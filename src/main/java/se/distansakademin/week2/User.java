package se.distansakademin.week2;

public class User {
    private int id;

    private String username;

    private String hashedPassword;

    public User() {
    }

    public User(String username, String hashedPassword) { // Ny användare innan db
        this.username = username;
        this.hashedPassword = hashedPassword;
    }

    public User(int id, String username, String hashedPassword) { // Befintlig användare från db
        this.id = id;
        this.username = username;
        this.hashedPassword = hashedPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getHash(){
        var parts = hashedPassword.split(":");
        return parts[0];
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                '}';
    }
}
