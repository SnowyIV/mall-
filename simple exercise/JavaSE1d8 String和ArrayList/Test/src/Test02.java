public class Test02 {
    public static void main(String[] args) {
        //创建变量并输入电话
        String phone = "15888888888";
        //取前三位
        String first3 = phone.substring(0, 3);
        //取后4位
        String last4 = phone.substring(7);
        System.out.println(first3 + "****" + last4);
    }
}
