public class Forest extends Location
{
    private boolean step1;

    public boolean isStep1() {
        return step1;
    }

    public void setStep1(boolean step1) {
        this.step1 = step1;
    }

    public Forest(String locName)
    {
        super(locName="Orman");
    }
}
