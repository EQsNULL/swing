package TableModel;

import javax.swing.table.AbstractTableModel;

public class TableModelDemo extends AbstractTableModel {
    String[] columnNames = new String[]{"id", "name", "hp", "damage"};
    String[][] heros = new String[][]{{"1", "盖伦", "616", "100"},
            {"2", "提莫", "512", "102"}, {"3", "奎因", "832", "200"}};

    @Override
    public int getRowCount() {
        return heros.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return heros[rowIndex][columnIndex];
    }

    // 单元格是否可以修改
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    // 获取每一列的名称
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}
