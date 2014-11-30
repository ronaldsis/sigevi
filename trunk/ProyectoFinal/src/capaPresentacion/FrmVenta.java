package capaPresentacion;

import CAPA.JAVA.BEAN.Producto;
import CAPA.JAVA.DAO.DetalleVentaDao;
import CAPA.JAVA.DAO.ProductoDao;
import CAPA.JAVA.DAO.VentaDao;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import CAPA.JAVA.BEAN.DetalleVenta;

public class FrmVenta extends JPanel implements ActionListener {

    JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lbl10;
    JTextField NumeroVenta, Fecha, Nombre, DNI, telefono, direccion, pagar, montoe, vuelto;
    JTextField IdProducto, Nombre1, Stock1, PrecioUn1, Cantidad1, Total1;
    JButton Eliminar, Vender, Adicionar;
    JComboBox combo1;
    JTable tabla, tabla1;
    JScrollPane barra;
    DefaultTableModel modelo, modelo1;
    String[] Titulo = {"CODIGO", "NOMBRE", "PRECIO", "STOCK", "CATEGORIA"};
    String[][] datos = {};
    String[] Titulo2 = {"ITEM", "PRODUCTO", "PRECIO", "CANTIDAD", "SUB TOTAL"};
    String[][] datos2 = {};
    int i = 1;

    ProductoDao bdproducto = new ProductoDao();
    VentaDao bdventa = new VentaDao();
    DetalleVentaDao bddetalleventa = new DetalleVentaDao();

