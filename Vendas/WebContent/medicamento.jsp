<%@page import="br.edu.asselvi.modelo.entidade.Medicamento"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.asselvi.modelo.dao.MedicamentoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="config/padrao.css">
<link rel="stylesheet" type="text/css" href="config/menu.css">
<title>Medicamento</title>
</head>
<body>
<form action="MedicamentoServlet" method="POST">
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
<% String s1 = ""; %>
<% Object obj = request.getAttribute("medicamento");

if (obj != null)
	{
		Medicamento medicamento = (Medicamento) obj;
		s1 = medicamento.getDescricao();
	}%> 

<%= s1 %>

	<h1>Adicionar Medicamento</h1>
	<hr />
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
	<button name="submitAction" type="submit" value="incluir">Gravar</button>
</div> <!-- conteudo_esq -->
<div ID="conteudo_dir">
	<h1>Medicamentos Cadastrados</h1>
	<hr />
	
	<table class="table_morota">
	<tr style="background: #000000; color: #FFFFFF">
		<td class="td1">ID       </td>
		<td class="td1">Nome     </td>
		<td class="td1">Descricao</td>
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
				<td class="td2"><button type="submit" name="submitAction" value="editar|<%=medicamento.getId()%>" ><img src="imagem/editar.png" width="15" height="15"></button></td>
				<td class="td2"><button type="submit" name="submitAction" value="excluir|<%=medicamento.getId()%>"><img src="imagem/excluir.png" width="15" height="15"></button></td>
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
