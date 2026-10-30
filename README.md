# Sistema de Gimnasio

Sistema de gestión de gimnasio basado en microservicios: **Socio**, **Plan** y **Membresía**. Cada servicio expone una API REST y utiliza su propia base de datos MySQL.

## Requisitos previos

- Java 17 o superior
- MySQL en ejecución en `localhost:3306`
- Maven (opcional si se usa el Maven Wrapper incluido en cada servicio)

## Configuración de la base de datos

Los perfiles `dev` están activos por defecto y se conectan a las bases de datos `bd_socio_dev`, `bd_plan_dev` y `bd_membresia_dev`, respectivamente. Configura MySQL con el usuario `root` sin contraseña, o actualiza las credenciales en los archivos `application-dev.yml` de cada servicio.

Conéctate a MySQL y ejecuta:

```sql
CREATE DATABASE bd_socio_dev;
CREATE DATABASE bd_plan_dev;
CREATE DATABASE bd_membresia_dev;

-- Si root ya existe, asígnale una contraseña vacía para conexiones locales:
ALTER USER 'root'@'localhost' IDENTIFIED BY '';
```

Si el usuario `root` aún no existe, créalo con:

```sql
CREATE USER 'root'@'localhost' IDENTIFIED BY '';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;
```

Hibernate crea o actualiza las tablas al iniciar cada servicio (`ddl-auto: update`).

## Ejecución

Abre una terminal por servicio y ejecuta los comandos desde la carpeta raíz del proyecto. En Windows PowerShell:

```powershell
cd socio-service
.\mvnw.cmd spring-boot:run
```

```powershell
cd plan-service
.\mvnw.cmd spring-boot:run
```

```powershell
cd membresia-service
.\mvnw.cmd spring-boot:run
```

En Linux o macOS, usa `./mvnw spring-boot:run` en lugar de `.\mvnw.cmd spring-boot:run`.

## Puertos

| Microservicio | Puerto |
|---|---:|
| `socio-service` | 8081 |
| `plan-service` | 8082 |
| `membresia-service` | 8083 |

## Endpoints de la API

### Socio (puerto 8081)

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/api/socios` | Listar socios |
| POST | `/api/socios` | Crear socio |
| GET | `/api/socios/{id}` | Buscar socio por ID |
| PUT | `/api/socios/{id}` | Actualizar socio |
| DELETE | `/api/socios/{id}` | Eliminar socio |

### Plan (puerto 8082)

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/api/planes` | Listar planes |
| POST | `/api/planes` | Crear plan |
| GET | `/api/planes/{id}` | Buscar plan por ID |
| PUT | `/api/planes/{id}` | Actualizar plan |
| DELETE | `/api/planes/{id}` | Eliminar plan |

### Membresía (puerto 8083)

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/api/membresias` | Listar membresías |
| POST | `/api/membresias` | Crear membresía |
| GET | `/api/membresias/{id}` | Buscar membresía por ID |
| PUT | `/api/membresias/{id}` | Actualizar membresía |
| DELETE | `/api/membresias/{id}` | Eliminar membresía |
| GET | `/api/membresias/socio/{idSocio}` | Buscar membresías por ID de socio |
