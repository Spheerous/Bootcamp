<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="container">
			<nav style="justify-content: space-around;" class="navbar navbar-expand-lg navbar-dark bg-dark">
		  <div  class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		  	   <li class="nav-item">
		        <a class="nav-link" href="/new/student">New Student</a>
		  	</li>
		  		  	</li>
		  	   <li class="nav-item">
		        <a class="nav-link" href="new/info">New Address</a>
		  	</li>
		    </ul>
	
		  </div>
		</nav>
	<h1>All Students</h1>
	<table class="table">
		    <thead >
		        <tr>
		            <th >Name </th>
		            <th> Age</th>
		            <th>Address</th>
		            <th>City</th>
		            <th>State</th>
		        </tr>
		    </thead>
		    <tbody>
	        	<c:forEach items="${student}" var="students">
	        		<tr>
		          		<td> <c:out value="${students.name}"/> <c:out value="${students.lastName}"/> </td>
		          		<td> <c:out value="${students.age}"/> </td>
		          		<td>  <c:out value="${students.info.address}"/></td>
		          		<td> <c:out value="${students.info.city}"/></td> 
						<th> <c:out value="${students.info.state}"/></th>   	  
		        	</tr>
		        </c:forEach>
	        </tbody>
		</table >

</body>
</html>