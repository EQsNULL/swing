package TableModel与DAO结合;


import TableModel与DAO结合.dao.HeroDAO;
import TableModel与DAO结合.pojo.Hero;

import javax.swing.*;
import java.awt.*;

public class TestTableModelDao {
    public static void main(String[] args) {
        //先添加数据
//        for (int i = 0; i < 100; i++) {
//            HeroDAO.add(new Hero("猎魔人" + i + "号"));
//        }


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
        //mybatis SqlSession提交并关闭
        HeroDAO.commitAndClose();
    }
}
