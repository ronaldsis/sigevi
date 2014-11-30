package CAPA.JAVA.DAO;

import CAPA.JAVA.UTIL.ConexionBD;
import CAPA.JAVA.BEAN.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductoDao {

    Producto objEmpleBean;
    Connection cn = null;
    public ArrayList<Producto> lista;
    PreparedStatement pt = null;
    ResultSet rs = null;

    public ProductoDao() {
        lista = new ArrayList<>();
        cargarProducto();
    }

    public int Insertar(Producto obj) {

        int estado = 0;
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("Insert into producto(codigo,nombre,precio,stock,categoria,imagen) values (?,?,?,?,?,?)");
            pt.setInt(1, obj.getCodigo());
            pt.setString(2, obj.getNombre());
            pt.setDouble(3, obj.getPrecio());
            pt.setInt(4, obj.getStock());
            pt.setString(5, obj.getCategoria());
            pt.setString(6, obj.getImagen());
            estado = pt.executeUpdate();
            pt.close();
            cn.close();

        } catch (Exception e) {
        }

        return estado;
    }

    private void cargarProducto() {
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("select * from producto");
            rs = pt.executeQuery();

            while (rs.next()) {
                objEmpleBean = new Producto();
                objEmpleBean.setCodigo(rs.getInt(1));
                objEmpleBean.setNombre(rs.getString(2));
                objEmpleBean.setPrecio(rs.getDouble(3));
                objEmpleBean.setStock(rs.getInt(4));
                objEmpleBean.setCategoria(rs.getString(5));
                objEmpleBean.setImagen(rs.getString(6));
                lista.add(objEmpleBean);
            }
            rs.close();
            pt.close();
            cn.close();

        } catch (Exception e) {
        }

    }

    public Producto buscarProducto(int codigo) {
        for (int i = 0; i < lista.size(); i++) {
            Producto pro = (Producto) lista.get(i);
            if (codigo == pro.getCodigo()) {
                return pro;
            }
        }
        return null;
    }

    public void modificarProducto(int codPro, String nomPro, double pre, int stock, String cat, String ima) {
        Producto productoAmodificar = buscarProducto(codPro);
        productoAmodificar.setNombre(nomPro);
        productoAmodificar.setPrecio(pre);
        productoAmodificar.setStock(stock);
        productoAmodificar.setCategoria(cat);
        productoAmodificar.setImagen(ima);
    }

    public int numeroProductos() {
        return lista.size();
    }

    public Producto obtenerProducto(int indice) {
        return (Producto) lista.get(indice);
    }

    public void adicionarProducto(Producto pro) {
        lista.add(pro);
    }

    public int ModificarDato(Producto obj1) {
        int estado = 0;
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("update producto set  nombre=? , precio=? , stock=?, categoria=?, imagen=? where codigo =?");

            pt.setString(1, obj1.getNombre());
            pt.setDouble(2, obj1.getPrecio());
            pt.setInt(3, obj1.getStock());
            pt.setString(4, obj1.getCategoria());
            pt.setString(5, obj1.getImagen());
            pt.setInt(6, obj1.getCodigo());
            estado = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
            estado = 0;
        }
        return estado;
    }
public int ModificarDatoStock(int codigo,int stck) {
        int estado = 0;
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("update producto set stock=? where codigo =?");

            //pt.setString(1, obj1.getNombre());
         //   pt.setDouble(2, obj1.getPrecio());
            pt.setInt(1, stck);
          //  pt.setString(4, obj1.getCategoria());
          //  pt.setString(5, obj1.getImagen());
            pt.setInt(2, codigo);
            estado = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
            estado = 0;
        }
        return estado;
    }
    public int Eliminar(Producto obj_eli) {
        int i = 0;
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("DELETE FROM producto WHERE codigo=?");
            pt.setInt(1, obj_eli.getCodigo());
            i = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
            i = 0;
        }
        return i;
    }

    public void eliminarProducto(Producto pro) {
        lista.remove(pro);
    }

    public void actualizarStock(int codPro, int stock) {
        Producto productoAmodificar = buscarProducto(codPro);
        productoAmodificar.setStock(stock);
    }

    public int nuevoCodigo() {
        if (!lista.isEmpty()) {

            return lista.get(lista.size() - 1).getCodigo() + 1;
        } else {
            return 1;
        }
    }
}
    