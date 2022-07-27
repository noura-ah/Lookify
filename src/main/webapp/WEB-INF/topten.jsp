<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    


<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>Top Ten</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="container w-75">
		<c:if test="${not empty success}">
			<div class="alert alert-success mt-4"><c:out value="${success}"/></div>
		</c:if>
		
		<div class="d-flex align-items-center justify-content-between">
			<h3 class="m-2">Top Ten songs</h3>
			<a href='<c:url value="/dashboard"/>' class="mr-2" >Dashboard</a>
		</div>
		
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Rating</th>
					<th scope="col">Title</th>
					<th scope="col" >Artist</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${songs}" var="song">
					<tr>	
						
						<td ><c:out value="${song.getRating()}"/></td>
						<td ><a href='<c:url value="/songs/${song.getId()}"/>' ><c:out value="${song.getTitle()}"/></a></td>
						<td ><c:out value="${song.getArtist()}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
	</div>
    
	
</body>
</html>
