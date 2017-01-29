
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tom
 */
public class CPU {
    String make;
    String model;
   double price;
    float speed;
    int cores;
    boolean graphics;
    
    
    
    
    public void setMake(String make){
    
    this.make = make;
    }

    public void setSpeed(float speed){
    this.speed = speed;
    
    }
    
    public void setCores(int cores){
     this.cores = cores;   
        
    
    }
     public void setGraphics(boolean graphics){
     this.graphics = graphics;
        
    }

    public boolean saveCPU(){
        
     Connection con = DatabaseConnection.establishConnection();
    
    try {
       String query = "INSERT INTO Part  (Price,Model,Make,PartType) VALUES (?,?,?,?)"; 
          
       PreparedStatement statement = con.prepareStatement(query);
    

       statement.setDouble(1, this.price);
       statement.setString(2, this.model);
       statement.setString(3, this.make);
       statement.setString(4,"CPU");
       statement.execute();
       Statement stmt = (Statement) con.createStatement();
       query =("SELECT ID FROM Part WHERE Model='"+this.model+ "'AND Make='"+this.make+"' AND PartType='CPU'   ");
       stmt.executeQuery(query);
       ResultSet rs = stmt.getResultSet();
       return true;
    }
    catch(SQLException err){
        return false;
        
    
    }
    
    }
    
    
    
    }
    
