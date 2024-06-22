import com.geekaca.Moive;

import java.util.*;

public class ListCompare {
    public static void main(String[] args) {
        //List数组存储并循环放入数据
        List<Moive> moiveList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Moive mv = new Moive("蜡笔小新",9.5,"小新");
            moiveList.add(mv);
        }
        //创建并存储要查找的变量
        String toSearchName = "蜡笔小新9999";
        //开始时间
        Long start = System.currentTimeMillis();
        //list遍历数组并查找想要的变量
        moiveList.forEach(mv ->{
            if (toSearchName.equals(mv.getName())){
                System.out.println("找到了"+mv);
            }
        });
        //结束时间
        Long end = System.currentTimeMillis();
        //计算所用时间
        System.out.println("所用时间为："+(end-start));
        //map数组循环并放入数据
        Map<String,Moive> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            String name = "蜡笔小新"+i;
            map.put(name,new Moive("蜡笔小新",9.5,"小新"));
        }
        //开始时间
        Long start1 = System.currentTimeMillis();
        //遍历数组并查找想要的变量
        Moive moive = map.get(toSearchName);
        //结束时间
        Long end1 = System.currentTimeMillis();
        //计算所用时间
        System.out.println("所用时间为："+(end1-start1));
    }
}
