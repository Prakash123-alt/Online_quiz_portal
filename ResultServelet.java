import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        List<Map<String, String>> questions = (List<Map<String, String>>) session.getAttribute("questions");

        int score = 0;

        for (Map<String, String> q : questions) {
            String qid = q.get("id");
            String correct = q.get("correct");
            String answer = request.getParameter("q" + qid);
            if (answer != null && answer.equals(correct)) {
                score++;
            }
        }

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO results (username, score) VALUES (?, ?)");
            stmt.setString(1, username);
            stmt.setInt(2, score);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("score", score);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
