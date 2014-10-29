<%@page import="br.edu.asselvi.modelo.entidade.Medicamento"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.asselvi.modelo.dao.MedicamentoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
<link rel="stylesheet" type="text/css" href="config/padrao.css">
<link rel="stylesheet" type="text/css" href="config/menu.css">
<title>Adicionar Medico</title>
</head>
<body>
<div ID="corpo">
<div ID="menu">
	<ul>
		<li class="fakeMenu">RETROCLINIC</li>
		<li><a href="index.jsp">HOME</a></li>
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
		<li><a href="#">LOGIN?</a></li>
	</ul>
</div> <!-- menu --> 
<div ID="topo">
</div> <!-- topo --> 	
<div ID="conteudo">
<div ID="conteudo_esq">
	<h1>Adicionar Medicamento</h1>
	<hr />
	<form action="adicionaMedicamentoServlet" method="POST">
	<table>
		<tr>
			<td style=" width : 120px;">Nome:</td>
			<td style=" width : 151px;"><input maxlength="25" name="nome" type="text" /></td>
		</tr>
		<tr>	
			<td style=" width : 120px;">Descri&ccedil;&atilde;o:</td>
			<td style=" width : 151px;"><input maxlength="20" name="descricao" type="text" /></td>
		</tr>
	</table>
	<input name="submitAction" type="submit" value="Gravar" />
	</form>
</div> <!-- conteudo_esq -->
<div ID="conteudo_dir">
	<h1>Grid Medicamentos</h1>
	<hr />
	
	<table class="table_morota">
	<tr style="background: #000000; color: #FFFFFF">
		<td>ID       </td>
		<td>Nome     </td>
		<td>Descricao</td>
		<td style="background: #FFFFFF; color: #000000">Editar</td>
		<td style="background: #FFFFFF; color: #000000">Excluir</td>
	</tr>
	<%
		MedicamentoDao dao = new MedicamentoDao();
		List<Medicamento> medicamentos = dao.buscaTodos();
		
		for (Medicamento medicamento : medicamentos) {
			%>
			<tr>
				<td><%=medicamento.getId()       %></td>
				<td><%=medicamento.getNome()     %></td>
				<td><%=medicamento.getDescricao()%></td>
				<td></td>
				<td></td>
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
</body>
</html>
