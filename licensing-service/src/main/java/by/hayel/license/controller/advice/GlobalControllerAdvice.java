package by.hayel.license.controller.advice;

import by.hayel.license.model.error.ErrorMessage;
import by.hayel.license.model.error.ResponseWrapper;
import by.hayel.license.model.error.RestErrorList;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {
  @ExceptionHandler(value = {Exception.class})
  public @ResponseBody ResponseEntity<ResponseWrapper> handleException(
      HttpServletRequest request, ResponseWrapper responseWrapper) {
    return ResponseEntity.ok(responseWrapper);
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ResponseWrapper> handleIOException(
      HttpServletRequest request, RuntimeException runtimeException) {
    RestErrorList errorList =
        new RestErrorList(
            HttpStatus.NOT_ACCEPTABLE,
            new ErrorMessage(runtimeException.getMessage(), runtimeException.getMessage()));
    ResponseWrapper responseWrapper =
        new ResponseWrapper(null, Map.of("status", HttpStatus.NOT_ACCEPTABLE), errorList);
    return ResponseEntity.ok(responseWrapper);
  }
}
