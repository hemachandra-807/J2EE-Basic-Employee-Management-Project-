import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies(); // Retrieve all cookies

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                response.getWriter().println("Cookie Name: " + cookie.getName() + ", Value: " + cookie.getValue());
            }
        } else {
            response.getWriter().println("No cookies found!");
        }
    }
}
package JdbcEmployeeManagement.Entity;

public class demo {

}
