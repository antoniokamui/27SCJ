<!DOCTYPE html>
<%@page import="br.com.fiap.entity.Usuario"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
<head>
<title>Menu de Op��es</title>
</head>
<body>
	<%@ include file="welcome.jsp" %>

  <%--  <% // exemplo de controle via tela
	Usuario usuario = (Usuario)session.getAttribute("usuario_sessao");
	 if(usuario == null){
	 	response.sendRedirect("../login.jsp");
	 	response.sendRedirect("/AplicacaoServletJsp2/login.jsp");
	 }%> --%>
	<h1>Menu de Op��es</h1>
	<ul>
		<li><a href="cadUsuarios.jsp">Cadastro de Usu�rios</a></li>
		<li><a href="cadLivros.jsp">Cadastro de Livros</a></li>
	</ul>
</body>
</html>