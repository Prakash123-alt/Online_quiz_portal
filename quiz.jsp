<%@ page import="java.util.*" %>
<%
    List<Map<String, String>> questions = (List<Map<String, String>>) session.getAttribute("questions");
%>
<html>
<head><title>Quiz</title></head>
<body>
    <form action="ResultServlet" method="post">
        <% for (Map<String, String> q : questions) { %>
            <p><b><%= q.get("question") %></b></p>
            <% for (int i = 1; i <= 4; i++) { %>
                <input type="radio" name="q<%= q.get("id") %>" value="<%= i %>" required />
                <%= q.get("option" + i) %><br>
            <% } %>
            <hr>
        <% } %>
        <input type="submit" value="Submit Quiz" />
    </form>
</body>
</html>
