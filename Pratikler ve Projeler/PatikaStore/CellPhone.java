import java.util.ArrayList;
import java.util.List;

public class CellPhone extends Product
{
    static private int storage;
    static private int ram;
    static private double screenSize;
    static private int batteryPower;
    static List<Product> cellPhones=new ArrayList<>();

    public CellPhone(int productId, String productName, int productPrice, int productStock, double discountRate, Brand brand, String color,int storage,int ram,double screenSize,int batteryPower )
    {
        super(productId, productName, productPrice, productStock, discountRate, brand, color);
        this.storage=storage;
        this.ram=ram;
        this.screenSize=screenSize;
        this.batteryPower=batteryPower;
    }

    public static int getStorage() {
        return storage;
    }

    public  void setStorage(int storage) {
        this.storage = storage;
    }

    public static int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public static double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public static int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public static void addCellPhone(String name,int price,int stock,double discR,Brand br,String color,int storage,int ram,double screenSize ,int batteryPower)
    {
        CellPhone ph=new CellPhone(cellPhones.size()+1,name,price,stock,discR,br,color,ram,storage,screenSize,batteryPower);
        cellPhones.add(ph);
    }

}
