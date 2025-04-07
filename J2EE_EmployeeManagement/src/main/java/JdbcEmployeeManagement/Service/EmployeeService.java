package JdbcEmployeeManagement.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JdbcEmployeeManagement.Entity.Employee;

public class EmployeeService {

	private static Connection con;
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EmployeeProject?user=postgres&password=123");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int save(Employee emp) {
		int res = 0;
		int id = emp.getId();
		String name = emp.getName();
		int age = emp.getAge();
		double salary = emp.getSalary();
		String gender = emp.getGender();
		String sql = "Insert into public.employee(id, name, age, salary, gender)  values(?,?,?,?,?)";
		PreparedStatement pstm;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setString(2, name);
			pstm.setInt(3, age);
			pstm.setDouble(4, salary);
			pstm.setString(5, gender);

			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	public List<Employee> fetchAll() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT * FROM Employee";

		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setGender(rs.getString("gender"));
				employees.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}

	public Employee getEmployeeById(int id) {
		Employee emp = null;
		String sql = "SELECT * FROM employee WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setGender(rs.getString("gender"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public void updateEmployee(Employee emp) {
	    String sql = "UPDATE employee SET name = ?, age = ?, salary = ?, gender = ? WHERE id = ?";
	    try {
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, emp.getName());
	        ps.setInt(2, emp.getAge());
	        ps.setDouble(3, emp.getSalary());
	        ps.setString(4, emp.getGender());
	        ps.setInt(5, emp.getId()); // Ensure id is passed
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public boolean deleteEmployee(int id) {
	    boolean rowDeleted = false;
	    String sql = "DELETE FROM Employee WHERE id = ?";

	    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	        pstmt.setInt(1, id);
	        rowDeleted = pstmt.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace(); // Log error for debugging
	    }

	    return rowDeleted;
	}
}
