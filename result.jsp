<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Quiz Result</title></head>
<body>
    <h2>Your Score: <%= request.getAttribute("score") %></h2>
    <a href="index.jsp">Take Quiz Again</a>
</body>
</html>
