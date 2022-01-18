<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<meta charset="UTF-8">
		<title>Question</title>
	</head>
	<body>
		<h1> <c:out value="${Question.question}"/>
		</h1>
		<form:form action="/create/answer" method="POST" modelAttribute="ans">
				<form:input type="hidden" path="question.id" value="${Question.id}"/>
	   		 <p>
		        <form:label class="form-label" path="answer">Answer :</form:label>
		        <form:errors path="answer"/>
		        <form:input class="form-control" path="answer"/>
	    	</p> 
	    	<input class="btn btn-primary" type="submit" value="Register"/>
		</form:form> 
		<table class="table">
		    <thead >
		        <tr>
		            <th >Answers of this question </th>
		            
		       
		        </tr>
		    </thead>
		    <tbody>
		    		<c:forEach items="${Question.answers}" var="ans" >
	        		<tr>
		          		<td scope="col"> <c:out value="${ans.answer}"/></td>
		        	</tr>
		    		
		    		</c:forEach>
		          
	        </tbody>
		</table >
		
	</body>
</html>