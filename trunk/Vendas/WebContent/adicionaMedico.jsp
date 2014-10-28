<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adicionar Medico</title>
</head>
<body>
	<span style="font-family: courier new, courier, monospace;">
		<h1>Adicionar&nbsp;Medico</h1>

		<hr />
		<form action="adicionaMedicoServlet" method="POST">
			<p>
				Nome: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input maxlength="25"
					name="nome" type="text" /><br /> Crm:&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
				&nbsp; &nbsp;<input maxlength="20" name="crm" type="text" /><br />
				CPF: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<input
					maxlength="20" name="cpf" type="text" /> <br /> <input
					checked="checked" name="sexo" type="radio" value="M" />&nbsp;Masculino
				&nbsp; &nbsp; &nbsp;<input name="sexo" type="radio" value="F" />&nbsp;Feminino
			</p>
			<hr />
			<p>
				Endere&ccedil;o:&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<input
					maxlength="40" name="endereco" type="text" /><br
					style="font-family: 'courier new', courier, monospace;" />
				Cidade:&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<input maxlength="20"
					name="cidade" type="text" /><br
					style="font-family: 'courier new', courier, monospace;" />
				Bairro:&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<input maxlength="20"
					name="bairro" type="text" /><br
					style="font-family: 'courier new', courier, monospace;" />
				Cep:&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input
					maxlength="8" name="cep" size="20" type="tel" />
			</p>

			<hr />
			<p>
				Email: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<input maxlength="40"
					name="email" type="email" /><br
					style="font-family: 'courier new', courier, monospace;" />
				Telefone:&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<input maxlength="20"
					name="telefone" type="tel" /><br
					style="font-family: 'courier new', courier, monospace;" />
				Celular:&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<input maxlength="20"
					name="celular" type="tel" />
			</p>

			<p>
				<input type="submit" value="Gravar" name="submitAction" />&nbsp;
			</p>
	</span>
</body>
</html>