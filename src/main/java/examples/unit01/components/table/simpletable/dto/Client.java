package examples.unit01.components.table.simpletable.dto;

import java.util.Date;

public class Client {

    private String firstName;
    private String lastName;
    private Date incorporationDate;
    private String state;

    public Client() {
    }

    public Client(String firstName, String lastName, Date incorporationDate, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.incorporationDate = incorporationDate;
        this.state = state;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getIncorporationDate() {
        return incorporationDate;
    }

    public void setIncorporationDate(Date incorporationDate) {
        this.incorporationDate = incorporationDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String[] toArrayString() {
        String[] s = new String[4];
        s[0] = getFirstName();
        s[1] = getLastName();
        s[2] = getIncorporationDate().toString();
        s[3] = getState();
        return s;
    }
}
