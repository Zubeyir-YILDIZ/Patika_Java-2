import java.util.Date;

public abstract class Insurance
{
    private String insuranceName;
    private double insurancePrice;
    private Date insuranceFirst;
    private Date insuranceLast;


    public abstract double calculate(double data);

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public double getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(double insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public Date getInsuranceFirst() {
        return insuranceFirst;
    }

    public void setInsuranceFirst(Date insuranceFirst) {
        this.insuranceFirst = insuranceFirst;
    }

    public Date getInsuranceLast() {
        return insuranceLast;
    }

    public void setInsuranceLast(Date insuranceLast) {
        this.insuranceLast = insuranceLast;
    }
}
