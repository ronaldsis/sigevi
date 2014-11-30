package CAPA.JAVA.UTIL;
import java.sql.*;
public class ConexionBD {

    public static Connection getConexionBD(){
        
        Connection cn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost/proyectofinal","root","root");
            System.out.println("Se conecto");
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("No se conecto");
        }
        
        return cn;

    }
    
    public static void main(String[] args) {
        
        getConexionBD();
    }
    
}
