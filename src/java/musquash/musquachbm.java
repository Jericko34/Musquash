/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musquash;

import classdb.Client;
import classdb.Reservation;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Benjamin
 */
@ManagedBean
@RequestScoped
public class musquachbm {

    private Connexion maconnexion = new Connexion();
    private List <Client> clients = new ArrayList<>();
    private List <Reservation> reservations = new ArrayList<>();

    /**
     * Creates a new instance of musquachbm
     */
    public musquachbm() {
    }

    public void listedeclient() throws SQLException  {

        setClients(maconnexion.RequeteSelectClient());
    }
    
    public void listedereservation() throws SQLException  {

        setReservations(maconnexion.RequeteSelectReservation());
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

    /**
     * @return the resultat
     */
    public List <Client> getResultat() {
        return getClients();
    }

    /**
     * @param resultat the resultat to set
     */
    public void setResultat(List <Client> resultat) {
        this.setClients(resultat);
    }

    /**
     * @return the clients
     */
    public List <Client> getClients() {
        return clients;
    }

    /**
     * @param clients the clients to set
     */
    public void setClients(List <Client> clients) {
        this.clients = clients;
    }

    /**
     * @return the reservations
     */
    public List <Reservation> getReservations() {
        return reservations;
    }

    /**
     * @param reservations the reservations to set
     */
    public void setReservations(List <Reservation> reservations) {
        this.reservations = reservations;
    }
    
}
