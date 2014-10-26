<%@ page import="java.util.*"%>
<%@page import="br.edu.asselvi.modelo.dao.PacienteDao"%>
<%@page import="br.edu.asselvi.modelo.entidade.Paciente"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Pacientes</title>
</head>
<body>
	<span style="font-family: courier new, courier, monospace;">
		<table>
			<%
				PacienteDao dao = new PacienteDao();
				List<Paciente> pacientes = dao.buscaTodos();

				for (Paciente paciente : pacientes) {
			%>
			<tr>
				<td><%=paciente.getNome() %></td>
				<td><%=paciente.getRg()   %></td>
				<td><%=paciente.getCpf()  %></td>
			</tr>
			<%
				}
			%>
		</table>

	</span>
</body>
</html>