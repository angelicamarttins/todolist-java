package com.javafluency.todolist.model.builder;

import com.javafluency.todolist.dto.TodoRequestDto;
import com.javafluency.todolist.dto.TodoResponseDto;
import com.javafluency.todolist.model.Todo;

public class TodoBuilder {
  public static Todo fromDto(TodoRequestDto todoRequestDto) {
    return Todo
        .builder()
        .title(todoRequestDto.title())
        .description(todoRequestDto.description())
        .build();
  }

  public static TodoResponseDto fromEntity(Todo todo) {
    return new TodoResponseDto(
        todo.getTodoId(),
        todo.getTitle(),
        todo.getDescription(),
        todo.getCreatedAt(),
        todo.getUpdatedAt(),
        todo.getDeletedAt()
    );
  }
}
