# Finance Backend API

## Overview
This project is a backend system for managing financial records with role-based access control.
It allows users to securely perform operations like creating, viewing, filtering, and analyzing financial data.

---

## Features
- User Authentication using JWT
- Role-Based Access Control (ADMIN, ANALYST, VIEWER)
- Financial Records CRUD operations
- Filtering by type, category, and date
- Dashboard summary (income, expense, balance)
- Input validation and error handling

---

## Tech Stack
- Java
- Spring Boot
- Spring Security
- H2 Database
- Maven

---

## How to Run
1. Clone the repository
2. Open in IntelliJ IDEA
3. Run `FinanceBackendApplication`
4. Use Postman to test APIs

---

## API Endpoints

### Authentication
- POST /auth/register
- POST /auth/login

### Financial Records
- POST /records
- GET /records
- DELETE /records/{id}

### Filters
- GET /records/type/{type}
- GET /records/category/{category}
- GET /records/date/{date}

### Dashboard
- GET /records/summary

---

## Role Access
- ADMIN: Full access (create, delete, view)
- ANALYST: View records and summary
- VIEWER: View summary only

---

## Assumptions
- Record type is restricted to INCOME and EXPENSE
- H2 database is used for simplicity for production will use SQL
- JWT is used for authentication
- Pagination is not implemented due to small dataset

