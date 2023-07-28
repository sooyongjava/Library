package UserManage;

import BookManage.BookMethodImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserMethodImpl implements UserMethod {

    private static Map<String, User> user = new HashMap<>(); // 헷갈렸던 부분 2 : 저장소 역할을 하는 변수를 어디에 선언해야 하나?
    private static User loginUser = null;

    @Override
    public void userSignUp() {
        Scanner sc = new Scanner(System.in);
        Pattern passPattern1 = Pattern.compile("^[a-zA-Z]{1}[a-zA-Z0-9]{4,11}$");

        while (true) {
            System.out.println("======================== 회원가입 ========================");
            System.out.print("이름을 입력해 주세요 : ");
            String name = sc.nextLine().trim();

            System.out.print("사용하실 아이디를 입력해 주세요 : ");
            String id = sc.nextLine().trim();
            Matcher matcher = passPattern1.matcher(id);

            if (!matcher.find()) {
                System.out.println("아이디는 영문으로 시작하여 영문과 숫자만 사용이 가능하고 5~12자 이하여야 합니다.");
                continue;
            }

            if (user.containsKey(id)) {
                System.out.println("이미 존재하는 아이디입니다.");
            } else {
                System.out.print("사용하실 패스워드를 입력해주세요 : ");
                String password = sc.nextLine().trim();
                User registerUser = new User(id, password, name);
                user.put(id, registerUser);
                break;
            }
        }
        System.out.println("회원가입이 완료되었습니다.");
    }

    @Override
    public boolean userLogin() {
        Scanner sc = new Scanner(System.in);

        System.out.println("======================== 로그인 ========================");
        System.out.print("로그인 하실 아이디를 입력해 주세요 : ");
        String id = sc.nextLine().trim();

        if (!user.containsKey(id)) {
            System.out.println("아이디가 존재하지 않습니다.");
            return false;
        }

        System.out.print("비밀번호를 입력하세요. : ");
        String password = sc.nextLine().trim();

        if (!user.get(id).getPassword().equals(password)) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return false;
        }

        loginUser = new User(id, password, user.get(id).getName());
        System.out.println(loginUser.getName() + "님 어서오세요.");
        libraryMenu();
        return true;
    }

    @Override
    public void libraryMenu() {
        Scanner sc = new Scanner(System.in);
        BookMethodImpl bookMethod = new BookMethodImpl();
        while (true) {
            System.out.println("==========   도서관 입장을 환영합니다.   ==========\n");
            System.out.println("                1. 도서 목록 조회");
            System.out.println("                2. 도서 검색");
            System.out.println("                3. 도서 대출");
            System.out.println("                4. 도서 반납");
            System.out.println("                5. 로그아웃");
            System.out.print("\n==========      번호를 선택하세요.      ========== >>>");

            int select = sc.nextInt();

            switch (select) {
                case 1:
                    bookMethod.bookListPrint();
                    break;
                case 2:
                    bookMethod.bookSearch();
                    break;
                case 3:
                    bookMethod.bookRent();
                    break;
                case 4:
                    bookMethod.bookReturn();
                    break;
                case 5:
                    logout();
                    break;
            }
        }
    }

    @Override
    public void logout() {
        if (loginUser != null) {
            System.out.println(loginUser.getName() + "님 !! 로그아웃 되었습니다.");
            loginUser = null;
        } else {
            System.out.println("로그인 상태가 아닙니다.");
        }
    }

    public User getLoginUser() {
        return loginUser;
    }
}
