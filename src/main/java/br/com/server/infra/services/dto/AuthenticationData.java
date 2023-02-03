package br.com.server.infra.services.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationData(
        @NotBlank @Email
        String email,

        @NotBlank
        String password
) {
}
