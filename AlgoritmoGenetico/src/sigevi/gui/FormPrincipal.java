package sigevi.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FormPrincipal extends javax.swing.JFrame {

  
  
    private FormAlgoritmoGenetico cliente;

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
        mClientes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA DE ALGORITMO GENÉTICO");
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

        mMantenimiento.setText("Algoritmo Gnetico");

        mClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sigevi/img/ico.png"))); // NOI18N
        mClientes.setText("Canbio minimo moneda");
        mClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mClientesActionPerformed(evt);
            }
        });
        mMantenimiento.add(mClientes);

        jMenuBar1.add(mMantenimiento);

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

    private void mSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mSalirActionPerformed

    private void mClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mClientesActionPerformed
        cliente = new FormAlgoritmoGenetico();
        escritorio.add(cliente);
        cliente.show();
    }//GEN-LAST:event_mClientesActionPerformed

    private void mInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mInicioActionPerformed
        inicio = new FormInicio();
        escritorio.add(inicio);
        inicio.show();
    }//GEN-LAST:event_mInicioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mArchivo;
    private javax.swing.JMenuItem mClientes;
    private javax.swing.JMenuItem mInicio;
    private javax.swing.JMenu mMantenimiento;
    private javax.swing.JMenuItem mSalir;
    // End of variables declaration//GEN-END:variables
}
