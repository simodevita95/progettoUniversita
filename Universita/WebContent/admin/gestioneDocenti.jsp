<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione docenti</title>
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
	<h2 style="text-align: center;">
		<span style="color: #A52A2A;"><b>Menu gestione docenti</b></span>
	</h2>
	<p style="text-align: center;">
		<span style="color: #A52A2A;"><img
			src="http://docente.unife.it/allegati/teacher.gif"
			style="width: 300px; height: 300px;" /></span>
	</p>
	
	<h3 style="text-align: center;">
		<a href="docenti?x=1"><span style="color: #000000;"><b>Inserisci
					Docente </b></span></a>
	</h3>

	<h3 style="text-align: center;">
		<a href="docenti?x=2"><span style="color: #000000;"><b>Modifica
					Docente</b></span></a>
	</h3>
	<h3 style="text-align: center;">
		<a href="docenti?x=3"><span style="color: #000000;"><b>Ricerca
					Docente</b></span></a>
	</h3>
	<h3 style="text-align: center;">
		<a href="docenti?x=4"><span style="color: #000000;"><b>Lista
					Docenti</b></span></a>
	</h3>
	<h3 style="text-align: center;">
		<a href="docenti?x=5"><span style="color: #000000;"><b>Elimina
					Docente</b></span></a>
	</h3>
	<h4 style="text-align: center;">
		<a href="admin?x=5"><span style="color: #000000;"><b>Torna
					al menu admin</b></span></a>
	</h4>
	<h5 style="text-align: center;">
		<a href="login?x=1"><span style="color: #000000;"><b>Effettua
					logout</b></span></a>
	</h5>
	<%
		}
	%>
</body>
</html>