<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca docente</title>
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
	<form action="docenti?y=4" method="post">
	<h1 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Ricerca docente</b></span>
		</h1>
	
<h4 style="text-align: center;">
			<span style="color: #000000;"><b>Inserisci codice docente:<br>
					<input type="text" name="CodDocente"><br>
			</b></span>
		</h4>
		<input type="submit" value="Ricerca docente">
	</form>
	<a href="admin?x=4">Torna alla gestione docenti</a>
		</div>
	<%
		}
	%>
</body>
</html>