package sigevi.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
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
    private FormReporte reporte;
    private FormProveedor proveedor;
    private FormDespacho precio;
    private FormInicio inicio;

    public FormPrincipal() {
        super();
        estilos();
        initComponents();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        inicio = new FormInicio();
        escritorio.add(inicio);
        inicio.show();
    }

    private void estilos() {
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println("Mensaje: " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
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
        mOcompra1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIGEVI: SISTEMA DE GESTIÓN DE VIDRIERIA");
        setBackground(new java.awt.Color(35, 94, 141));

        escritorio.setBackground(new java.awt.Color(35, 94, 141));

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

        mOcompra1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/ico.png"))); // NOI18N
        mOcompra1.setText("Reportes");
        mOcompra1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mOcompra1ActionPerformed(evt);
            }
        });
        mReportes.add(mOcompra1);

        jMenuBar1.add(mReportes);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(escritorio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 800, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(escritorio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 550, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mProductosActionPerformed
        producto = new FormProducto();
        escritorio.add(producto);
        producto.show();
    }//GEN-LAST:event_mProductosActionPerformed

    private void mSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mSalirActionPerformed

    private void mOventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mOventaActionPerformed
        venta = new FormVenta();
        escritorio.add(venta);
        venta.show();
    }//GEN-LAST:event_mOventaActionPerformed

    private void mCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCategoriaActionPerformed
        categoria = new FormCategoria();
        escritorio.add(categoria);
        categoria.show();
    }//GEN-LAST:event_mCategoriaActionPerformed

    private void mProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mProveedoresActionPerformed
        proveedor = new FormProveedor();
        escritorio.add(proveedor);
        proveedor.show();
    }//GEN-LAST:event_mProveedoresActionPerformed

    private void mOcompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mOcompraActionPerformed
        compra = new FormCompra();
        escritorio.add(compra);
        compra.show();
    }//GEN-LAST:event_mOcompraActionPerformed

    private void mClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mClientesActionPerformed
        cliente = new FormCliente();
        escritorio.add(cliente);
        cliente.show();
    }//GEN-LAST:event_mClientesActionPerformed

    private void mUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mUsuariosActionPerformed
        usuario = new FormUsuario();
        escritorio.add(usuario);
        usuario.show();
    }//GEN-LAST:event_mUsuariosActionPerformed

    private void mInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mInicioActionPerformed
        inicio = new FormInicio();
        escritorio.add(inicio);
        inicio.show();
    }//GEN-LAST:event_mInicioActionPerformed

    private void mMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mMedidaActionPerformed
        medida = new FormMedida();
        escritorio.add(medida);
        medida.show();
    }//GEN-LAST:event_mMedidaActionPerformed

    private void mDespachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mDespachoActionPerformed
        precio = new FormDespacho();
        escritorio.add(precio);
        precio.show();
    }//GEN-LAST:event_mDespachoActionPerformed

    private void mOcompra1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mOcompra1ActionPerformed
        try {
            reporte = new FormReporte();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        escritorio.add(reporte);
        reporte.show();
    }//GEN-LAST:event_mOcompra1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
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
    private javax.swing.JMenuItem mOcompra1;
    private javax.swing.JMenuItem mOventa;
    private javax.swing.JMenuItem mProductos;
    private javax.swing.JMenuItem mProveedores;
    private javax.swing.JMenu mReportes;
    private javax.swing.JMenuItem mSalir;
    public static javax.swing.JMenuItem mUsuarios;
    private javax.swing.JMenu mVentas;
    // End of variables declaration//GEN-END:variables
}
