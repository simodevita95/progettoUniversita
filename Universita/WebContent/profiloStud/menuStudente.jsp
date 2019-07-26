<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu studente</title>
<style>
.dropbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
	cursor: pointer;
}

.dropdown {
	position: relative;
	display: inline-block;
	margin-top: 5%;
	margin-left: 25px;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #f1f1f1
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}
</style>
</head>
<body>
	<%
		Studenti stud = (Studenti) session.getAttribute("stud");
		if (stud == null) {
	%>
	<h3>Non sei loggato, effettua il login!</h3>
	<a href="/Universita/index.jsp">Torna al menu</a>
	<%
		} else {
	%>
	<div class="dropdown">
		<button class="dropbtn">${stud.getUser()}</button>
		<div class="dropdown-content">
			<p>Matricola: ${stud.getCodStudente()}</p> <p>Nome: ${stud.getNome()}</p> <p>Cognome: ${stud.getCognome()}</p>
		</div>
	</div>
	<p style="text-align: center;">
		<span style="color: #A52A2A;"><img
			src="http://www.altovicentino.net/alfstreaming-servlet/streamer/resourceId/5db9d04a-2019-4b7d-8d4d-f8bbbb70c598/studio"
			style="width: 300px; height: 300px;" /></span>
	</p>
	<h3 style="text-align: center;">
		<a href="prenotazioni?x=1"><span style="color: #000000;"><b>Prenota
					esame</b></span></a>
	</h3>

	<h3 style="text-align: center;">
		<a href="prenotazioni?x=2"><span style="color: #000000;"><b>Visualizza
					esami</b></span></a>
	</h3>
	<h3 style="text-align: center;">
		<a href="prenotazioni?x=3"><span style="color: #000000;"><b>Elimina
					prenotazione</b></span></a>
	</h3>

	<h5 style="text-align: center;">
		<a href="login?x=1"><span style="color: #000000;"><b>Effettua
					logout</b></span></a>
	</h5>
	<%
		}
	%>
</body>
</html>