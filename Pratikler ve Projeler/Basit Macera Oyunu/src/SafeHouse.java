public class SafeHouse extends Location
{
    public SafeHouse(String locName)
    {
        super(locName="Safe House");
    }
    public void giveHeal(Player player)
    {
        System.out.println("Güvenli Ev Candır :)");
        System.out.println("Dinleniyorsun...");
        player.setHealth(player.getHealth()+5);
        System.out.println("Canın: "+player.getHealth());
    }
}
