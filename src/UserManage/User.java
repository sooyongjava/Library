package UserManage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    private String id;
    private String password;
    private String name;
    private List rentalBookList = new ArrayList();
    public HashMap<String, String> userInfo = new HashMap<>();

    // 기본 생성자
    public User() {
        super();
    }

    public User(String id, String password, String name, List rentalBookList, HashMap userInfo) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.rentalBookList = rentalBookList;
        this.userInfo = userInfo;
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

    public void setRentalBookList(List rentalBookList) {
        this.rentalBookList = rentalBookList;
    }

    public HashMap<String, String> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(HashMap<String, String> userInfo) {
        this.userInfo = userInfo;
    }
}
