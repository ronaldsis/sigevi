/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAPA.JAVA.BEAN;

public class Compra {
    
    private int numero, ncomprobante;
    private String proveedor;
    private String fecha;
    private String tcomprobante;
    private String fpago;
    private double tcompra;

    public Compra() {
        
    }

    public Compra(int numcom, String proveed, String fecha, String tcomprobante, String fpago, int ncomprobante, double tcompra) {
        this.numero = numcom;
        this.proveedor = proveed;
        this.fecha = fecha;
        this.tcomprobante = tcomprobante;
        this.ncomprobante= ncomprobante;
        this.fpago = fpago;
        this.tcompra = tcompra;
    }


    public int getNcomprobante() {
        return ncomprobante;
    }

    public void setNcomprobante(int ncomprobante) {
        this.ncomprobante = ncomprobante;
    }

    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFpago() {
        return fpago;
    }

    public void setFpago(String fpago) {
        this.fpago = fpago;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public double getTcompra() {
        return tcompra;
    }

    public void setTcompra(double tcompra) {
        this.tcompra = tcompra;
    }

    public String getTcomprobante() {
        return tcomprobante;
    }

    public void setTcomprobante(String tcomprobante) {
        this.tcomprobante = tcomprobante;
    }
   
}