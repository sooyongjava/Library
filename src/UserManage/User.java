package UserManage;

import BookManage.Book;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String password;
    private String name;
    private List<String> rentalBookList = new ArrayList();

    // 기본 생성자
    public User() {}

    public User(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.rentalBookList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getRentalBookList() {
        return rentalBookList;
    }

    public void addRentalBookList(String bookTitle) {
        rentalBookList.add(bookTitle);
    }
}
