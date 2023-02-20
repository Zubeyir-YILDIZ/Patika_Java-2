import java.util.ArrayList;

public class AddressManager
{

    public static void addAddress(User user,Address address)
    {
        ArrayList<Address> addresses=user.getUserAdress();
        addresses.add(address);
        user.setUserAdress(addresses);

    }
    public static void deleteAddress(User user,Address address)
    {
        ArrayList<Address> addresses=user.getUserAdress();
        addresses.remove(address);
        user.setUserAdress(addresses);
    }

}
