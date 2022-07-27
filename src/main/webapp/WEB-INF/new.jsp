<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    


<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>Create a song</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="container w-75">
		
		
		<div class="container w-75">
			<div class="d-flex align-items-center justify-content-between">
				<h1 class="mb-2">Add a Song:</h1>
				<a href="/dashboard" class="mt-2">Dashboard</a>
			</div>
			<form:form class="border border-3 p-4 border-dark" method="post" modelAttribute="song" action="/songs/new">
			<div class="mb-3"> 
				<form:label path="title" class="form-label">Title:</form:label>
				<form:input  path="title" cssClass="form-control" cssErrorClass="form-control is-invalid"  />
				<form:errors path="title" cssClass="invalid-feedback"/>
			</div>
			<div class="mb-3">
				<form:label path="artist" class="form-label">Artist:</form:label>
				<form:input path="artist" cssClass="form-control" cssErrorClass="form-control is-invalid"  />
				<form:errors path="artist" cssClass="invalid-feedback"/>
			</div>
			<div class="mb-3">
				<form:label path="rating" class="form-label">Rating(1-10): </form:label>
				<form:input  path="rating" type="number" cssClass="form-control" cssErrorClass="form-control is-invalid"  />
				<form:errors  path="rating" cssClass="invalid-feedback"/>
			</div>
			<input type="submit" value="Submit" class="btn btn-dark">
		</form:form>
		</div>
		
	</div>
    
	
</body>
</html>
