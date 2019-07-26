<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.* "%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prenota Esame</title>
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
			ArrayList<Esami> arrayE = (ArrayList) request.getAttribute("listaE");
	%>
	<form method="post" action="prenotazioni?y=1">
		<h2 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Seleziona esame da
					prenotare:</b> <br> </span><select name="CodEsame">
				<option></option>
				<%
					for (Esami es : arrayE) {
				%>
				<option value="<%=es.getCodEsame()%>"><%=es.getData() + " | " + es.getD().getCodDocente() + " | " + es.getD().getNome() + " | "
							+ es.getD().getCognome() + " | " + es.getD().getInsegnamento()%></option>

				<%
					}
				%>
			</select>
		</h2>

		<p style="text-align: center;">
			<input type="submit" value="Prenota esame">
		</p>
		<%
			}
		%>
	</form>
	<div align="center">
		<a href="studenti?x=7">Torna indietro</a>
</div>
</body>
</html>