package sigevi.bea;

public class Producto {
    private Integer codPro;
    private String nomPro;
    private Double stoPro;
    private String desPro;
    private String nomCat;
    private Double preVen;
    private Double preCom;
    private Integer categoria_codCat;

    public Double getPreVen() {
        return preVen;
    }

    public void setPreVen(Double preVen) {
        this.preVen = preVen;
    }

    public Double getPreCom() {
        return preCom;
    }

    public void setPreCom(Double preCom) {
        this.preCom = preCom;
    }

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