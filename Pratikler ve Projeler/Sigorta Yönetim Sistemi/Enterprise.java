import java.util.ArrayList;

public class Enterprise extends Account
{
    private String enterpriseName;

    @Override
    public void addInsurance()
    {


    }

    public Enterprise(User user, ArrayList<Insurance> insurances, String enterpriseName) {
        super(user, insurances);
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
}
