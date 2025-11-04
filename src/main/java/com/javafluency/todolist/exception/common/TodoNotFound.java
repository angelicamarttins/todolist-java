package com.javafluency.todolist.exception.common;

import org.springframework.http.HttpStatus;

public class TodoNotFound extends GeneralHttpException {
  public TodoNotFound(Long todoId) {
    super(new ErrorData("Todo not found with id: " + todoId, HttpStatus.BAD_REQUEST));
  }
}
