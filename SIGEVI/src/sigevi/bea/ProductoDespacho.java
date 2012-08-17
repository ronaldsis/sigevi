package sigevi.bea;

public class ProductoDespacho {
    private Integer codProPre;

    private Double precio;

    private Integer producto_codPro;

    private Integer despacho_codDes;

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

    public Integer getProducto_codPro() {
        return producto_codPro;
    }

    public void setProducto_codPro(Integer producto_codPro) {
        this.producto_codPro = producto_codPro;
    }

    public Integer getDespacho_codDes() {
        return despacho_codDes;
    }

    public void setDespacho_codDes(Integer despacho_codDes) {
        this.despacho_codDes = despacho_codDes;
    }
}
