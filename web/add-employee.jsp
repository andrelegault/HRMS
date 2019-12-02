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
        <h2 class="work-heading">Add employee</h2>
      </div>
      <div class="collection-list-wrapper w-dyn-list">
        <div class="collection-wrap w-dyn-items">
          <div class="blog-preview-wrap w-dyn-item">
		<%
			if (request.getAttribute("error") != null) {
				out.println("<p style='color: red'>Error adding employee!</p>");
			} else if (request.getAttribute("success") != null) {
				out.println("<p style='color: green'>Employee added!</p>");
			} else if (request.getAttribute("format") != null) {
				out.println("<p style='color: red'>Invalid input format!</p>");
			}
		%>
            <form action="add-employee" method="POST">
		<label>ID :</label>
		<input type="number" name="id" placeholder="1" class="hrms-input" required />
		<label>First Name :</label>
		<input type="text" name="first" placeholder="John" class="hrms-input" required />
		<label>Last Name :</label>
		<input type="text" name="last" placeholder="Doe" class="hrms-input" required />
		<label>Date of birth :</label>
		<input type="text" name="dob" placeholder="YYYY-MM-DD" class="hrms-input" required />
		<label>Role :</label>
		<input type="text" name="role" placeholder="Developer" class="hrms-input" required />
		<label>Address :</label>
		<input type="text" name="address" placeholder="1 King st." class="hrms-input" required />
		<label>Email :</label>
		<input type="email" name="email" placeholder="johndoe@does.com" class="hrms-input" required />
		<label>Phone :</label>
		<input type="tel" name="phone" placeholder="5141234567" class="hrms-input" required />
		<label>Icon :</label>
		<input type="text" name="icon" placeholder="icon url" class="hrms-input" />
		<label>Details :</label>
		<input type="text" name="details" placeholder="Extra details" class="hrms-input" />
		<input type="submit" class="button cc-contact-us hrms-submit-btn"/>
	    </form>
          </div>
        </div>
      </div>
  </div>
  <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.4.1.min.220afd743d.js" type="text/javascript" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
  <script src="js/general.js" type="text/javascript"></script>
  <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>
