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


# Details

The data source file is located at `server/src/main/resources/json/lancamento-conta-legado.json`. It represents the legacy data source location. The file follows the structure below:

```json
[
  {
    "id": 111,
    "agency": "001",
    "number": "0234859",
    "digit": "9",
    "client": {
      "name": "Joe Jackson",
      "id": "165"
    },
    "statements": [
      {
        "id": 82354,
        "date": "2018-05-28",
        "operation": "Pagamento de boleto",
        "value": -200.0,
        "balance": 2000.0
      },
      ...
    ]
  },
  ...
]
```

### Entities

#### Account
**Description:** represents a bank acocunt.
**Attributes:** 
- ID: an identifier for the account.
- Agency: the agency number.
- Number: the account number.
- Digit: the account digit.
- Client: the client this account belongs to.
- Statements: a list of statements made in this account.


#### Client
**Description:** represents a bank client.
**Attributes:** 
- ID: an identifier for the client.
- Name: the client's name.


#### Statement
**Description:** represents a bank acocunt statement.
**Attributes:** 
- ID: an identifier for the statement.
- Date: the exact date the statement was made.
- Operation: an descriptive text that informs what was made in that statement.
- Value: the amount of money that was added or subtracted.
- Balance: the total amount of the account after the statement.
