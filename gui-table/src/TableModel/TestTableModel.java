package TableModel;

import javax.swing.*;
import java.awt.*;

public class TestTableModel {
    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());

        //创建一个TableModel
        TableModelDemo htm = new TableModelDemo();

        //根据 TableModel来创建 Table
        JTable t = new JTable(htm);

        JScrollPane sp = new JScrollPane(t);

        f.add(sp, BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
