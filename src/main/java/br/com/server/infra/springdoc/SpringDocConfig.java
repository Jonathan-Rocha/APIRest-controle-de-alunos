package br.com.server.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
            .components(new Components()
            .addSecuritySchemes(
                    "bearer-key",
                    new SecurityScheme()
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")))
            .info(new Info()
                    .title("Registro de aulas API")
                    .description("""
                            Api criada como um projeto pessoal, para registro de aulas de música.\s
                            A Api contem:\s
                            - CRUD para formatos de aulas e alunos;\s
                            - Criação e alteração de instrumetos e usuarios;\s
                            - Autenticação de usuarios;""")
                    .contact(new Contact()
                            .name("Jonathan Rocha")
                            .email("johnrocha149@gmail.com")
                            .url("https://github.com/Jonathan-Rocha")));
  }
}
