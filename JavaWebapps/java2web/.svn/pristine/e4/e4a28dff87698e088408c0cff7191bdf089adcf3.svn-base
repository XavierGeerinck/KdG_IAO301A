/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.springjsfrest.controller;

import be.kdg.springjsfrest.model.Meting;
import be.kdg.springjsfrest.service.api.DomoticaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author wouter
 */
@Controller
@RequestMapping("/domotica")
public class DomoticaController
{
    @Autowired    
    private DomoticaService domoticaService;

    @RequestMapping(value = "/{kamer}", method = RequestMethod.GET,
            headers = {"Accept=application/xml, application/json"})
    @ResponseBody
    public List<Meting> getMetingen(@PathVariable("kamer") String kamer)
    {
        return domoticaService.getMetingen(kamer);
    }
}
