package BookManage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BookMethodImpl implements BookMethod{

    Book book1 = new Book(1,"신  데  렐  라","가브리엘라", true);
    Book book2 = new Book(2,"세이노의 가르침","세 이 노", true);
    Book book3 = new Book(3,"하 늘 과 바 람","김 상 욱", true);
    Book book4 = new Book(4,"원         씽","게리 캘러", true);
    Book book5 = new Book(5,"역    행    자","자   청", true);
    Book book6 = new Book(6,"메  리  골  드","윤 정 은", true);
    Book book7 = new Book(7,"나 는    너 랑","하 태 완", true);
    Book book8 = new Book(8,"꿀 벌 의 예 언1","베르나르", true);
    Book book9 = new Book(9,"동  물  농  장","조지오웰", true);
    Book book10 = new Book(10,"인  간 실  격","디자오사무", true);

    List<Book> bookList = new ArrayList<>();

    public void bookListsetting() {
        bookList.add(book1); bookList.add(book6);
        bookList.add(book2); bookList.add(book7);
        bookList.add(book3); bookList.add(book8);
        bookList.add(book4); bookList.add(book9);
        bookList.add(book5); bookList.add(book10);
    }

    @Override
    public void bookListPrint() {
        bookListsetting();

//        Iterator<Book> iterator = bookList.iterator();

        System.out.println("\n도서명\t\t\t\t\t저자\t\t\t대출 가능 여부");
        System.out.println("================================================");

        for (Book bookList : bookList) {
            String bookStatus = "";
            if (bookList.isBookRentalAvailability() == true) {
                bookStatus = "대출 가능";
            } else {
                bookStatus = "대출 불가능";
            }
            System.out.println(bookList.getBookTitle() + "\t\t" + bookList.getBookWriter() + "\t\t" + bookStatus);
        }
    }

    @Override
    public void bookSearch(String bookTitle) {

    }

    @Override
    public void bookRent() {
        Scanner sc = new Scanner(System.in);

        System.out.println("======================== 도서 대출 ========================");
        bookListPrint();
        System.out.print("======================== 도서명을 입력하세요. ======================== >>>");
        String selectBook = sc.nextLine().trim();

        for (Book book : bookList){
            if (book.getBookTitle().replaceAll("\\s", "").equals(selectBook)) {
                if (book.isBookRentalAvailability()) {
                    book.setBookRentalAvailability(false);
                }
            }
        }
    }

    @Override
    public boolean bookReturn(String bookTitle) {
        return false;
    }
}
