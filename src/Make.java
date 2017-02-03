/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tom
 */
//import needed packages
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

        Connection con = DatabaseConnection.establishConnection(); //connects to datbase

        try {
            int availability; //checks availibility using sql query
            Statement stmt = (Statement) con.createStatement();
            String query = ("SELECT COUNT(*) FROM Make WHERE Name = '" + make + "'"); //checks name of make in database

            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                availability = rs.getInt("COUNT(*)"); //checks availibility of make in database
                if (availability == 1) {
                    return false; // not in database already
                } else {
                    return true; //already present in database
                }
            }

        } catch (SQLException err) {

            System.out.println(err.getMessage()); //error message displayed
            return false;
        }
        return false;
    }

     public void saveMake(){
    
    Connection con = DatabaseConnection.establishConnection();
    
    try {
       String query = "INSERT INTO Make values (?,?)";  //inserts the inputs into database
          
       PreparedStatement statement = con.prepareStatement(query);
    
       statement.setString(1,name); //insert name of part
       statement.setString(2, website); //website of part
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

       public ResultSet  getMakes(){ //returns the make to user
              Connection con = DatabaseConnection.establishConnection();
       try {
            int availability;
            Statement stmt = (Statement) con.createStatement();
            String query = ("SELECT Name FROM Make ORDER BY Name;"); //gets make from database refering to name

            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet(); //returns the make
            return rs;
            
        } catch (SQLException err) {

            System.out.println(err.getMessage());
            return null; //prints error message if not found
        }
       
       
       }
       
       
       
}


