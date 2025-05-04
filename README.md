# Application Overview:
Songify is a back-end Java-based application built to manage a personal or collaborative music collection lists in a secure and scalable way by using AWS cognito. The core idea is to
provide users with the ability to Create, Read, Update, and Delete (CRUD) song entries—such as title, song type and length —stored in a structured SQL database.
What makes Songify more than just a CRUD app is its focus on security and cloud integration. To ensure only authenticated users can access or modify song data, the
application uses AWS Cognito to handle user registration, login, and token-based authentication. This approach eliminates any kind of threat from the user mind about the
security eller data breach at any point of time.
This project serves as both a learning platform for cloud-native development and a practical solution for building secure, scalable Java applications with real-world tools and services.

## Create Database in mysql
First we create our databse at MYSQL database through MySQL Workbench and create following tables 1-Song 2-Writer -In song table we create attributes Like id,
title, type and length of the song. -In writer table we create attributes Like id, name, date of birth and email. We create tables in MySQL database and add values
through Postman. We do CRUD (Create,Read,Update and Delete) operation of these two table through Postman.

### Core Features
 Scalable Backend Architecture
Built using Spring Boot RESTful services, enabling future scalability and modular
enhancements.

 Secure API Endpoints
All API endpoints are protected with Spring Security.

 CRUD Operations on Songs
Authenticated users can add, view, edit, and delete songs from the database.

 MySQL Database Integration
All song data is persistently stored and managed through a MySQL database.

 Authentication via AWS Cognito
Users register and log in securely using Cognito’s hosted authentication system.

### Create a User Pool and User in Amazon Cognito.
I create a user pool in AWS Cognito through AWS Management Console, navigate to
Amazon Cognito, and follow the instruction to create a user pool and within user pool
create user client. Once all done, make changes in my java application according to
connect my application to with AWS Cognito Finally, review and save all the
configuration to finalize the setup.

### Challenges
Connecting AWS Cognito with Spring Boot was tricky at first. Even though users could log
in, the backend did not accept their tokens. We fixed this by setting up custom token validation
using Cognito’s public keys.
The other challenge is when we use Oauth dependencies application was not working
properly.
Another issue was that new users couldn’t log in right away because their accounts weren’t
confirmed.