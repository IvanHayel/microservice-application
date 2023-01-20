package by.hayel.license.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Organization extends RepresentationModel<Organization> {
  String id;
  String name;
  String contactName;
  String contactEmail;
  String contactPhone;
}
