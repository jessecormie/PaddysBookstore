<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">


<h3>Purchase History</h3>
<c:forEach var="ph" items="${purchaseHistory}">
	<table class="table table-bordered">
		<tr>
			<th>User</th>
			<th>Date</th>
			<th>Total</th>
		</tr>
		<tr>
			<td><c:out value="${ph.username}"></c:out></td>
			<td><c:out value="${ph.date}"></c:out></td>
			<td><c:out value="${ph.shoppingCartHistory.total}"></c:out></td>
		</tr>
		<tr>
			<th>Title</th>
			<th>Quantity</th>
			<th>Price</th>
		</tr>

		<c:forEach var="li"
			items="${ph.shoppingCartHistory.lineItemShoppingCart}">
			<tr>
				<td><c:out value="${li.book.title}"></c:out></td>
				<td><c:out value="${li.quantity}"></c:out></td>
				<td><c:out value="${li.book.price}"></c:out></td>
			</tr>

		</c:forEach>
	</table>
</c:forEach>
