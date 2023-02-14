public class Player extends Inventory
{
    private int damage;
    private int health;
    private String playerName;
    private int money;
    private String charName;
    private boolean weapon;
    private boolean isDead;

    public boolean isDead()
    {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean isWeapon() {
        return weapon;
    }
    public void setWeapon(boolean weapon) {
        this.weapon = weapon;
    }
    public void setPlayer(String playerName,int damage,int health,int money,String charName,boolean weapon)
    {
        this.playerName=playerName;
        this.damage=damage;
        this.health=health;
        this.money=money;
        this.charName=charName;
        this.weapon=weapon;
    }
    public int getDamage()
    {
        return damage;
    }
    public void setDamage(int damage)
    {
        this.damage = damage;
    }
    public int getHealth()
    {
        return health;
    }
    public void setHealth(int health)
    {
        this.health = health;
    }
    public String getPlayerName()
    {
        return playerName;
    }
    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }
    public int getMoney()
    {
        return money;
    }
    public void setMoney(int money)
    {
        this.money = money;
    }
    public String getCharName()
    {
        return charName;
    }
    public void setCharName(String charName)
    {
        this.charName = charName;
    }
}
