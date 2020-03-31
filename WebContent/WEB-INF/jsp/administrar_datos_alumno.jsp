<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">

<title>Sistema para Agendar citas</title>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<head>
<script src="jquery/jquery.min.js"></script>
<!---- jquery link local dont forget to place this in first than other script or link or may not work ---->

<link rel="stylesheet" href="css/bootstrap.min.css">
<!---- boostrap.min link local ----->

<link rel="stylesheet" href="css/style.css">
<!---- boostrap.min link local ----->

<script src="js/bootstrap.min.js"></script>
<!---- Boostrap js link local ----->

<link rel="icon" href="images/icon.png" type="image/x-icon" />
<!---- Icon link local ----->

<link href="https://fonts.googleapis.com/css?family=Lobster"
	rel="stylesheet">
<!---- Font awesom link local ----->
<script type="text/javascript"
	src="/bower_components/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="/bower_components/moment/min/moment.min.js"></script>
<script type="text/javascript"
	src="/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet"
	href="/bower_components/bootstrap/dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="/bower_components/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" />
</head>

<body>
	<div class="container-fluid">
		<div class="container">
			<h2 class="text-center" id="title">Administrar mis datos</h2>
			<p class="text-center">
				<small id="passwordHelpInline" class="text-muted"> Posgrado
					de Ciencia e Ingeniería de la Computación</small>
			</p>
			<hr>

			<div class="col-md-3">

				<h3>Menú</h3>
				<hr>
				<div class="form-group">
				<div>
						<form role="form" method="post"
							action="administrar_datos_alumno.html"
							modelAttribute="usuario">
							<fieldset>
								<div>
									<input type="submit" class="btn btn-primary btn-lg"
										value="Administrar mis datos" disabled="true">
								</div>
							</fieldset>
						</form>
					</div>
					
					<div>
						<form role="form" method="post" action="ver_citas_agendadas.html"
							modelAttribute="usuario">
							<fieldset>
								<div>
									<input type="submit" class="btn btn-primary btn-lg"
										value="Ver Mis Citas">
								</div>
							</fieldset>
						</form>
					</div>
					<div>
						<form role="form" method="post" action="solicitar_cita.html"
							modelAttribute="usuario">
							<fieldset>
								<div>
									<input type="submit" class="btn btn-primary btn-lg"
										value="Solicitar citas">
								</div>
							</fieldset>
						</form>
					</div>
					<div>
					<form role="form" method="get"
							action="get.html">
							<fieldset>
								<div>
									<input type="submit" class="btn btn-primary btn-lg"
										value="Cerrar Sesion"
										onclick="return confirm('¿ ${usuario.nombre} estas seguro que quieres salir de tu sesión?')"
										>
								</div>
							
							</fieldset>
						</form>
					</div><hr>
				</div>
			</div>
			<div class="col-md-2">
				<!-------null------>
			</div>

			<div class="row">
				<div class="col-md-6">
				<form role="form" method="post" action="actualizar_datos_alumno.html"
						modelAttribute="usuario">
						<fieldset>
					<div class="form-group">
						<input type="text" name="nombre" id="nombre"
							class="form-control input-lg" placeholder="Nombre"
							value="${usuario.nombre}">
					</div>
					<div class="form-group">
						<input type="text" name="apellido1" id="apellido1"
							class="form-control input-lg" placeholder="Apellido Paterno"
							value="${usuario.apellido1}">
					</div>
					<div class="form-group">
						<input type="text" name="apellido2" id="apellido2"
							class="form-control input-lg" placeholder="Apellido Materno"
							value="${usuario.apellido2}">
					</div>
					<div class="form-group">
						<input type="email" name="email" id="email"
							class="form-control input-lg" placeholder="Email"
							value="${usuario.email}" disabled="true">
					</div>
					<div class="form-group">
						<input type="text" name="nCuenta" id="nCuenta"
							class="form-control input-lg" placeholder="No. Cuenta"
							value="${usuario.nCuenta}" disabled="true">
					</div>

					<div class="form-group">
						<input type="facultad" name="facultad" id="facultad"
							class="form-control input-lg" placeholder="Facultad"
							value="${usuario.facultad}" disabled="true">
					</div>
					<div class="form-group">
						<input type="carrera" name="carrera" id="carrera"
							class="form-control input-lg" placeholder="Carrera"
							value="${usuario.carrera}" disabled="true">
					</div>



					<div>
						<input type="submit" class="btn btn-lg btn-primary"
							value="Actualizar" onclick="return confirm('¿ ${usuario.nombre} estas seguro que quieres actualizar tus datos?')">
					</div>
					</fieldset>
					</form>
				</div>




			</div>
		</div><hr>
		<p class="text-center">
			<small id="passwordHelpInline" class="text-muted">
				 UNAM @2019  </small>
		</p>
	</div>
</body>



</html>
