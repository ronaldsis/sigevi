package sigevi.gui;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sigevi.bea.Venta;
import sigevi.map.SqlMapConfig;

public class FormVenta extends javax.swing.JPanel {

    public FormVenta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jComprobante1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jComprobante2 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNumVenta = new javax.swing.JTextField();
        txtSubTotal = new javax.swing.JTextField();
        lblSubTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleVenta = new javax.swing.JTable();
        cboComprobante = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        btnVender = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtConsultar = new javax.swing.JButton();
        txtAgregarProducto = new javax.swing.JButton();
        lblIgv = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtIgv = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();

        jComprobante1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComprobante1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jComprobante1.setText("Nombre ");

        jComprobante2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComprobante2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jComprobante2.setText("DNI");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Dirrecion");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Nº de venta: ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Fecha:");

        txtNumVenta.setEditable(false);

        txtSubTotal.setEditable(false);

        lblSubTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubTotal.setText("SubTotal :");

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

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Tipo comprobante:");

        btnVender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/calcular.png"))); // NOI18N
        btnVender.setText("Vender");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

        txtFecha.setEditable(false);
        txtFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario");

        txtUsuario.setEditable(false);

        txtConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/buscar.png"))); // NOI18N
        txtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsultarActionPerformed(evt);
            }
        });

        txtAgregarProducto.setText("Agregar Producto");
        txtAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgregarProductoActionPerformed(evt);
            }
        });

        lblIgv.setText("IGV :");

        txtTotal.setEditable(false);

        txtIgv.setEditable(false);

        lblTotal.setText("Total :");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(48, 48, 48)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel12)
                                        .add(48, 48, 48)
                                        .add(txtNumVenta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(jLabel13))
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel18)
                                        .add(18, 18, 18)
                                        .add(cboComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 103, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(54, 54, 54)
                                        .add(jLabel1)))
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(28, 28, 28)
                                        .add(txtUsuario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 108, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(30, 30, 30)
                                        .add(txtFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                            .add(layout.createSequentialGroup()
                                .add(46, 46, 46)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                        .add(jComprobante1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jComprobante2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(jLabel11))
                                .add(28, 28, 28)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(txtDireccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 363, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(layout.createSequentialGroup()
                                        .add(1, 1, 1)
                                        .add(txtNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 242, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(43, 43, 43)
                                        .add(txtConsultar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(txtDni, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 243, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                        .add(10, 10, 10))
                    .add(layout.createSequentialGroup()
                        .add(38, 38, 38)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 475, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtAgregarProducto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 467, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 467, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(42, 42, 42)
                        .add(btnEliminar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnVender)
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(lblIgv)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, lblTotal)
                                .add(lblSubTotal)))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(txtSubTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtIgv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(30, 30, 30)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtNumVenta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(2, 2, 2)
                                .add(jLabel12))))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel13))))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(2, 2, 2)
                                .add(jLabel18))
                            .add(cboComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtUsuario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel1))))
                .add(18, 18, 18)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(3, 3, 3)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jComprobante1)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(txtConsultar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(5, 5, 5))
                            .add(layout.createSequentialGroup()
                                .add(txtNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jComprobante2)
                                    .add(txtDni, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel11)
                    .add(txtDireccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(23, 23, 23)
                .add(txtAgregarProducto)
                .add(28, 28, 28)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 121, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(30, 30, 30)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(btnVender)
                            .add(btnEliminar)))
                    .add(layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblSubTotal)
                            .add(txtSubTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblIgv)
                            .add(txtIgv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblTotal)
                            .add(txtTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(30, 30, 30))
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
            jComprobante1.setText("Razon Social");
            jComprobante2.setText("RUC");
            habilitarTextos(true);
        } else {
            jComprobante1.setText("Nombre");
            jComprobante2.setText("DNI");
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
    }
    private void txtAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgregarProductoActionPerformed
                                                  
        int Fila_Adicionar = tblDetalleVenta.getSelectedRow();
          if (Fila_Adicionar >= 0) {
            campo_Xcodigo.setText(String.valueOf(TablaProductos.getValueAt(Fila_Adicionar, 0)));
            campo_Xnombre.setText(String.valueOf(TablaProductos.getValueAt(Fila_Adicionar, 1)));
            campo_Xstock.setText(String.valueOf(TablaProductos.getValueAt(Fila_Adicionar, 3)));
            campo_Xpreciounit.setText(String.valueOf(TablaProductos.getValueAt(Fila_Adicionar, 2)));
            campo_Xcantidad.setEditable(true);
            campo_Xcantidad.setBackground(Color.white);
        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA!");
        }
       
    }//GEN-LAST:event_txtAgregarProductoActionPerformed
private void agregarVenta() {
        Venta vnt = new Venta();
        vnt.setNroVen(Integer.parseInt(txtNumVenta.getText()));
        vnt.setTipCom((String)cboComprobante.getSelectedItem());
        vnt.setFecVen(txtFecha.getText());
        vnt.setUsuario_codUsu(txtDireccion.getText());
        vnt.setCliente_codCli(txtTelefono.getText());
        

        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {

            sqlMapClient.insert("insertVentas", vnt);
        } catch (SQLException ex) {
            Logger.getLogger(FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void txtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsultarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConsultarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

   }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed

   }//GEN-LAST:event_btnVenderActionPerformed
    private void habilitarTextos(boolean b) {
        lblIgv.setVisible(b);
        lblSubTotal.setVisible(b);
        txtSubTotal.setVisible(b);
        txtIgv.setVisible(b);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVender;
    private javax.swing.JComboBox cboComprobante;
    private javax.swing.JLabel jComprobante1;
    private javax.swing.JLabel jComprobante2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblIgv;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblDetalleVenta;
    private javax.swing.JButton txtAgregarProducto;
    private javax.swing.JButton txtConsultar;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumVenta;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
