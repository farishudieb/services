# Technology Used
* Java 11
* SpringBoot 2.4.4
* Spring Rest Web Service 
* MongoDB
* Spring Data Mongo
* Spring RestTemplate (Http client)
* JUnit Test (For integration test)
* Docker-compose (For MongoDB where service connects to at run time)

# How to run
The service and it's MongoDB are dockerized, so first you need to do the following:
* Build the service using maven => mvn clean install
* Build the docker image => docker build -t up42-service .
* Start up docker-compose => docker-compose up

# How to test
There are two tests:
* Integration test: where the real endpoint is being called and I am using embedded MongoDB for storage.
* Unit test: sample unit test for testing a main logic.

# Service Structure
* For easier query, I am saving the provided sample data in a MongoDB on the startup of the 
  application, this class MongoCollectionInitializer. Once the service is started up, 
  an even in this class is triggered, where the data is being read from a json file, the
  DB is cleared, and the data is inserted.
* The service has 3 GET APIs as specified in the task descritption
* The service is doing following things:
    1. Loading data from db.json file, and store it in MongoDB
    2. For finding all Features, we query the DB, map each returned object to client mode, and return the list
    3. For finding specific feature, we query the DB by feature id, map and return the result if found, if not return 404
    4. For feature quicklook, we do same as previous step, we get from the stored Feature the base64 encoding for the image, decode it, and return the result as byte array.

# What can be enhanced
* I see the data model is really big, contains many items, and I always query all this object from the DB, I think this can be enhanced by returning specific fields depends on the usage directly.
* Maybe caching of quicklook images instead of loading it always from the DB  
* Adding more unit and integration tests (Maybe with different framework)
* Enhancing project and package structure!