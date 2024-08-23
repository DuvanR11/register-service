# Backend Lintick Spring Boot

Esta es un servicio rest para la gestion de reservas de habitaciones de un hotel.
Para visualizar su interacción desde una interfaz web debes bajar y correr el repositorio: [`Front Linktic`](https://github.com/DuvanR11/register-front).  

## Características

- Autenticación de usuarios
- Gestión de usuarios: listar, crear, actualizar, obtener por id, eliminar.
- Gestión de servicios: listar, crear, actualizar, obtener por id, eliminar.
- Gestión de reservas: listar, crear, actualizar, obtener por id, eliminar.
- Conexión a API mediante REST.
- Seguridad mejorada utilizando variables de entorno para datos sensibles.

## Requisitos

- JDK +17
- XAMPP o preferencia
- Crear tabla reservations

## Instalación

Sigue estos pasos para clonar y configurar el proyecto localmente:

1. Clona el repositorio:

   ```bash
   git clone https://github.com/DuvanR11/register-service
   cd register-service

2. Instala las dependencias del proyecto:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```
    
3. Accede a la apliación desde:

    ```plaintext
    http://localhost:8080
    ```

4. Documentación de endpoints:

    ```bash
    http://localhost:8080/custom/swagger-ui/index.html#/
    ```

## Contribución

Si deseas contribuir a este proyecto, por favor abre un issue o envía un pull request con tus cambios.
