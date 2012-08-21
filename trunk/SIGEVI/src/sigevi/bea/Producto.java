package sigevi.bea;

public class Producto {
    private Integer codPro;

    private String nomPro;

    private Double stoPro;

    private String desPro;
    
    private String nomCat;

    private Integer categoria_codCat;

    private Integer medida_codMed;

    public Integer getCodPro() {
        return codPro;
    }

    public void setCodPro(Integer codPro) {
        this.codPro = codPro;
    }

    public String getNomPro() {
        return nomPro;
    }

    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }

    public Double getStoPro() {
        return stoPro;
    }

    public void setStoPro(Double stoPro) {
        this.stoPro = stoPro;
    }

    public Integer getCategoria_codCat() {
        return categoria_codCat;
    }

    public void setCategoria_codCat(Integer categoria_codCat) {
        this.categoria_codCat = categoria_codCat;
    }

    public Integer getMedida_codMed() {
        return medida_codMed;
    }

    public void setMedida_codMed(Integer medida_codMed) {
        this.medida_codMed = medida_codMed;
    }
    
     public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }

    public String getNomCat() {
        return nomCat;
    }

    public String getDesPro() {
        return desPro;
    }

    public void setDesPro(String desPro) {
        this.desPro = desPro;
    }
}