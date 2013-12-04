/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.springjsfrest.service.impl;

import be.kdg.springjsfrest.model.Meting;
import be.kdg.springjsfrest.service.api.DomoticaService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.stereotype.Service;

/**
 *
 * @author wouter
 */
@Service("domoticaService")
public class DomoticaServiceImpl implements DomoticaService
{
    private List<String> kamers;
    private Map<String,List<Meting>> meetPunten;
    private Random random;
    private static int AANTAL_METINGEN = 10;
    private static int GEM_TEMP = 20;
    private static int GEM_LV = 50;
    private static int STD_TEMP = 1;
    private static int STD_LV = 20;

    public DomoticaServiceImpl()
    {
        this.kamers = java.util.Arrays.asList("living","keuken","badkamer","slaapkamer1","slaapkamer2","kelder");
        this.random = new Random();
        this.meetPunten = new HashMap<String, List<Meting>>();
        initMetingen();
    }

    @Override
    public List<Meting> getMetingen(String kamer)
    {
        return meetPunten.get(kamer);
    }

    private void initMetingen()
    {
        double temp;
        double luchtvochtigheid;
        
        for(String kamer : kamers)
        {
            List<Meting> metingen = new ArrayList<Meting>();
            for(int i = 0; i < AANTAL_METINGEN; i++)
            {
                temp = GEM_TEMP + random.nextGaussian() * STD_TEMP;
                luchtvochtigheid = GEM_LV + random.nextGaussian() * STD_LV; 
                metingen.add(new Meting(i,temp, luchtvochtigheid));
            }
            meetPunten.put(kamer,metingen);
        }
    }

    @Override
    public List<String> getKamers()
    {
        return this.kamers;
    }
}
