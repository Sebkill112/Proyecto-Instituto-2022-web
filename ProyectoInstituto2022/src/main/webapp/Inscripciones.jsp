<%
	if(request.getSession().getAttribute("listaMenus")==null)
		response.sendRedirect("Index.jsp?MENSAJE=Iniciar login");
%>

<jsp:include page="Principal.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mantenimiento de Inscripciones</title>

<!-- Bootstrap CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/dataTables.bootstrap5.min.css" rel="stylesheet">
<link href="datepicker/bootstrap-datepicker.css" rel="stylesheet">

	<style>
		/* Estilos Jefersom */		
		body{
		background-color: #008080;
		}	
		h3{
		background-color: #5f9ea0;
		color: white;
		}
		table{
		background-color: white;
		border-collapse: collapse;
		}
		th, td{
		padding: 20px;
		}
		thead{
		background-color: #246355;
		border-bottom: solid 5px #0F362D;
		color: white;	
		}
	
		/* Verificar colores*/
		tr:nth-child(even){
		background-color: #ddd;	
		}
		tr:hover td{
		background-color: #369681; 
		color: white;
		}
		
		/* ---------------------------------------------------------------- */
		.modal-header{
		color:#fff;
		background: #428bca;
		display: flex;
  		justify-content: center;  		
		}
		.help-block {
		  		color: red;
		}
		.form-group.has-error .form-control-label {
		  color: red;
		}
		.form-group.has-error .form-control {
		  border: 1px solid red;
		  box-shadow: 0 0 0 0.2rem rgba(250, 16, 0, 0.18);		  
		}
	</style>
</head>
<body>

<div class="container">
		<c:if test="${param.MENSAJE!=null}">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
			  <strong>SISTEMA</strong> ${param.MENSAJE}
			  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
		</c:if>
		
		<br>
		
		<h3 class="text-center">LISTADO DE INSCRIPCIONES</h3>	      
	    
	    <!-- Modal PARA ACTUALIZAR-->
		<div class="modal fade" id="modalInscripcion" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">INSCRIPCION</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form id="formInscripcion" action="ServletInscripcion?accion=ACTUALIZAR" method="post">
				  <div class="form-group">
				    <label for="exampleNombre" class="form-label">ID Incripcion</label>
				    <input type="text" class="form-control" name="codigo" readonly value="0" id="id-inscripcion">
				  </div>
				  <div class="form-group">
				    <label for="exampleNombre" class="form-label">Nro de DNI</label>
				    <input type="text" class="form-control" name="dni" id="id-dni">
				  </div>
				  <div class="form-group">
				    <label for="examplePaterno" class="form-label">ID Carrera</label>
				    <input type="text" class="form-control" name="carrera" id="id-carrera">
				  </div>
				 <div class="form-group">
				    <label for="exampleMaterno" class="form-label">Fecha Inscripcion</label>
				    <input type="text" class="form-control" name="fecha" id="id-fecha">
				  </div>	
				 
				  <div class="modal-footer">
			      	<button type="submit" class="btn btn-primary">Grabar</button>
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
			      </div>
				</form>
		      </div>
		    </div>
		  </div>
		</div>
	    <!--fin modal PARA ACTUALIZAR-->
	    
	    
	    <!-- Modal PARA ELIMINAR-->
		<div class="modal fade" id="modalEliminar" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">SISTEMA</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form id="formInscripcion" action="ServletInscripcion?accion=ELIMINAR" method="post">
		        	<h4>Seguro de eliminar inscripcion?</h4>
				    <input type="hidden" class="form-control" name="codigoEliminar" id="codEliminar">
				  <div class="modal-footer">
			      	<button type="submit" class="btn btn-primary">SI</button>
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">NO</button>
			      </div>
				</form>
		      </div>
		    </div>
		  </div>
		</div>
	    <!--fin modal PARA ELIMINAR-->	  
	    
	    
	    <div class="mt-5">
	    <table id="tableInscripcion" class="table table-striped" style="width:100%">
        <thead>
            <tr>
                <th>ID Inscripcion</th>
                <th>Nro de DNI</th>
                <th>ID Carrea</th>
                <th>Fecha Inscripcion</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	
            
        </tbody>
    </table>
	</div>    
	    
	  
</div>

	<!-- JS principal -->
	<script src="js/jquery-3.5.1.js"></script>




	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>
		
	<!-- JS para la tabla -->
	<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>
	
	<!--JS para validar  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.0/js/bootstrapValidator.js"></script>
	<script src="datepicker/bootstrap-datepicker.js"></script> 
	
	<script>
	
	cargarInscripciones();
	
	$(document).on("click",".btn-eliminar",function(){
		//console.log(e);
		let cod;
		cod=$(this).parents("tr").find("td")[0].innerHTML;
		$("#codEliminar").val(cod);
	})

	$(document).on("click",".btn-buscar",function(){
		let cod,dni,carrera,fecha
		cod=$(this).parents("tr").find("td")[0].innerHTML;

		$.get("ServletInscripcion?accion=BUSCAR&codigo="+cod,function(response){
			//console.log(e);
			$("#id-inscripcion").val(response.IdInscripcion);
			$("#id-dni").val(response.dni)
			$("#id-carrera").val(response.IdCarrera)
			$("#id-fecha").val(response.FecInscripcion)
		})
		
	})
	
			function cargarInscripciones(){
			$.get("ServletInscripcionJSON",function(e){
				console.log(e);
				$.each(e,function(i,item){
					$("#tableInscripcion").append("<tr>"+
			                "<td>"+item.IdInscripcion+"</td>"+
			                "<td>"+item.dni+"</td>"+
			                "<td>"+item.IdCarrera+"</td>"+
			                "<td>"+item.FecInscripcion+"</td>"+
			                "<td><button type='button' class='btn btn-info btn-buscar' data-bs-toggle='modal' data-bs-target='#modalInscripcion'>BUSCAR</button></td>"+
			                "<td><button type='button' class='btn btn-danger btn-eliminar' data-bs-toggle='modal' data-bs-target='#modalEliminar'>ELIMINAR</button></td>"+
			            "</tr>");
				})
			    $('#tableInscripcion').DataTable();
			})
			
		}
	</script> 		
	<!-- Validacion -->
	<script>    
	    $(document).ready(function(){     
	        $('#formInscripcion').bootstrapValidator({      
	        	 fields:{
	        		 dni:{
	        			 validators:{
	        				 notEmpty:{
	        		 				message:'Campo nombre es obligatorio'
	        		 		 },
	        		 		regexp:{
        		 				regexp:/^[0-9]{8}$/,
        		 				message:'Campo dni solo 8 numeros'
        		 			}
	        			 }
	        		 },
	        		 carrera:{
	        			 validators:{
	        				 notEmpty:{
	        		 				message:'Campo carrera es obligatorio'
	        		 		 }
	        			 }
	        		 },
	        		 fecha:{
	        			 validators:{
	        				 notEmpty:{
	        		 				message:'Campo fecha es obligatorio'
	        		 		 }
	        			 }
	        		 }
	        	 }
	        });   
				
	    });    
	</script> 	
</body>
</html>
