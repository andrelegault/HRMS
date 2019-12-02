# HRMS
Human Resources Management System solution by Team Sumas

## Introduction ##
This project showcases the main features of the HRMS solution provided as part of iterations 5 an
d 6 for SOEN 343.

The features include:
* Viewing employee attendance/information
* Clocking in/out
* Adding employees

## Usage ##
To run the app you need:
* An Apache Tomcat 9.0 server

### Installation ###
You can run the app with the provided in war file under *releases* by simply putting it in your apache tomcat server's `webapps` directory.
```bash
cp hrms-1.0.war <apache-installation>/webapps/
```

### Build ###
To build the app you need maven:
```bash
mvn install
```

Go to http://localhost:8080/hrms-1.0/
