<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<script src="<c:url value="/resources/js/jqGrid/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/jqGrid/jquery.ui.min.js" />"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/humanity/jquery-ui.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.14.0/css/ui.jqgrid.min.css">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.14.0/jquery.jqgrid.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/js/welcome.js" />"></script>
<link href="<c:url value="/resources/css/welcome.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">

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
		<table id="list">

			<tr>

				<td />

			</tr>

		</table>
		<div id="pager"></div>

	</div>

	<script type="text/javascript">
		$(document).ready(
				function() {

					$("#list").jqGrid(
							{

								url : "ticketsDashboard",

								datatype : "json",

								mtype : 'POST',

								colNames : [ 'ID', 'Category', 'Sub Category',
										'Description', 'Subject', 'Status',
										'Comments' ],

								colModel : [ {

									name : 'ticketNo',

									index : 'ticketNo',

									width : 70

								}, {

									name : 'category',

									index : 'category',

									width : 100,

									editable : false

								}, {

									name : 'subCategory',

									index : 'subCategory',

									width : 100,

									editable : false

								}, {

									name : 'description',

									index : 'description',

									width : 550,

									editable : false

								}, {

									name : 'subject',

									index : 'subject',

									width : 150,

									editable : false

								},

								{
									name : 'status',

									index : 'status',

									width : 100,

									editable : false

								}, {
									name : 'comments',

									index : 'comments',

									width : 550,

									editable : false

								} ],

								pager : '#pager',

								rowNum : 10,

								height : 'auto',

								rowList : [ 10 ],

								sortname : 'invid',

								sortorder : 'desc',

								viewrecords : true,

								gridview : true,

								multiselect : true,

								multiboxonly : false,

								caption : 'Ticket Details',

								jsonReader : {

									repeatitems : false,

								}

							});

					jQuery("#list").jqGrid('navGrid', '#pager', {

						edit : false,

						add : false,

						del : false,

						search : false

					});

				});
	</script>
<br>
	<form action="createTicket">
	<div align="right">
	<div class="row" >
	<div class="col-sm-11" align="right">
	<button id="create ticket" type="submit" class="btn btn-info btn-lg">Create Ticket</button>
		</div></div></div>
	</form>
	
	<div id="result" class="footer"></div>
</body>
</html>