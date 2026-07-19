# 🔐 Spring Boot Authentication Service

A production-style authentication and authorization service built using  Spring Boot 3 ,  Spring Security 6 , and  JWT .

This project demonstrates secure authentication using Access Tokens, Refresh Tokens, OAuth2 Login, Email OTP verification, Role-Based Authorization, and secure password management.

---

# 🚀 Features

## Authentication

- User Registration
- Secure Login
- Logout
- JWT Authentication
- Stateless Authentication
- Access Token Authentication
- Refresh Token Authentication

---

## Authorization

- Role Based Access Control (RBAC)
- Spring Security Method Authorization
- Protected REST APIs

---

## Security Features

- BCrypt Password Hashing
- JWT Access Tokens (15 Minutes)
- JWT Refresh Tokens (7 Days)
- HttpOnly Cookies
- Secure Cookies
- SameSite Cookie Protection
- Custom JWT Filter
- Stateless Session Management
- CSRF Disabled for REST APIs
- CORS Configuration

---

## Email Verification

- Email OTP Verification
- Account Verification
- Prevent Duplicate Verification
- Secure OTP Validation

---

## Password Recovery

- Forgot Password
- Email OTP
- Reset Password
- OTP Validation
- Secure Password Update

---

## OAuth2 Authentication

Supports OAuth2 Login using Spring Security.

Current flow includes

- OAuth2 Login
- Custom OAuth2 Success Handler
- User Authentication

---

## User Features

- Register
- Login
- View Profile
- Verify Email
- Reset Password

---

# 🏗️ Project Architecture

```
Client
   │
   ▼
REST Controller
   │
   ▼
Service Layer
   │
   ▼
Repository Layer
   │
   ▼
Database

                ▲
                │
JWT Filter
                │
Spring Security
```

---

# 📂 Project Structure

```
src
│
├── Controller
│
├── DTO
│
├── Entity
│
├── Exception
│
├── Repository
│
├── Security
│
├── Service
│
└── Application
```

---

# 🛠️ Technologies Used

- Java 21
- Spring Boot
- Spring Security 6
- Spring Data JPA
- Hibernate
- JWT (JJWT)
- OAuth2 Client
- Maven
- MySQL
- Lombok
- Jakarta Validation

---

# 🔑 Authentication Flow

```
User Login
      │
      ▼
Validate Credentials
      │
      ▼
Generate Access Token
      │
      ▼
Generate Refresh Token
      │
      ▼
Store Tokens in HttpOnly Cookies
      │
      ▼
Client Accesses Protected APIs
      │
      ▼
JWT Filter Validates Token
      │
      ▼
Request Authorized
```

---

# 🔄 Registration Flow

```
User Registers
       │
       ▼
Validate Input
       │
       ▼
Encrypt Password
       │
       ▼
Save User
       │
       ▼
Generate OTP
       │
       ▼
Send Email
       │
       ▼
Verify OTP
       │
       ▼
Account Activated
```

---

# 🔒 Password Reset Flow

```
Forgot Password
        │
        ▼
Generate OTP
        │
        ▼
Send Email
        │
        ▼
Verify OTP
        │
        ▼
Reset Password
        │
        ▼
Password Updated
```

---

# 📌 API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /register | Register User |
| POST | /login | Login |
| POST | /logout | Logout |
| POST | /send-verify-otp | Verify Account |
| POST | /send-reset-otp | Verify Password Reset OTP |
| POST | /forgot-password | Forgot Password |
| GET | /profile | User Profile |

---

# 🔐 Security Highlights

- JWT Authentication
- Refresh Token Strategy
- Stateless Security
- Role-Based Authorization
- HttpOnly Cookies
- Secure Cookies
- BCrypt Password Encryption
- Spring Security Filters
- OAuth2 Login
- Validation
- Global Exception Handling

---

# 📈 Future Improvements

- Redis Refresh Token Blacklisting
- Redis OTP Cache
- Rate Limiting
- Email Service using Kafka
- Docker Support
- Kubernetes Deployment
- Swagger/OpenAPI Documentation
- Monitoring with Prometheus & Grafana
- CI/CD Pipeline using GitHub Actions
- Multi-Factor Authentication (MFA)

---

# 💡 Learning Outcomes

This project demonstrates practical experience with:

- Spring Security
- JWT Authentication
- OAuth2 Authentication
- REST API Development
- Password Encryption
- Authentication Filters
- Role-Based Authorization
- Email Integration
- Secure Cookie Management
- Exception Handling
- Layered Architecture
- Production-Oriented Backend Development

---

# ⭐ If you found this project useful, consider giving it a star!