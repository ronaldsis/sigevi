package capaPresentacion;

import CAPA.JAVA.BEAN.Compra;
import CAPA.JAVA.BEAN.DetalleCompra;
import CAPA.JAVA.BEAN.Producto;
import CAPA.JAVA.BEAN.Proveedor;
import CAPA.JAVA.DAO.CompraDao;
import CAPA.JAVA.DAO.DetalleCompraDao;
import CAPA.JAVA.DAO.ProductoDao;
import CAPA.JAVA.DAO.ProveedorDao;
import CAPA.JAVA.UTIL.metodos;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class FrmCompra extends JPanel implements ActionListener {

    JLabel lblformPago, ruc, lblcompra, lblncompra, lblfecha,
            lbltipocomp, proveedor, lblcomprobante, lblAgregarPro,
            precio, stock, cantidad, detallecom, subtot, igv, tot;
    JTextField txtcodPro, txtcategoria, txtncompra, txtruc, txtfecha,
            txtcomprobante, txtprecio, txtstck, txtcantidad, txtsubtotal,
            txtigv, txttotal;
    JComboBox combotipocomprobante, comboproveedor, comboProducto, comboformapago;
    JButton AgregarPro, Registrar, Eliminar;
    JTable tabla;
    JScrollPane barra;
    JPanel imagenProducto;
    DefaultTableModel modelo;
    String[] Titulo = {"CODIGO","NUMCOMPRA","ITEM","CODPROD", "PRODUCTO","CANTIDAD", "PRECIO", "SUB TOTAL"};
    String[][] datos = {};
    int i = 1;
    metodos m = new metodos() {
    };
    String ImagenURL;

    CompraDao bdcompra = new CompraDao();
    ProveedorDao bdproveedor = new ProveedorDao();
    ProductoDao bdproducto = new ProductoDao();
    DetalleCompraDao bddetallecompra = new DetalleCompraDao();

    public FrmCompra() {

        setSize(900, 600);
        setVisible(true);
        setLayout(null);

        Border thinBorder = LineBorder.createBlackLineBorder();
        lblcompra = new JLabel();
        lblcompra.setText("                                                                       R E G I S T R O  D E  C O M P R A S");
        lblcompra.setFont(new java.awt.Font("Tahoma", 1, 14));
        lblcompra.setBounds(5, 5, 885, 30);
        lblcompra.setBorder(thinBorder);
        add(lblcompra);

        lblncompra = new JLabel("N°Compra");
        lblncompra.setBounds(10, 40, 100, 30);
        add(lblncompra);

        imagenProducto = new JPanel();
        imagenProducto.setBounds(350, 100, 1, 1);
        add(imagenProducto);

        txtncompra = new JTextField();
        txtncompra.setBounds(80, 40, 100, 30);
        add(txtncompra);
        txtncompra.setEnabled(false);
        txtncompra.setText(bdcompra.nuevoCodigo() + "");

        lblfecha = new JLabel("Fecha");
        lblfecha.setBounds(200, 40, 100, 30);
        add(lblfecha);

        txtfecha = new JTextField(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        txtfecha.setBounds(250, 40, 100, 30);
        add(txtfecha);
        txtfecha.setEnabled(false);

        lbltipocomp = new JLabel("Tipo Comprobante ");
        lbltipocomp.setBounds(380, 40, 120, 30);
        add(lbltipocomp);

        combotipocomprobante = new JComboBox();
        combotipocomprobante.setBounds(500, 40, 100, 30);
        add(combotipocomprobante);
        combotipocomprobante.addItem("seleccione");
        combotipocomprobante.addItem("Boleta");
        combotipocomprobante.addItem("Factura");

        lblformPago = new JLabel("Forma de Pago");
        lblformPago.setBounds(620, 40, 120, 30);
        add(lblformPago);

        comboformapago = new JComboBox();
        comboformapago.setBounds(740, 40, 100, 30);
        add(comboformapago);
        comboformapago.addItem("seleccione");
        comboformapago.addItem("Credito");
        comboformapago.addItem("Contado");

        proveedor = new JLabel("Proveedor");
        proveedor.setBounds(10, 100, 100, 30);
        add(proveedor);

        comboproveedor = new JComboBox();
        comboproveedor.setBounds(80, 100, 200, 30);
        add(comboproveedor);
        comboproveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccione"}));
        comboproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboproveedor(evt);
            }
        });

        lblcomprobante = new JLabel("Comprobante");
        lblcomprobante.setBounds(300, 100, 100, 30);
        add(lblcomprobante);

        txtcomprobante = new JTextField();
        txtcomprobante.setBounds(400, 100, 100, 30);
        add(txtcomprobante);

        ruc = new JLabel("RUC");
        ruc.setBounds(530, 100, 100, 30);
        add(ruc);

        txtruc = new JTextField();
        txtruc.setBounds(560, 100, 150, 30);
        add(txtruc);
        txtruc.setEnabled(false);

        lblAgregarPro = new JLabel("                                                                       A G R E G A R    P R O D U C T O S ");
        lblAgregarPro.setFont(new java.awt.Font("Tahoma", 1, 14));
        lblAgregarPro.setBounds(5, 160, 885, 30);
        lblAgregarPro.setBorder(thinBorder);
        add(lblAgregarPro);

        txtcategoria = new JTextField();
        txtcategoria.setBounds(10, 200, 150, 30);
        add(txtcategoria);
        txtcategoria.setEnabled(false);

        txtcodPro = new JTextField();
        txtcodPro.setBounds(10, 260, 150, 30);
        add(txtcodPro);
        txtcodPro.setEnabled(false);

        comboProducto = new JComboBox();
        comboProducto.setBounds(170, 200, 150, 30);
        add(comboProducto);
        comboProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccione producto"}));
        comboProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProducto(evt);
            }
        });

        precio = new JLabel("Precio");
        precio.setBounds(330, 200, 100, 30);
        add(precio);

        txtprecio = new JTextField();
        txtprecio.setBounds(410, 200, 100, 30);
        add(txtprecio);
        txtprecio.setEnabled(false);

        stock = new JLabel("Stock");
        stock.setBounds(520, 200, 100, 30);
        add(stock);

        txtstck = new JTextField();
        txtstck.setBounds(600, 200, 100, 30);
        add(txtstck);
        txtstck.setEnabled(false);

        cantidad = new JLabel("Cantidad");
        cantidad.setBounds(330, 260, 100, 30);
        add(cantidad);

        txtcantidad = new JTextField();
        txtcantidad.setBounds(410, 260, 100, 30);
        add(txtcantidad);

        AgregarPro = new JButton("Agregar");
        AgregarPro.setBounds(520, 260, 150, 30);
        add(AgregarPro);
        AgregarPro.addActionListener(this);

        lblcompra = new JLabel();
        lblcompra.setText("                                                                       D E T A L L E   D E  C O M P R A ");
        lblcompra.setFont(new java.awt.Font("Tahoma", 1, 14));
        lblcompra.setBounds(5, 300, 885, 30);
        lblcompra.setBorder(thinBorder);
        add(lblcompra);

        tabla = new JTable();
        barra = new JScrollPane();
        modelo = new DefaultTableModel(datos, Titulo);
        tabla.setModel(modelo);
        barra.setViewportView(tabla);
        barra.setBounds(10, 340, 880, 110);
        add(barra);
        int i = 0;

        Registrar = new JButton("Registrar Compra");
        Registrar.setBounds(10, 500, 200, 30);
        add(Registrar);
        Registrar.addActionListener(this);

        Eliminar = new JButton("Eliminar Producto");
        Eliminar.setBounds(10, 460, 200, 30);
        add(Eliminar);
        Eliminar.addActionListener(this);

        subtot = new JLabel("Sub Total");
        subtot.setBounds(620, 460, 100, 25);
        add(subtot);

        txtsubtotal = new JTextField();
        txtsubtotal.setBounds(720, 460, 100, 25);
        add(txtsubtotal);
        txtsubtotal.setEnabled(false);

        igv = new JLabel("IGV");
        igv.setBounds(620, 490, 100, 25);
        add(igv);

        txtigv = new JTextField();
        txtigv.setBounds(720, 490, 100, 25);
        add(txtigv);
        txtigv.setEnabled(false);

        tot = new JLabel("Total");
        tot.setBounds(620, 520, 100, 25);
        add(tot);

        txttotal = new JTextField();
        txttotal.setBounds(720, 520, 100, 25);
        add(txttotal);
        txttotal.setEnabled(false);

        cargarProveedores();
        cargarProducto();
    }

    private void comboproveedor(ActionEvent evt) {
        if (comboproveedor.getSelectedIndex() > 0) {
            txtruc.setText("" + bdproveedor.obtenerProveedor(comboproveedor.getSelectedIndex() - 1).getRUC());
        }
    }

    private void cargarProveedores() {
        for (int j = 0; j < bdproveedor.numeroProveedores(); j++) {
            Proveedor dat = bdproveedor.obtenerProveedor(j);
            comboproveedor.addItem(dat.getRaSocial());
        }
    }

    private void comboProducto(ActionEvent evt) {
        if (comboProducto.getSelectedIndex() > 0) {
            Producto dat = bdproducto.obtenerProducto(comboProducto.getSelectedIndex() - 1);
            txtcodPro.setText("" + dat.getCodigo());
            txtcategoria.setText("" + dat.getCategoria());
            txtprecio.setText("" + dat.getPrecio());
            txtstck.setText("" + dat.getStock());
        }
    }

    private void cargarProducto() {
        for (int i = 0; i < bdproducto.numeroProductos(); i++) {
            Producto dat = bdproducto.obtenerProducto(i);
            comboProducto.addItem(dat.getNombre());
        }
    }

    public void MostrarTabla() {
        modelo = new DefaultTableModel(datos, Titulo);
        tabla.setModel(modelo);
        for (int j = 0; j < bddetallecompra.numeroDetalleCompras(); j++) {
            DetalleCompra dat = bddetallecompra.obtenerDetalleCompra(j);
            if (dat.getNumCompra() == Integer.parseInt(txtncompra.getText())) {
                String nomProducto = bdproducto.buscarProducto(dat.getCodPro()).getNombre();
                Object[] fila = {dat.getCodigo(),dat.getNumCompra(),dat.getItem(), dat.getCodPro(),nomProducto, dat.getCan(),dat.getPrecio(), dat.getSubTot()};
                modelo.addRow(fila);
            }
        }
    }

    //agrega datos del producto en la tabla
    public void AgregarPro() {
        if (txtcantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(AgregarPro, "Escriba la cantidad de productos");
        } else {
            int numcompra = Integer.parseInt(txtncompra.getText());
            int codpro = Integer.parseInt(txtcodPro.getText());
            double prec = Double.parseDouble(txtprecio.getText());
            int cant = Integer.parseInt(txtcantidad.getText());
            // int stoc = Integer.parseInt(txtstck.getText());
            double subtotal = prec * cant;
            int codigo = numcompra * 10 + i;

            bddetallecompra.adicionarDetalleCompra(new DetalleCompra(codigo, numcompra, i, codpro, cant, prec, subtotal));
            JOptionPane.showMessageDialog(AgregarPro, "Item agregado correctamente ");
            MostrarTabla();
            i++;
            calcular();

        }
    }

    public void calcular() {
        double total = 0;
        double ttotal = 0;
        double IGV;

        for (int i = 0; i < bddetallecompra.numeroDetalleCompras(); i++) {
            DetalleCompra dat = bddetallecompra.obtenerDetalleCompra(i);
            if (dat.getNumCompra() == Integer.parseInt(txtncompra.getText())) {
                total = total + dat.getSubTot();
            }
        }
        ttotal = 1.18 * total;
        IGV = total * 0.18;
        txtsubtotal.setText("" + (total));
        txtigv.setText("" + IGV);
        txttotal.setText("" + ttotal);
        txtcantidad.setText("");
    }

    public void registrar() {
        if (txtruc.getText().equals("") || txtcomprobante.getText().equals("")) {
            JOptionPane.showMessageDialog(Registrar, "CAMPOS VACÍOS");
        } else {
            CompraDao objEDAO = new CompraDao();
            Compra obj = new Compra();
            DetalleCompraDao objEDAO2 = new DetalleCompraDao();

            int numcom = Integer.parseInt(txtncompra.getText());
            String fecha = txtfecha.getText();
            String tcomprobante = (String) combotipocomprobante.getSelectedItem();
            String fpago = (String) comboformapago.getSelectedItem();
            int ncomprobante = Integer.parseInt(txtcomprobante.getText());
            String proveed = txtruc.getText();
            double tcompra = Double.parseDouble(txttotal.getText());

            obj.setNumero(numcom);
            obj.setFecha(fecha);
            obj.setTcomprobante(tcomprobante);
            obj.setFpago(fpago);
            obj.setNcomprobante(ncomprobante);
            obj.setProveedor(proveed);
            obj.setTcompra(tcompra);

            int estado = objEDAO.guardar(obj);//AGREGA A LA BASE DE DATOS
            
            for (int i = 0; i < modelo.getRowCount(); i++) {
                DetalleCompra obj2 = new DetalleCompra();
                //Aqui creamos variables simples para almacenarlo de los que nos llega de la tabla 
                int a = Integer.parseInt((String)tabla.getValueAt(i,0).toString()); 
                int b = Integer.parseInt((String)tabla.getValueAt(i,1).toString()); 
                int c =Integer.parseInt((String)tabla.getValueAt(i,2).toString()); 
                int d = Integer.parseInt((String)tabla.getValueAt(i,3).toString()); 
                int e = Integer.parseInt((String)tabla.getValueAt(i,5).toString()); 
                double f = Double.parseDouble((String)tabla.getValueAt(i,6).toString()); 
                double g = Double.parseDouble((String)tabla.getValueAt(i,7).toString());
                obj2.setCodigo(a);
                obj2.setNumCompra(b);
                obj2.setItem(c);
                obj2.setCodPro(d);
                obj2.setCan(e);
                obj2.setPrecio(f);
                obj2.setSubTot(g);

                int estado2 = objEDAO2.guardar(obj2);//AGREGA A LA BASE DE DATOS
            }

            if (ncomprobante == 0) {
                JOptionPane.showMessageDialog(AgregarPro, "El campo debe ser mayor a 0");
            } else {
                bdcompra.adicionarCompra(new Compra(numcom, proveed, fecha, tcomprobante, fpago, ncomprobante, tcompra));//AGREGA AL ARRAYLIST
                if (estado == 1) {
                    JOptionPane.showMessageDialog(null, "Compra registrada");
                } else {
                    JOptionPane.showMessageDialog(null, "No se registro compra!!!!");
                }
                actualizarStock();
                MostrarTabla();
                limpiarTextos();
            }
        }

    }

    private void limpiarTextos() {
        txtncompra.setText("");
        txtcantidad.setText("");
        txtigv.setText("");
        txtsubtotal.setText("");
        txtcomprobante.setText("");
        txtprecio.setText("");
        txtruc.setText("");
        txtstck.setText("");
        txttotal.setText("");
        txtcodPro.setText("");
        txtcategoria.setText("");
        comboProducto.setSelectedIndex(0);
        comboformapago.setSelectedIndex(0);
        combotipocomprobante.setSelectedIndex(0);
        comboproveedor.setSelectedIndex(0);
        tabla.setModel(new DefaultTableModel());
        txtncompra.setText("" + bdcompra.nuevoCodigo());
    }

    private void Eliminar() {
        modelo.removeRow(tabla.getSelectedRow());
        int ultimo = bddetallecompra.numeroDetalleCompras() - 1;
        DetalleCompra dat = bddetallecompra.obtenerDetalleCompra(ultimo);
        if (dat.getNumCompra() == Integer.parseInt(txtncompra.getText())) {
            bddetallecompra.eliminarDetalleCompra(dat);
        }
    }

    private void actualizarStock() {
        for (int i = 0; i < bddetallecompra.numeroDetalleCompras(); i++) {
            int r = 0;
            DetalleCompra dat = bddetallecompra.obtenerDetalleCompra(i);
            if (dat.getNumCompra() == Integer.parseInt(txtncompra.getText())) {
                int cod = bdproducto.buscarProducto(dat.getCodPro()).getCodigo();
                int sto = bdproducto.buscarProducto(dat.getCodPro()).getStock();
                int can = dat.getCan();
                int nuevoStock = sto + can;
                bdproducto.actualizarStock(dat.getCodPro(), nuevoStock);
                ProductoDao obj_dao = new ProductoDao();
                r = obj_dao.ModificarDatoStock(cod, nuevoStock);

            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AgregarPro) {
            AgregarPro();
        }
        if (e.getSource() == Registrar) {
            registrar();
        }
        if (e.getSource() == Eliminar) {
            Eliminar();
        }
    }

}
