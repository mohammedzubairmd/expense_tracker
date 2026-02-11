# 💰 FinanceFlow Pro: Full-Stack Personal Finance Suite

FinanceFlow Pro is a professional-grade personal finance application designed to help users track spending, visualize financial trends, and hit savings goals. It features a robust **Spring Boot** backend and a sleek, responsive **Tailwind CSS** frontend.

## 🚀 Key Features

* **Smart Dashboard:** Real-time visualization of Net Worth, Total Income, and Expenses.
* **AI-Powered Insights:** Automatically calculates daily "Burn Rate" and projects end-of-month balances.
* **Interactive Analytics:** Dynamic Line Charts for growth trends and Doughnut Charts for category breakdowns using **Chart.js**.
* **Budget Tracking:** Set monthly limits per category with visual progress bars.
* **Financial Calendar:** A specialized daily view to track spending habits day-by-day.
* **Mobile Optimized:** Fully responsive design with a mobile-first navigation bar and Dark Mode support.

## 🛠️ Tech Stack

**Backend:**
* Java 17 / Spring Boot
* Spring Data JPA (Hibernate)
* MySQL / PostgreSQL
* Maven

**Frontend:**
* JavaScript (ES6+)
* Tailwind CSS (UI Framework)
* Chart.js (Data Visualization)
* FontAwesome (Iconography)

## 📸 Screenshots

| Desktop View Dashboard | Mobile App Experience |
| :--- | :--- |
| <img src="https://github.com/user-attachments/assets/e0c39437-befc-48dd-9234-25a8d81679c9" width="600" /> | <img width="370" height="600" alt="Screenshot 2026-02-08 190138" src="https://github.com/user-attachments/assets/661050ce-da60-4e58-a15c-020d6404e28d" />
|

---

## 📌 API Endpoints

### Expense APIs
* `POST   /api/expenses` - Create new record
* `GET    /api/expenses` - Fetch all history
* `PUT    /api/expenses/{id}` - Update record
* `DELETE /api/expenses/{id}` - Remove record

### Analytics APIs
* `GET /api/analytics/category` - Category-wise breakdown
* `GET /api/analytics/monthly` - Monthly trend data

## 🏗️ Installation & Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/mohammedzubairmd/expense_tracker.git

   
## 🗄️ Database Configuration

FinanceFlow Pro uses **MySQL** for data persistence. To set up the database locally, follow these steps:

### 1. Create the Database
Open your MySQL terminal or Workbench and run:
```sql
create database user;
use user;
create table user(id int primary key,
name varchar(20),
age int);
insert into user values (1,'Raj',18) ,
(2,'Rio',20);

```

2. Configure application.properties
Navigate to src/main/resources/application.properties and update the following fields with your local credentials:

Properties
# Database Connection
spring.datasource.url=jdbc:mysql://localhost:3306/finance_db?useSSL=false&serverTimezone=UTC

spring.datasource.username=your_mysql_username

spring.datasource.password=your_mysql_password

# JPA / Hibernate Settings
spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
