<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Welcome to the Simple Spring MVC Application!</h1>
<form action="${pageContext.request.contextPath}/" method="post">
    <label for="name">Enter your name:</label>
    <input type="text" id="name" name="name" required>
    <button type="submit">Submit</button>
</form>
</body>