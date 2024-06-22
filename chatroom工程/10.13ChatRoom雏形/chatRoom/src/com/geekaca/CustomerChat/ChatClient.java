package com.geekaca.CustomerChat;

import com.geekaca.SeverChat.ChatConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/*
 * 图形用户界面，用GUI制作
 * */
public class ChatClient implements ActionListener {
    //设计界面的窗口
    private JFrame win = new JFrame();
    //消息内容框架
    public JTextArea smsContent = new JTextArea(23, 50);
    //发送消息的框
    private JTextArea smsSend = new JTextArea(4, 40);
    //展示在线人数
    public JList<String> onlineUsers = new JList<>();
    // 是否私聊按钮
    private JCheckBox isPrivateBn = new JCheckBox("私聊");
    // 消息按钮
    private JButton sendBn = new JButton("发送");

    // 登录界面
    private JFrame loginView;
    //输入框
    private JTextField ipEt, nameEt, idEt;
    //指向服务端
    private Socket socket;

    public static void main(String[] args) {
        new ChatClient().initView();
    }

    private void initView() {
        // 初始化聊天窗口的界面
        win.setSize(650, 600);

        // 展示登录界面
        displayLoginView();

        // 展示聊天界面
        //displayChatView();
    }


    //显示登陆界面
    private void displayLoginView() {


        loginView = new JFrame("登录");
        loginView.setLayout(new GridLayout(3, 1));
        loginView.setSize(400, 230);

        JPanel ip = new JPanel();
        JLabel label = new JLabel("   IP:");
        ip.add(label);
        //输入框
        ipEt = new JTextField(20);
        ipEt.setText("127.0.0.1");
        ip.add(ipEt);
        loginView.add(ip);

        JPanel name = new JPanel();
        JLabel label1 = new JLabel("姓名:");
        name.add(label1);
        nameEt = new JTextField(20);
        name.add(nameEt);
        loginView.add(name);

        JPanel btnView = new JPanel();
        JButton login = new JButton("登陆");
        btnView.add(login);
        JButton cancle = new JButton("取消");
        btnView.add(cancle);
        loginView.add(btnView);
        // 关闭窗口退出当前程序
        loginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setWindowCenter(loginView, 400, 260, true);

        /**
         * 给登录和取消绑定点击事件
         * 点击按钮后 谁负责处理
         * */
        login.addActionListener(this);
        cancle.addActionListener(this);

    }


    //显示聊天UI界面

    private void displayChatView() {

        JPanel bottomPanel = new JPanel(new BorderLayout());
        //-----------------------------------------------
        // 将消息框和按钮 添加到窗口的底端
        win.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(smsSend);
        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btns.add(sendBn);
        btns.add(isPrivateBn);
        bottomPanel.add(btns, BorderLayout.EAST);
        //-----------------------------------------------
        // 给发送消息按钮绑定点击事件监听器
        // 将展示消息区centerPanel添加到窗口的中间
        smsContent.setBackground(new Color(0xdd, 0xdd, 0xdd));
        // 让展示消息区可以滚动。
        win.add(new JScrollPane(smsContent), BorderLayout.CENTER);
        smsContent.setEditable(false);
        //-----------------------------------------------
        // 用户列表和是否私聊放到窗口的最右边
        Box rightBox = new Box(BoxLayout.Y_AXIS);
        onlineUsers.setFixedCellWidth(120);
        onlineUsers.setVisibleRowCount(13);
        rightBox.add(new JScrollPane(onlineUsers));
        win.add(rightBox, BorderLayout.EAST);
        //-----------------------------------------------
        // 关闭窗口退出当前程序
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.pack();  // swing 加上这句 就可以拥有关闭窗口的功能
        /** 设置窗口居中,显示出来  */
        setWindowCenter(win, 650, 600, true);
        // 发送按钮绑定点击事件
        sendBn.addActionListener(this);
    }

    private static void setWindowCenter(JFrame frame, int width, int height, boolean flag) {
        /** 得到所在系统所在屏幕的宽高 */
        Dimension ds = frame.getToolkit().getScreenSize();

        /** 拿到电脑的宽 */
        int width1 = ds.width;
        /** 高 */
        int height1 = ds.height;

        System.out.println(width1 + "*" + height1);
        /** 设置窗口的左上角坐标 */
        frame.setLocation(width1 / 2 - width / 2, height1 / 2 - height / 2);
        frame.setVisible(flag);
    }

    //当按钮被点击的时候，此方法会被调用
    @Override
    public void actionPerformed(ActionEvent e) {
        /** 得到点击的事件源
         * 判断点击的哪个按钮
         * */
        JButton btn = (JButton) e.getSource();
        //获得按钮文字，判断
        switch (btn.getText()) {
            case "登陆":
                doLogin();
                break;
            case "发送":
                //获取用户输入的文字发送给服务器
                //得到发送消息的内容
                String msgSend = smsSend.getText().toString();
                //判断
                if (msgSend == null ||"".equals(msgSend.trim())){
                    JOptionPane.showMessageDialog(loginView,"输入不能为空！");
                    return;
                }
                //把聊天信息发送出去
                try {
                    OutputStream ops = socket.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(ops);
                    dos.writeInt(com.geekaca.CustomerChat.ChatConstant.MSG_CHAT);
                    dos.writeUTF(msgSend);
                    dos.flush();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                //文本输入框清空
                smsSend.setText(null);
                break;
                //
            case "取消":
                // 退出系统, 退出整个程序
                System.exit(0);
                break;
        }
    }

    private void doLogin() {
        /**
         * 从输入框拿到输入的信息
         */
        String ipStr = ipEt.getText().toString();
        String name = nameEt.getText().toString();

        if (ipStr == null || ipStr.trim().equals("")) {
            JOptionPane.showMessageDialog(loginView, "IP 地址不能为空!");
            return;
        }
        if (name == null || name.trim().equals("")) {
            JOptionPane.showMessageDialog(loginView, "昵称不能为空!");
        }
        //todo: 连接socket服务端
        try {
            socket = new Socket(ipStr, ChatConstant.Port);
            System.out.println("开始连接 : " + ipStr + ":" + ChatConstant.Port);
            new Thread(new ClientReaderRunable(socket, name, this)).start();
            //窗口显示自己的昵称
            win.setTitle(name);
            //关闭登陆界面
            loginView.dispose();
            //打开聊天主界面
            displayChatView();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
