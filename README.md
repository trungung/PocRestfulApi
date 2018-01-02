# PocRestfulApi
Spring boot Restful api practice

## How to Setup

### Running a database
- Install MySQL database
- Configure your Spring properties accordingly in `src/main/resources/application-*.yml` files (for example your database URL, login and password).

## Profiles
Application has two maven profiles:
- `dev`: using on local, develop environment. It focuses on ease of development and productivity.
- `prod`: using on production environment.

Application will use the dev profile for default.

## Profiles switches
Application has two additional profiles used as switches:

- `swagger` to enable swagger for the api document.

These can be used along with both the dev and prod profiles.

## Running application

### In Docker environment

TODO
