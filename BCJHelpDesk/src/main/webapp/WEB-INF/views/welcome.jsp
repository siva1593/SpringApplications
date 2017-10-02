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

<script src="<c:url value="/resources/js/welcome.js" />"></script>
<link href="<c:url value="/resources/css/welcome.css" />"
	rel="stylesheet">

</head>

<body>
	<div id="c101" class="jumbotron text-center">
		<h2>Welcome to BCJ Help Desk</h2>
	</div>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Menu Items -->
			<div>
				<div class="navbar-header">
					<a class="navbar-brand "><b>Boot Camp Java</b></a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active" data-toggle="tab" data-target="#myHome"><a
						href="#" title="Home">Home</a></li>
					<li data-toggle="tab" data-target="#myTickets"><a href="#">Tickets</a></li>
					<li data-toggle="tab" data-target="#About"><a href="#">About</a></li>
					<li data-toggle="tab" data-target="#Contact"><a href="#">Contact</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li data-toggle="modal" data-target="#signup"><a href="#"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li data-toggle="modal" data-target="#login"><a href="#"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</ul>


				<!-- Signup -->

				<form action="signup" method="POST">
					<div id="signup" class="modal fade" role="dialog">
						<div class="modal-dialog">
							<!--Modal Content-->

							<div class="modal-content">

								<div id="signupcolor" class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title" style="align: center;">Sign up</h4>
								</div>

								<div class="modal-body">
									<div class="bg1">
										<p align="center">
											<b><i>User Details</i></b>
										</p>
										<div class="form-group">
											<label for="firstname">First Name:</label> <input type="text"
												class="form-control" id="signupinputcolor"
												placeholder="Enter firstname" name="firstName">
										</div>
										<div class="form-group">
											<label for="lastname">Last Name:</label> <input type="text"
												class="form-control" id="signupinputcolor"
												placeholder="Enter firstname" name="lastName">
										</div>
										<div class="form-group">
											<label for="email">Email:</label> <input type="text"
												class="form-control" id="signupinputcolor"
												placeholder="Enter Email" name="email">
										</div>
										<div class="form-group">
											<label for="phone">Phone:</label> <input type="text"
												class="form-control" id="signupinputcolor"
												placeholder="Enter Phone Number" name="phone">
										</div>
										<hr>
										<p align="center">
											<b><i>Address</i></b>
										</p>
										<div class="form-group">
											<label for="addressline1">Address Line 1:</label> <input
												type="text" class="form-control" id="signupinputcolor"
												placeholder="Enter addressline1" name="address.addressLine1">
										</div>
										<div class="form-group">
											<label for="addressline2">Address Line 2:</label> <input
												id="signupinputcolor" type="text" class="form-control"
												placeholder="Enter addressline2" name="address.addressLine2">
										</div>
										<div class="form-group">
											<label for="city">City:</label> <input id="signupinputcolor"
												type="text" class="form-control" placeholder="Enter city"
												name="address.city">
										</div>
										<div class="form-group">
											<label for="state" class="control-label">State:</label>
											<div>
												<select class="form-control" id="state" name="address.state"
													style="background-color: rgb(230, 245, 255)">
												</select>
											</div>
											<!-- r-->
										</div>
										<div class="form-group">
											<label for="zip">Zip Code:</label> <input
												id="signupinputcolor" type="text" class="form-control"
												placeholder="Enter Zip Code" name="address.zipCode">
										</div>
										<hr>
										<p align="center">
											<b><i>Login Details</i></b>
										</p>
										<div class="form-group">
											<label for="email">Email:</label> <input type="email"
												class="form-control" id="signupinputcolor"
												placeholder="Enter email" name="login.email">
										</div>
										<div class="form-group">
											<label for="pwd">Password:</label> <input type="password"
												class="form-control" id="signupinputcolor"
												placeholder="Enter password" name="login.password">
										</div>
										<div class="form-group">
											<label for="userType">User Type:</label>
											<div>
												<select class="form-control" id="userType"
													name="login.userType"
													style="background-color: rgb(230, 245, 255)">
												</select>
											</div>
										</div>
										<div class="modal-footer" id="signupcolor">
											<button type="submit" class="btn btn-default"
												style="background-color: rgb(51, 173, 255)">
												<b>sign up</b>
											</button>
										</div>

									</div>
								</div>


							</div>
						</div>
					</div>
				</form>
				<form action="login" method="POST">

					<div id="login" class="modal fade" role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header" id="logincolor">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Login</h4>
								</div>
								<div class="modal-body bg4">
									<div class="form-group">
										<label for="email">Email:</label> <input type="email"
											class="form-control" id="logininputcolor"
											placeholder="Enter email" name="login.email">
									</div>
									<div class="form-group">
										<label for="pwd">Password:</label> <input type="password"
											class="form-control" id="logininputcolor"
											placeholder="Enter password" name="login.password"
											style="background-color: rgb(255, 255, 230)">
									</div>

									<div class="modal-footer" id="logincolor">
										<button type="submit" class="btn btn-default">
											<b>login</b>
										</button>
									</div>

								</div>
							</div>
						</div>
					</div>
				</form>

			</div>
		</div>
	</nav>

	<div class="tab-content">
		<div id="myHome" class="container tab-pane fade in active"
			align="center" >
			<h4>Learn about issues, file a complaint or check your complaint
				status.</h4>
			<h4>Please sign in</h4>
		</div>

		<div id="myTickets" class="container tab-pane fade" align="center">
			<h4>Please signin to view or manage tickets</h4>

		</div>

		<div id="Contact" class="container tab-pane fade" align="center">
			<p>
				You can contact us directly at <a
					href="http://ekthasol.com/contact.html">http://ekthasol.com/contact.html</a><br>

				Read more: <a href="http://ekthasol.com/">http://ekthasol.com/</a>
			</p>

		</div>

		<div id="About" class="container tab-pane fade" align="center">
			<h4>Ektha Solutions Inc. is one of the fastest growing companies
				that provide quality IT consulting services and innovative solutions
				to our customers. It is headquartered in Texas (United States) and
				continues to provide experienced explosive growth year after year to
				its loyal clients all across the United States of America.</h4>

		</div>

	</div>

	<div id="message">
		<h5>${message}</h5>
	</div>
	<div id="result" class="footer"></div>
</body>
</html>