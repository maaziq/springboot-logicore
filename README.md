# springboot-logicore

Logistic Management system :

# 🚚 LogiCore – Smart Logistics & Shipment Management System

> *Every package has a destination. Every shipment has a story. LogiCore was built to make sure that story reaches its destination smoothly.*

---

# 📖 The Story Behind LogiCore

Imagine ordering a laptop from another city.

You place the order and instantly start wondering:

- Where is my package?
- Has it left the warehouse?
- Who is delivering it?
- Has the payment been confirmed?
- When will it arrive?

Behind every shipment, there are multiple people and processes working together.

A customer creates an order.

A warehouse stores the package.

A delivery agent picks it up.

The shipment moves through different locations.

Payments are processed.

Tracking history gets updated continuously until the package reaches the customer.

Managing all these operations manually quickly becomes difficult.

That is where **LogiCore** comes in.

LogiCore is a backend logistics management system built using **Spring Boot** that digitally manages the complete shipment lifecycle—from order creation to final delivery.

---

# 🎯 Project Objective

The goal of this project is to simulate how modern logistics companies manage shipments using a scalable REST API architecture.

The system focuses on:

- Shipment Management
- Customer Management
- Warehouse Management
- Delivery Agent Management
- Package Management
- Payment Processing
- Shipment Tracking

Every module is connected using proper JPA relationships, making the project closer to a real-world logistics application.

---

# 🏗️ System Workflow

```
Customer
    │
    ▼
Creates Shipment
    │
    ▼
Warehouse Receives Package
    │
    ▼
Package Gets Registered
    │
    ▼
Payment Created
    │
    ▼
Delivery Agent Assigned
    │
    ▼
Shipment Tracking Starts
    │
    ▼
Package Delivered
```

---

# ✨ Features

## Customer Module

- Register customers
- View customer details
- Update customer information
- Delete customers
- View all shipments of a customer

---

## Shipment Module

- Create shipment
- Generate unique tracking number
- Assign warehouse
- Assign delivery agent
- Update shipment status
- Search shipment using tracking number

---

## Warehouse Module

- Manage warehouses
- Store shipment information
- Track warehouse capacity
- Assign shipments

---

## Delivery Agent Module

- Register delivery agents
- Maintain availability status
- Assign agents to shipments
- View assigned deliveries

---

## Package Module

- Store package information
- Package type
- Fragile status
- Dimensions

---

## Payment Module

- Payment amount
- Payment method
- Payment status
- Automatic payment mapping with shipment

---

## Tracking Module

- Store shipment history
- Current location
- Shipment remarks
- Tracking status
- Complete shipment timeline

---

# 🛠️ Tech Stack

### Backend

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate

### Database

- MySQL

### Build Tool

- Maven

### Testing

- Postman

### IDE

- Eclipse IDE

---

# 🗂️ Project Structure

```
src
│
├── controller
│
├── service
│
├── repository
│
├── entity
│
├── dto
│
├── exception
│
├── util
│
├── enums
│
└── config
```

---

# 🗃️ Entity Relationships

```
Customer
     │
     │ 1
     │
     └───────────────∞ Shipment
                           │
            ┌──────────────┼──────────────┐
            │              │              │
            │              │              │
           1│             1│             1│
     Warehouse     DeliveryAgent      Payment
                                          │
                                          │
                                          1
                                          │
                                       Shipment

Shipment
    │
    ├──────────────∞ TrackingHistory

Shipment
    │
    └──────────────1 PackageEntity
```

---

# 📦 Shipment Lifecycle

```
PENDING
      │
      ▼
PAYMENT_RECEIVED
      │
      ▼
SHIPPED
      │
      ▼
OUT_FOR_DELIVERY
      │
      ▼
DELIVERED
```

---

# ⚙️ REST APIs

### Customer APIs

- Create Customer
- Get Customer
- Update Customer
- Delete Customer
- Get All Customers

---

### Shipment APIs

- Create Shipment
- Find Shipment
- Find Shipment By Tracking Number
- Update Shipment Status
- Delete Shipment

---

### Warehouse APIs

