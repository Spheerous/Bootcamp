<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html class="bg-dark">
	<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body class="container" style="background-color:silver">
		<nav style="justify-content: space-around;" class="navbar navbar-expand-lg navbar-dark bg-dark">
		  <div  class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item">
		        <p Style="color:white;"class="nav-link" >Dojo : <c:out value="${dojo.name}"/></p>
		  	</li>
		  	   <li class="nav-item">
		        <a class="nav-link" href="/dojo/new">New Dojo</a>
		  	</li>
		  		  	</li>
		  	   <li class="nav-item">
		        <a class="nav-link" href="/info/">Home</a>
		  	</li>
		    </ul>
	
		  </div>
		</nav>
		
		<table class="table">
			    <thead >
			        <tr >
			            <th >firstName</th>
			            <th >LastName</th>
			            <th >Age</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${list}" var="ninja">
			        <tr>
			            <td scope="col"><c:out value="${ninja.firstName}"/></td>
			            <td ><c:out value="${ninja.lastName}"/></td>
			            <td ><c:out value="${ninja.age}"/></td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table >
	
	</body>
</html>