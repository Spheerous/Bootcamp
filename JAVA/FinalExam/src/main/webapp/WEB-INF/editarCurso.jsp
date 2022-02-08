<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html style="background-color:black;">
	<head>
		<meta charset="UTF-8">
		<title>Edit</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<link rel=stylesheet type="text/css" href="CSS/index.css">
	</head>
	<body class="container">
		<ul class="nav justify-content-end">
		  <li class="nav-item">
		    <a class="nav-link active" aria-current="page" href="/dashboard">Dashboard</a>
		  </li>
		</ul>
		<p><form:errors path="curso.*"/></p>
		<form:form action="/${curso.id}" method="POST" modelAttribute="curso">
			<input type="hidden" name="_method" value="put">
		 	<p>
	       <form:label class="form-label" path="name">Nombre :</form:label>

			<form:input  class="form-control" path="name"/>
			</p>
			<p>
		    <form:label  class="form-label" path="instructor">Instructor :</form:label>
		
			<form:textarea class="form-control" path="instructor"/>
			</p>
			<p>
		    <form:label class="form-label" path="capacidad">Capacidad :</form:label>
			<form:errors path="capacidad"/>
			<form:input type="number" class="form-control" path="capacidad"/>
			</p>  
			<input class="btn btn-primary" type="submit" value="Guardar Cambios"/> 
		</form:form>
	
	</body>
</html>