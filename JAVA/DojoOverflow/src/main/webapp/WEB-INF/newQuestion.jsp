<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html class="bg-dark">
	<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<meta charset="UTF-8">
		<title>New Question</title>
	</head>
	<body class="container" style="background-color:silver">
			<nav style="justify-content: space-around;" class="navbar navbar-expand-lg navbar-dark bg-dark">
		  <div  class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		  	   <li class="nav-item">
		        <a class="nav-link" href="/home">Home</a>
		  	</li>
		    </ul>
		  </div>
		</nav>
		<h1 style="color: rgba(255,255,255,.55); padding :10px" class="display-3 bg-dark">Post a New Question</h1>
		<form:form action="/create" method="POST" modelAttribute="quest">
	   		 <p>
		        <form:label class="form-label" path="question">Your Question :</form:label>
		        <form:errors path="question"/>
		        <form:input class="form-control" path="question"/>
	    	</p>
	    	 		 <p>
		        <form:label class="form-label" path="tag">Tags for Your Question :</form:label>
		        <form:errors path="tag"/>
		        <form:input class="form-control" path="tag"/>
	    	</p>
	    	

	  
    
	    	<input  class="btn btn-primary" type="submit" value="Post"/>
		</form:form> 
	
	
	</body>
</html>