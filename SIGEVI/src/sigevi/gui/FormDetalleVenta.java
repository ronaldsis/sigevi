/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigevi.gui;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import sigevi.bea.Categoria;
import sigevi.bea.Producto;
import sigevi.bea.ProductoDespacho;
import sigevi.bea.ProductoMedida;
import sigevi.map.SqlMapConfig;

/**
 *
 * @author SIMONETTA
 */
public class FormDetalleVenta extends javax.swing.JFrame {

    /**
     * Creates new form FormDetalleVenta
     */
    public FormDetalleVenta() {
        initComponents();
        cargarCategorias();
        autocompletarBox();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblProducto = new javax.swing.JLabel();
        lblMedida = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        cboCategoria = new javax.swing.JComboBox();
        lblTipoVenta = new javax.swing.JLabel();
        lblAncho = new javax.swing.JLabel();
        lblLargo = new javax.swing.JLabel();
        cboProducto = new javax.swing.JComboBox();
        cboTipoDeVenta = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        cboMedida = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();

        jButton4.setText("jButton4");

        setPreferredSize(null);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton3.setText("CONFIRMAR");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("CATEGORIA:");

        lblProducto.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblProducto.setText("PRODUCTO:");

        lblMedida.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblMedida.setText("MEDIDA:");

        lblStock.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblStock.setText("STOCK:");

        cboCategoria.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR" }));
        cboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoriaActionPerformed(evt);
            }
        });

        lblTipoVenta.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTipoVenta.setText("TIPO DE VENTA:");

        lblAncho.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblAncho.setText("ANCHO:");

        lblLargo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblLargo.setText("LARGO:");

        cboProducto.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cboProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EJEJIR" }));
        cboProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductoActionPerformed(evt);
            }
        });

        cboTipoDeVenta.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cboTipoDeVenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEJIR" }));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        cboMedida.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cboMedida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("PIES:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("PRECIO SUGERIDO:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setText("PRECIO VENTA:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblProducto)
                                            .addComponent(lblMedida))
                                        .addGap(42, 42, 42))
                                    .addComponent(lblStock)
                                    .addComponent(lblTipoVenta)
                                    .addComponent(lblAncho)
                                    .addComponent(lblLargo)
                                    .addComponent(jLabel2))
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cboProducto, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboMedida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboTipoDeVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField2)
                                .addComponent(jTextField6)
                                .addComponent(jTextField5)
                                .addComponent(jTextField4)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblProducto)
                    .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMedida)
                    .addComponent(cboMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTipoDeVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAncho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLargo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void autocompletarBox() {
        AutoCompleteDecorator.decorate(this.cboCategoria);
        AutoCompleteDecorator.decorate(this.cboMedida);
        AutoCompleteDecorator.decorate(this.cboProducto);
        AutoCompleteDecorator.decorate(this.cboTipoDeVenta);
    }

    private void listarProductosXCategoria(int codCat) {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Producto> productos = new ArrayList<>();
        try {
            productos = sqlMapClient.queryForList("listProductoXCategoria", codCat);
        } catch (SQLException ex) {
            Logger.getLogger(FormDetalleVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < productos.size(); i++) {
            Producto per = productos.get(i);
            cboProducto.addItem(per.getNomPro());
        }
    }

    private void listarTipoDeVentaXProducto(int codPro) {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<ProductoDespacho> pd = new ArrayList<>();
        try {
            pd = sqlMapClient.queryForList("listDespachosDeProducto", codPro);
        } catch (SQLException ex) {
            Logger.getLogger(FormDetalleVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < pd.size(); i++) {
            ProductoDespacho per = pd.get(i);
            cboTipoDeVenta.addItem(per.getNomDes());
        }

    }
    private void listarMedidaXProducto(int codPro) {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<ProductoMedida> pm = new ArrayList<>();
        try {
            pm = sqlMapClient.queryForList("listMedidasDeProducto", codPro);
        } catch (SQLException ex) {
            Logger.getLogger(FormDetalleVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < pm.size(); i++) {
            ProductoMedida per = pm.get(i);
            cboTipoDeVenta.addItem(per.getNomMed());
        }

    }

    private void cargarCategorias() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Categoria> categorias = new ArrayList<>();
        try {
            categorias = sqlMapClient.queryForList("listCategoria", null);
        } catch (SQLException ex) {
            Logger.getLogger(FormDetalleVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < categorias.size(); i++) {
            Categoria per = categorias.get(i);
            cboCategoria.addItem(per.getNomCat());
        }
    }
    private void cboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoriaActionPerformed
        cboProducto.removeAllItems();
        cboProducto.addItem("ELEJIR");
        listarProductosXCategoria(cboCategoria.getSelectedIndex());
    }//GEN-LAST:event_cboCategoriaActionPerformed

    private void cboProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductoActionPerformed


        listarTipoDeVentaXProducto(1);
        listarMedidaXProducto(1);


    }//GEN-LAST:event_cboProductoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboCategoria;
    private javax.swing.JComboBox cboMedida;
    private javax.swing.JComboBox cboProducto;
    private javax.swing.JComboBox cboTipoDeVenta;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lblAncho;
    private javax.swing.JLabel lblLargo;
    private javax.swing.JLabel lblMedida;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTipoVenta;
    // End of variables declaration//GEN-END:variables
}
