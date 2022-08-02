// fitpro.db

package forms;

import java.io.*;
import java.sql.*;

public class DBController {
    private String dbName;
    Connection dbConn;
    
    public DBController(String dbName){
        this.dbName = dbName;
    }
    
    public void connect() throws Exception {
        File f = new File(this.dbName);
        
        if(!f.exists()){
            throw new Exception("DB don't exists!");
        }
        
        Class.forName("org.sqlite.JDBC");
        this.dbConn = DriverManager.getConnection("jdbc:sqlite:" + this.dbName);
    }
    
    public void disconnect() throws SQLException {
        this.dbConn.close();
    }
    
    public void setWorkout(String name, String intensity, String difficult, String area) throws Exception {
        String ins = "INSERT INTO workouts (name, intensity, difficult, area) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt;
        
        try {
            stmt = this.dbConn.prepareStatement(ins);
            stmt.setString(1, name);
            stmt.setString(2, intensity);
            stmt.setString(3, difficult);
            stmt.setString(4, area);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Insert Error: " + e.getMessage());
        }
    }
    
    public ResultSet getWorkout(String area) throws Exception {
        String sel = "SELECT * FROM workouts WHERE area='" + area + "'";
        ResultSet rset = null;
        
        try {
            Statement stmt = this.dbConn.createStatement();
            rset = stmt.executeQuery(sel);
        } catch (SQLException e) {
            throw new Exception("Search Error:" + e.getMessage());
        }
        return rset;
    }
}
