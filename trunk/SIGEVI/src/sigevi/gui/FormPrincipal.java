package sigevi.gui;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FormPrincipal extends javax.swing.JFrame {

    private FormProducto producto;
    private FormUsuario usuario;
    private FormMedida medida;
    private FormCategoria categoria;
    private FormCliente cliente;
    private FormVenta venta;
    private FormCompra compra;
    private FormProveedor proveedor;
    private FormInicio inicio;
    private FormDespacho precio;

    public FormPrincipal() {
        super();

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
           // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        initComponents();
        inicio = new FormInicio();
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.add(inicio);
        this.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        mArchivo = new javax.swing.JMenu();
        mInicio = new javax.swing.JMenuItem();
        mSalir = new javax.swing.JMenuItem();
        mMantenimiento = new javax.swing.JMenu();
        mUsuarios = new javax.swing.JMenuItem();
        mClientes = new javax.swing.JMenuItem();
        mProveedores = new javax.swing.JMenuItem();
        mProductos = new javax.swing.JMenuItem();
        mCategoria = new javax.swing.JMenuItem();
        mMedida = new javax.swing.JMenuItem();
        mDespacho = new javax.swing.JMenuItem();
        mVentas = new javax.swing.JMenu();
        mOventa = new javax.swing.JMenuItem();
        mCompras = new javax.swing.JMenu();
        mOcompra = new javax.swing.JMenuItem();
        mReportes = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIGEVI: SISTEMA DE GESTIÓN DE VIDRIERIA");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new java.awt.FlowLayout());

        mArchivo.setText("Archivo");

        mInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/ico.png"))); // NOI18N
        mInicio.setText("Inicio");
        mInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mInicioActionPerformed(evt);
            }
        });
        mArchivo.add(mInicio);

        mSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/ico.png"))); // NOI18N
        mSalir.setText("Salir");
        mSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSalirActionPerformed(evt);
            }
        });
        mArchivo.add(mSalir);

        jMenuBar1.add(mArchivo);

        mMantenimiento.setText("Mantenimientos");

        mUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/ico.png"))); // NOI18N
        mUsuarios.setText("Usuarios");
        mUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mUsuariosActionPerformed(evt);
            }
        });
        mMantenimiento.add(mUsuarios);

        mClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/ico.png"))); // NOI18N
        mClientes.setText("Clientes");
        mClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mClientesActionPerformed(evt);
            }
        });
        mMantenimiento.add(mClientes);

        mProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/ico.png"))); // NOI18N
        mProveedores.setText("Proveedores");
        mProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mProveedoresActionPerformed(evt);
            }
        });
        mMantenimiento.add(mProveedores);

        mProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/ico.png"))); // NOI18N
        mProductos.setText("Productos");
        mProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mProductosActionPerformed(evt);
            }
        });
        mMantenimiento.add(mProductos);

        mCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/ico.png"))); // NOI18N
        mCategoria.setText("Categoria");
        mCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCategoriaActionPerformed(evt);
            }
        });
        mMantenimiento.add(mCategoria);

        mMedida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/ico.png"))); // NOI18N
        mMedida.setText("Medidas");
        mMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mMedidaActionPerformed(evt);
            }
        });
        mMantenimiento.add(mMedida);

        mDespacho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/ico.png"))); // NOI18N
        mDespacho.setText("Forma Despacho");
        mDespacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mDespachoActionPerformed(evt);
            }
        });
        mMantenimiento.add(mDespacho);

        jMenuBar1.add(mMantenimiento);

        mVentas.setText("Ventas");

        mOventa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/ico.png"))); // NOI18N
        mOventa.setText("Vender");
        mOventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mOventaActionPerformed(evt);
            }
        });
        mVentas.add(mOventa);

        jMenuBar1.add(mVentas);

        mCompras.setText("Compras");

        mOcompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/ico.png"))); // NOI18N
        mOcompra.setText("Compras");
        mOcompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mOcompraActionPerformed(evt);
            }
        });
        mCompras.add(mOcompra);

        jMenuBar1.add(mCompras);

        mReportes.setText("Reportes");
        jMenuBar1.add(mReportes);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mProductosActionPerformed
        producto = new FormProducto();
        this.getContentPane().removeAll();
        this.getContentPane().add(producto);
        this.pack();
    }//GEN-LAST:event_mProductosActionPerformed

    private void mSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mSalirActionPerformed

    private void mOventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mOventaActionPerformed
        venta = new FormVenta();
        this.getContentPane().removeAll();
        this.getContentPane().add(venta);
        this.pack();
    }//GEN-LAST:event_mOventaActionPerformed

    private void mCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCategoriaActionPerformed
        categoria = new FormCategoria();
        this.getContentPane().removeAll();
        this.getContentPane().add(categoria);
        this.pack();
    }//GEN-LAST:event_mCategoriaActionPerformed

    private void mProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mProveedoresActionPerformed
        proveedor = new FormProveedor();
        this.getContentPane().removeAll();
        this.getContentPane().add(proveedor);
        this.pack();
    }//GEN-LAST:event_mProveedoresActionPerformed

    private void mOcompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mOcompraActionPerformed
        compra = new FormCompra();
        this.getContentPane().removeAll();
        this.getContentPane().add(compra);
        this.pack();
    }//GEN-LAST:event_mOcompraActionPerformed

    private void mClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mClientesActionPerformed
        cliente = new FormCliente();
        this.getContentPane().removeAll();
        this.getContentPane().add(cliente);
        this.pack();
    }//GEN-LAST:event_mClientesActionPerformed

    private void mUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mUsuariosActionPerformed
        usuario = new FormUsuario();
        this.getContentPane().removeAll();
        this.getContentPane().add(usuario);
        this.pack();
    }//GEN-LAST:event_mUsuariosActionPerformed

    private void mInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mInicioActionPerformed
        inicio = new FormInicio();
        this.getContentPane().removeAll();
        this.getContentPane().add(inicio);
        this.pack();
    }//GEN-LAST:event_mInicioActionPerformed

    private void mMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mMedidaActionPerformed
        medida = new FormMedida();
        this.getContentPane().removeAll();
        this.getContentPane().add(medida);
        this.pack();
    }//GEN-LAST:event_mMedidaActionPerformed

    private void mDespachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mDespachoActionPerformed
        precio = new FormDespacho();
        this.getContentPane().removeAll();
        this.getContentPane().add(precio);
        this.pack();
    }//GEN-LAST:event_mDespachoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mArchivo;
    private javax.swing.JMenuItem mCategoria;
    private javax.swing.JMenuItem mClientes;
    private javax.swing.JMenu mCompras;
    private javax.swing.JMenuItem mDespacho;
    private javax.swing.JMenuItem mInicio;
    private javax.swing.JMenu mMantenimiento;
    private javax.swing.JMenuItem mMedida;
    private javax.swing.JMenuItem mOcompra;
    private javax.swing.JMenuItem mOventa;
    private javax.swing.JMenuItem mProductos;
    private javax.swing.JMenuItem mProveedores;
    private javax.swing.JMenu mReportes;
    private javax.swing.JMenuItem mSalir;
    private javax.swing.JMenuItem mUsuarios;
    private javax.swing.JMenu mVentas;
    // End of variables declaration//GEN-END:variables
}
