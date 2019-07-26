<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista esami prenotati</title>
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
			ArrayList<Prenotazioni> arrayP = (ArrayList) request.getAttribute("arrayP");
	%>
	<h1 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Lista esami</b></span>
		</h1>
<div align="center" valign="middle">
	<table border="1">
		<tr>
			<td>Insegnamento</td>
			<td>Data esame</td>
			<td>Nome Docente</td>
			<td>Cognome Docente</td>
			<td>Codice Prenotazione</td>
			<%
				for (Prenotazioni p : arrayP) {
			%>
		
		<tr>
			<td><%=p.getD().getInsegnamento()%></td>
			<td><%=p.getE().getData()%></td>
			<td><%=p.getD().getNome()%></td>
			<td><%=p.getD().getCognome()%></td>
			<td><%=p.getIdprenotazione()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		}
	%>
	<a href="studenti?x=7">Torna indietro</a>
</div>
</body>
</html>