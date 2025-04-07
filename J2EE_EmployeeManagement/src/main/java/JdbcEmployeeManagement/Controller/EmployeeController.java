package JdbcEmployeeManagement.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class EmployeeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher=req.getRequestDispatcher("register.html");
		dispatcher.forward(req, resp);	
	}
}
//<servlet>
//<servlet-name>welcome</servlet-name>
//<servlet-class>JdbcEmployeeManagement.Controller.</servlet-class>
//</servlet>
//<servlet-mapping>
//<servlet-name>welcome</servlet-name>
//<url-pattern>/welcome</url-pattern>
//</servlet-mapping>
