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
    private ArrayList<Zone> zones = new ArrayList<Zone>();
    private int trackingNummer = 0;
    private int persCounter = 0;

    public TestData(String url) {
        String csvFile1 = url + "festival.csv";
        String csvFile2 = url + "klanten.csv";
        festivals = new ArrayList<Festival>();
        kopers = new ArrayList<Koper>();
        random = new Random();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        readCsv(csvFile1, 0);
        readCsv(csvFile2, 1);
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
            int amountDays = random.nextInt(4);
            Calendar cal = Calendar.getInstance();
            cal.setTime(festival.getStartDate());
            cal.add(Calendar.DATE, amountDays);
            festival.setEindDate(cal.getTime());
            generateTicketTypes(amountDays, festival, counter);
            generateZones(festival);

            for(int i=0; i<amountDays; i++){
                generateFestivalDays(festival.getStartDate(),i, festival);
            }
        }
    }

    private void readCsv(String url, int index){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        int counter = 0;
        Random random = new Random();
        try {

            br = new BufferedReader(new FileReader(url));
            while ((line = br.readLine()) != null) {
                if (counter == 0){
                    counter++;
                }else{
                    if(index == 0){
                        String[] festivalString = line.split(cvsSplitBy);
                        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yy");

                        Festival festival = new Festival();
                        festival.setNaam(festivalString[0]);
                        festival.setLocatie(festivalString[1]);
                        festival.setStartDate(sdf.parse(festivalString[2]));
                        festivals.add(festival);
                    }else{
                        String[] koperString = line.split(cvsSplitBy);
                        Koper koper = new Koper();
                        koper.setNaam(koperString[0]);
                        kopers.add(koper);
                    }
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
        int aantalOptredens = random.nextInt(3)+6;
        Calendar endPrevious = Calendar.getInstance();
        endPrevious.setTime(cal.getTime());
        endPrevious.set(Calendar.HOUR_OF_DAY, 12);
        endPrevious.set(Calendar.MINUTE, 0);
        endPrevious.set(Calendar.SECOND, 0);
        endPrevious.set(Calendar.MILLISECOND, 0);

        generateTicketsAndTracking(dag, ticketTypes);
        for(int i = 0; i < aantalOptredens; i++){
            endPrevious = generateOptredens(endPrevious, i, dag);
        }
        session.saveOrUpdate(dag);


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
        session.saveOrUpdate(optreden);


        return cal;


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
            ticket.setBarcode("8711700735179");
            if(i == 0){
                ticket.setTicketType(ticketTypes.get(2));
            }else if (i == 1){
                ticket.setTicketType(ticketTypes.get(1));
            }else if ((i == 2) || (i == 3 ) || ( i == 4) || ( i == 5)){
                ticket.setTicketType(ticketTypes.get(0));
            }else if ((i == 6) || (i == 7) || ( i == 8) || ( i == 9)){
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
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.HOUR_OF_DAY, 11);
            if(cal.get(Calendar.YEAR)== 2014){
                for(int index = 0; index < 5; index++){
                    for(Zone zone: zones){
                        Tracking trackingIn = new Tracking();
                        trackingIn.setInOut(0);
                        trackingIn.setTrackingNummer(trackingNummer);
                        cal.add(Calendar.MINUTE, 20);
                        trackingIn.setTimestamp(cal.getTime());
                        trackingIn.setZone(zone);
                        session.saveOrUpdate(trackingIn);

                        Tracking trackingOut = new Tracking();
                        trackingOut.setInOut(1);
                        cal.add(Calendar.MINUTE, 20);
                        trackingOut.setTrackingNummer(trackingNummer);
                        trackingOut.setTimestamp(cal.getTime());
                        trackingOut.setZone(zone);
                        session.saveOrUpdate(trackingOut);
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
