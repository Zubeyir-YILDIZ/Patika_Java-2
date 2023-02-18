import java.util.*;
public class Brand implements Comparable<Brand>
{
    private int brandId;
    private String brandName;
    private Product product;
    static List<Brand> brands=new ArrayList<>();

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Brand(int brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    @Override
    public int compareTo(Brand o) {
        return o.getBrandName().compareTo(this.brandName);
    }
}
