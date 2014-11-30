package CAPA.JAVA.DAO;

import CAPA.JAVA.BEAN.Proveedor;
import CAPA.JAVA.UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProveedorDao {

    Proveedor objEmpleBean;
    Connection cn = null;
    public ArrayList<Proveedor> listaProveedor;
    PreparedStatement pt = null;
    ResultSet rs = null;

    public ProveedorDao() {
        listaProveedor = new ArrayList<>();
        cargarProveedor();
    }

    public int Insertar(Proveedor obj) {

        int estado = 0;
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("Insert into proveedor(  RUC,RaSocial , direccion , telefono, contacto, email) values (?,?,?,?,?,?)");
            pt.setInt(1, obj.getRUC());
            pt.setString(2, obj.getRaSocial());
            pt.setString(3, obj.getDireccion());
            pt.setInt(4, obj.getTelefono());
            pt.setString(5, obj.getContacto());
            pt.setString(6, obj.getEmail());
            estado = pt.executeUpdate();
            pt.close();
            cn.close();

        } catch (Exception e) {
        }

        return estado;
    }

    private void cargarProveedor() {
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("select * from proveedor");
            rs = pt.executeQuery();

            while (rs.next()) {
                objEmpleBean = new Proveedor();
                objEmpleBean.setRUC(rs.getInt(1));
                objEmpleBean.setRaSocial(rs.getString(2));
                objEmpleBean.setDireccion(rs.getString(3));
                objEmpleBean.setTelefono(rs.getInt(4));
                objEmpleBean.setContacto(rs.getString(5));
                objEmpleBean.setEmail(rs.getString(6));
                listaProveedor.add(objEmpleBean);
            }
            rs.close();
            pt.close();
            cn.close();

        } catch (Exception e) {
        }

    }

    public Proveedor buscarProveedor(int codigo) {
        for (int i = 0; i < listaProveedor.size(); i++) {
            Proveedor pro = (Proveedor) listaProveedor.get(i);
            if (codigo == pro.getRUC()) {
                return pro;
            }
        }
        return null;
    }

    public void modificarProveedor(int RUCPro, String RaS, String dir, int Telf, String cont, String email) {
        Proveedor proveedorModificar = buscarProveedor(RUCPro);
        proveedorModificar.setRaSocial(RaS);
        proveedorModificar.setDireccion(dir);
        proveedorModificar.setTelefono(Telf);
        proveedorModificar.setContacto(cont);
        proveedorModificar.setEmail(email);
    }

    public int numeroProveedor() {
        return listaProveedor.size();
    }

    public Proveedor obtenerProveedor(int indice) {
        return (Proveedor) listaProveedor.get(indice);
    }

    public void adicionarProveedor(Proveedor pro) {
        listaProveedor.add(pro);
    }

    public int ModificarDato(Proveedor obj1) {
        int estado = 0;
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("update proveedor set  razonsocial=? , direccion=? , telefono=?, contacto=?, email=? where RUC =?");

            pt.setString(1, obj1.getRaSocial());
            pt.setString(2, obj1.getDireccion());
            pt.setInt(3, obj1.getTelefono());
            pt.setString(4, obj1.getContacto());
            pt.setString(5, obj1.getEmail());
            pt.setInt(6, obj1.getRUC());
            estado = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
            estado = 0;
        }
        return estado;
    }

    public int Eliminar(Proveedor obj_eli) {
        int i = 0;
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("DELETE FROM proveedor WHERE RUC=?");
            pt.setInt(1, obj_eli.getRUC());
            i = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
            i = 0;
        }
        return i;
    }

    public void eliminarProducto(Proveedor pro) {
        listaProveedor.remove(pro);
    }

    // Retorna la cantidad de Proveedors
    public int numeroProveedores() {
        return listaProveedor.size();
    }

}
