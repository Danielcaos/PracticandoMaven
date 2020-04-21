<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>HTML5 y CSS Formulario de contacto</title>
<link herf"css/estilo.css" rel="stylesheet" />
</head>
<body>
	<form class="contact_form" method="POST" action="RecibirParametros" runat="server">
		<div class="form-group">
			<ul class="list-group">
				<li class="list-group-item"> <h2>Contactos</h2> <span class="requiered_notification">* Datos requeridos</span>
					</li>
				<li class="list-group-item"><label for="name">Nombre:</label>
					<input type="text" name="name" placeholder="Daniel Calderon" required /></li>
				<li class="list-group-item"><label for="email">Email:</label>
					<input type="email" name="email" placeholder="danielcaos@ufps.edu.co" required /> <span class="form_hint">Formato correcto: "name@dominio.com"</span></li>
				<li class="list-group-item"><label for="website">Web Site:</label>
					<input type="url" name="website" placehorlder="http://dominio.com" required/> <span class="form_hint">Formato correcto: "http://dominio.com"</span></li>
				<li class="list-group-item"><label for="message">Mensaje:</label> <textarea name="message" rows="6" cols="40" required></textarea>
					</li>
				<li class="list-group-item"><button class="btn btn-primary" type="submit">Enviar mensaje</button>
					</li>
			</ul>
		</div>
	</form>
</body>
</html>