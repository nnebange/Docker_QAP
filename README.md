# Docker_QAP
 1. Test Member APIs
 1.1 Create a Member (POST /members)
   POST http://localhost:8080/members
   Content-Type: application/json

{
  "name": "John Doe",
  "address": "123 Golf St, Toronto, Canada",
  "email": "johndoe@example.com",
  "phoneNumber": "123-456-7890",
  "startDate": "2024-03-20",
  "duration": 12
}

1.2 Get All Members (GET /members)
GET http://localhost:8080/members

1.3 Get a Member by ID (GET /members/{id})
GET http://localhost:8080/members/id

1.4 Delete a Member (DELETE /members/{id})
DELETE http://localhost:8080/members/id

2. Test Tournament APIs

2.1 Create a Tournament (POST /tournaments)
POST http://localhost:8080/tournaments
Content-Type: application/json

{
  "startDate": "2024-06-01",
  "endDate": "2024-06-05",
  "location": "Greenfield Golf Club, Ottawa",
  "entryFee": 150.00,
  "cashPrize": 5000.00
}

2.2 Get All Tournaments (GET /tournaments)
GET http://localhost:8080/tournaments


2.3 Get a Tournament by ID (GET /tournaments/{id})

 GET http://localhost:8080/tournaments/id

2.4 Delete a Tournament (DELETE /tournaments/{id})
DELETE http://localhost:8080/tournaments/id

3. Test Many-to-Many Relationship APIs
3.1 Add a Member to a Tournament (PUT /tournaments/{tournamentId}/addMember/{memberId})
 PUT http://localhost:8080/tournaments/1/addMember/id

3.2 Get All Members in a Tournament (GET /tournaments/{id}/members)
GET http://localhost:8080/tournaments/id/members

3.3 Search Members by Name (GET /members?name=John)
GET http://localhost:8080/members?name=John

3.4 Search Tournaments by Location (GET /tournaments?location=Ottawa)
GET http://localhost:8080/tournaments?location=Ottawa

3.5 Search Tournaments by Date (GET /tournaments?startDate=2024-06-01)
GET http://localhost:808:0/tournaments?startDate=2024-06-01
