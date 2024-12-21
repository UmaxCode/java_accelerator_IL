
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>d</title>
</head>
<body>
<h1>Add New ToDo</h1>
<form action="${pageContext.request.contextPath}/todos/add" method="post">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required>
    <label for="description">Description:</label>
    <input type="text" id="description" name="description" required>
    <button type="submit">Add</button>
</form>
<a href="${pageContext.request.contextPath}/todos">Back to ToDo List</a>
</body>
</html>
