package sigevi.bea;

public class DetalleVenta {
    private Integer nroDet;

    private Double canDet;

    private Double preDet;

    private Integer venta_nroVen;

    private Integer producto_codPro;

    public Integer getNroDet() {
        return nroDet;
    }

    public void setNroDet(Integer nroDet) {
        this.nroDet = nroDet;
    }

    public Double getCanDet() {
        return canDet;
    }

    public void setCanDet(Double canDet) {
        this.canDet = canDet;
    }

    public Double getPreDet() {
        return preDet;
    }

    public void setPreDet(Double preDet) {
        this.preDet = preDet;
    }

    public Integer getVenta_nroVen() {
        return venta_nroVen;
    }

    public void setVenta_nroVen(Integer venta_nroVen) {
        this.venta_nroVen = venta_nroVen;
    }

    public Integer getProducto_codPro() {
        return producto_codPro;
    }

    public void setProducto_codPro(Integer producto_codPro) {
        this.producto_codPro = producto_codPro;
    }
}