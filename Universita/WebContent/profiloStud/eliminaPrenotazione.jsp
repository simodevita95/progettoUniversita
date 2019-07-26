<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elimina Prenotazione</title>
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
			ArrayList<Prenotazioni> arrayPE = (ArrayList)request.getAttribute("arrayPE");
	%>
	<div align="center" valign="middle">
	<form action="prenotazioni?y=2" method="post">
		<h2 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Seleziona Prenotazione da eliminare:
			</b> <br> <select name="CodPrenotazione"><option></option>
						<%
							for (Prenotazioni  p : arrayPE) {
						%>
						<option value="<%=p.getIdprenotazione()%>"><%=p.getE().getData()+" | "+p.getD().getInsegnamento()%></option>
						
						<%
							}
						%></select></span>
		</h2>
		<input type="submit" value="Elimina Prenotazione">
	</form>
	<a href="studenti?x=7">Torna indietro</a>
</div>
	<%
		}
	%>
</body>
</html>