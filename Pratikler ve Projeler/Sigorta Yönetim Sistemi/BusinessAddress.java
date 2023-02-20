import java.util.ArrayList;

public class BusinessAddress implements Address
{
    private String address;
    private ArrayList<BusinessAddress> businessAddresses;

    public BusinessAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<BusinessAddress> getBusinessAddresses() {
        return businessAddresses;
    }

    public void setBusinessAddresses(ArrayList<BusinessAddress> businessAddresses) {
        this.businessAddresses = businessAddresses;
    }




}
