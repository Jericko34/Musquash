/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classdb;

/**
 *
 * @author Benjamin
 */
public class Reservation {
    private String DATE;
    private int HEUREDEBUT;
    private int HEUREFIN;
    private int IDPROF;
    private int IDRESERVATION;
    private int IDSALLE;
    private int IDCOURCOLLECTIF;
    private int TYPEACTIVITE;

    public Reservation(String DATE, int HEUREDEBUT, int HEUREFIN, int IDPROF, int IDRESERVATION, int IDSALLE, int IDCOURCOLLECTIF, int TYPEACTIVITE) {
        this.DATE = DATE;
        this.HEUREDEBUT = HEUREDEBUT;
        this.HEUREFIN = HEUREFIN;
        this.IDPROF = IDPROF;
        this.IDRESERVATION = IDRESERVATION;
        this.IDSALLE = IDSALLE;
        this.IDCOURCOLLECTIF = IDCOURCOLLECTIF;
        this.TYPEACTIVITE = TYPEACTIVITE;
    }

    /**
     * @return the DATE
     */
    public String getDATE() {
        return DATE;
    }

    /**
     * @param DATE the DATE to set
     */
    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    /**
     * @return the HEUREDEBUT
     */
    public int getHEUREDEBUT() {
        return HEUREDEBUT;
    }

    /**
     * @param HEUREDEBUT the HEUREDEBUT to set
     */
    public void setHEUREDEBUT(int HEUREDEBUT) {
        this.HEUREDEBUT = HEUREDEBUT;
    }

    /**
     * @return the HEUREFIN
     */
    public int getHEUREFIN() {
        return HEUREFIN;
    }

    /**
     * @param HEUREFIN the HEUREFIN to set
     */
    public void setHEUREFIN(int HEUREFIN) {
        this.HEUREFIN = HEUREFIN;
    }

    /**
     * @return the IDPROF
     */
    public int getIDPROF() {
        return IDPROF;
    }

    /**
     * @param IDPROF the IDPROF to set
     */
    public void setIDPROF(int IDPROF) {
        this.IDPROF = IDPROF;
    }

    /**
     * @return the IDRESERVATION
     */
    public int getIDRESERVATION() {
        return IDRESERVATION;
    }

    /**
     * @param IDRESERVATION the IDRESERVATION to set
     */
    public void setIDRESERVATION(int IDRESERVATION) {
        this.IDRESERVATION = IDRESERVATION;
    }

    /**
     * @return the IDSALLE
     */
    public int getIDSALLE() {
        return IDSALLE;
    }

    /**
     * @param IDSALLE the IDSALLE to set
     */
    public void setIDSALLE(int IDSALLE) {
        this.IDSALLE = IDSALLE;
    }

    /**
     * @return the IDCOURCOLLECTIF
     */
    public int getIDCOURCOLLECTIF() {
        return IDCOURCOLLECTIF;
    }

    /**
     * @param IDCOURCOLLECTIF the IDCOURCOLLECTIF to set
     */
    public void setIDCOURCOLLECTIF(int IDCOURCOLLECTIF) {
        this.IDCOURCOLLECTIF = IDCOURCOLLECTIF;
    }

    /**
     * @return the TYPEACTIVITE
     */
    public int getTYPEACTIVITE() {
        return TYPEACTIVITE;
    }

    /**
     * @param TYPEACTIVITE the TYPEACTIVITE to set
     */
    public void setTYPEACTIVITE(int TYPEACTIVITE) {
        this.TYPEACTIVITE = TYPEACTIVITE;
    }
    
    
}
