# Loan Management Application

This is a **Loan Management Application** developed using **Spring Boot**, **Hibernate**, and **MySQL**. The application provides functionalities for managing loans, customers, and payments in a structured and efficient way.

## Features

- **User Authentication**: Role-based authentication for Admin and Customers.
- **Customer Management**: CRUD operations for customer data.
- **Loan Management**: Apply for loans, view loan status, and manage loan details.
- **Payment Management**: Track and update payment records.
- **Reports**: Generate reports for loans and payments.

## Tech Stack

- **Backend**: Spring Boot (REST API), Hibernate (ORM)
- **Database**: MySQL
- **Frontend**: (Optional - e.g., React, Angular, or Thymeleaf if applicable)
- **Build Tool**: Maven
- **Version Control**: Git

## Prerequisites

- **Java 11 or higher**
- **MySQL Server**
- **Maven**
- **Git**

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/loan-management-application.git
cd loan-management-application
```

### 2. Configure the Database

- Create a MySQL database named `loan_management`.
- Update the `application.properties` file in the `src/main/resources` directory with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/loan_management
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build and Run the Application

```bash
mvn clean install
mvn spring-boot:run
```

The application will be accessible at `http://localhost:8080`.

## API Endpoints

### Authentication
- `POST /api/auth/login`: Authenticate user.
- `POST /api/auth/register`: Register a new user.

### Customer Management
- `GET /api/customers`: Get all customers.
- `POST /api/customers`: Add a new customer.
- `PUT /api/customers/{id}`: Update customer details.
- `DELETE /api/customers/{id}`: Delete a customer.

### Loan Management
- `GET /api/loans`: Get all loans.
- `POST /api/loans`: Apply for a loan.
- `PUT /api/loans/{id}`: Update loan details.
- `DELETE /api/loans/{id}`: Delete a loan.

### Payment Management
- `GET /api/payments`: Get all payments.
- `POST /api/payments`: Add a new payment.
- `PUT /api/payments/{id}`: Update payment details.
- `DELETE /api/payments/{id}`: Delete a payment.

## Database Schema

### Tables
1. **Users**
   - `id` (Primary Key)
   - `username`
   - `password`
   - `role`

2. **Customers**
   - `id` (Primary Key)
   - `name`
   - `email`
   - `phone`
   - `address`

3. **Loans**
   - `id` (Primary Key)
   - `customer_id` (Foreign Key)
   - `loan_type`
   - `amount`
   - `interest_rate`
   - `status`

4. **Payments**
   - `id` (Primary Key)
   - `loan_id` (Foreign Key)
   - `amount`
   - `payment_date`



**Developed By:** Pratik Waghmare

**Contact:** pratikwaghmare917@gmail.com
