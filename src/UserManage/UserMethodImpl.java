package UserManage;

import java.util.HashMap;
import java.util.Scanner;

public class UserMethodImpl implements UserMethod{

    @Override
    public void userSignUp() {
        Scanner sc = new Scanner(System.in);
        User user = new User();

        System.out.println("======================== 회원가입 ========================");
        System.out.print("사용하실 아이디를 입력해 주세요 : ");
        String id = sc.nextLine().trim();

        while (true) {
            if (user.userInfo.containsKey(id)) {
                System.out.println("이미 존재하는 아이디입니다.");
                continue;
            }
            System.out.println("사용하실 패스워드를 입력해주세요 : ");
            String password = sc.nextLine().trim();
            user.userInfo.put(id, password);

            break;
        }
        System.out.println("회원가입이 완료되었습니다.");
    }

    @Override
    public void userLogin() {

    }

    @Override
    public void printRentalBook() {

    }
}
