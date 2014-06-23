/* 
               MENU DE LISTAS ENLAZADAS !!!
lista de trabajadores:
codigo
apellidos y nombres
categoria
sueldo basico
bonificacion
descuento
sueldo neto

 */

package menulista;
import java.util.*;
import javax.swing.JOptionPane;
public class Principal {
    static String codigo;
    static Nodo comienzo = null;
    static Nodo nuevo = null;
    static Nodo q = null;
    static Nodo anterior = null;
     static Nodo w=null;
    
    static class Nodo{
       String cod,ape_nom,cat;
       double sb,bon,des;
       Nodo siguiente;
    }  
    public static void main(String[] args) {
        int opc;
        do{
            opc=Integer.parseInt(JOptionPane.showInputDialog("                              MENU\n\n"
                    + "1. Crear Lista.\n"
                    + "2. Imprimir.\n"
                    + "3. Agregar.\n"
                    + "4. Eliminar.\n"
                    + "5. Ordenar.\n"
                    + "6. Salir.\n"
                    +"     Ingrese su opcion : "));
            switch(opc){
                case 1: crear();break;
                case 2: imprimir();break;
                case 3: agregar();break;
                case 4: eliminar();break;
                case 5: Collections.sort(w);
                imprimir();     
                break;
            }
        }
        while(opc!=6);
    }
    
    static void crear(){
        codigo=JOptionPane.showInputDialog("Ingrese codigo : ");
        while(codigo.compareTo("*")!=0)
        {
            nuevo = new Nodo ();
            nuevo.cod = codigo;
            nuevo.ape_nom=JOptionPane.showInputDialog("Ingrese Apellido y nombres : ");
            nuevo.cat=JOptionPane.showInputDialog("Ingrese Categoria : ");
            nuevo.sb=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Sueldo Basico : "));
            nuevo.bon=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Bonificacion : "));
            nuevo.des=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Descuento : "));
            if(comienzo==null)
            {
                comienzo = nuevo;
            }
            else
            {
                q=comienzo;
                while(q.siguiente!=null)
                     {
                            q=q.siguiente;
                     }
                q.siguiente=nuevo;
            }
            nuevo.siguiente=null;
            codigo=JOptionPane.showInputDialog("Ingrese codigo : ");
        }
    }
    
 static void imprimir(){
       Nodo t=comienzo;
       System.out.println("------------------------------------------------------------------------------------------");
       System.out.println(" CODIGO "+" APELLIDO Y NOMBRE "+" CATEGORIA "+" SUELDO BASICO "+" BONIFICACION "+" DESCUENTO "+" SUELDO NETO");
       System.out.println("------------------------------------------------------------------------------------------");
        while(t != null)
                {
                   System.out.println(t.cod+"  "+t.ape_nom+"  "+
                   t.cat+"  "+
                   t.sb+"  "+
                   t.bon+"  "+
                   t.des+"  "+(t.sb+t.bon-t.des));
                   t= t.siguiente;
                   System.out.println("------------------------------------------------------------------------------------------");
                }
    }
 
 static void agregar(){
   Nodo s=comienzo;
   codigo=JOptionPane.showInputDialog("Ingrese codigo a agregar : ");
   while(codigo.compareTo("*")!=0){
     nuevo = new Nodo ();
     nuevo.cod = codigo;
     nuevo.ape_nom=JOptionPane.showInputDialog("Ingrese Apellido y nombres : ");
     nuevo.cat=JOptionPane.showInputDialog("Ingrese Categoria : ");
     nuevo.sb=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Sueldo Basico : "));
     nuevo.bon=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Bonificacion : "));
     nuevo.des=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Descuento : "));
     while(s.siguiente!=null){
          s=s.siguiente;
     }
     s.siguiente=nuevo;
     nuevo.siguiente=null;
     codigo=JOptionPane.showInputDialog("Ingrese codigo : ");
   }
 }
 
 static void eliminar(){
    String cod_eliminar;
    Nodo u=comienzo;
    cod_eliminar=JOptionPane.showInputDialog("Ingrese el codigo del trabajador a eliminar : ");
    while(u!=null){
        if(u.cod.compareTo(cod_eliminar)==0){
           if(u==comienzo){
              comienzo=comienzo.siguiente;
           }
           else{
              anterior.siguiente=u.siguiente;
              //delete(u);
           }
        }
        anterior=u;
        u=u.siguiente;
        
    }
 }
 
 static int ordenar(){
  
    w=comienzo;
    while(w!=null){
        anterior=w;
        w=w.siguiente;
        if(w.ape_nom.compareToIgnoreCase(anterior.ape_nom)==0)
        { 
            return anterior.cod.compareToIgnoreCase(w.cod);
        }        
             anterior=w.siguiente;
             w=anterior;
        }
     anterior=w;
        return 0;
    }
  
    
}
