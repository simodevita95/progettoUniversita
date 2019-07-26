<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Studenti</title>
</head>
<body>
	<%
		Amministratori admin = (Amministratori) session.getAttribute("admin");
		ArrayList<Studenti> arrayStud = (ArrayList) request.getAttribute("arrayStud");
		if (admin == null) {
	%>
	<h3>Non sei loggato, effettua il login!</h3>
	<a href="/Universita/index.jsp">Torna al menu</a>
	<%
		} else {
	%>
	<form action="studenti?y=2" method="post">
		<h2 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Seleziona studente da
					modificare:</b> <br>
			<select name="codStudente"><option></option>
					<%
						for (Studenti s : arrayStud) {
					%>
					<option value="<%=s.getCodStudente()%>"><%="|Nome: "+s.getNome() + " | " +"Cognome: "+s.getCognome()+"|"%></option>
					<%
						}
					%></select></span>
		</h2>
		<h2 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Inserisci i nuovi dati</b></span>
		</h2>
		<h4 style="text-align: center;">
			<span style="color: #000000;"><b>Inserisci nome:<br>
					<input type="text" name="nome"><br>
			</b></span>
		</h4>
		<h4 style="text-align: center;">
			<span style="color: #000000;"><b>Inserisci cognome:<br>
					<input type="text" name="cognome"><br>
			</b></span>
		</h4>
		<h4 style="text-align: center;">
			<span style="color: #000000;"><b>Inserisci nuova password:<br>
					<input type="password" name="password"><br>
			</b></span>
		</h4>
		<p style="text-align: center;">
			<input type="submit" value="Modifica studente">
		</p>
	</form>
	<div align="center">
	<a href="admin?x=2">Torna alla gestione studenti</a>
	</div>
	<%
		}
	%>


</body>
</html>