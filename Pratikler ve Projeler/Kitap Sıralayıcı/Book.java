
public class Book implements Comparable<Book>
{
    private String bookName;
    private int pageNumber;
    private String author;
    private String releaseDate;

    public Book(String bookName, int pageNumber, String author, String releaseDate) {
        this.bookName = bookName;
        this.pageNumber = pageNumber;
        this.author = author;
        this.releaseDate = releaseDate;
    }
    @Override
    public int compareTo(Book b1)
    {
        return this.bookName.compareTo(b1.bookName);
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
