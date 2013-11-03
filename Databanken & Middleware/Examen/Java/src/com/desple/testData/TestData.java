package com.desple.testData;

import com.desple.model.*;
import com.desple.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Thierry
 * Date: 26/10/13
 * Time: 15:16
 * To change this template use File | Settings | File Templates.
 */
public class TestData {
    private Random random;
    private Session session;
    private ArrayList<Festival> festivals;
    private ArrayList<Koper> kopers;
    private ArrayList<TicketType> ticketTypes = new ArrayList<TicketType>();
    private ArrayList<Zone> zones;
    private ArrayList<Artiest> artiests;
    private int trackingNummer = 0;
    private int persCounter = 0;
    private Transaction tx;

    public TestData(String url) {
        festivals = new ArrayList<Festival>();
        kopers = new ArrayList<Koper>();
        random = new Random();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
        festivals = Reader.readFestivals(url+ "festival.csv");
        kopers = Reader.readKopers(url+"klanten.csv");
        artiests = Reader.readArtiest(url + "artiesten.csv");
        run();
        tx.commit();
    }

    private void run() {

        for(int i = 0; i < kopers.size(); i++){
            Koper koper = kopers.get(i);
            if (i <  600){
                koper.setType(EKoperType.PARTICULIER);
            }else if (i < 700){
                koper.setType(EKoperType.PERS);
            }else{
                koper.setType(EKoperType.BEDRIJF);
            }
            session.saveOrUpdate(koper);
        }
        for(int counter = 0; counter < festivals.size() ; counter++){
            Festival festival = festivals.get(counter);
            session.saveOrUpdate(festival);
            int amountDays = random.nextInt(3) + 1;
            Calendar cal = Calendar.getInstance();
            cal.setTime(festival.getStartDate());
            cal.add(Calendar.DATE, amountDays);
            festival.setEindDate(cal.getTime());
            zones = new ArrayList<Zone>();
            generateTicketTypes(amountDays, festival, counter);
            generateZones(festival);

            for(int i=0; i<amountDays; i++){
                generateFestivalDays(festival.getStartDate(),i, festival);
            }
        }
    }



    private void generateZones(Festival festival) {

        for(EZoneType zoneType : EZoneType.values()){
            Zone zone = new Zone();
            zone.setFestival(festival);
            zone.setType(zoneType);
            for(TicketType ticketType : ticketTypes){
                if(zoneType == EZoneType.VIP )  {
                    if( ETicketType.VIP == ticketType.getType() ){
                        zone.addTicketType(ticketType);
                    }
                } else if(zoneType == EZoneType.BACKSTAGE){
                    if( ETicketType.PERS == ticketType.getType()){
                        zone.addTicketType(ticketType);
                    }
                } else if(zoneType == EZoneType.CAMPING){
                    if( ETicketType.COMBI == ticketType.getType()){
                        zone.addTicketType(ticketType);
                    }
                } else{
                    zone.addTicketType(ticketType);
                }

            }
            if (zone.getType() == EZoneType.PUBLIEKPODIUM1){
                for(Zone myZone: zones){
                    if (myZone.getType() == EZoneType.PODIUM1){
                        zone.setZone(myZone);
                    }
                }
            }else if (zone.getType() == EZoneType.PUBLIEKPODIUM2){
                for(Zone myZone: zones){
                    if(myZone.getType()== EZoneType.PODIUM2){
                        zone.setZone(myZone);
                    }
                }
            }
            zones.add(zone);

            session.saveOrUpdate(zone);
        }
    }

    private void generateTicketTypes(int amountDays, Festival festival, int multiplier) {
        TicketType normalTicket = new TicketType();
        normalTicket.setType(ETicketType.NORMAL);
        normalTicket.setFestivalId(festival);
        normalTicket.setPrijs(50 + (multiplier*5));
        ticketTypes.add(normalTicket);
        session.saveOrUpdate(normalTicket);

        TicketType vipTicket = new TicketType();
        vipTicket.setType(ETicketType.VIP);
        vipTicket.setFestivalId(festival);
        vipTicket.setPrijs((50 + (multiplier*5))* 2);
        ticketTypes.add(vipTicket);
        session.saveOrUpdate(vipTicket);

        TicketType persTicket = new TicketType();
        persTicket.setType(ETicketType.PERS);
        persTicket.setFestivalId(festival);
        persTicket.setPrijs(50 + (multiplier * 5));
        ticketTypes.add(persTicket);
        session.saveOrUpdate(persTicket);

        //TicketType
        if (amountDays > 1){
            TicketType combiTicket = new TicketType();
            combiTicket.setType(ETicketType.COMBI);
            combiTicket.setFestivalId(festival);
            combiTicket.setPrijs((50 + (multiplier*5))* (amountDays - 0.5) );
            ticketTypes.add(combiTicket);
            session.saveOrUpdate(combiTicket);
        }
    }

