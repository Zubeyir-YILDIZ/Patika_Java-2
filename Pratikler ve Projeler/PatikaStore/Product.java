import java.util.Comparator;

public abstract class Product implements Comparable<Product>
{
    private int productId;
    private String productName;
    private int productPrice;
    private int productStock;
    private double discountRate;
    private Brand brand;
    private String color;
    static int key;
    public static String[] productsList=new String[]{"Notebook","Cep Telefonu"};
    public Product(int productId, String productName, int productPrice, int productStock, double discountRate, Brand brand, String color)
    {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.discountRate = discountRate;
        this.brand = brand;
        this.color = color;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public static String[] showProductList()
    {
        return productsList;
    }

    @Override
    public int compareTo(Product o)
    {
        if(key==1)
            return Integer.compare(this.productId,o.getProductId());
        else if(key==2)
            return this.productName.compareTo(o.getProductName());
        else
            return o.getBrand().compareTo(this.brand);
    }


}
