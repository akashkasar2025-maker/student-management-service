# Student Management and Fee Collection Microservices

## Project Overview

This project consists of two microservices built with Spring Boot 3.3.0 following REST API best practices:

### 1. Student Management Service (Port 8080)
- Create, read, update, delete student records
- Search students by ID or Student ID
- Manages student information with fields: Name, ID, Grade, Mobile, School

### 2. Fee Collection Service (Port 8081)
- Collect fees from students
- Generate unique receipts
- View receipts by number, student ID, or academic year
- Automatic receipt number generation with timestamp

## Technology Stack

- **Framework**: Spring Boot 3.3.0
- **Java Version**: 17
- **Database**: H2 (In-Memory)
- **Data Access**: Spring Data JPA
- **API Documentation**: SpringDoc OpenAPI 3.0 (Swagger UI)
- **Build Tool**: Maven
- **Authentication**: None (Open APIs)

## Repository Links

1. **Student Management Service**: https://github.com/akashkasar6666-collab/student-management-service
2. **Fee Collection Service**: https://github.com/akashkasar6666-collab/fee-collection-service

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.6.0+
- Git

### Setup Instructions

#### Student Management Service
```bash
git clone https://github.com/akashkasar6666-collab/student-management-service.git
cd student-management-service
mvn clean install
mvn spring-boot:run
```

Service runs on: `http://localhost:8080`

#### Fee Collection Service
```bash
git clone https://github.com/akashkasar6666-collab/fee-collection-service.git
cd fee-collection-service
mvn clean install
mvn spring-boot:run
```

Service runs on: `http://localhost:8081`

## API Documentation

### Swagger UI URLs

1. **Student Management Service**:
   - Interactive Docs: `http://localhost:8080/swagger-ui.html`
   - OpenAPI JSON: `http://localhost:8080/v3/api-docs`

2. **Fee Collection Service**:
   - Interactive Docs: `http://localhost:8081/swagger-ui.html`
   - OpenAPI JSON: `http://localhost:8081/v3/api-docs`

### H2 Database Console

1. **Student Management DB**:
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:studentdb`

2. **Fee Collection DB**:
   - URL: `http://localhost:8081/h2-console`
   - JDBC URL: `jdbc:h2:mem:feedb`

## Key Endpoints

### Student Management Service

```
POST   /api/v1/students              - Create student
GET    /api/v1/students/{id}         - Get student by ID
GET    /api/v1/students/search/{studentId} - Get by Student ID
GET    /api/v1/students              - Get all students
PUT    /api/v1/students/{id}         - Update student
DELETE /api/v1/students/{id}         - Delete student
GET    /api/v1/students/health       - Health check
```

### Fee Collection Service

```
POST   /api/v1/fee-collection/collect                    - Collect fee
GET    /api/v1/fee-collection/receipt/{receiptNumber}    - Get receipt
GET    /api/v1/fee-collection/receipts/student/{studentId} - Get receipts by student
GET    /api/v1/fee-collection/receipts/year/{academicYear} - Get receipts by year
GET    /api/v1/fee-collection/receipts                   - Get all receipts
GET    /api/v1/fee-collection/health                     - Health check
```

## Testing

### Using Postman
1. Import `postman-collection.json` from each service directory
2. Ensure both services are running
3. Execute requests from the collection

### Sample Request - Create Student
```bash
curl -X POST http://localhost:8080/api/v1/students \
  -H "Content-Type: application/json" \
  -d '{
    "student_id": "STU001",
    "student_name": "John Doe",
    "grade": "10-A",
    "mobile_number": "9876543210",
    "school_name": "St. Xaviers School"
  }'
```

### Sample Request - Collect Fee
```bash
curl -X POST http://localhost:8081/api/v1/fee-collection/collect \
  -H "Content-Type: application/json" \
  -d '{
    "student_id": "STU001",
    "student_name": "John Doe",
    "school_name": "St. Xaviers School",
    "fee_amount": 5000.00,
    "payment_method": "CASH",
    "academic_year": "2024-2025",
    "fee_type": "TUITION",
    "remarks": "Fee for first semester"
  }'
```

## API Design Approach

**Design Approach Used**: Code-First with API Documentation

- Written clean, well-structured Java code
- Swagger annotations for automatic OpenAPI documentation
- RESTful principles followed throughout
- Consistent request/response structure with ApiResponse wrapper
- JSON property mapping for clean snake_case API contracts

## Database Schema

### Student Management Service
```sql
CREATE TABLE students (
  id BIGINT PRIMARY KEY,
  student_id VARCHAR(255) NOT NULL UNIQUE,
  student_name VARCHAR(255) NOT NULL,
  grade VARCHAR(50) NOT NULL,
  mobile_number VARCHAR(20) NOT NULL,
  school_name VARCHAR(255) NOT NULL,
  created_at BIGINT,
  updated_at BIGINT
);
```

### Fee Collection Service
```sql
CREATE TABLE receipts (
  id BIGINT PRIMARY KEY,
  receipt_number VARCHAR(255) NOT NULL UNIQUE,
  student_id VARCHAR(255) NOT NULL,
  student_name VARCHAR(255) NOT NULL,
  grade VARCHAR(50) NOT NULL,
  mobile_number VARCHAR(20) NOT NULL,
  school_name VARCHAR(255) NOT NULL,
  fee_amount DECIMAL(10,2) NOT NULL,
  payment_method VARCHAR(50) NOT NULL,
  academic_year VARCHAR(50) NOT NULL,
  fee_type VARCHAR(50) NOT NULL,
  status VARCHAR(50) NOT NULL,
  remarks VARCHAR(500),
  payment_date BIGINT,
  issued_date BIGINT,
  created_at BIGINT
);
```

## Response Format

All APIs follow a consistent response format:

```json
{
  "status": "success",
  "message": "Operation successful",
  "data": { /* actual data */ },
  "timestamp": 1677123456789
}
```

## Error Handling

- Invalid requests return 400 Bad Request
- Resource not found returns 404 Not Found
- Server errors return 500 Internal Server Error
- All errors include status, message, and timestamp

## Features Implemented

✅ RESTful APIs with latest Spring Boot 3.3.0
✅ Spring Data JPA with H2 in-memory database
✅ OpenAPI 3.0 / Swagger UI documentation
✅ Postman collections for testing
✅ Code-First design approach with auto-generated Swagger specs
✅ Comprehensive README files with setup instructions
✅ Student management (CRUD operations)
✅ Fee collection and receipt generation
✅ Unique receipt number generation
✅ Multiple query capabilities (by ID, by student, by year)
✅ No authentication required (as per requirements)

## Project Files

Each service includes:
- `pom.xml` - Maven dependencies and build configuration
- `src/main/java/` - Complete application source code
- `src/main/resources/application.yml` - Spring configuration
- `postman-collection.json` - Postman test collection
- `README.md` - Setup and API documentation

## Next Steps (Optional Enhancements)

1. Add service-to-service communication (Student Service to Fee Service)
2. Implement Docker containerization
3. Add Docker Compose for easy deployment
4. Implement caching with Redis
5. Add batch processing for fee collection
6. Implement advanced search/filtering
7. Add audit logging
8. Implement input validation with Bean Validation
9. Add pagination for list endpoints
10. Implement API versioning strategy

## License

MIT

## Support

For issues or questions, please create an issue in the respective GitHub repository.