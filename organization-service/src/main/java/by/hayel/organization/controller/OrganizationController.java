package by.hayel.organization.controller;

import by.hayel.organization.model.Organization;
import by.hayel.organization.service.OrganizationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("v1/organization")
public class OrganizationController {
  OrganizationService service;

  @GetMapping("/{organizationId}")
  public ResponseEntity<Organization> getOrganization(@PathVariable String organizationId) {
    return ResponseEntity.ok(service.findById(organizationId));
  }

  @PutMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateOrganization(@RequestBody Organization organization) {
    service.update(organization);
  }

  @PostMapping
  public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization) {
    return ResponseEntity.ok(service.create(organization));
  }

  @DeleteMapping("/{organizationId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteOrganization(@PathVariable String organizationId) {
    service.delete(organizationId);
  }
}
