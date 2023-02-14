public class Inventory
{
    private boolean water;
    private boolean food;
    private boolean wood;
    private int armorDefence;

    public boolean isWater() {
        return water;
    }
    public void setWater(boolean water) {
        this.water = water;
    }
    public boolean isFood() {
        return food;
    }
    public void setFood(boolean food) {
        this.food = food;
    }
    public boolean isWood() {
        return wood;
    }
    public void setWood(boolean wood) {
        this.wood = wood;
    }
    public int getArmorDefence() {
        return armorDefence;
    }
    public void setArmorDefence(int armorDefence) {
        this.armorDefence = armorDefence;
    }
}
