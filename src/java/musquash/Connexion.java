/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musquash;

import classdb.Client;
import classdb.Reservation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Benjamin
 */
public class Connexion {

    public Connexion() {
    }

    private Connection maconnec = null;
    private List <Client> clients = new ArrayList<>();
    private List <Reservation> reservations = new ArrayList<>();

    public void LancerLaConnexion() {
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Pas de drivers JDBC?");
            e.printStackTrace();

        }

        System.out.println("Oracle JDBC Driver OK!");

        try {

            maconnec = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle.montpellier.epsi.fr:4521:bdaolap", "CL1GPE3",
                    "bzs2T89");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

        }

        if (maconnec != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

    public List<Client> RequeteSelectClient() throws SQLException {
        Statement requ = maconnec.createStatement();
        ResultSet request = null;
        String vNOMCLIENT;
        String vPRENOMCLIENT;
        String vADRESSE;
        int vTELEPHONE;
        int vIDCLIENT;
        int vADHERENT;
        String a = "Select NOMCLIENT, PRENOMCLIENT, ADRESSE, TELEPHONE, IDCLIENT, ADHERENT FROM CLIENT";

        try {
            request = requ.executeQuery(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (request.next()) {

            vNOMCLIENT = request.getString(1);
            vPRENOMCLIENT = request.getString(2);
            vADRESSE = request.getString(3);
            vTELEPHONE = Integer.parseInt(request.getString(4));
            vIDCLIENT = Integer.parseInt(request.getString(5));
            vADHERENT = Integer.parseInt(request.getString(6));
            Client b = new Client (vNOMCLIENT, vPRENOMCLIENT, vADRESSE, vTELEPHONE, vIDCLIENT, vADHERENT);
            clients.add(b);
            
        }
        return clients;
    }
    public List<Reservation> RequeteSelectReservation() throws SQLException {
        Statement requ = maconnec.createStatement();
        ResultSet request = null;
        String vDATERESERVATION;
        String  vHEUREDEBUT;
        String vHEUREFIN;
        int vIDPROF;
        int vIDRESERVATION;
        int vIDSALLE;
        int vIDCOURCOLLECTIF;
        int vTYPEACTIVITE;
        String a = "Select DATERESERVATION, HEUREDEBUT, HEUREFIN, IDPROF, IDRESERVATION, IDSALLE, IDCOURCOLLECTIF, TYPEACTIVITE FROM RESERVATION";

        try {
            request = requ.executeQuery(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (request.next()) {

            vDATERESERVATION = request.getString(1);
            vHEUREDEBUT = request.getString(2);
            vHEUREFIN = request.getString(3);
            vIDPROF = Integer.parseInt(request.getString(4));
            vIDRESERVATION = Integer.parseInt(request.getString(5));
            vIDSALLE = Integer.parseInt(request.getString(6));
            vIDCOURCOLLECTIF = Integer.parseInt(request.getString(7));
            vTYPEACTIVITE = Integer.parseInt(request.getString(8));
            Reservation b = new Reservation (vDATERESERVATION, vHEUREDEBUT, vHEUREFIN,vIDPROF,vIDRESERVATION,vIDSALLE,vIDCOURCOLLECTIF,vTYPEACTIVITE);
            reservations.add(b);
            
        }
        return reservations;
    }
}
