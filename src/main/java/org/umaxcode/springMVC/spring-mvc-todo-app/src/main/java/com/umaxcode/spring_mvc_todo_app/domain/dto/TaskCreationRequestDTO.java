package com.umaxcode.spring_mvc_todo_app.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record TaskCreationRequestDTO(

        @NotBlank(message = "Title cannot be empty")
        @NotNull(message = "Title cannot be null")
        String title,

        @NotBlank(message = "Description cannot be empty")
        @NotNull(message = "Description cannot be null")
        String description
) {
}
