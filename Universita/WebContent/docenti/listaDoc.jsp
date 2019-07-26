<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Docenti</title>
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
			ArrayList<Docenti> arrayDoc = (ArrayList)request.getAttribute("arrayDoc");
	%>

<h1 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Lista docenti</b></span>
		</h1>
<div align="center" valign="middle">
	<table border="1">
		<tr>
			<td>Codice docente</td>
			<td>Nome docente</td>
			<td>Cognome docente</td>
			<td>Insegnamento</td>
			<%
				for (Docenti d : arrayDoc) {
			%>
		
		<tr>
			<td><%=d.getCodDocente()%></td>
			<td><%=d.getNome()%></td>
			<td><%=d.getCognome()%></td>
			<td><%=d.getInsegnamento()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		}
	%>
<a href="admin?x=4">Torna alla gestione docenti</a>
	</div>
</body>
</html>