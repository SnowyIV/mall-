import java.util.ArrayList;

public class Test03cs {
    public static void main(String[] args) {
        //创建数组并存入数据
        Test03 mv1 = new Test03("肖申克","摩根弗里曼",1999,9.8);
        Test03 mv2 = new Test03("霸王别姬", "张国荣张丰毅", 1999, 9.8);
        Test03 mv3 = new Test03("阿甘正传", "汤姆汉克斯", 1999, 9.8);
        ArrayList<Test03> moivelist = new ArrayList<>();
        moivelist.add(mv1);
        moivelist.add(mv2);
        moivelist.add(mv3);
        //循环取出数组中的值
        for (int i = 0; i < moivelist.size(); i++) {
            Test03 movie = moivelist.get(i);
            System.out.println(movie.toString());
        }
    }
}
