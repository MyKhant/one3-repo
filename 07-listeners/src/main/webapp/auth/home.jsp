<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Form</title>
</head>
<c:import url="./../resource.jsp"></c:import>
<body>
	<div class="container mt-4">
		<h2>User List</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Address</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${ model.findAll() }">
					<tr>
						<td>${ user.id }</td>
						<td>${ user.firstName }</td>
						<td>${ user.lastName }</td>
						<td>${ user.email }</td>
						<td>${ user.phone }</td>
						<td>${ user.address }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table> 
		<div class="alert alert-warning" ${ not empty message }>
			${ message }
		</div>
	</div>
</body>
</html>