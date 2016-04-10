<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<c:forEach var="review" items="${review}">
	<article class="row">
		<div class="col-md-2 col-sm-2 hidden-xs">
			<figure class="thumbnail">
				<img class="img-responsive"
					src="http://www.keita-gaming.com/assets/profile/default-avatar-c5d8ec086224cb6fc4e395f4ba3018c2.jpg" />
				<figcaption class="text-center">
					<c:out value="${review.user.firstName}"></c:out>
					<c:out value="${review.user.lastName}"></c:out>
				</figcaption>
			</figure>
		</div>
		<div class="col-md-10 col-sm-10">
			<div class="panel panel-default arrow left">
				<div class="panel-body">
					<header class="text-left">
						<div class="comment-user">
							<i class="fa fa-user"></i>
							<c:out value="${review.reviewTitle}"></c:out>
						</div>
						<time class="comment-date" datetime="${review.date}">
							
							<i class="fa fa-clock-o"></i>
							<c:out value="${review.date}"></c:out>
						</time>
					</header>
					<div class="comment-post">
						<p>
							<c:out value="${review.reviewContent}"></c:out>
						</p>
					</div>
					<!-- 	<p class="text-right">
						<a href="#" class="btn btn-default btn-sm"><i
							class="fa fa-reply"></i> reply</a>
					</p> -->
				</div>
			</div>
		</div>
	</article>
</c:forEach>