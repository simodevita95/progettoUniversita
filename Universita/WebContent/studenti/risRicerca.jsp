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
	<h1 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Risultato ricerca studente</b></span>
		</h1>
		<div align="center" valign="middle">
	<table border="1">
		<tr>
			<td>Matricola</td>
			<td>Nome</td>
			<td>Cognome</td>
			<td>Username</td>
		</tr>
		<tr>
			<td>${studente.getCodStudente() }</td>
			<td>${studente.getNome() }</td>
			<td>${studente.getCognome() }</td>
			<td>${studente.getUser() }</td>
		</tr>
	</table>
		<a href="admin?x=2">Torna alla gestione studenti</a>
	</div>
	<%
		}
	%>

</body>
</html>