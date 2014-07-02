/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigevi.bea;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anthony
 */
public class Conexion {

    private String direc ="jdbc:oracle:thin:@localhost:1521:XE";
    private String login="vidrieria";
    private String password="vidrieria";
    private Connection conn;
    private Statement stm;
    private CallableStatement cstm;
    private ResultSet rs;
    private String reporte;
     private String historial;
     private String linea;
    private ResultSet rs1;
    
    public Conexion() throws ClassNotFoundException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(direc, login, password);
            stm = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
    public void cerrarConeccion(){
        try {
            rs.close();
            //cstm.close();
            stm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public String pReporte(int codigo) throws SQLException{
        cstm = conn.prepareCall("{ call p_reporte_cliente(?,?)}");
        cstm.setInt(1,codigo);
        cstm.registerOutParameter(2, Types.VARCHAR);
        
        cstm.execute();
        reporte = cstm.getString(2);
        
        return reporte;
    }
    
    public String pPersonal() throws SQLException{
        
        return linea;
        }
    
    public  void pVentacliente() throws SQLException{
      
            CallableStatement cstmt = conn.prepareCall("{call dbms_output.enable(32000) }");
            cstmt.execute();
            Statement stmt = conn.createStatement();
            String sql =
            "BEGIN\n" +
            "  SP_VENTAS_CLIENTE();\n" +
            "--rollback; \n" +
            "END;";
           
            stmt.execute(sql);
            cstmt = conn.prepareCall("{call dbms_output.get_line(?,?)}");
            cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);
            cstmt.registerOutParameter(2,java.sql.Types.NUMERIC);

            int status = 0;
            while (status == 0)
            {
                cstmt.execute();
                String line = cstmt.getString(1);
                status = cstmt.getInt(2);
                     if (line != null && status == 0)
                     {
                         System.out.println(line);
                          //Object[] fila = {line};
                        //  Modelo.addRow(fila);
                     }
            }
}
    
    public static void main(String[] args) throws SQLException {
        Conexion con;
        try {
            String rep = null;
            con = new Conexion();
            int a=150;
            con.pReporte(a);
            //con.pPersonal(a);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
}

