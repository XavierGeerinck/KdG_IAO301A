package com.desple.testData;

import com.desple.model.Artiest;
import com.desple.model.Festival;
import com.desple.model.Koper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Thierry
 * Date: 31/10/13
 * Time: 19:38
 * To change this template use File | Settings | File Templates.
 */
public class Reader {

    public static ArrayList<Festival> readFestivals(String url){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        int counter = 0;
        ArrayList<Festival> festivals = new ArrayList<Festival>();

        try {

            br = new BufferedReader(new FileReader(url));
            while ((line = br.readLine()) != null) {
                if (counter != 0){
                    String[] festivalString = line.split(cvsSplitBy);
                    SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yy");

                    Festival festival = new Festival();
                    festival.setNaam(festivalString[0]);
                    festival.setLocatie(festivalString[1]);
                    String temp = festivalString[2];
                    festival.setStartDate(sdf.parse(festivalString[2]));
                    festivals.add(festival);
                }else{
                    counter++;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return festivals;
    }

    public static ArrayList<Koper> readKopers(String url){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        int counter = 0;
        ArrayList<Koper> kopers = new ArrayList<Koper>();

        try {

            br = new BufferedReader(new FileReader(url));
            while ((line = br.readLine()) != null) {
                if (counter!=0){
                    String[] koperString = line.split(cvsSplitBy);
                    Koper koper = new Koper();
                    koper.setNaam(koperString[0]);
                    kopers.add(koper);
                }else{
                    counter++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return kopers;
    }

    public static ArrayList<Artiest> readArtiest(String url){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        int counter = 0;
        ArrayList<Artiest> artiesten = new ArrayList<Artiest>();

        try {

            br = new BufferedReader(new FileReader(url));
            while ((line = br.readLine()) != null) {
                if (counter!=0){
                    String[] artiestString = line.split(cvsSplitBy);
                    Artiest artiest = new Artiest();
                    artiest.setNaam(artiestString[0]);
                    artiesten.add(artiest);
                }else{
                    counter++;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return artiesten;
    }





}
