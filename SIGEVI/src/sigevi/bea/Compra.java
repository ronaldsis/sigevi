package sigevi.bea;

import java.util.Date;

public class Compra {
    private Integer nroCop;

    private String nroCom;

    private String tipCom;

    private Date fecCom;

    private Integer usuario_codUsu;

    private Integer proveedor_codPrv;

    public Integer getNroCop() {
        return nroCop;
    }

    public void setNroCop(Integer nroCop) {
        this.nroCop = nroCop;
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

    public Date getFecCom() {
        return fecCom;
    }

    public void setFecCom(Date fecCom) {
        this.fecCom = fecCom;
    }

    public Integer getUsuario_codUsu() {
        return usuario_codUsu;
    }

    public void setUsuario_codUsu(Integer usuario_codUsu) {
        this.usuario_codUsu = usuario_codUsu;
    }

    public Integer getProveedor_codPrv() {
        return proveedor_codPrv;
    }

    public void setProveedor_codPrv(Integer proveedor_codPrv) {
        this.proveedor_codPrv = proveedor_codPrv;
    }
}