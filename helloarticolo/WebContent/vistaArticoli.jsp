<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.helloarticolo.model.Articolo"%>
<%@page import="it.helloarticolo.service.MyServiceFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<title>Vista Articoli</title>
</head>
<body>
	<div class="container">
		<%
			if (request.getAttribute("messaggioConfermaDaInviare") != null) {
		%>
		<p style="color: green;"><%=request.getAttribute("messaggioConfermaDaInviare")%></p>
		<%
			} else if (request.getAttribute("messaggioErroreDaInviare") != null) {
		%>
		<p style="color: red;"><%=request.getAttribute("messaggioErroreDaInviare")%></p>
		<%
			}
		%>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Nome</th>
					<th scope="col">Modello</th>
					<th scope="col">Prezzo</th>
					<th scope="col">Azioni</th>
					<th scope="col"><a class="btn btn-danger" href="index.jsp"
						role="button">Indietro</a>
				</tr>
			</thead>
			<tbody>

				<%
					List<Articolo> listaDaServlet = new ArrayList<Articolo>();
					if (request.getAttribute("listaDaInviare") != null) {
						listaDaServlet = (List<Articolo>) request.getAttribute("listaDaInviare");
					}
					for (Articolo articoloItem : listaDaServlet) {
				%>
				<tr>
					<td><%=articoloItem.getNome()%></td>
					<td><%=articoloItem.getCategoria()%></td>
					<td><%=articoloItem.getPrezzo()%></td>
					<td><a class="btn btn"
						href="VisualizzaDettaglioServlet?idDaInviareComeParametro=<%=articoloItem.getIdArticolo()%>"
						role="button">Dettaglio</a>
						<form
							action="CarrelloServlet?idDaInviareComeParametro=<%=articoloItem.getIdArticolo()%>"
							method="post">
							<input type="submit" class="btn btn-success"
								value="Aggiungi al carrello">
						</form></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>