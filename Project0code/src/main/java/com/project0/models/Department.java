package com.project0.models;

public class Department {
    private int dep_id;
    private String dep_name;
    private String dep_location;
    private String dep_phone;
    private int dep_budget;


//boilerplate code below

//no args
    public Department() {
    }

//all args
    public Department(int dep_id, String dep_name, String dep_location, String dep_phone, int dep_budget) {
        this.dep_id = dep_id;
        this.dep_name = dep_name;
        this.dep_location = dep_location;
        this.dep_phone = dep_phone;
        this.dep_budget = dep_budget;
    }

    //constructor with minus dep_id because dep_id is auto generated


    public Department(String dep_name, String dep_location, String dep_phone, int dep_budget) {
        this.dep_name = dep_name;
        this.dep_location = dep_location;
        this.dep_phone = dep_phone;
        this.dep_budget = dep_budget;
    }

    //getter and setter let us access and change our private variable


    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getDep_location() {
        return dep_location;
    }

    public void setDep_location(String dep_location) {
        this.dep_location = dep_location;
    }

    public String getDep_phone() {
        return dep_phone;
    }

    public void setDep_phone(String dep_phone) {
        this.dep_phone = dep_phone;
    }

    public int getDep_budget() {
        return dep_budget;
    }

    public void setDep_budget(int dep_budget) {
        this.dep_budget = dep_budget;
    }

    //tostring let us print out our object in string form instead of memory address


    @Override
    public String toString() {
        return "Department{" +
                "dep_id=" + dep_id +
                ", dep_name='" + dep_name + '\'' +
                ", dep_location='" + dep_location + '\'' +
                ", dep_phone=" + dep_phone +
                ", dep_budget=" + dep_budget +
                '}';
    }
}




