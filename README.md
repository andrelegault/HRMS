# HRMS
Human Resources Management System solution by Team Sumas

## Introduction ##
This project showcases the main features of the HRMS solution provided as part of iterations 5 and 6 for SOEN 343.

The features include:
* Viewing employee attendance/information
* Clocking in/out
* Adding employees

## Usage ##
To run the app you need:
* A mysql server
* A tomcat server

### Installation ###
You can run the app with the provided .war file.

### Build ###
To build the app you need maven:
```bash
1. mvn install
2. cp target/HRMS-JPA-JSF.war <apache-installation>/webapps/
```

To populate the database:
```
1. mysql -u<username> -p<password> < init.sql
```

Go to http://localhost:8080/HRMS-JPA-JSF/
