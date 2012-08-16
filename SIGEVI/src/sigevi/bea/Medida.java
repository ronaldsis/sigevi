package sigevi.bea;

public class Medida {
    private Integer codMed;
    private String nomMed;
    private String simMed;
    private String desMed;

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

    public Integer getCodMed() {
        return codMed;
    }

    public void setCodMed(Integer codMed) {
        this.codMed = codMed;
    }

    public String getDesMed() {
        return desMed;
    }

    public void setDesMed(String desMed) {
        this.desMed = desMed;
    }
}