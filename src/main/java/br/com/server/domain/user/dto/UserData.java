package br.com.server.domain.user.dto;

import br.com.server.domain.user.User;

public record UserData(
        Long id,
        String name

) {
  public UserData(User user) {
    this(
            user.getId(),
            user.getName()
    );
  }
}
