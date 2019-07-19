import javax.swing.*;

public class 初始化线程 {
    public static void main(String[] args) {
//        new TestFrame().setVisible(true);

      SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              new TestFrame().setVisible(true);
          }
      });
    }

    static class TestFrame extends JFrame {
        public TestFrame() {
            setTitle("LoL");

            setSize(400, 300);

            setLocation(200, 200);

            setLayout(null);

            JButton b = new JButton("一键秒对方基地挂");

            b.setBounds(50, 50, 280, 30);

            add(b);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            System.out.println("当前线程是否是 事件调度线程: " + SwingUtilities.isEventDispatchThread());

        }
    }
}