    private void generateFestivalDays(Date festivalDate, int day, Festival festival){
        FestivalDag dag = new FestivalDag();
        Calendar cal = Calendar.getInstance();
        cal.setTime(festivalDate);
        cal.add(Calendar.DATE, day);
        dag.setDatum(cal.getTime());
        dag.setFestival(festival);
        System.out.println("Begin toevoegen Festival dag: " + dag.toString() + " van Festival: " + festival.toString() );
        int aantalOptredens = random.nextInt(3)+6;
        Calendar endPrevious = Calendar.getInstance();
        endPrevious.setTime(cal.getTime());
        endPrevious.set(Calendar.HOUR_OF_DAY, 12);
        endPrevious.set(Calendar.MINUTE, 0);
        endPrevious.set(Calendar.SECOND, 0);
        endPrevious.set(Calendar.MILLISECOND, 0);
        generateArtiesten();
        generateTicketsAndTracking(dag, ticketTypes);
        System.out.println("Tickets en tracking voor " + dag.toString() + " toegevoegd");
        for(int i = 0; i < aantalOptredens; i++){
            endPrevious = generateOptredens(endPrevious, i, dag);
        }
        session.saveOrUpdate(dag);
        tx.commit();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();


    }

    private Calendar generateOptredens(Calendar cal, int nummerOptreden, FestivalDag dag){


        Optreden optreden = new Optreden();


        optreden.setFestivalDag(dag);
        optreden.setStartDate(cal.getTime());
        int duur = (5 * nummerOptreden) + 50;
        cal.add(Calendar.MINUTE, duur);
        optreden.setEindDate(cal.getTime());
        optreden.setSoundCheck(true);
        optreden.setBenodigdeApparatuur(generateAperatuur());
        PersContract persContract = new PersContract();
        persContract.setKoperId(kopers.get(persCounter%kopers.size()));
        persContract.setMagFoto(random.nextBoolean());
        persContract.setMagFilmen(random.nextBoolean());
        persContract.setOptredenId(optreden);
        optreden.setZone(zones.get(random.nextInt(2)));
        optreden.setArtiest(artiests.get(random.nextInt(artiests.size())));
        session.saveOrUpdate(optreden);


        return cal;


    }

    private void generateArtiesten(){
        for(Artiest artiest: artiests){
            for(Zone zone: zones){
                if(zone.getType() == EZoneType.BACKSTAGE)
                {
                    artiest.setZone(zone);
                }
            }
            artiest.setBio(artiest.getNaam() + "'s Biography made by");
            session.saveOrUpdate(artiest);
        }
    }

    private BenodigdeApparatuur generateAperatuur(){
        int aantalMicros = random.nextInt(3)+1;
        int geluidsVersterking = random.nextInt(20) + 1;
        int lichten = random.nextInt(20) + 1;
        BenodigdeApparatuur apparatuur = new BenodigdeApparatuur();
        apparatuur.setGeluidsVersterking(geluidsVersterking);
        apparatuur.setLicht(lichten);
        apparatuur.setMicro(aantalMicros);
        session.saveOrUpdate(apparatuur);
        return apparatuur;
    }

    private void generateTicketsAndTracking(FestivalDag dag, ArrayList<TicketType> ticketTypes){
        for(int i = 0; i<7500; i++){
            trackingNummer++;

            Ticket ticket = new Ticket();
            ticket.setFestivalDag(dag);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dag.getDatum());
            long barcode = cal.getTimeInMillis() + i;
            ticket.setBarcode(barcode + "" );
            int index = i %ticketTypes.size();
            if(index == 0){
                ticket.setTicketType(ticketTypes.get(2));
            }else if (index == 1){
                ticket.setTicketType(ticketTypes.get(1));
            }else if ((index == 2) || (index == 3 ) || ( index == 4) || ( index == 5)){
                ticket.setTicketType(ticketTypes.get(0));
            }else if ((index == 6) || (index == 7) || ( index == 8) || ( index == 9)){
                if(ticketTypes.size() >= 4) {
                    ticket.setTicketType(ticketTypes.get(3));
                }else{
                    int chance = random.nextInt(3);
                    ticket.setTicketType(ticketTypes.get(chance));

                }
            }
            TicketOrder ticketOrder = null;
            if (i < ( 7500 * 0.6)){
                ticketOrder = generateTicketOrders(random.nextInt(650), ETicketOrder.WEB);
            }else{
                ticketOrder = generateTicketOrders(random.nextInt(300) + 650, ETicketOrder.HANDELAAR);
            }
            ticket.setTicketOrder(ticketOrder);
            Date date = dag.getDatum();
            cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.HOUR_OF_DAY, 11);
            if(cal.get(Calendar.YEAR)== 2014){
                for(int j = 0; j < 5; j++){
                    for(Zone zone: zones){

                        Tracking tracking = new Tracking();
                        tracking.setTrackingNummer(trackingNummer);
                        tracking.setZone(zone);
                        cal.add(Calendar.MINUTE, 20);
                        tracking.setTimestampIn(cal.getTime());
                        cal.add(Calendar.MINUTE, 20);
                        tracking.setTimestampOut(cal.getTime());
                        session.saveOrUpdate(tracking);
                    }
                }
            }
            session.saveOrUpdate(ticket);

        }
    }

    private TicketOrder generateTicketOrders(int index, ETicketOrder verkoopWijze) {
        Koper koper = kopers.get(index);
        TicketOrder ticketOrder = new TicketOrder();
        ticketOrder.setKoper(koper);
        ticketOrder.setVerkoopsWijze(verkoopWijze);
        session.saveOrUpdate(ticketOrder);
        return ticketOrder;
    }
}
