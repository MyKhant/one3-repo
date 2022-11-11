<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark text-light">
	
	<div class="container">
		<a class="navbar-brand fw-bold">ToDo App</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#coll">
			<span class="navbar-toggler-icon"></span>
		</button>
	
		<div class="navbar-collapse collapse" id="coll">
			<ul class="navbar-nav me-auto">
				<li class="nav-item">
					<c:url value="/home" var="home"></c:url>
					<a href="${ home }" class="nav-link">Todo List</a>
				</li>
			</ul>

		<c:if test="${ not empty user }">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a href="" class="btn btn-outline-light">
						<i class="fa-solid fa-right-from-bracket"></i> Sign Out
					</a>
				</li>
			</ul>
		</c:if>			
		</div>
	</div>

</nav>