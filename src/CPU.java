
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

    public void setMake(String make) {

        this.make = make;
    }

    public void setSpeed(float speed) {
        this.speed = speed;

    }

    public void setCores(int cores) {
        this.cores = cores;

    }

    public void setGraphics(boolean graphics) {
        this.graphics = graphics;

    }

    public boolean saveCPU() {

        Connection con = DatabaseConnection.establishConnection();

        try {
            String query = "INSERT INTO Part  (Price,Model,Make,PartType) VALUES (?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setDouble(1, this.price);
            statement.setString(2, this.model);
            statement.setString(3, this.make);
            statement.setString(4, "CPU");
            statement.execute();
            String model = this.model;
            query = "SELECT * FROM Part WHERE Model ='" + model + "' && PartType = 'CPU'";

            statement.executeQuery(query);
            ResultSet rs = statement.getResultSet();
            int partID = 0;
            while (rs.next()) {
                partID = rs.getInt("PartID");
            }

            query = "INSERT INTO CPU values (?,?,?,?)";

            statement = con.prepareStatement(query);

            statement.setInt(1, partID);
            statement.setFloat(2, this.speed);
            statement.setInt(3, this.cores);
            statement.setInt(4, 1);
            statement.execute();


            return true;

        } catch (SQLException err) {
            return false;

        }

    }

}
