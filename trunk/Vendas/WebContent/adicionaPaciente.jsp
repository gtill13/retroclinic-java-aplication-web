<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="config/padrao.css">
<title>Adicionar Paciente</title>
</head>
<body>
<form style="margin: 0;	padding: 0;">
<nav>
	<ul>
		<li class="fakeMenu">RETROCLINIC</li>
        <li><a href="index.jsp">Inicio</a></li>
        <li><a href="sobre.jsp">Sobre</a></li>
        <li><a> Cadastros</a>
        	<ul>
            	<li><a href="consulta.jsp"   >Consulta   </a></li>
            	<li><a href="medico.jsp"     >Medico     </a></li>
            	<li><a href="paciente.jsp"   >Paciente   </a></li>                   
            	<li><a href="medicamento.jsp">Medicamento</a></li>
            	<li><a href="pagamento.jsp"  >Pagamento  </a></li>
            </ul>
        </li>
        <li><a href="ajuda.jsp">Ajuda</a></li>               
	</ul>
</nav><br><br><br>
</form>


	<h1>Adicionar&nbsp;Paciente</h1>

	<hr />
	<form action="adicionaPacienteServlet" method="POST">
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
		
		<input type="submit" value="Gravar" name="submitAction" />&nbsp;
	</form>
	</span>
</body>
</html>
