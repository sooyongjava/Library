package Index;

import UserManage.User;
import UserManage.UserMethodImpl;

import java.util.Scanner;

public class IndexPrint {
    Scanner sc = new Scanner(System.in);

    public void index() {
        UserMethodImpl userMethodImpl = new UserMethodImpl();

        System.out.println("==========   도서 대출 프로그램   ==========\n");
        System.out.println("                1. 회원가입");
        System.out.println("                2. 로그인");
        System.out.println("                0. 종료");
        System.out.print("\n==========   번호를 선택 하세요.  ==========   >>>> ");

        int select = sc.nextInt();

        switch (select) {
            case 1:
                userMethodImpl.userSignUp();
                break;
            case 2:
                userMethodImpl.userLogin();
                break;
            case 0:
                System.exit(0);
        }
    }
}
