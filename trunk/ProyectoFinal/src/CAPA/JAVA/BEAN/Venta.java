
package CAPA.JAVA.BEAN;

public class Venta {

    private int numero, cliente;
    private String fecha;
    private String tcomprobante;
    private double tventa;

    public Venta(int numero, String fecha, String tcomprobante, int cliente, double tventa) {
        this.numero = numero;
        this.cliente = cliente;
        this.fecha = fecha;
        this.tcomprobante = tcomprobante;
        this.tventa = tventa;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTcomprobante() {
        return tcomprobante;
    }

    public void setTcomprobante(String tcomprobante) {
        this.tcomprobante = tcomprobante;
    }

    public double getTventa() {
        return tventa;
    }

    public void setTventa(double tventa) {
        this.tventa = tventa;
    }
}
