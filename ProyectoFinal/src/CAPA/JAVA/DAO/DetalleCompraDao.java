package CAPA.JAVA.DAO;

import CAPA.JAVA.BEAN.DetalleCompra;
import CAPA.JAVA.UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DetalleCompraDao {
    //Atributos
    DetalleCompra objEmpleBean;
    public ArrayList<DetalleCompra> aDetalleCompra;
    private Connection cn;
    private PreparedStatement pt;
    private ResultSet rs;

    public DetalleCompraDao() {
        aDetalleCompra = new ArrayList<>();
        cargar();
    }
    // Carga DetalleCompras 
    private void cargar() {
         try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("select * from DetalleCompra");
            rs = pt.executeQuery();
           
            while (rs.next()) {
                objEmpleBean = new DetalleCompra();
                objEmpleBean.setCodigo(rs.getInt(1));
                objEmpleBean.setNumCompra(rs.getInt(2));
                objEmpleBean.setItem(rs.getInt(3));
                objEmpleBean.setCodPro(rs.getInt(4));
                objEmpleBean.setCan(rs.getInt(5));
                objEmpleBean.setPrecio(rs.getDouble(6));
                objEmpleBean.setSubTot(rs.getDouble(7));
                aDetalleCompra.add(objEmpleBean);
            }
            rs.close();
            pt.close();
            cn.close();

        } catch (Exception e) {
        }
    }

    // Guarda los DetalleCompras al archivo
    public int guardar(DetalleCompra obj) {
        
        int estado = 0;
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("Insert into DetalleCompra(codigo,numCompra,item,codPro,can,precio,subtot) values (?,?,?,?,?,?,?)");
            pt.setInt(1, obj.getCodigo());
            pt.setInt(2, obj.getNumCompra());
            pt.setInt(3, obj.getItem());
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

    // Busca un DetalleCompra
    public DetalleCompra buscarDetalleCompra(int codigo) {
        for (int i = 0; i < aDetalleCompra.size(); i++) {
            DetalleCompra pro = (DetalleCompra) aDetalleCompra.get(i);
            if (codigo == pro.getCodigo()) {
                return pro;
            }
        }
        return null;
    }
    
    public int buscarDetalleCompra(DetalleCompra detcom){
        return aDetalleCompra.indexOf(detcom);
    }
    
    // Inserta un DetalleCompra
    public void adicionarDetalleCompra(DetalleCompra detcom) {
        aDetalleCompra.add(detcom);
    }
    
    //Modifica un DetalleCompra
    public void modificarDetalleCompra(int codigo, int numcom, int item, int codpro, int can, double precio,double subtot) {
        DetalleCompra DetalleCompraAmodificar=buscarDetalleCompra(codigo);
        DetalleCompraAmodificar.setNumCompra(numcom);
        DetalleCompraAmodificar.setItem(item);
        DetalleCompraAmodificar.setCodPro(codpro);
        DetalleCompraAmodificar.setCan(can);
        DetalleCompraAmodificar.setPrecio(precio);
        DetalleCompraAmodificar.setSubTot(subtot);
    }
   
    // Elimina un DetalleCompra
    public void eliminarDetalleCompra(DetalleCompra detcom) {
        aDetalleCompra.remove(detcom);
    }
    
    // Retorna el DetalleCompra de la posición dada
    public DetalleCompra obtenerDetalleCompra(int indice) {
        return (DetalleCompra) aDetalleCompra.get(indice);
    }
    
    // Retorna la cantidad de DetalleCompras
    public int numeroDetalleCompras() {
        return aDetalleCompra.size();
    }

    // Genera un nuevo código
    public int nuevoCodigo() {
        if (!aDetalleCompra.isEmpty())
            return aDetalleCompra.get(aDetalleCompra.size()-1).getCodigo()+1;
        else
            return 1;
    }       
}
