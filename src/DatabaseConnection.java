import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tom
 */
import java.net.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DatabaseConnection {

    public static Connection establishConnection() {    //This method connects to the database and returns the connection.

        try {
 
            String host = "jdbc:mysql://213.104.129.95:3306/ComPChecker";
            String uName = "root";
            String uPass = "root";
            System.out.println("Testing.");
            Connection con = DriverManager.getConnection(host, "root", "root");
            System.out.println("Connected database successfully...");

            return con;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return null;
        }
    }

}
