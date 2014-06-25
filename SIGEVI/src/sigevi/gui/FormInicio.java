package sigevi.gui;

import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class FormInicio extends javax.swing.JInternalFrame {

    protected javax.swing.JDesktopPane m_desktop;
    protected boolean m_undecorated;
    private FormProducto producto;
    private FormCliente cliente;
    private FormVenta venta;
    private FormCompra compra;
    private FormProveedor proveedor;
    private FormReporte reporte;

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

    public FormInicio() {
        initComponents();
        setUndecorated(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProducto1 = new javax.swing.JButton();
        btnProducto = new javax.swing.JButton();
        btnCompra = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        brnSistema = new javax.swing.JButton();

        setBackground(new java.awt.Color(35, 94, 141));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnProducto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/inventario.png"))); // NOI18N
        btnProducto1.setText("INVENTARIO");
        btnProducto1.setFocusable(false);
        btnProducto1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProducto1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/producto.png"))); // NOI18N
        btnProducto.setText("PRODUCTOS");
        btnProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProducto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoActionPerformed(evt);
            }
        });

        btnCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/proveedor.png"))); // NOI18N
        btnCompra.setText("COMPRAS");
        btnCompra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompra.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });

        btnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/venta.png"))); // NOI18N
        btnVenta.setText("VENTAS");
        btnVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });

        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/usuario.png"))); // NOI18N
        btnCliente.setText("CLIENTES");
        btnCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/cliente.png"))); // NOI18N
        btnProveedor.setText("PROVEEDORES");
        btnProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProveedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/reporte.png"))); // NOI18N
        btnReporte.setText("REPORTES");
        btnReporte.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReporte.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        brnSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/sistema.png"))); // NOI18N
        brnSistema.setText("SISTEMA");
        brnSistema.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        brnSistema.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVenta)
                    .addComponent(btnCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCompra)
                    .addComponent(btnProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReporte)
                    .addComponent(btnProducto1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(brnSistema)
                    .addComponent(btnProducto))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnProducto1)
                    .addComponent(btnCompra)
                    .addComponent(btnVenta)
                    .addComponent(btnProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCliente)
                    .addComponent(btnProveedor)
                    .addComponent(btnReporte)
                    .addComponent(brnSistema))
                .addContainerGap(298, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        venta = new FormVenta();
        FormPrincipal.escritorio.add(venta);
        venta.show();
    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        proveedor = new FormProveedor();
        FormPrincipal.escritorio.add(proveedor);
        proveedor.show();
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        cliente = new FormCliente();
        FormPrincipal.escritorio.add(cliente);
        cliente.show();
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        compra = new FormCompra();
        FormPrincipal.escritorio.add(compra);
        compra.show();
    }//GEN-LAST:event_btnCompraActionPerformed

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
        producto = new FormProducto();
        FormPrincipal.escritorio.add(producto);
        producto.show();
    }//GEN-LAST:event_btnProductoActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        reporte = new FormReporte();
        FormPrincipal.escritorio.add(reporte);
        reporte.show();
    }//GEN-LAST:event_btnReporteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnSistema;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnCompra;
    private javax.swing.JButton btnProducto;
    private javax.swing.JButton btnProducto1;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnVenta;
    // End of variables declaration//GEN-END:variables
}
