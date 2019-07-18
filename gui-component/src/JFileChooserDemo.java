import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class JFileChooserDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("LOL");
        f.setLayout(new FlowLayout());
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileFilter() {

            //此方法表示默认可选的文件类型
            @Override
            public String getDescription() {
                return ".txt";
            }
            //此方法表示浏览窗口中显示什么类型的文件
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".txt");
            }
        });

        JButton bOpen = new JButton("打开文件");

        JButton bSave = new JButton("保存文件");

        f.add(bOpen);
        f.add(bSave);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250, 150);

        //设定gui容器位置，此表示显示在桌面正中
        f.setLocationRelativeTo(null);

        f.setVisible(true);

        bOpen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fc.showOpenDialog(f);
                File file = fc.getSelectedFile();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(f, "计划打开文件:" + file.getAbsolutePath());
                }

            }
        });
        bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fc.showSaveDialog(f);
                File file = fc.getSelectedFile();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(f, "计划保存到文件:" + file.getAbsolutePath());
                }
            }
        });
    }
}
