package sigevi.gui;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import sigevi.bea.Despacho;
import sigevi.bea.ProductoDespacho;
import sigevi.map.SqlMapConfig;

public class FormProDes extends javax.swing.JFrame {

    DefaultTableModel Modelo;
    String[] Titulo = {"CODIGO", "PRODUCTO", "FORMA DE DESPACHO"};
    String[][] datos = {};
    int codPro = Integer.parseInt(sigevi.gui.FormProducto.txtCodigo.getText());

    public FormProDes() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtCodPro.setText(codPro + "");
        txtNomPro.setText(sigevi.gui.FormProducto.getProducto(codPro).getNomPro());
        Modelo = new DefaultTableModel(datos, Titulo);
        tblProductoDespacho.setModel(Modelo);
        listarDespachosDeProducto(codPro);
        cargarDespachos();
        AutoCompleteDecorator.decorate(this.cboFormaDespacho);
    }

    private int getNuevoCodigo() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        int cod = 0;
        try {
            obj = sqlMapClient.queryForObject("getMaxProductoDespacho");
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (obj != null) {
            cod = ((Integer) obj).intValue();
        }
        return cod + 1;
    }

    private boolean getCombinacion(int cod1, int cod2) {
        boolean rsta = false;
        long cmb = cod1 * 100000 + cod2;
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<ProductoDespacho> combinaciones = new ArrayList<>();

        try {
            combinaciones = sqlMapClient.queryForList("getCombinacionDespacho");
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProDes.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < combinaciones.size(); i++) {
            ProductoDespacho com = combinaciones.get(i);
            if (com.getCombinacion() == cmb) {
                rsta = true;
            }
        }
        return rsta;
    }

    private void listarDespachosDeProducto(int codigo) {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<ProductoDespacho> despachos = new ArrayList<>();
        try {
            despachos = sqlMapClient.queryForList("listDespachosDeProducto", codigo);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        Modelo = new DefaultTableModel(datos, Titulo);
        tblProductoDespacho.setModel(Modelo);

        for (int i = 0; i < despachos.size(); i++) {
            ProductoDespacho des = despachos.get(i);
            Object[] fila = {des.getCodProDes(), des.getNomPro(), des.getNomDes()};
            Modelo.addRow(fila);
        }
    }

    private void agregarProductoDespacho() {
        ProductoDespacho des = new ProductoDespacho();
        des.setCodProDes(getNuevoCodigo());
        des.setProducto_codPro(Integer.parseInt(txtCodPro.getText()));
        des.setDespacho_codDes(cboFormaDespacho.getSelectedIndex());

        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {

            sqlMapClient.insert("insertProductoDespacho", des);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generarProductoDespacho() {
        for (int i = 0; i < 6; i++) {
            ProductoDespacho des = new ProductoDespacho();
            des.setCodProDes(getNuevoCodigo());
            des.setProducto_codPro(Integer.parseInt(txtCodPro.getText()));
            des.setDespacho_codDes(i + 1);

            SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
            try {

                sqlMapClient.insert("insertProductoDespacho", des);
            } catch (SQLException ex) {
                Logger.getLogger(sigevi.gui.FormProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void cargarDespachos() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Despacho> despachos = new ArrayList<>();
        try {
            despachos = sqlMapClient.queryForList("listDespacho", null);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < despachos.size(); i++) {
            Despacho per = despachos.get(i);
            cboFormaDespacho.addItem(per.getNomDes());
        }
    }

    private void eliminarProductoDespacho(int dato) {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {
            sqlMapClient.delete("removeProductoDespacho", dato);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormProPre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodPro = new javax.swing.JTextField();
        lblTitulo1 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductoDespacho = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtNomPro = new javax.swing.JTextField();
        btnCerrar = new javax.swing.JButton();
        cboFormaDespacho = new javax.swing.JComboBox();
        btnCerrar1 = new javax.swing.JButton();

        jLabel1.setText("PRODUCTO :");

        jLabel2.setText("DESPACHO :");

        txtCodPro.setEnabled(false);

        lblTitulo1.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("FORMA DE DESPACHO DEL PRODUCTO");
        lblTitulo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo1.setOpaque(true);

        lblTitulo2.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("LISTA");
        lblTitulo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo2.setOpaque(true);

        tblProductoDespacho.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane1.setViewportView(tblProductoDespacho);

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

        txtNomPro.setEnabled(false);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/close.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        cboFormaDespacho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR DESPACHO" }));

        btnCerrar1.setText("Generar");
        btnCerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrar1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(lblTitulo1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(lblTitulo2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(jLabel2)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(cboFormaDespacho, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(btnAgregar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(btnEliminar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(btnCerrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(btnCerrar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtCodPro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtNomPro)))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(lblTitulo1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(txtCodPro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtNomPro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(cboFormaDespacho, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnCerrar1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnEliminar)
                    .add(btnCerrar)
                    .add(btnAgregar))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblTitulo2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (cboFormaDespacho.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "SELECCIONE UN TIPO DE DESPACHO", "MENSAJE", 2, null);
        }
        if (getCombinacion(Integer.parseInt(txtCodPro.getText()), cboFormaDespacho.getSelectedIndex())) {
            JOptionPane.showMessageDialog(this, "DESPACHO DEL PRODUCTO YA REGISTRADO", "MENSAJE", 0, null);

        } else {
            agregarProductoDespacho();
            listarDespachosDeProducto(Integer.parseInt(txtCodPro.getText()));
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = this.tblProductoDespacho.getSelectedRow();
        if (fila != -1) {
            String dato = String.valueOf(this.tblProductoDespacho.getValueAt(fila, 0));
            eliminarProductoDespacho(Integer.parseInt(dato));
            listarDespachosDeProducto(codPro);
        } else {
            JOptionPane.showMessageDialog(this, "SELECCIONE UN REGISTRO DE LA LISTA", "MENSAJE", 0, null);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnCerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar1ActionPerformed
        generarProductoDespacho();
        listarDespachosDeProducto(codPro);
    }//GEN-LAST:event_btnCerrar1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCerrar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox cboFormaDespacho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JTable tblProductoDespacho;
    private javax.swing.JTextField txtCodPro;
    private javax.swing.JTextField txtNomPro;
    // End of variables declaration//GEN-END:variables
}
