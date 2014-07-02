package sigevi.gui;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import sigevi.bea.Conexion;
import sigevi.bea.Reporte;
import sigevi.map.SqlMapConfig;

public final class FormReporte extends javax.swing.JInternalFrame {
     Conexion con;
    public FormReporte() throws ClassNotFoundException {
        initComponents();
        con=new Conexion();
        setUndecorated(true);
    }

    DefaultTableModel Modelo;
    String[] Titulo = {"CLIENTE", "TIPO", "MONTO"};
    String[][] datos = {};
    protected javax.swing.JDesktopPane m_desktop;
    protected boolean m_undecorated;

    public void setUndecorated(boolean undecorated) {
        if (m_undecorated != undecorated) {
            m_undecorated = undecorated;
            BasicInternalFrameUI bi = (BasicInternalFrameUI) getUI();
            if (undecorated) {
                putClientProperty("titlePane", bi.getNorthPane());
                putClientProperty("border", getBorder());
                bi.setNorthPane(null);
                setBorder(null);
            } else {
                bi.setNorthPane((JComponent) getClientProperty("titlePane"));
                setBorder((Border) getClientProperty("border"));
                putClientProperty("titlePane", null);
                putClientProperty("border", null);
            }
        }
    }
    
      private void listarClientes() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Reporte> reportes = new ArrayList<>();
        try {
            reportes = sqlMapClient.queryForList("sp_ventas_cliente", null);
        } catch (SQLException ex) {
            Logger.getLogger(sigevi.gui.FormCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        Modelo = new DefaultTableModel(datos, Titulo);
        tblCliente.setModel(Modelo);

        for (Reporte rpt : reportes) {
            Object[] fila = {rpt.getCli(), rpt.getTip(), rpt.getMon()};
            Modelo.addRow(fila);
        }
    } 

  
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        jToolBar = new javax.swing.JToolBar();
        btnListar = new javax.swing.JButton();
        btnListar1 = new javax.swing.JButton();
        btnListar3 = new javax.swing.JButton();
        btnListar4 = new javax.swing.JButton();
        btnListar5 = new javax.swing.JButton();
        btnListar6 = new javax.swing.JButton();
        btnListar7 = new javax.swing.JButton();
        btnListar8 = new javax.swing.JButton();
        btnListar9 = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(800, 550));

        lblTitulo2.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("LISTA DE CLIENTES");
        lblTitulo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo2.setOpaque(true);

        tblCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(tblCliente);

        jToolBar.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar.setBorder(null);
        jToolBar.setFloatable(false);
        jToolBar.setName(""); // NOI18N

        btnListar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar.setText("LISTAR");
        btnListar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });
        jToolBar.add(btnListar);

        btnListar1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar1.setText("REPORTE 1");
        btnListar1.setFocusable(false);
        btnListar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar1ActionPerformed(evt);
            }
        });
        jToolBar.add(btnListar1);

        btnListar3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar3.setText("REPORTE 2");
        btnListar3.setFocusable(false);
        btnListar3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar3ActionPerformed(evt);
            }
        });
        jToolBar.add(btnListar3);

        btnListar4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar4.setText("REPORTE 3");
        btnListar4.setFocusable(false);
        btnListar4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar4ActionPerformed(evt);
            }
        });
        jToolBar.add(btnListar4);

        btnListar5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar5.setText("REPORTE 4");
        btnListar5.setFocusable(false);
        btnListar5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar5ActionPerformed(evt);
            }
        });
        jToolBar.add(btnListar5);

        btnListar6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar6.setText("REPORTE 5");
        btnListar6.setFocusable(false);
        btnListar6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar6ActionPerformed(evt);
            }
        });
        jToolBar.add(btnListar6);

        btnListar7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar7.setText("REPORTE 6");
        btnListar7.setFocusable(false);
        btnListar7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar7ActionPerformed(evt);
            }
        });
        jToolBar.add(btnListar7);

        btnListar8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar8.setText("REPORTE 7");
        btnListar8.setFocusable(false);
        btnListar8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar8ActionPerformed(evt);
            }
        });
        jToolBar.add(btnListar8);

        btnListar9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar9.setText("REPORTE 8");
        btnListar9.setFocusable(false);
        btnListar9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar9ActionPerformed(evt);
            }
        });
        jToolBar.add(btnListar9);

        btnImprimir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/impimir.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
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
        btnSalir.setFocusable(false);
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar.add(btnSalir);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, lblTitulo2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1)
                    .add(jToolBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jToolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(8, 8, 8)
                .add(lblTitulo2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        listarClientes();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            tblCliente.print();
        } catch (PrinterException ex) {
            Logger.getLogger(FormReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnListar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar1ActionPerformed
        insertarCodigo insercod = new insertarCodigo();
        insercod.setVisible(true);   
        //ejecutarSP();
    }//GEN-LAST:event_btnListar1ActionPerformed

    private void btnListar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar3ActionPerformed
         try {
             con.pVentacliente();
         } catch (SQLException ex) {
             Logger.getLogger(FormReporte.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btnListar3ActionPerformed

    private void btnListar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListar4ActionPerformed

    private void btnListar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListar5ActionPerformed

    private void btnListar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListar6ActionPerformed

    private void btnListar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListar7ActionPerformed

    private void btnListar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListar8ActionPerformed

    private void btnListar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListar9ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnListar1;
    private javax.swing.JButton btnListar3;
    private javax.swing.JButton btnListar4;
    private javax.swing.JButton btnListar5;
    private javax.swing.JButton btnListar6;
    private javax.swing.JButton btnListar7;
    private javax.swing.JButton btnListar8;
    private javax.swing.JButton btnListar9;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JTable tblCliente;
    // End of variables declaration//GEN-END:variables
}
