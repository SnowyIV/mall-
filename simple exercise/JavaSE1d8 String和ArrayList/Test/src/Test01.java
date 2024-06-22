import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        //创建变量并输入账号和密码
        String password = "sh123456";
        String mima = "sh123456";
        Scanner scanner = new Scanner(System.in);
        //循环3次并判断账号密码是否正确
        for (int i = 0; i < 4; i++) {
            System.out.println("请输入账号");
            String zhanghao = scanner.next();
            System.out.println("请输入密码");
            String mima1 = scanner.next();
            if (password.equals(zhanghao) && mima.equals(mima1)) {
                System.out.println("登录成功");
                break;
            }
            if (2 - i == 0) {
                System.out.println("已超过最大验证次数，请稍后再试");
                break;
            } else {
                System.out.println("验证错误，你还有" + (2 - i) + "次机会");
            }
        }
    }
}


