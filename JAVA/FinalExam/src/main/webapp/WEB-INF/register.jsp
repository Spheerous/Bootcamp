<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html style="background-color:black;">
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	    <title>Registration Page</title>
	</head>
	<body class="container"style="display:flex;">
	<div style="width: 35rem;">
	<h1>Registrar!</h1>
    
    <p><form:errors path="user.*"/></p>
    
    <form:form  method="POST" action="/registration" modelAttribute="user">
        <div class="row">
	         <p class="col">
	            <form:label class="form-label" path="name">Nombre :</form:label>
	            <form:input type="name"  class="form-control" path="name"/>
	        </p>
	          <p class="col">
	            <form:label class="form-label" path="lastName">Apellido :</form:label>
	            <form:input type="lastName" class="form-control" path="lastName"/>
	        </p>
	     </div>
	     <div class="row">   
	        <p class="col">
	            <form:label class="form-label" path="email">Email:</form:label>
	            <form:input type="email" class="form-control" path="email"/>
	        </p>  
	    </div>
	    <div class="row">    	
	        <p class="col">
	            <form:label path="password">Contraseña :</form:label>
	            <form:password  class="form-control" path="password"/>
	        <p class="col">
	        <p>
	            <form:label path="passwordConfirm">Confirme su Contraseña :</form:label>
	            <form:password  class="form-control" path="passwordConfirm"/>
	        </p>
	    </div>    
	       
	        <input class="btn-primary" type="submit" value="Registrar!"/>
    </form:form>
	</div>
    
    <div style="display:inline-block; width:25rem;margin: 13rem;">
	    <h1>Login</h1>
    	 <c:if test="${error != null}">
   			 <c:out value="${error}"></c:out>
    	</c:if>
	        <c:out value="${errorMessage}"></c:out>
			<form method="POST" action="/login">
				<p>
				    <label for="email">Email</label>
				    <input type="email" id="email" name="username"/>
				</p>
				<p>
				    <label for="password">Password</label>
				    <input type="password" id="password" name="password"/>
				</p>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<input class="btn-primary" type="submit" value="Login!"/>
			</form>
    </div>
	
	</body>
</html>