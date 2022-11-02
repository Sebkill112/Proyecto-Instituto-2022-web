
<!-- trabajar con la libreria core de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/dataTables.bootstrap5.min.css" rel="stylesheet">
<link href="datepicker/bootstrap-datepicker.css" rel="stylesheet">
<title>Registro de Ficha de Insccripciones</title>
</head>
<body>

<h1 class="text-center mb-4 text-uppercase" >Registrar Ficha Inscripcion</h1>

<c:if test="${param.MENSAJE!=null}">
			<div class="alert alert-warning alert-dismissible fade show"
				role="alert">
				<strong>Sistema : ${param.MENSAJE}</strong>
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
		</c:if>
	<div class="container border border-info">
		
		<form class="row g-3">
		<div class="col-md-4">
					   <strong> <label for="inputEmail4" class="form-label">Codigo</label></strong>
					    <input type="text" class="form-control" id="inputEmail4">
					  </div>
		<div class="col-md-4">
					 <strong><label for="inputEmail4" class="form-label">Fecha de Registro</label></strong> 
					    <input type="date" class="form-control" id="inputEmail4">
					  </div>			  
		 <h2>Datos Alumno</h2>
					  <div class="col-md-4">
					    <label for="inputEmail4" class="form-label">DNI</label>
					    <input type="text" class="form-control" id="inputEmail4">
					  </div>
					  <div class="col-md-4">
					    <label for="inputPassword4" class="form-label">Nombre Alumno</label>
					    <input type="text" class="form-control" id="inputPassword4">
					  </div>
					  <div class="col-md-4">
					    <label for="inputPassword4" class="form-label">Apellido</label>
					    <input type="text" class="form-control" id="inputPassword4">
					  </div>
					  <div class="col-md-4">
					    <label for="inputEmail4" class="form-label">Fecha Nacimiento</label>
					    <input type="date" class="form-control" id="inputEmail4">
					  </div>
					  <div class="col-md-4">
					    <label for="inputPassword4" class="form-label">Correo</label>
					    <input type="text" class="form-control" id="inputPassword4">
					  </div>
					  <div class="col-md-4">
					    <label for="inputPassword4" class="form-label">Direccion</label>
					    <input type="text" class="form-control" id="inputPassword4">
					  </div>
					  <div class="col-md-6">
					    <button type="button" class="btn btn-info mt-3">Buscar Alumno</button>
					  </div>
					  
					<h2>Datos Carrera</h2>  
					  <div class="col-md-4">
					    <label for="inputPassword4" class="form-label">Carrera</label>
					    <input type="text" class="form-control" id="inputPassword4">
					  </div>
					  <div class="col-md-4">
					    <label for="inputPassword4" class="form-label">Tipo</label>
					    <input type="text" class="form-control" id="inputPassword4">
					  </div>
					  <div class="col-md-4">
					    <label for="inputEmail4" class="form-label">Numero de Ciclos</label>
					    <input type="text" class="form-control" id="inputEmail4">
					  </div>
					  <div class="col-md-4">
					    <label for="inputPassword4" class="form-label">Creditos</label>
					    <input type="text" class="form-control" id="inputPassword4">
					  </div>
		
					  <div class="form-group">
					    <button type="button" class="btn btn-info mt-3">Buscar Carrera</button>
					  </div>
					 <div class="form-group" style="text-align: center">
					  	<button type="submit" class="btn btn-success">Grabar Ficha</button>   
				      </div>
					 			 
					</form>




	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>
</body>
</html>