- Create Warehouse
- Update Warehouse
- Get Warehouse
- Delete Warehouse

---

### Delivery Agent APIs

- Create Delivery Agent
- Update Agent
- Assign Shipment
- Update Availability

---

### Payment APIs

- Create Payment
- Update Payment Status
- Find Payment

---

### Tracking APIs

- Add Tracking History
- View Tracking History
- Search Using Tracking Number

---

# 💾 Database Design

The project uses **Hibernate ORM** with **Spring Data JPA** to automatically map Java objects into relational database tables.

Relationships include:

- One-to-One
- One-to-Many
- Many-to-One

Cascade operations are implemented where required to reduce manual database operations.

---

# 🚀 Future Enhancements

There is always room for making logistics smarter.

Some planned improvements include:

- JWT Authentication
- Spring Security
- Role-Based Access Control
- Email Notifications
- SMS Alerts
- Google Maps Integration
- Live Location Tracking
- Redis Caching
- Docker Deployment
- AWS Cloud Deployment
- Swagger/OpenAPI Documentation
- Unit Testing with JUnit
- CI/CD Pipeline using GitHub Actions

---


# ▶️ Getting Started

Clone the repository

```bash
git clone https://github.com/your-username/logicore.git
```

Move into the project

```bash
cd logicore
```

Configure your MySQL credentials inside:

```
application.properties
```

Run the project

```bash
mvn spring-boot:run
```

The application starts at

```
http://localhost:8080
```

---

# 🎓 What I Learned

Building LogiCore was much more than creating REST APIs.

Through this project, I learned:

- Designing scalable backend architecture
- Spring Boot development
- JPA relationship mapping
- Hibernate ORM
- Exception handling
- Layered Architecture
- REST API Design
- MySQL database modeling
- Maven project management
- Debugging complex backend issues
- Git and GitHub project management

This project strengthened my understanding of how enterprise backend applications are designed and how different modules communicate to create a complete business solution.

---

# 🤝 Contributing

Contributions, suggestions, and improvements are always welcome.

If you'd like to improve this project:

1. Fork the repository
2. Create a new feature branch
3. Commit your changes
4. Open a Pull Request

---

# 📄 License

This project is developed for learning and educational purposes.

---

# 👨‍💻 Developer

**Maaz**

Final Year B.Tech Student  
Java Full Stack Developer

If you found this project interesting, don't forget to ⭐ the repository.



Schema design :-––––––––––

                           +----------------+
                           |    Customer    |
                           +----------------+
                           | customerId (PK)|
                           | name           |
                           | email          |
                           | phone          |
                           +----------------+
                                   |
                              1
                                   |
                                   |  One Customer
                                   |  can create
                                   |  many shipments
                                   |
                              *
                           +----------------+
                           |    Shipment    |
                           +----------------+
                           | shipmentId(PK) |
                           | source         |
                           | destination    |
                           | status         |
                           | createdDate    |
                           | customer_id(FK)|
                           | warehouse_id   |
                           | agent_id       |
                           +----------------+
                           /      |       \
                          /       |        \
                     1:1 /        |1:N      \ N:1
                        /         |          \
                       /          |           \
          +-----------+      +------------------+      +------------------+
          | Payment   |      | TrackingHistory  |      | DeliveryAgent    |
          +-----------+      +------------------+      +------------------+
          | paymentId |      | trackingId       |      | agentId          |
          | amount    |      | location         |      | name             |
          | method    |      | status           |      | contact          |
          | status    |      | time             |      | vehicleNumber    |
          |shipmentFK |      | shipmentFK       |      | availability     |
          +-----------+      +------------------+      +------------------+

                 |
                 |
              1:1|
                 |
        +----------------+
        | PackageEntity  |
        +----------------+
        | packageId      |
        | weight         |
        | dimensions     |
        | type           |
        | shipmentFK     |
        +----------------+

                         N:1
                          |
                          |
                  +----------------+
                  |   Warehouse    |
                  +----------------+
                  | warehouseId    |
                  | name           |
                  | location       |
                  | capacity       |
                  +----------------+
                  
                  
                  
                  
                  