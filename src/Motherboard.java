
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tom
 */
public class Motherboard {

    String make;
    String model;
    double price;
    String size;
    String socket;
    int ramSlots;
    int maxRAM;

    /**
     *
     * @param make
     */
    public void setMake(String make) {

        this.make = make;
    }

    /**
     *
     * @param socket
     */
    public void setSocket(String socket) {
        this.socket = socket;
    }

    /**
     *
     * @param model
     */
    public void setModel(String model) {
        this.model = model;

    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;

    }

    /**
     *
     * @param size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     *
     * @param slots
     */
    public void setRamSlots(int slots) {
        this.ramSlots = slots;
    }

    /**
     *
     * @param max
     */
    public void setMaxRAM(int max) {
        this.maxRAM = max;
    }

    public boolean saveMotherboard() {
        
        
        Connection con = DatabaseConnection.establishConnection();

        try {

            String query = "INSERT INTO Part  (Price,Model,Make,PartType) VALUES (?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setDouble(1, this.price);
            statement.setString(2, this.model);
            statement.setString(3, this.make);
            statement.setString(4, "Motherboard");
            statement.execute();
            String model = this.model;
            
            query = "SELECT * FROM Part WHERE Model ='" + model + "' && PartType = 'Motherboard'";
            System.out.println("first query");
            statement.executeQuery(query);

            ResultSet rs = statement.getResultSet();
            int partID = 0;
            while (rs.next()) {
                partID = rs.getInt("PartID");
            }

            query = "INSERT INTO Motherboard values (?,?,?,?,?)";
             statement = con.prepareStatement(query);
            statement.setInt(1, partID);
            statement.setString(2, socket);
            statement.setString(3, size);
            statement.setInt(4, ramSlots);
            statement.setInt(5, maxRAM);
            statement.execute();
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
            return false;

        }

    }

}
