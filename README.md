# HRMS
Implementation for the HRMS for iterations 5 &amp; 6




How to install Dev environment:
------------------------------------------------------------------------------------------------------------------------------------------
1. Install Eclipse JEE https://www.eclipse.org/downloads/packages/release/2019-09/r/eclipse-ide-enterprise-java-developers
2. Install Java JDK 8 https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
3. Clone repo to computer (remember path)
4. Open Eclipse for the first time, choose workspace folder as the same path you saved your repo in. HRMS project should appear in the  explorer.
5. Click Servers tab at the bottom. Click Add new server.
6. In Apache folder, select Tomcat V9.0 Server from the list.
7. Next to server runtime environment click "add..."
8. For Tomcat installation directory, browse and select the "apache-tomcat-9.0.29" folder as the target. Use default workbench JRE (should be 1.8.X_XXX format).
9. Click Next
10. Double click HRMS project in the Available panel to move it to Configured panel
11. Click Finish.
12. To run application, right click Tomcat v9.0 Server at localhost and click start. Open any browser and visit localhost:8080/root/index.html to test if server works
