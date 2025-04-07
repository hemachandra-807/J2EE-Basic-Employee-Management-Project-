package JdbcEmployeeManagement.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JdbcEmployeeManagement.Entity.Employee;
import JdbcEmployeeManagement.Service.EmployeeService;

@WebServlet("/update")
public class UpdateEmployee extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        double salary = Double.parseDouble(req.getParameter("salary"));
        String gender = req.getParameter("gender");
        
        Employee employee = new Employee(id, name, age, salary, gender);
        
        EmployeeService employeeService = new EmployeeService();
        employeeService.updateEmployee(employee);
        
        resp.sendRedirect("display");  
    }
}
