<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="config/padrao.css" >
<title>- - PROJETO RETROCLINIC - -</title>
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
<form action="adicionaPacienteServlet" method="POST">
</body>
</html>