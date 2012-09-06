package sigevi.gui;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import sigevi.bea.Producto;
import sigevi.map.SqlMapConfig;
import sigevi.uti.ButtonService;
import sigevi.uti.TableService;

/**
 *
 * @author SIMONETTA
 */
public class NewJFrame extends javax.swing.JFrame {

    

    public NewJFrame() {
        initComponents();
       AutoCompleteDecorator.decorate(jComboBox1); 
        MyTable();
    }

    public void MyTable() {
        JComboBox categorias = new JComboBox(cargarProductos());
        AutoCompleteDecorator.decorate(categorias);
        String[] columnNames = new String[]{"Nombre", "CANTIDAD", "Fumador", "Nacionalidad", ""};
        Object[][] data = new Object[][]{
                                        {"PIEDRA", "", false, "", new JButton("Reset")},
                                        {"PAPEL", "", false, "", new JButton("Reset")},
                                        {"TIJERA", "", false, "", new JButton("Reset")}
                                        };

        TableService model = new TableService(columnNames, data) {};
        // Establecemos el modelo
        tabla.setModel(model);
        // Establecemos el renderer y editor que usaremos para el boton
        tabla.setDefaultRenderer(JButton.class, new ButtonService());
        tabla.setDefaultEditor(JButton.class, new ButtonService());
        // Editores para cada tipo de objeto, estos nos permitirán darles el comportamiento adecuado
        tabla.getColumn("Nacionalidad").setCellEditor(new DefaultCellEditor(categorias));
        tabla.setDefaultEditor(JCheckBox.class, new DefaultCellEditor(new JCheckBox()));
    }

    private Vector cargarProductos() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Producto> categorias = new ArrayList<>();
        Vector vector = new Vector();
        try {
            categorias = sqlMapClient.queryForList("listProducto", null);
        } catch (SQLException ex) {
            Logger.getLogger(FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < categorias.size(); i++) {
            Producto per = categorias.get(i);
            jComboBox1.addItem(per.getNomPro());
            vector.add(per.getNomPro());
        }
        return vector;
    }

    static Vector toArrayList(ArrayList al) {
        return new Vector(al);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tabla);
        tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton1.setText("OBTENER PRECIO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int fila = this.tabla.getSelectedRow();
        String dato = String.valueOf(this.tabla.getValueAt(fila, 1));
        System.out.println("dato:::::::::::" + dato);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
