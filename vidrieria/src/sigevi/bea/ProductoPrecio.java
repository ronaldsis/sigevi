package sigevi.bea;


public class ProductoPrecio {
    private Integer codProPre;
    private Integer producto_codPro;
    private Integer producto_medida_codProMed;
    private Integer producto_despacho_codProDes;
    private long combinacion;
    private String nomMed;
    private String nomDes;
    private Double precio;

    public Integer getCodProPre() {
        return codProPre;
    }

    public void setCodProPre(Integer codProPre) {
        this.codProPre = codProPre;
    }

    public Integer getProducto_codPro() {
        return producto_codPro;
    }

    public void setProducto_codPro(Integer producto_codPro) {
        this.producto_codPro = producto_codPro;
    }

    public Integer getProducto_medida_codProMed() {
        return producto_medida_codProMed;
    }

    public void setProducto_medida_codProMed(Integer producto_medida_codProMed) {
        this.producto_medida_codProMed = producto_medida_codProMed;
    }

    public Integer getProducto_despacho_codProDes() {
        return producto_despacho_codProDes;
    }

    public void setProducto_despacho_codProDes(Integer producto_despacho_codProDes) {
        this.producto_despacho_codProDes = producto_despacho_codProDes;
    }

    public long getCombinacion() {
        return combinacion;
    }

    public void setCombinacion(long combinacion) {
        this.combinacion = combinacion;
    }

    public String getNomMed() {
        return nomMed;
    }

    public void setNomMed(String nomMed) {
        this.nomMed = nomMed;
    }

    public String getNomDes() {
        return nomDes;
    }

    public void setNomDes(String nomDes) {
        this.nomDes = nomDes;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

   }