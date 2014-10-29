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
		<li><a href="#">HOME</a></li>
		<li><a href="#">HOME</a></li>
		<li><a>HOME</a>
			<ul>
            	<li><a href="consulta.jsp"   >Consulta   </a></li>
            	<li><a href="medico.jsp"     >Medico     </a></li>
            	<li><a href="paciente.jsp"   >Paciente   </a></li>                   
            	<li><a href="medicamento.jsp">Medicamento</a></li>
            	<li><a href="pagamento.jsp"  >Pagamento  </a></li>
            </ul>
         </li> 
		<li><a href="#">HOME</a></li>
		<li><a href="#">HOME</a></li>
	</ul>
</div> <!-- menu --> 
<div ID="topo">
</div> <!-- topo --> 	
<div ID="conteudo">
	<h1>Adicionar&nbsp;Medicamento</h1>
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
	
</div> <!-- conteudo -->
<div ID="rodape">
</div> <!-- rodape -->	
</div> <!-- corpo --> 	
</body>
</html>
