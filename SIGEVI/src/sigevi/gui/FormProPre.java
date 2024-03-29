package sigevi.gui;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sigevi.bea.ProductoDespacho;
import sigevi.bea.ProductoMedida;
import sigevi.bea.ProductoPrecio;
import sigevi.map.SqlMapConfig;

public class FormProPre extends javax.swing.JFrame {
    
    DefaultTableModel Modelo;
    String[] Titulo = {"CODIGO", "MEDIDA", "DESPACHO", "PRECIO"};
    String[][] datos = {};
    int codPro = Integer.parseInt(sigevi.gui.FormProducto.txtCodigo.getText());
    
    public FormProPre() {
        initComponents();
        this.setLocationRelativeTo(null);
        ocultarCbo();
        txtCodPro.setText(codPro + "");
        txtProducto.setText(sigevi.gui.FormProducto.getProducto(codPro).getNomPro());
        Modelo = new DefaultTableModel(datos, Titulo);
        tblPreciosDeProducto.setModel(Modelo);
        listarMedidasDeProducto(codPro);
        listarDespachosDeProducto(codPro);
        listarPreciosDeProducto(codPro);
    }
    
    private void ocultarCbo() {
        cboCodDes.setVisible(false);
        cboCodMed.setVisible(false);
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
    
    private void listarPreciosDeProducto(int cod) {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<ProductoPrecio> productoPrecios = new ArrayList<>();
        try {
            productoPrecios = sqlMapClient.queryForList("listPreciosDeProducto", cod);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Modelo = new DefaultTableModel(datos, Titulo);
        tblPreciosDeProducto.setModel(Modelo);
        
        for (int i = 0; i < productoPrecios.size(); i++) {
            ProductoPrecio pre = productoPrecios.get(i);
            Object[] fila = {pre.getCodProPre(), pre.getNomMed(), pre.getNomDes(), pre.getPrecio()};
            Modelo.addRow(fila);
        }
    }
    
    private void agregarProductoPrecio() {
        ProductoPrecio pre = new ProductoPrecio();
        pre.setCodProPre(getNuevoCodigo());
        pre.setProducto_codPro(codPro);
        pre.setProducto_despacho_codProDes(((Integer) cboCodDes.getSelectedItem()).intValue());
        pre.setProducto_medida_codProMed(((Integer) cboCodMed.getSelectedItem()).intValue());
        pre.setPrecio(Double.parseDouble(txtPrecio.getText()));
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {
            sqlMapClient.insert("insertProductoPrecio", pre);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void eliminaProductoPrecio(String dato) {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {
            sqlMapClient.delete("removeProductoPrecio", Integer.parseInt(dato));
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProPre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private int getNuevoCodigo() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        int cod = 0;
        try {
            obj = sqlMapClient.queryForObject("getMaxProductoPrecio");
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProPre.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (obj != null) {
            cod = ((Integer) obj).intValue();
        }
        return cod + 1;
    }
    
    private boolean getCombinacion(int cod1, int cod2, int cod3) {
        boolean rsta = false;
        long cmb = cod1 * 100000 + cod2 * 1000 + cod3;
        
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<ProductoPrecio> combinaciones = new ArrayList<>();
        
        try {
            combinaciones = sqlMapClient.queryForList("getCombinacionPrecio");
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProDes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < combinaciones.size(); i++) {
            ProductoPrecio com = combinaciones.get(i);
            if (com.getCombinacion() == cmb) {
                rsta = true;
            }
        }
        return rsta;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodPro = new javax.swing.JTextField();
        lblTitulo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboMedida = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPreciosDeProducto = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblTitulo3 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        cboCodMed = new javax.swing.JComboBox();
        cboCodDes = new javax.swing.JComboBox();
        cboDespacho = new javax.swing.JComboBox();

        txtCodPro.setText("jTextField1");

        lblTitulo1.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("PRECIOS DE PRODUCTO");
        lblTitulo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo1.setOpaque(true);

        jLabel1.setText("PRODUCTO :");

        txtProducto.setEnabled(false);

        jLabel2.setText("DESPACHO :");

        jLabel3.setText("MEDIDA :");

        cboMedida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR MEDIDA" }));
        cboMedida.setMinimumSize(new java.awt.Dimension(117, 20));
        cboMedida.setName(""); // NOI18N
        cboMedida.setPreferredSize(new java.awt.Dimension(117, 20));
        cboMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMedidaActionPerformed(evt);
            }
        });

        tblPreciosDeProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(tblPreciosDeProducto);

        jLabel4.setText("PRECIO :");

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

        lblTitulo3.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo3.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo3.setText("LISTA");
        lblTitulo3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo3.setOpaque(true);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/close.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        cboCodMed.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MED" }));

        cboCodDes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DES" }));

        cboDespacho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR DESPACHO" }));
        cboDespacho.setName(""); // NOI18N
        cboDespacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDespachoActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(lblTitulo1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(lblTitulo3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(btnEliminar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 102, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(jLabel4)
                                    .add(jLabel2))
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(txtPrecio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 127, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createSequentialGroup()
                                        .add(6, 6, 6)
                                        .add(cboDespacho, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel1)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel3))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(txtProducto)
                                    .add(cboMedida, 0, 200, Short.MAX_VALUE))))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(26, 26, 26)
                                .add(btnAgregar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 102, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(cboCodMed, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(cboCodDes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, btnCerrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 102, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(lblTitulo1)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(9, 9, 9)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtProducto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel1)))
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(cboCodDes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(cboCodMed, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAgregar)
                    .add(cboMedida, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(btnEliminar)
                    .add(cboDespacho))
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnCerrar)
                    .add(txtPrecio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblTitulo3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 180, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMedidaActionPerformed
        if (cboMedida.getSelectedIndex() != -1) {
            cboCodMed.setSelectedIndex(cboMedida.getSelectedIndex());
        }
    }//GEN-LAST:event_cboMedidaActionPerformed
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int pro = Integer.parseInt(txtCodPro.getText());
        int med = ((Integer) cboCodMed.getSelectedItem()).intValue();
        int des = ((Integer) cboCodDes.getSelectedItem()).intValue();
        
        if (txtPrecio.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "INGRESE PRECIO", "MENSAJE", 2, null);
        }
        if (getCombinacion(pro, med, des)) {
            JOptionPane.showMessageDialog(this, "PRECIO DEL PRODUCTO YA REGISTRADO", "MENSAJE", 0, null);
        } else {
            agregarProductoPrecio();
            listarPreciosDeProducto(codPro);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = this.tblPreciosDeProducto.getSelectedRow();
        if (fila != -1) {
            String dato = String.valueOf(this.tblPreciosDeProducto.getValueAt(fila, 0));
            eliminaProductoPrecio(dato);
            listarPreciosDeProducto(codPro);
        } else {
            JOptionPane.showMessageDialog(this, "SELECCIONE UN REGISTRO DE LA LISTA", "MENSAJE", 0, null);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed
    
    private void cboDespachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDespachoActionPerformed
        if (cboDespacho.getSelectedIndex() != -1) {
            cboCodDes.setSelectedIndex(cboDespacho.getSelectedIndex());
        }
    }//GEN-LAST:event_cboDespachoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox cboCodDes;
    private javax.swing.JComboBox cboCodMed;
    private javax.swing.JComboBox cboDespacho;
    private javax.swing.JComboBox cboMedida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JTable tblPreciosDeProducto;
    private javax.swing.JTextField txtCodPro;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
