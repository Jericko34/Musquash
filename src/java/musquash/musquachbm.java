/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musquash;

import classdb.Client;
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
    private List <Client> resultat = new ArrayList<>();

    /**
     * Creates a new instance of musquachbm
     */
    public musquachbm() {
    }

    public void listedeclient() throws SQLException {
        try {
        resultat = maconnexion.RequeteSelectClient();
        } catch (SQLException e){e.printStackTrace();}
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
        return resultat;
    }

    /**
     * @param resultat the resultat to set
     */
    public void setResultat(List <Client> resultat) {
        this.resultat = resultat;
    }
    
}
