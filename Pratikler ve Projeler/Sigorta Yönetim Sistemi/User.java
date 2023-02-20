import java.util.ArrayList;
import java.util.Date;

public class User
{
    private String userName;
    private String userSurname;
    private String userMail;
    private String userPassword;
    private String userJob;
    private int userAge;
    private ArrayList<Address> userAddress;
    private Date userLastLogin;
    private Insurance insurance;

    public User(String userName, String userSurname, String userMail, String userPassword, String userJob, int userAge, ArrayList<Address> userAddress,Insurance insurance)
    {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userJob = userJob;
        this.userAge = userAge;
        this.userAddress = userAddress;
        this.insurance=insurance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public ArrayList<Address> getUserAdress() {
        return userAddress;
    }

    public void setUserAdress(ArrayList<Address> userAdress) {
        this.userAddress = userAdress;
    }

    public Date getUserLastLogin() {
        return userLastLogin;
    }

    public void setUserLastLogin(Date userLastLogin) {
        this.userLastLogin = userLastLogin;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public ArrayList<Address> getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(ArrayList<Address> userAddress) {
        this.userAddress = userAddress;
    }
}
