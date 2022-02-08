<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html style="background-color:black;">
	<head >
		<meta charset="UTF-8">
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	    <title>Curso </title>
	</head>
	<body class="container">
		<h1>Nombre del Curso : <c:out value="${curso.name}"/>  </h1>
		<h3> Instructor :<c:out value="${curso.instructor}"/> </h3>
		<h3> Limite de Personas :<c:out value="${curso.capacidad}"/> </h3>
		<table class="table">
		    <thead >
		        <tr >
		            <th >Nombre </th>
		            <th >Registro</th>
		            <th >Acción</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${curso.usuarios}" var="user">
		        <tr>
		            <td scope="col"><c:out value="${user.name}"/> <c:out value="${user.lastName}"/></td>
		            <td ><c:out value="${user.createdAt}"/></td>
		            <td style="display: flex;">

							<c:if test="${curso.usuarios.contains(currentUser) && currentUser.id == user.id}"> <a style="color:red" href="/eliminarCurso/<c:out value="${curso.id}"/>/<c:out value="${user.id}"/>">Dejar Curso!</a></c:if>
		             </td>
			        </tr>
			        </c:forEach>
		    </tbody>
		    <a href="/crear"> Crear Curso!</a> <a href="/dashboard">Dashboard</a>
		</table >
		<div style="display:flex;">
			<a style="display:inline-block" class="btn btn-primary" href="/editar/<c:out value="${curso.id}"/>">Editar</a>
		    <form:form id="delete" action="/delete/${curso.id}" method="post">
				    <input type="hidden" name="_method" value="delete">
				    <button style="display:inline-block" class="btn btn-danger" type="button" onclick="sure()">Delete
					</button>
			</form:form>
		</div>
			<script type="text/javascript">
				function sure() {	
					Swal.fire({
						  title: 'Estas seguro que quieres eliminar el Curso?',
						  text: "no podras Recuperarlo!",
						  icon: 'warning',
						  showCancelButton: true,
						  confirmButtonColor: '#3085d6',
						  cancelButtonColor: '#d33',
						  confirmButtonText: 'Yes, delete it!'
						}).then((result) => {
						  if (result.isConfirmed) {
						    document.getElementById("delete").submit(); 
						  }
						})
				}
		</script>
	</body>
</html>