# Spring Boot RESTful API Assignment

This project contains all 5 questions plus the bonus question for the Spring Boot RESTful API assignment.

**Student Name:** Muyoboke Pacifique  
**Student ID:** 26777

## Project Structure

```
src/main/java/com/restapi/
├── RestfulApiApplication.java (Main Application)
├── controller/
│   ├── library/BookController.java (Question 1)
│   ├── student/StudentController.java (Question 2)
│   ├── restaurant/MenuController.java (Question 3)
│   ├── ecommerce/ProductController.java (Question 4)
│   ├── task/TaskController.java (Question 5)
│   └── userprofile/UserProfileController.java (Bonus)
└── model/
    ├── library/Book.java
    ├── student/Student.java
    ├── restaurant/MenuItem.java
    ├── ecommerce/Product.java
    ├── task/Task.java
    └── userprofile/UserProfile.java, ApiResponse.java
```

## How to Run

1. Ensure you have Java 17+ and Maven installed
2. Navigate to the project directory
3. Run: `mvn spring-boot:run`
4. The application will start on `http://localhost:8080`

## API Endpoints

---

## Question 1: Library Book Management API

### Base URL: `/api/books`

#### 1. Get All Books
- **Method:** GET
- **URL:** `/api/books`
- **Response:** 200 OK
```json
[
  {
    "id": 1,
    "title": "Clean Code",
    "author": "Robert Martin",
    "isbn": "978-0132350884",
    "publicationYear": 2008
  }
]
```

#### 2. Get Book by ID
- **Method:** GET
- **URL:** `/api/books/{id}`
- **Example:** `/api/books/1`
- **Response:** 200 OK or 404 Not Found

#### 3. Search Books by Title
- **Method:** GET
- **URL:** `/api/books/search?title={title}`
- **Example:** `/api/books/search?title=clean`
- **Response:** 200 OK

#### 4. Add New Book
- **Method:** POST
- **URL:** `/api/books`
- **Request Body:**
```json
{
  "title": "Design Patterns",
  "author": "Gang of Four",
  "isbn": "978-0201633610",
  "publicationYear": 1994
}
```
- **Response:** 201 Created

#### 5. Delete Book
- **Method:** DELETE
- **URL:** `/api/books/{id}`
- **Example:** `/api/books/1`
- **Response:** 204 No Content or 404 Not Found

---

## Question 2: Student Registration API

### Base URL: `/api/students`

#### 1. Get All Students
- **Method:** GET
- **URL:** `/api/students`
- **Response:** 200 OK

#### 2. Get Student by ID
- **Method:** GET
- **URL:** `/api/students/{studentId}`
- **Example:** `/api/students/1`
- **Response:** 200 OK or 404 Not Found

#### 3. Get Students by Major
- **Method:** GET
- **URL:** `/api/students/major/{major}`
- **Example:** `/api/students/major/Computer Science`
- **Response:** 200 OK

#### 4. Filter Students by GPA
- **Method:** GET
- **URL:** `/api/students/filter?gpa={minGpa}`
- **Example:** `/api/students/filter?gpa=3.5`
- **Response:** 200 OK

#### 5. Register New Student
- **Method:** POST
- **URL:** `/api/students`
- **Request Body:**
```json
{
  "firstName": "Alice",
  "lastName": "Johnson",
  "email": "alice@email.com",
  "major": "Computer Science",
  "gpa": 3.7
}
```
- **Response:** 201 Created

#### 6. Update Student
- **Method:** PUT
- **URL:** `/api/students/{studentId}`
- **Request Body:** (Full student object)
- **Response:** 200 OK or 404 Not Found

---

## Question 3: Restaurant Menu API

### Base URL: `/api/menu`

#### 1. Get All Menu Items
- **Method:** GET
- **URL:** `/api/menu`
- **Response:** 200 OK

#### 2. Get Menu Item by ID
- **Method:** GET
- **URL:** `/api/menu/{id}`
- **Example:** `/api/menu/1`
- **Response:** 200 OK or 404 Not Found

