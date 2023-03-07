package br.com.server.controller;

import br.com.server.domain.user.User;
import br.com.server.domain.user.UserRepository;
import br.com.server.domain.user.dto.UserCreate;
import br.com.server.domain.user.dto.UserData;
import br.com.server.domain.user.dto.UserUpdate;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepository repository;

  @PostMapping("/create")
  @Transactional
  public ResponseEntity<UserData> create(@RequestBody @Valid UserCreate data, UriComponentsBuilder uriBuilder) {
    var user = new User(data);
    repository.save(user);

    var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();

    return ResponseEntity.created(uri).body(new UserData(user));
  }

  @GetMapping("{id}")
  @SecurityRequirement(name = "bearer-key")
  public ResponseEntity<UserData> findById(@PathVariable Long id) {
    var user = repository.getReferenceById(id);

    return ResponseEntity.ok(new UserData(user));
  }

  @PutMapping("{id}")
  @Transactional
  @SecurityRequirement(name = "bearer-key")
  public ResponseEntity<HttpStatusCode> update(@PathVariable Long id, @RequestBody @Valid UserUpdate data) {
    var user = repository.getReferenceById(id);
    user.update(data);

    return ResponseEntity.ok().build();
  }
}
