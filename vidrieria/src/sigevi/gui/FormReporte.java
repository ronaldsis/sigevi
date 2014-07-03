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

        for (Reporte rpt : reportes) {
            Object[] fila = {rpt.getCli(), rpt.getTip(), rpt.getMon()};
            Modelo.addRow(fila);
        }
    } 

  
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo2 = new javax.swing.JLabel();
        jToolBar = new javax.swing.JToolBar();
        btnListar1 = new javax.swing.JButton();
        btnListar3 = new javax.swing.JButton();
        btnListar4 = new javax.swing.JButton();
        btnListar5 = new javax.swing.JButton();
        btnListar6 = new javax.swing.JButton();
        btnListar7 = new javax.swing.JButton();
        btnListar8 = new javax.swing.JButton();
        btnListar9 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnListar10 = new javax.swing.JButton();
        btnListar11 = new javax.swing.JButton();
        btnListar13 = new javax.swing.JButton();
        btnListar14 = new javax.swing.JButton();
        btnListar15 = new javax.swing.JButton();
        btnListar16 = new javax.swing.JButton();
        btnListar17 = new javax.swing.JButton();
        btnListar18 = new javax.swing.JButton();
        btnListar19 = new javax.swing.JButton();
        btnListar20 = new javax.swing.JButton();
        btnListar21 = new javax.swing.JButton();
        btnListar22 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(800, 550));

        lblTitulo2.setBackground(new java.awt.Color(35, 94, 141));
        lblTitulo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("REPORTES");
        lblTitulo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo2.setOpaque(true);

        jToolBar.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar.setBorder(null);
        jToolBar.setFloatable(false);
        jToolBar.setName(""); // NOI18N

        btnListar1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar1.setText("REPORTE DE CLIENTE POR CODIGO");
        btnListar1.setFocusable(false);
        btnListar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar1ActionPerformed(evt);
            }
        });

        btnListar3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar3.setText("REPORTE DE MONTO DE VENTA DE LOS CLIENTES");
        btnListar3.setFocusable(false);
        btnListar3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar3ActionPerformed(evt);
            }
        });

        btnListar4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar4.setText("REPORTE DE PRODUCTOS POR CATEGORIA");
        btnListar4.setFocusable(false);
        btnListar4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar4ActionPerformed(evt);
            }
        });

        btnListar5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar5.setText("REPORTE DE BAJO STOCK");
        btnListar5.setFocusable(false);
        btnListar5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar5ActionPerformed(evt);
            }
        });

        btnListar6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar6.setText("REPORTE DE SOBRESTOCK");
        btnListar6.setFocusable(false);
        btnListar6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar6ActionPerformed(evt);
            }
        });

        btnListar7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar7.setText("REPORTE PRODUCTOS POR PROVEEDOR");
        btnListar7.setFocusable(false);
        btnListar7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar7ActionPerformed(evt);
            }
        });

        btnListar8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar8.setText("REPORTE DE PROVEEDOR POR CODIGO");
        btnListar8.setFocusable(false);
        btnListar8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar8ActionPerformed(evt);
            }
        });

        btnListar9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar9.setText("REPORTE DE CLIENTES POR TIPO");
        btnListar9.setFocusable(false);
        btnListar9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar9ActionPerformed(evt);
            }
        });

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

        btnListar10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar10.setText("REPORTE CLIENTES");
        btnListar10.setFocusable(false);
        btnListar10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar10ActionPerformed(evt);
            }
        });

        btnListar11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar11.setText("REPORTE DE PRODUCTOS");
        btnListar11.setFocusable(false);
        btnListar11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar11ActionPerformed(evt);
            }
        });

        btnListar13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar13.setText("REPORTE PROVEEDORES");
        btnListar13.setFocusable(false);
        btnListar13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar13ActionPerformed(evt);
            }
        });

        btnListar14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar14.setText("REPORTE DE USUARIOS");
        btnListar14.setFocusable(false);
        btnListar14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar14ActionPerformed(evt);
            }
        });

        btnListar15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar15.setText("Producto con menor venta");
        btnListar15.setFocusable(false);
        btnListar15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar15ActionPerformed(evt);
            }
        });

        btnListar16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar16.setText("GANANCIA POR PRODUCTO");
        btnListar16.setFocusable(false);
        btnListar16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar16ActionPerformed(evt);
            }
        });

        btnListar17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar17.setText("Producto con mayor venta");
        btnListar17.setFocusable(false);
        btnListar17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar17.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar17ActionPerformed(evt);
            }
        });

        btnListar18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar18.setText("COMPRAS ENTRE FECHAS");
        btnListar18.setFocusable(false);
        btnListar18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar18.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar18ActionPerformed(evt);
            }
        });

        btnListar19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar19.setText("R19");
        btnListar19.setFocusable(false);
        btnListar19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar19.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar19ActionPerformed(evt);
            }
        });

        btnListar20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar20.setText("R16");
        btnListar20.setFocusable(false);
        btnListar20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar20.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar20ActionPerformed(evt);
            }
        });

        btnListar21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar21.setText("VENTAS ENTRE FECHAS");
        btnListar21.setFocusable(false);
        btnListar21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar21.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar21ActionPerformed(evt);
            }
        });

        btnListar22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnListar22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/listar.png"))); // NOI18N
        btnListar22.setText("R20");
        btnListar22.setFocusable(false);
        btnListar22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar22.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar22ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(lblTitulo2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 845, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(24, 24, 24)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(btnListar14)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(btnListar16))
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                            .add(btnListar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 275, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                                .add(btnListar7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(btnListar4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .add(18, 18, 18)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                            .add(layout.createSequentialGroup()
                                                .add(btnListar8)
                                                .add(27, 27, 27)
                                                .add(btnSalir, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .add(layout.createSequentialGroup()
                                                .add(btnListar5)
                                                .add(18, 18, 18)
                                                .add(btnListar6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .add(layout.createSequentialGroup()
                                                .add(btnListar9)
                                                .add(18, 18, 18)
                                                .add(btnListar10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 151, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                    .add(layout.createSequentialGroup()
                                        .add(btnListar3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 315, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(btnListar11)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(btnListar13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 171, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .add(0, 0, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(layout.createSequentialGroup()
                                        .add(9, 9, 9)
                                        .add(btnListar19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 222, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(btnListar22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 237, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .add(layout.createSequentialGroup()
                                        .add(btnListar17)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(btnListar15)
                                        .add(18, 18, 18)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                            .add(btnListar21, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(btnListar18, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                                        .add(172, 172, 172)))
                                .add(btnListar20))))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jToolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jToolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(lblTitulo2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(0, 0, Short.MAX_VALUE)
                                .add(btnSalir))
                            .add(layout.createSequentialGroup()
                                .add(btnListar8)
                                .add(0, 0, Short.MAX_VALUE))))
                    .add(layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(btnListar1)))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnListar4)
                    .add(btnListar5)
                    .add(btnListar6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnListar7)
                    .add(btnListar9)
                    .add(btnListar10))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnListar11)
                    .add(btnListar3)
                    .add(btnListar13))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(btnListar14)
                            .add(btnListar16))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(btnListar20)
                            .add(btnListar17)
                            .add(btnListar18)
                            .add(btnListar15)))
                    .add(btnListar21))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(btnListar19)
                    .add(btnListar22))
                .add(83, 83, 83))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnListar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar1ActionPerformed
        insertarCodigoCliente insercod = new insertarCodigoCliente();
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
       seleccionarNombreCategoria insercod = new seleccionarNombreCategoria();
        insercod.setVisible(true); 
    }//GEN-LAST:event_btnListar4ActionPerformed

    private void btnListar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar5ActionPerformed
        insertarStockBajo insercod = new insertarStockBajo();
        insercod.setVisible(true);
    }//GEN-LAST:event_btnListar5ActionPerformed

    private void btnListar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar6ActionPerformed
      insertarStockAlto insercod = new insertarStockAlto();
        insercod.setVisible(true);
    }//GEN-LAST:event_btnListar6ActionPerformed

    private void btnListar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar7ActionPerformed
      selecionarNombreProveedor insercod = new selecionarNombreProveedor();
        insercod.setVisible(true); 
    }//GEN-LAST:event_btnListar7ActionPerformed

    private void btnListar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar8ActionPerformed
        insertarCodigoProveedor insercod = new insertarCodigoProveedor();
        insercod.setVisible(true); 
    }//GEN-LAST:event_btnListar8ActionPerformed

    private void btnListar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar9ActionPerformed
    insertarTipoCliente insercod = new insertarTipoCliente();
        insercod.setVisible(true); 
    }//GEN-LAST:event_btnListar9ActionPerformed

    private void btnListar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar10ActionPerformed
              try {
             con.pReporteCliente();
         } catch (SQLException ex) {
             Logger.getLogger(FormReporte.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btnListar10ActionPerformed

    private void btnListar11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar11ActionPerformed
               try {
             con.pReporteProducto();
         } catch (SQLException ex) {
             Logger.getLogger(FormReporte.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btnListar11ActionPerformed

    private void btnListar13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar13ActionPerformed
                try {
             con.pReporteProveedor();
         } catch (SQLException ex) {
             Logger.getLogger(FormReporte.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btnListar13ActionPerformed

    private void btnListar14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar14ActionPerformed
              try {
             con.pReporteUsuario();
         } catch (SQLException ex) {
             Logger.getLogger(FormReporte.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btnListar14ActionPerformed

    private void btnListar15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar15ActionPerformed
         try {
             String reporte=con.pReporteMenorProducto();
             hojaReporte report = new hojaReporte();
                report.texto(reporte);
                
                report.setVisible(true);
                
         } catch (SQLException ex) {
             Logger.getLogger(FormReporte.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btnListar15ActionPerformed

    private void btnListar16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar16ActionPerformed
         selecionarNombreProducto insercod = new selecionarNombreProducto();
        insercod.setVisible(true); 
    }//GEN-LAST:event_btnListar16ActionPerformed

    private void btnListar17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar17ActionPerformed
          try {
             String reporte=con.pReporteMayorProducto();
             hojaReporte report = new hojaReporte();
                report.texto(reporte);
                
                report.setVisible(true);
                
         } catch (SQLException ex) {
             Logger.getLogger(FormReporte.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btnListar17ActionPerformed

    private void btnListar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar18ActionPerformed
          insertarFechasCompra insercod = new insertarFechasCompra();
        insercod.setVisible(true);  
    }//GEN-LAST:event_btnListar18ActionPerformed

    private void btnListar19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListar19ActionPerformed

    private void btnListar20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListar20ActionPerformed

    private void btnListar21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar21ActionPerformed
        insertarFechasVenta insercod = new insertarFechasVenta();
        insercod.setVisible(true);   
    }//GEN-LAST:event_btnListar21ActionPerformed

    private void btnListar22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListar22ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListar1;
    private javax.swing.JButton btnListar10;
    private javax.swing.JButton btnListar11;
    private javax.swing.JButton btnListar13;
    private javax.swing.JButton btnListar14;
    private javax.swing.JButton btnListar15;
    private javax.swing.JButton btnListar16;
    private javax.swing.JButton btnListar17;
    private javax.swing.JButton btnListar18;
    private javax.swing.JButton btnListar19;
    private javax.swing.JButton btnListar20;
    private javax.swing.JButton btnListar21;
    private javax.swing.JButton btnListar22;
    private javax.swing.JButton btnListar3;
    private javax.swing.JButton btnListar4;
    private javax.swing.JButton btnListar5;
    private javax.swing.JButton btnListar6;
    private javax.swing.JButton btnListar7;
    private javax.swing.JButton btnListar8;
    private javax.swing.JButton btnListar9;
    private javax.swing.JButton btnSalir;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblTitulo2;
    // End of variables declaration//GEN-END:variables
}
