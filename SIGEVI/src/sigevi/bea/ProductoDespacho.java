package sigevi.bea;

public class ProductoDespacho {


    private Integer codProDes;
    private String nomDes;
    private String nomPro;
    private long combinacion;
    private Integer producto_codPro;
    private Integer despacho_codDes;

    public Integer getCodProDes() {
        return codProDes;
    }

    public void setCodProDes(Integer codProDes) {
        this.codProDes = codProDes;
    }

    public String getNomDes() {
        return nomDes;
    }

    public void setNomDes(String nomDes) {
        this.nomDes = nomDes;
    }

    public String getNomPro() {
        return nomPro;
    }

    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }

    public long getCombinacion() {
        return combinacion;
    }

    public void setCombinacion(long combinacion) {
        this.combinacion = combinacion;
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
