# Quick Reference Card - All Endpoints

## 🚀 Start Application
```bash
mvn spring-boot:run
```
Base URL: `http://localhost:8080`

---

## 📚 Question 1: Books (/api/books)
```
GET    /api/books                    - All books
GET    /api/books/{id}               - Book by ID
GET    /api/books/search?title=X     - Search by title
POST   /api/books                    - Add book
DELETE /api/books/{id}               - Delete book
```

---

## 🎓 Question 2: Students (/api/students)
```
GET    /api/students                 - All students
GET    /api/students/{id}            - Student by ID
GET    /api/students/major/{major}   - By major
GET    /api/students/filter?gpa=X    - By GPA
POST   /api/students                 - Register student
PUT    /api/students/{id}            - Update student
```

---

## 🍽️ Question 3: Menu (/api/menu)
```
GET    /api/menu                     - All items
GET    /api/menu/{id}                - Item by ID
GET    /api/menu/category/{cat}      - By category
GET    /api/menu/available?available=true - Available items
GET    /api/menu/search?name=X       - Search by name
POST   /api/menu                     - Add item
PUT    /api/menu/{id}/availability   - Toggle availability
DELETE /api/menu/{id}                - Delete item
```

---

## 🛒 Question 4: Products (/api/products)
```
GET    /api/products                 - All products
GET    /api/products?page=0&limit=5  - Paginated
GET    /api/products/{id}            - Product by ID
GET    /api/products/category/{cat}  - By category
GET    /api/products/brand/{brand}   - By brand
GET    /api/products/search?keyword=X - Search
GET    /api/products/price-range?min=X&max=Y - Price range
GET    /api/products/in-stock        - In stock only
POST   /api/products                 - Add product
PUT    /api/products/{id}            - Update product
PATCH  /api/products/{id}/stock?quantity=X - Update stock
DELETE /api/products/{id}            - Delete product
```

---

## ✅ Question 5: Tasks (/api/tasks)
```
GET    /api/tasks                    - All tasks
GET    /api/tasks/{id}               - Task by ID
GET    /api/tasks/status?completed=false - By status
GET    /api/tasks/priority/{priority} - By priority
POST   /api/tasks                    - Create task
PUT    /api/tasks/{id}               - Update task
PATCH  /api/tasks/{id}/complete      - Mark completed
DELETE /api/tasks/{id}               - Delete task
```

---

## 👤 Bonus: Users (/api/users)
```
GET    /api/users                    - All users
GET    /api/users/{id}               - User by ID
GET    /api/users/search/username?username=X - By username
GET    /api/users/search/country/{country} - By country
GET    /api/users/search/age-range?minAge=X&maxAge=Y - Age range
GET    /api/users/active             - Active users
POST   /api/users                    - Create user
PUT    /api/users/{id}               - Update user
PATCH  /api/users/{id}/activate      - Activate
PATCH  /api/users/{id}/deactivate    - Deactivate
DELETE /api/users/{id}               - Delete user
```

---

## 📊 HTTP Status Codes
- **200** OK - Successful GET, PUT, PATCH
- **201** Created - Successful POST
- **204** No Content - Successful DELETE
- **404** Not Found - Resource not found

---

## 🧪 Quick Browser Tests
```
http://localhost:8080/api/books
http://localhost:8080/api/students
http://localhost:8080/api/menu
http://localhost:8080/api/products
http://localhost:8080/api/tasks
http://localhost:8080/api/users
```

---

## 📝 Sample POST Request (Books)
```json
{
  "title": "New Book",
  "author": "Author Name",
  "isbn": "123-456-789",
  "publicationYear": 2024
}
```

---

## 🎯 Total Endpoints: 49
- Question 1: 5 endpoints
- Question 2: 6 endpoints
- Question 3: 8 endpoints
- Question 4: 11 endpoints
- Question 5: 8 endpoints
- Bonus: 11 endpoints

---

**Print this card for quick reference during testing!**
