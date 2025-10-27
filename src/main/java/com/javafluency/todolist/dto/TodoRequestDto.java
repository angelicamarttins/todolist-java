package com.javafluency.todolist.dto;

import jakarta.validation.constraints.NotBlank;

public record TodoRequestDto(
    @NotBlank(message = "Title can't be null, blanked or only contain whitespace")
    String title,
    @NotBlank(message = "Description can't be null, blanked or only contain whitespace")
    String description
) {
}
