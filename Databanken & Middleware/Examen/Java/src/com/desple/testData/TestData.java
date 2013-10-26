package com.desple.testData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                    Festival festival = new Festival(festivalString[0], festivalString[1], sdf.parse(festivalString[2]));
                    int amountDays = festival.setEndDate(random);

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
}
