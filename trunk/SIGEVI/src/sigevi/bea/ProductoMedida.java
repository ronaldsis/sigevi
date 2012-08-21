package sigevi.bea;

public class ProductoMedida {
    private Integer codProMed;
    private Integer producto_codPro;
    private Integer medida_codMed;
    private Integer codMed;
    private String nomMed;
    private String simMed;

    public Integer getCodProMed() {
        return codProMed;
    }

    public void setCodProMed(Integer codProMed) {
        this.codProMed = codProMed;
    }

    public Integer getProducto_codPro() {
        return producto_codPro;
    }

    public void setProducto_codPro(Integer producto_codPro) {
        this.producto_codPro = producto_codPro;
    }

    public Integer getMedida_codMed() {
        return medida_codMed;
    }

    public void setMedida_codMed(Integer medida_codMed) {
        this.medida_codMed = medida_codMed;
    }

    public Integer getCodMed() {
        return codMed;
    }

    public void setCodMed(Integer codMed) {
        this.codMed = codMed;
    }

    public String getNomMed() {
        return nomMed;
    }

    public void setNomMed(String nomMed) {
        this.nomMed = nomMed;
    }

    public String getSimMed() {
        return simMed;
    }

    public void setSimMed(String simMed) {
        this.simMed = simMed;
    }

}