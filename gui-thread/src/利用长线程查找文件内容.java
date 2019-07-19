import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class 利用长线程查找文件内容 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SearchFrame().setVisible(true));
    }

    static class SearchFrame extends JFrame {
        //5个组件
        JLabel lLocation = new JLabel("查询目录");
        JLabel lSearch = new JLabel("文件内容");

        JTextField tfLocation = new JTextField("e:/project");
        JTextField tfSearch = new JTextField("java");

        JButton bSubmit = new JButton("搜索");

        private void unfreeze() {
            bSubmit.setText("搜索");
            bSubmit.setEnabled(true);
            tfLocation.setEnabled(true);
            tfSearch.setEnabled(true);

        }

        private void freeze() {
            bSubmit.setText("正在搜索");
            bSubmit.setEnabled(false);
            tfLocation.setEnabled(false);
            tfSearch.setEnabled(false);
        }

        //面板初始化
        SearchFrame() {
            int gap = 50;
            this.setLayout(null);

            JPanel pInput = new JPanel();
            JPanel pSubmit = new JPanel();

            pInput.setLayout(new GridLayout(2, 2, gap, gap));
            pInput.add(lLocation);
            pInput.add(tfLocation);
            pInput.add(lSearch);
            pInput.add(tfSearch);

            pSubmit.add(bSubmit);

            pInput.setBounds(50, 20, 200, 100);
            pSubmit.setBounds(0, 130, 300, 150);

            this.add(pInput);
            this.add(pSubmit);

            this.setSize(300, 200);
            //显示在窗口中间
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            bSubmit.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    foundCount = 0;
                    String location = tfLocation.getText();
                    String search = tfSearch.getText();
                    if (0 == location.length()) {
                        JOptionPane.showMessageDialog(SearchFrame.this, "搜索目录不能为空");
                        tfLocation.grabFocus();
                        return;
                    }
                    if (0 == search.length()) {
                        JOptionPane.showMessageDialog(SearchFrame.this, "搜索目录不能为空");
                        tfSearch.grabFocus();
                        return;
                    }

                    File folder = new File(location);
                    if (!folder.exists()) {
                        JOptionPane.showMessageDialog(SearchFrame.this, "搜索目录不存在");
                        tfLocation.grabFocus();
                        return;
                    }
                    if (!folder.isDirectory()) {
                        JOptionPane.showMessageDialog(SearchFrame.this, "搜索目录不是一个文件夹");
                        tfLocation.grabFocus();
                        return;
                    }
                    //使组件交互失效
                    freeze();

                    SwingWorker worker = new SwingWorker() {

                        @Override
                        protected Object doInBackground() throws Exception {
                            //work here

                            search(folder, search);
                            JOptionPane.showMessageDialog(SearchFrame.this, "总共找到满足条件的文件: " + foundCount + " 个");
                            unfreeze();
                            return null;

                        }

                    };

                    worker.execute();
                }
            });

        }
    }

    private static int foundCount = 0;

    public static void search(File file, String search) {
        if (file.isFile()) {
            if (file.getName().toLowerCase().endsWith(".java")) {
                String fileContent = readFileConent(file);
                if (fileContent.contains(search)) {
                    foundCount++;
                }
            }
        }
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (File f : fs) {
                search(f, search);
            }
        }
    }

    public static String readFileConent(File file) {
        try (FileReader fr = new FileReader(file)) {
            char[] all = new char[(int) file.length()];
            fr.read(all);
            return new String(all);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}

