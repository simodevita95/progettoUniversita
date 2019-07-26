<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Esame</title>
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
			ArrayList<Esami> arrayE = (ArrayList)request.getAttribute("arrayE");
	%>
	<form action="Esami?y=3" method="post">
			<h2 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Seleziona esame da modificare:</b> <br>

				<select name="CodEsame"><option></option>
						<%
							for (Esami e : arrayE) {
						%>
						<option value="<%=e.getCodEsame()%>"><%=e.getData()+"|"+e.getD().getCodDocente()%></option>
						<%
							}
						%></select>
			</span>
		</h2>
		<h4 style="text-align: center;">
			<span style="color: #000000;"><b>Inserisci nuova data:<br>
					<input type="date" name="dataEsame"><br>
			</b></span>
		</h4>
		<h2 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Seleziona docente:</b> <br>

				<select name="CodDocente"><option></option>
						<%
							for (Docenti d : arrayDoc) {
						%>
						<option value="<%=d.getCodDocente()%>"><%=d.getNome()+"|"+d.getCognome()%></option>
						<%
							}
						%></select>
			</span>
		</h2>
		
		<p style="text-align: center;">
			<input type="submit" value="Modifica esame">
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