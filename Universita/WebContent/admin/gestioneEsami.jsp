<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione esami</title>
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
			<span style="color: #A52A2A;"><b>Menu gestione Esami</b></span>
		</h2>
	<p style="text-align: center;"><span style="color:#A52A2A;"><img src="http://prints.ultracoloringpages.com/6b7b31da47e9f65b2660023ed8929c53.png" style="width: 300px; height: 300px;" /></span></p>
			<h3 style="text-align: center;">
			<a href="Esami?x=1"><span style="color: #000000;"><b>Inserisci Esame</b></span></a>
		</h3>

		<h3 style="text-align: center;">
			<a href="Esami?x=4"><span style="color: #000000;"><b>Modifica Esame</b></span></a>
		</h3>
			<h3 style="text-align: center;">
			<a href="Esami?x=5"><span style="color: #000000;"><b>Ricerca Esame</b></span></a>
		</h3>
		<h3 style="text-align: center;">
			<a href="Esami?x=3"><span style="color: #000000;"><b>Lista Esami</b></span></a>
		</h3>
			<h3 style="text-align: center;">
			<a href="Esami?x=2"><span style="color: #000000;"><b>Elimina Esame</b></span></a>
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