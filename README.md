# Event Tracker Project

## Description:
This is a backend only for an application that allows a user to track each trip/trail they take with their 4x4 vehicle.  Users can:
- view lists of all trails
- view a specific trail
- create a trail
- update a trail
- delete a trail

Information about a trail event includes:
- date the trip was completed
- trail's name
- highest elevation seen
- coordinates for the trailhead
- an image (url)  

### Stretch Goals Implemented:
- The Controller contains logic which anticipates many possible errors and will display a corresponding status code (400, 404, etc) as well as setting more specific codes (204, etc) for successful operations.  Potential errors include giving bad data (missing a non-nullable field) or attempting to modify a record that does not exist.  Postman tests include tests for bad data and bad id numbers.

Users can also:

- sort the list of all trails by Highest Elevation (in either ascending or descending order)
- sort the list of all trails by Date Completed (in either ascending or descending order)
- search for trails whose name contains a keyword

### How to Access:
| CRUD Op. | HTTP Verb | URI                         | Request Body | Response Body |
|----------|-----------|-----------------------------|--------------|---------------|
| Read     | GET       | `/api/trails`               |              | List of all trails |
| Read     | GET       | `/api/trails/{trailId}`     |              | Representation of one trail |
| Create   | POST      | `/api/trails`               | JSON for new trail| JSON of created trail |
| Update   | PUT       | `/api/trails/{trailId}`     | JSON to update trail | JSON of updated trail |
| Delete   | DELETE    | `/api/trails/{trailId}`     |              | |
| Read     | GET       | `/api/trails/sort/elev/asc` |              | List of trails sorted by elevation (ascending order)|
| Read     | GET       | `/api/trails/sort/elev/desc`|              | List of trails sorted by elevation (descending order)|
| Read     | GET       | `/api/trails/sort/date/asc` |              | List of trails sorted by date completed (ascending order)|
| Read     | GET       | `/api/trails/sort/date/desc`|              | List of trails sorted by date completed (descending order)|
| Read     | GET       | `/api/trails/search/{keyword}`|              | List of trails whose name contains the keyword|

## Lessons Learned:


### What I Might Do Differently:
As stated, this is a backend only application.  In the future, I'd like to add a frontend.  I specifically included the trailhead lat/long for the potential to integrate the Google Maps API.   

## Technology Used:
### Applications:
MySQL Workbench, Spring, Spring Boot, Spring Data, JUnit, JSON, Postman, JPA, Spring Tools Suite, Chrome, git/gitHub, Atom, Unix Terminal, Slack, Zoom

### Languages:
Java, MySQL
