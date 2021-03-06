# MQ-Web-Client

MQ-Web-Client is a service you can simulate communication to a IBM MQ Queue

## Installation

1. Checkout the repository to your machine.


## Usage - Development Environment
1. Access the repository folder
2. Open the folder mq-stack and execute the command below:<br />
   -> docker-compose up -d
3. Back to the repository root folder
4. Open the folder mq-web-client-app and execute the command below:<br />
   -> mvn clean install -DskipTests
5. To start the service run the command below:<br />
   -> java -jar -Dspring.profiles.active=dev ./target/mq-web-client-app-0.0.1-SNAPSHOT.jar

## Usage - Production Environment
1. Access the repository folder
2. Open the folder mq-web-client-app and execute the command below:<br />
   -> mvn clean install -DskipTests
3. To start the service run the command below: <br />
   -> java -jar -Dspring.profiles.active=prod ./target/mq-web-client-app-0.0.1-SNAPSHOT.jar

## Environment Variables
User and password are not used in dev profile, as the MQ dev it is not mandatory to set it.
1. MQ_QUEUEMANAGER - Queue manager
2. MQ_CHANNEL - Queue Channel
3. MQ_CONN_NAME - Connection String - E.g.: 192.168.0.17(1414)
4. MQ_USERNAME - User name
5. MQ_PASSWORD - User password
6. MQ_QUEUE - Queue id

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License
[MIT](https://choosealicense.com/licenses/mit/)

## Dependencies
- Docker
- Docker-compose
