<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>HRMS</title>
  <meta content="width=device-width, initial-scale=1" name="viewport">
  <link href="css/normalize.css" rel="stylesheet" type="text/css">
  <link href="css/general.css" rel="stylesheet" type="text/css">
  <link href="css/hrms-soen343.css" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.26/webfont.js" type="text/javascript"></script>
  <script type="text/javascript">WebFont.load({  google: {    families: ["Montserrat:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic"]  }});</script>
  <!-- [if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" type="text/javascript"></script><![endif] -->
  <script type="text/javascript">!function(o,c){var n=c.documentElement,t=" w-mod-";n.className+=t+"js",("ontouchstart"in o||o.DocumentTouch&&c instanceof DocumentTouch)&&(n.className+=t+"touch")}(window,document);</script>
</head>
<body>
  <%@include file="header.jsp" %>
  <div class="section">
  <div class="blog-heading">
    <h2 class="work-heading">Employee information</h2>
  </div>
  	<table class="hrms-table">
	  <tr>
	    <th>ID</th>
	    <th>First Name</th>
	    <th>Last Name</th>
	    <th>DOB</th>
	    <th>Role</th>
	    <th>Address</th>
	    <th>Email</th>
	    <th>Phone</th>
	    <th>Created At</th>
	    <th>Last Sign In</th>
	    <th>Icon</th>
	    <th>Details</th>
	  </tr>
	  <%
        ArrayList<ArrayList<String>> employees = (ArrayList<ArrayList<String>>)request.getAttribute("employees");
	  
	    for (ArrayList<String> row : employees) { // every employee in db
	    	out.println("<tr>");
			for (String elem : row) { // every property of that employee
		    	out.println("<td>" + elem + "</td>");
			}
			out.println("</tr>");
	    }
	  %>
	</table>   
  </div>
  <div class="section">
    <div class="blog-heading">
	  <h2 class="work-heading">Employee Attendance</h2>
	</div>
	
  	<table class="hrms-table">
	  <tr>
	  	<th>ID</th>
	    <th>First Name</th>
	    <th>Last Name</th>
	    <th>Clock in</th>
	    <th>Clock out</th>
	    <th>Date</th>
	  </tr>
	  <%
        ArrayList<ArrayList<String>> attendances = (ArrayList<ArrayList<String>>)request.getAttribute("attendances");
	  
	    for (ArrayList<String> row : attendances) { // every employee in db
	    	out.println("<tr>");
			for (String elem : row) { // every shift of that employee
		    	out.println("<td>" + elem + "</td>");
			}
			out.println("</tr>");
	    }
	  %>
	</table>   
  </div>
  <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.4.1.min.220afd743d.js" type="text/javascript" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
  <script src="js/general.js" type="text/javascript"></script>
  <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>