# Bookstore RESTful API

## Overview
This project is a RESTful API for managing a bookstore system, developed in Java using the JAX-RS (`javax.ws.rs`) framework. It provides endpoints to manage books, customers, and shopping carts, supporting standard CRUD (Create, Read, Update, Delete) operations.

The API uses JSON for request and response data formatting, and includes robust error handling to ensure reliable communication. Postman was used extensively for testing and validating the API endpoints.

## Features
- Manage Books: Add, view, update, and delete book records.
- Manage Customers: CRUD operations on customer data.
- Manage Shopping Carts: Add items to cart, view cart contents, update quantities, and remove items.
- Error handling with appropriate HTTP response codes.
- JSON data format for all requests and responses.

## Technology Stack
- Java 11+ (or your JDK version)
- JAX-RS (`javax.ws.rs`) for RESTful services
- JSON processing (e.g., `javax.json` or third-party libraries like Gson/Jackson if applicable)
- Tested with Postman

## Prerequisites
- Java Development Kit (JDK) 11 or higher
- Maven or Gradle (if using build tools)
- Application server or servlet container supporting JAX-RS (e.g., Apache Tomcat, GlassFish)

## Setup & Running the Application
1. Clone the repository:
   ```bash
   git clone <repository-url>
