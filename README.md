# Spring MySQL docker-compose example

## Getting Started
* **Prerequisite:** Download docker application for your desktop

## Steps:
* Start the docker on your machine
* Run the below command to start the application (you need to be in the directory where your compose file is present)
```
docker-compose up 
```
This command will download/build the required image and start the MySQL database and once the database has started and shows up healthy then it will start the Spring boot application.
* Check if both the applications have started. You can run the below command, and it will show the contains running.
```
docker ps
```
## Testing the application:
* The application will start on port 8080 of container and we have mapped local 8111 to it. So your endpoint will look like below.
```
http://localhost:8111
```  
* To insert the data into database (POST)
```
http://localhost:8111/user
```
```
{
    "name": "Arpan",
    "country": "India"
}
```
* To retrieve the data (GET)
```
http://localhost:8111/users
```
* The API also supports additional operations like update and delete. Refer the code and build requests to try it out.