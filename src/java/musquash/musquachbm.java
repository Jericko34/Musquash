/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musquash;

//import calendar.ScheduleView;

import classdb.Client;
import classdb.Reservation;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author Benjamin
 */
@ManagedBean
@SessionScoped
public class musquachbm {

    private Connexion maconnexion = new Connexion();
    private List<Client> clients = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    /**
     * Creates a new instance of musquachbm
     */
    public musquachbm() {
    }

    public void lancerconnexion() {
        maconnexion.LancerLaConnexion();
    }

    public void listedeclient() throws SQLException {

        setClients(maconnexion.RequeteSelectClient());
    }

    public void listedereservation() throws SQLException {

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
    public List<Client> getResultat() {
        return getClients();
    }

    /**
     * @param resultat the resultat to set
     */
    public void setResultat(List<Client> resultat) {
        this.setClients(resultat);
    }

    /**
     * @return the clients
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * @param clients the clients to set
     */
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    /**
     * @return the reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * @param reservations the reservations to set
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
        init();
    }
    
    private ScheduleModel eventModel;
     
    private ScheduleModel lazyEventModel;
 
    private ScheduleEvent event = new DefaultScheduleEvent();
    
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HHmm");
    
    private Date dateDeb;
    
    private Date dateFin;
    
    private String salle = "0";
 
    @PostConstruct
    public void init() {
        setEventModel(new DefaultScheduleModel());
        for (int i = 0; i<reservations.size(); i++){
            if (!"0".equals(salle)){
                if(reservations.get(i).getIDSALLE() == Integer.parseInt(salle)){
                    String dateD = reservations.get(i).getDATE().substring(0, 10) + " " + reservations.get(i).getHEUREDEBUT();
                    String dateF = reservations.get(i).getDATE().substring(0, 10) + " " + reservations.get(i).getHEUREFIN();
                    Date dateDebutR = new Date();
                    Date dateFinR = new Date();
                    try {
                        dateDebutR = getSimpleDateFormat().parse(dateD);
                        dateFinR = getSimpleDateFormat().parse(dateF);
                    } catch (ParseException ex) {
                        Logger.getLogger(musquachbm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    getEventModel().addEvent(new DefaultScheduleEvent("Réservé", dateDebutR, dateFinR));
                }
            }else{
                String dateD = reservations.get(i).getDATE().substring(0, 10) + " " + reservations.get(i).getHEUREDEBUT();
                    String dateF = reservations.get(i).getDATE().substring(0, 10) + " " + reservations.get(i).getHEUREFIN();
                    Date dateDebutR = new Date();
                    Date dateFinR = new Date();
                    try {
                        dateDebutR = getSimpleDateFormat().parse(dateD);
                        dateFinR = getSimpleDateFormat().parse(dateF);
                    } catch (ParseException ex) {
                        Logger.getLogger(musquachbm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    getEventModel().addEvent(new DefaultScheduleEvent("Réservé", dateDebutR, dateFinR));
            }
        }
        
    }
     
    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);    //set random day of month
         
        return date.getTime();
    }
     
    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);
         
        return calendar.getTime();
    }
     
    public ScheduleModel getEventModel() {
        return eventModel;
    }
     
    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }
 
    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
 
        return calendar;
    }
     
    private Date previousDay8Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 8);
         
        return t.getTime();
    }
     
    private Date previousDay11Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 11);
         
        return t.getTime();
    }
     
    private Date today1Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 1);
         
        return t.getTime();
    }
     
    private Date theDayAfter3Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);     
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 3);
         
        return t.getTime();
    }
 
    private Date today6Pm() {
        Calendar t = (Calendar) today().clone(); 
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 6);
         
        return t.getTime();
    }
     
    private Date nextDay9Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 9);
         
        return t.getTime();
    }
     
    private Date nextDay11Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 11);
         
        return t.getTime();
    }
     
    private Date fourDaysLater3pm() {
        Calendar t = (Calendar) today().clone(); 
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
        t.set(Calendar.HOUR, 3);
         
        return t.getTime();
    }
     
    public ScheduleEvent getEvent() {
        return event;
    }
 
    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
     
    public void addEvent(ActionEvent actionEvent) {
        if(getEvent().getId() == null){
            Reservation res = new Reservation(getEvent().getStartDate().toString().substring(0, 10), getEvent().getStartDate().toString().substring(11, 15), getEvent().getEndDate().toString().substring(11, 15), 1, 19999, Integer.parseInt(salle), 1, 1);
            try {
                maconnexion.InsertionReservation(res);
            } catch (SQLException ex) {
                Logger.getLogger(musquachbm.class.getName()).log(Level.SEVERE, null, ex);
            }
            getEventModel().addEvent(getEvent());
        }else{
            Reservation res = new Reservation(getEvent().getStartDate().toString().substring(0, 10), getEvent().getStartDate().toString().substring(11, 15), getEvent().getEndDate().toString().substring(11, 15), 1, 19999, Integer.parseInt(salle), 1, 1);
            try {
                maconnexion.InsertionReservation(res);
            } catch (SQLException ex) {
                Logger.getLogger(musquachbm.class.getName()).log(Level.SEVERE, null, ex);
            }
            getEventModel().updateEvent(getEvent());
        }
        setEvent(new DefaultScheduleEvent());
    }
     
    public void onEventSelect(SelectEvent selectEvent) {
        setEvent((ScheduleEvent) selectEvent.getObject());
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
        setEvent(new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject()));
    }
     
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @param eventModel the eventModel to set
     */
    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    /**
     * @return the simpleDateFormat
     */
    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    /**
     * @param simpleDateFormat the simpleDateFormat to set
     */
    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    /**
     * @return the dateDeb
     */
    public Date getDateDeb() {
        return dateDeb;
    }

    /**
     * @param dateDeb the dateDeb to set
     */
    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    /**
     * @return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * @param dateFin the dateFin to set
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * @return the salle
     */
    public String getSalle() {
        return salle;
    }

    /**
     * @param salle the salle to set
     */
    public void setSalle(String salle) {
        this.salle = salle;
    }

    
    public void afficherSalle(){
        getEventModel().clear();
        init();
    }
}
