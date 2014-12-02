<%@page import="br.edu.asselvi.modelo.entidade.Pagamento"%>
<%@page import="br.edu.asselvi.modelo.dao.PagamentoDao"%>
<%@page import="br.edu.asselvi.modelo.entidade.Medicamento"%>
<%@page import="br.edu.asselvi.modelo.dao.MedicamentoDao"%>
<%@page import="br.edu.asselvi.modelo.entidade.Paciente"%>
<%@page import="br.edu.asselvi.modelo.dao.PacienteDao"%>
<%@page import="br.edu.asselvi.modelo.entidade.Medico"%>
<%@page import="br.edu.asselvi.modelo.dao.MedicoDao"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.asselvi.modelo.dao.ConsultaDao"%>
<%@page import="br.edu.asselvi.modelo.entidade.Consulta"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="config/padrao.css">
<link rel="stylesheet" type="text/css" href="config/menu.css">
<title>Consulta</title>
</head>
<body>
<form action="ConsultaServlet" method="POST">

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
Object obj = request.getAttribute("consulta");
Consulta consulta;
if (obj != null) {
	consulta = (Consulta) obj;
} else {
	consulta = new Consulta();
}
%> 
<div ID="conteudo_esq">
	<h1>
	<% if (consulta.getId() == 0) { %>
		Adicionar Consulta 
	<%} else { %>
		Alterar Consulta <%}%>
	</h1>
	<hr />
	<table>
		<tr>
			<td style=" width : 120px;">Medico:</td>
			<td style=" width : 151px;"><select required name="medico">
			<option value="">Selecione</option>
			<%
				MedicoDao medicoDao = new MedicoDao();
				List<Medico> medicos = medicoDao.buscaTodos();
		
				for (Medico dado : medicos) {
			%>
				<option value="<%= dado.getId() %>"><%= dado.getNome() %></option>
			<%
			}
			%>
			</select></td>
		</tr>
		<tr>	
			<td style=" width : 120px;">Paciente:</td>
			<td style=" width : 151px;"><select required name="paciente">
			<option value="">Selecione</option>
			<%
				PacienteDao pacienteDao = new PacienteDao();
				List<Paciente> pacientes = pacienteDao.buscaTodos();
		
				for (Paciente dado : pacientes) {
			%>
				<option value="<%= dado.getId() %>"><%= dado.getNome() %></option>
			<%
			}
			%>
			</select></td>
		</tr>
		
		<tr>	
			<td style=" width : 120px;">Medicamento:</td>
			<td style=" width : 151px;"><select required name="medicamento">
			<option value="">Selecione</option>
			<%
				MedicamentoDao medicamentoDao = new MedicamentoDao();
				List<Medicamento> medicamentos = medicamentoDao.buscaTodos();
		
				for (Medicamento dado : medicamentos) {
			%>
				<option value="<%= dado.getId() %>"><%= dado.getNome() %></option>
			<%
			}
			%>
			</select></td>
		</tr>
		
		<tr>	
			<td style=" width : 120px;">Pagamento:</td>
			<td style=" width : 151px;"><select required name="pagamento">
			<option value="">Selecione</option>
			<%
				PagamentoDao pagamentoDao = new PagamentoDao();
				List<Pagamento> pagamentos = pagamentoDao.buscaTodos();
		
				for (Pagamento dado : pagamentos) {
			%>
				<option value="<%= dado.getId() %>"><%= dado.getDescricao() %></option>
			<%
			}
			%>
			</select></td>
		</tr>
		
	</table>
	<% if (consulta.getId() == 0) { %>
		<button name="submitAction" type="submit" value="incluir">Gravar</button>
	<%} else { %>
		<button name="submitAction" type="submit" value="atualizar|<%=consulta.getId()%>">Gravar</button>
	<%}%>
	<button name="submitAction" type="submit" value="limpar">Limpar</button>
</div> <!-- conteudo_esq -->
<div ID="conteudo_dir">
	<h1>Consultas Cadastrados</h1>
	<hr />
	
	<table class="table_morota">
	<tr style="background: #000000; color: #FFFFFF">
		<td class="td1">ID</td>
		<td class="td1">Medico</td>
		<td class="td1">Paciente</td>
	</tr>
	<%
		ConsultaDao dao = new ConsultaDao();
		List<Consulta> consultas = dao.buscaTodos();
		
		for (Consulta dado : consultas) {
			%>
			<tr>
				<td><%=dado.getId()%></td>
				<td><%=dado.getMedico().getNome()%></td>
				<td><%=dado.getPaciente().getNome()%></td>
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
