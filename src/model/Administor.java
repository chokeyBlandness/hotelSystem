package model;

public class Administor {
    private String administorAccount;
    private String administorPassword;
    private String username;
    private String administorlevel;
    private String personalIdentification;

    public String getPersonalIdentification() {
        return personalIdentification;
    }

    public void setPersonalIdentification(String personalIdentification) {
        this.personalIdentification = personalIdentification;
    }

    public String getAdministorlevel() {

        return administorlevel;
    }

    public void setAdministorlevel(String administorlevel) {
        this.administorlevel = administorlevel;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAdministorPassword() {

        return administorPassword;
    }

    public void setAdministorPassword(String administorPassword) {
        this.administorPassword = administorPassword;
    }

    public String getAdministorAccount() {

        return administorAccount;
    }

    public void setAdministorAccount(String administorAccount) {
        this.administorAccount = administorAccount;
    }
}
