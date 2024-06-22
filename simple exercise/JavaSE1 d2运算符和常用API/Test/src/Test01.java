import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//键盘录入
        System.out.println("请输入分数");
        int score = sc.nextInt();//创建变量
        if (score >= 95 && score < 100)//判断条件
            System.out.println("奖励一辆自行车");
        else if (score >= 90 && score < 95)
            System.out.println("奖励去游乐园");
        else if (score >= 80 && score < 90)
            System.out.println("奖励变形金刚");
        else {
            System.out.println("棒子炖肉");
        }
    }
}
