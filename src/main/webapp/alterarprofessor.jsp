<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="br.com.cursoja.agendacurso.model.entidade.Professor" %>
<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Professor professorAlterar = (Professor) request.getAttribute("professor");
		DecimalFormat fmt = new DecimalFormat("###0.00");
	
	%>

	<form method="post" action="ExecutaAlteraProfessor">
	<label>Valor Hora:</label>
	<input type="number" name="valorhora" value="<%= professorAlterar.getValorHora() %>"
	step="0.01"/>
	<label>Nome:</label>
	<input type="text" name="nomeprofessor" value="<%= professorAlterar.getNome() %>"/>
	<label>Celular:</label>
	<input type="text" name="celularprofessor" value="<%= professorAlterar.getCelular() %>"/>
	<input type="hidden" name="id" value="<%=professorAlterar.getId() %>"/>
	<input type="submit" value="Alterar"/>	
	
	</form>

</body>
</html>