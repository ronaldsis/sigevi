package sigevi.gui;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import sigevi.bea.Categoria;
import sigevi.bea.Medida;
import sigevi.bea.Producto;
import sigevi.bea.ProductoDespacho;
import sigevi.bea.ProductoMedida;
import sigevi.bea.ProductoPrecio;
import sigevi.map.SqlMapConfig;

public class FormDetalleVenta extends javax.swing.JFrame {

    public FormDetalleVenta() {
        initComponents();
        listarCategorias();
        autocompletarBox();
    }

 private void autocompletarBox() {
        AutoCompleteDecorator.decorate(this.cboCategoria);
        AutoCompleteDecorator.decorate(this.cboMedida);
        AutoCompleteDecorator.decorate(this.cboProducto);
        AutoCompleteDecorator.decorate(this.cboDespacho);
    }
    
    private void ocultarCbo(){
    cboCodDes.setVisible(false);
         cboCodMed.setVisible(false);
         cboCodPro.setVisible(false);
         txtCodPre.setVisible(false);
    }
    
    private void calcularVentaPie2(){
        int a=Integer.parseInt(txtAncho.getText());
        int b=Integer.parseInt(txtLargo.getText());
        double c=Double.parseDouble(txtPrecioPie.getText());
        DecimalFormat df = new DecimalFormat("##.00");
        txtPrecioSugerido.setText(""+df.format(a*b*c*12/1000));
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
            cboCategoria.addItem(cat.getNomCat());
        }
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

