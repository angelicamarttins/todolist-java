package com.javafluency.todolist.repository;

import com.javafluency.todolist.model.Todo;
import java.util.NoSuchElementException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodolistRepository extends JpaRepository<Todo, Long> {

  default Todo getOrThrowTodo(Long todoId) {
    return this.findById(todoId).orElseThrow(() ->
                                               new NoSuchElementException("Todo not found")
    );
  }
}
