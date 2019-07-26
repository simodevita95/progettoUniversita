<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca esame</title>
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
	<form action="Esami?y=4" method="post">
		<table border="1">
			<tr>
				<td>Inserisci codice esame:</td>
				<td><input type="text" name="CodEsame"></td>
		</table>
		<input type="submit" value="Ricerca esame">
	</form>
		<div align="center">
		<a href="admin?x=3">Torna alla gestione esami</a>
	</div>
	<%
		}
	%>
</body>
</html>