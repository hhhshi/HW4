package dbHelper;

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
import model.Users;


public class ReadUserRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Users user = new Users();
    private String Email;
  
    public ReadUserRecord (String Email) {
    
     Properties props = new Properties(); //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadUserRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadUserRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        
        this.Email = Email;
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadUserRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadUserRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void doRead() {
    
        try {
            //set up a string to hold our query
            String query = "SELECT * FROM bookmarks_siteusers WHERE email = ?";
            
            //create a preparedstatement using our query string
            PreparedStatement ps = conn.prepareStatement(query);
            
            //fill in the preparedstatement
            ps.setString(1,Email);
            
            //execute the query
            this.results = ps.executeQuery();
            
            this.results.next();
            
                user.setEmail(this.results.getString("email"));
                user.setPasswd(this.results.getString("passwd"));
                user.setFirstname(this.results.getString("firstname"));
                user.setLastname (this.results.getString("lastname"));

            
        } catch (SQLException ex) {
            Logger.getLogger(ReadUserRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
 
}
    
    public Users getEmail(){
       
        return this.user;
        
    }
}
