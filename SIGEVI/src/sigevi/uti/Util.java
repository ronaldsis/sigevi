package sigevi.uti;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import jxl.*;
import jxl.write.*;

public class Util {

    public void exportarData(JTable table, File file) {

        try {

            WritableWorkbook workbook1 = Workbook.createWorkbook(file);
            WritableSheet sheet1 = workbook1.createSheet("First Sheet", 0);
            TableModel model = table.getModel();

            for (int i = 0; i < model.getColumnCount(); i++) {
                Label column = new Label(i, 0, model.getColumnName(i));
                sheet1.addCell(column);
            }
            int j = 0;
            for (int i = 0; i < model.getRowCount(); i++) {
                for (j = 0; j < model.getColumnCount(); j++) {
                    Label row = new Label(j, i + 1,
                            model.getValueAt(i, j).toString());
                    sheet1.addCell(row);
                }
            }
            workbook1.write();
            workbook1.close();
        } catch (IOException | WriteException ex) {
            ex.printStackTrace();
        }
    }

    public String getFecha() {
        Calendar c = new GregorianCalendar();
        String min, hora, dia, mes, annio;
        min = Integer.toString(c.get(Calendar.MINUTE));
        hora = Integer.toString(c.get(Calendar.HOUR));
        dia = Integer.toString(c.get(Calendar.DATE));
        mes = Integer.toString(c.get(Calendar.MONTH));
        annio = Integer.toString(c.get(Calendar.YEAR));
        return hora+min+dia + mes + annio;
    }

    public String autoComplete(String cadena, List<String> data) {
            String hit = null;
            for (String o : data) {
                if (o.startsWith(cadena)) {
                    if (hit == null) {
                        hit = o;
                    } else {
                        hit = null;
                        break;
                    }
                }
            }
            return hit;
        }
}
