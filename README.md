# Introduction

# Technologies
- ## JDK
    - We need to first download the [Java Development Kit](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).
- ## MongoDB
    - Set up a [MongoDB Atlas](https://www.mongodb.com/cloud/atlas/lp/try4?utm_source=google&utm_campaign=search_gs_pl_evergreen_atlas_core-high-int_prosp-brand_gic-null_amers-us_ps-all_desktop_eng_lead&utm_term=mongodb%20atlas&utm_medium=cpc_paid_search&utm_ad=e&utm_ad_campaign_id=19609124046&adgroup=145188748043&cq_cmp=19609124046&gad_source=1&gclid=Cj0KCQiA67CrBhC1ARIsACKAa8QVgxyJ6kKG9UQY1qu3UsfL7Z1XFC3B9KbAt7fOMLQ993Ztg5lHbfkaAtjSEALw_wcB) account and download MongoDB Compass.
- ## Spring Initializr 
    - [start.spring.io](start.spring.io)
    - Add dependencies, Lombok, Spring Web, DevTools, and Spring Data Reactive MongoDB.

# Launch the Project
- Type `mvn spring-boot:run` in the terminal.
- Reload Maven `mvn clean install`
- Go to [localhost:8080](localhost:8080)
- Create first "Hello World" page inside `Application.java`.
```
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/")
	public String apiRoot(){
		return "Hello World";
	}
}
```
- We will put our application into separate layers, service layer(Service), data access layer(Repository), and API layer(Controller).

# Add More Maven Dependencies
- Go to [MVN Repository](https://mvnrepository.com/)
- Search for [Spring Dotenv](https://mvnrepository.com/artifact/me.paulschwarz/spring-dotenv)
- Insert this new dependency inside the `pom.xml` file and reload Maven.
```
<dependencies>
...
    <dependency>
        <groupId>me.paulschwarz</groupId>
        <artifactId>spring-dotenv</artifactId>
        <version>2.5.4</version>
    </dependency>
</dependencies>
```

# Connect to MongoDB
- When you connect to cluster, at the MongoDB Compass download page, you can see the connection string, which starts with`mongodb+srv://`
- Create a `.env` file to store these sensitive information.
- Put the following inside the `application.properties` file
```
spring.data.mongodb.database=${env.MONGO_DATABASE}
spring.data.mongodb.uri=mongodb+srv://${env.MONGO_USER}:${env.MONGO_PASSWORD}@${env.MONGO_CLUSTER}

```
- Add `.env` inside `.gitignore`


# Create Spring Data MongoDB Entities

- `Kpop.java` and `Review.java`
- Make Controller, Repository, and Service java files for these two entities.
- The Controller is only concerned about getting a request from the user and returning a response.
- The Service class contains the business logic of application.
- The Repository class talks to the database and get the data back.
- Any REST API should return proper status code
- Test it in the terminal `curl -i http://localhost:8080/api/v1/kpop` and it should return the following information.
```
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 04 Dec 2023 04:23:58 GMT
...
```





