<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.Enumeration, java.util.ArrayList, java.io.File, java.net.URL " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Produtos da Gubee</title>
	<link type="text/css" rel="stylesheet" href="estilo.css">
</head>
<body>

	<h1>Produtos da Gubee</h1>
	
	<%
		String jsonString = new DAO().fetchData();
		ParseJSON pg = new ParseJSON(jsonString);		
	
		ArrayList<Produto> todosProdutos = pg.getTodosProdutos();	
		ArrayList<String> todasStacks = new StackGetter(todosProdutos).getTodasStacks();	
	%>
	
	<form action="listar-produtos.jsp" method="post">
	  	
	  	<% for (int i=0; i < todasStacks.size(); i++) { %>
			<input type="checkbox" id="tec<%=i%>" name="tec<%=i%>" value="<%=todasStacks.get(i)%>"
				<% if (request.getParameter("tec"+i) != null) { // para manter o que foi marcado %>
					checked
				<% }%>
			>
			<label for="tec<%=i%>"><%=todasStacks.get(i)%></label><br>
	  	<%}%>
	  	<input type="submit" value="Aplicar filtros">
	  	
	</form>


 	<% 
	
	ProdutoFilter prodFilter = new ProdutoFilter(todosProdutos, request);
	
	ArrayList<Produto> produtosFiltrados = prodFilter.filtrar();
	
	out.println("<p>Produtos filtrados</p>");
	
	for (int i=0; i < produtosFiltrados.size(); i++) {     
		out.println("<div class=\"box\">");	
		out.println("    <p> Produto: "   + produtosFiltrados.get(i).getProductName() + "</p>");
		out.println("    <p> Descrição: " + produtosFiltrados.get(i).getDescription() + "</p>");
		out.println("    <p> Mercado alvo: " + produtosFiltrados.get(i).getTargetMarket().toString() + "</p>");
		out.println("    <p> Tecnologias: " + produtosFiltrados.get(i).getStack() + "</p>");
		out.println("</div>");
		out.println("<hr>");
	}
	
	%>
</body>
</html>