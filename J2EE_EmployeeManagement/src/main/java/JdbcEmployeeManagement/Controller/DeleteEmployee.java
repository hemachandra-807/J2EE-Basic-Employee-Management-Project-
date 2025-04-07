package JdbcEmployeeManagement.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JdbcEmployeeManagement.Service.EmployeeService;

@WebServlet("/delete")
public class DeleteEmployee extends HttpServlet {
    private EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean success = employeeService.deleteEmployee(id);

        if (success) {
            resp.sendRedirect("display"); 
        } else {
            resp.getWriter().println("<h3>Failed to delete employee</h3>");
        }
    }
}

