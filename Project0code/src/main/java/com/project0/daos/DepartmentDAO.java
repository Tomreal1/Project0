package com.project0.daos;

import com.project0.models.Department;
import com.project0.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDAO implements DepartmentDAOinterface{


    @Override
    public Department getDepartmentById(int get_id) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT *FROM departments WHERE dep_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, get_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {

                //Extract the Department data from the ResultSet. We need to use the all-args constructor to store all the data
                //to get data out of a ResultSet, we use the rs.get___() methods
                Department department = new Department(
                        rs.getInt("dep_id"),
                        rs.getString("dep_name"),
                        rs.getString("dep_location"),
                        rs.getInt("dep_phone"),
                        rs.getInt("dep_budget")
                );

                return department; //return the Department object to the user!

            }





        }catch(SQLException e){
            System.out.println("ERROR GETTING DEPARTMENT");
        }
        return null;
    }

    @Override
    public boolean updateDepBudget(int dep_budget, String dep_name) {
        return false;
    }
}
