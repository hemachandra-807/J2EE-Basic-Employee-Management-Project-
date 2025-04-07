package JdbcEmployeeManagement.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JdbcEmployeeManagement.Entity.Employee;
import JdbcEmployeeManagement.Service.EmployeeService;

@WebServlet("/edit")
public class EditEmployee extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        EmployeeService employeeService = new EmployeeService();
        Employee emp = employeeService.getEmployeeById(id);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print("<html><head><title>Edit Employee</title>");
        out.print("<style>");
        out.print("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
        out.print("h2 { text-align: center; color: #4CAF50; padding: 20px; }");
        out.print("form { width: 40%; margin: 20px auto; padding: 20px; background-color: #fff; border-radius: 8px; border: 1px solid #ddd; }");
        out.print("label { font-size: 14px; color: #555; display: block; margin: 10px 0 5px; }");
        out.print("input[type='text'], input[type='number'], input[type='submit'] { width: 100%; padding: 10px; margin: 5px 0; border: 1px solid #ddd; border-radius: 5px; }");
        out.print("input[type='submit'] { background-color: #4CAF50; color: white; cursor: pointer; }");
        out.print("input[type='submit']:hover { background-color: #45a049; }");
        out.print("</style>");
        out.print("</head><body>");

        if (emp == null) {
            out.print("<h2>Employee not found</h2>");
            return;
        }

        out.print("<h2>Edit Employee Details</h2>");
        out.print("<form action='update' method='post'>");

        out.print("<input type='hidden' name='id' value='" + emp.getId() + "'><br>");

        out.print("<label for='name'>Name:</label>");
        out.print("<input type='text' name='name' value='" + emp.getName() + "' required><br>");
        
        out.print("<label for='age'>Age:</label>");
        out.print("<input type='number' name='age' value='" + emp.getAge() + "' required><br>");
        
        out.print("<label for='salary'>Salary:</label>");
        out.print("<input type='number' step='0.01' name='salary' value='" + emp.getSalary() + "' required><br>");
        
        out.print("<label for='gender'>Gender:</label>");
        out.print("<input type='text' name='gender' value='" + emp.getGender() + "' required><br>");
        
        out.print("<input type='submit' value='Update Employee'>");
        out.print("</form>");
        out.print("</body></html>");
        
        out.close();
    }
}
