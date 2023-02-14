import java.util.Scanner;

public class ToolStore extends Location
{
    private Scanner input =new Scanner(System.in);
    public ToolStore(String locName)
    {
        super(locName="ToolStore");
    }
    public void menu(Player player1)
    {
        int money=player1.getMoney();
        int damage=player1.getDamage();
        System.out.println("Markete Hoşgeldiniz \nParanız: "+money +"₺");
        System.out.println("Silahlar için-1 \nZırhlar için-2 \nÇıkmak için-3\n    tuşlayınız...");
        int selection1=input.nextInt();
        switch (selection1)
        {
            case 1:
                System.out.println("--Silah Menüsü--");
                System.out.println("1-Tabanca(25₺) Hasar -> 2\n2-Kılıç(35₺) Hasar -> 3\n3-Tüfek(45₺) Hasar -> 7\n4-Çıkış\n5-Zırhlar Menüsü");
                int selection2=input.nextInt();
                if(selection2==5)
                    selection1=2;
                else if (selection2==4)
                    break;
                else
                {
                    switch (selection2)
                    {
                        case 1:
                            if(money>=25)
                            {
                                if(! player1.isWeapon())
                                {
                                    player1.setDamage(damage+2);
                                    player1.setMoney(money-25);
                                    player1.setWeapon(true);
                                }
                                else
                                {
                                    System.out.println("zaten silahınız var değiştirme istediğinize emin misiniz (e/E)-(h/H) ?");
                                    String key =input.nextLine();
                                    if(key.toLowerCase()=="e");
                                    {
                                        player1.setDamage(damage+2);
                                        player1.setMoney(money-25);
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("Yetersiz bakiye");
                            }
                            break;
                        case 2:
                            if(money>=35)
                            {
                                if(! player1.isWeapon())
                                {
                                    player1.setDamage(damage+3);
                                    player1.setMoney(money-35);
                                    player1.setWeapon(true);
                                }
                                else
                                {
                                    System.out.println("zaten silahınız var değiştirme istediğinize emin misiniz (e/E)-(h/H) ?");
                                    String key =input.nextLine();
                                    if(key.toLowerCase()=="e");
                                    {
                                        player1.setDamage(damage+3);
                                        player1.setMoney(money-35);
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("Yetersiz bakiye");
                            }
                            break;
                        case 3:
                            if(money>=45)
                            {
                                if(! player1.isWeapon())
                                {
                                    player1.setDamage(damage+7);
                                    player1.setMoney(money-45);
                                    player1.setWeapon(true);
                                }
                                else
                                {
                                    System.out.println("zaten silahınız var değiştirme istediğinize emin misiniz (e/E)-(h/H) ?");
                                    String key =input.nextLine();
                                    if(key.toLowerCase()=="e");
                                    {
                                        player1.setDamage(damage+7);
                                        player1.setMoney(money-45);
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("Yetersiz bakiye");
                            }
                            break;
                        default:
                            System.out.println("Hatalı giriş");
                            break;
                    }
                }
                break;
            case 2:
                System.out.println("--Zırh Menüsü--");
                System.out.println("1-Hafif(15₺) Zırh -> 1\n2-Orta(25₺) Zırh -> 3\n3-Ağır(40₺) Zırh -> 5\n4-Çıkış");
                selection2=input.nextInt();
                if(selection2==1)
                {
                    if(money>=15)
                    {
                        player1.setArmorDefence(1);
                    }
                    else
                    {
                        System.out.println("Yetersiz bakiye");
                        break;
                    }
                }
                else if (selection2==2)
                {
                    if(money>=25)
                    {
                        player1.setArmorDefence(3);
                    }
                    else
                    {
                        System.out.println("Yetersiz bakiye");
                        break;
                    }
                }
                else if (selection2==3)
                {
                    if(money>=40)
                    {
                        player1.setArmorDefence(5);
                    }
                    else
                    {
                        System.out.println("Yetersiz bakiye");
                        break;
                    }
                }
                else if(selection2==4)
                    break;
                else
                    System.out.println("hatalı giriş");
                break;
            case 3:
                break;
            default:
                System.out.println("hatalı giriş");
                break;
        }
    }
}
