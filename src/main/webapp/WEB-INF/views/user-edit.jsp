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
    <form method="post" action="<%= baseUrl %>/users/save" modelAttribute="user">
        <input type="hidden" name="id" value="${user.id}"/>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="${user.name}">
        </div>
        <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" class="form-control" id="email" name="email" value="${user.email}">
                </div>

          <div class="form-group">
                             <label for="phone">Phone:</label>
                             <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}">
                         </div>

                          <div class="form-group">
                                             <label for="address">Address:</label>
                                             <input type="text" class="form-control" id="address" name="address" value="${user.address}">
                                         </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>
</body>
</html>
