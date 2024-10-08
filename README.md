# Application Overview:

The Songify application is a Java-based application designed to keep track of melodious songs which shows
the title, type and length of the song. Application has another class which is the writer of these songs which are in 
our list. User can see the detail of writer who wrote this song and other details as well. 
This application is also manage on AWS RDS (Relational Database Service) where we store our database for 
reliability and for security purpose and to enhance the security of the application and data we use AWS cognito for 
the users to signin through cognito which save record of all users.
## Create Database in mysql
First we create our databse at MYSQL database through MySQL Workbench and create following tables
 1-Song
 2-Writer
-In song table we create attributes Like id, title, type and length of the song. 
-In writer table we create attributes Like id, name, date of birth and email. 
After that I deploy this database to AWS RDS for reliability, scalability, availability and for security 
purpose as well. CRUD Operation in this Java application we do CRUD (Create,Read,Update and Delete) operation of 
these two table and also all of these tables shown in EC2 instance.

To enhance scalability and reliability, we have deployed the application on Amazon EC2
(Elastic Compute Cloud) instnce and AWS Elastic Beanstalk.

### Deployment Architecture

#  1. Create a User Pool and User in Amazon Cognito.
 I create a user pool in AWS Cognito through AWS Management Console, navigate to Amazon Cognito, 
 and follow the instruction to create a user pool and within user pool create user client. Once all done, 
 make changes in my java application according to connect my application to with AWS Cognito Finally, 
 review and save all the configuration to finalize the setup.
# 2.Amazon EC2
Amazon EC2 provides resizable compute capacity in the cloud. It allows us to launch and manage virtual servers (instances) 
where our application runs. I choose EC2 to deploy my backend application, giving me full access and control over the server
environment, configurations, networking and infrastructure which will help me for troubleshooting, and easy integration with 
other AWS services.

# 3.AWS Elastic Beanstalk
Elastic Beanstalk is an AWS service where we can deploy our application without worrying about underlying infrastructure. 
That is why this service comes under platform-as-a-service (PaaS) that simplifies the deployment,
management, and scaling of applications. We utilize Elastic Beanstalk for deploying web application. Thsi advantage 
of this service is we do not need to worry about autoscaling and load balancing.

#### Challenges of Deploying a Application on both services:

 As we know Elastic Beanstalk abstracts much of the infrastructure, which limits your ability to customize 
 certain aspects of the environment (e.g., specific OS configurations, networking). We do not have full access 
 of infrastructure and configurations which is difficult to implement or require workarounds.
 Sometime Beanstalk abstracts much of the infrastructure, which can make diagnosing infrastructure-related issues harder.
 Troubleshooting performance issues or environmental problems might require more effort, as Beanstalk controls many aspects of the deployment.
 Application Logging and Monitoring.
## Logs and Troubleshooting

- If your application doesn't work as expected:
 1. Check cloudwatch Logs and cloudtrail logs for in the AWS Elastic Beanstalk console.
 2. Review error logs to identify issues with your application or database connection.
 3. Access logs from the Elastic Beanstalk Dashboard under the Logs section.

## Major Issue 

**SSL Error After Cognito Integration:** 
The application was not working when I deployed my application on EC2 instance. The application did not connect 
with the cognito after that I download nginx on my instance and amended it's configuration according to my application.
Change the port to 443 and also change the setting of my security group inbound rules to allow traffic through port 443.


#### Common Challenges Across Both Platforms:
Database and Service Integration:

Whether on EC2 or Elastic Beanstalk, integrating my Spring Boot application with external services e.g., Amazon RDS involves 
configuring connection properties, handling security and ensuring network connectivity.
 **Security Configuration:**

Ensuring proper security configurations for both your application and underlying infrastructure firewalls, 
access controls SSL is critical. VPC settings, and security group configurations need to be handled with 
care to avoid security risks.
