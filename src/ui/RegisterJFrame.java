package ui;
import javax.swing.*;
public class RegisterJFrame extends JFrame {
    public RegisterJFrame(){

        //设置界面的宽高
        this.setSize(488,500);

        //设置界面的标题
        this.setTitle("拼图 注册");

        //设置界面置顶
        this.setAlwaysOnTop(true);

        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);




        //让界面显示出来，建议写在最后
        this.setVisible(true);
    }
}
