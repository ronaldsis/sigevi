package CAPA.JAVA.DAO;

import CAPA.JAVA.BEAN.DetalleVenta;
import CAPA.JAVA.UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DetalleVentaDao {

    DetalleVenta objEmpleBean;
    public ArrayList<DetalleVenta> ListaDetalleVenta;
    Connection cn = null;
    PreparedStatement pt = null;
    ResultSet rs = null;

    public DetalleVentaDao() {
        ListaDetalleVenta = new ArrayList<>();
        cargarDetalleVenta();
    }

    public int guardar(DetalleVenta obj) {

        int estado = 0;
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("Insert into DetalleVenta(codigo,numVenta,item, codPro, can, precio,subTot) values (?,?,?,?,?,?,?)");
            pt.setInt(1, obj.getCodigo());
            pt.setInt(2, obj.getNumVenta());
            pt.setDouble(3, obj.getItem());
            pt.setInt(4, obj.getCodPro());
            pt.setInt(5, obj.getCan());
            pt.setDouble(6, obj.getPrecio());
            pt.setDouble(7, obj.getSubTot());
            estado = pt.executeUpdate();
            pt.close();
            cn.close();

        } catch (Exception e) {
        }

        return estado;
    }

    private void cargarDetalleVenta() {
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("select * from DetalleVenta");
            rs = pt.executeQuery();

            while (rs.next()) {
                objEmpleBean = new DetalleVenta();
                objEmpleBean.setCodigo(rs.getInt(1));
                objEmpleBean.setNumVenta(rs.getInt(2));
                objEmpleBean.setItem(rs.getInt(3));
                objEmpleBean.setCodPro(rs.getInt(4));
                objEmpleBean.setCan(rs.getInt(5));
                objEmpleBean.setPrecio(rs.getDouble(6));
                objEmpleBean.setSubTot(rs.getDouble(7));
                ListaDetalleVenta.add(objEmpleBean);
            }
            rs.close();
            pt.close();
            cn.close();

        } catch (Exception e) {
        }

    }

    // Busca un DetalleVenta
    public DetalleVenta buscarDetalleVenta(int codigo) {
        for (int i = 0; i < ListaDetalleVenta.size(); i++) {
            DetalleVenta pro = (DetalleVenta) ListaDetalleVenta.get(i);
            if (codigo == pro.getCodigo()) {
                return pro;
            }
        }
        return null;
    }

    public int buscarDetalleVenta(DetalleVenta detven) {
        return ListaDetalleVenta.indexOf(detven);
    }

    // Inserta un DetalleVenta
    public void adicionarDetalleVenta(DetalleVenta detven) {
        ListaDetalleVenta.add(detven);
    }

    //Modifica un DetalleVenta
    public void modificarDetalleVenta(int codigo, int numven, int item, int codpro, int can, double precio, double subtot) {
        DetalleVenta DetalleVentaAmodificar = buscarDetalleVenta(codigo);
        DetalleVentaAmodificar.setNumVenta(numven);
        DetalleVentaAmodificar.setItem(item);
        DetalleVentaAmodificar.setCodPro(codpro);
        DetalleVentaAmodificar.setCan(can);
        DetalleVentaAmodificar.setPrecio(precio);
        DetalleVentaAmodificar.setSubTot(subtot);
    }

    // Elimina un DetalleVenta
    public void eliminarDetalleVenta(DetalleVenta detven) {
        ListaDetalleVenta.remove(detven);
    }

    // Retorna el DetalleVenta de la posición dada
    public DetalleVenta obtenerDetalleVenta(int indice) {
        return (DetalleVenta) ListaDetalleVenta.get(indice);
    }

    // Retorna la cantidad de DetalleVentas
    public int numeroDetalleVentas() {
        return ListaDetalleVenta.size();
    }

    // Genera un nuevo código
    public int nuevoCodigo() {
        if (!ListaDetalleVenta.isEmpty()) {
            return ListaDetalleVenta.get(ListaDetalleVenta.size() - 1).getCodigo() + 1;
        } else {
            return 1;
        }
    }
}
