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

public class FormDetalleVenta extends javax.swing.JFrame {

    public FormDetalleVenta() {
        this.setLocationRelativeTo(null);
        initComponents();
        listarCategorias();
        autocompletarBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        btnAgregarDetalle = new javax.swing.JButton();
        lblCategoria = new javax.swing.JLabel();
        lblProducto = new javax.swing.JLabel();
        lblMedida = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        cboCategoria = new javax.swing.JComboBox();
        lblTipoVenta = new javax.swing.JLabel();
        lblAncho = new javax.swing.JLabel();
        lblLargo = new javax.swing.JLabel();
        cboProducto = new javax.swing.JComboBox();
        cboDespacho = new javax.swing.JComboBox();
        txtStock = new javax.swing.JTextField();
        cboMedida = new javax.swing.JComboBox();
        txtPies = new javax.swing.JLabel();
        txtSugerido = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JLabel();
        txtAncho = new javax.swing.JTextField();
        txtLargo = new javax.swing.JTextField();
        txtPie = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        cboCodPro = new javax.swing.JComboBox();
        cboCodMed = new javax.swing.JComboBox();
        cboCodDes = new javax.swing.JComboBox();
        txtPrecio = new javax.swing.JTextField();

        jButton4.setText("jButton4");

        btnAgregarDetalle.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAgregarDetalle.setText("AGREGAR A LA VENTA");

        lblCategoria.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblCategoria.setText("CATEGORIA:");

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
        cboProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR" }));
        cboProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductoActionPerformed(evt);
            }
        });

        cboDespacho.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cboDespacho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR" }));
        cboDespacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDespachoActionPerformed(evt);
            }
        });

        txtStock.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        cboMedida.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cboMedida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR" }));
        cboMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMedidaActionPerformed(evt);
            }
        });

        txtPies.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtPies.setText("PIE CUADRADO:");

        txtSugerido.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtSugerido.setText("PRECIO SUGERIDO:");

        txtPrecioVenta.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtPrecioVenta.setText("PRECIO VENTA:");

        txtAncho.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtLargo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtPie.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        cboCodPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pro" }));

        cboCodMed.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "med" }));

        cboCodDes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "des" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSugerido)
                                .addComponent(txtPies, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblLargo, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPrecioVenta)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cboCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboCodMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lblCategoria, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTipoVenta, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblProducto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMedida, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblStock, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAncho, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboDespacho, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboMedida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboCategoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAncho, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPie, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLargo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboCodDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMedida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDespacho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAncho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLargo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPies))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSugerido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarDetalle)
                    .addComponent(cboCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCodMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboCodDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void autocompletarBox() {
        AutoCompleteDecorator.decorate(this.cboCategoria);
        AutoCompleteDecorator.decorate(this.cboMedida);
        AutoCompleteDecorator.decorate(this.cboProducto);
        AutoCompleteDecorator.decorate(this.cboDespacho);
    }

    private void listarCategorias() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Categoria> categorias = new ArrayList<>();
        try {
            categorias = sqlMapClient.queryForList("listCategoria", null);
        } catch (SQLException ex) {
            Logger.getLogger(FormDetalleVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < categorias.size(); i++) {
            Categoria cat = categorias.get(i);
            cboCategoria.addItem(cat.getNomCat());
        }
    }
    
    private double getStockProducto(int codigo){
        Producto producto = new Producto();
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        try {
            obj = sqlMapClient.queryForObject("getProducto", codigo);
        } catch (SQLException ex) {
            Logger.getLogger(FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        producto = ((Producto) obj);
        return producto.getStoPro();
    }
    private void listarProductosDeCategoria(int codCat) {
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
            cboCodPro.addItem(per.getCodPro());
        }
    }

    private void listarMedidasDeProducto(int cod) {
        cboMedida.removeAllItems();
        cboMedida.addItem("ELEGIR");
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<ProductoMedida> productoMedidas = new ArrayList<>();
        try {
            productoMedidas = sqlMapClient.queryForList("listMedidasDeProducto", cod);
        } catch (SQLException ex) {
            Logger.getLogger(FormProMed.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < productoMedidas.size(); i++) {
            ProductoMedida med = productoMedidas.get(i);
            cboMedida.addItem(med.getNomMed());
            cboCodMed.addItem(med.getCodMed());
        }
    }

    private void listarDespachosDeProducto(int cod) {
        cboDespacho.removeAllItems();
        cboDespacho.addItem("ELEGIR");
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<ProductoDespacho> productoDespachos = new ArrayList<>();
        try {
            productoDespachos = sqlMapClient.queryForList("listDespachosDeProducto", cod);
        } catch (SQLException ex) {
            Logger.getLogger(FormProMed.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < productoDespachos.size(); i++) {
            ProductoDespacho des = productoDespachos.get(i);
            cboDespacho.addItem(des.getNomDes());
            cboCodDes.addItem(des.getCodDes());
        }
    }

    private void cboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoriaActionPerformed
        cboProducto.removeAllItems();
        cboProducto.addItem("ELEGIR");
        listarProductosDeCategoria(cboCategoria.getSelectedIndex());
    }//GEN-LAST:event_cboCategoriaActionPerformed

    private void cboProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductoActionPerformed
         if (cboProducto.getSelectedIndex() != -1) {
             if (!cboProducto.getSelectedItem().toString().equals("ELEGIR")) {
                cboCodPro.setSelectedIndex(cboProducto.getSelectedIndex());
                txtStock.setText(""+getStockProducto(((Integer) cboCodPro.getSelectedItem()).intValue()));
               listarMedidasDeProducto(((Integer) cboCodPro.getSelectedItem()).intValue());
                listarDespachosDeProducto(((Integer) cboCodPro.getSelectedItem()).intValue());
             }
             else {
                 txtStock.setText("");
             }
         }
    }//GEN-LAST:event_cboProductoActionPerformed

    private void cboMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMedidaActionPerformed
        if (cboMedida.getSelectedIndex() != -1) {
            cboCodMed.setSelectedIndex(cboMedida.getSelectedIndex());
        }
    }//GEN-LAST:event_cboMedidaActionPerformed

    private void cboDespachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDespachoActionPerformed
        if (cboDespacho.getSelectedIndex() != -1) {
            cboCodDes.setSelectedIndex(cboDespacho.getSelectedIndex());
        }
        if (cboDespacho.getSelectedItem().toString().equals("PEDAZO")){
            String medida=cboMedida.getSelectedItem().toString();
            String largo =medida.substring(WIDTH, WIDTH);
        }
    }//GEN-LAST:event_cboDespachoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarDetalle;
    private javax.swing.JComboBox cboCategoria;
    private javax.swing.JComboBox cboCodDes;
    private javax.swing.JComboBox cboCodMed;
    private javax.swing.JComboBox cboCodPro;
    private javax.swing.JComboBox cboDespacho;
    private javax.swing.JComboBox cboMedida;
    private javax.swing.JComboBox cboProducto;
    private javax.swing.JButton jButton4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lblAncho;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblLargo;
    private javax.swing.JLabel lblMedida;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTipoVenta;
    private javax.swing.JTextField txtAncho;
    private javax.swing.JTextField txtLargo;
    private javax.swing.JTextField txtPie;
    private javax.swing.JLabel txtPies;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JLabel txtPrecioVenta;
    private javax.swing.JTextField txtStock;
    private javax.swing.JLabel txtSugerido;
    // End of variables declaration//GEN-END:variables
}
