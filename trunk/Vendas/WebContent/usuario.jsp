<%@page import="br.edu.asselvi.modelo.entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.asselvi.modelo.dao.UsuarioDao"%>
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
<form action="UsuarioServlet" method="POST">

<%

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

if (!logado) {
	request.getRequestDispatcher("index.jsp").forward(request, response);	
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

<%
	Object obj = request.getAttribute("login");
Usuario login;
if (obj != null) {
	login = (Usuario) obj;
} else {
	login = new Usuario(0, "", "");
}
%>

<div ID="conteudo_esq">
<h1>
	<%
		if (login.getId() == 0) {
	%>
		Adicionar Usuario 
	<%
		} else {
	%>
		Alterar Usuario <%
		}
	%>
	</h1>
	<hr />
	<table>
		<tr>
			<td style=" width : 120px;">Usuario:</td>
			<td style=" width : 151px;"><input required maxlength="25" name="usuario" type="text" value="<%=login.getLogin()%>"/></td>
		</tr>
		<tr>	
			<td style=" width : 120px;">Senha:</td>
			<td style=" width : 151px;"><input required maxlength="25" name="senha" type="password" /></td>
		</tr>
	</table>
	<%
		if (login.getId() == 0) {
	%>
		<button name="submitAction" type="submit" value="incluir">Gravar</button>
	<%
		} else {
	%>
		<button name="submitAction" type="submit" value="atualizar|<%=login.getId()%>">Gravar</button>
	<%
		}
	%>
	<button name="submitAction" type="submit" value="limpar">Limpar</button>
</div> <!-- conteudo_esq -->
<div ID="conteudo_dir">
	<h1>Usuarios Cadastrados</h1>
	<hr />
	
	<table class="table_morota">
	<tr style="background: #000000; color: #FFFFFF">
		<td class="td1">ID       </td>
		<td class="td1">Nome     </td>
	</tr>
	<%
		UsuarioDao dao = new UsuarioDao();
		List<Usuario> logins = dao.buscaTodos();
		
		for (Usuario dado : logins) {
	%>
			<tr>
				<td><%=dado.getId()%></td>
				<td><%=dado.getLogin()%></td>
				<td class="td2"><button type="submit" name="submitAction" value="editar|<%=dado.getId()%>" ><img src="imagem/editar.png" width="15" height="15"></button></td>
				<td class="td2"><button type="submit" name="submitAction" value="excluir|<%=dado.getId()%>"><img src="imagem/excluir.png" width="15" height="15"></button></td>
			</tr>
			<%
		}
	%>
		</table>
	
</div> <!-- conteudo_dir -->
</div> <!-- conteudo -->
<div ID="rodape">
</div> <!-- rodape -->	
</div> <!-- corpo --> 	
</form>
</body>
</html>
