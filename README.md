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
You can run the app with the provided .war file by simply putting it in your apache server's `webapps` directory.
```bash
cp target/HRMS-JPA-JSF.war <apache-installation>/webapps/
```

### Build ###
To build the app you need maven:
```bash
mvn install
```

To populate the database:
```bash
mysql -u<username> -p<password> < init.sql
```

Go to http://localhost:8080/HRMS-JPA-JSF/
