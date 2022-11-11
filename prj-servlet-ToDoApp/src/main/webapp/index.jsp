<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo Home Page</title>

<c:url value="resource-css.jsp" var="css"></c:url>
<c:import url="${ css }"></c:import>

</head>
<body>

	<c:url value="general/nav-bar.jsp" var="nav"></c:url>
	<c:import url="${ nav }"></c:import>
	
	

	<c:url value="resource-js.jsp" var="js"></c:url>
	<c:import url="${ js }"></c:import>

</body>
</html>