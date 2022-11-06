# Event Tracker Project

## Description:
This is a backend only for an application that allows a user to track each trip/trail they take with their 4x4 vehicle.  A user can enter the date they completed the trip along with data such as the trail's name, the highest elevation they saw, the coordinates for the trailhead, and an image (url).  

### Stretch Goals Implemented:
The Controller contains logic which anticipates many possible errors and will display a corresponding status code (400, 404, etc) as well as setting more specific codes (204, etc) for successful operations.  Potential errors include giving bad data (missing a non-nullable field) or attempting to modify a record that does not exist.  Postman tests include tests for bad data and data id numbers.

Users can sort the list of all trails by Highest Elevation (either ascending or descending order).

### How to Access:
| CRUD Op. | HTTP Verb | URI                         | Request Body | Response Body |
|----------|-----------|-----------------------------|--------------|---------------|
| Read     | GET       | `/api/trails`               |              | List of all trails |
| Read     | GET       | `/api/trails/{trailId}`     |              | Representation of one trail |
| Create   | POST      | `/api/trails`               | JSON for new trail| JSON of created trail |
| Update   | PUT       | `/api/trails/{trailId}`     | JSON to update trail | JSON of updated trail |
| Delete   | DELETE    | `/api/trails/{trailId}`     |              | |
| Read     | GET       | `/api/trails/sort/elev/asc` |              | List of trails sorted by ascending elevation|
| Read     | GET       | `/api/trails/sort/elev/desc`|              | List of trails sorted by descending elevation|

## Lessons Learned:


### What I Might Do Differently:
As stated, this is a backend only application.  In the future, I'd like to add a frontend.  I specifically included the trailhead lat/long for the potential to integrate the Google Maps API.   

## Technology Used:
### Applications:
MySQL Workbench, Atom, Unix Terminal, Spring, Spring Boot, Spring Data, JUnit, Postman, JPA, Spring Tools Suite, Chrome, git/gitHub, Slack, Zoom

### Languages:
Java, MySQL
