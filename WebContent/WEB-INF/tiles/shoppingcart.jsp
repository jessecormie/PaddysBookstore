<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/script/jquery.js">

<div class="container">
	<h2>Shopping Cart</h2>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Title</th>
				<th>Quantity</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="line" items="${lineitemlist}">
				<tr>
					<td><c:out value="${line.book.title}"></c:out></td>
					<td><c:out value="${line.quantity}"></c:out></td>
					<td><c:out value="${line.book.price * line.quantity}"></c:out></td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<th>Total:</th>
				<td><c:out value="${totalPrice}"></c:out></td>
			</tr>
		</tbody>
	</table>

	<form accept-charset="UTF-8"
		action="${pageContext.request.contextPath}/checkout" method="post">
		<button class="btn btn-success btn-lg" type="submit">Checkout</button>
	</form>
</div>