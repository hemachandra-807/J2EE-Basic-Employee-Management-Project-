package JdbcEmployeeManagement.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JdbcEmployeeManagement.Entity.Employee;
import JdbcEmployeeManagement.Service.EmployeeService;

@WebServlet("/register")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		double salary = Double.parseDouble(req.getParameter("salary"));
		String gender = req.getParameter("gender");
		
		Employee emp = new Employee();
		emp.setId(id);emp.setName(name);emp.setAge(age);emp.setSalary(salary);emp.setGender(gender);
		
		EmployeeService e1 = new EmployeeService();
		int res = e1.save(emp);
		if(res!=0)
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("welcome.html");
			dispatcher.forward(req, resp);
		}else {
			PrintWriter pw = resp.getWriter();
			pw.print("<h1>DATA NOT SAVED</h1>");
		}
	}
}
