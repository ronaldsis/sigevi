package sigevi.gui;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import sigevi.bea.Categoria;
import sigevi.bea.Compra;
import sigevi.bea.DetalleCompra;
import sigevi.bea.Producto;
import sigevi.bea.Proveedor;
import sigevi.map.SqlMapConfig;
import sigevi.uti.Util;

public class FormCompra extends javax.swing.JInternalFrame {

    protected javax.swing.JDesktopPane m_desktop;
    private Util uti = new Util();
    protected boolean m_undecorated;

    public FormCompra() {
        initComponents();
        setUndecorated(true);
        txtNcompra.setText(getNuevoCodigo() + "");
        listarCategorias();
        listarProveedores();
        autocompletarBox();
    }

    public final void setUndecorated(boolean undecorated) {
        if (m_undecorated != undecorated) {
            m_undecorated = undecorated;
            BasicInternalFrameUI bi = (BasicInternalFrameUI) getUI();
            if (undecorated) {
                putClientProperty("titlePane", bi.getNorthPane());
                putClientProperty("border", getBorder());
                bi.setNorthPane(null);
                setBorder(null);
            } else {
                bi.setNorthPane((JComponent) getClientProperty("titlePane"));
                setBorder((Border) getClientProperty("border"));
                putClientProperty("titlePane", null);
                putClientProperty("border", null);
            }
        }
    }

    private void autocompletarBox() {
        AutoCompleteDecorator.decorate(this.cboCategoriaPro);
        AutoCompleteDecorator.decorate(this.cboProducto);
        AutoCompleteDecorator.decorate(this.cboProveedor);
    }

