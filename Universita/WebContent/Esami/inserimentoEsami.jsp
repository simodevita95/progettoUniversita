<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento Esami</title>
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
			ArrayList<Docenti> arrayDoc = (ArrayList) request.getAttribute("arrayDoc");
	%>
	<form action="Esami?y=1" method="post">
		<h2 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Seleziona docente :</b> <br>
				<select name="codDocente"><option></option>
					<%
						for (Docenti d : arrayDoc) {
					%>
					<option value="<%=d.getCodDocente()%>"><%="|Nome: " + d.getNome() + " | " + "Cognome: " + d.getCognome() + "|"%></option>
					<%
						}
					%></select></span>
		</h2>
		<h4 style="text-align: center;">
			<span style="color: #000000;"><b>Inserisci data esame:<br>
					<input type="date" name="dataEsame"><br>
			</b></span>
		</h4>
		<p style="text-align: center;">
			<input type="submit" value="Inserisci esame">
		</p>
	</form>
	<div align="center">
		<a href="admin?x=3">Torna alla gestione esami</a>
	</div>
	<%
		}
	%>

</body>
</html>