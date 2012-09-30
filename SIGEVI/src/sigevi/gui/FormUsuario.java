package sigevi.gui;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.awt.print.PrinterException;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import sigevi.bea.Perfil;
import sigevi.bea.Usuario;
import sigevi.map.SqlMapConfig;
import sigevi.uti.Util;

public final class FormUsuario extends javax.swing.JInternalFrame {

    DefaultTableModel Modelo;
    String[] Titulo = {"CODIGO", "LOGIN", "NOMBRES", "APELLIDOS", "PERFIL"};
    String[][] datos = {};

    protected javax.swing.JDesktopPane m_desktop;
    protected boolean m_undecorated;
    
    public void setUndecorated(boolean undecorated) {
        if (m_undecorated != undecorated) {
            m_undecorated = undecorated;
            BasicInternalFrameUI ui = (BasicInternalFrameUI) getUI();
            if (undecorated) {
                putClientProperty("titlePane", ui.getNorthPane());
                putClientProperty("border", getBorder());
                ui.setNorthPane(null);
                setBorder(null);
            } else {
                ui.setNorthPane((JComponent) getClientProperty("titlePane"));
                setBorder((Border) getClientProperty("border"));
                putClientProperty("titlePane", null);
                putClientProperty("border", null);
            }
        }
    }
    
    public FormUsuario() {
        initComponents();
        setUndecorated(true);
    }

