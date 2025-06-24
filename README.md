# Simple Task Management API
The simple task management api to practice Spring Boot Framework

# Installation
1. Clone the repo
```
git clone https://github.com/Nguyen-Dang-Khoa-04072004/TaskManagement
```
2. run project with docker compose
```
docker compose up -d
```
# Features
- Simple CRUD operations with spring data JPA
- Search and filter with criteria query 
- Global exception handling use @ControllerAdvice
- Unit testing with JUnit5 and Mockito
- Apply continuous intergration with github action
- Containerize java application by docker compose
# Endpoints
## URI: http://localhost:8080/api
## GET /tasks - Retrieve all task
### Query parameters
- name : String (Search a name like pattern %{name}% )
- status : String (Filter by status) with accepted values { PLANNING, ON_PROGRESS, PENDING, COMPLETE } 
- priority : String (Filter by Priority) with acepted values { LOW, MEDIUM, HIGH }
### Response 
```
{
    "code" : int,
    "status": String,
    "message": String,
    "tasks": [
        {
            "id": Long,
            "name": String,
            "isCompleted": Boolean,
            "priority": String
        }
    ]
}
```
## GET/tasks/{taskId} - Retrieve a task with specific task id
### Response
```
{
    "code" : int,
    "status": String,
    "message": String,
    "task": {
        "id": Long,
        "name": String,
        "isCompleted": Boolean,
        "priority": String
    }
}
```
## POST /tasks - Create a new task
### Request header
```
  Content-Type: application/json
```
### Request body
```
{
    "name": String,
    "priority": String, accepted values { PLANNING, ON_PROGRESS, PENDING, COMPLETE }
    "status": String accepted values { LOW, MEDIUM, HIGH }
}
```
### Response
```
{
    "code" : int,
    "status": String,
    "message": String,
    "task": {
        "id": Long,
        "name": String,
        "isCompleted": Boolean,
        "priority": String
    }
}
```
## PUT /tasks/{taskId} - Update a task
### Request header
```
  Content-Type: application/json
```
### Request body (Required 1 field to update)
```
{
    "name": String, 
    "priority": String, accepted values { PLANNING, ON_PROGRESS, PENDING, COMPLETE } 
    "status":"COMPLETE" accepted values { LOW, MEDIUM, HIGH } 
}
```
### Response
```
{
    "code" : int,
    "status": String,
    "message": String,
    "task": {
        "id": Long,
        "name": String,
        "isCompleted": Boolean,
        "priority": String
    }
}
```

## DELETE /tasks/{taskId} - Delete a task
### Response
No content
