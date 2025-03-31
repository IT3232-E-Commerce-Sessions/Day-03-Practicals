# Student Management API

## Description
This is a simple Spring Boot REST API for managing students. The API allows users to retrieve student details, perform CRUD operations, and filter students based on their age.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [API Endpoints](#api-endpoints)
- [Models and Purpose](#models-and-purpose)

## Overview
This Spring Boot application provides a RESTful API to manage student data. It includes functionalities to:
- Retrieve all students
- Retrieve a specific student by registration number
- Filter students within a specific age range
- Add a new student
- Update an existing student's details
- Delete a student record

## Features
- RESTful API design using Spring Boot
- CRUD operations for student management
- Filtering students by age range
- Simple in-memory list-based storage

## API Endpoints

### General Endpoints
```http
GET /app/msg
```
**Description:** Returns a welcome message

**Example Response:**
```json
{
  "message": "Hello Springboot"
}
```

```http
GET /app/name
```
**Description:** Returns application name

**Example Response:**
```json
{
  "message": "My Name is Springboot"
}
```

```http
GET /app/age/{ag}
```
**Description:** Returns age from parameter

**Example Request:**
```http
GET /app/age/24
```
**Example Response:**
```json
{
  "message": "My Age is 24"
}
```

### Student Endpoints
```http
GET /app/students
```
**Description:** Retrieves all students

**Example Response:**
```json
[
  {
    "regNo": "2020ICT07",
    "name": "Udara",
    "age": 24,
    "course": "ICT",
    "gpa": 3.9
  },
  {
    "regNo": "2020ICT06",
    "name": "Jello",
    "age": 27,
    "course": "ICT",
    "gpa": 3.2
  }
]
```

```http
GET /app/students/{reg}
```
**Description:** Retrieves a student by registration number

**Example Request:**
```http
GET /app/students/2020ICT07
```
**Example Response:**
```json
{
  "regNo": "2020ICT07",
  "name": "Udara",
  "age": 24,
  "course": "ICT",
  "gpa": 3.9
}
```

```http
GET /app/students/age-between
```
**Description:** Finds students with age between 20-23

**Example Response:**
```json
[
  {
    "regNo": "2020ICT07",
    "name": "Udara",
    "age": 24,
    "course": "ICT",
    "gpa": 3.9
  }
]
```

```http
POST /app/students
```
**Description:** Adds a new student

**Example Request:**
```json
{
  "regNo": "2020ICT08",
  "name": "Alex",
  "age": 22,
  "course": "ICT",
  "gpa": 3.5
}
```
**Example Response:**
```json
{
  "message": "Student added successfully"
}
```

```http
PUT /app/students/{id}
```
**Description:** Updates a student's details

**Example Request:**
```json
{
  "name": "Alex Updated",
  "age": 23,
  "course": "ICT",
  "gpa": 3.7
}
```
**Example Response:**
```json
{
  "message": "Student updated successfully"
}
```

```http
DELETE /app/students/{id}
```
**Description:** Deletes a student

**Example Request:**
```http
DELETE /app/students/2020ICT08
```
**Example Response:**
```json
{
  "message": "Student deleted successfully"
}
```

## Models and Purpose

### `Student` Model
The `Student` class represents the student entity in the application. It contains the following attributes:

| Attribute | Type    | Description                   |
|-----------|--------|-------------------------------|
| regNo     | String | Unique registration number    |
| name      | String | Student's full name           |
| age       | int    | Student's age                 |
| course    | String | Student's enrolled course     |
| gpa       | double | Student's GPA                 |

This model is used for storing and managing student-related data within the API.

