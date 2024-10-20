
# **Simple pos system**

## **Project Overview**
This project is a fully functional **API** built using **Spring Web MVC** and **Spring Data MongoDB** for database management with **MongoDB Atlas**. The API follows a well-structured layered architecture for scalability and maintainability.

The project includes:
- **Spring Web MVC** for building the web interface.
- **Spring Data MongoDB** for seamless interaction with MongoDB.
- **AJAX (or Fetch API)** for client-side requests and responses.
- **Logging** to track application events at appropriate levels.
- Complete **API documentation** linked below for reference.
- A suitable **license** for open-source or commercial use.

## **Tech Stack**
- **Backend**: Spring Boot (Spring Web MVC)
- **ORM**: Spring Data MongoDB
- **Database**: MongoDB Atlas
- **Frontend**: AJAX (or Fetch API for asynchronous data handling)
- **Logging**: SLF4J with Logback (or another logging framework)
- **Testing**: JUnit and Mockito (optional but recommended)

## **Project Architecture**
The application is structured in layers, following best practices for clean and maintainable code:
1. **Controller Layer**: Exposes RESTful APIs to the clients, handling HTTP requests and returning appropriate responses.
2. **Service Layer**: Contains the business logic and orchestrates operations between the Controller and the Data Access layer.
3. **Repository Layer**: Uses **Spring Data MongoDB** to interact with the MongoDB database via **MongoDB Atlas**.
4. **DTOs (Data Transfer Objects)**: Used for transferring data between the layers and ensuring separation of concerns.
5. **Entity Layer**: Represents MongoDB collections with proper annotations to handle persistence.

## **Key Features**
- **API**: Offers endpoints to manage resources (CRUD operations).
- **AJAX-based Frontend**: Implements asynchronous API calls using **fetch()** for a seamless user experience.
- **Spring Data MongoDB**: Simplifies database interactions with MongoDB and supports repository patterns.
- **Proper Logging**: Logs messages at appropriate levels (INFO, DEBUG, ERROR) using SLF4J and Logback for better monitoring and debugging.
- **API Documentation**: A complete set of API documentation for developers and users, detailing the endpoints, request formats, and responses.

## **Logging**
The application uses **SLF4J** with **Logback** for efficient logging management. Each log entry is categorized by levels such as:
- **INFO**: Tracks general information about the application's state.
- **DEBUG**: Provides detailed output for debugging purposes.
- **ERROR**: Logs critical failures and exceptions.

Log files are stored in the `logs/` directory and can be configured through the `logback.xml` file.

## **API Documentation**
You can view the complete API documentation [here](https://www.postman.com/supply-engineer-31331527/possystem-spring/collection/vc5wb07/possystem-spring?action=share&creator=36186170), which includes:
- Endpoints for each resource.
- Expected input parameters (request bodies, query parameters).
- Response format and status codes.

## **Project Structure**
```
src/
    ├── main/
    │   ├── java/
    │   │   └── com.example.possystem/
    │   │       ├── controller/    # Controllers handling API requests
    │   │       ├── dao/           # Data Access Objects (no longer applicable for JPA)
    │   │       ├── dto/           # Data Transfer Objects
    │   │       ├── entity/        # Entity classes (MongoDB Documents)
    │   │       ├── exception/     # Custom exceptions
    │   │       ├── service/       # Business logic
    │   │       ├── util/          # Utility classes
    │   │       └── repository/    # MongoDB interactions (Spring Data MongoDB)
    │   └── resources/
    │       ├── logback.xml        # Logging configuration
    │       └── application.properties   # Spring configuration file
    ├── webapp/
    │   └── WEB-INF/
    │       └── web.xml            # Deployment descriptor (if needed)
    └── test/ 
```

## **API Endpoints Overview**
The API supports basic CRUD operations for resources. Below is a quick overview of key endpoints:
- `GET /api/resources`: Fetch all resources.
- `GET /api/resources/{id}`: Fetch a resource by its ID.
- `POST /api/resources`: Create a new resource.
- `PUT /api/resources/{id}`: Update an existing resource by ID.
- `DELETE /api/resources/{id}`: Delete a resource by ID.

