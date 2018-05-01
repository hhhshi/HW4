
package dbHelper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Users;

public class ReadUserQuery {
   
    private Connection conn;
    private ResultSet results;
    
    public ReadUserQuery(){
        
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadUserQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadUserQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadUserQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadUserQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead(){
        
        try {
            String query = "Select * from bookmarks_siteusers";
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadUserQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Users> listAllUsers() throws SQLException {
        
            List<Users> allUsers = new ArrayList<Users>();
            
            while(this.results.next()){
                Users user = new Users();
                user.setEmail(this.results.getString("email"));
                user.setPasswd(this.results.getString("passwd"));
                user.setFirstname(this.results.getString("firstname"));
                user.setLastname(this.results.getString("lastname"));
                
                allUsers.add(user);
            }
        return allUsers;
    }
    
    
    public String getHTMLTable(){
        String user_table="";
        user_table += "<table>";
        user_table += "<th>Email</th>";
        user_table += "<th>Password</th>";
        user_table += "<th>First Name</th>";
        user_table += "<th>Last Name</th>";
        user_table += "<th></th>";
        
        try {
            while(this.results.next()){
                Users user = new Users();
                user.setEmail(this.results.getString("email"));
                user.setPasswd(this.results.getString("passwd"));
                user.setFirstname(this.results.getString("firstname"));
                user.setLastname (this.results.getString("lastname"));
                
                user_table+="<tr>";
                user_table+="<td>";
                user_table+= user.getEmail();
                user_table+="</td>";
                
                user_table+="<td>";
                user_table+= user.getPasswd();
                user_table+="</td>";
                
                user_table+="<td>";
                user_table+= user.getFirstname();
                user_table+="</td>";
                
                user_table+="<td>";
                user_table+= user.getLastname();
                user_table+="</td>";
                
 
                user_table += "<td>";        
                user_table +="<a href=updateUser?email="+user.getEmail()+">Update </a>";
                user_table+="</td>";
                user_table+="</tr>";
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadUserQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        user_table+="</table>";
                return user_table;
    }
    
    
    
    
    
}
