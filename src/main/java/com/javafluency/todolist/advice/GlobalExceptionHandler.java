package com.javafluency.todolist.advice;

import com.javafluency.todolist.exception.common.ErrorData;
import com.javafluency.todolist.exception.common.GeneralHttpException;
import java.util.List;
import java.util.Map;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorData> handleException(Exception exception) {
    ErrorData errorData = new ErrorData("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);

    return new ResponseEntity<>(errorData, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(GeneralHttpException.class)
  public ResponseEntity<ErrorData> handleGeneralHttpException(GeneralHttpException generalHttpException) {
    return new ResponseEntity<>(generalHttpException.getErrorData(), generalHttpException.getHttpStatus());
  }


  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException exception) {

    List<String> missingValues = exception
      .getBindingResult()
      .getFieldErrors()
      .stream()
      .map(error -> error.getField() + ": " +
        error.getDefaultMessage())
      .toList();

    Map<String, Object> errorData = Map.of(
      "errorReason", missingValues,
      "errorCode", HttpStatus.BAD_REQUEST
    );

    return ResponseEntity.badRequest().body(errorData);
  }

}
