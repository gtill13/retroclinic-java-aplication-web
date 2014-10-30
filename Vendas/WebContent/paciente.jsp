<%@page import="br.edu.asselvi.modelo.entidade.Paciente"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.asselvi.modelo.dao.PacienteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="config/padrao.css">
<link rel="stylesheet" type="text/css" href="config/menu.css">
<title>Paciente</title>
</head>
<body>
<form action="PacienteServlet" method="POST">
<div ID="corpo">
<div ID="menu">
	<ul>
		<li class="fakeMenu">RETROCLINIC</li>
		<li><a href="index.jsp">Home</a></li>
		<li><a>Cadastro</a>
			<ul>
            	<li><a href="consulta.jsp"   >Consulta   </a></li>
            	<li><a href="medico.jsp"     >Medico     </a></li>
            	<li><a href="paciente.jsp"   >Paciente   </a></li>                   
            	<li><a href="medicamento.jsp">Medicamento</a></li>
            	<li><a href="pagamento.jsp"  >Pagamento  </a></li>
            </ul>
         </li> 
		<li><a href="#">Relatorio</a></li>
		<li><a href="#">Logoff</a></li>
	</ul>
</div> <!-- menu --> 
<div ID="topo">
<img src="imagem/banner.jpg" width="900px" height="160px">
</div> <!-- topo --> 	
<div ID="conteudo">
<div ID="conteudo_esq">
	<h1>Adicionar Paciente</h1>

	<hr />
	<table>
		<tr> 
			<td>Nome:</td>
			<td><input maxlength="25" name="nome" type="text" /></td> 
		</tr>
		<tr>
			<td>RG:</td>
			<td><input maxlength="20"name="rg" type="text" /></td>
		</tr>
		<tr>
			<td>CPF:</td>
			<td><input maxlength="20" name="cpf" type="text" /></td>
		</tr>
		<tr>
			<td><input checked="checked" name="sexo" type="radio" value="M" />&nbsp;Masculino</td>
			<td><input name="sexo" type="radio" value="F" />&nbsp;Feminino</td>
		</tr>		
	</table>
	<hr />
	<table>
		<tr>
			<td style=" width : 140px;">Endere&ccedil;o:</td>
			<td><input maxlength="40" name="endereco" type="text" /></td>
		</tr>
		<tr>
			<td>Cidade:</td>
			<td><input maxlength="20"name="cidade" type="text" /></td>
		</tr>
		<tr>
			<td>Bairro:</td>
			<td><input maxlength="20"name="bairro" type="text" /></td>
		</tr>
		<tr>
			<td>Cep:</td>
			<td><input maxlength="8" name="cep" size="20" type="tel" /></td>
		</tr>
	</table>
	<hr />
	<table>
		<tr>
			<td style=" width : 140px;">Email:</td>
			<td><input maxlength="40"	name="email" type="email" /></td>
		</tr>
		<tr>
			<td>Telefone:</td>
			<td><input maxlength="20" name="telefone" type="tel" /></td>
		</tr>
		<tr>
			<td>Celular:</td>
			<td><input maxlength="20" name="celular" type="tel" /></td>
		</tr>
	</table>
	<button name="submitAction" type="submit" value="incluir">Gravar</button>
</div> <!-- conteudo_esq -->
<div ID="conteudo_dir">
	<h1>Pacientes Cadastrados</h1>
	<hr />
	
	<table class="table_morota">
	<tr style="background: #000000; color: #FFFFFF">
		<td class="td1">ID</td>
		<td class="td1">Nome</td>
		<td class="td1">Rg</td>
	</tr>
	<%
		PacienteDao dao = new PacienteDao();
		List<Paciente> pacientes = dao.buscaTodos();
		
		for (Paciente paciente : pacientes) {
			%>
			<tr>
				<td><%=paciente.getId()  %></td>
				<td><%=paciente.getNome()%></td>
				<td><%=paciente.getRg()  %></td>
				<td class="td2"><button type="submit" name="submitAction" value="editar|<%=paciente.getId()%>" ><img src="imagem/editar.png" width="15" height="15"></button></td>
				<td class="td2"><button type="submit" name="submitAction" value="excluir|<%=paciente.getId()%>"><img src="imagem/excluir.png" width="15" height="15"></button></td>
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