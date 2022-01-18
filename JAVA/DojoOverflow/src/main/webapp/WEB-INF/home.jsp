<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html class="bg-dark">
	<head >
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<meta charset="UTF-8">
		<title>Products And Categories</title>
	</head>
	<body class="container" style="background-color:silver">
			<nav style="justify-content: space-around;" class="navbar navbar-expand-lg navbar-dark bg-dark">
		  <div  class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		  	   <li class="nav-item">
		        <a class="nav-link" href="/new/question">New Question</a>
		  	</li>
		  		  	
		    </ul>
	
		  </div>
		</nav>
		<h3 style="color: rgba(255,255,255,.55); padding :10px" class="display-3 bg-dark">Questions</h3>
		<table class="table">
		    <thead >
		        <tr>
		            <th >Questions </th>
		             <th >Tags </th>
		            
		       
		        </tr>
		    </thead>
		    <tbody>
	        	<c:forEach items="${questions}" var="quest">
	        		<tr>
		          		<td scope="col"> <a href="/show/<c:out value="${quest.id}"/>"> <c:out value="${quest.question}"/> </a></td>
		          		<c:forEach items="${quest.tags}" var="t">
		          			<td> <c:out value="${t.subject}"/> </td>  
		          		</c:forEach>
		        	</tr>
		        </c:forEach>
	        </tbody>
		</table >

</body>
</html>