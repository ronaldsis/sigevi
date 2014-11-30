package capaPresentacion;

import CAPA.JAVA.BEAN.Producto;
import CAPA.JAVA.DAO.ProductoDao;
import CAPA.JAVA.UTIL.metodos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Frmproducto extends JPanel implements ActionListener, MouseListener {

    ProductoDao bdproducto = new ProductoDao();
    JButton btnAgregar, btnMostrar, btnNuevo, btnModificar, btnBuscar, btnEliminar, btnCancelar, btnExaminar;
    JTable tabla;
    JScrollPane barra1;
    JPanel imagenProducto;
    DefaultTableModel modelo;
    String columnas[] = {"CODIGO", "NOMBRE", "PRECIO", "STOCK", "CATEGORIA","URL IMAGEN"};
    String[][] datos = {};
    int i = 0;
    JLabel lbltitulo, lblcodigo, lblnombre, lblprecio, lblstock, lblcategoria;
    JTextField txtcodigo, txtnombre, txtprecio, txtstock, txtcategoria;
    metodos m = new metodos() {
    };
    String ImagenURL;
    
    
    Frmproducto() {

        setSize(900, 900);
        setBackground(new Color(255, 0, 255));

        tabla = new JTable();
        modelo = new DefaultTableModel(datos, columnas);
        barra1 = new JScrollPane();
        barra1.setViewportView(tabla);
        tabla.setModel(modelo);
        tabla.addMouseListener(this);
        barra1.setBounds(50, 400, 600, 130);
        add(barra1);

        imagenProducto = new JPanel();
        imagenProducto.setBounds(350, 100, 200, 160);
        add(imagenProducto);
        
        lbltitulo = new JLabel(" MANTENIMIENTO DEL PRODUCTO ");
        lbltitulo.setFont(new java.awt.Font("Candara", 0, 30));
        lbltitulo.setBounds(50, 20, 500, 30);
        add(lbltitulo);

        lblcodigo = new JLabel("Codigo : ");
        lblcodigo.setBounds(50, 100, 100, 30);
        add(lblcodigo);

        txtcodigo = new JTextField();
        txtcodigo.setBounds(200, 100, 100, 30);
        add(txtcodigo);


        lblnombre = new JLabel("Nombre : ");
        lblnombre.setBounds(50, 150, 100, 30);
        add(lblnombre);

        txtnombre = new JTextField();
        txtnombre.setBounds(200, 150, 100, 30);
        add(txtnombre);
        txtnombre.setEnabled(false);

        lblprecio = new JLabel("Precio : ");
        lblprecio.setBounds(50, 200, 100, 30);
        add(lblprecio);

        txtprecio = new JTextField();
        txtprecio.setBounds(200, 200, 100, 30);
        add(txtprecio);
        txtprecio.setEnabled(false);

        lblstock = new JLabel("Stock : ");
        lblstock.setBounds(50, 250, 100, 30);
        add(lblstock);

        txtstock = new JTextField();
        txtstock.setBounds(200, 250, 100, 30);
        add(txtstock);
        txtstock.setEnabled(false);

        lblcategoria = new JLabel("Categoria : ");
        lblcategoria.setBounds(50, 300, 100, 30);
        add(lblcategoria);


        txtcategoria = new JTextField();
        txtcategoria.setBounds(200, 300, 100, 30);
        add(txtcategoria);
        txtcategoria.setEnabled(false);

        btnAgregar = new JButton(" AGREGAR  ");
        btnAgregar.setBounds(710, 350, 100, 30);
        add(btnAgregar);
        btnAgregar.addActionListener(this);
        btnAgregar.setEnabled(false);

        btnNuevo = new JButton(" NUEVO  ");
        btnNuevo.setBounds(50, 350, 100, 30);
        add(btnNuevo);
        btnNuevo.addActionListener(this);

        btnMostrar = new JButton(" LISTAR  ");
        btnMostrar.setBounds(160, 350, 100, 30);
        add(btnMostrar);
        btnMostrar.addActionListener(this);

        btnModificar = new JButton("MODIFICAR");
        btnModificar.setBounds(270, 350, 100, 30);
        add(btnModificar);
        btnModificar.addActionListener(this);
        btnModificar.setEnabled(false);

        btnBuscar = new JButton("BUSCAR");
        btnBuscar.setBounds(380, 350, 100, 30);
        add(btnBuscar);
        btnBuscar.addActionListener(this);

        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(490, 350, 100, 30);
        add(btnEliminar);
        btnEliminar.addActionListener(this);
        btnEliminar.setEnabled(false);

        btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBounds(600, 350, 100, 30);
        add(btnCancelar);
        btnCancelar.addActionListener(this);
        
        btnExaminar = new JButton("EXAMINAR");
        btnExaminar.setBounds(350, 300, 100, 30);
        add(btnExaminar);
        btnExaminar.addActionListener(this);
        btnExaminar.setEnabled(false);

    }
    public void examinar(){
      imagenProducto.removeAll();
            m.Abrir_Dialogo(imagenProducto);
            ImagenURL = m.ObtenerUrl();
}
    public void agregar() {
        if (txtnombre.getText().equals("") || txtprecio.getText().equals("") || txtstock.getText().equals("") || txtcategoria.getText().equals("")) {
            JOptionPane.showMessageDialog(btnAgregar, "CAMPOS VACIOS");
        } else {
            ProductoDao objEDAO = new ProductoDao();
            Producto obj = new Producto();
            int cox = Integer.parseInt(txtcodigo.getText());
            String nomb = txtnombre.getText();
            double prec = Double.parseDouble(txtprecio.getText());
            int sto = Integer.parseInt(txtstock.getText());
            String cate = txtcategoria.getText();
            String ima=m.ObtenerUrl();

            obj.setCodigo(cox);
            obj.setNombre(nomb);
            obj.setPrecio(prec);
            obj.setStock(sto);
            obj.setCategoria(cate);
            obj.setImagen(ima);
            int estado = objEDAO.Insertar(obj);
            
            if (prec == 0 || sto == 0) {
                JOptionPane.showMessageDialog(btnAgregar, "El campo debe ser mayor a 0");
            } else {
                bdproducto.adicionarProducto(new Producto(cox, nomb, prec, sto, cate, ima));
                if (estado == 1) {
                    JOptionPane.showMessageDialog(null, "Se Inserto");
                } else {
                    JOptionPane.showMessageDialog(null, "No se Inserto");
                }
                Mostrar();
                limpiarTextos();
                limpiarImagen();
            }
        }
    }

    public void Seleccionar() {
        
        //Aqui creamos variables simples para almacenarlo de los que nos llega de la tabla 
        String codi;
        String prec;
        String sto, cate,imag;
        String nomb;

        codi = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
        nomb = tabla.getValueAt(tabla.getSelectedRow(), 1).toString();
        prec = tabla.getValueAt(tabla.getSelectedRow(), 2).toString();
        sto = tabla.getValueAt(tabla.getSelectedRow(), 3).toString();
        cate = tabla.getValueAt(tabla.getSelectedRow(), 4).toString();
        imag = tabla.getValueAt(tabla.getSelectedRow(), 5).toString();
       
        limpiarTextos();
        txtcodigo.setText(codi);
        txtnombre.setText(nomb);
        txtprecio.setText(prec);
        txtstock.setText(sto);
        txtcategoria.setText(cate);
        Producto p=bdproducto.buscarProducto(Integer.parseInt(txtcodigo.getText()));
        cargarImagen(p);

    }

    public void Mostrar() {
        modelo = new DefaultTableModel(datos, columnas);
        tabla.setModel(modelo);
        for (int r = 0; r < bdproducto.numeroProductos(); r++) {
            Producto dat = bdproducto.obtenerProducto(r);
            Object[] fila = {dat.getCodigo(), dat.getNombre(), dat.getPrecio(), dat.getStock(), dat.getCategoria(), dat.getImagen()};
            modelo.addRow(fila);
        }
        activarTextos(true);
        txtcodigo.setEnabled(false);

    }

    public void modificar() {
        int i = 0;
        try {

            if (txtcodigo.getText().length() != 0) {

                Producto obj_bean = new Producto();

                obj_bean.setCodigo(Integer.parseInt(txtcodigo.getText()));
                obj_bean.setNombre(txtnombre.getText());
                obj_bean.setPrecio(Double.parseDouble(txtprecio.getText()));
                obj_bean.setStock(Integer.parseInt(txtstock.getText()));
                obj_bean.setCategoria(txtcategoria.getText());
                 obj_bean.setImagen(m.ObtenerUrl());

                ProductoDao obj_dao = new ProductoDao();
                i = obj_dao.ModificarDato(obj_bean);
                int cod = Integer.parseInt(txtcodigo.getText());
                String nom = txtnombre.getText();
                double pre = Double.parseDouble(txtprecio.getText());
                int stock = Integer.parseInt(txtstock.getText());
                String cat = txtcategoria.getText();
                String ima=m.ObtenerUrl();
                bdproducto.modificarProducto(cod, nom, pre, stock, cat,ima);

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
        limpiarImagen();
        btnAgregar.setEnabled(false);
        btnBuscar.setEnabled(false);

    }

    public void Eliminar() {
        int i = 0;
        try {

            if (txtcodigo.getText().length() != 0) {

                Producto productoAeliminar = bdproducto.buscarProducto(Integer.parseInt(txtcodigo.getText()));
                bdproducto.eliminarProducto(productoAeliminar);
                Producto obj_bean = new Producto();
                obj_bean.setCodigo(Integer.parseInt(txtcodigo.getText()));
                ProductoDao obj_dao = new ProductoDao();
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
        btnAgregar.setEnabled(true);

    }

    private void Nuevo() {
        limpiarTextos();
        activarTextos(true);
        txtcodigo.setEditable(false);
        btnNuevo.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnBuscar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnExaminar.setEnabled(true);
        btnMostrar.setEnabled(true);
         limpiarImagen();
        txtcodigo.setText(bdproducto.nuevoCodigo() + "");
        
    }
 private void limpiarImagen(){
        imagenProducto.removeAll();
        imagenProducto.repaint();
   }    
    private void limpiarTextos() {
        txtcodigo.setText("");
        txtnombre.setText("");
        txtprecio.setText("");
        txtstock.setText("");
        txtcategoria.setText("");
        
        activarControles();
    }

    private void activarTextos(boolean b) {
        txtcodigo.setEnabled(b);
        txtnombre.setEnabled(b);
        txtprecio.setEnabled(b);
        txtstock.setEnabled(b);
        txtcategoria.setEnabled(b);
    }

    private void activarControles() {
        txtcodigo.setEditable(true);
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnMostrar.setEnabled(true);
        btnBuscar.setEnabled(true);
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnExaminar.setEnabled(false);
    }
 
    private void cargarImagen(Producto p){
        try {
            imagenProducto.removeAll();
            URL url = new URL(p.getImagen());
            m.setObtener(url);
            m.Mostrar(imagenProducto);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Frmproducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Buscar() {
        limpiarImagen();
        if (txtcodigo.getText().compareTo("") != 0) {
            int result = JOptionPane.showConfirmDialog(
                    this, "¿Deseas Buscar el Producto para Modificarlo?",
                    "Mensaje..!!",
                    JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {

                buscarProducto();
                btnNuevo.setEnabled(false);
                btnMostrar.setEnabled(false);
                btnCancelar.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnExaminar.setEnabled(true);
                btnModificar.setEnabled(true);
                activarTextos(true);
            }
            if (result == JOptionPane.NO_OPTION) {
                buscarProducto();
                btnEliminar.setEnabled(true);
                btnNuevo.setEnabled(false);
                btnCancelar.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese codigo de producto que desee buscar");
        }

    }

    private void buscarProducto() {
        Producto p = bdproducto.buscarProducto(Integer.parseInt(txtcodigo.getText()));
        if (p != null) {
            txtcodigo.setText(String.valueOf(p.getCodigo()));
            txtnombre.setText(p.getNombre());
            txtprecio.setText(String.valueOf(p.getPrecio()));
            txtstock.setText(String.valueOf(p.getStock()));
            txtcategoria.setText(String.valueOf(p.getCategoria()));
        } else {
            JOptionPane.showMessageDialog(null, "No exite");
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAgregar) {
            agregar();
        }

        if (e.getSource() == btnMostrar) {
            Mostrar();
        }

        if (e.getSource() == btnEliminar) {
            Eliminar();
        }

        if (e.getSource() == btnModificar) {
            modificar();
        }

        if (e.getSource() == btnNuevo) {
            Nuevo();
        }

        if (e.getSource() == btnBuscar) {
            Buscar();
        }
        if (e.getSource() == btnCancelar) {
            limpiarTextos();
            activarTextos(false);
            limpiarImagen();
            txtcodigo.setEnabled(true);
        }
        if (e.getSource() == btnExaminar) {
           examinar();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tabla) {
            Seleccionar();
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnExaminar.setEnabled(true);
            btnBuscar.setEnabled(false);
            btnNuevo.setEnabled(false);
            activarTextos(true);
            txtcodigo.setEnabled(false);

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
