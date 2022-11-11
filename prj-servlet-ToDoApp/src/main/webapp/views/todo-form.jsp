<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDo Form</title>
<c:url value="../resource-css.jsp" var="css"></c:url>
<c:import url="${ css }"></c:import>
</head>
<body>

	<c:url value="../general/nav-bar.jsp" var="nav"></c:url>
	<c:import url="${ nav }"></c:import>
	
	<div class="container mt-4">
		<div class="row">
			<div class="col-5">
				<h3 class="text-success fw-bold mb-3">Create New ToDo Item</h3>
				
				<c:url value="/auth/todo-form" var="form"></c:url>
				<form action="${ form }" method="post">
				
					<label for="name" class="form-label">Item Name</label>
					<input type="text" name="name" id="name" class="form-control mb-2" />
					
					<label for="target" class="form-label">Target</label>
					<input type="date" name="target" id="target" class="form-contorl mb-2" />
					
					<label for="status" class="form-check-label">Status</label>
					<input type="checkbox" id="status" class="form-check-control mb-2" />
					
					<button class="btn btn-primary" type="submit">Save Item</button>
					
				</form>
			</div>
		</div>
	</div>

	<c:url value="../resource-js.jsp" var="js"></c:url>
	<c:import url="${ js }"></c:import>
</body>
</html>