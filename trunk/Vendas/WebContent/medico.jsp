<%@page import="br.edu.asselvi.modelo.entidade.Medico"%>
<%@page import="br.edu.asselvi.modelo.entidade.Endereco"%>
<%@page import="br.edu.asselvi.modelo.entidade.Contato"%>
<%@page import="br.edu.asselvi.modelo.entidade.ESexo"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.asselvi.modelo.dao.MedicoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="config/padrao.css">
<link rel="stylesheet" type="text/css" href="config/menu.css">
<title>Medico</title>
</head>
<body>
<form action="MedicoServlet" method="POST">

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
Object obj = request.getAttribute("medico");
Medico medico;
if (obj != null) {
	medico = (Medico) obj;
} else {
	medico = new Medico(0, "", "", "", ESexo.M, new Endereco(0, "", "", "", ""), new Contato(0, "", "", ""));
}
%> 

<div ID="conteudo_esq">
	<h1>
	<% if (medico.getId() == 0) { %>
		Adicionar Medico 
	<%} else { %>
		Alterar Medico <%}%>
	</h1>

	<hr />
		<table>
			<tr> 
				<td style=" width : 140px;">Nome:</td>
				<td><input maxlength="25" name="nome" type="text" value="<%=medico.getNome()%>" /></td> 
			</tr>
			<tr>
				<td>Crm:</td>
				<td><input maxlength="20"name="crm" type="text" value="<%=medico.getCrm()%>" /></td>
			</tr>
			<tr>
				<td>CPF:</td>
				<td><input maxlength="20" name="cpf" type="text" value="<%=medico.getCpf()%>" /></td>
			</tr>
			<tr>
			<% if (medico.getSexo() == ESexo.M) { %>
				<td><input checked="checked" name="sexo" type="radio" value="M" />Masculino</td>
				<td><input name="sexo" type="radio" value="F" />Feminino</td>
			<% } else { %>
				<td><input name="sexo" type="radio" value="M" />Masculino</td>
				<td><input checked="checked" name="sexo" type="radio" value="F" />Feminino</td>
			<% } %>
			</tr>		
		</table>
		<hr />
		<table>
			<tr>
				<td style=" width : 140px;">Endere&ccedil;o:</td>
				<td><input maxlength="40" name="endereco" type="text" value="<%=medico.getEndereco().getEndereco()%>" /></td>
			</tr>
			<tr>
				<td>Cidade:</td>
				<td><input maxlength="20"name="cidade" type="text" value="<%=medico.getEndereco().getCidade()%>" /></td>
			</tr>
			<tr>
				<td>Bairro:</td>
				<td><input maxlength="20"name="bairro" type="text" value="<%=medico.getEndereco().getBairro()%>" /></td>
			</tr>
			<tr>
				<td>Cep:</td>
				<td><input maxlength="8" name="cep" size="20" type="tel" value="<%=medico.getEndereco().getCep()%>" /></td>
			</tr>
		</table>
		<hr />
		<table>
			<tr>
				<td style=" width : 140px;">Email:</td>
				<td><input maxlength="40"	name="email" type="email" value="<%=medico.getContato().getEmail()%>"/></td>
			</tr>
			<tr>
				<td>Telefone:</td>
				<td><input maxlength="20" name="telefone" type="tel" value="<%=medico.getContato().getTelefone()%>" /></td>
			</tr>
			<tr>
				<td>Celular:</td>
				<td><input maxlength="20" name="celular" type="tel" value="<%=medico.getContato().getCelular()%>" /></td>
			</tr>
		</table>
	<% if (medico.getId() == 0) { %>
		<button name="submitAction" type="submit" value="incluir">Gravar</button>
	<%} else { %>
		<button name="submitAction" type="submit" value="atualizar|<%=medico.getId()%>">Gravar</button>
	<%}%>
	<button name="submitAction" type="submit" value="limpar">Limpar</button>
</div> <!-- conteudo_esq -->
<div ID="conteudo_dir">
	<h1>Medicos Cadastrados</h1>
	<hr />
	
	<table class="table_morota">
	<tr style="background: #000000; color: #FFFFFF">
		<td class="td1">ID</td>
		<td class="td1">Nome</td>
		<td class="td1">Crm</td>
	</tr>
	<%
		MedicoDao dao = new MedicoDao();
		List<Medico> medicos = dao.buscaTodos();
		
		for (Medico dado : medicos) {
			%>
			<tr>
				<td><%=dado.getId()  %></td>
				<td><%=dado.getNome()%></td>
				<td><%=dado.getCrm() %></td>
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