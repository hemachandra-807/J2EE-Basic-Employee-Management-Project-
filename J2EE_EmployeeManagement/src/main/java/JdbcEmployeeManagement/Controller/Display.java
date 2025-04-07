package JdbcEmployeeManagement.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JdbcEmployeeManagement.Entity.Employee;
import JdbcEmployeeManagement.Service.EmployeeService;

@WebServlet("/display")
public class Display extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		EmployeeService employeeService = new EmployeeService();
		List<Employee> employees = employeeService.fetchAll();

		out.print("<html><head><title>Employee List</title>");
		out.print("<style>");
		out.print("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
		out.print("h2 { text-align: center; color: #4CAF50; padding: 20px; }");
		out.print(
				"table { width: 80%; margin: 20px auto; border-collapse: collapse; border: 1px solid #ddd; background-color: #fff; }");
		out.print("th, td { padding: 12px; border: 1px solid #ddd; text-align: center; }");
		out.print("th { background-color: #f2f2f2; color: #333; }");
		out.print("td { color: #555; }");
		out.print(
				"a { text-decoration: none; color: #4CAF50; padding: 5px 10px; border: 1px solid #4CAF50; border-radius: 5px; }");
		out.print("a:hover { background-color: #4CAF50; color: white; }");
		out.print(
				"button { background-color: #f44336; color: white; border: none; padding: 5px 10px; cursor: pointer; border-radius: 5px; }");
		out.print("button:hover { background-color: #e53935; }");
		out.print("</style>");
		out.print("</head><body>");

		out.print("<h2>Employee List</h2>");

		out.print("<table>");
		out.print("<tr><th>ID</th><th>Name</th><th>Age</th><th>Salary</th><th>Gender</th><th>Actions</th></tr>");

		for (Employee emp : employees) {
			out.print("<tr>");
			out.print("<td>" + emp.getId() + "</td>");
			out.print("<td>" + emp.getName() + "</td>");
			out.print("<td>" + emp.getAge() + "</td>");
			out.print("<td>" + emp.getSalary() + "</td>");
			out.print("<td>" + emp.getGender() + "</td>");
			out.print("<td><a href='edit?id=" + emp.getId() + "'>Edit</a> | ");
			out.print("<a href='delete?id=" + emp.getId()
					+ "' onclick='return confirm(\"Are you sure?\")'>Delete</a></td>");
			out.print("</tr>");
		}

		out.print("</table>");
		out.print("</body></html>");

		out.close();
	}
}