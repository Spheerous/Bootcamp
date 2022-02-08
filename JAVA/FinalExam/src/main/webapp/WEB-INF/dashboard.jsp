<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head style="background-color:black;">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Welcome Page</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
	<body>
	    <h1>Bienvenido <c:out value="${currentUser.name}"/>  <c:out value="${currentUser.lastName}"/></h1>
	    
	    <form style="display:flex;justify-content:flex-end;"id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input class="btn-primary"style="margin-right: 3rem;" type="submit" value="Logout!" />
	    </form>
	    
	    <table class="table">
		    <thead >
		        <tr >
		            <th >Curso</th>
		            <th >Instructor</th>
		            <th >Capacidad</th>
		            <th >Acción</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${cursos}" var="curso">
		        <tr>
		            <td scope="col"><a href="/show/<c:out value="${curso.id}"/>"><c:out value="${curso.name}"/></a></td>
		            <td ><c:out value="${curso.instructor}"/></td>
		            <td>  <c:out value="${curso.usuarios.size()}"/> /<c:out value="${curso.capacidad}"/> </td>
		            <td style="display: flex;">
		            	
		            	
			            
							<c:if test="${curso.usuarios.contains(currentUser)}">ya Estas Adentro</c:if>
				         	<c:if test="${!curso.usuarios.contains(currentUser) && curso.usuarios.size() != curso.capacidad}"> <a href="/añadirUser/<c:out value="${curso.id}"/>/<c:out value="${currentUser.id}"/>">unirse!</a>
				         		
				         		<form:form type="hidden" path="user" value="${currentUser.id}"/>
				         		<form:form type="hidden" path="curso" value="${curso.id}"/>
				         	
				         	
				         	
				         	
				         	
				         	 </c:if>
				         	<c:if test="${curso.usuarios.size() == curso.capacidad}">full</c:if>
				         	
			      
		             </td>
			        </tr>
			        </c:forEach>
		    </tbody>
		    <a href="/crear"> Crear Curso!</a>
		</table >
    </body>
</html>