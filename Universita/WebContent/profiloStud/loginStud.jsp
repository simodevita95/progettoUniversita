<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login studenti</title>
</head>
<body>
<h1 style="text-align: center;">
		<span style="color: #0000CD;"><strong>PROGETTO
				UNIVERSITA&#39; ATS</strong></span>
	</h1>
	<h2 style="text-align: center;">
		<span style="color: #A52A2A;"><b>Effettua l'accesso come studente</b></span>
	</h2>
	<form method="post" action="login?y=2">
		<h4 style="text-align: center;">
			<span style="color: #000000;"><b>Inserisci username:<br><input type="text" name="username"><br>
				</b></span>
		</h4>
		<h4 style="text-align: center;">
			<span style="color: #000000;"><b>Inserisci password:<br><input type="password" name="password"><br>
		</b></span></h4>
		<p style="text-align: center;"><input type="submit" value="Accedi"></p>
	</form>
	<div align="center" valign="middle">
   <a href="studenti?x=8">Non hai un account? Registrati</a>
   </div>
</body>
</html>