/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.springjsfrest.controller;

import be.kdg.springjsfrest.model.Meting;
import be.kdg.springjsfrest.service.api.DomoticaService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author wouter
 */
@Component("domoticaBean")
public class DomoticaBean
{
    @Autowired
    private DomoticaService domoticaService;
    
    public DomoticaBean()
    {   
        // lukt niet => NullPointerException
        //this.domoticaService.getKamers();
    }
    
    @PostConstruct
    public void init()
    {
        // lukt wel
        this.domoticaService.getKamers();
    }

    public CartesianChartModel getCategoryModel(String kamer)
    {
        return createCategoryModel(kamer);
    }

    private CartesianChartModel createCategoryModel(String kamer)
    {
        CartesianChartModel categoryModel = new CartesianChartModel();
        final List<Meting> metingen = domoticaService.getMetingen(kamer);
        ChartSeries tempSeries = new ChartSeries();
        tempSeries.setLabel("temperatuur");        
        ChartSeries lvSeries = new ChartSeries();
        lvSeries.setLabel("luchtvochtigheid");
        
        for(Meting meting: metingen)
        {
            tempSeries.set(String.valueOf(meting.getM_key()), meting.getTemperatuur());                    
            lvSeries.set(String.valueOf(meting.getM_key()), meting.getLuchtvochtigheid());
        }
        
        categoryModel.addSeries(tempSeries);
        categoryModel.addSeries(lvSeries);
        
        return categoryModel;
    }
}
