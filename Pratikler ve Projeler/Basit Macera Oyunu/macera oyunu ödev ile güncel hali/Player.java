import java.util.Random;
import java.util.Scanner;

public class Player extends Inventory
{
    private Scanner input=new Scanner(System.in);
    private int damage;
    private int health;
    private String playerName;
    private int money;
    private String charName;
    private boolean weapon;
    private boolean isDead;
    private int firstDamage;

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
        this.firstDamage=damage;
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

    public void posibilityItem(Player player1)
    {
        int key=0;
        Random rnd=new Random();
        int value=rnd.nextInt(201);
        if(value<=30)
        {
            if(value<=9)
            {
                System.out.println("Canavardan tüfek çıktı!");
                System.out.println("Kullanmak için 1 Yere atmak için 2 tuşlayınız");
                key=input.nextInt();
                if(key==1)
                    player1.setDamage(firstDamage+7);
            }
            else if(value<=21 && value>9)
            {
                System.out.println("Canavardan kılıç çıktı!");
                System.out.println("Kullanmak için 1 Yere atmak için 2 tuşlayınız");
                key=input.nextInt();
                if(key==1)
                    player1.setDamage(firstDamage+3);
            }
            else
            {
                System.out.println("Canavardan tabanca çıktı!");
                System.out.println("Kullanmak için 1 Yere atmak için 2 tuşlayınız");
                key=input.nextInt();
                if(key==1)
                    player1.setDamage(firstDamage+2);
            }
        }
        else if(value>30 && value<=60)
        {
            if(value<=36)
            {
                System.out.println("Canavardan ağır zırh çıktı!");
                System.out.println("Kullanmak için 1 Yere atmak için 2 tuşlayınız");
                key=input.nextInt();
                if(key==1)
                {
                    player1.setArmorDefence(5);
                }
            }
            else if(value<=45 && value>36)
            {
                System.out.println("Canavardan orta zırh çıktı!");
                System.out.println("Kullanmak için 1 Yere atmak için 2 tuşlayınız");
                key=input.nextInt();
                if(key==1)
                    player1.setArmorDefence(3);
            }
            else
            {
                System.out.println("Canavardan hafif zırh çıktı!");
                System.out.println("Kullanmak için 1 Yere atmak için 2 tuşlayınız");
                key=input.nextInt();
                if(key==1)
                    player1.setArmorDefence(1);
            }
        }
        else if(value>60 && value<=100)
        {
            if(value<=68)
            {
                System.out.println("Canavardan 10₺ çıktı!");
                player1.setMoney(player1.getMoney()+10);


            }
            else if(value<=80 && value>68)
            {
                System.out.println("Canavardan 5₺ çıktı!");
                player1.setMoney(player1.getMoney()+5);
            }
            else
            {
                System.out.println("Canavardan 1₺ çıktı!");
                player1.setMoney(player1.getMoney()+1);
            }
        }
    }
}
