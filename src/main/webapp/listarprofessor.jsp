<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="br.com.cursoja.agendacurso.controller.ProfessorController" %>

<%@ page import="br.com.cursoja.agendacurso.model.entidade.Professor" %>
<%@ page import="java.text.DecimalFormat" %>

<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de Professor</title>
</head>
<body>
<a href= "cadastrarprofessor.jsp">Cadastrar Professor</a>
		<table>
			<thead>
			
				<th>Valor Hora</th>
				<th>Nome</th>
				<th>Celular</th>				
				<th>Ações</th>
						
			</thead>			
		
		<tbody>
		
	<%
		ProfessorController controller = new ProfessorController();
		ArrayList<Professor> lista = controller.listar("");
		
		//DecimalFormat fmt = new DecimalFormat("###0.00");
		DecimalFormat fmt = new DecimalFormat("###,##0.00");
		for (Professor p : lista) {	
	
	%>
	
	<tr>
					
			<td><%= fmt.format (p.getValorHora()) %></td>
			<td><%= p.getNome() %></td>
			<td><%= p.getCelular() %></td>
			<td>
			<a href= "InicioAlteraProfessor?id=<%= p.getId()%>" >Alterar</a>
			<a href= "ExcluirProfessor?id=<%= p.getId() %>"
						onclick= "if (!confirm('Deseja excluir esse registro?')){return false}">Excluir</a>
			
			 </td>
		
		</tr>
	
	<% } %>
 
</tbody>
</table>
</body>
</html>