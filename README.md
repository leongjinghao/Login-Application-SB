# I. Overview
Login Application developed with Spring Boot,

- Backend: Spring Boot
- Frontend: Thymeleaf
- ORM: Hibernate
- Database: MySQL
- Authentication & Authorisation: Spring Security

# II. Configuration
## application.properties
located in _Login-Application-SB\src\main\resources_

To configure:
- spring.datasource.url
- spring.datasource.username
- spring.datasource.password

\* Relevant tables are created automatically on initial build if datasource is configured correctly.

## User creation
![image](https://github.com/leongjinghao/Login-Application-SB/assets/73938217/e0892391-8b3c-4492-bffd-9f6c917caa90)

All user creation will be done primarily on the registration page, the backend API is required to encrypt and store the configured user password in the database.
- Registered user are given the default role of **"ROLE_USER"**
- To configure admin user, update or add user role through the ROLE table, set ROLE.Name to **"ROLE_ADMIN"**

# III. Accessibility
- Unauthenticated user: able to access index, login, and register page.
- Authenticated user (USER): able to access index, login, register, and home page.
- Authenticated user (ADMIN): able to access index, login, register, home, and dashboard page.
- Logging out: Authenticated user -> Unauthenticated user

## Authenticated User (USER) Home Page:
![image](https://github.com/leongjinghao/Login-Application-SB/assets/73938217/c0ff6034-4a26-4d88-83ab-e0bde0090b14)

## Authenticated User (ADMIN) Home Page:
![image](https://github.com/leongjinghao/Login-Application-SB/assets/73938217/8add02b1-4c40-4600-891f-d2b1e7d2926d)

## Dashboard Page:
![image](https://github.com/leongjinghao/Login-Application-SB/assets/73938217/2e178126-3a1c-4893-8e81-86de0033bfc9)

# IV. Multi Language/Translation Support
Language preference (persistent) is configurable on the top right corner of every page.

Language supported:
- English (Default)
- Chinese
![image](https://github.com/leongjinghao/Login-Application-SB/assets/73938217/f3a7a1ff-6d79-4aa9-969c-1e403c2caac2)
![image](https://github.com/leongjinghao/Login-Application-SB/assets/73938217/2eb1fea8-ba6f-4779-9b52-b97186dc3214)
