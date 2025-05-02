import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String courseId = request.getParameter("courseId");
        HttpSession session = request.getSession();

        List<Course> enrolled = (List<Course>) session.getAttribute("enrolledCourses");
        if (enrolled == null) {
            enrolled = new ArrayList<>();
        }

        Course course = null;

        switch (courseId) {
            case "CSC 2031":
                course = new Course("CSC 2031", "Database Systems", "Dr. Fernando");
                break;
            case "MGT 1010":
                course = new Course("MGT 1010", "Principles of Management", "Prof. Gunawardena");
                break;
            case "ENG 1001":
                course = new Course("ENG 1001", "Academic Writing", "Ms. Kumari");
                break;
            case "MAT 1101":
                course = new Course("MAT 1101", "Calculus I", "Dr. Bandara");
                break;
            case "PHY 1001":
                course = new Course("PHY 1001", "Physics I", "Mr. Weerasinghe");
                break;
            case "CSC 1051":
                course = new Course("CSC 1051", "Introduction to Programming", "Dr. Wijesekara");
                break;
            case "ACC 2101":
                course = new Course("ACC 2101", "Financial Accounting", "Mr. Perera");
                break;
            default:
                course = null;
                break;
        }

        if (course != null && !enrolled.stream().anyMatch(c -> c.getId().equals(courseId))) {
            enrolled.add(course);
            session.setAttribute("enrolledCourses", enrolled);
        }

        response.sendRedirect("DashboardServlet");
    }
}
