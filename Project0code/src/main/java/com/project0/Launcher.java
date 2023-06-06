package com.project0;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project0.daos.DepartmentDAO;
import com.project0.daos.EmployeeDAO;
import com.project0.models.Employee;
import com.project0.utils.ConnectionUtil;

public class Launcher {
    public static void main(String[] args) {
        try(Connection conn = ConnectionUtil.getConnection()){
            System.out.println("Connection successful");

        }catch(SQLException e){
            System.out.println("Connection Failed");
        }

        //geting departments object by dep_id
        //first we instantiate new object then we call a method in print statements
        DepartmentDAO ddao = new DepartmentDAO();

       //System.out.println(ddao.getDepartmentById(3));
        System.out.println(ddao.updateDepBudget(750000, "Finance" ));
        System.out.println(ddao.updateDepPhone("222 222 3454", 1));

        //instantiate employee object
        EmployeeDAO edao = new EmployeeDAO();

        //instantiate new employee

        Employee tom = new Employee("Temesgen","Hailu", 120000, 3);
        //calling method

        System.out.println(edao.insertEmployee(tom));

        //get all employees
        ArrayList<Employee> employeeList = edao.getAllEmployees();

        //delete employee by emp_id

        System.out.println(edao.deleteEmployee(3));

    }

}
