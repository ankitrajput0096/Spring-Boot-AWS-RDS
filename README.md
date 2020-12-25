# Integration of Spring boot application with AWS RDS

Dockerized Spring Boot application using AWS RDS Postgres DB.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development purposes. See running for notes on how to run the project on a system.

### Prerequisites

1. Clone the project to your local environment:
    ```
    git clone https://github.com/ankitrajput0096/Spring-Boot-AWS-RDS
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

### NOTE
Please create an AWS RDS Postgres DB first and then update the details of the postgres DB in docker-compose.yml file.
Properties you need to change are `POSTGRES_USER`, `POSTGRES_PASSWORD`, `POSTGRES_URL` and `POSTGRES_PORT`.

### Installing

Once you have maven and docker installed on your environment, install the project dependencies via:

```
mvn install
```

Build docker Image:

```
docker-compose build
```

## Running

Start docker:
```
docker-compose up
```

Or Run the application from the `Application.java` main method directly,
Or from a command line:
```
mvn spring-boot:run
```

Your server should be now running on http://localhost:8090

## Get access to all exposed API's with Postman

1. Install Postman (https://www.getpostman.com)
2. Import Postman collection from the `SpringBoot_PostgreSQL_AWS_RDS.postman_collection.json` file
3. Enjoy !!

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Spring Boot 2
* [Maven](https://maven.apache.org/) - Dependency Management
* [Docker](https://www.docker.com/) - For containerization of application

## Contributing

If you have any improvement suggestions please create a pull request and I'll review it.


## Authors

* **Ankit Rajput** - *Initial work* - [Github](https://github.com/ankitrajput0096)

## License

This project is licensed under the MIT License

## Acknowledgments

* Big thanks to Pivotal for Spring Boot framework, love it!
