import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("student1", "pass1");
        users.put("student2", "pass2");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (!users.containsKey(username) || !users.get(username).equals(password)) {
            response.setContentType("text/html");
            response.getWriter().println("<h3>Invalid credentials!</h3>");
            response.getWriter().println("<a href='login.html'>Try again</a>");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(30 * 60); // 30 minutes
            response.addCookie(cookie);

            response.sendRedirect("DashboardServlet");
        }
    }
}
