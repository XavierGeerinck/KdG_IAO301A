package com.desple.testData;

import com.desple.model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private String csvFile;
    private Random random;

    public TestData(String csvFile) {
        this.csvFile = csvFile;
        random = new Random();
        readCsv();
    }

    private void readCsv(){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        int counter = 0;
        Random random = new Random();
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                if (counter == 0){
                    counter++;
                }else{
                    String[] festivalString = line.split(cvsSplitBy);
                    SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yy");
                    Festival festival = new Festival();
                    festival.setNaam(festivalString[0]);
                    festival.setLocatie(festivalString[1]);
                    festival.setStartDate(sdf.parse(festivalString[2]));

                    int amountDays = random.nextInt(4);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(festival.getStartDate());
                    cal.add(Calendar.DATE, amountDays);
                    festival.setEindDate(cal.getTime());
                    for(int i=0; i<amountDays; i++){
                        generateFestivalDays(festival.getStartDate(),i, festival);
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
        for(int i = 0; i < aantalOptredens; i++){
            endPrevious = generateOptredens(endPrevious, i, dag);
        }
        for(int i=0; i < 7500; i++){
            generateTickets(dag);
        }


    }

    private Calendar generateOptredens(Calendar cal, int nummerOptreden, FestivalDag dag){
        int duur = (5 * nummerOptreden) + 50;
        cal.add(Calendar.MINUTE, duur);
        Optreden optreden = new Optreden();
        optreden.setDuur(duur);
        optreden.setFestivalDag(dag);
        optreden.setTijdstip(cal.getTime());
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

    private void generateTickets(FestivalDag dag){
        Ticket ticket = new Ticket();
        ticket.setFestivalDag(dag);
        ticket.setBarcode("8711700735179");
        ticket.setTicketOrder();

    }
}
