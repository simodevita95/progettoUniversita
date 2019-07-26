<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elimina esame</title>
</head>
<body>
<%		Amministratori admin = (Amministratori) session.getAttribute("admin");
		if (admin == null) {
	%>
	<h3>Non sei loggato, effettua il login!</h3>
	<a href="/Universita/index.jsp">Torna al menu</a>
	<%
		} else {
			ArrayList<Esami> arrayE = (ArrayList)request.getAttribute("arrayE");
	%>
	<div align="center" valign="middle">
	<form action="Esami?y=2" method="post">
		<h2 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Seleziona esame da eliminare:
			</b> <br> <select name="CodEsame"><option></option>
						<%
							for (Esami es : arrayE) {
						%>
						<option value="<%=es.getCodEsame()%>"><%=es.getData()+" | "+es.getD().getCodDocente()%></option>
						
						<%
							}
						%></select></span>
		</h2>
		<input type="submit" value="Elimina esame">
	</form>
	<a href="admin?x=3">Torna alla gestione esami</a>
</div>

	<%
		}
	%>

</body>
</html>