    private void limpiar() {
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        try {
            txtFecha.setDate((Date) formatter.parse(uti.getFecha()));
        } catch (ParseException ex) {
            Logger.getLogger(FormCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNComprobante.setText("");
        txtRuc.setText("");
        txtSubTotal.setText("");
        txtIgv.setText("");
        txtTotal.setText("");
        cboProveedor.setSelectedIndex(0);
        tblDetalleCompra.setModel(new DefaultTableModel());
        txtNcompra.setText(getNuevoCodigo() + "");
    }

    private void borrar() {
        txtCantidad.setText("");
        txtPrecio.setText("");
        cboCategoriaPro.setSelectedIndex(0);
        cboProducto.setSelectedIndex(0);
    }

    private void agregarCompra() {
        Compra cmp = new Compra();
        int numCop = Integer.parseInt(txtNcompra.getText());
        cmp.setNroCop(numCop);
        cmp.setNroCom(txtNComprobante.getText());
        cmp.setTipCom((String) cboTipoComprobante.getSelectedItem());
        cmp.setFecCom(uti.setFecha(txtFecha.getDate().toString()));
        cmp.setProveedor_codPrv(cboCodPrv.getSelectedIndex());
        cmp.setUsuario_codUsu(FormLogin.getUsuario());


        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {

            sqlMapClient.insert("insertVenta", cmp);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < tblDetalleCompra.getRowCount(); i++) {
            int codPro = Integer.parseInt(tblDetalleCompra.getValueAt(i, 0).toString());
            double precio = Double.parseDouble(tblDetalleCompra.getValueAt(i, 3).toString());
            double cantidad = Double.parseDouble(tblDetalleCompra.getValueAt(i, 4).toString());
            agregarDetalleCompra(numCop, codPro, precio, cantidad);
        }
    }

    private void agregarDetalleCompra(int compra, int producto, double precio, double cantidad) {
        DetalleCompra det = new DetalleCompra();
        det.setNroDet(getNuevoCodigoDetalle());
        det.setCompra_nroCop(compra);
        det.setProducto_codPro(producto);
        det.setPreDet(precio);
        det.setCanDet(cantidad);

        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {

            sqlMapClient.insert("insertDetalleCompra", det);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Proveedor getProveedor(int codigo) {
        Proveedor proveedor = new Proveedor();
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        try {
            obj = sqlMapClient.queryForObject("getProveedor", codigo);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        proveedor = ((Proveedor) obj);
        return proveedor;
    }

    private int getNuevoCodigoDetalle() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        int cod = 0;
        try {
            obj = sqlMapClient.queryForObject("getMaxDetalleCompra");
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (obj != null) {
            cod = ((Integer) obj).intValue();
        }
        return cod + 1;
    }

    private int getNuevoCodigo() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        int cod = 0;
        try {
            obj = sqlMapClient.queryForObject("getMaxCompra");
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (obj != null) {
            cod = ((Integer) obj).intValue();
        }
        return cod + 1;
    }

    private void listarCategorias() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Categoria> categorias = new ArrayList<>();
        try {
            categorias = sqlMapClient.queryForList("listCategoria", null);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormDetalleVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < categorias.size(); i++) {
            Categoria cat = categorias.get(i);
            cboCategoriaPro.addItem(cat.getNomCat());
        }
    }

    private void listarProveedores() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Proveedor> proveedores = new ArrayList<>();
        try {
            proveedores = sqlMapClient.queryForList("listProveedor", null);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < proveedores.size(); i++) {
            Proveedor prv = proveedores.get(i);
            cboCodPrv.addItem(prv.getCodPrv());
            cboProveedor.addItem(prv.getNomPrv());
        }
    }

    private void listarProductosDeCategoria(int codCat) {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Producto> productos = new ArrayList<>();
        try {
            productos = sqlMapClient.queryForList("listProductoXCategoria", codCat);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormDetalleVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < productos.size(); i++) {
            Producto per = productos.get(i);
            cboCodPro.addItem(per.getCodPro());
            cboProducto.addItem(per.getNomPro());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNroCompra = new javax.swing.JLabel();
        txtNcompra = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        lblProveedor = new javax.swing.JLabel();
        cboProveedor = new javax.swing.JComboBox();
        lblRUC = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        lblFormaPago = new javax.swing.JLabel();
        cmbFormaPago = new javax.swing.JComboBox();
        lblTipoComprobante = new javax.swing.JLabel();
        cboTipoComprobante = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleCompra = new javax.swing.JTable();
        cboCategoriaPro = new javax.swing.JComboBox();
        cboProducto = new javax.swing.JComboBox();
        lblCantidad = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        lblSubtotal = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        lblIgv = new javax.swing.JLabel();
        txtIgv = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        lblNroComprobante = new javax.swing.JLabel();
        txtNComprobante = new javax.swing.JTextField();
        txtFecha = new org.jdesktop.swingx.JXDatePicker();
        lblTitulo1 = new javax.swing.JLabel();
        lblTitulo3 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        cboCodPro = new javax.swing.JComboBox();
        cboCodPrv = new javax.swing.JComboBox();
        jToolBar = new javax.swing.JToolBar();
        btnSalir = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setPreferredSize(new java.awt.Dimension(800, 550));

        lblNroCompra.setText("COMPRA N° :");

        txtNcompra.setEnabled(false);

        lblFecha.setText("FECHA :");

        lblProveedor.setText("PROVEEDOR :");

        cboProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELIJA PROVEEDOR" }));
        cboProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProveedorActionPerformed(evt);
            }
        });

        lblRUC.setText("R.U.C :");

        txtRuc.setEditable(false);
        txtRuc.setEnabled(false);

        lblFormaPago.setText("FORMA DE PAGO :");

        cmbFormaPago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELIJA", "CONTACTO", "CRÉDITO" }));

        lblTipoComprobante.setText("TIPO COMPROBANTE :");

        cboTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELIJA", "BOLETA", "FACTURA", "OTRO" }));

        tblDetalleCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION DEL PRODUCTO", "PRECIO", "CANTIDAD", "SUBTOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetalleCompra.setColumnSelectionAllowed(true);
        tblDetalleCompra.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblDetalleCompra);
        tblDetalleCompra.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDetalleCompra.getColumnModel().getColumn(0).setMinWidth(60);
        tblDetalleCompra.getColumnModel().getColumn(0).setMaxWidth(60);
        tblDetalleCompra.getColumnModel().getColumn(1).setMinWidth(300);
        tblDetalleCompra.getColumnModel().getColumn(1).setMaxWidth(300);

        cboCategoriaPro.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        cboCategoriaPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CATEGORÍA" }));
        cboCategoriaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoriaProActionPerformed(evt);
            }
        });

        cboProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELIJA PRODUCTO" }));

        lblCantidad.setText("CANTIDAD :");

        lblPrecio.setText("PRECIO :");

        lblSubtotal.setText("SUB TOTAL :");

        txtSubTotal.setEnabled(false);

        lblIgv.setText("I.G.V :");

        txtIgv.setEnabled(false);

        txtTotal.setEnabled(false);

        lblTotal.setText("TOTAL A PAGAR :");

        lblNroComprobante.setText("N° COMPROBANTE :");

        lblTitulo1.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("REGISTRO DE COMPRAS");
        lblTitulo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo1.setOpaque(true);

        lblTitulo3.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo3.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo3.setText("DETALLE DE COMPRA");
        lblTitulo3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo3.setOpaque(true);

        lblTitulo2.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("AGREGAR PRODUCTOS");
        lblTitulo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo2.setOpaque(true);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/add.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        cboCodPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "codPro" }));

        cboCodPrv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "codPrv" }));

        jToolBar.setRollover(true);
        jToolBar.setBorder(null);

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/inicio.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar.add(btnSalir);

        btnImprimir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/impimir.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setFocusable(false);
        btnImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jToolBar.add(btnImprimir);

        btnComprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/vender.png"))); // NOI18N
        btnComprar.setText("Registrar");
        btnComprar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnComprar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        jToolBar.add(btnComprar);

        btnCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/calcular.png"))); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCalcular.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        jToolBar.add(btnCalcular);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(lblTitulo1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblTitulo3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(27, 27, 27)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(lblProveedor)
                    .add(lblNroCompra))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(txtNcompra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(41, 41, 41)
                        .add(lblFecha)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(cboProveedor, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(lblTipoComprobante)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cboTipoComprobante, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(lblRUC)
                        .add(18, 18, 18)
                        .add(txtRuc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 155, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(lblFormaPago)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(cmbFormaPago, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(lblNroComprobante)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtNComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 81, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(30, 30, 30))
            .add(lblTitulo2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(cboCodPro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(cboCodPrv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jToolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 325, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                    .add(35, 35, 35)
                                    .add(lblSubtotal))
                                .add(lblTotal))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblIgv))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtIgv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtSubTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(cboCategoriaPro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 92, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cboProducto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 235, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(lblPrecio)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtPrecio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(10, 10, 10)
                        .add(lblCantidad)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtCantidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(32, 32, 32)
                        .add(btnAgregar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnEliminar)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane1)))
                .add(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(lblTitulo1)
                .add(1, 1, 1)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblNroCompra)
                            .add(txtNcompra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblFecha)
                            .add(txtFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(cboProveedor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblProveedor)))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblTipoComprobante)
                            .add(cboTipoComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblNroComprobante)
                            .add(txtNComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblRUC)
                            .add(txtRuc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblFormaPago)
                            .add(cmbFormaPago, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(lblTitulo2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cboCategoriaPro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblPrecio)
                    .add(txtPrecio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnAgregar)
                    .add(btnEliminar)
                    .add(cboProducto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblCantidad)
                    .add(txtCantidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblTitulo3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblSubtotal)
                            .add(txtSubTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtIgv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblIgv))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(14, 14, 14)
                                .add(lblTotal))
                            .add(layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                            .add(cboCodPro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(cboCodPrv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(jToolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProveedorActionPerformed
        if (cboProveedor.getSelectedIndex() > 0) {
            cboCodPrv.setSelectedIndex(cboProveedor.getSelectedIndex());
            String s = cboCodPrv.getSelectedItem().toString();
            txtRuc.setText("" + getProveedor(Integer.parseInt(s)).getDocPrv());
        }

    }//GEN-LAST:event_cboProveedorActionPerformed

    private void cboCategoriaProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoriaProActionPerformed
        cboProducto.removeAllItems();
        cboProducto.addItem("ELEGIR");
        cboCodPro.removeAllItems();
        cboCodPro.addItem("pro");
        listarProductosDeCategoria(cboCategoriaPro.getSelectedIndex());
    }//GEN-LAST:event_cboCategoriaProActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (txtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "CAMPOS VACÍOS", "MENSAJE", 2, null);
        } else {
            int codPro = cboProducto.getSelectedIndex();
            String nomPro = cboProducto.getSelectedItem().toString();
            double canPro = Double.parseDouble(txtCantidad.getText());
            double prePro = Double.parseDouble(txtPrecio.getText());
            double subtotal = canPro * prePro;
            Object[] fila = {codPro, nomPro, canPro, prePro, subtotal};
            DefaultTableModel modelo = (DefaultTableModel) tblDetalleCompra.getModel();
            modelo.addRow(fila);
            borrar();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) FormVenta.tblDetalleVenta.getModel();
        modelo.removeRow(tblDetalleCompra.getSelectedRow());
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        if (txtTotal.getText().equals("") || txtRuc.getText().equals("") || txtNComprobante.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "CAMPOS VACÍOS", "MENSAJE", 2, null);
        } else {
            agregarCompra();
            JOptionPane.showMessageDialog(this, "VENTA REGISTRADA", "MENSAJE", 1, null);
            limpiar();
        }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            tblDetalleCompra.print();
        } catch (PrinterException ex) {
            Logger.getLogger(FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        double st = 0.0;
        for (int i = 0; i < tblDetalleCompra.getRowCount(); i++) {
            st = st + Double.parseDouble(tblDetalleCompra.getValueAt(i, 5).toString());
        }
        txtSubTotal.setText(uti.df(st / 1.1) + "");
        txtIgv.setText(uti.df(st / 1.18 * 0.18) + "");
        txtTotal.setText(uti.df(st) + "");        
    }//GEN-LAST:event_btnCalcularActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboCategoriaPro;
    private javax.swing.JComboBox cboCodPro;
    private javax.swing.JComboBox cboCodPrv;
    private javax.swing.JComboBox cboProducto;
    private javax.swing.JComboBox cboProveedor;
    private javax.swing.JComboBox cboTipoComprobante;
    private javax.swing.JComboBox cmbFormaPago;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFormaPago;
    private javax.swing.JLabel lblIgv;
    private javax.swing.JLabel lblNroCompra;
    private javax.swing.JLabel lblNroComprobante;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblRUC;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTipoComprobante;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblDetalleCompra;
    private javax.swing.JTextField txtCantidad;
    private org.jdesktop.swingx.JXDatePicker txtFecha;
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtNComprobante;
    private javax.swing.JTextField txtNcompra;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
