# Hospital Management System

A backend application developed using **Java, Spring Boot, and PostgreSQL** to manage hospital operations, including patients, doctors, appointments, and patient medical histories.

## 🚀 Features

- Patient Management – Add and retrieve patient details.
- Doctor Management – Manage doctor information.
- Illness Management – Maintain illness records.
- Appointment Management – Create and retrieve appointments.
- Patient History – Store symptoms, diagnosis, treatment, and follow-up details.
- RESTful APIs – Handle application requests using HTTP methods.
- DTO Pattern – Separate API request and response data from entity classes.

## 🛠️ Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- IntelliJ IDEA
- Postman

## 📁 Project Structure

```text
hospitalmanagement/
├── src/main/java/
│   └── com/prectice/hospitalmanagement/
│       ├── controllers/
│       ├── dto/
│       ├── entity/
│       ├── repository/
│       ├── service/
│       └── HospitalmanagementApplication.java
│
├── src/main/resources/
│   └── application.properties
│
└── pom.xml
```

## ⚙️ Installation and Setup

### 1. Clone the repository

```bash
git clone https://github.com/Brijesh1011/HospitalManagement.git
```

### 2. Open the project

Open the project in IntelliJ IDEA.

### 3. Create PostgreSQL database

```sql
CREATE DATABASE hospitaldb;
```

### 4. Configure database connection

Set your database password as an environment variable named `DB_PASSWORD`.

In `application.properties`:

```properties
spring.application.name=hospitalmanagement

spring.datasource.url=jdbc:postgresql://localhost:5432/hospitaldb
spring.datasource.username=postgres
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 5. Run the application

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

The application runs at:

```text
http://localhost:8080
```

## 🧪 API Testing

Use Postman to test the REST APIs.

<img width="1241" height="877" alt="Screenshot 2026-11-08 140327" src="https://github.com/user-attachments/assets/52e29ba0-234d-4ebb-b6f8-c47995969d38" />
<img width="1213" height="867" alt="Screenshot 2026-11-08 140501" src="https://github.com/user-attachments/assets/92262f47-7e68-4f7a-bce9-5bf53590bea5" />

<img width="1237" height="862" alt="Screenshot 2026-11-08 140552" src="https://github.com/user-attachments/assets/fd2c52af-7239-4e13-b993-4a4105540e12" />
<img width="1236" height="896" alt="Screenshot 2026-11-08 140527" src="https://github.com/user-attachments/assets/b9efd088-94a0-4cb8-94b7-af926c3ce2c6" />

<img width="1232" height="892" alt="Screenshot 2026-11-08 140619" src="https://github.com/user-attachments/assets/518fb517-a52c-45e5-ab4b-4eece9efb187" />


## 👨‍💻 Author

**Brijesh Parmar**

- GitHub: [Brijesh1011](https://github.com/Brijesh1011)

## 📌 Project Status

Currently under development. More features and API improvements will be added.
