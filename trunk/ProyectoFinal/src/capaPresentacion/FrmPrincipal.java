package capaPresentacion;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FrmPrincipal extends JFrame implements ActionListener {

    JMenuBar barra;
    JMenu menuprograma, menuMantenimiento, menuConsultas, menuprocesos;
    JMenuItem menuItemInicio, menuItemSalir;
    JMenuItem menuItemProducto, menuItemProveedor;
    JMenuItem menuItemConsulProductos, menuItemConsulProveedor;
    JMenuItem menuitemCompra, menuitemVenta;
    FrmInicio inicio;

    public static void main(String arg[]) {
        FrmPrincipal a = new FrmPrincipal();
        a.setLocation(500, 500);
//        a.setResizable(false);
//        ImageFondo image = new ImageFondo();
//        image.setImage("/img/maestro.png");
//        a.setContentPane(image);
        a.setVisible(true);
        a.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public FrmPrincipal() {

        setSize(900, 600);
        setLayout(null);
//        inicio = new FrmInicio();
//        add(inicio);
        setResizable(false);

        setTitle("SISTEMA DE GESTION DE MAESTRO PERU S.A.");

        barra = new JMenuBar();
        setJMenuBar(barra);

        menuprograma = new JMenu("Programa");
        barra.add(menuprograma);

        menuMantenimiento = new JMenu("Mantenimiento");
        barra.add(menuMantenimiento);

        menuConsultas = new JMenu("consultas");
        barra.add(menuConsultas);

        menuprocesos = new JMenu("procesos");
        barra.add(menuprocesos);

        menuItemInicio = new JMenuItem("Inicio");
        menuItemInicio.addActionListener(this);
        menuprograma.add(menuItemInicio);

        menuItemSalir = new JMenuItem();
        menuItemSalir.setText("Salir");
        menuprograma.add(menuItemSalir);

        menuItemSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuItemSalirActionPerformed(e);
            }
        });

        menuItemProducto = new JMenuItem("Producto");
        menuItemProducto.addActionListener(this);
        menuMantenimiento.add(menuItemProducto);

        menuItemProveedor = new JMenuItem("Proveedor");
        menuItemProveedor.addActionListener(this);
        menuMantenimiento.add(menuItemProveedor);

        menuItemConsulProductos = new JMenuItem("Consultar de productos");
        menuItemConsulProductos.addActionListener(this);
        menuConsultas.add(menuItemConsulProductos);

        menuItemConsulProveedor = new JMenuItem("Consultar de proveedores");
        menuItemConsulProveedor.addActionListener(this);
        menuConsultas.add(menuItemConsulProveedor);

        menuitemCompra = new JMenuItem("Compra");
        menuitemCompra.addActionListener(this);
        menuprocesos.add(menuitemCompra);

        menuitemVenta = new JMenuItem("Venta");
        menuitemVenta.addActionListener(this);
        menuprocesos.add(menuitemVenta);

        getRootPane().setMenuBar(barra);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Container f = this.getContentPane();
        if (e.getSource() == menuItemInicio) {
            f.removeAll();
            setResizable(false);
            FrmInicio i = new FrmInicio();
            f.add(i);
            f.repaint();
        }

        if (e.getSource() == menuItemProducto) {
            f.removeAll();
            setResizable(false);
            Frmproducto p = new Frmproducto();
            f.add(p);
            f.repaint();
        }
        if (e.getSource() == menuItemConsulProductos) {
            f.removeAll();
            setResizable(false);
            FrmListaProducto p = new FrmListaProducto();
            f.add(p);
            f.repaint();
        }
        if (e.getSource() == menuItemConsulProveedor) {
            f.removeAll();
            setResizable(false);
            FrmListaProveedor p = new FrmListaProveedor();
            f.add(p);
            f.repaint();
        }
        if (e.getSource() == menuitemCompra) {
            f.removeAll();
            setResizable(false);
            FrmCompra p = new FrmCompra();
            f.add(p);
            f.repaint();
        }

        if (e.getSource() == menuitemVenta) {
            f.removeAll();
            setResizable(false);
            FrmVenta p = new FrmVenta();
            f.add(p);
            f.repaint();
        }

        if (e.getSource() == menuItemProveedor) {
            f.removeAll();
            setResizable(false);
            FrmProveedor p = new FrmProveedor();
            f.add(p);
            f.repaint();
        }

    }

    private void menuItemSalirActionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
