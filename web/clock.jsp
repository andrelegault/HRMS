<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>HRMS</title>
  <meta content="width=device-width, initial-scale=1" name="viewport">
  <link href="/root/css/normalize.css" rel="stylesheet" type="text/css">
  <link href="/root/css/general.css" rel="stylesheet" type="text/css">
  <link href="/root/css/hrms-soen343.css" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.26/webfont.js" type="text/javascript"></script>
  <script type="text/javascript">WebFont.load({  google: {    families: ["Montserrat:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic"]  }});</script>
  <!-- [if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" type="text/javascript"></script><![endif] -->
  <script type="text/javascript">!function(o,c){var n=c.documentElement,t=" w-mod-";n.className+=t+"js",("ontouchstart"in o||o.DocumentTouch&&c instanceof DocumentTouch)&&(n.className+=t+"touch")}(window,document);</script>
</head>
<body>
  <%@include file="header.jsp" %>
  <div class="section">
  <div class="blog-heading">
        <h2 class="work-heading">Clock in/out</h2>
      </div>
      <div class="collection-list-wrapper w-dyn-list">
        <div class="collection-wrap w-dyn-items">
          <div class="blog-preview-wrap w-dyn-item">
          	<%
          		if (request.getAttribute("error") != null) {
          			out.println("<p style='color: red'>Error clocking!</p>");
          		} else if (request.getAttribute("clockIn") != null) {
          			out.println("<p style='color: green'>Successfully clocked in!</p>");
          		} else if (request.getAttribute("clockOut") != null) {
          			out.println("<p style='color: green'>Successfully clocked out!</p>");
          		}
          	%>
          	${ date }
            <form action="clock" method="POST">
    			<label>Employee Code :</label>
    			<input type="number" name="id" placeholder="1" class="hrms-input" required />
    			<input type="submit" name="clock" value="clockIn" text="Clock In" class="button cc-contact-us hrms-submit-btn"/>
    			<input type="submit" name="clock" value="clockOut" text="Clock Out" class="button cc-contact-us hrms-submit-btn"/>
   			</form>
          </div>
        </div>
      </div>
  </div>
  <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.4.1.min.220afd743d.js" type="text/javascript" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
  <script src="/root/js/general.js" type="text/javascript"></script>
  <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>