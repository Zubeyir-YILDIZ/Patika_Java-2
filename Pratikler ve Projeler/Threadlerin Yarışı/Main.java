public class Main {
    public static void main(String[] args)
    {
        Race.createList();
        Thread t1=new Thread(new Race(Race.list1,"1."));
        Thread t2=new Thread(new Race(Race.list2,"2."));
        Thread t3=new Thread(new Race(Race.list3,"3."));
        Thread t4=new Thread(new Race(Race.list4,"4."));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}