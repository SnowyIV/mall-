//⚫ 随机生成一个1-100之间的数据，提示用户猜测，猜大提示过大，猜小提示过小，直到猜中结束游戏

import java.util.Random;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        //随机生成一个1-100之间的数据
        Random r = new Random();
        int random = r.nextInt(100) + 1;
        //创建键盘输入
        Scanner scanner = new Scanner(System.in);
        //创建计数
        int count = 0;
        //while死循环
        while (true) {
            System.out.println("请输入1-100之间的数字进行猜测");
            int num = scanner.nextInt();
            count++;
            //if判断
            if (num == random) {
                System.out.println("猜对了，随机数为" + random + "共猜测" + count + "次");
                break;
            } else if (num < random) {
                System.out.println("猜小了");
            } else if (num > random) {
                System.out.println("猜大了");
            }
            //猜测4次以后终止
            if (count == 4) {
                System.out.println("猜测次数已用完，请充值");
                break;
            }
        }
    }
}



