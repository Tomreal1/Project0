package com.project0;


import java.sql.Connection;
import java.sql.SQLException;

import com.project0.daos.DepartmentDAO;
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

        System.out.println(ddao.getDepartmentById(3));
        System.out.println(ddao.updateDepBudget(750000, "Finance" ));
        System.out.println(ddao.updateDepPhone("222 222 3454", 1));

    }
}
