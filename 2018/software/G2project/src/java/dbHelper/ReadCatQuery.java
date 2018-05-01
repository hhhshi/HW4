
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
import model.Categories;

public class ReadCatQuery {
    private Connection conn;
    private ResultSet results;
    
    public ReadCatQuery(){
    Properties props= new Properties();
    InputStream instr= getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String ur1=props.getProperty("server.name");
    String username=props.getProperty("user.name");
    String password =props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection(ur1,username,password);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void doRead(){
        try {
            String query="Select * from bookmarks_categories";
            PreparedStatement ps=conn.prepareStatement(query);
            this.results=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Categories> listAllCategories() throws SQLException {
        
            List<Categories> allCategories = new ArrayList<Categories>();
            
            while(this.results.next()){
                Categories category = new Categories();
                category.setCat_ID(this.results.getInt("cat_id"));
                category.setCat_name(this.results.getString("cat_name"));
                
                allCategories.add(category);
            }
        return allCategories;
    }
    
    public String getHTMLTable(){
        String cat_table="";
        cat_table += "<table>";
        cat_table += "<th>ID</th>";
        cat_table += "<th>Category</th>";
        cat_table += "<th></th>";
        
        try {
            while(this.results.next()){
                Categories category=new Categories();
                category.setCat_ID(this.results.getInt("cat_id"));
                category.setCat_name(this.results.getString("cat_name"));
                
                cat_table+="<tr>";
                cat_table+="<td>";
                cat_table+= category.getCat_ID();
                cat_table+="</td>";
                
                cat_table+="<td>";
                cat_table+= category.getCat_name();
                cat_table+="</td>";
 
                cat_table += "<td>";        
                cat_table +="<a href=updateCat?cat_id="+category.getCat_ID()+">Update </a>";
                cat_table+="</td>";
                cat_table+="</tr>";
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        cat_table+="</table>";
                return cat_table;
    }
}
