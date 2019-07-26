
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento studenti</title>
</head>
<body>
	<%
		Amministratori admin = (Amministratori) session.getAttribute("admin");
		if (admin == null) {
	%>
	<h3>Non sei loggato, effettua il login!</h3>
	<a href="/Universita/index.jsp">Torna al menu</a>
	<%
		} else {
	%>
	<form action="studenti?y=1" method="post">
		<h2 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Inserisci dati studente</b></span>
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
				<input type="password" name="password"><br>
			</b></span>
		</h4>
		<p style="text-align: center;">
			<input type="submit" value="Inserisci studente">
		</p>
	</form>
	<div align="center">
	<a href="admin?x=2">Torna alla gestione studenti</a>
	</div>
	<%
		}
	%>

</body>
</html>