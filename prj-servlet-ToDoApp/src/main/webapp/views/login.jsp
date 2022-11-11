<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>

<c:url value="../resource-css.jsp" var="cs"></c:url>
<c:import url="${ cs }"></c:import>

</head>
<body>

	<div class="container">
		<div class="row justify-content-center align-items-center"
			style="height: 100vh;">
			<div class="col-5">

				<div class="card">
					<h3 class="card-header text-center">Log In</h3>
					<div class="card-body">
						<c:url value="/login" var="login"></c:url>
						<form action="${ login }" method="post">
							<label for="loginId" class="form-label">Login Id</label> <input
								type="text" name="loginId" id="loginId"
								class="form-control mb-3" /> <label for="password"
								class="form-label">Password</label> <input type="password"
								name="password" id="password" class="form-control mb-3" />

							<button class="btn btn-primary" type="submit">Log In</button>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>


	<c:url value="../resource-js.jsp" var="js"></c:url>
	<c:import url="${ js }"></c:import>

</body>
</html>