# Testing Guide

## Quick Start Testing

### 1. Start the Application
```bash
cd restful-api-assignment
mvn spring-boot:run
```

Wait for the message: "Started RestfulApiApplication"

### 2. Test with Browser (GET requests only)

Open your browser and test these URLs:

**Question 1 - Books:**
- http://localhost:8080/api/books
- http://localhost:8080/api/books/1
- http://localhost:8080/api/books/search?title=clean

**Question 2 - Students:**
- http://localhost:8080/api/students
- http://localhost:8080/api/students/1
- http://localhost:8080/api/students/major/Computer%20Science
- http://localhost:8080/api/students/filter?gpa=3.5

**Question 3 - Menu:**
- http://localhost:8080/api/menu
- http://localhost:8080/api/menu/category/Appetizer
- http://localhost:8080/api/menu/available?available=true

**Question 4 - Products:**
- http://localhost:8080/api/products
- http://localhost:8080/api/products?page=0&limit=5
- http://localhost:8080/api/products/category/Electronics
- http://localhost:8080/api/products/brand/Apple
- http://localhost:8080/api/products/search?keyword=phone
- http://localhost:8080/api/products/price-range?min=100&max=500
- http://localhost:8080/api/products/in-stock

**Question 5 - Tasks:**
- http://localhost:8080/api/tasks
- http://localhost:8080/api/tasks/status?completed=false
- http://localhost:8080/api/tasks/priority/HIGH

**Bonus - Users:**
- http://localhost:8080/api/users
- http://localhost:8080/api/users/active
- http://localhost:8080/api/users/search/username?username=john
- http://localhost:8080/api/users/search/country/USA

### 3. Test with Postman

1. Open Postman
2. Import the `Postman_Collection.json` file
3. Test all endpoints organized by question

### 4. Test with cURL (Command Line)

**GET Request:**
```bash
curl http://localhost:8080/api/books
```

**POST Request:**
```bash
curl -X POST http://localhost:8080/api/books ^
  -H "Content-Type: application/json" ^
  -d "{\"title\":\"Test Book\",\"author\":\"Test Author\",\"isbn\":\"123456789\",\"publicationYear\":2024}"
```

**PUT Request:**
```bash
curl -X PUT http://localhost:8080/api/students/1 ^
  -H "Content-Type: application/json" ^
  -d "{\"firstName\":\"Updated\",\"lastName\":\"Name\",\"email\":\"updated@email.com\",\"major\":\"CS\",\"gpa\":4.0}"
```

**PATCH Request:**
```bash
curl -X PATCH http://localhost:8080/api/tasks/1/complete
```

**DELETE Request:**
```bash
curl -X DELETE http://localhost:8080/api/books/1
```

## Expected Test Results

### Question 1 - Library (5 endpoints)
✓ GET all books returns 3 books
✓ GET book by ID returns specific book or 404
✓ Search by title filters correctly
✓ POST creates new book with 201 status
✓ DELETE removes book with 204 status

### Question 2 - Students (6 endpoints)
✓ GET all students returns 5 students
✓ Filter by major "Computer Science" returns 3 students
✓ Filter by GPA >= 3.5 returns 3 students
✓ POST creates new student with 201 status
✓ PUT updates student information

### Question 3 - Menu (8 endpoints)
✓ GET all menu items returns 8 items
✓ Filter by category works for all 4 categories
✓ Available filter returns only available items
✓ Search by name filters correctly
✓ Toggle availability changes status

### Question 4 - Products (11 endpoints)
✓ GET all products returns 10 products
✓ Pagination works correctly
✓ All filters (category, brand, price range) work
✓ Search by keyword searches name and description
✓ In-stock filter excludes items with 0 quantity
✓ PATCH updates stock quantity

### Question 5 - Tasks (8 endpoints)
✓ GET all tasks returns 3 tasks
✓ Filter by completion status works
✓ Filter by priority (LOW, MEDIUM, HIGH) works
✓ PATCH marks task as completed

### Bonus - User Profiles (11 endpoints)
✓ All responses wrapped in ApiResponse format
✓ Search by username, country, age range works
✓ Activate/deactivate toggles user status
✓ All CRUD operations return proper messages

## Troubleshooting

**Port 8080 already in use:**
- Change port in `application.properties`: `server.port=8081`

**Application won't start:**
- Check Java version: `java -version` (should be 17+)
- Clean and rebuild: `mvn clean install`

**404 errors:**
- Verify application is running
- Check URL spelling and case sensitivity
- Ensure correct HTTP method is used

## Grading Checklist

- [ ] All 5 questions implemented
- [ ] Bonus question implemented
- [ ] All endpoints return correct HTTP status codes
- [ ] Sample data initialized in constructors
- [ ] Proper use of @RestController, @RequestMapping, etc.
- [ ] Code is clean and well-organized
- [ ] README.md documentation complete
- [ ] Tested all endpoints successfully
- [ ] Screenshots or Postman collection included
