# Docker_QAP
**Prerequisites**

Docker Desktop 

MySQL

Postman

**Update MySQL Passwords in docker-compose.yml**
```sh
environment:
	MYSQL_ROOT_PASSWORD: yourpassword
	spring.datasource.password=yourpassword
```

Build the Project
```sh
mvn install
mvn clean package
```


Start Docker Containers
```sh
docker-compose up --build
```

**1. Test Member APIs**

1.1 Create a Member (POST /members)
```sh 
POST http://localhost:8080/members
```
**Headers:**
```sh
Content-Type: application/json
```
**Request Body:**
  
```sh
{
  "name": "Clovis N",
  "address": "12 Ladysmith St, St.John's, Canada",
  "email": "clovis.n@gmail.com",
  "phoneNumber": "709-567-7890",
  "startDate": "2024-03-20",
  "duration": 12
}
```
1.2 Get All Members (GET /members)
```sh

GET http://localhost:8080/members
```

1.3 Get a Member by ID (GET /members/{id})

```sh
GET http://localhost:8080/members/id
```

1.4 Delete a Member (DELETE /members/{id})
```sh
DELETE http://localhost:8080/members/id
```

**2. Test Tournament APIs**

2.1 Create a Tournament (POST /tournaments)
```sh
POST http://localhost:8080/tournaments
```
**Headers:**
```sh
Content-Type: application/json
```
**Request Body:**
```sh
{
  "startDate": "2024-06-01",
  "endDate": "2024-06-05",
  "location": "Paradise Golf Club, St.John's",
  "entryFee": 150.00,
  "cashPrize": 5000.00
}
```

2.2 Get All Tournaments (GET /tournaments)
```sh
GET http://localhost:8080/tournaments
```

2.3 Get a Tournament by ID (GET /tournaments/{id})
```sh
 GET http://localhost:8080/tournaments/id
```

2.4 Delete a Tournament (DELETE /tournaments/{id})
```sh
DELETE http://localhost:8080/tournaments/id
```

**3.Test Many-to-Many Relationship APIs**

3.1 Add a Member to a Tournament (PUT /tournaments/{tournamentId}/addMember/{memberId})
```sh
PUT http://localhost:8080/tournaments/id/addMember/id
```

3.2 Get All Members in a Tournament (GET /tournaments/{id}/members)
```sh
GET http://localhost:8080/tournaments/id/members
```

3.3 Search Members by Name (GET /members?name=Clovis)
```sh
GET http://localhost:8080/members?name=Clovis
```

3.4 Search Tournaments by Location (GET /tournaments?location=St. John's)
```sh
GET http://localhost:8080/tournaments?location=St.John's
```

3.5 Search Tournaments by Date (GET /tournaments?startDate=2024-06-01)
```sh
GET http://localhost:8080/tournaments?startDate=2024-06-01
```
