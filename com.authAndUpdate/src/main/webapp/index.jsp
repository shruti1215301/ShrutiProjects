
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Login Page</title>
	<style>
		* {
			box-sizing: border-box;
			margin: 0;
			padding: 0;
		}

		body {
			height: 100vh;
			font-family: Arial, sans-serif;
			background-color: #F9F9F9;
		}

		.container {
			height: 100%;
			display: flex;
			justify-content: center;
			align-items: center;
			flex-direction: column;
			background: linear-gradient(to bottom right, #667eea, #764ba2);
		}

		form {
			padding: 20px;
			display: flex;
			justify-content: center;
			align-items: center;
			flex-direction: column;
			background-color: #FFF;
			border-radius: 5px;
			box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
		}

		h2 {
			margin-bottom: 20px;
			font-size: 28px;
			color: #555;
		}

		input[type="text"],
		input[type="password"] {
			width: 100%;
			padding: 12px 20px;
			margin: 8px 0;
			border: none;
			border-radius: 4px;
			background-color: #f2f2f2;
			font-size: 18px;
			color: #333;
		}

		button[type="submit"] {
			background-color: #667eea;
			color: #FFF;
			border-radius: 4px;
			padding: 12px 20px;
			border: none;
			cursor: pointer;
			font-size: 18px;
			margin-top: 20px;
			transition: background-color 0.3s ease-in-out;
		}

		button[type="submit"]:hover {
			background-color: #764ba2;
		}

		a {
			color: #555;
			font-size: 14px;
			margin-top: 10px;
			text-decoration: none;
			transition: color 0.3s ease-in-out;
		}

		a:hover {
			color: #764ba2;
		}

		p {
			margin-top: 25px;
			font-size: 16px;
			color: #555;
		}

		p a {
			color: #764ba2;
		}
	</style>
</head>
<body>
	<div class="container">
		<form action="loginCheck" method="post">
			<h2>Login</h2>
			<input type="text" placeholder="Enter the username" name="userName"> 
			<input type="password" placeholder="Enter the password" name="userPass">
			<div>
				<button type="submit">Login Now</button>
				<a href="#">Forgot password</a>
			</div>
			<p>
				First time user? <a href="#">Register now</a>
			</p>
		</form>
	</div>
</body>
</html>
