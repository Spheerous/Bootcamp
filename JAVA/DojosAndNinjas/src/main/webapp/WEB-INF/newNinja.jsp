<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
	<head class="bg-dark">
		<meta charset="UTF-8">
		<title>new Ninja</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body class="container" style="background-color:silver">
				<nav style="justify-content: space-around;" class="navbar navbar-expand-lg navbar-dark bg-dark">
		  <div  class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		  	   <li class="nav-item">
		        <a class="nav-link" href="/ninjas/new">New Dojo</a>
		  	</li>
		  	   <li class="nav-item">
		        <a class="nav-link" href="/info/">Home</a>
		  	</li>
		    </ul>
		  </div>
		</nav>
		<h1 style="color: rgba(255,255,255,.55); padding :10px" class="display-3 bg-dark">Create a New Ninja</h1>
		
		<form:form action="/createN" method="POST" modelAttribute="ninja">
				<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <label class="input-group-text" for="inputGroupSelect01">Dojo</label>
				  </div>
				<form:select class="custom-select" id="inputGroupSelect01" path="dojo.id">
				    <option selected>Choose...</option>
				    <c:forEach items="${dojos}" var="dojo">
				    	<option Value="<c:out value="${dojo.id}"/>"><c:out value="${dojo.name}"/></option>		    
			   		 </c:forEach>
	  			</form:select>
	  			</div>
	   		 <p>
		        <form:label class="form-label" path="firstName">First Name</form:label>
		        <form:errors path="firstName"/>
		        <form:input class="form-control" path="firstName"/>
	    	</p>
	   		 <p>
		        <form:label class="form-label" path="lastName">Last Name </form:label>
		        <form:errors path="lastName"/>
		        <form:textarea class="form-control" path="lastName"/>
	   		 </p>
	   		 <p>
		        <form:label class="form-label" path="age">Age</form:label>
		        <form:errors path="age"/>
		        <form:input class="form-control" path="age"/>
	    	</p>  
	    	<input class="btn btn-primary" type="submit" value="Register"/>
		</form:form> 
	
	
	</body>
</html>