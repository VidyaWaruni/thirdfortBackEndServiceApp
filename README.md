# Thirdfort Notes Backend

## Dependencies
* Spring Boot
* Maven Dependencies
* MySQL

##Regarding for this Code Challenge I was taken one Database with User Id (uId), Note Id (nId), Note (note), status for save archive or not (1 for archieve and 0 for unarchieve,by default its unarchieve(0).As I taken only one table I took only nId as primary key (increment) but In the real scenario uId and nId both should be composite primary key and uId should be foreign key of User table.

## How to run

* make sure that MySQL is running.(XAMPP)
* change data Source and data source username if Ports are different Edit the configuration File.


* import Maven Dependencies

* run back end (build and run)
 
* Run the Application.

* api will be served at

```node
localhost:[port]/api/v1/
```

# Assumptions
## Notes contain only basic strings
## When a user wants to update a note which is already archived, the user wants to update the archived note as well
## When a user wants to delete a note which is already archived, the user wants to delete the archived note as well

# APIS

## API Swagger UI samples can be Tested and easily can tested for different scenarios and guided way.

```node
http://localhost:[port]/api/v1/swagger-ui.html
```

## 1. Add a note

```node
http://localhost:8090/api/v1/notes/addNote
```

* sample body

```node
{
  "note": "string",
  "uid": 0
}
```

* sample response body

```node
{
	"note":"Note added Successfully",
	"id":13
}
```

## 2. Update a note

### if archived, update archived note too

* api

```node
http://localhost:8090/api/v1/notes/updateNote
```

* sample body

```node
{
	"n_id": 2,
	"u_id":3,
	"note":"My Note"
}
```

* sample success response body

```node
{
	"note id":2,
	"note":"My Note",
	"message":"Note Updated Successfully"
}
```


## 3. Delete a note

* api

```node
http://localhost:8090/api/v1/notes/deleteNote
```


* sample success response body

```node
{
	"note id":13,
	"message":"Note Deleted Successfully"
}

```
## 4. Get all archived notes of a user


* api

```node
http://localhost:8090/api/v1/notes/archiveNotes
```


* sample success response body

```node
[
  {
    "note": "My Arch Note 1",
    "status": 1,
    "nid": 3,
    "uid": 2
  },
  {
    "note": "My Arch Note 2",
    "status": 1,
    "nid": 4,
    "uid": 2
  }
]
```

## 5. Get all un-archived notes of a user


* api

```node
http://localhost:8090/api/v1/notes/unarchiveNotes
```


* sample success response body

```node
[
  {
    "note": "My Note 3",
    "status": 0,
    "nid": 5,
    "uid": 2
  },
  {
    "note": "My Note 4",
    "status": 0,
    "nid": 6,
    "uid": 2
  }
]
```

## 6. Archive a note


* api

```node
http://localhost:8090/api/v1/notes/archiveNote
```

* sample body

```node
{
	"n_id": 5,
	"u_id":2
}
```

* sample success response body

```node
{
	"note id":2,
	"message":"Note Archived Successfully"
}
```


## 7. Un-archive a note

* api

```node
http://localhost:8090/api/v1/notes/unarchiveNote
```

* sample body

```node
{
	"n_id": 5,
	"u_id":2
}
```

* sample success response body

```node
{
	"note id":5,
	"message":"Note Unarchived Successfully"
}
```


# choose of technology

* Spring boot
	* Spring MVC architecture for developing RESTful web services 
	* Rest annotations available
	* Security can be enhanced with supported dependencies
	* Swagger UI helps to test the API easily 


* SQL
	* to save notes and note status
	* writing complex queries can be done easily
	* relation schema 
	* Data replication minimized

# improvements

* According to the Code challenge given, description of requirement can be done through the API calls that i have implemented.Other than that if spend more time on implementation on this task I would have created User table and store and assigned with encrypted Id for the user and make User Id as primary key and make foreign key at the table note.note Id and User Id together maje compostie primary key for the unique identification of a note. And also some features can be added like,
	* enhance more security with JWT
	* specify exceptions more with different scenario to get declarative idea about the errors appearing in different scenario
	* Optimized the code while achieving the service requirement for mora faster service
	* enhance the size of the note by make it file for larger notes in the server
	* can make a reminder alert setup for each note for each user for more functioning
	* can include a expiry date for the archieving automatically
* This function can be implemented. If one asked for my which will you for the technology to writing instead of technology i used, i will goes with Node Js and Monogo DB because of the expressiveness of Server logic in node and, fast,simplicity,security of mongo DB.

