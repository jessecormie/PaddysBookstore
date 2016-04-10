<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">

<br>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value = '/'/>">Bookstore</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/book">Show All Books</a></li>
				<li><a href="${pageContext.request.contextPath}/shoppingcart">Shopping Cart</a></li>
				<li><sec:authorize access="hasRole('ROLE_ADMIN')">
						<a href="<c:url value = '/admin'/>">Admin</a>
					</sec:authorize></li>
				<li>
				<sec:authorize access="!isAuthenticated()">
					<a class="login" href="<c:url value = '/login'/>">Log In</a>
				</sec:authorize>

				<sec:authorize access="isAuthenticated()">
					<a class="login"
						href="<c:url value = '/j_spring_security_logout'/>">Log Out</a>
				</sec:authorize></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>
