package sigevi.uti;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ButtonService extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

    private Component currentValue;

    @Override
    public Component getTableCellEditorComponent(final JTable table, Object value, boolean isSelected, final int row, int column) {
        JButton button = null;
        if (value instanceof JButton) {
            button = (JButton) value;
            button.setAction(new AbstractAction("Reset") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((TableService) table.getModel()).reset(row);
                }
            });
        }
        currentValue = button;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return currentValue;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        if (value instanceof JButton) {
            return (JButton) value;
        }
        return null;
    }
}