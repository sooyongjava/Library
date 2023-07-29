package BookManage;

import UserManage.User;
import UserManage.UserMethodImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BookMethodImpl implements BookMethod {

    UserMethodImpl userMethod = new UserMethodImpl();
    User loginUser = userMethod.getLoginUser(); // 헷갈렸던 부분 : 로그인한 유저의 정보를 어떻게 BookMethodImple로 가져올 수 있을까?

    Book book1 = new Book(1, "신  데  렐  라", "가브리엘라", true);
    Book book2 = new Book(2, "세이노의 가르침", "세 이 노", true);
    Book book3 = new Book(3, "하 늘 과 바 람", "김 상 욱", true);
    Book book4 = new Book(4, "원         씽", "게리 캘러", true);
    Book book5 = new Book(5, "역    행    자", "자   청", true);
    Book book6 = new Book(6, "메  리  골  드", "윤 정 은", true);
    Book book7 = new Book(7, "나 는    너 랑", "하 태 완", true);
    Book book8 = new Book(8, "꿀 벌 의 예 언1", "베르나르", true);
    Book book9 = new Book(9, "동  물  농  장", "조지오웰", true);
    Book book10 = new Book(10, "인  간 실  격", "디자오사무", true);

    List<Book> bookList = new ArrayList<>();

    public void bookListsetting() {
        bookList.add(book1);
        bookList.add(book6);
        bookList.add(book2);
        bookList.add(book7);
        bookList.add(book3);
        bookList.add(book8);
        bookList.add(book4);
        bookList.add(book9);
        bookList.add(book5);
        bookList.add(book10);
    }

    @Override
    public void bookListPrint() {
        bookListsetting();


        System.out.println("\n도서명\t\t\t\t\t저자\t\t\t대출 가능 여부");
        System.out.println("================================================");

        for (Book bookList : bookList) {
            String bookStatus = "";
            if (bookList.isBookRentalAvailability()) {
                bookStatus = "대출 가능";
            } else {
                bookStatus = "대출 불가능";
            }
            System.out.println(bookList.getBookTitle() + "\t\t" + bookList.getBookWriter() + "\t\t" + bookStatus);
        }
    }

    @Override
    public void bookSearch() {
        Scanner sc = new Scanner(System.in);
        System.out.println("======================== 도서 찾기 ========================");
        System.out.print("도서명을 입력하세요.  >>> ");
        String searchBook = sc.nextLine().trim().replaceAll("\\s", "");
        boolean bookCatch = false;

        for (Book bookList : bookList) {
            if (bookList.getBookTitle().replaceAll("\\s", "").equalsIgnoreCase(searchBook)) {
                String bookStatus = bookList.isBookRentalAvailability() ? "대출 가능" : "대출 불가능";
                System.out.println("\n도서명\t\t\t\t\t저자\t\t\t대출 가능 여부");
                System.out.println(bookList.getBookTitle() + "\t\t" + bookList.getBookWriter() + "\t\t" + bookStatus);
                bookCatch = true;
                break;
            }
        }
        if (!bookCatch) {
            System.out.println("죄송하지만 검색하신 책을 찾을 수가 없습니다 !");
        }
    }

    @Override
    public void bookRent() {
        Scanner sc = new Scanner(System.in);

        System.out.println("======================== 도서 대출 ========================");
        bookListPrint();
        System.out.print("======================== 도서명을 입력하세요. ======================== >>>");
        String selectBook = sc.nextLine().trim();
        boolean bookCatch = false;

        for (Book book : bookList) {
            if (book.getBookTitle().replaceAll("\\s", "").equals(selectBook.replaceAll("\\s", ""))) {
                if (book.isBookRentalAvailability()) {
                    book.setBookRentalAvailability(false);
                    System.out.println("<<" + book.getBookTitle() + ">>" + "를 대출하셨습니다 !");
                    loginUser.addRentalBookList(selectBook);
                } else {
                    System.out.println("이미 대출 중인 도서입니다 !");
                }
                bookCatch = true;
                break;
            }
        }
        if (!bookCatch) {
            System.out.println("죄송하지만 저희 도서관에는 존재하지 않는 책입니다 !");
        }
    }

    @Override
    public void bookReturn() {
        Scanner sc = new Scanner(System.in);
        User loginuser = userMethod.getLoginUser();
        System.out.println("======================== 도서 반납 (현재 빌린 도서 목록) ========================");
        try {
            System.out.println(loginuser.getRentalBookList());
        } catch (Exception e) {
            System.out.println("현재 빌리고 계신 도서가 없습니다 !");
        }

        System.out.print("======================== 도서명을 입력하세요. ======================== >>>");
        String returnBook = sc.nextLine().trim().replaceAll("\\s","");

        if (loginUser.getRentalBookList().remove(returnBook)) {
            for (Book book : bookList) {
                if (book.getBookTitle().replaceAll("\\s", "").equalsIgnoreCase(returnBook.replaceAll("\\s", ""))) {
                    book.setBookRentalAvailability(true);
                    System.out.println("<<" + book.getBookTitle() + ">>" + "를 반납하셨습니다 !");
                    return;
                }
            }
            System.out.println("도서 목록에서 해당 도서를 찾지 못했습니다.");
        } else {
            System.out.println("대출한 도서 목록에서 해당 도서를 찾지 못했습니다.");
        }
    }
}
