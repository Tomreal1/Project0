package com.project0.daos;

import com.project0.models.Department;

public interface DepartmentDAOinterface {
    Department getDepartmentById(int dep_id);

    boolean updateDepBudget(int dep_budget, String dep_name);

    boolean updateDepPhone(String dep_phone, int dep_id);

}
