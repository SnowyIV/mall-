import java.util.Random;


public class Test04 {
    public static void main(String[] args) {
        //创建数组
        int arr[] = {33,22,35,13,88};
        //创建random函数
        Random random = new Random();
        int temp = 0;
        //遍历数组，随机一个索引，让数组的值与随机索引位置处的值互换
        for (int i = 0; i < arr.length; i++) {
            int r = random.nextInt(5);
            temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
            System.out.println(arr[i]);
        }
        //再度遍历数组
        //for (int i = 0; i < arr.length ; i++) {

        }
    }
//}
