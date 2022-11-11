<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To do list</title>
<c:url value="../resource-css.jsp" var="css"></c:url>
<c:import url="${ css }"></c:import>
</head>
<body>

	<c:url value="../general/nav-bar.jsp" var="nav"></c:url>
	<c:import url="${ nav }"></c:import>
	
	
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-8">
				
				<h3 class="fw-bold text-success mb-2">To Do List</h3>
				
				<div class="row">
					<div class="col-3 ms-auto">
						<c:url value="/auth/todo-form" var="form"></c:url>
						<a href="${ form }" class="btn btn-success text-end">Create ToDo</a>
					</div>
				</div>
				
				<c:if test="${ not empty todoList }">
				
					<table class="table table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Target</th>
								<th>Status</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							
							<c:forEach var="todo" items="todoList">
								<tr>
									<td>${ todo.id }</td>
									<td>${ todo.name }</td>
									<td>${ todo.target }</td>
									<td>${ todo.status }</td>
									<td>
										<a href="" class="btn btn-outline-primary me-2">Edit</a>
										<a href="" class="btn btn-outline-danger">Delete</a>
									</td>
								</tr>
							</c:forEach>
							
						</tbody>
					</table>
				
				</c:if>
				
				<c:otherwise>
					<div class="alert alert-info">
						There is no to do item.
					</div>
				</c:otherwise>
				
			</div>
		</div>
	</div>
	
	
	

	<c:url value="../resource-js.jsp" var="js"></c:url>
	<c:import url="${ js }"></c:import>
</body>
</html>