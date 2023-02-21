import java.util.ArrayList;
import java.util.Scanner;

public class Book
{
    static Scanner input=new Scanner(System.in);
    static ArrayList<Book> books=new ArrayList<>();
    private String bookName;
    private int bookPageNumber;
    private String authorName;
    private String releaseDate;

    public Book(String bookName, int bookPageNumber, String authorName, String releaseDate) {
        this.bookName = bookName;
        this.bookPageNumber = bookPageNumber;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPageNumber() {
        return bookPageNumber;
    }

    public void setBookPageNumber(int bookPageNumber) {
        this.bookPageNumber = bookPageNumber;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public static void createBook(int index)
    {
        for(int i=0;i<index;i++)
        {
            input.nextLine();
            System.out.print("Kitap Adı:");
            String name=input.nextLine();
            System.out.print("Sayfa Sayısı:");
            int pageNumber=input.nextInt();
            System.out.print("Yazarı: ");
            input.nextLine();
            String author=input.nextLine();
            System.out.print("Yayınlanma Tarihi: ");
            String releaseDate=input.nextLine();

            Book book=new Book(name,pageNumber,author,releaseDate);
            books.add(book);
        }
    }
    public static void getGreaterThan(int number)
    {
        books.stream().filter(i -> i.getBookPageNumber()>number).map(i ->"Kitap Adı: "+i.getBookName()+" || Yazarı: "+i.getAuthorName()+" || Sayfa Sayısı: "+i.getBookPageNumber()).forEach(i -> System.out.println(i));
    }
    public static void getBooksProperty()
    {
        books.stream().map(i ->"Kitap Adı: "+i.getBookName()+" || Yazarı: "+i.getAuthorName()).forEach(System.out::println);
    }
    public static void showMenu()
    {
        boolean isTrue=false;
        while (!isTrue)
        {
            System.out.println("1-Kitap(lar) oluştur\n2-Kitap(lar) Listele\n3-Çıkış yap");
            int key=input.nextInt();
            switch (key)
            {
                case 1:
                    System.out.println("Kaç kitap oluşturmak istiyorsunuz? ");
                    int index=Book.input.nextInt();
                    Book.createBook(index);
                    break;
                case 2:
                    System.out.println("1-Sayfa Sayısına Göre Filtrele\n2-Hepsini Getir");
                    int key2=input.nextInt();
                    if(key2==1)
                    {
                        System.out.print("Filtrelenecek Sayfa Sayısını Giriniz: ");
                        int page=input.nextInt();
                        Book.getGreaterThan(page);
                    }
                    else
                        Book.getBooksProperty();
                    break;

                case 3:
                    System.out.println("Yine bekleriz...");
                    isTrue=true;
                    break;
                default:
                    System.out.println("Bir Hata Oldu!");
                    break;
            }

        }
    }
}
