package com.javafluency.todolist.exception.common;

import java.util.Objects;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GeneralHttpException extends RuntimeException {

  private final ErrorData errorData;

  private final HttpStatus httpStatus;

  public GeneralHttpException(ErrorData errorData, HttpStatus httpStatus, Throwable cause) {
    super(errorData.errorReason(), cause);

    this.errorData = errorData;
    this.httpStatus = Objects.isNull(httpStatus) ? HttpStatus.INTERNAL_SERVER_ERROR : httpStatus;
  }

  public GeneralHttpException(ErrorData errorData, Throwable cause) {
    this(errorData, null, cause);
  }

  public GeneralHttpException(ErrorData errorData) {
    this(errorData, null, null);
  }
}
