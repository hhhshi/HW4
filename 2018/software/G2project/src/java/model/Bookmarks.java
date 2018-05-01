
package model;

import java.sql.Timestamp;

public class Bookmarks {
   
    private int bookmark_ID;
    private String page_name;
    private String url;
    private String username;
    private int cat;
    private String note;
    private Timestamp date_saved;
    private Timestamp date_modified;
    
    public Bookmarks() {
        this.bookmark_ID = 0;
        this.page_name = "";
        this.url = "";
        this.username = "";
        this.cat = 0;
        this.note = "";
    }

    public Bookmarks(int bookmark_ID, String page_name, String url, String username, int cat, String note, Timestamp date_saved, Timestamp date_modified) {
        this.bookmark_ID = bookmark_ID;
        this.page_name = page_name;
        this.url = url;
        this.username = username;
        this.cat = cat;
        this.note = note;
        this.date_saved = date_saved;
        this.date_modified = date_modified;
    }

    public int getBookmark_ID() {
        return bookmark_ID;
    }

    public void setBookmark_ID(int bookmark_ID) {
        this.bookmark_ID = bookmark_ID;
    }

    public String getPage_name() {
        return page_name;
    }

    public void setPage_name(String page_name) {
        this.page_name = page_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Timestamp getDate_saved() {
        return date_saved;
    }

    public void setDate_saved(Timestamp date_saved) {
        this.date_saved = date_saved;
    }

    public Timestamp getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(Timestamp date_modified) {
        this.date_modified = date_modified;
    }

    @Override
    public String toString() {
        return "Bookmarks{" + "bookmark_ID=" + bookmark_ID + ", page_name=" + page_name + ", url=" + url + ", username=" + username + ", cat=" + cat + ", note=" + note + ", date_saved=" + date_saved + ", date_modified=" + date_modified + '}';
    }

}
