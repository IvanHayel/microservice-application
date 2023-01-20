package by.hayel.license.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "licenses")
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class License extends RepresentationModel<License> {
  @Id
  @Column(name = "license_id", nullable = false)
  String licenseId;

  String description;

  @Column(name = "organization_id", nullable = false)
  String organizationId;

  @Column(name = "product_name", nullable = false)
  String productName;

  @Column(name = "license_type", nullable = false)
  String licenseType;

  String comment;

  public License withComment(String comment) {
    this.comment = comment;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    License license = (License) o;
    return licenseId != null && Objects.equals(licenseId, license.licenseId);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
