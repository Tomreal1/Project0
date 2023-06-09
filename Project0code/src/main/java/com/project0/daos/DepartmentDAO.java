package com.project0.daos;

import com.project0.models.Department;
import com.project0.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDAO implements DepartmentDAOinterface{

    @Override
    public Department insertDepartment(Department dep) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO departments(dep_name, dep_location, dep_phone, dep_budget) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dep.getDep_name());
            ps.setString(2, dep.getDep_location());
            ps.setString(3, dep.getDep_phone());
            ps.setInt(4, dep.getDep_budget());
            ps.executeUpdate();
            return dep;

        }catch(SQLException e){
            System.out.println("INSERT Department FAILED");
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Department getDepartmentById(int dep_id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM departments WHERE dep_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, dep_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {

                //Extract the Department data from the ResultSet. We need to use the all-args constructor to store all the data
                //to get data out of a ResultSet, we use the rs.get___() methods
                Department department = new Department(
                        rs.getInt("dep_id"),
                        rs.getString("dep_name"),
                        rs.getString("dep_location"),
                        rs.getString("dep_phone"),
                        rs.getInt("dep_budget")
                );

                return department; //return the Department object to the user!

            }
        }catch(SQLException e){
            System.out.println("ERROR GETTING DEPARTMENT");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateDepBudget(int dep_budget, String dep_name) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "UPDATE departments set dep_budget = ? where dep_name= ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, dep_budget);
            ps.setString(2, dep_name);
            ps.executeUpdate();
            return true;

        }catch(SQLException e){
            System.out.println("update failed");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateDepPhone(String dep_phone, int dep_id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "UPDATE departments SET dep_phone = ? WHERE dep_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,dep_phone);
            ps.setInt(2,dep_id);
            ps.executeUpdate();
            return true;

        }catch(SQLException e){
            System.out.println("error update department phone");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteDepartment(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "DELETE FROM departments WHERE dep_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("delete department failed");
            e.printStackTrace();
        }
        return false;
    }
}
