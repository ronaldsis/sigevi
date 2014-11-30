package CAPA.JAVA.DAO;

import CAPA.JAVA.BEAN.Usuario;
import CAPA.JAVA.UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    Usuario objUsuarioBean;
    Connection cn;
    PreparedStatement pt;
    ResultSet rs;

    public boolean ValidarAcceso(Usuario objUsuBean) {
        boolean estado = false;

        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("select * from usuario where  USU=? and  CLA=?");
            pt.setString(1, objUsuBean.getUsu());
            pt.setString(2, objUsuBean.getCla());
            rs = pt.executeQuery();
            if (rs.next()) {
                estado = true;
            }
            rs.close();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return estado;
    }

}
