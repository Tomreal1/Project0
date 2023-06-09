package com.project0.service;

import com.project0.daos.DepartmentDAO;
import com.project0.daos.DepartmentDAOinterface;
import com.project0.models.Department;

public class DepartmentService {

    private DepartmentDAOinterface departmentDao;
    public DepartmentService(DepartmentDAOinterface departmentDao){
        this.departmentDao = departmentDao;
    }
    public Department getDepartmentById(int dep_id) {
        if (dep_id > 0) {
            return departmentDao.getDepartmentById(dep_id);
        } else {
            return null;
        }
    }
    public boolean updateDepBudget(int dep_budget, String dep_name){
        if(dep_name == null || dep_name.trim().equals("")){
            return false;
        }
        char[] titleArray = dep_name.toLowerCase().toCharArray();

        // Now I need a string to store the result
        String formattedTitle = "";
        formattedTitle += Character.toUpperCase(titleArray[0]);

        // Now we need to loop over the rest of the characters and if the character BEFORE the current one is a space
        // we need to capitalize that character, otherwise just add

        for (int i = 1; i< titleArray.length; i++){
            if (titleArray[i-1] == ' '){
                formattedTitle += Character.toUpperCase(titleArray[i]);
            } else {
                formattedTitle += titleArray[i];
            }
        }
        if (dep_budget > 0){
            return departmentDao.updateDepBudget(dep_budget, formattedTitle);
        }

        return false;
    }
    public boolean deleteDepartment(int id){
        return departmentDao.deleteDepartment(id);

    }

    public Department createNewDepartment(Department dep){
        return departmentDao.insertDepartment(dep);
    }

}