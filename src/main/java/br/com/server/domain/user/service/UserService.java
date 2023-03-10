package br.com.server.domain.user.service;

import br.com.server.domain.user.User;
import br.com.server.domain.user.UserRepository;
import br.com.server.domain.user.dto.UserCreate;
import br.com.server.domain.user.dto.UserUpdate;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public User create(UserCreate data) {
    return userRepository.save(new User(data));
  }

  public User findById(Long id) {
    return userRepository.getReferenceById(id);
  }

  public void update(Long id, UserUpdate data) {
    var user = userRepository.getReferenceById(id);
    if (data.name() != null) {
      user.setName(data.name());
    }
    if (data.password() != null) {
      user.setPassword(BCrypt.hashpw(data.password(), BCrypt.gensalt(12)));
    }
  }
}
