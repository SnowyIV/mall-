/*
红茶妹妹有21元钱，她攒了几天钱之后自己的钱比原来的两倍还多三块。绿茶妹妹有24元钱，她攒了几
天钱之后自己的钱正好是原来的两倍。那么红茶和绿茶现在的钱一样多，请问对么？
*/
public class Test02 {
    public static void main(String[] args) {
        int rmoney = 21;//定义变量并赋值
        int gmoney = 24;//定义变量并赋值
        int rsmoney = rmoney * 2 + 3;//运算红茶妹妹钱数
        int gsmoney = gmoney * 2;//运算绿茶妹妹钱数
        boolean isdb = rsmoney == gsmoney;//对比钱数是否一致
        System.out.println("现在红茶和绿茶现在的钱一样多是对的吗？" + isdb);
        System.out.println("红茶妹妹的钱为" + rsmoney + ",绿茶妹妹的钱为" + gsmoney);
    }
}
