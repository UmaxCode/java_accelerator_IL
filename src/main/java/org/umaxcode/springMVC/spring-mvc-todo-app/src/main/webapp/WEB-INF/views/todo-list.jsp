<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>ToDo List</title>
</head>
<body>
<h1>ToDo List</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>Status</th>
    </tr>
    <c:if test="${empty tasks}">
        <tr>
            <td colspan="4" style="text-align: center;">No tasks available</td>
        </tr>
    </c:if>
     <a href="todos/add">add new task</a>
    <c:if test="${not empty tasks}">
        <c:forEach var="todo" items="${tasks}">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.title}</td>
                <td>${todo.description}</td>
                <td>${todo.completed ? "Complete" : "Incomplete"}</td>
                <td>
                    <a href="/todos/complete/${todo.id}">Mark as Complete</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
