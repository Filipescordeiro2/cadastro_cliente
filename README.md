# Microsserviço de Cadastro de Cliente

Este projeto é um microsserviço de cadastro de cliente desenvolvido em Java com o framework Spring Boot e JPA para persistência de dados.

## Estrutura do Projeto

```plaintext
src
├── controller
│   └── ClienteController.java
├── dto
│   ├── ClienteDTO.java
│   └── AtualizarCelularDTO.java
├── entity
│   └── ClienteEntity.java
├── repository
│   └── ClienteRepository.java
├── service
│   ├── ClienteService.java
│   └── imp
│       └── ClienteServiceImp.java
└── ClienteApplication.java
```

### Explicação das Pastas e Arquivos

- **controller**: Contém o `ClienteController`, responsável por expor os endpoints REST para operações relacionadas ao cliente.
- **dto**: Contém os Data Transfer Objects (DTOs) `ClienteDTO` e `AtualizarCelularDTO` usados para transferir dados entre as camadas do sistema.
- **entity**: Contém a entidade `ClienteEntity` que representa a tabela de cliente no banco de dados.
- **repository**: Contém o `ClienteRepository`, responsável pela comunicação com o banco de dados, utilizando JPA.
- **service**: Contém a interface `ClienteService` e sua implementação `ClienteServiceImp`, onde está a lógica de negócios.
- **ClienteApplication**: Classe principal para iniciar o microsserviço Spring Boot.

## Requisitos

- Java 17
- Spring Boot 3.x
- MySQL 8.x
- Maven 3.x

## Configuração do Banco de Dados

No arquivo `application.properties`, configure as propriedades do banco de dados MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/NomeDoBanco?useSSL=false&serverTimezone=UTC
spring.datasource.username=userName
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

## Endpoints

- **GET /clientes**: Retorna a lista de todos os clientes.
- **POST /clientes**: Cadastra um novo cliente.
- **PUT /clientes/{id}/celular**: Atualiza o número de celular de um cliente existente.
- **GET /clientes/{id}**: Retorna as informações de um cliente específico.
- **DELETE /clientes/{id}**: Remove um cliente do sistema.

## Tecnologias Utilizadas

- **Spring Boot**: Framework Java para criação de aplicações robustas.
- **JPA (Hibernate)**: Para mapeamento objeto-relacional (ORM) e manipulação do banco de dados.
- **HikariCP**: Pool de conexões para maior eficiência no gerenciamento de conexões com o banco de dados.
- **MySQL**: Banco de dados relacional utilizado para armazenar os dados.

