package com.javafluency.todolist.exception.common;

import org.springframework.http.HttpStatus;

public record ErrorData(String errorReason, HttpStatus statusCode) {
}
