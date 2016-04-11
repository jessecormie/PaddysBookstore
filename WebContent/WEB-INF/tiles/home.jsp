<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">

<p><a href= "${pageContext.request.contextPath}/book">Show all books</a></p>

<sec:authorize access="hasRole('ROLE_ADMIN')">
<p><a href="<c:url value = '/admin'/>">Admin</a></p>
</sec:authorize>
