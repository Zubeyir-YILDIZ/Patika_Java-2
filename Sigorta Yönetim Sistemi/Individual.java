import java.util.ArrayList;

public class Individual extends Account
{
    @Override
    public void addInsurance()
    {

    }
    public Individual(User user, ArrayList<Insurance> insurances) {
        super(user, insurances);
    }
}
