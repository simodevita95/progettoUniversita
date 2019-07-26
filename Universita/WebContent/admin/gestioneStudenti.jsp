<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione studenti</title>

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
			<span style="color: #A52A2A;"><b>Menu gestione studenti</b></span>
		</h2>
	<p style="text-align: center;"><span style="color:#A52A2A;"><img src="http://www.pieffecopy.it/wp-content/uploads/2014/06/Cappello_Laurea.jpg" style="width: 300px; height: 300px;" /></span></p>
			<h3 style="text-align: center;">
			<a href="studenti?x=2"><span style="color: #000000;"><b>Inserisci Studente</b></span></a>
		</h3>

		<h3 style="text-align: center;">
			<a href="studenti?x=3"><span style="color: #000000;"><b>Modifica Studente</b></span></a>
		</h3>
			<h3 style="text-align: center;">
			<a href="studenti?x=4"><span style="color: #000000;"><b>Ricerca Studente</b></span></a>
		</h3>
		<h3 style="text-align: center;">
			<a href="studenti?x=5"><span style="color: #000000;"><b>Lista Studente</b></span></a>
		</h3>
			<h3 style="text-align: center;">
			<a href="studenti?x=6"><span style="color: #000000;"><b>Elimina Studente</b></span></a>
		</h3>
				<h4 style="text-align: center;">
			<a href="admin?x=5"><span style="color: #000000;"><b>Torna al menu admin</b></span></a>
		</h4>
			<h5 style="text-align: center;">
			<a href="login?x=1"><span style="color: #000000;"><b>Effettua logout</b></span></a>
		</h5>
	<%
		}
	%>
</body>
</html>