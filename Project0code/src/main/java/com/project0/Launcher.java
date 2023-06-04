package com.project0;


import java.sql.Connection;
import java.sql.SQLException;

import com.project0.utils.ConnectionUtil;

public class Launcher {
    public static void main(String[] args) {
        try(Connection conn = ConnectionUtil.getConnection()){
            System.out.println("Connection successful");

        }catch(SQLException e){
            System.out.println("Connection Failed");
        }

    }
}
