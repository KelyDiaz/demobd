# Microservicio de Spring Boot con Base de Datos

Este proyecto es un microservicio implementado en Spring Boot que interactúa con una base de datos. Proporciona una estructura básica para desarrollar un servicio ApiRest que realiza operaciones CRUD.

## Requisitos Previos

- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) (versión 17)
- [Maven](https://maven.apache.org/download.cgi)
- [Base de Datos](#configuración-de-la-base-de-datos) (puede ser H2, MySQL, PostgreSQL, etc.)

## Configuración del Proyecto

1. **Clonar el Repositorio:**
   ```bash
   git clone https://github.com/KelyDiaz/demobd.git
   cd demobd

## Configuración de la Base de Datos

Configura las propiedades de la base de datos en `src/main/resources/application.properties`. A continuación, se muestra un ejemplo para una base de datos PostgreSQL:

```properties

Configuración para PostgreSQL Database
spring.datasource.url=jdbc:postgresql://localhost:5432/prueba
spring.datasource.username=username_your_database
spring.datasource.password=password_your_database
spring.datasource.driverClassName=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.hbm2ddl.auto=none
```

Asegúrate de ajustar la configuración según la base de datos que estés utilizando.

Ejecución del Microservicio
ejecutar el microservicio utilizando el siguiente comando

```
./mvnw spring-boot:run
```
El microservicio estará disponible en http://localhost:8080.

## Endpoints de la API
1. Obtener todos los elementos
```
GET /demo-bd
```
2. Obtener un elemento por name en un path param
```
/demo-bd/{name}
```
3. Obtener un elemento por name en un query param
```
/demo-bd/query?name={name}
```
4. Crear un nuevo elemento
```
/demo-bd
```
Cuerpo de ejemplo:
```
{
    "name": "prueba"
}

```
### Tecnologías Utilizadas
- Spring Boot
- Base de datos (PostgreSQL)
- Maven para la gestión de dependencias y construcción
