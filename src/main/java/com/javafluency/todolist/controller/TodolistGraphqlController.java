package com.javafluency.todolist.controller;

import com.javafluency.todolist.dto.TodoResponseDto;
import com.javafluency.todolist.service.TodolistService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@AllArgsConstructor
public class TodolistGraphqlController {

  private final TodolistService todolistService;

  @QueryMapping
  public TodoResponseDto todoById(@Argument Long todoId) {
    log.info("Querying todo. todoId: {}", todoId);
    return todolistService.getTodo(todoId);
  }
}
