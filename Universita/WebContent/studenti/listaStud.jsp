<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Studenti</title>
</head>
<body>
	<%
		Amministratori admin = (Amministratori) session.getAttribute("admin");
		ArrayList<Studenti> arrayStud = (ArrayList)request.getAttribute("arrayStud");
		if (admin == null) {
	%>
	<h3>Non sei loggato, effettua il login!</h3>
	<a href="/Universita/index.jsp">Torna al menu</a>
	<%
		} else {
	%>
		<h1 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Lista studenti</b></span>
		</h1>
<div align="center" valign="middle">
	<table border="1">
		<tr>
			<td>Matricola studente</td>
			<td>Nome studente</td>
			<td>Cognome studente</td>
			<td>Username studente</td>
			<%
				for (Studenti s : arrayStud) {
			%>
		
		<tr>
			<td><%=s.getCodStudente()%></td>
			<td><%=s.getNome()%></td>
			<td><%=s.getCognome()%></td>
			<td><%=s.getUser()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="admin?x=2">Torna alla gestione studenti</a>
	</div>
	<%
		}
	%>
</body>
</html>