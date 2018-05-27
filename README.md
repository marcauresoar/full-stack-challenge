# Full Stack Challenge

This applicatoin was built using an Spring Boot REST API and AngularJs clinet.

## Dependencies

Make sure you have the following softwares installed in your machine.

- JDK 8
- Maven
- npm

It's also necessary to install @angular/cli. You can do that with the following command:

```sh
npm install -g @angular/cli
```

## Build and run

First, you have to start the Spring Boot application. In the terminal, go to the `server/` directory and run the following command:

```sh
$ mvn spring-boot:run
```

Then your server will be up at `http://localhost:8080`.

After that, you need to start the client. In the terminal, go to the `client/` directory and run the following commands:

```sh
$ npm install
$ ng serve
```

Now your client should be running successfully at `http://localhost:4200`.