#### 3. Get Items by Category
- **Method:** GET
- **URL:** `/api/menu/category/{category}`
- **Example:** `/api/menu/category/Appetizer`
- **Response:** 200 OK

#### 4. Get Available Items
- **Method:** GET
- **URL:** `/api/menu/available?available=true`
- **Response:** 200 OK

#### 5. Search Menu Items by Name
- **Method:** GET
- **URL:** `/api/menu/search?name={name}`
- **Example:** `/api/menu/search?name=chicken`
- **Response:** 200 OK

#### 6. Add New Menu Item
- **Method:** POST
- **URL:** `/api/menu`
- **Request Body:**
```json
{
  "name": "Pizza Margherita",
  "description": "Classic Italian pizza",
  "price": 11.99,
  "category": "Main Course",
  "available": true
}
```
- **Response:** 201 Created

#### 7. Toggle Item Availability
- **Method:** PUT
- **URL:** `/api/menu/{id}/availability`
- **Example:** `/api/menu/1/availability`
- **Response:** 200 OK or 404 Not Found

#### 8. Delete Menu Item
- **Method:** DELETE
- **URL:** `/api/menu/{id}`
- **Response:** 204 No Content or 404 Not Found

---

## Question 4: E-Commerce Product API

### Base URL: `/api/products`

#### 1. Get All Products (with pagination)
- **Method:** GET
- **URL:** `/api/products` or `/api/products?page={page}&limit={limit}`
- **Example:** `/api/products?page=0&limit=5`
- **Response:** 200 OK

#### 2. Get Product by ID
- **Method:** GET
- **URL:** `/api/products/{productId}`
- **Example:** `/api/products/1`
- **Response:** 200 OK or 404 Not Found

#### 3. Get Products by Category
- **Method:** GET
- **URL:** `/api/products/category/{category}`
- **Example:** `/api/products/category/Electronics`
- **Response:** 200 OK

#### 4. Get Products by Brand
- **Method:** GET
- **URL:** `/api/products/brand/{brand}`
- **Example:** `/api/products/brand/Apple`
- **Response:** 200 OK

#### 5. Search Products by Keyword
- **Method:** GET
- **URL:** `/api/products/search?keyword={keyword}`
- **Example:** `/api/products/search?keyword=phone`
- **Response:** 200 OK

#### 6. Get Products by Price Range
- **Method:** GET
- **URL:** `/api/products/price-range?min={min}&max={max}`
- **Example:** `/api/products/price-range?min=100&max=500`
- **Response:** 200 OK

#### 7. Get In-Stock Products
- **Method:** GET
- **URL:** `/api/products/in-stock`
- **Response:** 200 OK

#### 8. Add New Product
- **Method:** POST
- **URL:** `/api/products`
- **Request Body:**
```json
{
  "name": "Wireless Mouse",
  "description": "Ergonomic wireless mouse",
  "price": 29.99,
  "category": "Electronics",
  "stockQuantity": 100,
  "brand": "Logitech"
}
```
- **Response:** 201 Created

#### 9. Update Product
- **Method:** PUT
- **URL:** `/api/products/{productId}`
- **Request Body:** (Full product object)
- **Response:** 200 OK or 404 Not Found

#### 10. Update Stock Quantity
- **Method:** PATCH
- **URL:** `/api/products/{productId}/stock?quantity={quantity}`
- **Example:** `/api/products/1/stock?quantity=75`
- **Response:** 200 OK or 404 Not Found

#### 11. Delete Product
- **Method:** DELETE
- **URL:** `/api/products/{productId}`
- **Response:** 204 No Content or 404 Not Found

---

## Question 5: Task Management API

### Base URL: `/api/tasks`

#### 1. Get All Tasks
- **Method:** GET
- **URL:** `/api/tasks`
- **Response:** 200 OK

#### 2. Get Task by ID
- **Method:** GET
- **URL:** `/api/tasks/{taskId}`
- **Example:** `/api/tasks/1`
- **Response:** 200 OK or 404 Not Found

#### 3. Get Tasks by Status
- **Method:** GET
- **URL:** `/api/tasks/status?completed={true/false}`
- **Example:** `/api/tasks/status?completed=false`
- **Response:** 200 OK

