package sigevi.bea;

public class Producto {
    private Integer codPro;

    private String nomPro;

    private Double stoPro;

    private String imagen;

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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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
}