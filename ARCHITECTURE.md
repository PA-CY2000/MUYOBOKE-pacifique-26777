# Project Architecture

## 🏗️ Application Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                    Spring Boot Application                   │
│                  (RestfulApiApplication.java)                │
│                      Port: 8080                              │
└─────────────────────────────────────────────────────────────┘
                              │
                              │
        ┌─────────────────────┴─────────────────────┐
        │                                           │
        ▼                                           ▼
┌──────────────┐                            ┌──────────────┐
│ Controllers  │                            │   Models     │
│   Layer      │◄──────────────────────────►│   Layer      │
└──────────────┘                            └──────────────┘
        │                                           │
        │                                           │
        ├─── Question 1: BookController ──────────►├─── Book
        │                                           │
        ├─── Question 2: StudentController ───────►├─── Student
        │                                           │
        ├─── Question 3: MenuController ──────────►├─── MenuItem
        │                                           │
        ├─── Question 4: ProductController ───────►├─── Product
        │                                           │
        ├─── Question 5: TaskController ──────────►├─── Task
        │                                           │
        └─── Bonus: UserProfileController ────────►├─── UserProfile
                                                    └─── ApiResponse<T>
```

---

## 📦 Package Structure

```
com.restapi
│
├── RestfulApiApplication.java (Main Entry Point)
│
├── controller/
│   ├── library/
│   │   └── BookController.java
│   ├── student/
│   │   └── StudentController.java
│   ├── restaurant/
│   │   └── MenuController.java
│   ├── ecommerce/
│   │   └── ProductController.java
│   ├── task/
│   │   └── TaskController.java
│   └── userprofile/
│       └── UserProfileController.java
│
└── model/
    ├── library/
    │   └── Book.java
    ├── student/
    │   └── Student.java
    ├── restaurant/
    │   └── MenuItem.java
    ├── ecommerce/
    │   └── Product.java
    ├── task/
    │   └── Task.java
    └── userprofile/
        ├── UserProfile.java
        └── ApiResponse.java
```

---

## 🔄 Request Flow

```
Client (Browser/Postman)
        │
        │ HTTP Request
        ▼
┌─────────────────┐
│  Spring Boot    │
│  DispatcherServlet │
└─────────────────┘
        │
        │ Route to Controller
        ▼
┌─────────────────┐
│  @RestController│
│  - BookController
│  - StudentController
│  - MenuController
│  - ProductController
│  - TaskController
│  - UserProfileController
└─────────────────┘
        │
        │ Process Request
        │ - @PathVariable
        │ - @RequestParam
        │ - @RequestBody
        ▼
┌─────────────────┐
│  Business Logic │
│  - CRUD Operations
│  - Search/Filter
│  - Validation
└─────────────────┘
        │
        │ Access Data
        ▼
┌─────────────────┐
│  In-Memory List │
│  (ArrayList)    │
│  - books
│  - students
│  - menuItems
│  - products
│  - tasks
│  - users
└─────────────────┘
        │
        │ Return Response
        ▼
┌─────────────────┐
│  HTTP Response  │
│  - JSON Format  │
│  - Status Code  │
└─────────────────┘
        │
        ▼
Client (Browser/Postman)
```

---

## 🎯 Endpoint Mapping

### Question 1: Library Books
```
/api/books
    ├── GET    /                    → getAllBooks()
    ├── GET    /{id}                → getBookById()
    ├── GET    /search?title=X      → searchBooksByTitle()
    ├── POST   /                    → addBook()
    └── DELETE /{id}                → deleteBook()
```

### Question 2: Students
```
/api/students
    ├── GET    /                    → getAllStudents()
    ├── GET    /{studentId}         → getStudentById()
    ├── GET    /major/{major}       → getStudentsByMajor()
    ├── GET    /filter?gpa=X        → filterStudentsByGpa()
    ├── POST   /                    → registerStudent()
    └── PUT    /{studentId}         → updateStudent()
```

### Question 3: Restaurant Menu
```
/api/menu
    ├── GET    /                    → getAllMenuItems()
    ├── GET    /{id}                → getMenuItemById()
    ├── GET    /category/{category} → getMenuItemsByCategory()
    ├── GET    /available?available=X → getAvailableMenuItems()
    ├── GET    /search?name=X       → searchMenuItemsByName()
    ├── POST   /                    → addMenuItem()
    ├── PUT    /{id}/availability   → toggleAvailability()
    └── DELETE /{id}                → deleteMenuItem()
