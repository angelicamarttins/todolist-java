package com.javafluency.todolist.controller;

import com.javafluency.todolist.dto.TodoRequestDto;
import com.javafluency.todolist.dto.TodoResponseDto;
import com.javafluency.todolist.service.TodolistService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("todo")
@RequiredArgsConstructor
public class TodolistController {

  private final TodolistService todolistService;

  @PostMapping
  public ResponseEntity<TodoResponseDto> createTodo(@RequestBody TodoRequestDto todoRequestDto) {
    log.info("Creating todo");

    return ResponseEntity.ok(todolistService.createTodo(todoRequestDto));
  }

  @GetMapping
  public ResponseEntity<List<TodoResponseDto>> getAllTodos() {
    log.info("Getting all todos");
    return ResponseEntity.ok(todolistService.getAllTodos());
  }

  @GetMapping("/{todoId}")
  public ResponseEntity<TodoResponseDto> getTodo(@PathVariable Long todoId) {
    log.info("Getting todo. todoId: {}", todoId);

    return ResponseEntity.ok(todolistService.getTodo(todoId));
  }

  @PutMapping("/{todoId}")
  public ResponseEntity<TodoResponseDto> updateTodo(
    @PathVariable Long todoId,
    @RequestBody TodoRequestDto todoRequestDto
  ) {
    log.info("Updating todo. todoId: {}", todoId);

    return ResponseEntity.ok(todolistService.updateTodo(todoId, todoRequestDto));
  }

  @DeleteMapping("/{todoId}")
  public ResponseEntity<TodoResponseDto> deleteTodo(@PathVariable Long todoId) {
    log.info("Deleting todo. todoId: {}", todoId);

    todolistService.deleteTodo(todoId);

    return ResponseEntity.noContent().build();
  }
}
