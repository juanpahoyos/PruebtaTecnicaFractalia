#Spring Boot DummyJSON Auth API

API REST en Java con Spring Boot 3 que permite autenticarse contra la API externa de [DummyJSON](https://dummyjson.com/), registrar los accesos en una base de datos PostgreSQL y devolver la información del usuario autenticado.

---

##Objetivo

- Autenticarse vía `https://dummyjson.com/auth/login`.
- Consultar datos del usuario autenticado vía `https://dummyjson.com/auth/me`.
- Registrar cada login exitoso en la base de datos (`login_log`).
- Utilizar Feign Client, JPA y principios SOLID.
- Incluir una prueba unitaria del flujo de login.

---

## Tecnologías

- Java 21
- Spring Boot 3.2
- Spring Data JPA
- Spring Cloud OpenFeign
- PostgreSQL
- JUnit 5 + Mockito
- Lombok

---

## Instalación y ejecución

1. **Clona el repositorio:**

```bash
git clone https://github.com/juanpahoyos/PruebtaTecnicaFractalia.git
cd auth-api```

2. **Configura PostgreSQL:**
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/authdb
    username: postgres
    password: postgres
	

3. **Construye y ejecuta el proyecto:**	
./mvnw clean install
./mvnw spring-boot:run

##Anotaciones:

a. **Puedes usar cualquier usuario del endpoint:**
GET https://dummyjson.com/users

con la siguiente estructura tipo JSON:
{
  "username": "emilys",
  "password": "emilyspass"
}

b. **Esta es una referencia de cómo se ejecuta el login por cURL:**
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{ "username": "emilys", "password": "emilyspass" }'
