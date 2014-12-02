<%@page import="br.edu.asselvi.modelo.dao.DaoException"%>
<%@page import="br.edu.asselvi.modelo.dao.DaoBase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="config/padrao.css">
<link rel="stylesheet" type="text/css" href="config/menu.css">
<title>Login</title>
</head>
<body>
<form name="submitForm" action="LogarServlet" method="POST">

<%

DaoBase dao = new DaoBase();
try{
dao.conecta();
dao.disconecta();
}
catch(DaoException e){
        dao.CriaBanco();
}

Object obj1 = session.getAttribute("usuario");
boolean logado = false;

if (obj1 == null) {

	String usuario = request.getParameter("usuario");

	if (usuario != null && !usuario.isEmpty()) {
		session.setAttribute("usuario", request.getParameter("usuario"));
		logado = true;
	}
}
else {
	String aux = (String) obj1;
	
	if (aux != null && !aux.isEmpty()){
		logado = true;
	}
}

%> 

<div ID="corpo">
<div ID="menu">
	<ul>
		<li class="fakeMenu">RETROCLINIC</li>
		<li><a href="index.jsp">Home</a></li>
       	<li><a href="consulta.jsp">Consulta   </a></li>
       	<li><a href="medico.jsp">Medico     </a></li>
       	<li><a href="paciente.jsp">Paciente   </a></li>                   
       	<li><a href="medicamento.jsp">Medicamento</a></li>
       	<li><a href="pagamento.jsp">Pagamento  </a></li>
       	<li><a href="usuario.jsp">Usuario    </a></li> 
	</ul>
</div> <!-- menu --> 
<div ID="topo">
<img src="imagem/banner.jpg" width="900px" height="160px">
</div> <!-- topo --> 	
<div ID="conteudo">

<% if (logado) { %>

<h1 style="text-align: center;">Bem-vindo ao sistema RetroClinic</h1>

<% } else { %>
<h1 style="text-align: center;">Login</h1>
	<table align="center">
		<tr>
			<td><label class="destaque">Usuário</label></td>
			<td><input type="text" name="usuario" size="20" maxlength="25" /></td>
		</tr>
		<tr>
			<td><label class="destaque">Senha</label></td>
			<td><input type="password" name="senha" size="20" maxlength="25" /></td>
		</tr>
		<tr>
			<td style="text-align: center;" colspan="2"><input type="submit" name="submitAction" value="logar"/><input type="reset" value="Limpar"/></td>
		</tr>
	</table>
<% } %>
</div> <!-- conteudo_index -->
<div ID="rodape">
</div> <!-- rodape -->	
</div> <!-- corpo --> 	
</form>
</body>
</html>