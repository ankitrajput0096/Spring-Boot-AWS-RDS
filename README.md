# Dockerized Spring boot application with PostgreSQL

Dockerized Spring Boot application with Dockerized postgreSQL server (JPA, Hibernate, PostgreSQL)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development purposes. See running for notes on how to run the project on a system.

### Prerequisites

1. Clone the project to your local environment:
    ```
    git clone https://github.com/ankitrajput0096/Dockerized_SpringBoot_PostgreSQL
    ```

2. You need maven installed on your environment:

    #### Mac (homebrew):
    
    ```
    brew install maven
    ```
    #### Ubuntu:
    ```
    sudo apt-get install maven
    ```

3. You need Docker to be installed:

    #### Windows:
    https://download.docker.com/win/stable/Docker%20for%20Windows%20Installer.exe
    
    #### Mac:
    https://download.docker.com/mac/stable/Docker.dmg
    
    #### Ubuntu:
    https://docs.docker.com/install/linux/docker-ce/ubuntu/

### Installing

Once you have maven and docker installed on your environment, install the project dependencies via:

```
mvn install
```

Build docker Image:

```
docker-compose build
```

Start docker:

```
docker-compose up
```

## Running

Start docker:
```
docker-compose up
```

Run the application from the `Application.java` main method directly,
or from a command line:
```
mvn spring-boot:run
```

Keep docker running in a separate terminal tab, create another tab to run the application.

Your server should be now running on http://localhost:8090

## Alternate way to start this application
1. Clone this repository
2. Bring up the application by just using docker-compose 
    ```
    sudo docker-compose -f my-docker-compose.yml up
    ```
    Your server should be now running on http://localhost:8090
3. Bring down the application 
    ```
    sudo docker-compose -f my-docker-compose.yml down
    ```
## Get an access to all exposed API's with Postman

1. Install Postman (https://www.getpostman.com)
2. Import Postman collection from the `Dockerized_SpringBoot_PostgreSQL.postman_collection.json` file
3. Enjoy !!

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Spring Boot 2
* [Maven](https://maven.apache.org/) - Dependency Management
* [Docker](https://www.docker.com/) - For containerization of application
* [PostgreSQL](https://www.postgresql.org/) - Database

## Contributing

If you have any improvement suggestions please create a pull request and I'll review it.


## Authors

* **Ankit Rajput** - *Initial work* - [Github](https://github.com/ankitrajput0096)

## License

This project is licensed under the MIT License

## Acknowledgments

* Big thanks to Pivotal for Spring Boot framework, love it!
