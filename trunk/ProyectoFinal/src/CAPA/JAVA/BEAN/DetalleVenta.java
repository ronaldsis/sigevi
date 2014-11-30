package CAPA.JAVA.BEAN;

public class DetalleVenta {

    int codigo, numVenta, item, codPro, can;
    double precio, subTot;

    public DetalleVenta(int codigo, int numVenta, int item, int codPro, int can, double precio, double subTot) {
        this.codigo = codigo;
        this.numVenta = numVenta;
        this.item = item;
        this.codPro = codPro;
        this.can = can;
        this.precio = precio;
        this.subTot = subTot;
    }

    public DetalleVenta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public int getNumVenta() {
        return numVenta;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }

    public double getSubTot() {
        return subTot;
    }

    public void setSubTot(double subTot) {
        this.subTot = subTot;
    }
}
