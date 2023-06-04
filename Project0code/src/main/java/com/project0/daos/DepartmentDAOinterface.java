package com.project0.daos;

import com.project0.models.Department;

public interface DepartmentDAOinterface {
    Department getDepartmentById(int get_id);

    boolean updateDepBudget(int dep_budget, String dep_name);

}
