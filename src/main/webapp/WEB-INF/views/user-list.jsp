<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.users.model.*,java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
            <%@ include file="header.jsp" %>

        <h2>User List</h2>

         <% for (User crossing : (List<User>)request.getAttribute("users")) { %>

        <ul class="list-group">
            <li class="list-group-item">ID: <%= crossing.getId() %>
            </li>
            <li class="list-group-item">Name: <%= crossing.getName() %>
            </li>
        </ul>
        <a href="<%= baseUrl %>/users/edit/<%= crossing.getId() %>" class="btn btn-primary">Edit</a>

        <hr />
          <% } %>
    </div>
</body>
</html>
