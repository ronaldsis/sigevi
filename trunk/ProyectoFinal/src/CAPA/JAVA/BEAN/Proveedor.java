/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CAPA.JAVA.BEAN;

public class Proveedor {
    private int RUC;
    private String  RaSocial;
    private String direccion;
    private int  telefono;
    private String contacto;
    private String  email;

    public Proveedor(int RUC, String RaSocial, String direccion, int telefono, String contacto, String email) {
        this.RUC = RUC;
        this.RaSocial = RaSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contacto = contacto;
        this.email = email;
    }

    public Proveedor() {
         }

    
    public int getRUC() {
        return RUC;
    }

    public void setRUC(int RUC) {
        this.RUC = RUC;
    }

    public String getRaSocial() {
        return RaSocial;
    }

    public void setRaSocial(String RaSocial) {
        this.RaSocial = RaSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
