<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica docente</title>
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
	<form action="docenti?y=2" method="post">
		<h2 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Seleziona docente da
					modificare:</b> <br>
				<select name="codDocente"><option></option>
						<%
							for (Docenti d : arrayDoc) {
						%>
						<option value="<%=d.getCodDocente()%>"><%=d.getNome()+" "+d.getCognome() %></option>
						<%
							}
						%></select>
			</span>
		</h2>
		<h2 style="text-align: center;">
			<span style="color: #A52A2A;"><b>Inserisci i nuovi dati</b></span>
		</h2>
		<h4 style="text-align: center;">
			<span style="color: #000000;"><b>Inserisci nome:<br>
					<input type="text" name="nome"><br>
			</b></span>
		</h4>
		<h4 style="text-align: center;">
			<span style="color: #000000;"><b>Inserisci cognome:<br>
					<input type="text" name="cognome"><br>
			</b></span>
		</h4>
		<h4 style="text-align: center;">
			<span style="color: #000000;"><b>Inserisci nuovo insegnamento:<br>
					<input type="text" name="insegnamento"><br>
			</b></span>
		</h4>
		<p style="text-align: center;">
			<input type="submit" value="Modifica docente">
		</p>
	</form>
	<div align="center">
		<a href="admin?x=4">Torna alla gestione docenti</a>
</div>
	<%
		}
	%>


</body>
</html>