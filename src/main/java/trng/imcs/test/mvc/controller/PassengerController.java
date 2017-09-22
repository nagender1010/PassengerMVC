package trng.imcs.test.mvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import trng.imcs.test.mvc.model.Passenger;
import trng.imcs.test.mvc.service.PassengerService;


@Controller
@RequestMapping("/passenger")
public class PassengerController {

	final static Logger logger = Logger.getLogger(PassengerController.class);

	@Autowired
	PassengerService passengerService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		logger.debug("initBinder method called");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView defaultPage() {
		logger.debug("defaultPage method called");
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;

	}

	@RequestMapping(value = "/psngrForm", method = RequestMethod.GET)
	public ModelAndView getEmpForm() {
		logger.debug("defaultPage method called");
		ModelAndView modelAndView = new ModelAndView("passenger");
		return modelAndView;

	}

	@RequestMapping(value = "/eSearch", method = RequestMethod.GET)
	public ModelAndView getPassenger(@RequestParam("eSearch") int profileId) {
		logger.debug("defaultPage method called");
		System.out.println("---------------------------checking operations---------------");
		ModelAndView modelAndView = new ModelAndView("passenger");
		Passenger passenger = passengerService.getPassenger(profileId);
		System.out.println(passenger);
		if (passenger == null) {
			modelAndView.addObject("msg", "Employee Info doesnt exists with the given ID");
			return modelAndView;
		}
		modelAndView.addObject("eInfo", passenger);
		modelAndView.addObject("status", true);
		return modelAndView;

	}

	@RequestMapping(value = "/updatePassenger", method = RequestMethod.POST)
	public ModelAndView updatePassenger(@ModelAttribute("updateForm") Passenger passenger) {
		logger.debug("defaultPage method called");
		System.out.println("entered into updateemployee method " + passenger);
		Passenger p = passengerService.updatePassenger(passenger);
		
		ModelAndView modelAndView = new ModelAndView("passenger");
		modelAndView.addObject("msg", "User ID " + p.getProfileId() + " updated successfully");
		modelAndView.addObject("eInfo", p);
		modelAndView.addObject("status", true);
		return modelAndView;

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deletPassenger(@RequestParam("deleteId") int deleteId) {
		logger.debug("defaultPage method called");
		System.out.println("-------------------------------------------");
		ModelAndView modelAndView = new ModelAndView("passenger");
		passengerService.deletePassenger(deleteId);
		modelAndView.addObject("msg", "Employee Deleted Successfully");
		modelAndView.addObject("status", true);
		return modelAndView;

	}

	@RequestMapping(value = "/addPassenger", method = RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute("addForm") Passenger passenger) {
		passenger.setProfileId(0);
		logger.debug("defaultPage method called");
		System.out.println("entered into addEmployee method " + passenger);
		Passenger p = passengerService.addPassenger(passenger);
		
		ModelAndView modelAndView = new ModelAndView("passenger");
		modelAndView.addObject("msg", "User ID " + p.getProfileId() + " added successfully");
		modelAndView.addObject("eInfo", p);
		modelAndView.addObject("status", false);
		return modelAndView;

	}


}
