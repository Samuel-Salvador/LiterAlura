# LiterAlura - API

<img src="https://img.shields.io/badge/Java-17-blue?logo=java" alt="Java"></img> <img src="https://img.shields.io/badge/Spring%20Boot-3.2-brightgreen?logo=springboot" alt="Spring Boot"></img> <img src="https://img.shields.io/badge/PostgreSQL-15-blue?logo=postgresql" alt="PostgreSQL"></img> <img src="https://img.shields.io/badge/Maven-Build-red?logo=apachemaven" alt="Maven"></img>

API REST para gerenciamento de metadados de livros, integrando com a API Gutendex (Projeto Gutenberg). Permite operações de cadastro, listagem e consulta de livros, utilizando as melhores práticas do ecossistema Spring Boot, persistência com JPA (Hibernate) e banco de dados PostgreSQL.

<hr></hr>

## 🚀 Tecnologias Utilizadas

 - Java
 - Spring Boot
 - Spring Data JPA
 - Maven
 - PostgreSQL

## ✨ Funcionalidades
 - Cadastro, listagem e consulta de livros
 - Integração com API externa (Gutendex)

## 🛠️ Como rodar o projeto
### Pré-requisitos
 - Java 17
 - Maven 3.8 +
 - PostgreSQL 15 +
 - Git

Certifique-se de que todas as ferramentas estejam instaladas e configuradas no seu sistema antes de prosseguir.


1. Clone o repositório e acesse a pasta:

```
git clone https://github.com/samuel-salvador/LiterAlura
cd LiterAlura
```

2. Configure o banco de dados:

    1. Crie um banco de dados para o projeto (exemplo: literalura_db):

        ```
        psql -U SEU_USUARIO_POSTGRES
        CREATE DATABASE literalura_db;
        \q
       ```
    2. Altere as configurações de acesso ao banco no arquivo src/main/resources/application.properties:

        ```
        spring.datasource.url = jdbc:postgresql://localhost:5432/literalura_db
        spring.datasource.username = SEU_USUARIO_POSTGRES
        spring.datasource.password = SUA_SENHA_POSTGRES
        server.port = 8080
       ```
3. Compile o projeto:

```
mvn clean install
```

4. Execute a aplicação:

```
mvn spring-boot:run
```