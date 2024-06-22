package com.geekaca;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ATM 模拟系统
 */
public class ATMSystem {
    /**
     * 1, 有一个集合 用来保存系统中的所有账户对象
     * 成员变量
     */
    private static ArrayList<Account> accountList = new ArrayList<>();

    public static void main(String[] args) {
        initAccount();
        System.out.println("=====欢迎进入ATM系统======");
        System.out.println("1, 登陆账户");
        System.out.println("2, 注册账户");
        System.out.println("请选择操作(输入数字)");
        Scanner scanner = new Scanner(System.in);
        int inputInt = scanner.nextInt();
        switch (inputInt) {
            case 1:
//                System.out.println("登陆");
                //提示用户输入卡号，密码，执行判断
                login(scanner);
                break;
            case 2:
                System.out.println("注册");
                register(scanner);
                break;
            default:
                System.out.println("输入有误！");
                break;
        }
    }

    //注册账号
    private static void register(Scanner scanner) {
        System.out.println("请输入账户名称:");
        String accName = scanner.next();
        while (true) {
            System.out.println("请输入密码：");
            String pass = scanner.next();
            System.out.println("请再次输入密码：");
            String pass2 = scanner.next();
            if (pass.equals(pass2)) {
                //两次密码一致, 生成随机8位卡号，判断是否已经存在了
                //生成随机8位卡号
                String cardID = generateCardID();
                //判断是否已经存在了
                boolean isExsist = isCardIDExsists(cardID);
                //只要卡号已经存在了，重复了，就需要重新生成
                while (isExsist) {
                    cardID = generateCardID();
                    isExsist = isCardIDExsists(cardID);
                }
                // 用cardID这个卡号，创建Account对象，把属性填充进去 ，账户名，密码，余额，限额
                //把Account对象 存入集合
                break;
            } else {
                System.out.println("两次密码不一致!!!");
            }
        }
    }

    //判断卡号是否已经在 账户集合中存在了
    private static boolean isCardIDExsists(String cardID) {
        for (int i = 0; i < accountList.size(); i++) {
            Account account = accountList.get(i);
            String cardId = account.getCardId();
            if (cardID.equals(cardId)) {
                return true;
            }
        }
        return false;
    }

    //生成8位卡号
    private static String generateCardID() {
        return "";
    }

    //写死几个账号，用于测试
    private static void initAccount() {
        Account acc = new Account("666666", "张三丰", "123", 0, 100);
        Account acc2 = new Account("999999", "周芷若", "123", 0, 100);
        accountList.add(acc);
        accountList.add(acc2);
    }

    /**
     * 登陆验证
     *
     * @param scanner
     */
    private static void login(Scanner scanner) {
        System.out.println("==================欢迎您进入到登录操作======================");
        while (true) {
            System.out.println("请输入您的卡号:");
            String inputCardNo = scanner.next();
            System.out.println("请您输入登录的密码:");
            String inputPass = scanner.next();
            //验证 卡号和密码是否正确 ，在集合中查找 是否有一个账户对象，他的卡号和密码刚好能够匹配 你的输入
            //如何表示 没有找到, 遍历了所有账户对象后，都没有匹配，说明登陆失败
            //是否找到了
            boolean isFound = false;
            for (int i = 0; i < accountList.size(); i++) {
                Account account = accountList.get(i);
                if (inputCardNo.equals(account.getCardId()) && inputPass.equals(account.getPassword())) {
                    //登陆成功
                    isFound = true;
                    //登陆成功, 进入用户操作界面
                    System.out.println("登陆成功！");
                    System.out.println("欢迎你：" + account.getUserName() + "先生/女士进入系统，您可开始办理你的业务了!");
                    //展示用户菜单  account 对象就是当前登陆成功的 账户 ，包含了详细信息
                    showUserMenu(scanner, account);
                    return;//终止当前所在的函数
                }
            }//end for
            if (!isFound) {
                //登陆失败
                System.out.println("登陆失败");
            }
        }
    }

    /**
     * 显示用户操作菜单
     *
     * @param scanner
     * @param account 当前登陆的账户对象
     */
    private static void showUserMenu(Scanner scanner, Account account) {

        while (true) {
            System.out.println("==================欢迎您进入到操作界面======================");
            System.out.println("1, 查询");
            System.out.println("2, 存款");
            System.out.println("3, 取款");
            System.out.println("4, 转账");
            System.out.println("5, 修改密码");
            System.out.println("6, 退出");
            System.out.println("7, 注销账户");
            System.out.println("请输入你的选择：");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println("=====您的账户信息如下:=====");
                    System.out.println("账户名: " + account.getUserName());
                    System.out.println("卡号: " + account.getCardId());
                    System.out.println("余额: " + account.getMoney());
                    System.out.println("取款限额: " + account.getQuotaMoney());
                    System.out.println("===========================");
                    break;
                case 2:
                    //存款  都是针对当前的account对象操作
                    System.out.println("=====欢迎进入账号存款操作=====");
                    System.out.println("请输入存款金额");
                    Double Smoney = scanner.nextDouble();
                    account.setMoney(account.getMoney() + Smoney);
                    System.out.println("存款成功");
                    break;
                case 3:
                    //取款
                    System.out.println("=====欢迎进入账号存款操作=====");
                    System.out.println("请输入取款金额");
                    int Gmoney = scanner.nextInt();
                    if (Gmoney < account.getMoney()) {
                        account.setMoney(account.getMoney() - Gmoney);
                        System.out.println("取款成功");
                        break;
                    }else{
                        System.out.println("余额不足");
                        break;
                    }
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("输入有误");
                    break;
            }
        }
    }
}
