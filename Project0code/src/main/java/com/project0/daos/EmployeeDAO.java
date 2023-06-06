package com.project0.daos;

import com.project0.models.Employee;
import com.project0.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO implements EmployeeDAOinterface{
    @Override
    public Employee insertEmployee(Employee emp) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO employees(first_name, last_name, emp_salary, dep_id_fk) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, emp.getFirst_name());
            ps.setString(2, emp.getLast_name());
            ps.setInt(3, emp.getEmp_salary());
            ps.setInt(4, emp.getDep_id_fk());
            ps.executeUpdate();
            return emp;

        }catch(SQLException e){
            System.out.println("INSERT EMPLOYEE FAILED");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Employee> getAllEmployees() {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM employees";
            //since there is no variable we use Statement, otherwise we need PreparedStatement
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            ArrayList<Employee> employeeList = new ArrayList<>();

            DepartmentDAO ddao = new DepartmentDAO();

            while(rs.next()){
                Employee employee = new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("emp_salary"),
                        ddao.getDepartmentById(rs.getInt("dep_id_fk"))
                );
                employeeList.add(employee);
            }
            return employeeList;



        }catch(SQLException e){
            System.out.println("GET EMPLOYEE FAILED");
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public boolean deleteEmployee(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "DELETE FROM employees WHERE emp_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("delete employee failed");
            e.printStackTrace();
        }
        return false;


    }

}
