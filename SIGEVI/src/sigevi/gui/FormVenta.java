package sigevi.gui;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import sigevi.bea.Venta;
import sigevi.bea.DetalleVenta;
import sigevi.map.SqlMapConfig;

public class FormVenta extends javax.swing.JPanel {

    private FormDetalleVenta dp;
    private FormBuscarCliente dcli;

    public FormVenta() {
        initComponents();
        txtNumVenta.setText(getNuevoCodigo() + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCliente = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        btnVender = new javax.swing.JButton();
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

        setPreferredSize(new java.awt.Dimension(800, 500));

        lblCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCliente.setText("RAZON SOCIAL :");

        txtFecha.setEditable(false);
        txtFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        txtFecha.setEnabled(false);

        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipo.setText("TIPO COMPROBANTE :");

        btnVender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/calcular.png"))); // NOI18N
        btnVender.setText("Vender");
        btnVender.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVender.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

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

        txtTotal.setEditable(false);

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

        lblSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubTotal.setText("SUB TOTAL :");

        tblDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDetalleVenta);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNroComprobante)
                                    .addComponent(lblNroVenta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNumVenta, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTipo)
                                    .addComponent(lblCliente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cboComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 102, Short.MAX_VALUE))
                                    .addComponent(txtNombre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFecha)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(lblNroDocumento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDni)
                                            .addComponent(txtCodigoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))))
                            .addComponent(lblTitulo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lblDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion)
                        .addGap(236, 236, 236))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblSubTotal)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblIgv)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblTotal)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNroVenta)
                            .addComponent(txtNumVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNroComprobante)
                            .addComponent(txtNroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFecha)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNroDocumento)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCliente))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDireccion))
                    .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIgv))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTotal)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnVender))
                .addContainerGap(105, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private int getNuevoCodigo() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        int cod = 0;
        try {
            obj = sqlMapClient.queryForObject("getMaxVenta");
        } catch (SQLException ex) {
            Logger.getLogger(FormCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (obj != null) {
            cod = ((Integer) obj).intValue();
        }
        return cod + 1;
    }
    
    private void habilitarTextos(boolean b) {
        lblIgv.setVisible(b);
        lblSubTotal.setVisible(b);
        txtSubTotal.setVisible(b);
        txtIgv.setVisible(b);
    }

    private void limpiartextos() {
        txtNombre.setText("");
        txtDni.setText("");
        txtDireccion.setText("");
        txtNumVenta.setText("");
        txtTotal.setText("");
        txtSubTotal.setText("");
        txtIgv.setText("");
        cboComprobante.setSelectedIndex(0);
        tblDetalleVenta.setModel(new DefaultTableModel());

    }

    private void agregarVenta() {
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Venta vnt = new Venta();
        vnt.setNroVen(Integer.parseInt(txtNumVenta.getText()));
        vnt.setNroCom(txtNroComprobante.getText());
        vnt.setTipCom((String) cboComprobante.getSelectedItem());
        try {
            vnt.setFecVen((Date) formatter.parse(txtFecha.getText()));

        } catch (ParseException ex) {
            Logger.getLogger(FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {

            sqlMapClient.insert("insertVenta", vnt);
        } catch (SQLException ex) {
            Logger.getLogger(FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*for*/
        
        
        
    }
    
    private void agregarDetalleVenta(int venta, int producto, double precio, double cantidad){
        DetalleVenta det=new DetalleVenta();
        det.setNroDet(getNuevoCodigo());
        det.setVenta_nroVen(venta);
        det.setProducto_codPro(producto);
        det.setPreDet(precio);
        det.setCanDet(cantidad);
        
         SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {

            sqlMapClient.insert("insertDetalleVenta", det);
        } catch (SQLException ex) {
            Logger.getLogger(FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
    }//GEN-LAST:event_btnVenderActionPerformed

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
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVender;
    private javax.swing.JComboBox cboComprobante;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIgv;
    private javax.swing.JLabel lblNroComprobante;
    private javax.swing.JLabel lblNroDocumento;
    private javax.swing.JLabel lblNroVenta;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblDetalleVenta;
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
