package test;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class MyJFrame3 extends JFrame implements KeyListener {

    public MyJFrame3() {
        //设置界面的宽高
        this.setSize(603,680);

        //设置界面的标题
        this.setTitle("拼图小游戏 v1.0");

        //设置界面置顶
        this.setAlwaysOnTop(true);

        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);

        //取消默认的居中放置，只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);

        //给整个窗体添加键盘监听
        //调用者this：苯类对象，当前的界面对象，表示我要给整个界面添加监听
        //addKeyListener：表示要给本界面添加键盘监听
        //参数this：当事件被触发之后，会执行本类中的对应代码
        this.addKeyListener(this);






        //让整个界面显示出来
        this.setVisible(true);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("单击");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开");
        //获取键盘上每一个按键的编号
        int code=e.getKeyCode();
        if(code==65){
            System.out.println("按下A");
        }
    }
}
