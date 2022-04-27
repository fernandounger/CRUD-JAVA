<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Professor</title>
</head>
<body>

	<form method="post" action="ProfessorServelet">
		
		<label>ValorHora: </label>
		<input type="number" name="valorhora" required
			   step="0.01" />
		<label>Nome: </label>
		<input type="text" name="nomeprofessor" required/>
		<label>Celular: </label>
		<input type="text" name="celularprofessor" required />
		<input type="submit" value="gravar"/>
				
		</form>


</body>
</html>