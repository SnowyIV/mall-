import java.util.Random;
import java.util.Scanner;

//3.随机打乱顺序
public class Test03 {
    public static void main(String[] args) {
        //创建键盘录入函数
        Scanner scanner = new Scanner(System.in);
        //创建数组
        int arr[] = new int[5];
        for (int i = 0; i < arr.length; i++) {
            //录入员工号
            System.out.println("请输入第" + (i + 1) + "个员工的工号");
            int arrs = scanner.nextInt();
            arr[i] = arrs;
        }
        //创建random函数
        Random random = new Random();
        int temp = 0;
        //遍历数组，随机一个索引，让数组的值与随机索引位置处的值互换
        for (int i = 0; i < arr.length; i++) {
            int r = random.nextInt(5);
            temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
        }
        //再度遍历数组
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
}


