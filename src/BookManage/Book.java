package BookManage;

public class Book {
    private long bookId;
    private String bookTitle;
    private String bookWriter;
    private boolean bookRentalAvailability;
    // 대출한 유저

    public Book(long bookId, String bookTitle, String bookwriter, boolean bookRentalAvailability) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookWriter = bookwriter;
        this.bookRentalAvailability = bookRentalAvailability;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter;
    }

    public boolean isBookRentalAvailability() {
        return bookRentalAvailability;
    }

    public void setBookRentalAvailability(boolean bookRentalAvailability) {
        this.bookRentalAvailability = bookRentalAvailability;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookwriter='" + bookWriter + '\'' +
                ", bookRentalAvailability=" + bookRentalAvailability +
                '}';
    }
}