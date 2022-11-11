<%@page import="com.jdc.scope.Counter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet Scope</title>
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css" />
</head>
<body>
			<%
				Object reqCounter=request.getAttribute("counter");
				Counter c1=null;
				if(reqCounter != null)
					c1=(Counter) reqCounter;
				else
					c1=new Counter();
			%>
			<%
				Object sesCounter=session.getAttribute("counter");
				Counter c2=null;
				if(sesCounter != null)
					c2=(Counter) sesCounter;
				else
					c2=new Counter();
			%>
			<%
				Object appCounter=application.getAttribute("counter");
				Counter c3=null;
				if(appCounter != null)
					c3=(Counter) appCounter;
				else
					c3=new Counter();
			%>
	<div class="container mt-5">
		<form action="counter" method="post">
			<div class="row g-3">
				<div class="col">
					<div class="card text-center">
						<div class="card hearder fs-2">Request Scope</div>
							<div class="card-body ">
							<div class="card-title fs-3">
							
								<%= c1.getCount() %>
							</div>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card text-center">
						<div class="card hearder fs-2">Session Scope</div>
							<div class="card-body ">
							<div class="card-title fs-3">
							
								<%= c2.getCount() %>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col">
					<div class="col">
					<div class="card text-center">
						<div class="card hearder fs-2">Application Scope</div>
							<div class="card-body ">
							<div class="card-title fs-3">
							
								<%= c3.getCount() %>
							</div>
						</div>
					</div>
				</div>
				</div>
			<input class="btn btn-primary" type="submit" value="Count Up" />
			</div>
		</form>
		<div class="row mt-2 p-1">
			<a href="invalidate" class="btn btn-danger">Clear Session</a>
		</div>
	</div>
</body>
</html>