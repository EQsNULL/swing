import javax.swing.*;
import java.awt.*;

public class 基本表格 {
    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
        f.setResizable(false);

        // 表格上的title
        String[] columnNames = new String[]{"id", "name", "hp", "damage"};
        // 表格中的内容，是一个二维数组
        String[][] heros = new String[][]{{"1", "盖伦", "616", "100"},
                {"2", "提莫", "512", "102"}, {"3", "奎因", "832", "200"}};
        JTable t = new JTable(heros, columnNames);
        // 根据t创建 JScrollPane
        JScrollPane sp = new JScrollPane(t);

        // 把sp而非JTable加入到JFrame上，
        f.add(sp, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置列宽度
        t.getColumnModel().getColumn(0).setPreferredWidth(200);

        f.setVisible(true);
    }
}
