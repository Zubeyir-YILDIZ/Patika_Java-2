import java.util.ArrayList;
import java.util.List;

public class Race implements Runnable
{
    static Object o=new Object();
    static ArrayList<Integer> cift=new ArrayList<>();
    static ArrayList<Integer> tek=new ArrayList<>();
    List<Integer> lists;
    String name;
    public Race(List<Integer>lists,String name) {
        this.lists=lists;
        this.name=name;
    }
    static List<Integer> list1;
    static List<Integer> list2;
    static List<Integer> list3;
    static List<Integer> list4;
    static ArrayList<Integer> list=new ArrayList<>();
    static int counter=0;

    @Override
    public void run()
    {
        synchronized (o)
        {
            for(Integer i:lists)
            {
                if(i%2==0)
                    cift.add(i);
                else
                    tek.add(i);
                counter++;
            }
            if(counter==10000)
            {
                System.out.println("Çift Sayılar: "+cift);
                System.out.println("Tek Sayılar: "+tek);
            }
        }
    }
    public synchronized static void createList()
    {
        synchronized (o)
        {
            for(int i=0;i<10000;i++)
            {
                list.add(i);
            }
            list1=list.subList(0,2500);
            list2=list.subList(2500,5000);
            list3=list.subList(5000,7500);
            list4=list.subList(7500,10000);
        }

    }
}
