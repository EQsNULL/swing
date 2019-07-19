import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class 事件调度线程 {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);

        final JLabel l = new JLabel();

        ImageIcon i = new ImageIcon("gui-panel/src/imgs/annie.jpg");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

        JButton b = new JButton("隐藏图片");
        b.setBounds(150, 200, 100, 30);

        b.addActionListener(new ActionListener() {
            boolean hide = false;
            public void actionPerformed(ActionEvent e) {
                b.setText(hide?"显示图片":"隐藏图片");
                l.setVisible(hide);
                hide = !hide;

                System.out.println("当前使用的是事件调度线程：" + SwingUtilities.isEventDispatchThread());
            }
        });

        f.add(l);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
