import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//键盘录入
        System.out.println("请输入一个整数");
        int num = sc.nextInt();//创建变量
        int sum = 0;//创建变量
        for (int i = 1; i <= num; i++) {//for循环
            sum += i;//求和
        }
        System.out.println(+sum);
    }
}
