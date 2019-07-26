<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elimina studente</title>
</head>
<body>
	<%		Amministratori admin = (Amministratori) session.getAttribute("admin");
	ArrayList<Studenti> arrayStud = (ArrayList)request.getAttribute("arrayStud");
		if (admin == null) {
	%>
	<h3>Non sei loggato, effettua il login!</h3>
	<a href="/Universita/index.jsp">Torna al menu</a>
	<%
		} else {
	%>
	<div align="center" valign="middle">
	<form action="studenti?y=3" method="post">
		<h2 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Seleziona studente da eliminare:
			</b> <br> <select name="CodStudente"><option></option>
					<%
						for (Studenti s : arrayStud) {
					%>
					<option value="<%=s.getCodStudente()%>"><%="|Nome: "+s.getNome() + " | " +"Cognome: "+s.getCognome()+"|"%></option>
					<%
						}
					%></select></span>
		</h2>
		<input type="submit" value="Elimina studente">
	</form>
	<a href="admin?x=2">Torna alla gestione studenti</a>
</div>
	<%
		}
	%>
</body>
</html>