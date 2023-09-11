# kafkaApplication

This is a sample project demonstrating how to use Spring Boot and Kafka to send messages to a Kafka topic.

## Prerequisites

Before running this project, make sure you have the following prerequisites installed:

- Java JDK 8 or higher
- Apache Kafka (must be up and running)

## Configuration

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/ceguro/kafkaApplication.git

- Open the project in your preferred IDE.

- Ensure that you configure Kafka properties in application.properties based on your setup.

##  Execution
To run the application, use your IDE or run the following command from the command line:

./mvnw spring-boot:run

##  Usage
Once the application is up and running, you can send messages via the REST API. Use the following endpoint to send a message

POST /message

{
  "message": "Your message here"
}


