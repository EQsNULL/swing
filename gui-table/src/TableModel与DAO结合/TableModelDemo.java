package TableModel与DAO结合;

import TableModel与DAO结合.dao.HeroDAO;
import TableModel与DAO结合.pojo.Hero;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModelDemo extends AbstractTableModel {
    String[] columnNames = new String[] { "id", "name", "hp", "damage" };

    // 使用从DAO返回的List作为TableModel的数据

    public List<Hero> heros = new HeroDAO().list();

    // heros.size返回一共有多少行
    public int getRowCount() {
        // TODO Auto-generated method stub
        return heros.size();
    }

    public int getColumnCount() {
        // TODO Auto-generated method stub
        return columnNames.length;
    }

    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return columnNames[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    // 先通过heros.get(rowIndex)获取行对应的Hero对象
    // 然后根据columnIndex返回对应的属性
    public Object getValueAt(int rowIndex, int columnIndex) {
        Hero h = heros.get(rowIndex);
        if (0 == columnIndex)
            return h.id;
        if (1 == columnIndex)
            return h.name;
        if (2 == columnIndex)
            return h.hp;
        if (3 == columnIndex)
            return h.damage;
        return null;
    }
}
