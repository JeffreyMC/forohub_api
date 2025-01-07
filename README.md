# Foro Hub API

## Descripción

El proyecto **Foro Hub** tiene como objetivo replicar el proceso de gestión de tópicos en un foro a nivel de backend. Para ello, he creado una API REST utilizando **Spring Framework**. Esta API permitirá gestionar los tópicos de un foro, ofreciendo las siguientes funcionalidades:

- **Crear un nuevo tópico**
- **Mostrar todos los tópicos creados**
- **Mostrar un tópico específico**
- **Actualizar un tópico**
- **Eliminar un tópico**

Estas operaciones corresponden al patrón CRUD (Crear, Leer, Actualizar, Eliminar), que se utiliza comúnmente en el desarrollo de aplicaciones.

## Funcionalidades

Al final de este desarrollo, la API tendrá las siguientes características:

1. **Implementación de Rutas RESTful:** Las rutas de la API seguirán las mejores prácticas del modelo REST, permitiendo que los recursos (tópicos) sean gestionados de forma adecuada y accesible.

2. **Validaciones de Negocio:** Se implementarán validaciones que seguirán las reglas de negocio definidas, asegurando que los datos sean consistentes y correctos.

3. **Persistencia de Datos:** Se utilizará una base de datos para almacenar la información, garantizando la persistencia de los tópicos creados y gestionados a través de la API.

4. **Autenticación y Autorización:** Se incluirá un servicio de autenticación y autorización para restringir el acceso a los recursos de la API, permitiendo solo a usuarios autorizados interactuar con los tópicos.

## Endpoints

La API implementará las siguientes rutas para manejar los tópicos:

- **POST /topics:** Crear un nuevo tópico.
- **GET /topics:** Obtener todos los tópicos creados.
- **GET /topics/{id}:** Obtener un tópico específico por su ID.
- **PUT /topics/{id}:** Actualizar un tópico existente por su ID.
- **DELETE /topics/{id}:** Eliminar un tópico por su ID.

## Tecnologías

- **Spring Framework:** Utilizado para crear la API REST.
- **Base de datos PostgreSQL:** Para la persistencia de los datos.
- **JWT (JSON Web Tokens):** Para la autenticación y autorización de usuarios.

## Requisitos

- Java 17 o superior
- Maven para la gestión de dependencias
- Base de datos relacional PostgreSQL
- Herramienta para hacer peticiones HTTP (Postman, Insomnia, etc. Yo utilicé Bruno (Acá hay un directorio con algunos ![ejemplos](https://github.com/JeffreyMC/forohub_api/tree/main/forohub) de cómo realizar las peticiones))


