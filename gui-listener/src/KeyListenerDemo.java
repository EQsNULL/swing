import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerDemo {

    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);

        final JLabel l = new JLabel();

        ImageIcon i = new ImageIcon("gui-listener/resources/shana.png");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

        // 增加键盘监听
        f.addKeyListener(new KeyListener() {

            // 键被弹起
            public void keyReleased(KeyEvent e) {

                //步长
                int step = 10;
                if (e.getKeyCode() == 38) {
                    // 图片向上移动 （x坐标不变，y坐标减少）
                    l.setLocation(l.getX() , l.getY()- step);
                }
                if (e.getKeyCode() == 40) {
                    // 图片向下移动 （x坐标不变，y坐标增加）
                    l.setLocation(l.getX() , l.getY()+ step);
                }
                if (e.getKeyCode() == 37) {
                    // 图片向左移动 （y坐标不变，x坐标减少）
                    l.setLocation(l.getX() - step, l.getY());
                }
                if (e.getKeyCode() == 39) {
                    // 图片向右移动 （y坐标不变，x坐标增加）
                    l.setLocation(l.getX() + step, l.getY());
                }

            }

            //键被按下
            public void keyPressed(KeyEvent e) {

            }

            // 一个按下弹起的组合动作
            public void keyTyped(KeyEvent e) {

            }
        });

        f.add(l);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
