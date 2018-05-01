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
import model.Bookmarks;


public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Bookmarks bookmark = new Bookmarks();
    private int bookmark_ID;
  
    public ReadRecord (int bookmark_ID) {
    
     Properties props = new Properties(); //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
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
        
        this.bookmark_ID = bookmark_ID;
        
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
            //set up a string to hold our query
            String query = "SELECT * FROM bookmarks WHERE bookmark_id = ?";
            
            //create a preparedstatement using our query string
            PreparedStatement ps = conn.prepareStatement(query);
            
            //fill in the preparedstatement
            ps.setInt(1,bookmark_ID);
            
            //execute the query
            this.results = ps.executeQuery();
            
            this.results.next();
            
            bookmark.setBookmark_ID(this.results.getInt("bookmark_id"));
            bookmark.setPage_name(this.results.getString("page_name"));
            bookmark.setUrl(this.results.getString("url"));
            bookmark.setCat(this.results.getInt("cat"));
            bookmark.setNote(this.results.getString("note"));
            //Set date modified to current date =bookmark.setDate_modified()
            
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
 
}
    
    public Bookmarks getBookmark(){
       
        return this.bookmark;
        
    }
}
