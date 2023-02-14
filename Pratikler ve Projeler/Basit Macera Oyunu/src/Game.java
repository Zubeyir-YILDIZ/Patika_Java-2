import java.util.Random;
import java.util.Scanner;
public class Game
{
    private Scanner input=new Scanner(System.in);
    Random rnd=new Random();
    public void start()
    {
        System.out.println("Hoşgeldiniz ");
        System.out.println("Oyundaki amacımız bir takım bölgelerdeki canavarlarla savaşarak malzeme biriktirmek\nbunun sonucunda else edilen malzemeler ile adadan kaçmak iyi eğlenceler");
        ToolStore store1=new ToolStore("Market");
        SafeHouse house1=new SafeHouse("Güvenli Ev");
        Forest forest1=new Forest("Orman");
        forest1.setStep1(false);
        Player player1=getPlayer();
        Player monster=new Player();
        while (true)
        {
            if(player1.isWood()&& player1.isFood()&& player1.isWater())
            {
                System.out.println("Tebrik ederiz adadan kurtuldunuz şimdi bizi gemiden atanlardan intikam alma vakti...");
                break;
            }
            if(player1.getHealth()<0)
            {
                System.out.println("Ölümünüz bizi üzdü.");
                break;
            }
            if(player1.isDead())
            {
                System.out.println("ölümün bizi üzdü");
                break;
            }
            System.out.println("\nBaşlamak için 1 \nkuralları görmek için 2 \nÇıkış yapmak için 3 \ntuşlayınız : ");
            int key1 = input.nextInt();
            if (key1 == 1)
            {
                System.out.println("yükleniyor...");
                System.out.println("\nUyanıyorsun.Etrafına baktığında bir adada olduğunu farkettin." +
                        "\nKendine gelip gemiden atıldığını hatırladığında toplarlanıp gözlem için yüksek bir tepeye çıkıyorsun.");
                while (true)
                {
                    System.out.println("\nÖnünde 2 farklı yol var 1.yol nehire gidiyor ama yol ormandan geçmekte 2.yol ışıkların yandığı bir kaç evden oluşan yere gidiyor");
                    System.out.println("hemen yanında ise bir mağara var içeriden bir takım sesler geliyor.gitmek istediğin yeri seç");
                    boolean wood= player1.isWood();
                    int selection=locationSelection();
                    if(selection==2)
                    {
                        System.out.println("evlere doğru yola çıktın sığınacak bir ev buluyorsun karşında ise market var");
                        System.out.println("1-Markete git\n2-Eve gir\n3-tepeye geri dön");
                        int selection2=input.nextInt();
                        while (selection2==1 || selection2==2)
                        {
                            while(selection2==1)
                            {
                                store1.menu(player1);
                                System.out.println("marketten ayrıldın,şimdi ne yapmak istersin?\n1-markete dön\n2-eve gir\n3-tepeye dön");
                                selection2=input.nextInt();
                                if(selection2==3)
                                    continue;
                            }
                            while(selection2==2)
                            {
                                house1.giveHeal(player1);
                                System.out.println("evden ayrıldın,şimdi ne yapmak istersin?\n1-markete git\n2-eve dön\n3-tepeye dön");
                                selection2=input.nextInt();
                                if(selection2==3)
                                    continue;
                            }
                            if(selection2!=2 && selection2!=1)
                            {
                                System.out.println("tepeye dönüyorsun...");
                                break;
                            }
                        }
                    }
                    else if(selection==1)
                    {
                        if(!player1.isDead())
                        {
                            if(!forest1.isStep1())
                                System.out.println("\nNehire doğru yola çıktın.Ormana giriyorsun...\ntuhaf sesler geliyor!");
                            else
                                System.out.println("Nehire ilerliyorsun");
                            while (true)
                            {
                                if(!forest1.isStep1() && !player1.isDead())
                                {
                                    System.out.println("Ayı Gördün!!!");
                                    monster=getMonster(1,false);
                                    int selectionAction=runOrAttack(player1,monster);
                                    if(selectionAction==2)
                                    {
                                        int value= rnd.nextInt(1,3);
                                        while (value>0 && player1.getHealth()>0)
                                        {
                                            fight(player1,monster);
                                            value--;
                                        }
                                        if(monster.getHealth()<=0)
                                        {
                                            System.out.println("Canavar(lar) öldü sonraki girişinde nehire ilerleyeceksin");
                                            player1.setWood(true);
                                            forest1.setStep1(true);
                                            break;
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("\ngeri dönüyorsun");
                                        selection=locationSelection();
                                        break;
                                    }
                                }
                                else if(player1.isDead())
                                    break;
                                if(forest1.isStep1() && !player1.isDead())
                                {
                                    System.out.println("orada bir zombi var!!!");
                                    monster=getMonster(selection,true);
                                    int selectionAction=runOrAttack(player1,monster);
                                    if(selectionAction==2)
                                    {
                                        int value= rnd.nextInt(1,3);
                                        while (value>0)
                                        {
                                            fight(player1,monster);
                                            if(player1.getHealth()<0)
                                                break;
                                            value--;
                                        }
                                        if(monster.getHealth()<=0)
                                        {
                                            System.out.println("Canavar(lar) Öldü geri dönüyorsun");
                                            player1.setWater(true);
                                            break;
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("\ngeri dönüyorsun");
                                        selection=locationSelection();
                                        break;
                                    }
                                }
                                else if (player1.isDead())
                                    break;
                            }
                        }
                        else
                            break;
                    }
                    else
                    {
                        while (true)
                        {
                            if(!player1.isDead())
                            {
                                monster=getMonster(3,false);
                                System.out.println("\nMağaraya giriyorsun... içeride vampir var!!!");
                                int selectionAction=runOrAttack(player1,monster);
                                if(selectionAction==2)
                                {
                                    int value= rnd.nextInt(1,3);
                                    while (value>0)
                                    {
                                        if(player1.getHealth()<0)
                                            break;
                                        fight(player1,monster);
                                        value--;
                                    }
                                    if(monster.getHealth()<=0)
                                    {
                                        System.out.println("Canavar(lar) Öldü geri dönüyorsun");
                                        player1.setFood(true);
                                        break;
                                    }
                                }
                                else
                                {
                                    System.out.println("\ngeri dönüyorsun");
                                    selection=locationSelection();
                                    break;
                                }
                            }
                            else
                                break;

                        }
                    }
                    if(player1.isWood()&& player1.isFood()&& player1.isWater())
                        break;
                    if(player1.getHealth()<0 || player1.isDead())
                        break;
                }
            }
            else if (key1==2)
            {
                System.out.println("---KURALLAR VE BİLGİLENDİRME---");
                System.out.println(
                        "\n1-Adadan kaçabilmek için su,yemek ve oduna ihtiyaç var" +
                                "\n2-Güvenli ev +5 can verir" +
                                "\n3-Sadece tek silah kuşanabilirsin" +
                                "\n4-Zırhlar canavar hasarını azaltır" +
                                "\n5-Marketten ihtiyacın olan malzemeleri canavarlardan elde ettiğin parayla satın alabilirsin " +
                                "\nİyi eğlenceler...");
            }
            else
            {
                System.out.println("Çıkış yapılıyor");
                break;
            }
        }
    }
     int runOrAttack(Player player1,Player monster1)
    {
        System.out.println("Canın: "+player1.getHealth()+" Hasarın: "+player1.getDamage());
        System.out.println("Canavarın,Canı: "+monster1.getHealth()+" Hasarı: "+(monster1.getDamage()- player1.getArmorDefence()));
        System.out.println("Kaçmak için 1\nSavaşmak için 2'yi tuşlayın");
        int selection=input.nextInt();

        return selection;
    }
     void fight(Player player1,Player monster)
    {
        while (monster.getHealth()>0 && player1.getHealth()>0)
        {
            if(player1.getHealth()>0)
            {
                System.out.println("Canın: "+player1.getHealth()+" Canavarın Canı: "+monster.getHealth());
                System.out.println("saldırıyorsun...");
                monster.setHealth(monster.getHealth()-player1.getDamage());
            }
            else
                break;
            if(monster.getHealth()>0)
            {
                System.out.println("Canın: "+player1.getHealth()+" Canavarın Canı: "+monster.getHealth());
                System.out.println("Canavar saldırıyor...");
                player1.setHealth(player1.getHealth()- monster.getDamage()+ player1.getArmorDefence());
            }
            else
                break;
        }
        if(player1.getHealth()>0 && monster.getHealth()<=0)
        {
            System.out.println("Kazandın!");
            if(monster.getCharName()=="Zombi")
            {
                player1.setWater(true);
                player1.setMoney(player1.getMoney()+4);
            }
            else if (monster.getCharName()=="Ayı")
            {
                player1.setWood(true);
                player1.setMoney(player1.getMoney()+12);
            }
            else if(monster.getCharName()=="Vampir")
            {
                player1.setFood(true);
                player1.setMoney(player1.getMoney()+7);
            }
        }
        else
        {
            System.out.println("Kaybettin");
            player1.setDead(true);
        }
    }
     int locationSelection()
    {
        System.out.println("ne yapmak istersin ?" +
                "\n1-nehire doğru ilerlemek" +
                "\n2-evlere doğru ilerlemek" +
                "\n3-mağaraya girmek");
        return input.nextInt();
    }
     Player getPlayer()
    {
        Player player1;
        System.out.print("Oyuncu adı giriniz: "); String playerName=input.nextLine();
        System.out.println(playerName +" karakter seçimi yaparak başlayabilirsin");
        System.out.println("\n1-Samuray (Hasar:5,Can:21,Para:15)\n2-Okçu (Hasar:7,Can:18,Para:20)\n3-Sövalye (Hasar:8,Can:24,Para:5)\n"); int key1=input.nextInt();
        if(key1==1)
        {
            player1=new Player();
            player1.setPlayer(playerName,5,21,15,"Samuray",false);
            player1.setFood(false);
            player1.setWater(false);
            player1.setWood(false);
            return player1;
        }
        else if (key1==2)
        {
            player1=new Player();
            player1.setPlayer(playerName,7,18,20,"Okçu  ",false);
            player1.setFood(false);
            player1.setWater(false);
            player1.setWood(false);
            return player1;
        }
        else
        {
            player1=new Player();
            player1.setPlayer(playerName,8,24,5,"Sövalye",false);
            player1.setFood(false);
            player1.setWater(false);
            player1.setWood(false);
            return player1;
        }
    }
     Player getMonster(int selection,boolean wood)
    {
        Player zombie=new Player();
        zombie.setPlayer("npc",3,10,4,"Zombi",false);
        Player vampire=new Player();
        vampire.setPlayer("npc",4,14,7,"Vampir",false);
        Player bear=new Player();
        bear.setPlayer("npc",7,20,12,"Ayı",false);
        if(selection==1)
        {
            if(!wood)
                return bear;
            else
                return zombie;
        }
        else
            return vampire;
    }
}
