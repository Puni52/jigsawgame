package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {


    //创建一个二维数组
    //目的：用来管理数据
    //加载图片的时候，会根据二维数组中的数据进行加载
    int[][]data = new int[4][4];

    //记录空白方块在二维数组中的位置
    int x=0;
    int y=0;

    //记录当前展示图片的路径
    String path="image\\animal\\animal3\\";


    public GameJFrame(){
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化数据（打乱）
        initData();


        //初始化图片（根据打乱的结果去加载图片）
        initImage();


        //让界面显示出来，建议写在最后
        this.setVisible(true);
    }

    //初始化数据（打乱）
    private void initData() {
        //需求：
        //把一个一维数组中的数据：0-15打乱顺序
        //再按四个一组的方式添加到二维数组中


        //定义一个一维数组
        int[] tempArr={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        //打乱数组中数据的顺序
        //遍历数组，得到每一个元素，拿着每一个元素跟随机索引上的数据进行交换
        Random r=new Random();
        for (int i=0; i<tempArr.length; i++){
            //获取随机索引
            int index=r.nextInt(tempArr.length);
            //拿着每一个元素跟随机索引上的数据进行交换
            int temp=tempArr[i];
            tempArr[i]=tempArr[index];
            tempArr[index]=temp;
        }

        //给二维数组添加数据
        for (int i = 0; i < tempArr.length; i++) {

            if(tempArr[i]==0){
                x=i/4;
                y=i%4;
            }else{
                data[i/4][i%4]=tempArr[i];
            }
        }
    }


    //初始化图片
    //添加图片的时候按照二维数组中管理的数据添加图片
    private void initImage() {
        //清空已经出现的所有图片
        this.getContentPane().removeAll();

        //相对路径：相对于当前项目而言
        //  aaa\\bbb 表示在当前项目下，找aaa文件夹，再在其中找bbb


        //细节：先加载的图片在上层，后加载的图片在下层
        //所以背景图片要在最后添加

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //获取当前要加载图片的序号
                int num=data[i][j];
                //创建一个图片ImageIcon对象
                ImageIcon icon=new ImageIcon(path+num+".jpg");
                //创建一个JLabel对象（管理容器）
                JLabel jLabel=new JLabel(icon);
                //指定图片位置
                jLabel.setBounds(105*j+83,105*i+134,105,105);
                //给图片添加边框
                //0:让图片凸起
                //1:让图片凹下去
                jLabel.setBorder(new BevelBorder(1));

                //把管理容器添加到界面中
                this.add(jLabel);
                this.getContentPane().add(jLabel);
            }
        }
        //添加背景图片
        ImageIcon bg=new ImageIcon("image\\background.png");
        JLabel background=new JLabel(bg);
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);


        //刷新一下界面
        this.getContentPane().repaint();

    }

    //初始化菜单
    private void initJMenuBar() {
        //初始化菜单
        //创建整个的菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上面的两个选项的对象（功能 关于我们）
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        //创建选项下面的条目对象
        JMenuItem replayItem=new JMenuItem("重新游戏");
        JMenuItem reLoginItem=new JMenuItem("重新登陆");
        JMenuItem closeItem=new JMenuItem("关闭游戏");

        JMenuItem accountItem=new JMenuItem("公众号");

        //将每一个选项下面的条目添加到选项当中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        //将菜单里面的两个个选项添加到菜单当中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    //初始化界面
    private void initJFrame() {
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

        //给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    //按下不松
    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==65){
            //清屏
            this.getContentPane().removeAll();
            //加载完整图片
            JLabel all=new JLabel(new ImageIcon(path+"all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            //加载背景图片
            ImageIcon bg=new ImageIcon("image\\background.png");
            JLabel background=new JLabel(bg);
            background.setBounds(40,40,508,560);
            this.getContentPane().add(background);
            //刷新界面
            this.getContentPane().repaint();

        }
    }

    //松开
    @Override
    public void keyReleased(KeyEvent e) {
        //对上下左右进行判断
        //左：37 上：38 右：39 下：40
        int code=e.getKeyCode();
        if(code==37){
            if(y==0)return;
            System.out.println("向左");
            data[x][y]=data[x][y-1];
            data[x][y-1]=0;
            y--;
            //重新加载图片
            initImage();
        }else if(code==38){
            if(x==0)return;
            System.out.println("向上");
            //逻辑：把空白图片向上移动
            data[x][y]=data[x-1][y];
            data[x-1][y]=0;
            x--;
            //重新加载图片
            initImage();
        }else if(code==39){
            if(y==3)return;
            System.out.println("向右");
            data[x][y]=data[x][y+1];
            data[x][y+1]=0;
            y++;
            //重新加载图片
            initImage();
        }else if(code==40){
            if(x==3)return;
            System.out.println("向下");
            data[x][y]=data[x+1][y];
            data[x+1][y]=0;
            x++;
            //重新加载图片
            initImage();
        }else if(code==65){
            initImage();
        }
    }
}
