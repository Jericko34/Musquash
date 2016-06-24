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
public class Client {

    private String nomClient;
    private String prenomClient;
    private String adresse;
    private int telephone;
    private int idclient;
    private int adherent;

    public Client() {
    }

    public Client(String a, String b, String c, int d, int e, int f) {
        this.nomClient = a;
        this.prenomClient = b;
        this.adresse = c;
        this.telephone = d;
        this.idclient = e;
        this.adherent = f;
    }

    /**
     * @return the nomClient
     */
    public String getNomClient() {
        return nomClient;
    }

    /**
     * @param nomClient the nomClient to set
     */
    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    /**
     * @return the prenomClient
     */
    public String getPrenomClient() {
        return prenomClient;
    }

    /**
     * @param prenomClient the prenomClient to set
     */
    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the telephone
     */
    public int getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the idclient
     */
    public int getIdclient() {
        return idclient;
    }

    /**
     * @param idclient the idclient to set
     */
    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    /**
     * @return the adherent
     */
    public int getAdherent() {
        return adherent;
    }

    /**
     * @param adherent the adherent to set
     */
    public void setAdherent(int adherent) {
        this.adherent = adherent;
    }

}
