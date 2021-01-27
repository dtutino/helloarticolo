<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Benvenuto nella mia pagina di benvenuto!</h1>

<% if(request.getAttribute("messaggioDiErrore") != null){ %>
		<p style="color: red;"><%=request.getAttribute("messaggioDiErrore") %></p>
	<%  }else{ %>
 	<%}    %> 

<a href="ListaArticoliServlet">Lista Articoli</a>
<br>
<a href="RicercaPerNomeServlet">Ricerca per nome</a> <p>Presto disponibile!</p>
<br>
<a href="CarrelloServlet">Carrello</a>
</body>
</html>