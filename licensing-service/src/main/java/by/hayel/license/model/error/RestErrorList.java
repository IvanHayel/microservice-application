package by.hayel.license.model.error;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestErrorList extends ArrayList<ErrorMessage> {
  HttpStatus status;

  public RestErrorList(HttpStatus status, ErrorMessage... errors) {
    this(status.value(), errors);
  }

  public RestErrorList(int status, ErrorMessage... errors) {
    this.status = HttpStatus.valueOf(status);
    addAll(asList(errors));
  }
}
