package sigevi.bea;

public class ProductoTipoprecio {
    private Integer codProPre;

    private Double precio;

    private Integer tipoprecio_codPre;

    private Integer producto_codPro;

    public Integer getCodProPre() {
        return codProPre;
    }

    public void setCodProPre(Integer codProPre) {
        this.codProPre = codProPre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getTipoprecio_codPre() {
        return tipoprecio_codPre;
    }

    public void setTipoprecio_codPre(Integer tipoprecio_codPre) {
        this.tipoprecio_codPre = tipoprecio_codPre;
    }

    public Integer getProducto_codPro() {
        return producto_codPro;
    }

    public void setProducto_codPro(Integer producto_codPro) {
        this.producto_codPro = producto_codPro;
    }
}