package br.com.server.domain.user.dto;

import br.com.server.domain.user.User;

public record UserSearch(
        Long id,
        String name,
        String email
) {
  public UserSearch(User user) {
    this(
            user.getId(),
            user.getName(),
            user.getEmail()
    );
  }
}
