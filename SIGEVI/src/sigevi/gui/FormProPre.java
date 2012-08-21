package sigevi.gui;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import sigevi.bea.ProductoDespacho;
import sigevi.bea.ProductoMedida;
import sigevi.bea.ProductoPrecio;
import sigevi.map.SqlMapConfig;

/**
 *
 * @author SIMONETTA
 */
public class FormProPre extends javax.swing.JFrame {

    DefaultTableModel Modelo;
    String[] Titulo = {"CODIGO", "MEDIDA", "FORMA DE DESPACHO", "PRECIO"};
    String[][] datos = {};
    int codPro=Integer.parseInt(FormProducto.txtCodigo.getText());

    public FormProPre() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtProducto.setText(codPro+"");
        listarMedidasDeProducto(codPro);
        listarDespachosDeProducto(codPro);
        listarPreciosDeProducto(codPro);
    }

    private void listarMedidasDeProducto(int cod) {
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

    private void listarPreciosDeProducto(int cod) {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<ProductoPrecio> productoPrecios = new ArrayList<>();
        try {
            productoPrecios = sqlMapClient.queryForList("listPreciosDeProducto", cod);
        } catch (SQLException ex) {
            Logger.getLogger(FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        Modelo = new DefaultTableModel(datos, Titulo);
        tblPreciosDeProducto.setModel(Modelo);

        for (int i = 0; i < productoPrecios.size(); i++) {
            ProductoPrecio pre = productoPrecios.get(i);
            Object[] fila = {pre.getCodProPre(), pre.getNomMed(),pre.getNomDes(),pre.getPrecio()};
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
            Logger.getLogger(FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      private int getNuevoCodigo() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        int cod = 0;
        try {
            obj = sqlMapClient.queryForObject("getMaxProductoPrecio");
        } catch (SQLException ex) {
            Logger.getLogger(FormProPre.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (obj != null) {
            cod = ((Integer) obj).intValue();
        }
        return cod + 1;
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboDespacho = new org.jdesktop.swingx.JXComboBox();
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

        setTitle("SIGEVI");
        setBackground(new java.awt.Color(0, 0, 0));

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

        cboDespacho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR DESPACHO" }));
        cboDespacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDespachoActionPerformed(evt);
            }
        });

        jLabel3.setText("MEDIDA :");

        cboMedida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR MEDIDA" }));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblTitulo3, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboDespacho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboMedida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtProducto))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboCodMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboCodDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCodMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCodDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDespacho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnCerrar))
                .addGap(18, 18, 18)
                .addComponent(lblTitulo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
         this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void cboMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMedidaActionPerformed
        if(cboMedida.getSelectedIndex()!=-1){
            cboCodMed.setSelectedIndex(cboMedida.getSelectedIndex());
        }
    }//GEN-LAST:event_cboMedidaActionPerformed

    private void cboDespachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDespachoActionPerformed
        if(cboDespacho.getSelectedIndex()!=-1){
            cboCodDes.setSelectedIndex(cboDespacho.getSelectedIndex());
        }
    }//GEN-LAST:event_cboDespachoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox cboCodDes;
    private javax.swing.JComboBox cboCodMed;
    private org.jdesktop.swingx.JXComboBox cboDespacho;
    private javax.swing.JComboBox cboMedida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JTable tblPreciosDeProducto;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
