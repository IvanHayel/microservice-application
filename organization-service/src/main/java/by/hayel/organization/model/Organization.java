package by.hayel.organization.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "organizations")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Organization {
  @Id
  @Column(name = "organization_id", nullable = false)
  String id;

  @Column(name = "name", nullable = false)
  String name;

  @Column(name = "contact_name", nullable = false)
  String contactName;

  @Column(name = "contact_email", nullable = false)
  String contactEmail;

  @Column(name = "contact_phone", nullable = false)
  String contactPhone;
}
