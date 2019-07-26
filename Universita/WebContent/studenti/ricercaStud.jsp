<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca studente</title>
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
	<div align="center" valign="middle">
	<form action="studenti?y=4" method="post">
	<h1 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Ricerca studente</b></span>
		</h1>
		<h4 style="text-align: center;">
			<span style="color: #000000;"><b>Inserisci matricola studente:<br>
					<input type="text" name="CodStudente"><br>
			</b></span>
		</h4>
		<p style="text-align: center;">
			<input type="submit" value="Ricerca studente">
		</p>
	</form>
		<a href="admin?x=2">Torna alla gestione studenti</a>
		</div>
	<%
		}
	%>
</body>
</html>