    private ProductoPrecio getProductoPrecio(long cmb) {
        ProductoPrecio pp = new ProductoPrecio();
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        try {
            obj = sqlMapClient.queryForObject("getIdProductoPrecio", cmb);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        pp = ((ProductoPrecio) obj);
        return pp;
    }

    private Medida getMedida(int codigo) {
        Medida medida = new Medida();
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        try {
            obj = sqlMapClient.queryForObject("getMedida", codigo);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormMedida.class.getName()).log(Level.SEVERE, null, ex);
        }
        medida = ((Medida) obj);
        return medida;
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

    private void listarMedidasDeProducto(int cod) {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<ProductoMedida> productoMedidas = new ArrayList<>();
        try {
            productoMedidas = sqlMapClient.queryForList("listMedidasDeProducto", cod);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProMed.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(sigevi.gui.FormProMed.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < productoDespachos.size(); i++) {
            ProductoDespacho des = productoDespachos.get(i);
            cboDespacho.addItem(des.getNomDes());
            cboCodDes.addItem(des.getCodDes());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        lblPieCuadrado = new javax.swing.JLabel();
        lblPrecioSugerido = new javax.swing.JLabel();
        lblPrecioVenta = new javax.swing.JLabel();
        txtAncho = new javax.swing.JTextField();
        txtLargo = new javax.swing.JTextField();
        txtPrecioPie = new javax.swing.JTextField();
        txtPrecioSugerido = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        cboCodPro = new javax.swing.JComboBox();
        cboCodMed = new javax.swing.JComboBox();
        cboCodDes = new javax.swing.JComboBox();
        txtCodPre = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();

        btnAgregarDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/add.png"))); // NOI18N
        btnAgregarDetalle.setText("AGREGAR");
        btnAgregarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDetalleActionPerformed(evt);
            }
        });

        lblCategoria.setText("CATEGORIA:");

        lblProducto.setText("PRODUCTO:");

        lblMedida.setText("MEDIDA:");

        lblStock.setText("STOCK:");

        cboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR" }));
        cboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoriaActionPerformed(evt);
            }
        });

        lblTipoVenta.setText("TIPO DE VENTA:");

        lblAncho.setText("ANCHO:");

        lblLargo.setText("LARGO:");

        cboProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR" }));
        cboProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductoActionPerformed(evt);
            }
        });

        cboDespacho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR" }));
        cboDespacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDespachoActionPerformed(evt);
            }
        });

        cboMedida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR" }));
        cboMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMedidaActionPerformed(evt);
            }
        });

        lblPieCuadrado.setText("PIE2:");

        lblPrecioSugerido.setText("PRECIO SUGERIDO:");

        lblPrecioVenta.setText("PRECIO VENTA:");

        cboCodPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pro" }));

        cboCodMed.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "med" }));
        cboCodMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCodMedActionPerformed(evt);
            }
        });

        cboCodDes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "des" }));

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/limpiar.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(17, 17, 17)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblCategoria)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblTipoVenta)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblProducto)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblMedida)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblStock)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblAncho))
                        .add(10, 10, 10)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(txtStock, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 143, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(cboDespacho, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 143, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, cboMedida, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 143, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, cboCategoria, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 143, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                        .add(txtAncho, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(18, 18, 18)
                                        .add(lblLargo)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(txtLargo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(lblPieCuadrado)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtPrecioPie, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(cboProducto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 222, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(layout.createSequentialGroup()
                            .add(cboCodDes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(txtCodPre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(18, 18, 18)
                            .add(btnLimpiar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(layout.createSequentialGroup()
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout.createSequentialGroup()
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(lblPrecioVenta)
                                        .add(layout.createSequentialGroup()
                                            .add(cboCodPro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(cboCodMed, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                    .add(15, 15, 15))
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                    .add(lblPrecioSugerido)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)))
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(btnAgregarDetalle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 143, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, txtPrecioVenta)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, txtPrecioSugerido)))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblCategoria)
                    .add(cboCategoria, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cboProducto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblProducto))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cboMedida, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblMedida))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cboDespacho, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblTipoVenta))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtStock, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblStock))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtAncho, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblAncho)
                    .add(lblLargo)
                    .add(txtLargo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblPieCuadrado)
                    .add(txtPrecioPie, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtPrecioSugerido, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblPrecioSugerido))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtPrecioVenta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblPrecioVenta))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAgregarDetalle)
                    .add(cboCodPro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cboCodMed, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(cboCodDes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(txtCodPre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(btnLimpiar)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDetalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarDetalleActionPerformed

    private void cboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoriaActionPerformed
        cboProducto.removeAllItems();
        cboProducto.addItem("ELEGIR");
        cboCodPro.removeAllItems();
        cboCodPro.addItem("pro");
        listarProductosDeCategoria(cboCategoria.getSelectedIndex());
    }//GEN-LAST:event_cboCategoriaActionPerformed

    private void cboProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductoActionPerformed
        cboMedida.removeAllItems();
        cboMedida.addItem("ELEGIR");
        if (cboProducto.getSelectedIndex() > 0) {
            cboCodPro.setSelectedIndex(cboProducto.getSelectedIndex());
            String s = cboCodPro.getSelectedItem().toString();
            txtStock.setText("" + getProducto(Integer.parseInt(s)).getStoPro());
            listarMedidasDeProducto(((Integer) cboCodPro.getSelectedItem()).intValue());
            listarDespachosDeProducto(((Integer) cboCodPro.getSelectedItem()).intValue());
        }
    }//GEN-LAST:event_cboProductoActionPerformed

    private void cboDespachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDespachoActionPerformed
        if (cboDespacho.getSelectedIndex() > 0) {
            cboCodDes.setSelectedIndex(cboDespacho.getSelectedIndex());
            if (cboDespacho.getSelectedItem().equals("PIE2")) {
                int pro = ((Integer) cboCodPro.getSelectedItem()).intValue();
                int med = ((Integer) cboCodMed.getSelectedItem()).intValue();
                int des = ((Integer) cboCodDes.getSelectedItem()).intValue();
                long cmb = pro * 100000 + med * 1000 + des;
                System.out.println("com" + cmb);
                txtPrecioPie.setText("" + getProductoPrecio(cmb).getPrecio());
                calcularVentaPie2();
            }
        }
    }//GEN-LAST:event_cboDespachoActionPerformed

    private void cboMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMedidaActionPerformed
        if (cboProducto.getSelectedIndex() > 0) {
            cboCodMed.setSelectedIndex(cboMedida.getSelectedIndex());
        }
    }//GEN-LAST:event_cboMedidaActionPerformed

    private void cboCodMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCodMedActionPerformed
        if (cboCodMed.getSelectedIndex() > 0) {
            String s = cboCodMed.getSelectedItem().toString();
            int cod = Integer.parseInt(s);
            txtAncho.setText(getMedida(cod).getAncMed() + "");
            txtLargo.setText(getMedida(cod).getLarMed() + "");
        }
    }//GEN-LAST:event_cboCodMedActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtStock.setText("");
        txtAncho.setText("");
        txtLargo.setText("");
        cboCategoria.setSelectedIndex(0);
        cboProducto.setSelectedIndex(0);
        cboMedida.setSelectedIndex(0);
        cboDespacho.setSelectedIndex(0);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarDetalle;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox cboCategoria;
    private javax.swing.JComboBox cboCodDes;
    private javax.swing.JComboBox cboCodMed;
    private javax.swing.JComboBox cboCodPro;
    private javax.swing.JComboBox cboDespacho;
    private javax.swing.JComboBox cboMedida;
    private javax.swing.JComboBox cboProducto;
    private javax.swing.JLabel lblAncho;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblLargo;
    private javax.swing.JLabel lblMedida;
    private javax.swing.JLabel lblPieCuadrado;
    private javax.swing.JLabel lblPrecioSugerido;
    private javax.swing.JLabel lblPrecioVenta;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTipoVenta;
    private javax.swing.JTextField txtAncho;
    private javax.swing.JTextField txtCodPre;
    private javax.swing.JTextField txtLargo;
    private javax.swing.JTextField txtPrecioPie;
    private javax.swing.JTextField txtPrecioSugerido;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
