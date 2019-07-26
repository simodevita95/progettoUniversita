<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu amministratore</title>
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
		<span style="color: #A52A2A;"><b>Benvenuto ${admin.getNome() } !</b></span>
	</h2>
	<p style="text-align: center;"><span style="color:#A52A2A;"><img src="https://mobile-cdn.123rf.com/300wm/valentint/valentint1601/valentint160104114/50939659-icono-de-administrador-bot%C3%B3n-de-internet-sobre-fondo-blanco-.jpg?ver=6" style="width: 300px; height: 300px;" /></span></p>
			<h3 style="text-align: center;">
			<a href="admin?x=2"><span style="color: #000000;"><b>Gestione studenti</b></span></a>
		</h3>

		<h3 style="text-align: center;">
			<a href="admin?x=3"><span style="color: #000000;"><b>Gestione esami</b></span></a>
		</h3>
			<h3 style="text-align: center;">
			<a href="admin?x=4"><span style="color: #000000;"><b>Gestione docenti</b></span></a>
		</h3>
	
			<h5 style="text-align: center;">
			<a href="login?x=1"><span style="color: #000000;"><b>Effettua logout</b></span></a>
		</h5>
	<%
		}
	%>
</body>
</html>