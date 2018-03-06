
package model;

public class user {

    private int USER_ID;
    private String USERNAME;
    private int USERAGE;

    public user() {
        this.USER_ID = 0;
        this.USERNAME = "";
        this.USERAGE = 0;
    }
    
    public user(int USER_ID, String USERNAME, int USERAGE) {
        this.USER_ID = USER_ID;
        this.USERNAME = USERNAME;
        this.USERAGE = USERAGE;
    }

    public int getUSER_ID() {
        return USER_ID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public int getUSERAGE() {
        return USERAGE;
    }

    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public void setUSERAGE(int USERAGE) {
        this.USERAGE = USERAGE;
    }

    @Override
    public String toString() {
        return "user{" + "USER_ID=" + USER_ID + ", USERNAME=" + USERNAME + ", USERAGE=" + USERAGE + '}';
    }
    
       
}
