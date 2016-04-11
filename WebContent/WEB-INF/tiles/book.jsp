<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">

<div class="container">
	<h2>Books</h2>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Title</th>
				<th>Author</th>
				<th>Category</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${book}">
				<tr>
					<td><a href="${pageContext.request.contextPath}/book/${book.title}"><c:out
								value="${book.title}"></c:out></a></td>
					<td><c:out value="${book.author}"></c:out></td>
					<td><c:out value="${book.category}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>