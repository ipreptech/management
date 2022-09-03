# Management
Code for handling a small institute which have multiple students and course offerings.

# Setup
Export the following environment variables
1. DB_PASSWORD=\<Database Password>
2. DB_USERNAME=\<Database Username>
3. DB_URL=\<Database fully qualified url>
```
Ex: jdbc:mysql://\<Ip Address>:<DB_PORT>/<DB_NAME>?useSSL=false&serverTimeZone=UTC
```

# Running
1. Navigate to the code directory
2. Run `./mvnw spring-boot:run`