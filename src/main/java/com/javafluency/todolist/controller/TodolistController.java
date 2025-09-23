package com.javafluency.todolist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todo")
public class TodolistController {

  @PostMapping
  public ResponseEntity<String> createTodo(String todo) {
    return ResponseEntity.ok(todo);
  }

}
