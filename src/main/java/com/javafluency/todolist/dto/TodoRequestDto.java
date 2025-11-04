package com.javafluency.todolist.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record TodoRequestDto(
  @NotBlank(message = "Title can't be null, blanked or only contain whitespace") String title,

  @Nullable
  @Pattern(regexp = ".*\\S.*", message = "Description cannot be only whitespace")
  String description
) {
}
