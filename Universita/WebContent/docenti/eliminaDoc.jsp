<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elimina docente</title>
</head>
<body>
	<%		Amministratori admin = (Amministratori) session.getAttribute("admin");
		if (admin == null) {
	%>
	<h3>Non sei loggato, effettua il login!</h3>
	<a href="/Universita/index.jsp">Torna al menu</a>
	<%
		} else {
			ArrayList<Docenti> arrayDoc = (ArrayList)request.getAttribute("arrayDoc");
	%>
	<div align="center" valign="middle">
	<form action="docenti?y=3" method="post">
		<h2 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Seleziona docente da eliminare:
			</b> <br>
			<select name="CodDocente"><option></option>
						<%
							for (Docenti d : arrayDoc) {
						%>
						<option value="<%=d.getCodDocente()%>"><%=+d.getCodDocente()+" | "+ d.getNome()+" | "+ d.getCognome()%></option>
						<%
							}
						%></select></span>
		</h2>
		<input type="submit" value="Elimina docente">
	</form>
	<a href="admin?x=4">Torna alla gestione docenti</a>
</div>

	<%
		}
	%>
</body>
</html>