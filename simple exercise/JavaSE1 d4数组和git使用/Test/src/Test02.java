//2.求数组最大值和最小值
public class Test02 {
    public static void main(String[] args) {
        //创建数组
        int arr[] = {22, 33, 35, 13, 88};
        //创建最大值和最小值得变量
        int max = 0;
        int min = 0;
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            //if判断并取值
            if (max < arr[i]) {
                max = arr[i];
            } else if (min < arr[i]) {
                min = arr[i];
            }
        }
        System.out.println("最大值为"+max+",最小值为"+min);
    }
}
