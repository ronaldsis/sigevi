/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CAPA.JAVA.BEAN;

/**
 *
 * @author User
 */
public class DetalleCompra {
    int codigo,numCompra, item, codPro, can;
    double precio,subTot;

    public DetalleCompra(int codigo,int numCompra, int item, int codPro, int can, double precio, double subTot) {
        this.codigo=codigo;
        this.numCompra = numCompra;
        this.item = item;
        this.codPro = codPro;
        this.can = can;
        this.precio=precio;
        this.subTot = subTot;
    }

    public DetalleCompra() {
        
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }

    public int getCodPro() {
        return codPro;
    }

    public void setCodPro(int codPro) {
        this.codPro = codPro;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getNumCompra() {
        return numCompra;
    }

    public void setNumCompra(int numCompra) {
        this.numCompra = numCompra;
    }

    public double getSubTot() {
        return subTot;
    }

    public void setSubTot(double subTot) {
        this.subTot = subTot;
    }
}
