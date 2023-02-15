import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Set<Book> books =new TreeSet<>();

        Book book1=new Book("A-seçmeler",100,"A ile","(1915.05.05)");
        Book book2=new Book("B-seçmeler",200,"C ile","(1906.06.04)");
        Book book3=new Book("D-seçmeler",400,"B ile","(1910.07.03)");
        Book book4=new Book("E-seçmeler",270,"D ile","(1911.08.02)");
        Book book5=new Book("C-seçmeler",350,"E ile","(1909.09.01)");

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        System.out.println("Order By Name\n__________");
        Iterator<Book> itr =books.iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next().getBookName());
        }
        System.out.println("---------------------------------");
        Set<Book> books1 =new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageNumber()-o2.getPageNumber();
            }
        });
        books1.addAll(books);
        System.out.println("Order By Page Number\n__________");
        for(Book b:books1)
            System.out.println(b.getPageNumber());
    }
}