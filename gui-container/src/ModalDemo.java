import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModalDemo {
    public static void main(String[] args) {
        //普通的窗体，带最大和最小化按钮
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
        JButton b = new JButton("打开一个模态窗口");
        b.setBounds(50, 50, 280, 30);

        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JDialog d = new JDialog(f);
                d.setTitle("这是一个模态窗口");
                d.setModal(true);
                d.setSize(200, 150);
                //将模态窗口位置设置在其中心
                d.setLocationRelativeTo(f);

                JButton b = new JButton("锁定大小");
                d.add(b);
                b.addActionListener(new ActionListener() {
                    boolean resizable = false;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        d.setResizable(resizable);
                        resizable = !resizable;
                        b.setText(resizable ? "解锁大小" : "锁定大小");
                    }
                });

                d.setVisible(true);
            }
        });

        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
