## Sobre o projeto
Este projeto pessoal foi pensado para ajudar no controle das minhas aulas de música. Para isso, desenvolvi uma API Rest para cadastrar os formatos de aulas e seus valores, cadastrar meu alunos e também cadastrar os instrumentos e os relacionando.

---

## Funcionalidades

- [x] CRUD de formatos de aulas;
- [x] CRUD de alunos;
- [x] Cadastro e alterações de instrumetos e usuarios,
- [x] Login de usuarios com autenticação JWT

## Documentação

O projeto está configurado para rodar na porta 8081 mas pode ser alterado seguindo os passos:

* Acessar a pasta resource
* Abrir o aquivo application.properties
* Alterar a seguinte configuração:

````
server.port=custom-port
````

O Projeto pode ser rodado utilizando alguma IDE através da classe "ServerApplication", ou pelo comando:

````
mvn spring-boot:run
````
A documentação das funcionalidades da aplicação pode ser acessada neste link:

```
https://server:port/swagger-ui/index.html
```
Na barra 'Explore' procure por:

````
/v3/api-docs
````
---

## Tecnologias

As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:

- **[Java 17](https://www.oracle.com/java)**
- **[Spring Boot 3](https://spring.io/projects/spring-boot)**
- **[Maven](https://maven.apache.org)**
- **[MariaDB](https://www.mariadb.org)**
- **[Docker](https://www.docker.com)**
- **[Hibernate](https://hibernate.org)**
- **[Flyway](https://flywaydb.org)**
- **[Lombok](https://projectlombok.org)**

---