<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.cursoja.agendacurso.model.dao.Conexao" %>
<%@ page import="br.com.cursoja.agendacurso.model.dao.CursoDao" %>
<%@ page import="br.com.cursoja.agendacurso.model.dao.ProfessorDao" %>

<%@ page import="br.com.cursoja.agendacurso.model.entidade.Curso" %>
<%@ page import="br.com.cursoja.agendacurso.model.entidade.Professor" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página inicial</title>
</head>
<body>
	<h1>Olá mundo agora na "web"!</h1>
	<a href= "listarcurso.jsp">Cursos</a><br/>
	<a href= "listarprofessor.jsp">Professores</a>
	<%
	Conexao c = new Conexao();
	c.getConexao();
	
	c.fecharConexao();
	
	Professor professor = new Professor();
	professor.setValorHora(100.00);
	professor.setNome("Luiz");
	professor.setCelular("999928282");
	
	ProfessorDao da = new ProfessorDao();
	//da.cadastrar(professor);
	
	
	
	
	Curso curso = new Curso();
	curso.setNome("Word");
	curso.setValor(300);
	
	Curso curso2 = new Curso();
	curso2.setNome("Datilografia");
	curso2.setValor(50);	
	
	CursoDao dao = new CursoDao();
	//dao.cadastrar(curso);
	//dao.cadastrar(curso2);
	
	Curso cursoAlterar = new Curso();
	cursoAlterar.setNome("Office");
	cursoAlterar.setValor(500);
	cursoAlterar.setId(1);
	dao.alterar(cursoAlterar);
	
	Professor professorAlterar = new Professor();
	professorAlterar.setValorHora(500);
	professorAlterar.setNome("Luis Feliciano Renato");
	professorAlterar.setCelular("999930300");
	professorAlterar.setId(1);
	da.alterar(professorAlterar);
	
	
	ArrayList<Curso> cursos = dao.listar("");
	for(Curso a : cursos) {		
		
		%>
		<p><%= a.getNome() %></p>
	<%	
	 }
	
	ArrayList<Professor> professores = da.listar("");
	for(Professor b : professores) {
		
		%>
		<p><%= b.getNome() %></p>
		<%
	}
	
	Curso unico = dao.buscar(1);
	Professor somente = da.buscar(1);
	%>
	
	<p><%= unico.getNome() %> - <%= unico.getValor() %>
	<p><%= somente.getValorHora() %> - <%=somente.getNome() %> - <%=somente.getCelular() %> 
	
	
	<%
		//curso2.setId(2);
	 	//dao.excluir(curso2);
	 	//professor.setId(7);
	 	//da.excluir(professor);
	
	%>
	

	
	
</body>
</html>