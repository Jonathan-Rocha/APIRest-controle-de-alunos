package br.com.server.controller;

import br.com.server.domain.user.dto.UserCreate;
import br.com.server.domain.user.dto.UserData;
import br.com.server.domain.user.dto.UserUpdate;
import br.com.server.domain.user.service.UserService;
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
  private UserService userService;

  @PostMapping("/create")
  @Transactional
  public ResponseEntity<UserData> create(@RequestBody @Valid UserCreate data, UriComponentsBuilder uriBuilder) {
    var user = userService.create(data);
    var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
    return ResponseEntity.created(uri).body(new UserData(user));
  }

  @GetMapping("{id}")
  @SecurityRequirement(name = "bearer-key")
  public ResponseEntity<UserData> findById(@PathVariable Long id) {
    var user = userService.findById(id);
    return ResponseEntity.ok(new UserData(user));
  }

  @PutMapping("{id}")
  @Transactional
  @SecurityRequirement(name = "bearer-key")
  public ResponseEntity<HttpStatusCode> update(@PathVariable Long id, @RequestBody @Valid UserUpdate data) {
    userService.update(id, data);
    return ResponseEntity.ok().build();
  }
}
