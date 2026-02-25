# Student Management Service

RESTful API for managing student information with Spring Boot, Spring Data JPA, and H2 in-memory database.

## Features

- Create, retrieve, update, and delete student records
- Search students by ID or Student ID
- Spring Data JPA for data access
- H2 in-memory database
- Swagger UI for API documentation
- No authentication required

## Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher
- Git

## Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/akashkasar6666-collab/student-management-service.git
cd student-management-service
```

### 2. Build the Project
```bash
mvn clean install
```

### 3. Run the Application
```bash
mvn spring-boot:run
```

The service will start on `http://localhost:8080`

## API Documentation

### Swagger UI
Access the interactive API documentation at:
```
http://localhost:8080/swagger-ui.html
```

### API Endpoints

#### 1. Create a Student
- **URL**: `POST /api/v1/students`
- **Request Body**:
```json
{
  "student_id": "STU001",
  "student_name": "John Doe",
  "grade": "10-A",
  "mobile_number": "9876543210",
  "school_name": "St. Xavier's School"
}
```
- **Response**: 201 Created

#### 2. Get Student by ID
- **URL**: `GET /api/v1/students/{id}`
- **Response**: 200 OK

#### 3. Get Student by Student ID
- **URL**: `GET /api/v1/students/search/{studentId}`
- **Response**: 200 OK

#### 4. Get All Students
- **URL**: `GET /api/v1/students`
- **Response**: 200 OK

#### 5. Update Student
- **URL**: `PUT /api/v1/students/{id}`
- **Request Body**: Same as create
- **Response**: 200 OK

#### 6. Delete Student
- **URL**: `DELETE /api/v1/students/{id}`
- **Response**: 200 OK

#### 7. Health Check
- **URL**: `GET /api/v1/students/health`
- **Response**: 200 OK

## Database Access

H2 Console is available at:
```
http://localhost:8080/h2-console
```

**Credentials**:
- JDBC URL: `jdbc:h2:mem:studentdb`
- Username: `sa`
- Password: (leave empty)

## Student Fields

| Field | Type | Required | Description |
|-------|------|----------|-------------|
| student_id | String | Yes | Unique student identifier |
| student_name | String | Yes | Full name of the student |
| grade | String | Yes | Grade/Class of the student |
| mobile_number | String | Yes | Contact phone number |
| school_name | String | Yes | Name of the school |

## Project Structure

```
student-management-service/
├── src/
│   ├── main/
│   │   ├── java/com/studentmgmt/
│   │   │   ├── StudentManagementApplication.java
│   │   │   ├── controller/
│   │   │   │   └── StudentController.java
│   │   │   ├── service/
│   │   │   │   └── StudentService.java
│   │   │   ├── repository/
│   │   │   │   └── StudentRepository.java
│   │   │   ├── entity/
│   │   │   │   └── Student.java
│   │   │   └── dto/
│   │   │       ├── StudentDTO.java
│   │   │       └── ApiResponse.java
│   │   └── resources/
│   │       └── application.yml
│   └── test/
├── pom.xml
└── README.md
```

## Technology Stack

- **Framework**: Spring Boot 3.3.0
- **Java Version**: 17
- **Database**: H2 (In-Memory)
- **ORM**: Spring Data JPA
- **API Documentation**: Swagger/OpenAPI 3.0
- **Build Tool**: Maven

## Testing with Postman

A Postman collection is included in `postman-collection.json`. Import it into Postman to test all endpoints.

## Swagger Specification

The OpenAPI/Swagger specification is generated automatically and available at:
```
http://localhost:8080/v3/api-docs
```

Download the JSON spec for integration with other tools.

## Notes

- All APIs are open without authentication
- H2 database is in-memory and will reset on application restart
- The database schema is automatically created on startup
- Timestamps are automatically managed (createdAt, updatedAt)

## License

MIT