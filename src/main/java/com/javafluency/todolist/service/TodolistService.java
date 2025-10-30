package com.javafluency.todolist.service;

import static com.javafluency.todolist.model.builder.TodoBuilder.fromDto;
import static com.javafluency.todolist.model.builder.TodoBuilder.fromEntity;

import com.javafluency.todolist.dto.TodoRequestDto;
import com.javafluency.todolist.dto.TodoResponseDto;
import com.javafluency.todolist.model.Todo;
import com.javafluency.todolist.model.builder.TodoBuilder;
import com.javafluency.todolist.repository.TodolistRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodolistService {

  private final TodolistRepository todolistRepository;

  public TodoResponseDto createTodo(TodoRequestDto todoRequestDto) {
    Todo savedTodo = todolistRepository.save(fromDto(todoRequestDto));

    return fromEntity(savedTodo);
  }

  public List<TodoResponseDto> getAllTodos() {
    List<Todo> savedTodoEntities = todolistRepository.findAll();

    return savedTodoEntities.stream().map(TodoBuilder::fromEntity).toList();
  }

  public TodoResponseDto getTodo(Long todoId) {
    Todo savedTodo = todolistRepository.getOrThrowTodo(todoId);

    return fromEntity(savedTodo);
  }

  @Transactional
  public TodoResponseDto updateTodo(Long todoId, TodoRequestDto todoRequestDto) {
    Todo savedTodo = todolistRepository.getOrThrowTodo(todoId);

    if (todoRequestDto.title() != null) {
      savedTodo.setTitle(todoRequestDto.title());
    }

    if (todoRequestDto.description() != null) {
      savedTodo.setDescription(todoRequestDto.description());
    }

    savedTodo.setUpdatedAt(LocalDateTime.now());

    Todo updatedTodo = todolistRepository.save(savedTodo);

    return fromEntity(updatedTodo);
  }

  public void deleteTodo(Long todoId) {
    todolistRepository.getOrThrowTodo(todoId);

    todolistRepository.deleteById(todoId);
  }
}
