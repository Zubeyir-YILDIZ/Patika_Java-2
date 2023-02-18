import java.util.ArrayList;
import java.util.List;

public class Notebook extends Product
{
    private static int ram;
    private static int storage;
    private static double screenSize;
    static List<Product> notebooks =new ArrayList<>();

    public Notebook(int productId, String productName, int productPrice, int productStock, double discountRate, Brand brand, String color,int ram,int storage,double screenSize)
    {
        super(productId, productName, productPrice, productStock, discountRate, brand, color);
        this.ram=ram;
        this.storage=storage;
        this.screenSize=screenSize;
    }

    public static int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public static int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public static double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public static void addNotebook(String name,int price,int stock,double discR,Brand br,String color,int ram,int storage,double screenSize)
    {
        Notebook nb=new Notebook(notebooks.size()+1,name,price,stock,discR,br,color,ram,storage,screenSize);
        notebooks.add(nb);
    }

}
