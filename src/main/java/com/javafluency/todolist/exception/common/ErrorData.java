package com.javafluency.todolist.exception.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public record ErrorData(
  @JsonProperty("error_reason") String errorReason,
  @JsonProperty("error_code") HttpStatus statusCode
) {
}
