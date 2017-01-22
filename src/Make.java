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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Make {

    private String name;
    private String website;

    public boolean checkMakes(String make) {

        Connection con = DatabaseConnection.establishConnection();

        try {
            int availability;
            Statement stmt = (Statement) con.createStatement();
            String query = ("SELECT COUNT(*) FROM Make WHERE Name = '" + make + "'");

            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                availability = rs.getInt("COUNT(*)");
                if (availability == 1) {
                    return false;
                } else {
                    return true;
                }
            }

        } catch (SQLException err) {

            System.out.println(err.getMessage());
            return false;
        }
        return false;
    }

     public void saveMake(){
    
    Connection con = DatabaseConnection.establishConnection();
    
    try {
       String query = "INSERT INTO Make values (?,?)"; 
          
       PreparedStatement statement = con.prepareStatement(query);
    
       statement.setString(1,name);
       statement.setString(2, website);
       statement.execute();
       JOptionPane.showMessageDialog(null, "Saved", "No Account Found", JOptionPane.INFORMATION_MESSAGE);
    }
    catch(SQLException err){
    }
    
     }
    
       public void setName(String name) {
        this.name = name;
    }
       
       public void setWebsite(String website) {
        this.website = website;
    }

}


