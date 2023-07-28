package BookManage;

public interface BookMethod {
    void bookListPrint(); // 도서 목록 표출
    void bookSearch(); // 도서 검색
    void bookRent(); // 도서 대출
    boolean bookReturn(String bookTitle); // 도서 반납
}
