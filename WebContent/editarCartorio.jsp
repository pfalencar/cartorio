<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<body>
		<form action="/SistemaCartorio/EditarCartorioServlet" method="GET"> 
			<p>Id:</p>
			<input type="text" size="20" name="id">
			<br>
			<p>Nome:</p>
			<input type="text" size="10" name="nome">
			<br><br>
			<input value="Editar cartório" type="submit">
		</form>
	</body>
</html>