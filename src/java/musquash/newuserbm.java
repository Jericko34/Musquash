/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musquash;

import classdb.Client;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Darcel
 */
public class newuserbm extends musquachbm {
    
    private Connexion maconnexion = new Connexion();
    private String nom;
    private String prenom;
    private String adresse;
    private int telephone;
    private int id;
    private int numero;

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void save(){
        maconnexion.LancerLaConnexion();
        Client cli = new Client(nom, prenom, adresse, telephone, id, numero);
        if (!this.nom.isEmpty() && !this.prenom.isEmpty() && !this.adresse.isEmpty()){
            try {
                maconnexion.InsertionReservation(cli);
            } catch (SQLException ex) {
                Logger.getLogger(newuserbm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @return the maconnexion
     */
    public Connexion getMaconnexion() {
        return maconnexion;
    }

    /**
     * @param maconnexion the maconnexion to set
     */
    public void setMaconnexion(Connexion maconnexion) {
        this.maconnexion = maconnexion;
    }
    
    
}
