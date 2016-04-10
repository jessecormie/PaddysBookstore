<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">


	<h3>Authorized Users Only</h3>

	<table class="formtable">
		<tr>
			<td>Email</td>
			<td>Role</td>
			<td>Enabled</td>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td><c:out value="${user.username}"></c:out></td>
				<td><c:out value="${user.authority}"></c:out></td>
				<td><c:out value="${user.enabled}"></c:out></td>
		</c:forEach>
	</table>

