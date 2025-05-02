import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.html");
            return;
        }

        List<Course> courses = new ArrayList<>();

        courses.add(new Course("CSC 2031", "Database Systems", "Dr. Fernando"));
        courses.add(new Course("MGT 1010", "Principles of Management", "Prof. Gunawardena"));
        courses.add(new Course("ENG 1001", "Academic Writing", "Ms. Kumari"));
        courses.add(new Course("MAT 1101", "Calculus I", "Dr. Bandara"));
        courses.add(new Course("PHY 1001", "Physics I", "Mr. Weerasinghe"));
        courses.add(new Course("CSC 1051", "Introduction to Programming", "Dr. Wijesekara"));
        courses.add(new Course("ACC 2101", "Financial Accounting", "Mr. Perera"));



        List<Course> enrolled = (List<Course>) session.getAttribute("enrolledCourses");
        if (enrolled == null) {
            enrolled = new ArrayList<>();
            session.setAttribute("enrolledCourses", enrolled); // Optional but ensures persistence
        }

        request.setAttribute("courses", courses);
        request.setAttribute("enrolledCourses", enrolled);
        request.setAttribute("username", session.getAttribute("username"));

        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    }
}
