/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacion;

import javax.swing.JPanel;

import CAPA.JAVA.BEAN.Proveedor;
import CAPA.JAVA.DAO.ProveedorDao;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmListaProveedor  extends JPanel {
    
    ProveedorDao bdproveedor = new ProveedorDao();
    JTable tabla;
    JScrollPane barra1;
    DefaultTableModel Modelo;
    String[] columnas = {"RUC", "RAZON SOCIAL", "DIRECCION", "TELEFONO", "CONTACTO", "EMAIL"};
    String[][] datos = {};
     

  
    public FrmListaProveedor() {
        
        setSize(900, 900);
        setBackground(new Color(0, 255, 0));

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
        for (int i = 0; i < bdproveedor.numeroProveedor(); i++) {
            Proveedor dat = bdproveedor.obtenerProveedor(i);
            Object[] fila = {dat.getRUC(), dat.getRaSocial(), dat.getDireccion(), dat.getTelefono(), dat.getContacto(), dat.getEmail()};
            Modelo.addRow(fila);
        }
    }

    
}