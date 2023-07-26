package BookManage;

public class Book {
    private String bookTitle;
    private String bookwriter;
    private boolean bookRentalAvailability;

    public Book(String bookTitle, String bookwriter, boolean bookRentalAvailability) {
        this.bookTitle = bookTitle;
        this.bookwriter = bookwriter;
        this.bookRentalAvailability = bookRentalAvailability;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookwriter() {
        return bookwriter;
    }

    public void setBookwriter(String bookwriter) {
        this.bookwriter = bookwriter;
    }

    public boolean isBookRentalAvailability() {
        return bookRentalAvailability;
    }

    public void setBookRentalAvailability(boolean bookRentalAvailability) {
        this.bookRentalAvailability = bookRentalAvailability;
    }

    @Override
    public String toString() {
        return  bookTitle + '\t' +
                bookwriter + '\t' +
                bookRentalAvailability;
    }
}