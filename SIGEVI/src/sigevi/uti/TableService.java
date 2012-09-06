package sigevi.uti;

import javax.swing.table.AbstractTableModel;

public class TableService extends AbstractTableModel{

    private String[] columnNames;
    private Object[][] data;

    public TableService(String[] columnNames, Object[][] data) {
        this.columnNames = columnNames;
        this.data = data;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return data != null ? data.length : 0;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        Class clazz = Object.class;
        Object aux = getValueAt(0, columnIndex);
        if (aux != null) {
            clazz = aux.getClass();
        }
        return clazz;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void reset(int row) {

        for (int i = 0; i < data[row].length - 1; i++) {
            if (getColumnClass(i) == String.class) {
                setValueAt("", row, i);
            } else if (getColumnClass(i) == Boolean.class) {
                setValueAt(false, row, i);
            }
        }
    }
}
