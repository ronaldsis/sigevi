/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigevi.gui;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author SIMONETTA
 */
public class FormCompra extends javax.swing.JPanel {

    /**
     * Creates new form FormCompra
     */
    public FormCompra() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNroCompra = new javax.swing.JLabel();
        txtNcompra = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        lblProveedor = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox();
        lblRUC = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        lblFormaPago = new javax.swing.JLabel();
        cmbFormaPago = new javax.swing.JComboBox();
        lblTipoComprobante = new javax.swing.JLabel();
        cmbTipoComprobante = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDetalleCompra = new javax.swing.JTable();
        cboCategoriaPro = new javax.swing.JComboBox();
        cboProducto = new javax.swing.JComboBox();
        lblCantidad = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
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

        setPreferredSize(new java.awt.Dimension(800, 500));

        lblNroCompra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNroCompra.setText("COMPRA N° :");

        lblFecha.setText("FECHA :");

        lblProveedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblProveedor.setText("PROVEEDOR :");

        cmbProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELIJA PROVEEDOR" }));
        cmbProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProveedorActionPerformed(evt);
            }
        });

        lblRUC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblRUC.setText("R.U.C :");

        txtRuc.setEditable(false);

        lblFormaPago.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblFormaPago.setText("FORMA DE PAGO :");

        cmbFormaPago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELIJA", "CONTACTO", "CRÉDITO" }));

        lblTipoComprobante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTipoComprobante.setText("TIPO COMPROBANTE :");

        cmbTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELIJA", "BOLETA", "FACTURA", "OTRO" }));

        TablaDetalleCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablaDetalleCompra);

        cboCategoriaPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELIJA CATEGORÍA" }));
        cboCategoriaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoriaProActionPerformed(evt);
            }
        });

        cboProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELIJA PRODUCTO" }));
        cboProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductoActionPerformed(evt);
            }
        });

        lblCantidad.setText("CANTIDAD :");

        lblPrecio.setText("PRECIO :");

        lblStock.setText("STOCK :");

        txtPrecio.setEnabled(false);

        txtStock.setEnabled(false);

        btnAgregarProducto.setText("AGREGAR PRODUCTO");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setText("ELIMINAR PRODUCTO");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        btnRegistrarCompra.setText("REGISTRAR COMPRA");
        btnRegistrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCompraActionPerformed(evt);
            }
        });

        lblSubtotal.setText("SUB TOTAL :");

        lblIgv.setText("I.G.V :");

        lblTotal.setText("TOTAL A PAGAR :");

        lblNroComprobante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(21, 21, 21)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, lblTitulo3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, lblTitulo2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(cboCategoriaPro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(cboProducto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(27, 27, 27)
                                .add(lblPrecio))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblCantidad))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(txtPrecio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(lblStock)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtStock, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(txtCantidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(btnAgregarProducto, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .add(jScrollPane1)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(btnEliminarProducto, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(btnRegistrarCompra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 139, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(lblTotal)
                            .add(lblSubtotal)
                            .add(lblIgv))
                        .add(28, 28, 28)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, txtSubTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(txtTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(txtIgv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, lblTitulo1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(lblProveedor)
                                    .add(lblNroCompra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 75, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(lblRUC))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(layout.createSequentialGroup()
                                        .add(txtNcompra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(51, 51, 51)
                                        .add(lblFecha)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jXDatePicker1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(txtRuc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(cmbProveedor, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .add(51, 51, 51)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(lblTipoComprobante)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(lblFormaPago)
                                        .add(lblNroComprobante)))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(cmbTipoComprobante, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(cmbFormaPago, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(txtNComprobante))))
                        .add(0, 0, Short.MAX_VALUE)))
                .add(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(7, 7, 7)
                .add(lblTitulo1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblNroCompra)
                    .add(txtNcompra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblFecha)
                    .add(lblTipoComprobante)
                    .add(cmbTipoComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXDatePicker1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblProveedor)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(lblNroComprobante)
                        .add(txtNComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(cmbProveedor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(lblRUC)
                        .add(txtRuc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(cmbFormaPago, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(lblFormaPago)))
                .add(20, 20, 20)
                .add(lblTitulo2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cboCategoriaPro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cboProducto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblPrecio)
                    .add(lblStock)
                    .add(txtPrecio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtStock, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(4, 4, 4)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblCantidad)
                    .add(txtCantidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnAgregarProducto))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 31, Short.MAX_VALUE)
                .add(lblTitulo3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 158, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnEliminarProducto)
                    .add(lblSubtotal)
                    .add(txtSubTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnRegistrarCompra)
                    .add(txtIgv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblIgv))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblTotal))
                .add(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProveedorActionPerformed
      
    }//GEN-LAST:event_cmbProveedorActionPerformed

    private void cboCategoriaProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoriaProActionPerformed
    
    }//GEN-LAST:event_cboCategoriaProActionPerformed

    private void cboProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductoActionPerformed
       
    }//GEN-LAST:event_cboProductoActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
      
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnRegistrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCompraActionPerformed
        
    }//GEN-LAST:event_btnRegistrarCompraActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDetalleCompra;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnRegistrarCompra;
    private javax.swing.JComboBox cboCategoriaPro;
    private javax.swing.JComboBox cboProducto;
    private javax.swing.JComboBox cmbFormaPago;
    private javax.swing.JComboBox cmbProveedor;
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
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTipoComprobante;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtNComprobante;
    private javax.swing.JTextField txtNcompra;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}