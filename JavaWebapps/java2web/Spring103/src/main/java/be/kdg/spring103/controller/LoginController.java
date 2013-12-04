/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.spring103.controller;

import be.kdg.spring103.controller.form.LoginFormBean;
import be.kdg.spring103.model.LoginService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author wouter
 */
@Controller
@Scope("request")
@SessionAttributes("loginBeanForm")
@RequestMapping(value = "/login")
public class LoginController
{
    @Autowired
    private LoginService loginService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String createForm(Model model)
    {
        model.addAttribute("loginFormBean", new LoginFormBean());
        return "login";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String checkForm(@Valid LoginFormBean loginFormBean, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "login";
        }
        if(loginService.checkLogin(loginFormBean.getUsername(), loginFormBean.getPassword()))
        {
            return "welcome";
        }                
        return "login";
    }
}
