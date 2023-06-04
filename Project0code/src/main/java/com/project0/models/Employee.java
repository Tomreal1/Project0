package com.project0.models;

public class Employee {
    private int emp_id;
    private String first_name;
    private String last_name;
    private  int emp_salary;

    private Department department;
    private int dep_id_fk;

    //no args


    public Employee() {
    }
    //with args and dep object


    public Employee(int emp_id, String first_name, String last_name, int emp_salary, Department department) {
        this.emp_id = emp_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.emp_salary = emp_salary;
        this.department = department;
    }

    //minus emp_id with dep obj


    public Employee(String first_name, String last_name, int emp_salary, Department department) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.emp_salary = emp_salary;
        this.department = department;
    }

    //all args minus emp_id with dep_id_fk only used for insert


    public Employee(String first_name, String last_name, int emp_salary, int dep_id_fk) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.emp_salary = emp_salary;
        this.dep_id_fk = dep_id_fk;
    }
    //getter and setter

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(int emp_salary) {
        this.emp_salary = emp_salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getDep_id_fk() {
        return dep_id_fk;
    }

    public void setDep_id_fk(int dep_id_fk) {
        this.dep_id_fk = dep_id_fk;
    }
    //toString

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", emp_salary=" + emp_salary +
                ", department=" + department +
                ", dep_id_fk=" + dep_id_fk +
                '}';
    }
}
