<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione studente</title>
</head>
<body>
<form action="studenti?y=5" method="post">
		<h2 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Inserisci i tuoi dati</b></span>
		</h2>
		<h4 style="text-align: center;">
			<span style="color: #000000;"><b>Inserisci nome:<br>
				<input type="text" name="nome"><br>
			</b></span>
		</h4>
		<h4 style="text-align: center;">
			<span style="color: #000000;"><b>Inserisci cognome:<br>
				<input type="text" name="cognome"><br>
			</b></span>
		</h4>
		<h4 style="text-align: center;">
			<span style="color: #000000;"><b>Inserisci username:<br>
				<input type="text" name="username"><br>
			</b></span>
		</h4>
		<h4 style="text-align: center;">
			<span style="color: #000000;"><b>Inserisci password:<br>
				<input type="text" name="password"><br>
			</b></span>
		</h4>
		<p style="text-align: center;">
			<input type="submit" value="Registrati">
		</p>
	</form>
</body>
</html>