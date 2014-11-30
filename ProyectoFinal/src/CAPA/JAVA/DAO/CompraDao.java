package CAPA.JAVA.DAO;

import CAPA.JAVA.BEAN.Compra;
import CAPA.JAVA.UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CompraDao {

    Compra objEmpleBean;
    Connection cn = null;
    public ArrayList<Compra> listacompra;
    PreparedStatement pt = null;
    ResultSet rs = null;

    public CompraDao() {
        listacompra = new ArrayList<>();
        cargarCompra();
    }

    // Guarda los Compras a la base de datos
    public int guardar(Compra obj) {
        int estado = 0;
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("Insert into Compra(numero,ncomprobante,proveedor,fecha,tcomprobante,fpago,tcompra) values (?,?,?,?,?,?,?)");
            pt.setInt(1, obj.getNumero());
            pt.setInt(2, obj.getNcomprobante());
            pt.setString(3, obj.getProveedor());
            pt.setString(4, obj.getFecha());
            pt.setString(5, obj.getTcomprobante());
            pt.setString(6, obj.getFpago());
            pt.setDouble(7, obj.getTcompra());

            estado = pt.executeUpdate();
            pt.close();
            cn.close();

        } catch (Exception e) {

        }
        return estado;
    }

    private void cargarCompra() {
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("select * from compra");
            rs = pt.executeQuery();

            while (rs.next()) {
                objEmpleBean = new Compra();
                objEmpleBean.setNumero(rs.getInt(1));
                objEmpleBean.setNcomprobante(rs.getInt(2));
                objEmpleBean.setProveedor(rs.getString(3));
                objEmpleBean.setFecha(rs.getString(4));
                objEmpleBean.setTcomprobante(rs.getString(5));
                objEmpleBean.setFpago(rs.getString(6));
                objEmpleBean.setTcompra(rs.getDouble(7));
                listacompra.add(objEmpleBean);
            }
            rs.close();
            pt.close();
            cn.close();

        } catch (Exception e) {
        }

    }

    // Busca un Compra
    public Compra buscarCompra(int numero) {
        for (int i = 0; i < listacompra.size(); i++) {
            Compra ven = (Compra) listacompra.get(i);
            if (numero == ven.getNumero()) {
                return ven;
            }
        }
        return null;
    }

    public int buscarCompra(Compra com) {
        return listacompra.indexOf(com);
    }

    // Inserta un Compra
    public void adicionarCompra(Compra com) {
        listacompra.add(com);
    }

    //Modifica un Compra
    public void modificarCompra(int numCom, String proveedor, String fecVen, String tcomprobante, int ncomprobante, String fpago, Double tcompra) {
        Compra CompraAmodificar = buscarCompra(numCom);
        CompraAmodificar.setProveedor(proveedor);
        CompraAmodificar.setFecha(fecVen);
        CompraAmodificar.setTcomprobante(tcomprobante);
        CompraAmodificar.setNcomprobante(ncomprobante);
        CompraAmodificar.setFpago(fpago);
        CompraAmodificar.setTcompra(tcompra);
    }

    // Elimina un Compra
    public void eliminarCompra(Compra com) {
        listacompra.remove(com);
    }

    // Retorna el Compra de la posición dada
    public Compra obtenerCompra(int indice) {
        return (Compra) listacompra.get(indice);
    }

    // Retorna la cantidad de Compras
    public int numeroCompras() {
        return listacompra.size();
    }

    // Genera un nuevo código
    public int nuevoCodigo() {
        if (!listacompra.isEmpty()) {
            return listacompra.get(listacompra.size() - 1).getNumero() + 1;
        } else {
            return 1;
        }
    }

}
