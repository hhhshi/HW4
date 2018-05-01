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
import model.Categories;


public class ReadCatRecord {
    private Connection conn;
    private ResultSet results;
    private Categories category=new Categories();
    private int cat_ID;
    public ReadCatRecord(int cat_ID){
    
    Properties props= new Properties();
    InputStream instr= getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadCatRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadCatRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String ur1=props.getProperty("server.name");
    String username=props.getProperty("user.name");
    String password =props.getProperty("user.password");
    
    this.cat_ID=cat_ID;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadCatRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection(ur1,username,password);
        } catch (SQLException ex) {
            Logger.getLogger(ReadCatRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
 
    public void doRead() {
        
        try {
            //set up a string to hold our query
            String query = "SELECT * FROM Bookmarks_categories WHERE cat_id = ?";
            //create a preparedstatement using our query string
            PreparedStatement ps = conn.prepareStatement(query);
            //fill in the preparedstatement
            ps.setInt(1,cat_ID);
            //execute the query
            this.results = ps.executeQuery();
            
            this.results.next();
            
            category.setCat_ID(this.results.getInt("cat_id"));
            category.setCat_name(this.results.getString("cat_name"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadCatRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public Categories getCategory(){
        
        return this.category;
    }
}