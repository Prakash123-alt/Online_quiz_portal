<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Quiz Portal</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h2>Welcome to Online Quiz</h2>
    <form action="QuizServlet" method="post">
        Enter your name: <input type="text" name="username" required />
        <input type="submit" value="Start Quiz" />
    </form>
</body>
</html>
