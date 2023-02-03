package br.com.server.controller;

import br.com.server.domain.user.User;
import br.com.server.infra.services.TokenService;
import br.com.server.infra.services.dto.AuthenticationData;
import br.com.server.infra.services.dto.TokenJWTData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

  @Autowired
  private AuthenticationManager manager;

  @Autowired
  private TokenService tokenService;

  @PostMapping
  public ResponseEntity<TokenJWTData> login(@RequestBody @Valid AuthenticationData data) {
    var token = new UsernamePasswordAuthenticationToken(data.email(), data.password());
    var authentication = manager.authenticate(token);

    var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());

    return ResponseEntity.ok(new TokenJWTData(tokenJWT));
  }
}
