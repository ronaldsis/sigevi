package sigevi.gui;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import sigevi.bea.DetalleVenta;
import sigevi.bea.Venta;
import sigevi.map.SqlMapConfig;
import sigevi.uti.Util;

public class FormVenta extends javax.swing.JInternalFrame {

    private sigevi.gui.FormDetalleVenta dp;
    private sigevi.gui.FormBuscarCliente dcli;
    protected javax.swing.JDesktopPane m_desktop;
    protected boolean m_undecorated;
    private Util uti = new Util();

    public void setUndecorated(boolean undecorated) {
        if (m_undecorated != undecorated) {
            m_undecorated = undecorated;
            BasicInternalFrameUI ui = (BasicInternalFrameUI) getUI();
            if (undecorated) {
                putClientProperty("titlePane", ui.getNorthPane());
                putClientProperty("border", getBorder());
                ui.setNorthPane(null);
                setBorder(null);
            } else {
                ui.setNorthPane((JComponent) getClientProperty("titlePane"));
                setBorder((Border) getClientProperty("border"));
                putClientProperty("titlePane", null);
                putClientProperty("border", null);
            }
        }
    }

    public FormVenta() {
        initComponents();
        setUndecorated(true);
        txtNumVenta.setText(getNuevoCodigo() + "");
    }

    private int getNuevoCodigo() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        int cod = 0;
        try {
            obj = sqlMapClient.queryForObject("getMaxVenta");
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (obj != null) {
            cod = ((Integer) obj).intValue();
        }
        return cod + 1;
    }
    
        private int getNuevoCodigoDetalle() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        int cod = 0;
        try {
            obj = sqlMapClient.queryForObject("getMaxDetalleVenta");
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (obj != null) {
            cod = ((Integer) obj).intValue();
        }
        return cod + 1;
    }

    private void habilitarTextos(boolean b) {
        lblIgv.setVisible(b);
        lblSubTotal.setVisible(b);
        txtIgv.setVisible(b);
        txtSubTotal.setVisible(b);
    }

    private void limpiartextos() {
        txtNombre.setText("");
        txtDni.setText("");
        txtDireccion.setText("");
        txtNumVenta.setText("");
        txtSubTotal.setText("");
        txtIgv.setText("");
        txtTotal.setText("");
        txtNroComprobante.setText("");
        cboComprobante.setSelectedIndex(0);
        tblDetalleVenta.setModel(new DefaultTableModel());
        txtNumVenta.setText(getNuevoCodigo() + "");
    }

