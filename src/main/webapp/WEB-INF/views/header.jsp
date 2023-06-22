<%
String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<div class="row">
    <a class="btn btn-primary" href="<%= baseUrl %>/users/list">User List</a>
    <a class="btn btn-primary" href="<%= baseUrl %>/users/search-form">User Search</a>
</div>