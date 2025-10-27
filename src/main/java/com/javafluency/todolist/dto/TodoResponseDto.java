package com.javafluency.todolist.dto;

import java.time.LocalDateTime;

public record TodoResponseDto(
    Long todoId,
    String title,
    String description,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    LocalDateTime deletedAt
) {
}
