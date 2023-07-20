<html>
<head>
<title>Yahoo!! from JSP</title>
</head>
<body>
	<p><font color="red">${errorMessage}</font></p>
	<form action="/login" method="POST">
		Name : <input type="text" name = "name" /> 
		Password: <input type = "password" name = "password">
		<input type="submit" />
	</form>

</body>
</html>