package br.com.server.domain.user.dto;

import br.com.server.domain.user.User;

public record UserSearch(
        Long id,
        String name
) {
  public UserSearch(User user) {
    this(
            user.getId(),
            user.getName()
    );
  }
}
