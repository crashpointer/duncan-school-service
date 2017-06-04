<!DOCTYPE html>
<html lang="en">

<head>
<title>Spring Security Tutorial</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #eee;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
</head>

<body>
	<form action="/registration" method="POST" class="form-signin">
		<h2 class="form-signin-heading">Registration Form</h2>
		<label for="inputName" class="sr-only">Name</label> <input
			id="inputName" class="form-control" placeholder="Name"
			required="" autofocus="" type="text" name="name">
		<label for="inputLastName" class="sr-only">Name</label> <input
			id="inputLastName" class="form-control" placeholder="Last Name"
			required="" autofocus="" type="text" name="lastName">
		<label for="inputEmail" class="sr-only">Email address</label> <input
			id="inputEmail" class="form-control" placeholder="Email address"
			required="" type="email" name="email"> <label
			for="inputPassword" class="sr-only">Password</label> <input
			id="inputPassword" class="form-control" placeholder="Password"
			required="" type="password" name="password">
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
	</form>
</body>
</html>