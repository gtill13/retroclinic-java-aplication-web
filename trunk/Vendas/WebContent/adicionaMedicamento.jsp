<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
<title>Adicionar Medico</title>
</head>
<body>
	<span style="font-family: courier new, courier, monospace;">
		<h1>Adicionar&nbsp;Medicamento</h1>

		<hr />
		<form action="adicionaMedicamentoServlet" method="POST">
			<p>
				Nome: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input maxlength="25"
					name="nome" type="text" /><br />
				Descri&ccedil;&atilde;o:&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;<input
					maxlength="20" name="descricao" type="text" />
			</p>

			<p>
				<input name="submitAction" type="submit" value="Gravar" />&nbsp;
			</p>
		</form>
	</span>
</body>
</html>
