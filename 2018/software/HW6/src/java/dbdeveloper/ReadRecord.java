
package dbdeveloper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.user;

public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private user newuser = new user();
    private int User_ID;
    
    public ReadRecord (int User_ID) {
    
    Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConnection.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        
        this.User_ID = User_ID;
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }
    
    public void doRead() {
        
        try {
            String query = "Select * from USER_AGE WHERE USER_ID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, User_ID);
            this.results = ps.executeQuery();
                this.results.next();
                
                newuser.setUSER_ID(this.results.getInt("USER_ID"));
                newuser.setUSERNAME(this.results.getString("USERNAME"));
                newuser.setUSERAGE(this.results.getInt("USERAGE"));
                
                
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public user getUser() {
        
        return this.newuser;
        
    }
    
}
    

