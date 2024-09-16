# 📊 Finanzas API - Spring Boot

![Java](https://img.shields.io/badge/Java-17+-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.3-brightgreen.svg)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)
![Maven](https://img.shields.io/badge/Maven-3.6.3-orange.svg)

Una API RESTful para gestionar transacciones financieras, construida con **Spring Boot**, **MySQL** y protegida con **Spring Security**. La API incluye características como validación de datos, paginación y filtrado.

## 🚀 Características principales

- CRUD para transacciones financieras (ingresos y gastos).
- Validación de datos de entrada con anotaciones.
- Paginación y filtrado por tipo de transacción (ingreso/gasto).
- Seguridad con Spring Security.
- Gestión de credenciales con variables de entorno.

## 🛠️ Requisitos previos

Antes de ejecutar este proyecto, asegúrate de tener instalados los siguientes programas:

- [Java 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven 3.6.3+](https://maven.apache.org/install.html)
- [MySQL 8.0+](https://dev.mysql.com/downloads/mysql/)
- [Git](https://git-scm.com/)

## 🔧 Configuración del proyecto

### Como ejecutar la aplicación:

Configuración para iniciar:



Clonar el repositorio
```bash
git clone https://github.com/tu-usuario/tu-repositorio.git
cd tu-repositorio

## Crear una base de datos y configurarla:
CREATE DATABASE finance_api;

## Uso de variables de entorno
DB_URL=jdbc:mysql://localhost:3306/finance_api
DB_USERNAME=tu_usuario
DB_PASSWORD=tu_contraseña

##Modificar application.properties
spring.datasource.url=${DB_URL:jdbc:mysql://localhost:3306/finance_api}
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:password}

##Ejecutar la aplicación
mvn spring-boot:run

La aplicación estará disponible en: http://localhost:8080.

🔐 Seguridad
Esta API está protegida con Spring Security. Usa autenticación básica con las siguientes credenciales por defecto:

Usuario: admin
Contraseña: password

🛠️ Endpoints principales
Método	Endpoint	Descripción
GET	/api/transactions	Listar todas las transacciones con paginación.
GET	/api/transactions/filter	Filtrar transacciones por tipo (ingreso/gasto).
POST	/api/transactions	Crear una nueva transacción.
DELETE	/api/transactions/{id}	Eliminar una transacción por ID.


