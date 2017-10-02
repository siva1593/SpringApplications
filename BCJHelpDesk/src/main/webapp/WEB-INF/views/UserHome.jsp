<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>BCJ-HelpDesk</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- let's add tag srping:url -->

<spring:url value="/resources/js/login.js" var="loginJS" />
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<script src="${loginJS}"></script>
<!-- Finish adding tags -->
</head>

<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Menu Items -->
			<div class="navbar-header">
				<a class="navbar-brand "><b>Boot Camp Java</b></a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="userHome" title="Home">Home</a></li>
				<li><a id="ticketHandler" href="ticketHandler">Tickets</a></li>
				<li data-toggle="tab" data-target="#Contact"><a href="#">Contact</a></li>
			</ul>
			<!-- Sign Out -->
			<ul class="nav navbar-nav navbar-right">
				<li data-toggle="modal" data-target="#logout"><a href="logout"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</ul>
		</div>
	</nav>

	<div id="Contact" class="container tab-pane fade" align="center"
		style="color: #000000;">
		<p>
			You can contact us directly at <a
				href="http://ekthasol.com/contact.html">http://ekthasol.com/contact.html</a><br>

			Read more: <a href="http://ekthasol.com/">http://ekthasol.com/</a>
		</p>

	</div>

	<div align="center">
		<h4><b>Welcome ${user.firstName}</b></h4>
	</div>

	<div id="message">
		<h5>${message}</h5>
	</div>
	<div id="result" class="footer"></div>
</body>
</html>