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
import sigevi.bea.*;
import sigevi.map.SqlMapConfig;

public class FormProDes extends javax.swing.JFrame {

    DefaultTableModel Modelo;
    String[] Titulo = {"PRODUCTO", "FORMA DE PAGO"};
    String[][] datos = {};
    int codPro = Integer.parseInt(FormProducto.txtCodigo.getText());

    public FormProDes() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtCodPro.setText(codPro + "");
        txtNomPro.setText(FormProducto.getProducto(codPro).getNomPro());
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
            Logger.getLogger(FormProducto.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FormProDes.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FormProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        Modelo = new DefaultTableModel(datos, Titulo);
        tblProductoDespacho.setModel(Modelo);

        for (int i = 0; i < despachos.size(); i++) {
            ProductoDespacho des = despachos.get(i);
            Object[] fila = {des.getNomPro(), des.getNomDes()};
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
            Logger.getLogger(FormProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarDespachos() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Despacho> despachos = new ArrayList<>();
        try {
            despachos = sqlMapClient.queryForList("listDespacho", null);
        } catch (SQLException ex) {
            Logger.getLogger(FormUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FormProPre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodPro = new javax.swing.JTextField();
        lblTitulo1 = new javax.swing.JLabel();
        lblTitulo3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductoDespacho = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtNomPro = new javax.swing.JTextField();
        btnCerrar = new javax.swing.JButton();
        cboFormaDespacho = new javax.swing.JComboBox();

        setTitle("SIGEVI");
        setBackground(new java.awt.Color(0, 0, 0));

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

        lblTitulo3.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo3.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo3.setText("LISTA");
        lblTitulo3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo3.setOpaque(true);

        tblProductoDespacho.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTitulo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNomPro, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboFormaDespacho, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboFormaDespacho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnCerrar)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(lblTitulo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private javax.swing.JComboBox cboFormaDespacho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JTable tblProductoDespacho;
    private javax.swing.JTextField txtCodPro;
    private javax.swing.JTextField txtNomPro;
    // End of variables declaration//GEN-END:variables
}
