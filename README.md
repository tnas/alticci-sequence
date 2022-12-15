# Altice Labs Technical Exercise

## Table of contents
* [Description - In Portuguese](#description)
* [Tech Stack](#tech-stack)
* [Implementation](#implementation)
* [Run Locally](#run-locally)
* [Containerization](#containerization)
* [API Documentation](#api-documentation)

## Description

Deverá ser implementado um serviço REST utilizando uma framework JAVA que devolve um
valor da sequência **Alticci**.

Opcionalmente poderá ser implementado um GUI web simples em JavaScript para consultar o
serviço.

A sequência Alticci - a(n) - é definida da seguinte forma:

n=0 => a(0) = 0<br>
n=1 => a(1) = 1<br>
n=2 => a(2) = 1<br>
n>2 => a(n) = a(n-3) + a(n-2)

Exemplo dos primeiros valores da sequência:

0<br>
1<br>
1<br>
1<br>
2<br>
2<br>
3<br>
4<br>
5<br>
7<br>
9<br>
[…]

O endpoint a criar será da forma `<baseurl>/alticci/{n}` em que o `{n}` representa o
índice da sequência para o qual pretendemos obter o valor.

O serviço implementado deverá tirar partido de cálculos passados para acelerar cálculos
futuros (caching).

Resposta deverá incluir:

- Código fonte
- Documentação das APIs ReST – formato Open API (Swagger)
- Instruções para execução (em containers ou outra)

Caso existam dúvidas em relação a qualquer ponto que possa influenciar a implementação, o
candidato deverá tomar decisões e avançar de acordo com os pressupostos assumidos (que
devem ser incluídos na resposta ao exercício).

## Tech Stack

- JDK 17
- Spring Boot 2.7.6 (Java framework)
- Maven 3.6.3
- Swagger 2
- Angular 14
- Junit 5 (Unit tests)
- Docker 20.10.21

## Implementation

The API computes the Alticci sequence up to the limit of **1000 elements**.

## Run Locally

To **run the application locally**, execute both the front-end (SPA application) and back-end (Restful API).

### Restful API

In the `backend` folder, run the command `mvn install` to build the application.
Such a command also prepares the application for the containerization.

In the `backend/target` folder, execute the command `java -jar alticci-0.0.1-SNAPSHOT.jar` to run the API on port `8080`.

### Single Page Application

In the `frontend` folder, execute the command `ng serve --open` to run the application.

To build the application in preparation for containerization, run the command
`ng build --configuration=production`.

## Containerization

The application can be run in three ways.

### Docker

A `Dockerfile` was created for each application part - back-end and front-end. A bash script has been prepared to facilitate the Docker image building and container creation. 

Inside each application folder (`backend` and `frontend`), run the script through the `./docker_build_run.sh` command.

**Note 1:** You must give execution permission to the bash script.
For this, run the command `chmod +x docker_build_run.sh`.

**Note 2:** The application build is not part of the Docker image building and container creation phases. It means that, **before run** `docker` or `docker-compose` commands, both applications must be built. In other words, the Restful API `.jar` file must be generated, as well as the SPA static files. 

### Docker Compose

Another way to run the application is using the `docker-compose.yml` file available in the root folder of the project. In that 
folder run the command `docker-compose up`. Once both containers are running, access the application via the URL
[http://localhost:8000](http://localhost:8000).

### Docker Hub

The simplest way to have the application running on localhost is using the Docker images
available on the Docker Hub. Again, the Docker Compose can be used for this.

In the `dockerhub` folder, just run the `docker-compose up` command.

**Note:** This way to run the application eliminates the need to build
the back-end (`.jar`file) and the front-end (SPA static files) locally.

### API Documentation

The Restful API has been documented following the Open API
standard. The Swagger was employed for such documentation.
It is available at [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/).
