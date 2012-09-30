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
import sigevi.bea.Medida;
import sigevi.map.SqlMapConfig;
import sigevi.uti.Util;

public class FormMedida extends javax.swing.JInternalFrame {

    DefaultTableModel Modelo;
    String[] Titulo = {"CODIGO", "NOMBRE", "UNIDAD DE MEDIDA","ANCHO", "LARGO"};
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
        
    public FormMedida() {
        initComponents();
        setUndecorated(true);
    }

    private int getNuevoCodigo() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        int cod = 0;
        try {
            obj = sqlMapClient.queryForObject("getMaxMedida");
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormMedida.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (obj != null) {
            cod = ((Integer) obj).intValue();
        }
        return cod + 1;
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

    private void agregarMedida() {
        Medida med = new Medida();
        med.setCodMed(Integer.parseInt(txtCodigo.getText()));
        med.setNomMed(txtNombre.getText().toUpperCase());
        med.setSimMed(txtSimbolo.getText().toUpperCase());
        
        if(txtLargo.getText().equals("")||txtAncho.getText().equals("")){
           med.setLarMed(0);
            med.setAncMed(0); 
        }
        else{
            med.setLarMed(Integer.parseInt(txtLargo.getText()));
            med.setAncMed(Integer.parseInt(txtAncho.getText()));
        }
            

        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {

            sqlMapClient.insert("insertMedida", med);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormMedida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modificarMedida() {
        Medida med = new Medida();
        med=getMedida(Integer.parseInt(txtCodigo.getText()));
        med.setNomMed(txtNombre.getText().toUpperCase());
        med.setSimMed(txtSimbolo.getText().toUpperCase());
        med.setLarMed(Integer.parseInt(txtLargo.getText()));
        med.setAncMed(Integer.parseInt(txtAncho.getText()));
        
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {

            sqlMapClient.update("updateMedida", med);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormMedida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarMedida() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {
            sqlMapClient.delete("removeMedida", Integer.parseInt(txtCodigo.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormMedida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listarMedidas() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Medida> medidas = new ArrayList<>();
        try {
            medidas = sqlMapClient.queryForList("listMedida", null);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormMedida.class.getName()).log(Level.SEVERE, null, ex);
        }

        Modelo = new DefaultTableModel(datos, Titulo);
        tblMedida.setModel(Modelo);

        for (int i = 0; i < medidas.size(); i++) {
            Medida med = medidas.get(i);
            Object[] fila = {med.getCodMed(),med.getNomMed(),med.getSimMed(),med.getAncMed(),med.getLarMed()};
            Modelo.addRow(fila);
        }
    }

    private void limpiartextos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtSimbolo.setText("");
        txtAncho.setText("");
        txtLargo.setText("");
    }

    private void activartextos(boolean b) {
        txtCodigo.setEnabled(!b);
        txtNombre.setEnabled(b);
        txtSimbolo.setEnabled(b);
        txtAncho.setEnabled(b);
        txtLargo.setEnabled(b);
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

        txtCodigo = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        lblSimbolo = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtSimbolo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedida = new javax.swing.JTable();
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
        lblTitulo1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblAncho = new javax.swing.JLabel();
        lblLargo = new javax.swing.JLabel();
        txtLargo = new javax.swing.JTextField();
        txtAncho = new javax.swing.JTextField();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setMinimumSize(new java.awt.Dimension(800, 550));
        setPreferredSize(new java.awt.Dimension(800, 550));

        lblCodigo.setText("CODIGO :");

        lblSimbolo.setText("SIMBOLO :");

        lblTitulo2.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("LISTA DE MEDIDAS");
        lblTitulo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo2.setOpaque(true);

        lblNombre.setText("NOMBRE :");

        txtSimbolo.setEnabled(false);

        tblMedida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(tblMedida);

        jToolBar.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar.setBorder(null);
        jToolBar.setFloatable(false);
        jToolBar.setName(""); // NOI18N

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        btnListar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        btnExcel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        btnImprimir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        lblTitulo1.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("MANTENIMIENTO DE MEDIDAS");
        lblTitulo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo1.setOpaque(true);

        txtNombre.setEnabled(false);

        lblAncho.setText("ANCHO :");

        lblLargo.setText("LARGO :");

        txtLargo.setEnabled(false);

        txtAncho.setEnabled(false);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 107, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createSequentialGroup()
                                .add(lblNombre)
                                .add(18, 18, 18)
                                .add(txtNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(lblSimbolo)
                                .add(18, 18, 18)
                                .add(txtSimbolo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(lblCodigo)
                                .add(18, 18, 18)
                                .add(txtCodigo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(40, 40, 40)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createSequentialGroup()
                                .add(lblAncho)
                                .add(18, 18, 18)
                                .add(txtAncho, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(lblLargo)
                                .add(18, 18, 18)
                                .add(txtLargo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(254, 254, 254))
                    .add(lblTitulo2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jScrollPane1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, lblTitulo1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jToolBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jToolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblTitulo1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtCodigo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblCodigo))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, lblNombre)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, txtNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(txtAncho, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(lblAncho)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(lblSimbolo)
                    .add(txtSimbolo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(txtLargo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(lblLargo)))
                .add(16, 16, 16)
                .add(lblTitulo2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
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
        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "INGRESE NOMBRE DE MEDIDA", "MENSAJE", 2, null);
        }
        else {
            agregarMedida();
            JOptionPane.showMessageDialog(this, "MEDIDA REGISTRADA", "MENSAJE", 1, null);
            listarMedidas();
            activarBotones();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "INGRESE CÓDIGO", "MENSAJE", 2, null);
        } else {
            Medida medida = new Medida();
            medida = getMedida(Integer.parseInt(txtCodigo.getText()));
            if (medida != null) {

                txtNombre.setText(medida.getNomMed());
                txtLargo.setText(medida.getLarMed()+"");
                txtAncho.setText(medida.getAncMed()+"");
            } else {
                JOptionPane.showMessageDialog(this, "MEDIDA NO EXISTE", "MENSAJE", 0, null);
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
        int confirmado = JOptionPane.showConfirmDialog(this, "¿LO CONFIRMAS?","MENSAJE", 1);

        if (JOptionPane.OK_OPTION == confirmado) {
            eliminarMedida();
            listarMedidas();
            limpiartextos();
            JOptionPane.showMessageDialog(this, "MEDIDA ELIMINADA", "MENSAJE", 1, null);
        } else {
            JOptionPane.showMessageDialog(this, "OPERACION CANCELADA", "MENSAJE", 1, null);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "CAMPOS VACÍOS", "MENSAJE", 2, null);
        } else {
            modificarMedida();
            JOptionPane.showMessageDialog(this, "MEDIDA MODIFICADA", "MENSAJE", 1, null);
            listarMedidas();
            activarBotones();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        listarMedidas();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        activarBotones();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        try {
            Util exp = new Util();
            String archivo="D:\\INFO-"+exp.getFecha()+".xls";
            exp.exportarData(tblMedida, new File(archivo));
            JOptionPane.showMessageDialog(null, "INFORMACIÓN EXPORTADA A :  " +
                archivo, " MENSAJE",
                JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnExcelActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            tblMedida.print();
        } catch (PrinterException ex) {
            Logger.getLogger(FormMedida.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblAncho;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblLargo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSimbolo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JTable tblMedida;
    private javax.swing.JTextField txtAncho;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtLargo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSimbolo;
    // End of variables declaration//GEN-END:variables
}
