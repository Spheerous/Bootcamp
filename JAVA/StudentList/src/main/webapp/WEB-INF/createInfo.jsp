<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
	<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		<meta charset="UTF-8">
		<title>New Student</title>
	</head>
	<body class="container">
		<ul class="nav justify-content-end">
		  <li class="nav-item">
		    <a class="nav-link active" aria-current="page" href="/dashboard">Dashboard</a>
		  </li>
		</ul>
		<h2>Register a Address</h2>	
		<form:form action="/create" method="POST" modelAttribute="info">
	   		 	<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <label class="input-group-text" for="inputGroupSelect01">Student</label>
				  </div>
				<form:select class="custom-select" id="inputGroupSelect01" path="student">
				    <option selected>Choose...</option>
				    <c:forEach items="${list}" var="lista">
				    	<option Value="<c:out value="${lista.id}"/>"> <c:out value="${lista.name}"/> <c:out value="${lista.lastName}"/></option>		    
			   		 </c:forEach>
	  			</form:select>
	  			</div>
	   		 <p>
		        <form:label class="form-label" path="Address">Address :</form:label>
		        <form:errors path="Address"/>
		        <form:input class="form-control" path="Address"/>
	    	</p>
	   		 <p>
		        <form:label class="form-label" path="city">City :</form:label>
		        <form:errors path="city"/>
		        <form:input class="form-control" path="city"/>
	    	</p>
	    	<p>
		        <form:label class="form-label" path="State">State :</form:label>
		        <form:errors path="State"/>
		        <form:input class="form-control" path="State"/>
	    	</p>
	   
	    	<input class="btn btn-primary" type="submit" value="Register"/>
		</form:form>
	
	</body>
</html>