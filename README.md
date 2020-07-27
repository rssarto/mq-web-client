# MQ-Web-Client

MQ-Web-Client is a service you can simulate communication to a IBM MQ Queue

## Installation

1. Checkout the repository to your machine.


## Usage - Development Environment
1. Access the repository folder
2. Open the folder mq-stack and execute the command below:
   -> docker-compose up -d
3. Back to the repository root folder
4. Open the folder mq-web-client-app and execute the command below:
   -> mvn clean install -DskipTests
5. To start the service run the command below
   -> java -jar -Dspring.profiles.active=dev ./target/mq-web-client-app-0.0.1-SNAPSHOT.jar

## Usage - Production Environment
1. Access the repository folder
2. Open the folder mq-web-client-app and execute the command below:
   -> mvn clean install -DskipTests
3. To start the service run the command below
   -> java -jar -Dspring.profiles.active=prod ./target/mq-web-client-app-0.0.1-SNAPSHOT.jar


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License
[MIT](https://choosealicense.com/licenses/mit/)

## Dependencies
- Docker
- Docker-compose
