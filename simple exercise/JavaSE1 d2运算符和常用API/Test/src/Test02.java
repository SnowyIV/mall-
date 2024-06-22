import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//键盘录入
        System.out.println("请输入月份");
        int month = sc.nextInt();//创建变量
        switch (month){//判断条件
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("该月为31天");
                break;
            case 2:
                System.out.println("该月为28天");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("该月为30天");
                break;
        }
    }
}
