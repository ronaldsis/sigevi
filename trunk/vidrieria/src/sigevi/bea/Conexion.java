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
        cstm = conn.prepareCall("{call p_personal_cargo(?)}");
        cstm.registerOutParameter(1, Types.VARCHAR);
        System.out.println("1");
        CallableStatement cstmt = conn.prepareCall("{call dbms_output.enable(32000) }");
        cstmt.execute();
           System.out.println("2");
        String sql =
            "cli varchar2(100);\n" +
            "tip varchar2(20);\n" +
            "mon float;\n" +
            " cursor reporte is\n" +
            "   select c.nomCli,c.tipCli,sum(a.canDet*a.preDet) as monto\n" +
            "   from detalle_venta a \n" +
            "   inner join venta b on a.venta_nroVen =b.nroVen\n" +
            "   inner join cliente c on b.cliente_codCli =c.codCli\n" +
            "   group by c.nomCli, c.tipCli;\n" +
            "   \n" +
            "begin\n" +
            "   \n" +
            "       DBMS_OUTPUT.PUT_LINE('**************** REPORTE:**********************');\n" +
            "       DBMS_OUTPUT.PUT_LINE('*CLIENTE****TIPO CLIENTE****MONTO COMPRADO*');\n" +
            "   for f in reporte\n" +
            "   loop \n" +
            "   \n" +
            "   \n" +
            "   DBMS_OUTPUT.PUT_LINE(f.nomCli||' '||f.tipCli||' '||f.monto);\n" +
            "   end loop;\n" +
            "   DBMS_OUTPUT.PUT_LINE('Responsable del Reporte: Marco Castillo');\n" +
            "   DBMS_OUTPUT.PUT_LINE('Fecha: ' ||TO_CHAR(sysdate, 'fmDAY, DD \"DE\" MONTH \"DE\" YYYY'));\n" +
            "   DBMS_OUTPUT.PUT_LINE('');";
           System.out.println("3");
        stm.execute(sql);
        System.out.println("4");
        //cstm.execute();
        cstmt = conn.prepareCall("{call dbms_output.get_line(?,?)}");
        cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);
        cstmt.registerOutParameter(2,java.sql.Types.NUMERIC);
System.out.println("5");
        int status = 0;
        while (status == 0)
        {
            System.out.println("6");
        cstmt.execute();
        String line = cstmt.getString(1);
        status = cstmt.getInt(2);
        System.out.println("7");
            if (line != null && status == 0)
             {System.out.println("8");
                System.out.println(line);
             }
        }
        historial = cstm.getString(1);
        
        return linea;
        }
    
    public  void pVentacliente() throws SQLException{
      
            CallableStatement cstmt = conn.prepareCall("{call dbms_output.enable(32000) }");
            cstmt.execute();
            Statement stmt = conn.createStatement();
            String sql =
            "DECLARE\n" +
            "cli varchar2(100);\n" +
            "tip varchar2(20);\n" +
            "mon float;\n" +
            " cursor reporte is\n" +
            "   select c.nomCli,c.tipCli,sum(a.canDet*a.preDet) as monto\n" +
            "   from detalle_venta a \n" +
            "   inner join venta b on a.venta_nroVen =b.nroVen\n" +
            "   inner join cliente c on b.cliente_codCli =c.codCli\n" +
            "   group by c.nomCli, c.tipCli;\n" +
            "   \n" +
            "begin\n" +
            "     \n" +
            "       DBMS_OUTPUT.PUT_LINE('**************** REPORTE:**********************');\n" +
            "       DBMS_OUTPUT.PUT_LINE('*CLIENTE****TIPO CLIENTE****MONTO COMPRADO*');\n" +
            "   for f in reporte\n" +
            "   loop \n" +
            "   \n" +
            "   \n" +
            "   DBMS_OUTPUT.PUT_LINE(f.nomCli||' '||f.tipCli||' '||f.monto);\n" +
            "   end loop;\n" +
            "   DBMS_OUTPUT.PUT_LINE('Responsable del Reporte: Marco Castillo');\n" +
            "   DBMS_OUTPUT.PUT_LINE('Fecha: ' ||TO_CHAR(sysdate, 'fmDAY, DD \"DE\" MONTH \"DE\" YYYY'));\n" +
            "   DBMS_OUTPUT.PUT_LINE('');\n" +
            "   end;";
           
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

