<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Produtos da Gubee</title>
	<link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>

	<a href="index.html">Ir para Home</a>

	<form action="listar-produtos" method="post">
		<% 
		for (Tecnologia tec: (ListaTecnologias) request.getAttribute("todasTecs")) { 	
		%>
			<input type="checkbox" id="tec<%=tec.getId()%>" name="tec<%=tec.getId()%>" 
			       value="<%=tec.getTecNome()%>" <%=(tec.isChecked()?"checked":"")%>> 
			<label for="tec<%=tec.getId()%>"><%=tec.getTecNome()%></label><br/>
		<%} %>
		<input type="submit" value="Listar Produtos">
	</form>

	<h2>Lista de Produtos ...</h2>
	<% 
	ListaProdutos produtosFiltrados = (ListaProdutos) request.getAttribute("produtosFiltrados");
	for (Produto p: produtosFiltrados) {
		out.println("<div class=\"box\">");
		out.println("Produto: " + p.getProductName() + "<br>");
		out.println("Descrição: " + p.getDescription() + "<br>");
		out.println("Mercado alvo: " + p.getTargetMarket().toString() + "<br>");
		out.println("Tecnologias: [");
		for (Tecnologia t: p.getStack()) {
			out.println(t.getTecNome() + " - ");
		}
		out.println("]");
		out.println("</div>");
	}
	%>
	

	
</body>
</html>