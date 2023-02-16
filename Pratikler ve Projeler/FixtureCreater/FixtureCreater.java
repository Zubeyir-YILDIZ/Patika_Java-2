import java.util.*;

public class FixtureCreater
{
    Scanner input=new Scanner(System.in);
    Random rnd=new Random();
    public void createTeam()
    {
        List<String> teams=new ArrayList<>();
        String teamName;
        System.out.print("Takım sayısı giriniz:");
        int teamCount= input.nextInt();
        if(!isDouble(teamCount))
            teams.add("Bay ");

        for(int i=0;i<teamCount;i++)
        {
            System.out.println("takım giriniz:");
            teamName=input.next();
            teams.add(teamName);
        }
        createFixture(teams);
    }
    public void createFixture(List<String> ts)
    {
        System.out.println(ts);
        Set<String> set=new TreeSet<>();
        Set<String> set2=findAllMatch(ts);

        for(int a=0;a<(ts.size()*(ts.size()-1)/(ts.size()/2));a++)
        {
            System.out.println("WEEK-"+(a+1));
            List<String> teams=new ArrayList<>();
            teams.addAll(ts);
            List<String> teamsH=new ArrayList<>();
            List<String> teamsA=new ArrayList<>();
            int number;
            int number2;
            for (int i=0;i<ts.size()/2;i++)
            {
                number=takeNumber(teams);
                teamsH.add(teams.get(number));
                teams.remove(number);
            }
            teamsA.addAll(teams);
            System.out.println(teamsA);
            System.out.println(teamsH);
            for(int j=0;j< ts.size()/2;j++)
            {
                number=takeNumber(teamsH);
                number2=takeNumber(teamsA);

                set.add(teamsH.get(number)+" vs "+teamsA.get(number2));

                if(!set2.equals(set))
                {
                    System.out.println(teamsH.get(number)+" vs "+teamsA.get(number2));
                }
                teamsA.remove(number2);
                teamsH.remove(number);
            }
        }
    }
    public Set<String> findAllMatch(List<String> l)
    {
        Set<String> set=new TreeSet<>();
        int counter=0;
        while (counter!=l.size()*(l.size())-1)
        {
            set.add(l.get(takeNumber(l))+" vs "+l.get(takeNumber(l)));
            counter++;
        }
        System.out.println(set);
        return set;
    }
    public int takeNumber(List<String> p1)
    {
        return rnd.nextInt(p1.size());
    }
    public boolean isDouble(int teamCount)
    {
        if(teamCount % 2 ==0 )
            return true;
        else
            return false;
    }
}
