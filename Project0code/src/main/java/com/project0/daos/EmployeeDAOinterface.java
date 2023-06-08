package com.project0.daos;

import com.project0.models.Employee;

import java.util.ArrayList;

public interface EmployeeDAOinterface {

    Employee insertEmployee(Employee emp);

    ArrayList<Employee> getAllEmployees();


    boolean deleteEmployee(int id);
}
