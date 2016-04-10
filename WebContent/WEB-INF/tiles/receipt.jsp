<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/script/jquery.js">

<div class="row">
	<div
		class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
		<div class="row">
			<div class="col-xs-6 col-sm-6 col-md-6">
				<address>
					<strong><c:out value="${sp.address}"></c:out></strong> <br>
					<c:out value="${sp.city}"></c:out>
					<c:out value="${sp.zip}"></c:out>
					<br>
					<c:out value="${sp.country}"></c:out>
				</address>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-6 text-right">
				<p>
					<em>Date: <c:out value="${currentDate}"></c:out></em>
				</p>
				<p>
					<em>Card Number: <c:out value="${sp.cardNumber}"></c:out></em>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="text-center">
				<h1>Receipt</h1>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Product</th>
						<th>#</th>
						<th class="text-center">Price</th>
						<th class="text-center">Total</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="line" items="${lineitemlist}">
						<tr>
							<td class="col-md-9"><em><c:out
										value="${line.book.title}"></c:out></em></td>
							<td class="col-md-1" style="text-align: center"><c:out
									value="${line.quantity}"></c:out></td>
							<td class="col-md-1 text-center">$<c:out
									value="${line.book.price}"></c:out>0
							</td>
							<td class="col-md-1 text-center">$<c:out
									value="${line.book.price * line.quantity}"></c:out>0
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td class="text-right"><h4>
								<strong>Total:</strong>
							</h4></td>
						<td class="text-center text-danger"><h4>
								<strong>$<c:out value="${totalPrice}0"></c:out></strong>
							</h4></td>
					</tr>				
				</tbody>	
			</table>
			<div align="center">
			<form accept-charset="UTF-8"
						action="${pageContext.request.contextPath}/purchaseHistory"
						method="post">
						<button class="btn btn-success btn-lg" type="submit">Done</button>
					</form>
					</div>
		</div>
	</div>
</div>