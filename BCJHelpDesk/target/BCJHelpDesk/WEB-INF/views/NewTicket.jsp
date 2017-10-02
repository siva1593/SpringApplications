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
<spring:url value="/resources/js/ticket.js" var="TicketJS" />
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<script src="${loginJS}"></script>
<script src="${TicketJS}"></script>
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

	<form action="submitTicket" method="post" class="form-horizontal">
		<div class="container">
			<div class="jumbotron">
				<h2>Ticket Details</h2>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="subject">Subject:</label>
				<div class="col-sm-7">
					<input class="form-control" id="subject" name="subject" type="text"
						placeholder="Subject" style="background-color: rgb(230, 245, 255)"
						required>
				</div>
			</div>

			<div class="form-group">
				<fieldset>
					<label class="control-label col-sm-2" for="Category">Category:</label>
					<div class="col-sm-3">
						<select class="form-control" id="category" name="category"
							style="background-color: rgb(230, 245, 255)"
							onchange="loadSubCategory()">
							<option>Select</option> ${ticketCategory}
						</select>
					</div>
				</fieldset>
			</div>

			<div class="form-group">
				<fieldset>
					<label class="control-label col-sm-2" for="subCategory">SubCategory:</label>
					<div class="col-sm-3">
						<select class="form-control" id="subCategory" name="subCategory"
							style="background-color: rgb(230, 245, 255)">
							<option>Select</option>
						</select>
					</div>
				</fieldset>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="description">Description:</label>
				<div class="col-sm-7">
					<textarea class="form-control" rows="5" id="Description"
						name="description" placeholder="Enter your text here.."
						style="background-color: rgb(230, 245, 255)" required></textarea>
				</div>
			</div>

			<div class="modal-footer">
				<button type="submit" class="btn btn-default">Submit</button>
				&nbsp;&nbsp;&nbsp;
			</div>

		</div>
	</form>
	<div id="result" class="footer"></div>
</body>
</html>