```

### Question 4: E-Commerce Products
```
/api/products
    ├── GET    /                    → getAllProducts()
    ├── GET    /?page=X&limit=Y     → getAllProducts() [paginated]
    ├── GET    /{productId}         → getProductById()
    ├── GET    /category/{category} → getProductsByCategory()
    ├── GET    /brand/{brand}       → getProductsByBrand()
    ├── GET    /search?keyword=X    → searchProducts()
    ├── GET    /price-range?min=X&max=Y → getProductsByPriceRange()
    ├── GET    /in-stock            → getInStockProducts()
    ├── POST   /                    → addProduct()
    ├── PUT    /{productId}         → updateProduct()
    ├── PATCH  /{productId}/stock?quantity=X → updateStock()
    └── DELETE /{productId}         → deleteProduct()
```

### Question 5: Tasks
```
/api/tasks
    ├── GET    /                    → getAllTasks()
    ├── GET    /{taskId}            → getTaskById()
    ├── GET    /status?completed=X  → getTasksByStatus()
    ├── GET    /priority/{priority} → getTasksByPriority()
    ├── POST   /                    → createTask()
    ├── PUT    /{taskId}            → updateTask()
    ├── PATCH  /{taskId}/complete   → markTaskAsCompleted()
    └── DELETE /{taskId}            → deleteTask()
```

### Bonus: User Profiles
```
/api/users
    ├── GET    /                    → getAllUsers()
    ├── GET    /{userId}            → getUserById()
    ├── GET    /search/username?username=X → searchByUsername()
    ├── GET    /search/country/{country} → searchByCountry()
    ├── GET    /search/age-range?minAge=X&maxAge=Y → searchByAgeRange()
    ├── GET    /active              → getActiveUsers()
    ├── POST   /                    → createUser()
    ├── PUT    /{userId}            → updateUser()
    ├── PATCH  /{userId}/activate   → activateUser()
    ├── PATCH  /{userId}/deactivate → deactivateUser()
    └── DELETE /{userId}            → deleteUser()
```

---

## 🔧 Technology Stack

```
┌─────────────────────────────────────┐
│         Spring Boot 3.2.0           │
├─────────────────────────────────────┤
│         Spring Web (MVC)            │
├─────────────────────────────────────┤
│         Jackson (JSON)              │
├─────────────────────────────────────┤
│         Embedded Tomcat             │
├─────────────────────────────────────┤
│         Java 17                     │
├─────────────────────────────────────┤
│         Maven                       │
└─────────────────────────────────────┘
```

---

## 📊 Data Flow Example

### Example: GET /api/books/1

```
1. Client Request
   GET http://localhost:8080/api/books/1

2. Spring DispatcherServlet
   Routes to BookController

3. BookController.getBookById(1L)
   @GetMapping("/{id}")
   public ResponseEntity<Book> getBookById(@PathVariable Long id)

4. Search in ArrayList<Book>
   books.stream()
        .filter(book -> book.getId().equals(id))
        .findFirst()

5. Return Response
   - Found: ResponseEntity.ok(book) → 200 OK
   - Not Found: ResponseEntity.notFound().build() → 404 Not Found

6. JSON Serialization (Jackson)
   {
     "id": 1,
     "title": "Clean Code",
     "author": "Robert Martin",
     "isbn": "978-0132350884",
     "publicationYear": 2008
   }

7. Client receives JSON response
```

---

## 🎨 Design Patterns Used

1. **MVC Pattern**
   - Model: Entity classes (Book, Student, etc.)
   - View: JSON responses
   - Controller: REST Controllers

2. **RESTful Architecture**
   - Resource-based URLs
   - HTTP methods for operations
   - Stateless communication

3. **Generic Wrapper Pattern** (Bonus)
   - ApiResponse<T> wraps all responses
   - Consistent response format

4. **Repository Pattern** (Simplified)
   - In-memory ArrayList as data store
   - CRUD operations in controllers

---

## 🚀 Deployment Architecture

```
Development Environment
┌─────────────────────────────────┐
│  Local Machine                  │
│  ├── Java 17 JDK               │
│  ├── Maven                      │
│  ├── IDE (IntelliJ/Eclipse)    │
│  └── Spring Boot App            │
│      └── Embedded Tomcat:8080  │
└─────────────────────────────────┘
         │
         │ HTTP
         ▼
┌─────────────────────────────────┐
│  Testing Tools                  │
│  ├── Web Browser                │
│  ├── Postman                    │
│  └── cURL                       │
└─────────────────────────────────┘
```

---

This architecture provides a clean, maintainable, and scalable foundation for RESTful API development!
