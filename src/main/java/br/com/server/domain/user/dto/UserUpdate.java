package br.com.server.domain.user.dto;

public record UserUpdate(
        String name,
        String password
) {
}
