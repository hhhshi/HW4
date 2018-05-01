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
import model.Bookmarks;

public class UpdateQuery {
    
    private Connection conn;
    
    public UpdateQuery() {
        
        Properties props = new Properties(); //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
    }
    
    public void doUpdate (Bookmarks bookmark){
        
        try {
            String query = "UPDATE bookmarks SET page_name = ?, url = ?, cat = ?, note=?, date_modified=? WHERE bookmark_id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, bookmark.getPage_name());
            ps.setString(2, bookmark.getUrl());
            ps.setInt(3, bookmark.getCat());
            ps.setString(4, bookmark.getNote());
            ps.setTimestamp(5, bookmark.getDate_modified());
            ps.setInt(6, bookmark.getBookmark_ID());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
