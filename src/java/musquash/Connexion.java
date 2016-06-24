/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musquash;

import classdb.Client;
import java.sql.Connection;
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
    private List <Client> rep = new ArrayList<>();
    private List <Client> clients = new ArrayList<>();

    public List<Client> LancerLaConnexion() {
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
        try {
            rep = this.RequeteSelect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rep;

    }

    public List<Client> RequeteSelect() throws SQLException {
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
}
