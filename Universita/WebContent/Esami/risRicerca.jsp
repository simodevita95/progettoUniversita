<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RisRicerca</title>
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
	<table border="1">
		<tr>
			<td>Codice esame</td>
			<td>data esame</td>
			<td>codice docente</td>
		</tr>
		<tr>
			<td>${esame.getCodEsame()}</td>
			<td>${esame.getData()}</td>
			<td>${esame.getD().getCodDocente()}</td>
		</tr>
	</table>
	<%
		}
	%>
	<div align="center">
		<a href="admin?x=3">Torna alla gestione esami</a>
	</div>
</body>
</html>