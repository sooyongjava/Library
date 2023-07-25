package Index;

import UserManage.User;
import UserManage.UserMethodImpl;

import java.util.Scanner;

public class IndexPrint {
    Scanner sc = new Scanner(System.in);

    public void index() {
        UserMethodImpl userMethodImpl = new UserMethodImpl();

        System.out.println("==========   도서 대여 프로그램   ==========\n");
        System.out.println("                1. 회원가입");
        System.out.println("                2. 로그인");
        System.out.println("                0. 종료");
        System.out.println("\n==========   번호를 선택 하세요.  ==========");
    }
}
