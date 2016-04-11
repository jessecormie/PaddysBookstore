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

<h3>Book Information</h3>
<c:forEach var="book" items="${book}">
	<table class="table table-bordered">
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>Price</th>
			<th>Category</th>
			<th>Stock</th>
			<th>Edit Stock</th>
		</tr>
		<tr>
			<td><c:out value="${book.title}"></c:out></td>
			<td><c:out value="${book.author}"></c:out></td>
			<td><c:out value="${book.price}"></c:out></td>
			<td><c:out value="${book.category}"></c:out></td>
			<td><c:out value="${book.stock}"></c:out></td>
			<td>

				<form accept-charset="UTF-8"
					action="${pageContext.request.contextPath}/stock/${book.title}"
					method="post">
					<div class="form-group">
						<label class="col-md-4 control-label" for="textinput">Number</label>
						<div class="col-md-4">
							<input class="form-control input-md" name="number" type="number" />
							<label for="add">Add</label> <input type="radio" name="sum"
								id="sum" value="add" checked="checked"><br> <label
								for="subtract">Subtract</label> <input type="radio" name="sum"
								id="sum" value="subtract"> <label
								class="col-md-4 control-label" for="singlebutton"></label>
							<button id="submite" name="singlebutton" class="btn btn-primary"
								type="submit">Enter</button>
						</div>
					</div>
				</form>
			</td>

		</tr>
	</table>
</c:forEach>
<H3>Set Sale by Category</H3>

<form accept-charset="UTF-8" action="${pageContext.request.contextPath}/setSale" method="post">

	<div class="form-group">
		<div class="col-md-4">
			<label for="add">Fantasy</label> <input type="radio" name="category"
				id="category" value="Fantasy" checked="checked"> <br> <label
				for="subtract">Crime</label> <input type="radio" name="category"
				id="category" value="Crime"> <br> <label for="subtract">Fiction</label>
			<input type="radio" name="category" id="category" value="Fiction">
			<br>
			<!-- <label class="col-md-4" for="singlebutton"></label> -->
			<button id="submite" name="singlebutton" class="btn btn-primary"
				type="submit">Enter</button>
		</div>
	</div>

</form>
