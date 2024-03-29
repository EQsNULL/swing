import javax.swing.*;
import java.awt.*;

public class SplitPanelDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);

        f.setLayout(null);

        JPanel pLeft = new JPanel();
        pLeft.setBounds(50, 50, 300, 60);

        pLeft.setBackground(Color.RED);

        pLeft.setLayout(new FlowLayout());

        JButton b1 = new JButton("盖伦");
        JButton b2 = new JButton("提莫");
        JButton b3 = new JButton("安妮");

        pLeft.add(b1);
        pLeft.add(b2);
        pLeft.add(b3);

        JPanel pRight = new JPanel();
        JButton b4 = new JButton("英雄4");
        JButton b5 = new JButton("英雄5");
        JButton b6 = new JButton("英雄6");

        pRight.add(b4);
        pRight.add(b5);
        pRight.add(b6);

        pRight.setBackground(Color.BLUE);
        pRight.setBounds(10, 150, 300, 60);

        // 创建一个水平JSplitPane，左边是p1,右边是p2
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pLeft, pRight);
//        JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pLeft, pRight);
        // 设置分割条的位置
        sp.setDividerLocation(80);


        //JFrame上有一层面板，叫做ContentPane
        //平时通过f.add()向JFrame增加组件，其实是向JFrame上的 ContentPane加东西
        // 把sp当作ContentPane
        f.setContentPane(sp);
        //窗口大小不可变
        f.setResizable(false);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
