package dbHelper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Users;

public class UpdateUserQuery {
    
    private Connection conn;
    
    public UpdateUserQuery() {
        
        Properties props = new Properties(); //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(UpdateUserQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(UpdateUserQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateUserQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateUserQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
    }
    
    public void doUpdate (Users user){
        
        try {
            String query = "UPDATE bookmarks_siteusers SET email = ?, passwd = ?, firstname = ?, lastname=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPasswd());
            ps.setString(3, user.getFirstname());
            ps.setString(4, user.getLastname());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateUserQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
