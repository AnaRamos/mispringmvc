package com.micompania.miapp;

import com.micompania.miapp.beans.BeanSaludo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import persistence.daos.PersonaDao;
import persistence.entities.Persona;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private BeanSaludo beanSaludo;
	
	private PersonaDao personaDao;
		
	@Autowired
	public void setPersonaDao(PersonaDao personaDao) {
		this.personaDao = personaDao;
	}
	
	@Autowired
	public void setBeanSaludo(BeanSaludo beanSaludo) {
		this.beanSaludo = beanSaludo;
	}


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}."+beanSaludo.getMensaje(), locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("beanSaludo", beanSaludo.getMensaje() );
		
		
		personaDao.save(new Persona("Juan", "Perez"));
		return "home";
	}
	
}