    private int getNuevoCodigo() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        int cod = 0;
        try {
            obj = sqlMapClient.queryForObject("getMaxUsuario");
        } catch (SQLException ex) {
            Logger.getLogger(FormUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (obj != null) {
            cod = ((Integer) obj).intValue();
        }
        return cod + 1;
    }

    private String getLogin() {
        if (txtApellido.getText().length() == 4) {
            return txtNombre.getText().substring(0, 1).toLowerCase() + txtApellido.getText().substring(0, 4).toLowerCase();
        }
        if (txtApellido.getText().length() == 3) {
            return txtNombre.getText().substring(0, 1).toLowerCase() + txtApellido.getText().substring(0, 3).toLowerCase();
        }
        if (txtApellido.getText().length() == 2) {
            return txtNombre.getText().substring(0, 1).toLowerCase() + txtApellido.getText().substring(0, 2).toLowerCase();
        } else {
            return txtNombre.getText().substring(0, 1).toLowerCase() + txtApellido.getText().substring(0, 5).toLowerCase();
        }
    }

    private Usuario getUsuario(int codigo) {
        Usuario usuario = new Usuario();
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        try {
            obj = sqlMapClient.queryForObject("getUsuario", codigo);
        } catch (SQLException ex) {
            Logger.getLogger(FormUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        usuario = ((Usuario) obj);
        return usuario;
    }

    private void agregarUsuario() {
        Usuario usu = new Usuario();
        usu.setCodUsu(Integer.parseInt(txtCodigo.getText()));
        usu.setLogUsu(getLogin());
        usu.setApeUsu(txtApellido.getText().toUpperCase());
        usu.setNomUsu(txtNombre.getText().toUpperCase());
        usu.setPasUsu(txtPassU.getText());
        usu.setPerfil_codPer(cboPerfil.getSelectedIndex());

        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {
            sqlMapClient.insert("insertUsuario", usu);
        } catch (SQLException ex) {
            Logger.getLogger(FormUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modificarUsuario() {
        Usuario usu = new Usuario();
        usu = getUsuario(Integer.parseInt(txtCodigo.getText()));
        usu.setLogUsu(getLogin());
        usu.setApeUsu(txtApellido.getText().toUpperCase());
        usu.setNomUsu(txtNombre.getText().toUpperCase());
        usu.setPasUsu(txtPassU.getText());
        usu.setPerfil_codPer(cboPerfil.getSelectedIndex());

        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {

            sqlMapClient.update("updateUsuario", usu);
        } catch (SQLException ex) {
            Logger.getLogger(FormUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarUsuario(int codigo) {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {
            sqlMapClient.delete("removeUsuario", codigo);
        } catch (SQLException ex) {
            Logger.getLogger(FormUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listarUsuarios() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Usuario> usuarios = new ArrayList<>();
        try {
            usuarios = sqlMapClient.queryForList("listUsuario", null);
        } catch (SQLException ex) {
            Logger.getLogger(FormUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        Modelo = new DefaultTableModel(datos, Titulo);
        tblUsuario.setModel(Modelo);

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usu = usuarios.get(i);
            Object[] fila = {usu.getCodUsu(), usu.getLogUsu(), usu.getNomUsu(), usu.getApeUsu(), usu.getNomPer()};
            Modelo.addRow(fila);
        }
    }

    private boolean validarContraseña() {
        if (txtPassU.getText().equals(txtPassU2.getText())) {
            return true;
        } else {
            return false;
        }
    }

    private void cargarPerfiles() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Perfil> perfiles = new ArrayList<>();
        try {
            perfiles = sqlMapClient.queryForList("listPerfil", null);
        } catch (SQLException ex) {
            Logger.getLogger(FormUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < perfiles.size(); i++) {
            Perfil per = perfiles.get(i);
            cboPerfil.addItem(per.getNomPer());
        }
    }

    private void limpiartextos() {
        txtCodigo.setText("");
        txtLogin.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtPassU.setText("");
        txtPassU2.setText("");
        cboPerfil.setSelectedIndex(0);
    }

    private void activartextos(boolean b) {
        txtCodigo.setEnabled(!b);
        txtNombre.setEnabled(b);
        txtApellido.setEnabled(b);
        txtPassU.setEnabled(b);
        txtPassU2.setEnabled(b);
        cboPerfil.setEnabled(b);
    }

    private void activarBotones() {
        btnNuevo.setEnabled(true);
        btnAgregar.setEnabled(false);
        btnBuscar.setEnabled(true);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnListar.setEnabled(true);
        limpiartextos();
        activartextos(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPassU = new javax.swing.JPasswordField();
        txtCodigo = new javax.swing.JTextField();
        lblPerfil = new javax.swing.JLabel();
        lblContrasena = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        cboPerfil = new javax.swing.JComboBox();
        txtPassU2 = new javax.swing.JPasswordField();
        lblContrasena2 = new javax.swing.JLabel();
        jToolBar = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblTitulo2 = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblTitulo1 = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setMinimumSize(new java.awt.Dimension(800, 550));
        setPreferredSize(new java.awt.Dimension(800, 550));

        txtPassU.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtPassU.setEnabled(false);

        lblPerfil.setText("PERFIL :");

        lblContrasena.setText("PASSWORD :");

        lblCodigo.setText("CODIGO :");

        cboPerfil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR PERFIL" }));
        cboPerfil.setEnabled(false);

        txtPassU2.setEnabled(false);

        lblContrasena2.setText("CONFIRMAR PASS :");

        jToolBar.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar.setBorder(null);
        jToolBar.setFloatable(false);
        jToolBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jToolBar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jToolBar.setName(""); // NOI18N

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/nuevo.png"))); // NOI18N
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

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("");
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jToolBar.add(btnBuscar);

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

        btnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar.setText("Listar");
        btnListar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });
        jToolBar.add(btnListar);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jToolBar.add(btnCancelar);

        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/excel.png"))); // NOI18N
        btnExcel.setText("Excel");
        btnExcel.setFocusable(false);
        btnExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });
        jToolBar.add(btnExcel);

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/impimir.png"))); // NOI18N
        btnImprimir.setText("Impirmir");
        btnImprimir.setFocusable(false);
        btnImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jToolBar.add(btnImprimir);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/inicio.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setOpaque(false);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar.add(btnSalir);

        txtNombre.setEnabled(false);

        lblNombre.setText("NOMBRE :");

        tblUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblUsuario);

        lblApellido.setText("APELLIDOS :");

        txtApellido.setEnabled(false);

        lblTitulo2.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("LISTA DE USUARIOS");
        lblTitulo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo2.setOpaque(true);

        lblLogin.setText("LOGIN :");

        txtLogin.setEnabled(false);

        lblTitulo1.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("MANTENIMIENTO DE USUARIOS");
        lblTitulo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo1.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblTitulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblContrasena)
                                        .addComponent(lblPerfil)
                                        .addComponent(lblNombre)
                                        .addComponent(lblCodigo))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtPassU)
                                        .addComponent(txtNombre)
                                        .addComponent(cboPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblApellido)
                                        .addComponent(lblLogin)
                                        .addComponent(lblContrasena2))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtLogin)
                                        .addComponent(txtApellido)
                                        .addComponent(txtPassU2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 161, Short.MAX_VALUE)))
                    .addGap(16, 16, 16)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblTitulo1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblLogin)
                                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblApellido)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblContrasena2)
                                .addComponent(txtPassU2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCodigo))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblNombre)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblContrasena)
                                .addComponent(txtPassU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblPerfil)
                                .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(11, 11, 11)
                    .addComponent(lblTitulo2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addGap(6, 6, 6)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        btnNuevo.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnBuscar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnListar.setEnabled(false);
        limpiartextos();
        activartextos(true);
        txtCodigo.setText(getNuevoCodigo() + "");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtPassU.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "CAMPOS VACÍOS", "MENSAJE", 2, null);
        }
        if (validarContraseña() != true) {
            JOptionPane.showMessageDialog(this, "LAS CONTRASEÑAS NO COINCIDEN", "MENSAJE", 2, null);
        }
        if (cboPerfil.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "SELECCIONE UN PERFIL", "MENSAJE", 2, null);
        } else {
            agregarUsuario();
            JOptionPane.showMessageDialog(this, "USUARIO REGISTRADO, LOGIN: " + getLogin(), "MENSAJE", 1, null);
            listarUsuarios();
            activarBotones();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "INGRESE CÓDIGO", "MENSAJE", 2, null);
        } else {
            Usuario usuario = new Usuario();
            usuario = getUsuario(Integer.parseInt(txtCodigo.getText()));
            if (usuario != null) {
                txtLogin.setText(usuario.getLogUsu());
                txtNombre.setText(usuario.getNomUsu());
                txtApellido.setText(usuario.getApeUsu());
                txtPassU.setText(usuario.getPasUsu());
                txtPassU2.setText(usuario.getPasUsu());
                cboPerfil.setSelectedIndex(usuario.getPerfil_codPer());
            } else {
                JOptionPane.showMessageDialog(this, "USUARIO NO EXISTE", "MENSAJE", 0, null);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        activartextos(true);
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnListar.setEnabled(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int confirmado = JOptionPane.showConfirmDialog(this, "¿LO CONFIRMAS?", "MENSAJE", 1);

        if (JOptionPane.OK_OPTION == confirmado) {
            eliminarUsuario(Integer.parseInt(txtCodigo.getText()));
            listarUsuarios();
            limpiartextos();
            JOptionPane.showMessageDialog(this, "USUARIO ELIMINADO", "MENSAJE", 1, null);
        } else {
            JOptionPane.showMessageDialog(this, "OPERACION CANCELADA", "MENSAJE", 1, null);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtPassU.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "CAMPOS VACÍOS", "MENSAJE", 2, null);
        } else {
            modificarUsuario();
            JOptionPane.showMessageDialog(this, "USUARIO MODIFICADO", "MENSAJE", 1, null);
            listarUsuarios();
            activarBotones();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        listarUsuarios();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        activarBotones();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        try {
            Util exp = new Util();
            String archivo = "D:\\INFO-" + exp.getFecha() + ".xls";
            exp.exportarData(tblUsuario, new File(archivo));
            JOptionPane.showMessageDialog(null, "INFORMACIÓN EXPORTADA A :  "
                    + archivo, " MENSAJE",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnExcelActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            tblUsuario.print();
        } catch (PrinterException ex) {
            Logger.getLogger(FormUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboPerfil;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblContrasena2;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassU;
    private javax.swing.JPasswordField txtPassU2;
    // End of variables declaration//GEN-END:variables
}
