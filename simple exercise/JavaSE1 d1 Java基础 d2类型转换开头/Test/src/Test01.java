/*
* 身高是具有遗传性的，子女的身高和父母的身高有一定的关系。假定，父母和子女的身高遗传关系如
下：
儿子身高（厘米）＝(父亲身高＋母亲身高) ×1.08÷2
女儿身高（厘米）＝(父亲身高×0.923＋母亲身高) ÷2
现有父亲身高177CM,母亲身高165CM。求子女身高分别预计为多少？
 */

public class Test01 {
    public static void main(String[] args) {
        double fheight = 177;//定义变量并赋值
        double mheight = 165;//定义变量并赋值

        System.out.println("儿子身高为："+(fheight+mheight)*1.08/2);
        System.out.println("女儿身高为："+(fheight*0.923+mheight)/2);
    }
}