#### 4. Get Tasks by Priority
- **Method:** GET
- **URL:** `/api/tasks/priority/{priority}`
- **Example:** `/api/tasks/priority/HIGH`
- **Response:** 200 OK

#### 5. Create New Task
- **Method:** POST
- **URL:** `/api/tasks`
- **Request Body:**
```json
{
  "title": "Review code",
  "description": "Review pull requests",
  "completed": false,
  "priority": "MEDIUM",
  "dueDate": "2024-12-25"
}
```
- **Response:** 201 Created

#### 6. Update Task
- **Method:** PUT
- **URL:** `/api/tasks/{taskId}`
- **Request Body:** (Full task object)
- **Response:** 200 OK or 404 Not Found

#### 7. Mark Task as Completed
- **Method:** PATCH
- **URL:** `/api/tasks/{taskId}/complete`
- **Example:** `/api/tasks/1/complete`
- **Response:** 200 OK or 404 Not Found

#### 8. Delete Task
- **Method:** DELETE
- **URL:** `/api/tasks/{taskId}`
- **Response:** 204 No Content or 404 Not Found

---

## Bonus Question: User Profile API

### Base URL: `/api/users`

All responses are wrapped in ApiResponse format:
```json
{
  "success": true,
  "message": "Operation message",
  "data": { ... }
}
```

#### 1. Get All Users
- **Method:** GET
- **URL:** `/api/users`
- **Response:** 200 OK

#### 2. Get User by ID
- **Method:** GET
- **URL:** `/api/users/{userId}`
- **Example:** `/api/users/1`
- **Response:** 200 OK or 404 Not Found

#### 3. Search by Username
- **Method:** GET
- **URL:** `/api/users/search/username?username={username}`
- **Example:** `/api/users/search/username?username=john`
- **Response:** 200 OK

#### 4. Search by Country
- **Method:** GET
- **URL:** `/api/users/search/country/{country}`
- **Example:** `/api/users/search/country/USA`
- **Response:** 200 OK

#### 5. Search by Age Range
- **Method:** GET
- **URL:** `/api/users/search/age-range?minAge={min}&maxAge={max}`
- **Example:** `/api/users/search/age-range?minAge=25&maxAge=35`
- **Response:** 200 OK

#### 6. Get Active Users
- **Method:** GET
- **URL:** `/api/users/active`
- **Response:** 200 OK

#### 7. Create User
- **Method:** POST
- **URL:** `/api/users`
- **Request Body:**
```json
{
  "username": "alice_wonder",
  "email": "alice@example.com",
  "fullName": "Alice Wonder",
  "age": 27,
  "country": "Australia",
  "bio": "Travel enthusiast",
  "active": true
}
```
- **Response:** 201 Created

#### 8. Update User
- **Method:** PUT
- **URL:** `/api/users/{userId}`
- **Request Body:** (Full user object)
- **Response:** 200 OK or 404 Not Found

#### 9. Activate User
- **Method:** PATCH
- **URL:** `/api/users/{userId}/activate`
- **Response:** 200 OK or 404 Not Found

#### 10. Deactivate User
- **Method:** PATCH
- **URL:** `/api/users/{userId}/deactivate`
- **Response:** 200 OK or 404 Not Found

#### 11. Delete User
- **Method:** DELETE
- **URL:** `/api/users/{userId}`
- **Response:** 200 OK or 404 Not Found

---

## Testing with Postman

1. Import the endpoints into Postman
2. Set base URL: `http://localhost:8080`
3. Test each endpoint with the provided examples
4. Verify HTTP status codes match the specifications

## HTTP Status Codes Used

- **200 OK** - Successful GET, PUT, PATCH requests
- **201 Created** - Successful POST requests
- **204 No Content** - Successful DELETE requests
- **404 Not Found** - Resource not found

## Technologies Used

- Spring Boot 3.2.0
- Spring Web
- Java 17
- Maven

## Author

**Student Name:** Muyoboke Pacifique  
**Student ID:** 26777

## Submission

Branch name: `restFull_api_26777`
