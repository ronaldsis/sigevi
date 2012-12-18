package sigevi.gui;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.awt.print.PrinterException;
import java.io.File;
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
import sigevi.map.SqlMapConfig;
import sigevi.uti.Util;

public class FormProducto extends javax.swing.JInternalFrame {

    private sigevi.gui.FormProDes pxd;
    private sigevi.gui.FormProMed pxm;
    private sigevi.gui.FormProPre pxp;
    protected javax.swing.JDesktopPane m_desktop;
    protected boolean m_undecorated;

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

    public FormProducto() {
        initComponents();
        setUndecorated(true);
        cargarCategorias();
        AutoCompleteDecorator.decorate(this.cboCategoria);
    }

    private int getNuevoCodigo() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        int cod = 0;
        try {
            obj = sqlMapClient.queryForObject("getMaxProducto");
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (obj != null) {
            cod = ((Integer) obj).intValue();
        }
        return cod + 1;
    }

    public static Producto getProducto(int codigo) {
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

    private void agregarProducto() {
        Producto pro = new Producto();
        pro.setCodPro(Integer.parseInt(txtCodigo.getText()));
        pro.setNomPro(txtNombre.getText().toUpperCase());
        pro.setDesPro(txtDescripción.getText().toUpperCase());
        pro.setStoPro(Double.parseDouble(txtStock.getText()));
        pro.setPreCom(Double.parseDouble(txtPrecioCompra.getText()));
        pro.setPreVen(Double.parseDouble(txtPrecioVenta.getText()));
        pro.setCategoria_codCat(cboCategoria.getSelectedIndex());


        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {

            sqlMapClient.insert("insertProducto", pro);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modificarProducto() {
        Producto pro = new Producto();
        pro = getProducto(Integer.parseInt(txtCodigo.getText()));
        pro.setNomPro(txtNombre.getText().toUpperCase());
        pro.setDesPro(txtDescripción.getText().toUpperCase());
        pro.setStoPro(Double.parseDouble(txtStock.getText()));
        pro.setCategoria_codCat(cboCategoria.getSelectedIndex());
        pro.setPreCom(Double.parseDouble(txtPrecioCompra.getText()));
        pro.setPreVen(Double.parseDouble(txtPrecioVenta.getText()));


        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {

            sqlMapClient.update("updateProducto", pro);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarProducto() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {
            sqlMapClient.delete("removeProducto", Integer.parseInt(txtCodigo.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listarProductos() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Producto> productos = new ArrayList<>();
        try {
            productos = sqlMapClient.queryForList("listProducto", null);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultTableModel modelo = (DefaultTableModel) tblProducto.getModel();
        tblProducto.setModel(modelo);

        for (int i = 0; i < productos.size(); i++) {
            Producto pro = productos.get(i);
            Object[] fila = {pro.getCodPro(), pro.getNomPro(), pro.getDesPro(), pro.getStoPro(),
                pro.getPreCom(), pro.getPreVen(), pro.getNomCat()};
            modelo.addRow(fila);
        }
    }

    private void cargarCategorias() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Categoria> categorias = new ArrayList<>();
        try {
            categorias = sqlMapClient.queryForList("listCategoria", null);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < categorias.size(); i++) {
            Categoria per = categorias.get(i);
            cboCategoria.addItem(per.getNomCat());
        }
    }

    private void activarBotones() {
        btnNuevo.setEnabled(true);
        btnAgregar.setEnabled(false);
        btnBuscar.setEnabled(true);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnListar.setEnabled(true);
        limpiartextos();
        activartextos(false);
        activarTab(false);
    }

    private void activartextos(boolean b) {
        txtCodigo.setEnabled(!b);
        txtNombre.setEnabled(b);
        txtPrecioCompra.setEnabled(b);
        txtPrecioVenta.setEnabled(b);
        txtDescripción.setEnabled(b);
        txtStock.setEnabled(b);
        cboCategoria.setEnabled(b);
    }

    private void activarTareas(boolean b) {
        int seleccion = JOptionPane.showConfirmDialog(this, "¿DESEA PROCESAR LA INFORMACIÓN DEL PRODUCTO?", "MENSAJE", 0);
        if (seleccion != -1) {

            if (seleccion == 0) {
                activartextos(!b);
                txtCodigo.setEnabled(!b);
                activarTab(b);
            } else {
                listarProductos();
                activarBotones();
            }
        }
    }

    private void limpiartextos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtDescripción.setText("");
        txtStock.setText("");
        txtPrecioCompra.setText("");
        txtPrecioVenta.setText("");
        cboCategoria.setSelectedIndex(0);
    }

    private void activarTab(boolean b) {
        btnMedidas.setEnabled(b);
        btnDespacho.setEnabled(b);
        btnPrecio.setEnabled(b);
        btnFinalizar.setEnabled(b);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo2 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblDocumento = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jToolBar = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripción = new javax.swing.JTextArea();
        lblCodigo1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblCodigo2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        cboCategoria = new javax.swing.JComboBox();
        txtStock = new javax.swing.JTextField();
        tabProcesar = new javax.swing.JTabbedPane();
        pnlProcesarProducto = new javax.swing.JPanel();
        btnMedidas = new javax.swing.JButton();
        btnDespacho = new javax.swing.JButton();
        btnPrecio = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        lblCodigo4 = new javax.swing.JLabel();
        lblCodigo5 = new javax.swing.JLabel();
        txtPrecioCompra = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setPreferredSize(new java.awt.Dimension(800, 550));

        lblTitulo2.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("LISTA DE PRODUCTOS");
        lblTitulo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo2.setOpaque(true);

        lblCodigo.setText("STOCK :");

        lblDocumento.setText("NOMBRE :");

        lblTitulo1.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("MANTENIMIENTO DE PRODUCTO");
        lblTitulo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo1.setOpaque(true);

        lblDireccion.setText("DESCRIPCIÓN :");

        txtNombre.setEnabled(false);

        jToolBar.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar.setBorder(null);
        jToolBar.setFloatable(false);
        jToolBar.setName(""); // NOI18N

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setToolTipText("");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar.add(btnNuevo);

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setEnabled(false);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jToolBar.add(btnAgregar);

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("");
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jToolBar.add(btnBuscar);

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jToolBar.add(btnEditar);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar.add(btnEliminar);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/grabar.png"))); // NOI18N
        btnGuardar.setText("Grabar");
        btnGuardar.setEnabled(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar.add(btnGuardar);

        btnListar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar.setText("Listar");
        btnListar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });
        jToolBar.add(btnListar);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jToolBar.add(btnCancelar);

        btnExcel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/excel.png"))); // NOI18N
        btnExcel.setText("Excel");
        btnExcel.setFocusable(false);
        btnExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });
        jToolBar.add(btnExcel);

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

        txtDescripción.setColumns(20);
        txtDescripción.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtDescripción.setRows(10);
        txtDescripción.setWrapStyleWord(true);
        txtDescripción.setAutoscrolls(false);
        txtDescripción.setEnabled(false);
        jScrollPane2.setViewportView(txtDescripción);

        lblCodigo1.setText("CODIGO :");

        lblCodigo2.setText("CATEGORIA :");

        tblProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "PRODUCTO", "DESCRIPCION", "STOCK", "COSTO", "VENTA", "CATEGORIA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProducto);
        tblProducto.getColumnModel().getColumn(0).setMinWidth(50);
        tblProducto.getColumnModel().getColumn(0).setMaxWidth(50);
        tblProducto.getColumnModel().getColumn(1).setMinWidth(250);
        tblProducto.getColumnModel().getColumn(1).setMaxWidth(250);
        tblProducto.getColumnModel().getColumn(2).setMinWidth(200);
        tblProducto.getColumnModel().getColumn(2).setMaxWidth(200);
        tblProducto.getColumnModel().getColumn(6).setMinWidth(100);
        tblProducto.getColumnModel().getColumn(6).setMaxWidth(100);

        cboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR CATEGORIA" }));
        cboCategoria.setEnabled(false);

        txtStock.setEnabled(false);
        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });

        pnlProcesarProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnMedidas.setText("INGRESAR MEDIDAS");
        btnMedidas.setEnabled(false);
        btnMedidas.setPreferredSize(new java.awt.Dimension(150, 23));
        btnMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedidasActionPerformed(evt);
            }
        });
        pnlProcesarProducto.add(btnMedidas);

        btnDespacho.setText("INGRESA DESPACHOS");
        btnDespacho.setEnabled(false);
        btnDespacho.setPreferredSize(new java.awt.Dimension(150, 23));
        btnDespacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDespachoActionPerformed(evt);
            }
        });
        pnlProcesarProducto.add(btnDespacho);

        btnPrecio.setText("INGRESAR PRECIOS");
        btnPrecio.setEnabled(false);
        btnPrecio.setPreferredSize(new java.awt.Dimension(150, 23));
        btnPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrecioActionPerformed(evt);
            }
        });
        pnlProcesarProducto.add(btnPrecio);

        btnFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/ok.png"))); // NOI18N
        btnFinalizar.setText("FINALIZAR");
        btnFinalizar.setEnabled(false);
        btnFinalizar.setPreferredSize(new java.awt.Dimension(150, 25));
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        pnlProcesarProducto.add(btnFinalizar);

        tabProcesar.addTab("PROCESAR PRODUCTO", pnlProcesarProducto);

        lblCodigo4.setText("PRECIO VENTA REF:");

        lblCodigo5.setText("PRECIO COMPRA REF :");

        txtPrecioCompra.setEnabled(false);

        txtPrecioVenta.setEnabled(false);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblTitulo1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jToolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                            .add(lblDocumento)
                                            .add(lblCodigo)
                                            .add(lblCodigo1))
                                        .add(18, 18, 18)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(txtNombre)
                                            .add(layout.createSequentialGroup()
                                                .add(1, 1, 1)
                                                .add(lblCodigo5)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(txtPrecioCompra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                                .add(lblCodigo4)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(txtPrecioVenta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                            .add(layout.createSequentialGroup()
                                                .add(txtCodigo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(lblCodigo2)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                                .add(cboCategoria, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 158, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                    .add(layout.createSequentialGroup()
                                        .add(51, 51, 51)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                            .add(lblDireccion)
                                            .add(txtStock, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(18, 18, 18)
                                        .add(jScrollPane2)))
                                .add(18, 18, 18)
                                .add(tabProcesar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 206, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(0, 150, Short.MAX_VALUE))
                    .add(lblTitulo2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jToolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblTitulo1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(tabProcesar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblCodigo1)
                            .add(txtCodigo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblCodigo2)
                            .add(cboCategoria, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblDocumento))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblCodigo4)
                            .add(lblCodigo5)
                            .add(txtPrecioCompra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtPrecioVenta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(lblCodigo)
                                    .add(txtStock, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(lblDireccion)))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblTitulo2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        btnNuevo.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnBuscar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnListar.setEnabled(false);
        limpiartextos();
        activartextos(true);
        txtCodigo.setText(getNuevoCodigo() + "");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "INGRESE NOMBRE DE PRODUCTO", "MENSAJE", 2, null);
            if (cboCategoria.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "SELECCIONE UNA CATEGORIA", "MENSAJE", 2, null);
            }
        } else {
            agregarProducto();
            JOptionPane.showMessageDialog(this, "PRODUCTO REGISTRADO", "MENSAJE", 1, null);
            activarTareas(true);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "INGRESE CÓDIGO", "MENSAJE", 2, null);
        } else {
            Producto producto = new Producto();
            producto = getProducto(Integer.parseInt(txtCodigo.getText()));
            if (producto != null) {

                txtNombre.setText(producto.getNomPro());
                txtDescripción.setText(producto.getDesPro());
                txtStock.setText(producto.getStoPro().toString());
                txtPrecioCompra.setText(producto.getPreCom().toString());
                txtPrecioVenta.setText(producto.getPreVen().toString());
                cboCategoria.setSelectedIndex(producto.getCategoria_codCat());
                btnEliminar.setEnabled(true);
                btnEditar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "PRODUCTO NO EXISTE", "MENSAJE", 0, null);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        activartextos(true);
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnListar.setEnabled(false);
        activarTab(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int confirmado = JOptionPane.showConfirmDialog(this, "¿LO CONFIRMAS?", "MENSAJE", 1);

        if (JOptionPane.OK_OPTION == confirmado) {
            eliminarProducto();
            listarProductos();
            limpiartextos();
            JOptionPane.showMessageDialog(this, "PRODUCTO ELIMINADO", "MENSAJE", 1, null);
        } else {
            JOptionPane.showMessageDialog(this, "OPERACION CANCELADA", "MENSAJE", 1, null);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "CAMPOS VACÍOS", "MENSAJE", 2, null);
        } else {
            modificarProducto();
            activarBotones();
            JOptionPane.showMessageDialog(this, "PRODUCTO MODIFICADO", "MENSAJE", 1, null);
            listarProductos();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        listarProductos();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        activarBotones();
        activarTab(false);
        btnEliminar.setEnabled(false);
        btnEditar.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        try {
            String archivo = "D:\\INFO-" + Util.getFecha() + ".xls";
            Util.exportarData(tblProducto, new File(archivo));
            JOptionPane.showMessageDialog(null, "INFORMACIÓN EXPORTADA A :  " + archivo, " MENSAJE", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }//GEN-LAST:event_btnExcelActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            tblProducto.print();
        } catch (PrinterException ex) {
            Logger.getLogger(FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedidasActionPerformed
        pxm = new FormProMed();
        pxm.setVisible(true);
    }//GEN-LAST:event_btnMedidasActionPerformed

    private void btnDespachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDespachoActionPerformed
        pxd = new FormProDes();
        pxd.setVisible(true);
    }//GEN-LAST:event_btnDespachoActionPerformed

    private void btnPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrecioActionPerformed
        pxp = new FormProPre();
        pxp.setVisible(true);
    }//GEN-LAST:event_btnPrecioActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        activarTab(false);
        JOptionPane.showMessageDialog(null, "PROCESAR PRODUCTO FINALIZADO", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDespacho;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnMedidas;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPrecio;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboCategoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblCodigo2;
    private javax.swing.JLabel lblCodigo4;
    private javax.swing.JLabel lblCodigo5;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JPanel pnlProcesarProducto;
    private javax.swing.JTabbedPane tabProcesar;
    private javax.swing.JTable tblProducto;
    public static javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripción;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