    private void agregarVenta() {
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Venta vnt = new Venta();
        int numVen = Integer.parseInt(txtNumVenta.getText());
        vnt.setNroVen(numVen);
        vnt.setNroCom(txtNroComprobante.getText());
        vnt.setTipCom((String) cboComprobante.getSelectedItem());
        vnt.setFecVen(uti.setFecha(txtFecha.getText()));
        vnt.setCliente_codCli(Integer.parseInt(txtCodigoCliente.getText()));
        vnt.setUsuario_codUsu(FormLogin.getUsuario());
        try {
            vnt.setFecVen((Date) formatter.parse(txtFecha.getText()));

        } catch (ParseException ex) {
            Logger.getLogger(sigevi.gui.FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {

            sqlMapClient.insert("insertVenta", vnt);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        /**
         * *Recorremos la tabla**
         */
        for (int i = 0; i < tblDetalleVenta.getRowCount(); i++) {
            int codPro = Integer.parseInt(FormVenta.tblDetalleVenta.getValueAt(i, 0).toString());
            double precio = Double.parseDouble(FormVenta.tblDetalleVenta.getValueAt(i, 3).toString());
            double cantidad = Double.parseDouble(FormVenta.tblDetalleVenta.getValueAt(i, 4).toString());
            agregarDetalleVenta(numVen, codPro, precio, cantidad);
        }
    }

    private void agregarDetalleVenta(int venta, int producto, double precio, double cantidad) {
        DetalleVenta det = new DetalleVenta();
        det.setNroDet(getNuevoCodigoDetalle());
        det.setVenta_nroVen(venta);
        det.setProducto_codPro(producto);
        det.setPreDet(precio);
        det.setCanDet(cantidad);

        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {

            sqlMapClient.insert("insertDetalleVenta", det);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCliente = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        txtConsultar = new javax.swing.JButton();
        lblNroDocumento = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtIgv = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        lblIgv = new javax.swing.JLabel();
        lblNroComprobante = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtNroComprobante = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblNroVenta = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        txtNumVenta = new javax.swing.JTextField();
        txtSubTotal = new javax.swing.JTextField();
        lblSubTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleVenta = new javax.swing.JTable();
        cboComprobante = new javax.swing.JComboBox();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblTitulo1 = new javax.swing.JLabel();
        lblTitulo3 = new javax.swing.JLabel();
        txtCodigoCliente = new javax.swing.JTextField();
        lblNroDocumento1 = new javax.swing.JLabel();
        jToolBar = new javax.swing.JToolBar();
        btnSalir = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnVender = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setPreferredSize(new java.awt.Dimension(800, 550));

        lblCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCliente.setText("RAZON SOCIAL :");

        txtFecha.setEditable(false);
        txtFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        txtFecha.setEnabled(false);

        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipo.setText("TIPO COMPROBANTE :");

        txtConsultar.setBackground(new java.awt.Color(255, 255, 255));
        txtConsultar.setForeground(new java.awt.Color(255, 255, 255));
        txtConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/lupa.png"))); // NOI18N
        txtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsultarActionPerformed(evt);
            }
        });

        lblNroDocumento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNroDocumento.setText("DNI :");

        txtNombre.setEnabled(false);

        txtIgv.setEditable(false);
        txtIgv.setEnabled(false);

        txtTotal.setEditable(false);
        txtTotal.setEnabled(false);

        lblIgv.setText("IGV :");

        lblNroComprobante.setText("NRO COMPROBANTE :");

        lblTotal.setText("TOTAL :");

        txtDni.setEnabled(false);

        lblDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDireccion.setText("DIRECCIÓN :");

        txtDireccion.setEnabled(false);

        lblNroVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNroVenta.setText("NRO VENTA :");

        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("FECHA :");

        txtNumVenta.setEditable(false);
        txtNumVenta.setEnabled(false);

        txtSubTotal.setEditable(false);
        txtSubTotal.setEnabled(false);

        lblSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubTotal.setText("SUB TOTAL :");

        tblDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION DEL PRODUCTO", "MEDIDA", "PRECIO", "CANTIDAD", "SUBTOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetalleVenta.setColumnSelectionAllowed(true);
        tblDetalleVenta.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblDetalleVenta);
        tblDetalleVenta.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDetalleVenta.getColumnModel().getColumn(0).setMinWidth(60);
        tblDetalleVenta.getColumnModel().getColumn(0).setMaxWidth(60);
        tblDetalleVenta.getColumnModel().getColumn(1).setMinWidth(300);
        tblDetalleVenta.getColumnModel().getColumn(1).setMaxWidth(300);

        cboComprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FACTURA", "BOLETA" }));
        cboComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboComprobanteActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/add.png"))); // NOI18N
        btnAgregar.setText("Agregar Producto");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar Producto");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblTitulo1.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("REGISTRO DE VENTA");
        lblTitulo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo1.setOpaque(true);

        lblTitulo3.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo3.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo3.setText("DETALLE DE COMPRA");
        lblTitulo3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo3.setOpaque(true);

        txtCodigoCliente.setEnabled(false);

        lblNroDocumento1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNroDocumento1.setText("COD CLIENTE :");

        jToolBar.setBorder(null);
        jToolBar.setRollover(true);

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

        btnVender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/vender.png"))); // NOI18N
        btnVender.setText("Vender");
        btnVender.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVender.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });
        jToolBar.add(btnVender);

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
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(7, 7, 7)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(lblNroComprobante)
                            .add(lblNroVenta))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtNumVenta)
                            .add(txtNroComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 75, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(44, 44, 44)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(lblTipo)
                            .add(lblCliente))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(cboComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(0, 0, Short.MAX_VALUE))
                            .add(txtNombre))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(txtConsultar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(211, 211, 211))
                    .add(layout.createSequentialGroup()
                        .add(btnAgregar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnEliminar)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .add(layout.createSequentialGroup()
                .add(61, 61, 61)
                .add(lblDireccion)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtDireccion)
                .add(246, 246, 246))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(0, 595, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(lblFecha)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(lblNroDocumento)
                            .add(lblNroDocumento1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(txtDni)
                            .add(txtCodigoCliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(37, 37, 37))
            .add(lblTitulo1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblTitulo3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 750, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(jToolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                    .add(lblSubTotal)
                                    .add(18, 18, 18)
                                    .add(txtSubTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                    .add(lblIgv)
                                    .add(18, 18, 18)
                                    .add(txtIgv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(lblTotal)
                                .add(18, 18, 18)
                                .add(txtTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(lblTitulo1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblNroVenta)
                            .add(txtNumVenta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblNroComprobante)
                            .add(txtNroComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblFecha)
                            .add(txtFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtDni, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblNroDocumento)))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(cboComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblTipo))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtConsultar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblCliente))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(txtDireccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(lblDireccion))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(txtCodigoCliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(lblNroDocumento1)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblTitulo3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAgregar)
                    .add(btnEliminar))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtSubTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblSubTotal))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtIgv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblIgv))
                        .add(8, 8, 8)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(lblTotal)
                            .add(txtTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jToolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        double st=0.0;      
        for (int i = 0; i < tblDetalleVenta.getRowCount(); i++) {
            st =st + Double.parseDouble(FormVenta.tblDetalleVenta.getValueAt(i, 5).toString());
        }
        txtSubTotal.setText(uti.df(st/1.1)+"");
        txtIgv.setText(uti.df(st/1.18*0.18)+"");
        txtTotal.setText(uti.df(st)+"");       
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void txtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsultarActionPerformed
        dcli = new FormBuscarCliente();
        dcli.setVisible(true);
    }//GEN-LAST:event_txtConsultarActionPerformed

    private void cboComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboComprobanteActionPerformed
        if (cboComprobante.getSelectedIndex() == 0) {
            lblCliente.setText("RAZÓN SOCIAL :");
            lblNroDocumento.setText("RUC :");
            habilitarTextos(true);
        } else {
            lblCliente.setText("NOMBRE :");
            lblNroDocumento.setText("DNI :");
            habilitarTextos(false);
        }
    }//GEN-LAST:event_cboComprobanteActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        dp = new FormDetalleVenta();
        dp.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) FormVenta.tblDetalleVenta.getModel();
        modelo.removeRow(tblDetalleVenta.getSelectedRow());
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        if (txtTotal.getText().equals("")||txtNombre.getText().equals("")||txtNroComprobante.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "CAMPOS VACÍOS", "MENSAJE", 2, null);
        } else {
            agregarVenta();
            JOptionPane.showMessageDialog(this, "VENTA REGISTRADA", "MENSAJE", 1, null);
            limpiartextos();
        }
    }//GEN-LAST:event_btnVenderActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            tblDetalleVenta.print();
        } catch (PrinterException ex) {
            Logger.getLogger(FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVender;
    private javax.swing.JComboBox cboComprobante;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIgv;
    private javax.swing.JLabel lblNroComprobante;
    private javax.swing.JLabel lblNroDocumento;
    private javax.swing.JLabel lblNroDocumento1;
    private javax.swing.JLabel lblNroVenta;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTotal;
    public static javax.swing.JTable tblDetalleVenta;
    public static javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JButton txtConsultar;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIgv;
    public static javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNroComprobante;
    private javax.swing.JTextField txtNumVenta;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
