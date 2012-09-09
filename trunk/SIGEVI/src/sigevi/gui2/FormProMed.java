/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigevi.gui2;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sigevi.bea.Medida;
import sigevi.bea.ProductoMedida;
import sigevi.map.SqlMapConfig;

/**
 *
 * @author SIMONETTA
 */
public class FormProMed extends javax.swing.JInternalFrame {

    DefaultTableModel Modelo;
    String[] Titulo = {"CODIGO", "MEDIDA", "SIMBOLO"};
    String[][] datos = {};
    int codPro = Integer.parseInt(sigevi.gui.FormProducto.txtCodigo.getText());
    
    public FormProMed() {
        initComponents();
        txtProducto.setText(codPro + "");
        txtNomPro.setText(sigevi.gui.FormProducto.getProducto(codPro).getNomPro());
        Modelo = new DefaultTableModel(datos, Titulo);
        tblProductoMedidas.setModel(Modelo);
        cargarMedidas();
        listarMedidasDeProducto(codPro);
    }

    private int getNuevoCodigo() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        int cod = 0;
        try {
            obj = sqlMapClient.queryForObject("getMaxProductoMedida");
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (obj != null) {
            cod = ((Integer) obj).intValue();
        }
        return cod + 1;
    }

    private void listarMedidasDeProducto(int cod) {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<ProductoMedida> productoMedidas = new ArrayList<>();
        try {
            productoMedidas = sqlMapClient.queryForList("listMedidasDeProducto", cod);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProMed.class.getName()).log(Level.SEVERE, null, ex);
        }

        Modelo = new DefaultTableModel(datos, Titulo);
        tblProductoMedidas.setModel(Modelo);

        for (int i = 0; i < productoMedidas.size(); i++) {
            ProductoMedida mxp = productoMedidas.get(i);
            Object[] fila = {mxp.getCodProMed(), mxp.getNomMed(), mxp.getSimMed()};
            Modelo.addRow(fila);
        }
    }

    private void agregarProductoMedida() {
        ProductoMedida pro = new ProductoMedida();
        pro.setCodProMed(getNuevoCodigo());
        pro.setProducto_codPro(Integer.parseInt(txtProducto.getText()));
        pro.setMedida_codMed(cboMedida.getSelectedIndex());

        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {

            sqlMapClient.insert("insertProductoMedida", pro);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarMedidas() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Medida> medidas = new ArrayList<>();
        try {
            medidas = sqlMapClient.queryForList("listMedida", null);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < medidas.size(); i++) {
            Medida med = medidas.get(i);
            cboMedida.addItem(med.getNomMed());
        }
    }

    private void eliminarProductoMedida(int dato) {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {
            sqlMapClient.delete("removeProductoMedida", dato);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProPre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean getCombinacion(int cod1, int cod2) {
        boolean rsta = false;
        long cmb = cod1 * 100000 + cod2;
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<ProductoMedida> combinaciones = new ArrayList<>();

        try {
            combinaciones = sqlMapClient.queryForList("getCombinacionMedida");
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProDes.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < combinaciones.size(); i++) {
            ProductoMedida com = combinaciones.get(i);
            if (com.getCombinacion() == cmb) {
                rsta = true;
            }
        }
        return rsta;
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProducto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        cboMedida = new javax.swing.JComboBox();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductoMedidas = new javax.swing.JTable();
        lblTitulo1 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        txtNomPro = new javax.swing.JTextField();

        lblProducto.setText("PRODUCTO :");

        jLabel1.setText("MEDIDA :");

        txtProducto.setEnabled(false);

        cboMedida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR MEDIDA" }));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/add.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblProductoMedidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblProductoMedidas);

        lblTitulo1.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("MEDIDAS DEL PRODUCTO");
        lblTitulo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo1.setOpaque(true);

        lblTitulo2.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("LISTA");
        lblTitulo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo2.setOpaque(true);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/close.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        txtNomPro.setEnabled(false);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(lblTitulo1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .add(lblTitulo2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(lblProducto)
                            .add(jLabel1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(cboMedida, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 131, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(txtProducto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(txtNomPro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 172, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(layout.createSequentialGroup()
                        .add(btnAgregar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(btnEliminar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnCerrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(lblTitulo1)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblProducto)
                    .add(txtProducto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtNomPro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(cboMedida, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAgregar)
                    .add(btnEliminar)
                    .add(btnCerrar))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblTitulo2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (cboMedida.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "SELECCIONE UN TIPO DE MEDIDA", "MENSAJE", 2, null);
        }
        if (getCombinacion(Integer.parseInt(txtProducto.getText()), cboMedida.getSelectedIndex())) {
            JOptionPane.showMessageDialog(this, "MEDIDA DEL PRODUCTO YA REGISTRADA", "MENSAJE", 0, null);
        } else {
            agregarProductoMedida();
            listarMedidasDeProducto(Integer.parseInt(txtProducto.getText()));
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = this.tblProductoMedidas.getSelectedRow();
        if (fila != -1) {
            String dato = String.valueOf(this.tblProductoMedidas.getValueAt(fila, 0));
            eliminarProductoMedida(Integer.parseInt(dato));
            listarMedidasDeProducto(codPro);
        } else {
            JOptionPane.showMessageDialog(this, "SELECCIONE UN REGISTRO DE LA LISTA", "MENSAJE", 0, null);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox cboMedida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JTable tblProductoMedidas;
    private javax.swing.JTextField txtNomPro;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
