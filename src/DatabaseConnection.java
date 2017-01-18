

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tom
 */

import java.sql.DriverManager;
import java.net.*;
import java.io.*;
import java.sql.*;

public class DatabaseConnection {

    public static Connection establishConnection() {

        try {
            String host = "jdbc:mysql://104.155.71.164:3306/ComPChecker";
            String uName = "system";
            String uPass = "system";

            Connection con = DriverManager.getConnection(host, "system", "system");
            System.out.println("Connected database successfully...");

            return con;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return null;
        }
    }

}
