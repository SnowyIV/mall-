//1.数组元素求和
public class Test01 {
    public static void main(String[] args) {
        //创建数组
        int arr[] = {22, 33, 35, 13, 88};
        //创建sum变量
        int sum = 0;
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            //求和
            sum += arr[i];
        }
        System.out.println("数组元素的和为"+sum);
    }
}
