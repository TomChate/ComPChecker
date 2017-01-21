/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tom
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Make {
    private String name;
    private String website;
    
    
    public ResultSet getMakes(){
     Connection con = DatabaseConnection.establishConnection();
     
      try {
            int availability;
            Statement stmt = (Statement) con.createStatement();
            String query = ("SELECT name FROM Make ORDER BY name;");
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            return rs;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return null;
        }
    }    
}



