<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RisRicercaD</title>
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
			<td>Codice</td>
			<td>Nome</td>
			<td>Cognome</td>
			<td>Insegnamento</td>
		</tr>
		<tr>
			<td>${docente.getCodDocente() }</td>
			<td>${docente.getNome() }</td>
			<td>${docente.getCognome() }</td>
			<td>${docente.getInsegnamento() }</td>
		</tr>
	</table>
	<%
		}
	%>
	<div align="center">
		<a href="admin?x=4">Torna alla gestione docenti</a>
</div>
</body>
</html>