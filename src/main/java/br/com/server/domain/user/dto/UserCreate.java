package br.com.server.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserCreate(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password

) {
}
