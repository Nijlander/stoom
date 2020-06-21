package nl.saxion.stoom;

public class Account {

    private String username;
    private String password;

    /**
     * constructor
     *
     * @param username username of the account
     * @param password password of the account
     */
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * gets the username of the account
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * gets the password of the account
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Account{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
