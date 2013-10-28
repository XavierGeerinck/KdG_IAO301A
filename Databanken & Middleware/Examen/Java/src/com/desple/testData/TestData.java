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

    public TestData(String url) {
        String csvFile1 = url + "festival.csv";
        String csvFile2 = url + "klanten.csv";
        festivals = new ArrayList<Festival>();
        kopers = new ArrayList<Koper>();
        random = new Random();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        readCsv(csvFile1, 0);
        readCsv(csvFile2, 1);
        run();
    }

    private void run() {
        Transaction tx = session.beginTransaction();
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
            ArrayList<TicketType> ticketTypes = generateTicketTypes(amountDays, festival, counter);
            generateZones(festival, ticketTypes);

            for(int i=0; i<amountDays; i++){
                generateFestivalDays(festival.getStartDate(),i, festival, ticketTypes);
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

    private void generateZones(Festival festival, ArrayList<TicketType> ticketTypes) {
        for(EZoneTypes zoneType : EZoneTypes.values()){
            Zone zone = new Zone();
            zone.setFestival(festival);
            zone.setZoneType(zoneType);
            for(TicketType ticketType : ticketTypes){
                if(zoneType == EZoneTypes.VIP )  {
                    if( ETicketType.VIP == ticketType.getType() ){
                        zone.addTicketType(ticketType);
                    }
                } else if(zoneType == EZoneTypes.BACKSTAGE){
                    if( ETicketType.PERS == ticketType.getType()){
                        zone.addTicketType(ticketType);
                    }
                } else if(zoneType == EZoneTypes.CAMPING){
                    if( ETicketType.COMBI == ticketType.getType()){
                        zone.addTicketType(ticketType);
                    }
                } else{
                    zone.addTicketType(ticketType);
                }

            }
        }
    }

    private ArrayList<TicketType> generateTicketTypes(int amountDays, Festival festival, int multiplier) {
        ArrayList<TicketType> ticketTypes = new ArrayList<TicketType>();
        TicketType normalTicket = new TicketType();
        normalTicket.setType(ETicketType.NORMAL);
        normalTicket.setFestivalId(festival);
        normalTicket.setPrijs(50 + (multiplier*5));
        ticketTypes.add(normalTicket);

        TicketType vipTicket = new TicketType();
        vipTicket.setType(ETicketType.VIP);
        vipTicket.setFestivalId(festival);
        vipTicket.setPrijs((50 + (multiplier*5))* 2);
        ticketTypes.add(vipTicket);

        TicketType persTicket = new TicketType();
        persTicket.setType(ETicketType.PERS);
        persTicket.setFestivalId(festival);
        persTicket.setPrijs(50 + (multiplier*5));
        ticketTypes.add(persTicket);
        //TicketType
        if (amountDays > 1){
            TicketType combiTicket = new TicketType();
            combiTicket.setType(ETicketType.COMBI);
            combiTicket.setFestivalId(festival);
            combiTicket.setPrijs((50 + (multiplier*5))* (amountDays - 0.5) );
            ticketTypes.add(combiTicket);
        }
        return ticketTypes;
    }

    private void generateFestivalDays(Date festivalDate, int day, Festival festival, ArrayList<TicketType> ticketTypes){
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
        for(int i = 0; i < aantalOptredens; i++){
            endPrevious = generateOptredens(endPrevious, i, dag);
        }
        generateTickets(dag, ticketTypes );


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
        return apparatuur;
    }

    private void generateTickets(FestivalDag dag, ArrayList<TicketType> ticketTypes){

        for(int i = 0; i<7500; i++){
            int chance = random.nextInt(10);
            Ticket ticket = new Ticket();
            ticket.setFestivalDag(dag);
            ticket.setBarcode("8711700735179");
            ticket.setFestivalDag(dag);
            if(i == 0){
                ticket.setTicketType(ticketTypes.get(2));
            }else if (i == 1){
                ticket.setTicketType(ticketTypes.get(1));
            }else if ((i == 2) || (i == 3 ) || ( i == 4) || ( i == 5)){
                ticket.setTicketType(ticketTypes.get(0));
            }else if ((i == 6) || (i == 7) || ( i == 8) || ( i == 9)){
                ticket.setTicketType(ticketTypes.get(3));
            }
            TicketOrder ticketOrder = null;
            if (i < ( 7500 * 0.6)){
                ticketOrder = generateTicketOrders(random.nextInt(650), ETicketOrder.WEB);
            }else{
                ticketOrder = generateTicketOrders(random.nextInt(300) + 650, ETicketOrder.HANDELAAR);
            }
            ticket.setTicketOrder(ticketOrder);

        }
    }

    private TicketOrder generateTicketOrders(int index, ETicketOrder verkoopWijze) {
        Koper koper = kopers.get(index);
        TicketOrder ticketOrder = new TicketOrder();
        ticketOrder.setKoper(koper);
        ticketOrder.setVerkoopsWijze(verkoopWijze);
        return ticketOrder;
    }
}
