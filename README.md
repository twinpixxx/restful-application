[![GitHub version](https://badge.fury.io/gh/twinpixxx%2Fhtmlparser.svg)](https://badge.fury.io/gh/twinpixxx%2Fhtmlparser)

# Triangful
A Spring Boot RESTful application that calculates area and perimeter of triangle

  - Perform Calculations
  - Error Handling
  - Triangle Visualisation [IN FUTURE]
  
### Tech

Triangful uses a number of projects to work properly:

* [SpringBoot](https://spring.io/projects/spring-boot) - Spring Boot makes it easy to create stand-alone Spring Applications.
* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - awesome Java IDE from JetBrains.
* [Swagger2](https://swagger.io/) - Auto Documentations. 
* [VueJS](https://vuejs.org/) - The Progressive JavaScript Framework [IN FUTURE]



### Installation

Triangful requires [Java 8+](https://java.com/) to run.

Install the dependencies and devDependencies and start the server.

```sh
$ cd restful-application
$ gradlew bootRun
```
Alternatively, you can build the JAR file
```sh
$ cd restful-application
$ gradlew build
$ java -jar build/libs/restful-application-0.1.0.jar
```
Or just use your IDE << this is much more prefer.

### Testing

Open your favorite Web Browser (or Postman) and go to

```sh
localhost:8080/triangle?a=&b=&c=
```
Where a, b and c are sides of triangle.

Example:
```sh
localhost:8080/triangle?a=3&b=4&c=5
```

### POST
Also, you can perform bulk operations.

Just make request (POST method) with triangles in body (JSON format).

Request example (JSON):
```sh
{
    "triangles": [
    	{
    		"firstSide": 3,
        	"secondSide": 4,
        	"thirdSide": 5
    	},
	    {
	        "firstSide": 12,
	        "secondSide": 13,
	        "thirdSide": 15
	    }
	]
}
```

Response example (JSON):
```sh
{
    "results": {
        "resultsList": [
            {
                "perimeter": 40,
                "area": 74.83314773547883
            },
            {
                "perimeter": 12,
                "area": 6.0
            }
        ]
    }
}
```
### Documentation
All documentation available in JSON format:
 ```sh
localhost:8080/v2/api-docs
```
Or in Web format:
 ```sh
localhost:8080/swagger-ui.html
```
### ToDo

- [ ] Controller Error Handling
- [ ] Database
- [ ] VueJs Web View
- [ ] Async
- [ ] Tests


## License

The code is available under the [MIT license](LICENSE.md).