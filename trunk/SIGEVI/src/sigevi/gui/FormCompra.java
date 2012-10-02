package sigevi.gui;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.util.ArrayList;
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
import sigevi.bea.Producto;
import sigevi.bea.Proveedor;
import sigevi.map.SqlMapConfig;

public class FormCompra extends javax.swing.JInternalFrame {

    protected javax.swing.JDesktopPane m_desktop;
    protected boolean m_undecorated;

    public void setUndecorated(boolean undecorated) {
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

    public FormCompra() {
        initComponents();
        setUndecorated(true);
        txtNcompra.setText(getNuevoCodigo() + "");
        listarCategorias();
        listarProveedores();
        autocompletarBox();
    }

    private void autocompletarBox() {
        AutoCompleteDecorator.decorate(this.cboCategoriaPro);
        AutoCompleteDecorator.decorate(this.cboProducto);
        AutoCompleteDecorator.decorate(this.cboProveedor);
    }

    private Producto getProducto(int codigo) {
        Producto producto = new Producto();
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        try {
            obj = sqlMapClient.queryForObject("getProducto", codigo);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        producto = ((Producto) obj);
        return producto;
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
        cmbTipoComprobante = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleCompra = new javax.swing.JTable();
        cboCategoriaPro = new javax.swing.JComboBox();
        cboProducto = new javax.swing.JComboBox();
        lblCantidad = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnRegistrarCompra = new javax.swing.JButton();
        lblSubtotal = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        lblIgv = new javax.swing.JLabel();
        txtIgv = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        lblNroComprobante = new javax.swing.JLabel();
        txtNComprobante = new javax.swing.JTextField();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        lblTitulo1 = new javax.swing.JLabel();
        lblTitulo3 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        cboCodPro = new javax.swing.JComboBox();
        cboCodPrv = new javax.swing.JComboBox();

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

        cmbTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELIJA", "BOLETA", "FACTURA", "OTRO" }));

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

        btnRegistrarCompra.setText("REGISTRAR COMPRA");
        btnRegistrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCompraActionPerformed(evt);
            }
        });

        lblSubtotal.setText("SUB TOTAL :");

        lblIgv.setText("I.G.V :");

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

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(lblTitulo1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblTitulo3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(21, 21, 21)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                            .add(btnRegistrarCompra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 139, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, cboCodPrv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                .add(438, 438, 438)
                                                .add(lblSubtotal))
                                            .add(layout.createSequentialGroup()
                                                .add(413, 413, 413)
                                                .add(lblTotal))))
                                    .add(layout.createSequentialGroup()
                                        .add(cboCodPro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(lblIgv)))
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
                                .add(btnEliminar)))
                        .add(0, 17, Short.MAX_VALUE))
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
                                .add(jXDatePicker1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(cboProveedor, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(lblTipoComprobante)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(cmbTipoComprobante, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .add(20, 20, 20)))
                .addContainerGap())
            .add(lblTitulo2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .add(jXDatePicker1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(cboProveedor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblProveedor)))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblTipoComprobante)
                            .add(cmbTipoComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
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
                    .add(layout.createSequentialGroup()
                        .add(btnRegistrarCompra)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(cboCodPro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cboCodPrv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(32, 32, 32))
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

    private void btnRegistrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCompraActionPerformed
    }//GEN-LAST:event_btnRegistrarCompraActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (txtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "CAMPOS VACÍOS", "MENSAJE", 2, null);
        } else {
            int codPro = cboProducto.getSelectedIndex();
            String nomPro = cboProducto.getSelectedItem().toString();
            double canPro = Double.parseDouble(txtCantidad.getText());
            double prePro = Double.parseDouble(txtPrecio.getText());
            double subtotal = canPro * prePro;
            Object[] fila = {codPro, nomPro,canPro, prePro, subtotal};
            DefaultTableModel modelo = (DefaultTableModel) tblDetalleCompra.getModel();
            modelo.addRow(fila);
            //limpiar();
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         DefaultTableModel modelo = (DefaultTableModel) FormVenta.tblDetalleVenta.getModel();
         modelo.removeRow(tblDetalleCompra.getSelectedRow());
    }//GEN-LAST:event_btnEliminarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrarCompra;
    private javax.swing.JComboBox cboCategoriaPro;
    private javax.swing.JComboBox cboCodPro;
    private javax.swing.JComboBox cboCodPrv;
    private javax.swing.JComboBox cboProducto;
    private javax.swing.JComboBox cboProveedor;
    private javax.swing.JComboBox cmbFormaPago;
    private javax.swing.JComboBox cmbTipoComprobante;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
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
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtNComprobante;
    private javax.swing.JTextField txtNcompra;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
