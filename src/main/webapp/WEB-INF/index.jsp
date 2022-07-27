<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    


<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>Lookify</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="container w-75">
		<c:if test="${not empty success}">
			<div class="alert alert-success mt-4"><c:out value="${success}"/></div>
		</c:if>
		
		<div class="d-flex align-items-center justify-content-between">
			<div>
				<a href='<c:url value="/songs/new"/>' class="mr-2" >Add new</a>
				<a href='<c:url value="/search/topten"/>' >Top Songs</a>
			</div>
		
			<form class="row" method="post" action="/search">
				<div class="m-3"> 
					<input name="search" Class="form-control" />
				</div>
				<div class="m-3"> 
					<input type="submit" value="Search" class="btn btn-dark">
				</div>
			</form>
		</div>
		
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Title</th>
					<th scope="col">Rating</th>
					<th scope="col" >Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${songs}" var="song">
					<tr>	
						<td ><a href='<c:url value="/songs/${song.getId()}"/>' ><c:out value="${song.getTitle()}"/></a></td>
						<td ><c:out value="${song.getRating()}"/></td>
						<td >
							<form action='/songs/<c:out value="${song.getId()}"/>' method="post">
									<input type="hidden" name="_method" value="delete">
									<input type="submit" class="btn btn-link" value="Delete">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
	</div>
    
	
</body>
</html>
