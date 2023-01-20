package by.hayel.license.model.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorMessage {
  String message;
  String code;
  String detail;

  public ErrorMessage(String message, String detail) {
    this.message = message;
    this.detail = detail;
  }
}
