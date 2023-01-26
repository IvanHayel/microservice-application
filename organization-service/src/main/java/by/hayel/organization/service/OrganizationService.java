package by.hayel.organization.service;

import by.hayel.organization.model.Organization;
import by.hayel.organization.repository.OrganizationRepository;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrganizationService {
  OrganizationRepository repository;

  public Organization findById(String organizationId) {
    return repository.findById(organizationId).orElse(null);
  }

  public Organization create(Organization organization) {
    organization.setId(UUID.randomUUID().toString());
    return repository.save(organization);
  }

  public void update(Organization organization) {
    repository.save(organization);
  }

  public void delete(String organizationId) {
    repository.deleteById(organizationId);
  }
}
