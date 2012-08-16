package sigevi.bea;

public class DetalleCompra {
    private Integer nroDet;

    private Double canDet;

    private Double preDet;

    private Integer compra_nroCop;

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

    public Integer getCompra_nroCop() {
        return compra_nroCop;
    }

    public void setCompra_nroCop(Integer compra_nroCop) {
        this.compra_nroCop = compra_nroCop;
    }

    public Integer getProducto_codPro() {
        return producto_codPro;
    }

    public void setProducto_codPro(Integer producto_codPro) {
        this.producto_codPro = producto_codPro;
    }
}