    public FrmVenta() {
        setVisible(true);
        setLayout(null);
        setSize(900, 600);

        tabla = new JTable();
        barra = new JScrollPane();
        modelo = new DefaultTableModel(datos, Titulo);
        tabla.setModel(modelo);
        barra.setViewportView(tabla);
        barra.setBounds(10, 10, 330, 120);
        add(barra);
        mostrarDatosTable();

        Adicionar = new JButton("Adicionar");
        Adicionar.setBounds(10, 130, 330, 35);
        add(Adicionar);

        lbl1 = new JLabel("Id Producto");
        lbl1.setBounds(20, 200, 100, 30);
        add(lbl1);

        IdProducto = new JTextField();
        IdProducto.setBounds(100, 200, 140, 30);
        add(IdProducto);

        lbl2 = new JLabel("Nombre");
        lbl2.setBounds(20, 240, 100, 30);
        add(lbl2);

        Nombre1 = new JTextField();
        Nombre1.setBounds(100, 240, 140, 30);
        add(Nombre1);

        lbl3 = new JLabel("Stock");
        lbl3.setBounds(20, 280, 100, 30);
        add(lbl3);

        Stock1 = new JTextField();
        Stock1.setBounds(100, 280, 140, 30);
        add(Stock1);

        lbl4 = new JLabel("Precio U.");
        lbl4.setBounds(20, 320, 100, 30);
        add(lbl4);

        PrecioUn1 = new JTextField();
        PrecioUn1.setBounds(100, 320, 140, 30);
        add(PrecioUn1);

        lbl5 = new JLabel("Cantidad");
        lbl5.setBounds(20, 360, 100, 30);
        add(lbl5);

        Cantidad1 = new JTextField();
        Cantidad1.setBounds(100, 360, 140, 30);
        add(Cantidad1);

        lbl6 = new JLabel("Total");
        lbl6.setBounds(20, 400, 100, 30);
        add(lbl6);

        Total1 = new JTextField();
        Total1.setBounds(100, 400, 140, 30);
        add(Total1);

        lbl1 = new JLabel("N° de Venta");
        lbl1.setBounds(380, 10, 150, 30);
        add(lbl1);

        NumeroVenta = new JTextField();
        NumeroVenta.setBounds(470, 10, 120, 30);
        add(NumeroVenta);

        lbl2 = new JLabel("Fecha");
        lbl2.setBounds(620, 10, 100, 30);
        add(lbl2);

        Fecha = new JTextField(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        Fecha.setBounds(690, 10, 120, 30);
        add(Fecha);
        Fecha.setEnabled(false);

        lbl3 = new JLabel("Tipo Comprobante");
        lbl3.setBounds(380, 70, 250, 30);
        add(lbl3);

        combo1 = new JComboBox();
        combo1.setBounds(500, 70, 180, 30);
        add(combo1);
        combo1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Boleta", "Factura"}));
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1(evt);
            }
        });

        lbl3 = new JLabel("_______________________________________________________________________");
        lbl3.setBounds(380, 90, 600, 30);
        add(lbl3);

        lbl4 = new JLabel("Nombre");
        lbl4.setBounds(380, 150, 100, 30);
        add(lbl4);

        Nombre = new JTextField();
        Nombre.setBounds(455, 150, 325, 30);
        add(Nombre);

        lbl5 = new JLabel("DNI");
        lbl5.setBounds(380, 190, 60, 30);
        add(lbl5);

        DNI = new JTextField();
        DNI.setBounds(455, 190, 95, 30);
        add(DNI);

        lbl6 = new JLabel("Telefono");
        lbl6.setBounds(570, 190, 100, 30);
        add(lbl6);

        telefono = new JTextField();
        telefono.setBounds(630, 190, 150, 30);
        add(telefono);

        lbl7 = new JLabel("Direccion");
        lbl7.setBounds(380, 230, 100, 30);
        add(lbl7);

        direccion = new JTextField();
        direccion.setBounds(455, 230, 325, 30);
        add(direccion);

        tabla1 = new JTable();
        barra = new JScrollPane();
        modelo1 = new DefaultTableModel(datos2, Titulo2);
        tabla1.setModel(modelo1);
        barra.setViewportView(tabla1);
        barra.setBounds(380, 280, 500, 100);
        add(barra);

        Eliminar = new JButton("ELIMINAR");
        Eliminar.setBounds(390, 400, 100, 30);
        add(Eliminar);
        Eliminar.addActionListener(this);

        Vender = new JButton("VENDER");
        Vender.setBounds(510, 400, 100, 30);
        add(Vender);
        Vender.addActionListener(this);

        lbl8 = new JLabel(" Total a pagar");
        lbl8.setBounds(630, 400, 130, 30);
        add(lbl8);

        pagar = new JTextField();
        pagar.setBounds(750, 400, 100, 30);
        add(pagar);
        pagar.setEnabled(false);

        lbl9 = new JLabel("Monto Entregado");
        lbl9.setBounds(630, 440, 130, 30);
        add(lbl9);

        montoe = new JTextField();
        montoe.setBounds(750, 440, 100, 30);
        add(montoe);

        lbl10 = new JLabel("Vuelto");
        lbl10.setBounds(630, 480, 130, 30);
        add(lbl10);

        vuelto = new JTextField();
        vuelto.setBounds(750, 480, 100, 30);
        add(vuelto);
        vuelto.setEnabled(false);

    }

    private void mostrarDatosTable() {
        modelo = new DefaultTableModel(datos, Titulo);
        tabla.setModel(modelo);
        for (int i = 0; i < bdproducto.numeroProductos(); i++) {
            Producto dat = bdproducto.obtenerProducto(i);
            Object[] fila = {dat.getCodigo(), dat.getNombre(), dat.getPrecio(), dat.getStock(), dat.getCategoria()};
            modelo.addRow(fila);
        }
    }

    private void combo1(ActionEvent evt) {

        if (combo1.getSelectedIndex() == 1) {
            lbl4.setText("Razon Social");
            lbl5.setText("RUC");
        } else {
            lbl4.setText("Nombre");
            lbl5.setText("DNI");
        }
    }

    private void mostrarItemTable() {
        modelo1 = new DefaultTableModel(datos2, Titulo2);
        tabla1.setModel(modelo1);
        for (int k = 0; k < bddetalleventa.numeroDetalleVentas(); k++) {
            DetalleVenta dat = bddetalleventa.obtenerDetalleVenta(k);
            if (dat.getNumVenta() == Integer.parseInt(NumeroVenta.getText())) {
                String nomProducto = bdproducto.buscarProducto(dat.getCodPro()).getNombre();
                Object[] fila = {dat.getItem(), nomProducto, dat.getPrecio(), dat.getCan(), dat.getSubTot()};
                modelo1.addRow(fila);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
