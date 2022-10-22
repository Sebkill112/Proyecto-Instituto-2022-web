<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
<title>LOGIN</title>
</head>
<body>
 
	<div class="container mt-4 col-lg-4">
		<div class="card col-sm-10">
			<div class="card-body ">

				<form action="ServletUsuario?accion=INGRESAR" class="form-sign" method="POST">
					<div class="form-group text-center" >
					<h3>Bienvenido Al Sistema</h3>
					</div>
					<div class="form-group">
					<label>Usuario</label>
					<input type="text" name="txtUser" class="form-control">
					</div>
					<div class="form-group">
					<label>Contraseña</label>
					<input type="text" name="txtPass" class="form-control">
					</div>
					<input type="submit" value="Ingresar" class="btn btn-primary btn-block mt-2">
					
				</form>
				
				<c:if test="${param.MENSAJE!=null}">
							<div class="alert alert-warning alert-dismissible fade show"
								role="alert">
								<strong>SISTEMA</strong> ${param.MENSAJE}
								<button type="button" class="btn-close" data-bs-dismiss="alert"
									aria-label="Close"></button>
							</div>
						</c:if>
			</div>
		</div>
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