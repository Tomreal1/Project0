package com.project0.service;

import com.project0.daos.EmployeeDAO;
import com.project0.daos.EmployeeDAOinterface;
import com.project0.models.Employee;

import java.util.ArrayList;

public class EmployeeService {
    private final EmployeeDAOinterface employeeDao = new EmployeeDAO();


    public ArrayList<Employee> getAllEmployees(){

        return employeeDao.getAllEmployees();
    }

    public Employee createNewEmployee(Employee emp){
        return employeeDao.insertEmployee(emp);

    }


}
