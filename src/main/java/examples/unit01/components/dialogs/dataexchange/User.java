package examples.unit01.components.dialogs.dataexchange;

public class User {
    private String name;
    private char[] password;

    public User(String name, char[] password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
}
