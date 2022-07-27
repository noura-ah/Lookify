<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Show a song</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<body>
	<div class="container w-50 border border-3 p-4 border-dark">
		
		<div class="d-flex align-items-center justify-content-between">
			<h3>Title: <c:out value="${song.getTitle()}"/></h3> 
			<a href="/dashboard">Dashboard</a>
		</div>
		<p>Artist: <c:out value="${song.getArtist()}"/></p> 
		<p>Rating: <c:out value="${song.getRating()}"/></p>
		
		<div class="row ml-1">
			<form action='/songs/<c:out value="${song.getId()}"/>' method="post">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" class="btn btn-light" value="Delete">
			</form>
		</div>
		
	</div>
    
	
</body>
</html>