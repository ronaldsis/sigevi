/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigevi.bea;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import sigevi.gui.hojaReporte;

/**
 *
 * @author Anthony
 */
public class Conexion {

    private final String direc ="jdbc:oracle:thin:@localhost:1521:XE";
    private final String login="vidrieria";
    private final String password="vidrieria";
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
    public String pReporteTipoCliente(String codigo) throws SQLException{
      
        cstm = conn.prepareCall("{ call P_TIPO_CLIENTE(?,?)}");
        cstm.setString(1, codigo);
        cstm.registerOutParameter(2, Types.VARCHAR);
        System.out.println("DDDDDDDDDDDDDDD"+ codigo); 
        cstm.execute();
        System.out.println("EEEEEEEEEEEEEE"+ codigo);
        reporte = cstm.getString(2);
        System.out.println("FFFFFFFFFFFFFFF"+ codigo);
        
        return reporte;
    }
       public String pReporteProvee(int codigo) throws SQLException{
        cstm = conn.prepareCall("{ call p_reporte_proveedor(?,?)}");
        cstm.setInt(1,codigo);
        cstm.registerOutParameter(2, Types.VARCHAR);
        
        cstm.execute();
        reporte = cstm.getString(2);
        
        return reporte;
    }
    
        public String pReporte_Prod_x_Cat(String codigo) throws SQLException{
        cstm = conn.prepareCall("{ call p_rep_prod_por_cat(?,?)}");
        cstm.setString(1,codigo);
        cstm.registerOutParameter(2, Types.VARCHAR);
        cstm.execute();
        reporte = cstm.getString(2);
        
        return reporte;
    }
     public String pReporte_Ganancia_x_Producto(String codigo) throws SQLException{
        cstm = conn.prepareCall("{ call P_GANANCIA_POR_PRODUCTO(?,?)}");
        cstm.setString(1,codigo);
        cstm.registerOutParameter(2, Types.VARCHAR);
        cstm.execute();
        reporte = cstm.getString(2);
        
        return reporte;
    }
      public String pReporte_Venta_Fechas(String c1, String c2) throws SQLException{
        cstm = conn.prepareCall("{ call P_VENTAS_FECHA(?,?,?)}");
        cstm.setString(1,c1);
        cstm.setString(2,c2);
        cstm.registerOutParameter(3, Types.VARCHAR);
        cstm.execute();
        reporte = cstm.getString(3);
        
        return reporte;
    }   
      
      
              public String pReporte_Compra_Fechas(String c1, String c2) throws SQLException{
        cstm = conn.prepareCall("{ call P_COMPRAS_FECHA(?,?,?)}");
        cstm.setString(1,c1);
        cstm.setString(2,c2);
        cstm.registerOutParameter(3, Types.VARCHAR);
        cstm.execute();
        reporte = cstm.getString(3);
        
        return reporte;
    }   
       public String pReporte_Control_Stock_Bajo(int NUM) throws SQLException{
        cstm = conn.prepareCall("{ call p_rep_de_stock_bajo(?,?)}");
        cstm.setInt(1,NUM);
        cstm.registerOutParameter(2, Types.VARCHAR);
        
        cstm.execute();
        reporte = cstm.getString(2);
        
        return reporte;
    }
     
   public String pReporte_Control_Stock_Alto(int codigo) throws SQLException{
        cstm = conn.prepareCall("{ call p_rep_de_stock_alto(?,?)}");
        cstm.setInt(1,codigo);
        cstm.registerOutParameter(2, Types.VARCHAR);
        
        cstm.execute();
        reporte = cstm.getString(2);
        
        return reporte;
    }
        
          public String pReporte_Prod_x_Prove(String codigo) throws SQLException{
        cstm = conn.prepareCall("{ call p_rep_prod_por_prove(?,?)}");
        cstm.setString(1,codigo);
        cstm.registerOutParameter(2, Types.VARCHAR);
        
        cstm.execute();
        reporte = cstm.getString(2);
        
        return reporte;
    }
        
  
        public String pReporteMayorProducto() throws SQLException{
        cstm = conn.prepareCall("{ call P_PRODUCTO_MAYOR(?)}");
     
        cstm.registerOutParameter(1, Types.VARCHAR);
        
        cstm.execute();
        reporte = cstm.getString(1);
        
        return reporte;
    }
    public String pReporteMenorProducto() throws SQLException{
        cstm = conn.prepareCall("{ call P_PRODUCTO_MENOR(?)}");
     
        cstm.registerOutParameter(1, Types.VARCHAR);
        
        cstm.execute();
        reporte = cstm.getString(1);
        
        return reporte;
    }
    public String pPersonal() throws SQLException{
        
        return linea;
        }
    
    public  void pVentacliente() throws SQLException{
        
         hojaReporte report = new hojaReporte();
                
                report.setVisible(true);
    
      
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
                                       //report.jTextArea1.setText(line);
                                       report.jTextArea1.append(line+"\n");
                                       

                     }
            }
}
     public  void pReporteProducto() throws SQLException{
        
         hojaReporte report = new hojaReporte();
                
                report.setVisible(true);
    
      
            CallableStatement cstmt = conn.prepareCall("{call dbms_output.enable(32000) }");
            cstmt.execute();
            Statement stmt = conn.createStatement();
            String sql =
            "BEGIN\n" +
            "  P_PRODUCTO();\n" +
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
                                       //report.jTextArea1.setText(line);
                                       report.jTextArea1.append(line+"\n");
                                       

                     }
            }
}
     
      public  void pReporteProveedor() throws SQLException{
        
         hojaReporte report = new hojaReporte();
                
                report.setVisible(true);
    
      
            CallableStatement cstmt = conn.prepareCall("{call dbms_output.enable(32000) }");
            cstmt.execute();
            Statement stmt = conn.createStatement();
            String sql =
            "BEGIN\n" +
            "  P_PROVEEDOR();\n" +
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
                                       //report.jTextArea1.setText(line);
                                       report.jTextArea1.append(line+"\n");
                                       

                     }
            }
}
      public  void pReporteMedidas() throws SQLException{
        
         hojaReporte report = new hojaReporte();
                
                report.setVisible(true);
    
      
            CallableStatement cstmt = conn.prepareCall("{call dbms_output.enable(32000) }");
            cstmt.execute();
            Statement stmt = conn.createStatement();
            String sql =
            "BEGIN\n" +
            "  P_MEDIDAS();\n" +
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
                                       //report.jTextArea1.setText(line);
                                       report.jTextArea1.append(line+"\n");
                                       

                     }
            }
}
      public  void pReporteUsuario() throws SQLException{
        
         hojaReporte report = new hojaReporte();
                
                report.setVisible(true);
    
      
            CallableStatement cstmt = conn.prepareCall("{call dbms_output.enable(32000) }");
            cstmt.execute();
            Statement stmt = conn.createStatement();
            String sql =
            "BEGIN\n" +
            "  P_USUARIO();\n" +
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
                                       //report.jTextArea1.setText(line);
                                       report.jTextArea1.append(line+"\n");
                                       

                     }
            }
}
     
     public  void pReporteCliente() throws SQLException{
        
         hojaReporte report = new hojaReporte();
                
                report.setVisible(true);
    
      
            CallableStatement cstmt = conn.prepareCall("{call dbms_output.enable(32000) }");
            cstmt.execute();
            Statement stmt = conn.createStatement();
            String sql =
            "BEGIN\n" +
            "  P_CLIENTE();\n" +
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
                                       //report.jTextArea1.setText(line);
                                       report.jTextArea1.append(line+"\n");
                                       

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

