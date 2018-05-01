
package model;

public class Categories {
    
    private int cat_ID;
    private String cat_name;

    public Categories() {
        this.cat_ID = 0;
        this.cat_name = "";
    }
    
    public Categories(int cat_ID, String cat_name) {
        this.cat_ID = cat_ID;
        this.cat_name = cat_name;
    }

    public int getCat_ID() {
        return cat_ID;
    }

    public void setCat_ID(int cat_ID) {
        this.cat_ID = cat_ID;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    @Override
    public String toString() {
        return "Categories{" + "cat_ID=" + cat_ID + ", cat_name=" + cat_name + '}';
    }
    
    
    
}
