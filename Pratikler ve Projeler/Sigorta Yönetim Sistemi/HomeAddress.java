import java.util.ArrayList;

public class HomeAddress implements Address
{
    private String address;
    private ArrayList<HomeAddress> homeAddresses;

    public ArrayList<HomeAddress> getHomeAddresses() {
        return homeAddresses;
    }

    public void setHomeAddresses(ArrayList<HomeAddress> homeAddresses) {
        this.homeAddresses = homeAddresses;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HomeAddress(String address) {
        this.address = address;
    }



}
