# Build

```
mvn clean install
```

# Run

```
java -jar target/spring-value-uri-template-1.0-SNAPSHOT.jar
```

Observe the log output `Expanded URI: http://localhost/PATH?queryParam=QUERY` with replaced URI
parameters compared to the template `http://localhost/{pathParam}?queryParam={queryParam}` found
in `application.yaml`.