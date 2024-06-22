import java.util.Scanner;

public class TestApi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入分数");
        double score= scanner.nextDouble();
        String panduan = score >= 60 ? "及格" : "不及格";
        System.out.println(panduan);
    }
}
