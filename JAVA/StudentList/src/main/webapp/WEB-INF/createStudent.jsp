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
		    <a class="nav-link active" aria-current="page" href="/leng">Dashboard</a>
		  </li>
		</ul>
		<h2>Register a New Student</h2>	
		<form:form action="/student" method="POST" modelAttribute="student">
	   		 <p>
		        <form:label class="form-label" path="name">First Name :</form:label>
		        <form:errors path="name"/>
		        <form:input class="form-control" path="name"/>
	    	</p>
	   		 <p>
		        <form:label class="form-label" path="lastName">Last Name :</form:label>
		        <form:errors path="lastName"/>
		        <form:input class="form-control" path="lastName"/>
	    	</p>
	    	<p>
		        <form:label class="form-label" path="age">Age :</form:label>
		        <form:errors path="age"/>
		        <form:input class="form-control" path="age"/>
	    	</p>
	   
	    	<input class="btn btn-primary" type="submit" value="Register"/>
		</form:form>
	
	</body>
</html>