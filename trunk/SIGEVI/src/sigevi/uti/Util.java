package sigevi.uti;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
import jxl.*;
import jxl.write.*;
import sigevi.gui.FormVenta;

public class Util {

                protected boolean m_undecorated;
                protected javax.swing.JDesktopPane m_desktop;
                
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
    
        public Date setFecha(String strFecha){
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {
            fecha = formatoDelTexto.parse(strFecha);
        } catch (ParseException ex) {
            Logger.getLogger(FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fecha;
    }
        
        public String df(double numero){
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat df = new DecimalFormat("#,###.00",simbolos);
            return (df.format (numero));
        }
}          