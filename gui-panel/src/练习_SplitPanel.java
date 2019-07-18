import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class 练习_SplitPanel {
    public static void main(String[] args) {
        //设置皮肤
        setLookAndFeel();
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);

        f.setLayout(null);

        JPanel pLeft = new JPanel();
        pLeft.setBounds(50, 50, 300, 60);

        pLeft.setBackground(Color.LIGHT_GRAY);

        pLeft.setLayout(new FlowLayout());

        JButton b1 = new JButton("盖伦");
        JButton b2 = new JButton("提莫");
        JButton b3 = new JButton("安妮");

        pLeft.add(b1);
        pLeft.add(b2);
        pLeft.add(b3);

        JPanel pRight = new JPanel();
        JLabel lPic = new JLabel("");

        ImageIcon i = new ImageIcon("gui-panel\\src\\imgs\\gareen.jpg");
        lPic.setIcon(i);

        pRight.add(lPic);

        pRight.setBackground(Color.lightGray);
        pRight.setBounds(10, 150, 300, 60);

        // 创建一个水平JSplitPane，左边是p1,右边是p2
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pLeft, pRight);
        // 设置分割条的位置
        sp.setDividerLocation(80);

        // 把sp当作ContentPane
        f.setContentPane(sp);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);

        switchPic(b1, "gareen", lPic);
        switchPic(b2, "teemo", lPic);
        switchPic(b3, "annie", lPic);
    }

    private static void setLookAndFeel() {
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
            // handle exception
        }

    }

    private static void switchPic(JButton b1, String fileName, JLabel lPic) {
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon i = new ImageIcon("gui-panel\\src\\imgs\\" + fileName + ".jpg");
                lPic.setIcon(i);
            }
        });
    }
}
