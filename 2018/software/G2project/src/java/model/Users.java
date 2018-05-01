
package model;

public class Users {
    
    private String email;
    private String passwd;
    private String firstname;
    private String lastname;
    
    public Users() {
        this.email = "";
        this.passwd = "";
        this.firstname = "";
        this.lastname = "";
    }

    public Users(String email, String passwd, String firstname, String lastname) {
        this.email = email;
        this.passwd = passwd;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Users{" + "email=" + email + ", passwd=" + passwd + ", firstname=" + firstname + ", lastname=" + lastname + '}';
    }
  
}
