import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class QuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String username = request.getParameter("username");

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM questions");
            ResultSet rs = stmt.executeQuery();
            List<Map<String, String>> questions = new ArrayList<>();

            while (rs.next()) {
                Map<String, String> q = new HashMap<>();
                q.put("id", rs.getString("id"));
                q.put("question", rs.getString("question"));
                q.put("option1", rs.getString("option1"));
                q.put("option2", rs.getString("option2"));
                q.put("option3", rs.getString("option3"));
                q.put("option4", rs.getString("option4"));
                q.put("correct", rs.getString("correct_option"));
                questions.add(q);
            }

            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("questions", questions);
            request.getRequestDispatcher("quiz.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
