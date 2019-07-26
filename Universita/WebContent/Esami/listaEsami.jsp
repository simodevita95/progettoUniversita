<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
			ArrayList<Esami> arrayE = (ArrayList) request.getAttribute("arrayE");
	%>

	<h1 style="text-align: center;">
		<span style="color: #A52A2A;"><b>Lista esami</b></span>
	</h1>
	<div align="center" valign="middle">
		<table border="1">
			<tr>
				<td>Codice esame</td>
				<td>Data esame</td>
				<td>Codice Docente</td>
				<td>Nome Docente</td>
				<td>Cognome Docente</td>
				<td>Insegnamento Docente</td>
				<%
					for (Esami e : arrayE) {
				%>
			
			<tr>
				<td><%=e.getCodEsame()%></td>
				<td><%=e.getData()%></td>
				<td><%=e.getD().getCodDocente()%></td>
				<td><%=e.getD().getNome()%></td>
				<td><%=e.getD().getCognome()%></td>
				<td><%=e.getD().getInsegnamento()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			}
		%>
		<a href="admin?x=3">Torna alla gestione esami</a>
	</div>
</body>
</html>