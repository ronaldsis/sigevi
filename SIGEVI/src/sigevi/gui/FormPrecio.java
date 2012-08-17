package sigevi.gui;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import sigevi.bea.Tipoprecio;
import sigevi.map.SqlMapConfig;

public class FormPrecio extends javax.swing.JPanel {
    
    DefaultListModel modeloLista = new DefaultListModel();
    
    public FormPrecio() {
        initComponents();
        listarPrecios();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        lblTitulo1 = new javax.swing.JLabel();
        jToolBar = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstTipoPrecio = new javax.swing.JList();

        txtNombre.setEnabled(false);

        lblTitulo1.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("MANTENIMIENTO DE TIPO DE PRECIOS");
        lblTitulo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo1.setOpaque(true);

        jToolBar.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar.setBorder(null);
        jToolBar.setFloatable(false);
        jToolBar.setName(""); // NOI18N

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/new.jpg"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setToolTipText("");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar.add(btnNuevo);

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setEnabled(false);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jToolBar.add(btnAgregar);

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jToolBar.add(btnEditar);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar.add(btnEliminar);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/grabar.png"))); // NOI18N
        btnGuardar.setText("Grabar");
        btnGuardar.setEnabled(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar.add(btnGuardar);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/cancelar.jpg"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jToolBar.add(btnCancelar);

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/inicio.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar.add(btnSalir);

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNombre.setText("NOMBRE :");

        lblCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCodigo.setText("CODIGO :");

        lstTipoPrecio.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstTipoPrecioValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstTipoPrecio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 68, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jToolBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                    .addComponent(lblTitulo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private int getNuevoCodigo() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        int cod = 0;
        try {
            obj = sqlMapClient.queryForObject("getMaxPrecio");
        } catch (SQLException ex) {
            Logger.getLogger(FormPrecio.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (obj != null) {
            cod = ((Integer) obj).intValue();
        }
        return cod + 1;
    }
    
    private Tipoprecio getPrecio(int codigo) {
        Tipoprecio precio = new Tipoprecio();
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        try {
            obj = sqlMapClient.queryForObject("getPrecio", codigo);
        } catch (SQLException ex) {
            Logger.getLogger(FormPrecio.class.getName()).log(Level.SEVERE, null, ex);
        }
        precio = ((Tipoprecio) obj);
        return precio;
    }
    
    private void agregarPrecio() {
        Tipoprecio pre = new Tipoprecio();
        pre.setCodPre(Integer.parseInt(txtCodigo.getText()));
        pre.setDesPre(txtNombre.getText().toUpperCase());
        
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {
            
            sqlMapClient.insert("insertPrecio", pre);
        } catch (SQLException ex) {
            Logger.getLogger(FormPrecio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void modificarPrecio() {
        Tipoprecio pre = new Tipoprecio();
        pre = getPrecio(Integer.parseInt(txtCodigo.getText()));
        pre.setDesPre(txtNombre.getText().toUpperCase());
        
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {
            
            sqlMapClient.update("updatePrecio", pre);
        } catch (SQLException ex) {
            Logger.getLogger(FormPrecio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void eliminarPrecio() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {
            sqlMapClient.delete("removePrecio", Integer.parseInt(txtCodigo.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(FormPrecio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void listarPrecios() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Tipoprecio> precios = new ArrayList<>();
        try {
            precios = sqlMapClient.queryForList("listPrecio", null);
        } catch (SQLException ex) {
            Logger.getLogger(FormPrecio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lstTipoPrecio.setModel(modeloLista);
        
        for (int i = 0; i < precios.size(); i++) {
            Tipoprecio pre = precios.get(i);
            String s = pre.getDesPre();
            modeloLista.addElement(s);
        }
    }
    
    private void limpiartextos() {
        txtCodigo.setText("");
        txtNombre.setText("");
    }
    
    private void activartextos(boolean b) {
        txtCodigo.setEnabled(!b);
        txtNombre.setEnabled(b);
    }
    
    private void activarBotones() {
        btnNuevo.setEnabled(true);
        btnAgregar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);
        limpiartextos();
        activartextos(false);
    }
    
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        btnNuevo.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
        limpiartextos();
        activartextos(true);
        txtCodigo.setText(getNuevoCodigo() + "");
    }//GEN-LAST:event_btnNuevoActionPerformed
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "INGRESE NOMBRE DE PRECIO", "MENSAJE", 2, null);
        } else {
            agregarPrecio();
            JOptionPane.showMessageDialog(this, "PRECIO REGISTRADO", "MENSAJE", 1, null);
            listarPrecios();
            activarBotones();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed
        
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        activartextos(true);
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int confirmado = JOptionPane.showConfirmDialog(this, "¿LO CONFIRMAS?", "MENSAJE", 1);
        
        if (JOptionPane.OK_OPTION == confirmado) {
            eliminarPrecio();
            listarPrecios();
            limpiartextos();
            JOptionPane.showMessageDialog(this, "PRECIO ELIMINADO", "MENSAJE", 1, null);
        } else {
            JOptionPane.showMessageDialog(this, "OPERACION CANCELADA", "MENSAJE", 1, null);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "CAMPOS VACÍOS", "MENSAJE", 2, null);
        } else {
            modificarPrecio();
            JOptionPane.showMessageDialog(this, "PRECIO MODIFICADO", "MENSAJE", 1, null);
            listarPrecios();
            activarBotones();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        activarBotones();
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed
    
    private void lstTipoPrecioValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstTipoPrecioValueChanged
        int indice = lstTipoPrecio.getSelectedIndex();
        System.out.println(indice+"");
        Tipoprecio pre = new Tipoprecio();
        pre = getPrecio(indice+1);
        if(indice!=-1){
        txtCodigo.setText(""+pre.getCodPre());
        txtNombre.setText(""+pre.getDesPre());
        }
        else {
            this.modeloLista.clear();
        }
        
    }//GEN-LAST:event_lstTipoPrecioValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JList lstTipoPrecio;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}