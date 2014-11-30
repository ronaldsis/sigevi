/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacion;

import CAPA.JAVA.BEAN.Proveedor;
import CAPA.JAVA.DAO.ProveedorDao;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrmProveedor extends JPanel implements ActionListener, MouseListener {

    ProveedorDao bdproveedor = new ProveedorDao();
    JButton btnAgregarProveedor, btnMostrarProveedor, btnNuevoProveedor, btnModificarProveedor, btnBuscarProveedor, btnEliminarProveedor, btnCancelarProveedor;
    JTable tabla;
    JScrollPane barra1;
    DefaultTableModel modelo;
    String columnas[] = {"RUC", "RAZON SOCIAL", "DIRECCION", "TELEFONO", "CONTACTO", "EMAIL"};
    String[][] datos = {};
    int i = 0;
    private JLabel lbltitulo, lblRUC, lblRazonSocial, lblEmail, lblContacto, lblDireccion, lblTelefono;
    private JTextField txtRUC, txtRazonSocial, txtEmail, txtContacto, txtDireccion, txtTelefono;

    FrmProveedor() {

        setSize(900, 900);
        setBackground(new Color(128, 128, 128));
        tabla = new JTable();
        modelo = new DefaultTableModel(datos, columnas);
        barra1 = new JScrollPane();
        barra1.setViewportView(tabla);
        tabla.setModel(modelo);
        tabla.addMouseListener(this);
        barra1.setBounds(20, 400, 700, 120);
        add(barra1);

        lbltitulo = new JLabel(" MANTENIMIENTO DEL PROVEEDOR");
        lbltitulo.setFont(new java.awt.Font("Candara", 0, 30));
        lbltitulo.setBounds(50, 20, 500, 30);
        add(lbltitulo);

        lblRUC = new JLabel("RUC : ");
        lblRUC.setBounds(20, 100, 100, 30);
        add(lblRUC);

        txtRUC = new JTextField();
        txtRUC.setBounds(150, 100, 100, 30);
        add(txtRUC);

        btnBuscarProveedor = new JButton("BUSCAR");
        btnBuscarProveedor.setBounds(300, 100, 100, 30);
        add(btnBuscarProveedor);
        btnBuscarProveedor.addActionListener(this);

        lblRazonSocial = new JLabel("Razon Social : ");
        lblRazonSocial.setBounds(20, 150, 100, 30);
        add(lblRazonSocial);

        txtRazonSocial = new JTextField();
        txtRazonSocial.setBounds(150, 150, 250, 30);
        add(txtRazonSocial);
        txtRazonSocial.setEnabled(false);

        lblEmail = new JLabel("Email : ");
        lblEmail.setBounds(20, 200, 100, 30);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 200, 250, 30);
        add(txtEmail);
        txtEmail.setEnabled(false);

        lblContacto = new JLabel("Contacto : ");
        lblContacto.setBounds(20, 250, 100, 30);
        add(lblContacto);

        txtContacto = new JTextField();
        txtContacto.setBounds(150, 250, 250, 30);
        add(txtContacto);
        txtContacto.setEnabled(false);

        lblDireccion = new JLabel("Direccion : ");
        lblDireccion.setBounds(20, 300, 100, 30);
        add(lblDireccion);


        txtDireccion = new JTextField();
        txtDireccion.setBounds(150, 300, 250, 30);
        add(txtDireccion);
        txtDireccion.setEnabled(false);


        lblTelefono = new JLabel("Telefono : ");
        lblTelefono.setBounds(450, 150, 100, 30);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(580, 150, 100, 30);
        add(txtTelefono);
        txtTelefono.setEnabled(false);

        btnAgregarProveedor = new JButton(" AGREGAR  ");
        btnAgregarProveedor.setBounds(140, 350, 100, 30);
        add(btnAgregarProveedor);
        btnAgregarProveedor.addActionListener(this);
        btnAgregarProveedor.setEnabled(false);

        btnNuevoProveedor = new JButton(" NUEVO  ");
        btnNuevoProveedor.setBounds(20, 350, 100, 30);
        add(btnNuevoProveedor);
        btnNuevoProveedor.addActionListener(this);

        btnMostrarProveedor = new JButton(" LISTAR  ");
        btnMostrarProveedor.setBounds(500, 350, 100, 30);
        add(btnMostrarProveedor);
        btnMostrarProveedor.addActionListener(this);

        btnModificarProveedor = new JButton("MODIFICAR");
        btnModificarProveedor.setBounds(260, 350, 100, 30);
        add(btnModificarProveedor);
        btnModificarProveedor.addActionListener(this);
        btnModificarProveedor.setEnabled(false);

        btnEliminarProveedor = new JButton("ELIMINAR");
        btnEliminarProveedor.setBounds(380, 350, 100, 30);
        add(btnEliminarProveedor);
        btnEliminarProveedor.addActionListener(this);
        btnEliminarProveedor.setEnabled(false);

        btnCancelarProveedor = new JButton("CANCELAR");
        btnCancelarProveedor.setBounds(620, 350, 100, 30);
        add(btnCancelarProveedor);
        btnCancelarProveedor.addActionListener(this);

    }

    public void agregar() {
        if (txtRUC.getText().equals("") ||txtRazonSocial.getText().equals("") || txtEmail.getText().equals("") || txtContacto.getText().equals("") || txtDireccion.getText().equals("")) {
            JOptionPane.showMessageDialog(btnAgregarProveedor, "CAMPOS VACIOS");
        } 
        else {
            ProveedorDao objEDAO = new ProveedorDao();
            Proveedor obj = new Proveedor();
            
            int ruc = Integer.parseInt(txtRUC.getText());
            String rs = txtRazonSocial.getText();
            String dir = txtDireccion.getText();
            int tel = Integer.parseInt(txtTelefono.getText());
            String cont = txtContacto.getText();
            String em = txtEmail.getText();

            obj.setRUC(ruc);
            obj.setRaSocial(rs);
            obj.setDireccion(dir);
            obj.setTelefono(tel);
            obj.setContacto(cont);
            obj.setEmail(em);
            
            int estado = objEDAO.Insertar(obj);
            if (tel == 0) {
                JOptionPane.showMessageDialog(btnAgregarProveedor, "El campo debe ser mayor a 0");
            } else {
                bdproveedor.adicionarProveedor(new Proveedor(ruc, rs, dir, tel, cont, em));
                if (estado == 1) {
                    JOptionPane.showMessageDialog(null, "Se Inserto");
                } else {
                    JOptionPane.showMessageDialog(null, "No se Inserto");
                }
                Mostrar();
                limpiarTextos();
            }
        }
    }

    public void Seleccionar() {
        //Aqui creamos variables simples para almacenarlo de los que nos llega de la tabla 
        String ru;
        String ras;
        String di, telf;
        String cont, eml;

        ru = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
        ras = tabla.getValueAt(tabla.getSelectedRow(), 1).toString();
        di = tabla.getValueAt(tabla.getSelectedRow(), 2).toString();
        telf = tabla.getValueAt(tabla.getSelectedRow(), 3).toString();
        cont = tabla.getValueAt(tabla.getSelectedRow(), 4).toString();
        eml = tabla.getValueAt(tabla.getSelectedRow(), 5).toString();
        
        limpiarTextos();
        
        txtRUC.setText(ru);
        txtRazonSocial.setText(ras);
        txtDireccion.setText(di);
        txtTelefono.setText(telf);
        txtContacto.setText(cont);
        txtEmail.setText(eml);
    }

    public void Mostrar() {
        modelo = new DefaultTableModel(datos, columnas);
        tabla.setModel(modelo);
        for (int r = 0; r < bdproveedor.numeroProveedor(); r++) {
            Proveedor dat = bdproveedor.obtenerProveedor(r);
            Object[] fila = {dat.getRUC(), dat.getRaSocial(), dat.getDireccion(), dat.getTelefono(), dat.getContacto(), dat.getEmail()};
            modelo.addRow(fila);
        }
        activarTextos(true);
    //    txtRUC.setEnabled(true);

    }

    public void modificar() {
        int i = 0;
        try {

            if (txtRUC.getText().length() != 0) {

                Proveedor obj_bean = new Proveedor();

                obj_bean.setRUC(Integer.parseInt(txtRUC.getText()));
                obj_bean.setRaSocial(txtRazonSocial.getText());
                obj_bean.setDireccion(txtDireccion.getText());
                obj_bean.setTelefono(Integer.parseInt(txtTelefono.getText()));
                obj_bean.setContacto(txtContacto.getText());
                obj_bean.setEmail(txtEmail.getText());

                ProveedorDao obj_dao = new ProveedorDao();
                i = obj_dao.ModificarDato(obj_bean);
                int ruc1 = Integer.parseInt(txtRUC.getText());
                String rso = txtRazonSocial.getText();
                String direc = txtDireccion.getText();
                int telefo = Integer.parseInt(txtTelefono.getText());
                String contac = txtContacto.getText();
                String emai = txtEmail.getText();
                bdproveedor.modificarProveedor(ruc1, rso, direc, telefo, contac, emai);

                if (i == 1) {

                    JOptionPane.showMessageDialog(null, "Se modifico el dato");

                } else {
                    JOptionPane.showMessageDialog(null, "No Se modifico el dato");

                }

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un registro para modificar");

            }

        } catch (Exception e) {
        }
        limpiarTextos();
        Mostrar();
        btnAgregarProveedor.setEnabled(false);
        btnBuscarProveedor.setEnabled(false);

    }

    public void Eliminar() {
        int i = 0;
        try {

            if (txtRUC.getText().length() != 0) {

                Proveedor productoAeliminar = bdproveedor.buscarProveedor(Integer.parseInt(txtRUC.getText()));
                bdproveedor.eliminarProducto(productoAeliminar);
                Proveedor obj_bean = new Proveedor();
                obj_bean.setRUC(Integer.parseInt(txtRUC.getText()));
                ProveedorDao obj_dao = new ProveedorDao();
                i = obj_dao.Eliminar(obj_bean);

                if (i == 1) {
                    JOptionPane.showMessageDialog(null, "Se Elimino el dato");

                } else {
                    JOptionPane.showMessageDialog(null, "No Se Elimino el dato");

                }

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un registro para Eliminar");

            }
        } catch (Exception e) {
        }
        limpiarTextos();
        Mostrar();
        btnAgregarProveedor.setEnabled(true);

    }

    private void Nuevo() {
        limpiarTextos();
        activarTextos(true);
        btnNuevoProveedor.setEnabled(false);
        btnAgregarProveedor.setEnabled(true);
        btnBuscarProveedor.setEnabled(false);
        btnCancelarProveedor.setEnabled(true);
        btnMostrarProveedor.setEnabled(true);
   //     txtRUC.setText(bdproveedor.nuevoCodigo() + "");
    }

    private void limpiarTextos() {
        txtRUC.setText("");
        txtRazonSocial.setText("");
        txtEmail.setText("");
        txtContacto.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        activarControles();
    }

    private void activarTextos(boolean b) {
        txtRUC.setEnabled(b);
        txtRazonSocial.setEnabled(b);
        txtEmail.setEnabled(b);
        txtContacto.setEnabled(b);
        txtDireccion.setEnabled(b);
        txtTelefono.setEnabled(b);
    }

    private void activarControles() {
       // txtRUC.setEditable(true);
        btnEliminarProveedor.setEnabled(false);
        btnNuevoProveedor.setEnabled(true);
        btnMostrarProveedor.setEnabled(true);
        btnBuscarProveedor.setEnabled(true);
        btnAgregarProveedor.setEnabled(false);
        btnModificarProveedor.setEnabled(false);
    }

    public void Buscar() {
        if (txtRUC.getText().compareTo("") != 0) {
            int result = JOptionPane.showConfirmDialog(
                    this, "¿Deseas Buscar el Producto para Modificarlo?",
                    "Mensaje..!!",
                    JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {

                buscarProducto();
                btnNuevoProveedor.setEnabled(false);
                btnMostrarProveedor.setEnabled(false);
                btnCancelarProveedor.setEnabled(true);
                btnEliminarProveedor.setEnabled(true);
                btnModificarProveedor.setEnabled(true);
                activarTextos(true);
            }
            if (result == JOptionPane.NO_OPTION) {
                buscarProducto();
                btnEliminarProveedor.setEnabled(true);
                btnNuevoProveedor.setEnabled(false);
                btnCancelarProveedor.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese codigo de producto que desee buscar");
        }

    }

    private void buscarProducto() {
        Proveedor p = bdproveedor.buscarProveedor(Integer.parseInt(txtRUC.getText()));
        if (p != null) {
            txtRUC.setText(String.valueOf(p.getRUC()));
            txtRazonSocial.setText(p.getRaSocial());
            txtEmail.setText(String.valueOf(p.getEmail()));
            txtContacto.setText(String.valueOf(p.getContacto()));
            txtDireccion.setText(String.valueOf(p.getDireccion()));
            txtTelefono.setText(String.valueOf(p.getTelefono()));
        } else {
            JOptionPane.showMessageDialog(null, "No exite");
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAgregarProveedor) {
            agregar();
        }

        if (e.getSource() == btnMostrarProveedor) {
            Mostrar();
        }

        if (e.getSource() == btnEliminarProveedor) {
            Eliminar();
        }

        if (e.getSource() == btnModificarProveedor) {
            modificar();
        }

        if (e.getSource() == btnNuevoProveedor) {
            Nuevo();
        }

        if (e.getSource() == btnBuscarProveedor) {
            Buscar();
        }
        if (e.getSource() == btnCancelarProveedor) {
            limpiarTextos();
            activarTextos(false);
         //   txtRUC.setEnabled(true);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tabla) {
            Seleccionar();
            btnModificarProveedor.setEnabled(true);
            btnEliminarProveedor.setEnabled(true);
            btnBuscarProveedor.setEnabled(false);
            btnNuevoProveedor.setEnabled(false);
            activarTextos(true);
       //     txtRUC.setEnabled(true);
        }

    }
  @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}