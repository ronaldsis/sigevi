package sigevi.bea;

import java.util.Date;

public class Venta {
    private Integer nroVen;

    private String nroCom;

    private String tipCom;

    private Date fecVen;

    private Integer usuario_codUsu;

    private Integer cliente_codCli;

    public Integer getNroVen() {
        return nroVen;
    }

    public void setNroVen(Integer nroVen) {
        this.nroVen = nroVen;
    }

    public String getNroCom() {
        return nroCom;
    }

    public void setNroCom(String nroCom) {
        this.nroCom = nroCom;
    }

    public String getTipCom() {
        return tipCom;
    }

    public void setTipCom(String tipCom) {
        this.tipCom = tipCom;
    }

    public Date getFecVen() {
        return fecVen;
    }

    public void setFecVen(Date fecVen) {
        this.fecVen = fecVen;
    }

    public Integer getUsuario_codUsu() {
        return usuario_codUsu;
    }

    public void setUsuario_codUsu(Integer usuario_codUsu) {
        this.usuario_codUsu = usuario_codUsu;
    }

    public Integer getCliente_codCli() {
        return cliente_codCli;
    }

    public void setCliente_codCli(Integer cliente_codCli) {
        this.cliente_codCli = cliente_codCli;
    }
}