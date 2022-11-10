<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		padding: 20px;
	}
	form{
		margin-bottom: 10px;
	}
	table{
		width: 50
	}
	.fl{
		display: flex;
		flex-wrap: no-wrap;
		gap: 5px;
	}
	.fl img{
		max-height: 30vw;
		max-width: 200px;
	}
</style>
</head>
<body>
	<h2>File Upload and download</h2>
	<br />
	<c:url value="/file-upload" var="fileUpload"></c:url>
	<form action="${ fileUpload }" method="post" enctype="multipart/form-data">
		<input type="file" name="upload" />
		<input type="submit" value="Upload" />
	</form>
	<c:if test="${not empty items }">
		<table>
			<thead>
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${ items }" var="item">
					<tr>
						<td>${ item.name }</td>
						<td>${ item.price }</td>
						<td>${ item.quantity }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<hr />
	<h2>Image Upload</h2>
	<c:url value="/img-upload" var="imgUpload"></c:url>
	<form action="${ imgUpload }" method="post" enctype="multipart/form-data">
		<input type="file" name="imgUpload" accept="image/*"/>
		<input type="submit" value="Image Upload"></input>
	</form>
	<div class="fl">
		<c:if test="${ not empty img }">
			<img src="${ img }"></img>
		</c:if>
	</div>
	<hr />
	<h2>Multiple Image Upload</h2>
	<c:url value="/multiple-upload" var="imgUpload"></c:url>
	<form action="${ imgUpload }" method="post" enctype="multipart/form-data">
		<input type="file" name="images" accept="image/*" multiple/>
		<input type="submit" value="Image Upload"></input>
	</form>
	<div class="fl">
		<c:if test="${ not empty imgs }">
			<c:forEach items="${ imgs }" var="img">
				<img src="${ img }"></img>
			</c:forEach>
		</c:if>
	</div>
	<hr />
	<c:url value="/file-download" var="download"></c:url>
	<a href="${ download }">Download File</a>
</body>
</html>