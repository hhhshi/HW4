package model;

public class Roles {
    
    private String email;
    private String rolename;

    
    public Roles() {
        this.email = "";
        this.rolename = "";
    }

    public Roles(String email, String rolename) {
        this.email = email;
        this.rolename = rolename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "Users{" + "email=" + email + ", rolename=" + rolename + '}';
    }
  
}