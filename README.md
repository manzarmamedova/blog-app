# DevBlog

A full-stack blog application built with Spring Boot, designed as a personal learning project to explore backend development end-to-end — from authentication and database design to internationalization and containerized deployment.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![Docker](https://img.shields.io/badge/Docker-ready-blue)

## What it does

DevBlog lets users browse articles, read full posts, and leave comments. Authenticated admins can write, edit, and delete posts. It supports three languages (English, Turkish, Georgian) with runtime language switching, and exposes a REST API alongside the main web interface.

## Features

- **Authentication & Authorization** — Spring Security with BCrypt password hashing and role-based access control (admin vs. regular users)
- **CRUD for posts and comments** — full create/read/update/delete flow backed by PostgreSQL and Spring Data JPA
- **Internationalization** — EN / TR / KA support with runtime locale switching via a `lang` query parameter
- **Caching** — `@Cacheable` / `@CacheEvict` on frequently accessed post queries to reduce database load
- **Scheduled tasks** — background job logging database statistics at a fixed interval
- **Monitoring** — Spring Boot Actuator exposing health and metrics endpoints
- **REST API** — JSON endpoints for posts and comments, separate from the server-rendered views
- **Testing** — unit tests (Mockito), repository tests (`@DataJpaTest`), controller tests (`MockMvc`), and integration tests (`@SpringBootTest`)
- **Containerized** — Dockerfile and docker-compose setup for running the app and PostgreSQL together with a single command

## Tech stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 3.2.5 |
| Security | Spring Security |
| Persistence | Spring Data JPA / Hibernate |
| Database | PostgreSQL |
| Templating | FreeMarker |
| Testing | JUnit 5, Mockito |
| Containerization | Docker, Docker Compose |

## Running locally

You'll need Java 21 and a running PostgreSQL instance.

```bash
git clone https://github.com/manzarmamedova/blogapp_1.git
cd blogapp_1
mvn spring-boot:run
```

## Running with Docker

If you'd rather not set up PostgreSQL locally, Docker Compose handles everything:

```bash
docker compose up --build
```

This spins up the application alongside a PostgreSQL container, fully wired together.

## Project structure

```
src/main/java/com/example/blogapp_1/
├── controller/     # Web and REST controllers
├── service/        # Business logic, caching, scheduled tasks
├── repository/      # Spring Data JPA repositories
├── model/           # JPA entities
├── security/        # Spring Security configuration
├── config/          # i18n, logging, and other app config
└── dto/             # Data transfer objects
```

## Why I built this

This project started as part of a university course but grew into something I kept iterating on — adding features week by week (testing, security, i18n, caching, monitoring, deployment) to understand how each piece fits into a real-world Spring Boot application, not just in isolation.

## License

This project is for educational purposes.