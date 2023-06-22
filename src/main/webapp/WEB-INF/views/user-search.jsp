<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
    <title>Edit User</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
        <%@ include file="header.jsp" %>

    <h1>Edit User</h1>
    <form method="post" action="<%= baseUrl %>/users/search" modelAttribute="search">
        <div class="form-group">
            <label for="id">Id:</label>
            <input type="text" class="form-control" id="id" name="id">
        </div>
         <button type="submit" class="btn btn-primary">Search</button>
    </form>
</div>
</body>
</html>
