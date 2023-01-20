package by.hayel.license.service;

import by.hayel.license.config.ConfigurationService;
import by.hayel.license.model.License;
import by.hayel.license.repository.LicenseRepository;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LicenseService {
  MessageSource messages;
  LicenseRepository repository;
  ConfigurationService configurationService;

  public License getLicense(String licenseId, String organizationId) {
    var license = repository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
    if (license == null) {
      throw new IllegalArgumentException(
          String.format(
              messages.getMessage("license.search.error.message", null, null),
              licenseId,
              organizationId));
    }
    return license.withComment(configurationService.getProperty());
  }

  public License createLicense(License license) {
    license.setLicenseId(UUID.randomUUID().toString());
    repository.save(license);
    return license.withComment(configurationService.getProperty());
  }

  public License updateLicense(License license) {
    repository.save(license);
    return license.withComment(configurationService.getProperty());
  }

  public String deleteLicense(String licenseId) {
    String responseMessage = null;
    License license = new License();
    license.setLicenseId(licenseId);
    repository.delete(license);
    responseMessage =
        String.format(messages.getMessage("license.delete.message", null, null), licenseId);
    return responseMessage;
  }
}
