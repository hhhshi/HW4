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

public class ReadQuery {

    private Connection conn;
    private ResultSet results;

    public ReadQuery() {

        Properties props = new Properties(); //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
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
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void doRead() {

        try {
            String query = "Select * from Bookmarks";

            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getHTMLTable() {

        String table = "";

        table += "<table>";
        table += "<th>Page Name</th>";
        table += "<th>username</th>";
        table += "<th>category</th>";
        table += "<th>note</th>";
        table += "<th>date saved</th>";
        table += "<th>date modified</th>";
        table += "<th></th>";
        table += "<th></th>";

        try {
            while (this.results.next()) {

                Bookmarks bookmark = new Bookmarks();
                bookmark.setBookmark_ID(this.results.getInt("bookmark_id"));
                bookmark.setPage_name(this.results.getString("page_name"));
                bookmark.setUrl(this.results.getString("url"));
                bookmark.setUsername(this.results.getString("username"));
                bookmark.setCat(this.results.getInt("cat"));
                bookmark.setNote(this.results.getString("note"));
                bookmark.setDate_saved(this.results.getTimestamp("date_saved"));
                bookmark.setDate_modified(this.results.getTimestamp("date_modified"));

                table += "<tr>";
                table += "<td>";
                table += "<a href=" + bookmark.getUrl() + ">" + bookmark.getPage_name() + "</a>";
                table += "</td>";
                table += "<td>";
                table += bookmark.getUsername();
                table += "</td>";
                table += "<td>";
                table += bookmark.getCat();
                table += "<td>";
                table += bookmark.getNote();
                table += "</td>";
                table += "<td>";
                table += bookmark.getDate_saved();
                table += "</td>";
                table += "<td>";
                table += bookmark.getDate_modified();
                table += "</td>";
                table += "<td>";
                table += "<a href=update?bookmark_id=" + bookmark.getBookmark_ID() + "> Update </a>";
                table += "</td>";
                table += "<td>";
                table += " <a href=delete?bookmark_id=" + bookmark.getBookmark_ID() + ">Delete</a>";
                table += "</td>";

                table += "</tr>";

            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        table += "</table>";

        return table;
    }

}
