<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">

<sf:form class="form-horizontal" id="details" method="post"
	action="${pageContext.request.contextPath}/createaccount"
	commandName="user">
	<fieldset>

		<!-- Form Name -->
		<legend>Register</legend>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">First
				name</label>
			<div class="col-md-4">
				<sf:input class="form-control input-md" placeholder="John"
					path="firstName" name="firstName" type="text" required="" />

				<sf:errors path="firstName" cssClass="error"></sf:errors>

			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Last
				name</label>
			<div class="col-md-4">
				<sf:input class="form-control input-md" required=""
					placeholder="Smith" path="lastName" name="lastName" type="text" />
				<sf:errors path="lastName" cssClass="error"></sf:errors>
			</div>
		</div>
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="email">E-mail</label>
			<div class="col-md-4">

				<sf:input placeholder="john.smith@mail.com"
					class="form-control input-md" required="" path="username" name="username"
					type="text" />
				<sf:errors path="username" cssClass="error"></sf:errors>
			</div>
		</div>
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="password">Password</label>
			<div class="col-md-4">
				<sf:input placeholder="password" class="form-control input-md"
					required="" path="password" name="password" type="password" />
			</div>
		</div>
		<!-- Button -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="singlebutton"></label>
			<div class="col-md-4">
				<button id="singlebutton" name="singlebutton"
					class="btn btn-primary">Register</button>
			</div>
		</div>
	</fieldset>
</sf:form>
