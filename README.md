Auth con AWS Cognito (Spring Boot)

Backend en Spring Boot con autenticación y autorización usando AWS Cognito y OAuth2 (Authorization Code).
Incluye endpoints públicos, protegidos y protegidos por rol admin.

Tecnologías
- Java 21
- Spring Boot 4.x
- Spring Security + OAuth2
- AWS Cognito

Requisitos
- Java 21
- Gradle
- Cuenta AWS con Cognito configurado

Configuración

Editar el archivo:
src/main/resources/application.yml

Variables principales:

    aws:
        cognito:
            region: us-east-2
                user_pool_id: us-east-2_XXXXXXXXX

El user_pool_id debe coincidir con el User Pool configurado en AWS Cognito.

Cómo ejecutar el proyecto
Opción 1: Desde IntelliJ
- Abrir el proyecto
- Ejecutar la clase AuthApplicationKt

Opción 2: Desde consola
    
    ./gradlew bootRun

La aplicación se levanta en:

    http://localhost:8081

Endpoints

- GET /api/public → acceso público
- GET /api/restricted → requiere token
- GET /api/restricted/admin → requiere token y rol admin

Autenticación (resumen)

1. Login mediante Hosted UI de Cognito
2. Obtener code en el redirect
3. Intercambiar code por tokens
4. Usar el access_token como Bearer Token en Postman