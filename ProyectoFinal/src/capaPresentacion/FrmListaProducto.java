package capaPresentacion;

import CAPA.JAVA.BEAN.Producto;
import CAPA.JAVA.DAO.ProductoDao;
import java.awt.Color;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class FrmListaProducto  extends JPanel {
    
    ProductoDao bdproducto = new ProductoDao();
    JTable tabla;
    JScrollPane barra1;
    DefaultTableModel Modelo;
    String[] columnas = {"CODIGO", "NOMBRE", "PRECIO", "STOCK", "CATEGORIA", "URL IMAGEN"};
    String[][] datos = {};
     

  
    public FrmListaProducto() {
        
        setSize(900, 900);
        add(new imagenfondo());
       // setBackground(new Color(0, 255, 0));
        tabla = new JTable();
        Modelo = new DefaultTableModel(datos, columnas);
        barra1 = new JScrollPane();
        barra1.setViewportView(tabla);
        tabla.setModel(Modelo);
        barra1.setBounds(50, 50, 750, 400);
        add(barra1);
      
        mostrarDatosTable();
        
    }
   private void mostrarDatosTable() {
        Modelo = new DefaultTableModel(datos, columnas);
        tabla.setModel(Modelo);
        for (int i = 0; i < bdproducto.numeroProductos(); i++) {
            Producto dat = bdproducto.obtenerProducto(i);
            Object[] fila = {dat.getCodigo(), dat.getNombre(), dat.getPrecio(), dat.getStock(), dat.getCategoria(),dat.getImagen()};
            Modelo.addRow(fila);
        }
    }

    
}
