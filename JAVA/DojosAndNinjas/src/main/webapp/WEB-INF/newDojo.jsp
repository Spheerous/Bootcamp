<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html class="bg-dark">
	<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<meta charset="UTF-8">
		<title>new dojo</title>
	</head>
	<body class="container" style="background-color:silver">
			<nav style="justify-content: space-around;" class="navbar navbar-expand-lg navbar-dark bg-dark">
		  <div  class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		  	   <li class="nav-item">
		        <a class="nav-link" href="/ninjas/new">New Ninja</a>
		  	</li>
		  		  	</li>
		  	   <li class="nav-item">
		        <a class="nav-link" href="/info/">Home</a>
		  	</li>
		    </ul>
		  </div>
		</nav>
		<h1 style="color: rgba(255,255,255,.55); padding :10px" class="display-3 bg-dark">Create a New Dojo</h1>
		<form:form action="/createD" method="POST" modelAttribute="dojo">
	   		 <p>
		        <form:label class="form-label" path="name">Name:</form:label>
		        <form:errors path="name"/>
		        <form:input class="form-control" path="name"/>
	    	</p>
	  
	    	<input class="btn btn-primary" type="submit" value="Register"/>
		</form:form> 
	
	
	</body>
</html>