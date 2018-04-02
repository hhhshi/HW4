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

public class SearchQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery(){
        
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConnection.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }
    
    public void doSearch(String USERNAME) throws SQLException{
        
        try {
        String query = "SELECT * FROM USER_AGE WHERE UPPER(USERNAME) LIKE ? ORDER BY USER_ID ASC";
        
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, "%" + USERNAME.toUpperCase() + "%");
        this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLtable(){
        
        String table = "";
        
        table += "<table>";
        
        try {
            while(this.results.next()){
                user newuser = new user();
                newuser.setUSER_ID(this.results.getInt("User_ID"));
                newuser.setUSERNAME(this.results.getString("USERNAME"));
                newuser.setUSERAGE(this.results.getInt("USERAGE"));

                table += "<tr>";
                table += "<td>";
                table += newuser.getUSER_ID();                    
                table += "</td>";
                
                table += "<td>";
                table += newuser.getUSERNAME();                    
                table += "</td>";
                
                table += "<td>";
                table += newuser.getUSERAGE();                    
                table += "</td>";
                
                table += "<td>";
                table += "<a href=update?USER_ID=" + newuser.getUSER_ID() + "> Update </a>";                
                table += "</td>";
                
                table += "<td>";
                table += "<a href=delete?USER_ID=" + newuser.getUSER_ID() + "> Delete </a>";
                table += "</td>";
                
                table += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table += "</table>";
        
        return table;
                
    }
    

    }
    
    

