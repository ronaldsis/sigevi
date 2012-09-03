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
import sigevi.map.SqlMapConfig;

public class FormVenta extends javax.swing.JPanel {

    private FormDetalleVenta dp;
    private FormBuscarCliente dcli;

    public FormVenta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCliente = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNroDocumento = new javax.swing.JLabel();
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
        lblTipo = new javax.swing.JLabel();
        btnVender = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        lblusuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtConsultar = new javax.swing.JButton();
        lblIgv = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtIgv = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        lblNroComprobante = new javax.swing.JLabel();
        txtNroComprobante = new javax.swing.JTextField();
        txtCodigoCliente = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        btnAgregar2 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        lblCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCliente.setText("CLIENTE :");

        lblNroDocumento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNroDocumento.setText("DNI :");

        lblDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDireccion.setText("DIRECCIÓN :");

        lblNroVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNroVenta.setText("NRO VENTA :");

        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("FECHA :");

        txtNumVenta.setEditable(false);

        txtSubTotal.setEditable(false);

        lblSubTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        cboComprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Factura", "Boleta" }));
        cboComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboComprobanteActionPerformed(evt);
            }
        });

        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipo.setText("TIPO COMPROBANTE :");

        btnVender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/calcular.png"))); // NOI18N
        btnVender.setText("Vender");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

        txtFecha.setEditable(false);
        txtFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        lblusuario.setText("USUARIO :");

        txtUsuario.setEditable(false);

        txtConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/lupa-icon.gif"))); // NOI18N
        txtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsultarActionPerformed(evt);
            }
        });

        lblIgv.setText("IGV :");

        txtTotal.setEditable(false);

        txtIgv.setEditable(false);

        lblTotal.setText("TOTAL :");

        lblNroComprobante.setText("NRO COMPORBANTE :");

        txtCodigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoClienteActionPerformed(evt);
            }
        });

        lblCodigo.setText("REF CLIENTE :");

        btnAgregar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/add.png"))); // NOI18N
        btnAgregar2.setText("Agregar Prodcuto");
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar Producto");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(15, 15, 15)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(btnVender)
                        .add(74, 74, 74)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(lblIgv)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, lblTotal)
                                .add(lblSubTotal)))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtSubTotal, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtIgv)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtTotal)))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblTipo)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblNroVenta)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblNroComprobante)
                            .add(layout.createSequentialGroup()
                                .add(39, 39, 39)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(lblNroDocumento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(lblCliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(lblDireccion)))))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(txtDireccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 360, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtDni, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 121, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(txtNumVenta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(lblFecha))
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(cboComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 103, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(txtNroComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 103, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblusuario)
                                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblCodigo))))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, txtUsuario)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, txtFecha, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .add(txtCodigoCliente)))
                            .add(layout.createSequentialGroup()
                                .add(txtNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 321, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(txtConsultar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                            .add(btnAgregar2)
                            .add(18, 18, 18)
                            .add(btnEliminar))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 467, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(0, 101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(30, 30, 30)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblNroVenta)
                    .add(txtNumVenta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblFecha)
                    .add(txtFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cboComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblTipo)
                    .add(lblusuario)
                    .add(txtUsuario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtNroComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblNroComprobante)
                    .add(txtCodigoCliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblCodigo))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblCliente)
                            .add(txtNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblNroDocumento)
                            .add(txtDni, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(txtConsultar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtDireccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblDireccion))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAgregar2)
                    .add(btnEliminar))
                .add(18, 18, 18)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 121, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(btnVender)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblSubTotal)
                            .add(txtSubTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblIgv)
                            .add(txtIgv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblTotal)
                            .add(txtTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(100, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

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
    private void cboComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboComprobanteActionPerformed
        if (cboComprobante.getSelectedIndex() == 0) {
            lblCliente.setText("RAZÓN SOCIAL");
            lblNroDocumento.setText("RUC");
            habilitarTextos(true);
        } else {
            lblCliente.setText("NOMBRE");
            lblNroDocumento.setText("DNI");
            habilitarTextos(false);
        }
    }//GEN-LAST:event_cboComprobanteActionPerformed
    private int getNuevoCodigo() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        int cod = 0;
        try {
            obj = sqlMapClient.queryForObject("getMaxProducto");
        } catch (SQLException ex) {
            Logger.getLogger(FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (obj != null) {
            cod = ((Integer) obj).intValue();
        }
        return cod + 1;
    }    private void agregarVenta() {
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
        /*   vnt.setUsuario_codUsu(txtDireccion.getText());
         vnt.setCliente_codCli(txtTelefono.getText());*/


        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {

            sqlMapClient.insert("insertVentas", vnt);
        } catch (SQLException ex) {
            Logger.getLogger(FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void txtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsultarActionPerformed
        dcli = new FormBuscarCliente();
        dcli.setVisible(true);
    }//GEN-LAST:event_txtConsultarActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
   }//GEN-LAST:event_btnVenderActionPerformed

    private void txtCodigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoClienteActionPerformed

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed
        dp = new FormDetalleVenta();
        dp.setVisible(true);
    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    }//GEN-LAST:event_btnEliminarActionPerformed
    private void habilitarTextos(boolean b) {
        lblIgv.setVisible(b);
        lblSubTotal.setVisible(b);
        txtSubTotal.setVisible(b);
        txtIgv.setVisible(b);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVender;
    private javax.swing.JComboBox cboComprobante;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIgv;
    private javax.swing.JLabel lblNroComprobante;
    private javax.swing.JLabel lblNroDocumento;
    private javax.swing.JLabel lblNroVenta;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblusuario;
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
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
