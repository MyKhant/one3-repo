<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Info Coolies</title>
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<div class="col-4">
				<a href="info" class="btn btn-success">Show Info</a>
			</div>
		</div>
		<div class="row">
			<div class="col-3">
				<p>Name</p>
				<p>Value</p>
				<p>Version</p>
			</div>
			<div class="col-3">
				<p><%= session.getAttribute("name") %></p>
				<p><%= session.getAttribute("value") %></p>
				<p><%= session.getAttribute("version") %></p>
			</div>
		</div>
	</div>
</body>
</html>