package com.pikaa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pikaa.model.DateLocCar;
import com.pikaa.model.Locations;
import com.pikaa.model.RenterDetails;
import com.pikaa.model.ZipcodePage;
import com.pikaa.service.pikaaService;

@Controller
@RequestMapping(value="/pikaa")
public class PikaaController {

	@Autowired
	pikaaService ps;
	
	@Autowired
	DateLocCar dlc;
	
	int pickDateDay, pickDateMonth, pickDateYear, returnDateDay, returnDateMonth, returnDateYear;
	int carId, locId;
	/*@RequestMapping(method=RequestMethod.GET, value="/welcome")
	public String welcomePage1(Model model){
		return "welcome-page";
	}*/
	
	@RequestMapping(value="/zipcode", method= RequestMethod.GET)
	public String zipCodePage(Model model){
		ZipcodePage zp = new ZipcodePage();
		model.addAttribute("zip", zp);
		return "zipcode-page";
	}
	
	@RequestMapping(value="/welcome", method= RequestMethod.GET)
	public String welcomePage(Model model)
	{
		model.addAttribute("welcome", "welcome");
		return "welcome-page";
	}
	@RequestMapping(value="/about", method= RequestMethod.GET)
	public String aboutPage(Model model)
	{
		model.addAttribute("about", "about");
		return "about-us";
	}
	
	@RequestMapping(value="/zipcode", method=RequestMethod.POST)
	public String getZip(@Valid @ModelAttribute ("zip") ZipcodePage zip, BindingResult br, Model model){
		
		if(br.hasErrors())
		{
			return "welcome-page";
		}

		int zipCode = Integer.parseInt(zip.getZipcode());
		pickDateDay = zip.getPickDateDay();
		pickDateMonth = zip.getPickDateMonth();
		pickDateYear = zip.getPickDateYear();
		
		returnDateDay = zip.getReturnDateDay();
		returnDateMonth = zip.getReturnDateMonth();
		returnDateYear = zip.getReturnDateYear();

		List<Locations> topList = ps.topNearestLocsList(zipCode);
		model.addAttribute("topList", topList);
		return "location-list";
	}
	
	@RequestMapping(value="/carList/{id}", method = RequestMethod.GET)
	public String getCarList(Model model, @PathVariable String id){

		locId = new Integer(id).intValue();
		int availCars_Economy = 0, availCars_Compact = 0, availCars_Intermediate = 0, availCars_Standard = 0, availCars_FullSize = 0, availCars_Premium = 0;
		if(id!= null)
			
		{
			availCars_Economy = ps.getAvailabilityCars(locId, 1, pickDateDay, pickDateMonth, pickDateYear, returnDateDay, returnDateMonth, returnDateYear);
			availCars_Compact = ps.getAvailabilityCars(locId, 2, pickDateDay, pickDateMonth, pickDateYear, returnDateDay, returnDateMonth, returnDateYear);
			availCars_Intermediate = ps.getAvailabilityCars(locId, 3, pickDateDay, pickDateMonth, pickDateYear, returnDateDay, returnDateMonth, returnDateYear);
			availCars_Standard = ps.getAvailabilityCars(locId, 4, pickDateDay, pickDateMonth, pickDateYear, returnDateDay, returnDateMonth, returnDateYear);
			availCars_FullSize = ps.getAvailabilityCars(locId, 5, pickDateDay, pickDateMonth, pickDateYear, returnDateDay, returnDateMonth, returnDateYear);
			availCars_Premium = ps.getAvailabilityCars(locId, 6, pickDateDay, pickDateMonth, pickDateYear, returnDateDay, returnDateMonth, returnDateYear);
		}
		if(availCars_Economy > 0)
		{
			model.addAttribute("availCars_Economy", availCars_Economy);
		}
		else
		{
			model.addAttribute("availCars_Economy", "Sold out");
		}
		if(availCars_Compact > 0)
		{
			model.addAttribute("availCars_Compact", availCars_Compact);
		}
		else
		{
			model.addAttribute("availCars_Compact", "Sold out");
		}
		
		if(availCars_Intermediate > 0)
		{
			model.addAttribute("availCars_Intermediate", availCars_Intermediate);
		}
		else
		{
			model.addAttribute("availCars_Intermediate", "Sold out");
		}
		if(availCars_Standard > 0)
		{
			model.addAttribute("availCars_Standard", availCars_Standard);
		}
		else
		{
			model.addAttribute("availCars_Standard", "Sold out");
		}
		if(availCars_FullSize > 0)
		{
			model.addAttribute("availCars_FullSize", availCars_FullSize);
		}
		else
		{
			model.addAttribute("availCars_FullSize", "Sold out");
		}
		
		if(availCars_Premium > 0)
		{
			model.addAttribute("availCars_Premium", availCars_Premium);
		}
		else
		{
			model.addAttribute("availCars_Premium", "Sold out");
		}
		return "car-display";
		
	}
	
	@RequestMapping(value="/price/{id}", method = RequestMethod.GET)
	public String getPrice(Model model, @PathVariable String id){
		carId = new Integer(id).intValue();
		double basePrice = ps.getBasePrice(carId);
		double tax = ps.getTax();
		double totalPrice = ps.getTotalPrice();
		
		model.addAttribute("basePrice", basePrice);
		model.addAttribute("tax", tax);
		model.addAttribute("totalPrice", totalPrice);
		
		return "price-summary";		
	}
	
	@RequestMapping(value="/reserve", method = RequestMethod.GET)
	public String getPrice(Model model){	
		RenterDetails rd = new RenterDetails();
		model.addAttribute("renter", rd);
		return "renter-page";
	}
	
	@RequestMapping(value="/reserve", method=RequestMethod.POST)
	public String getZip(@Valid @ModelAttribute ("renter") RenterDetails renter, BindingResult br, Model model){
		
		if(br.hasErrors())
		{
			return "renter-page";
		}
		int rentId = ps.saveRenterDetails(renter);
		dlc.setLocId(locId);
		dlc.setCarId(carId);
		dlc.setPickDateDay(pickDateDay);
		dlc.setPickDateMonth(pickDateMonth);
		dlc.setPickDateYear(pickDateYear);
		dlc.setReturnDateDay(returnDateDay);
		dlc.setReturnDateMonth(returnDateMonth);
		dlc.setReturnDateYear(returnDateYear);
		
		int dlcId = ps.saveDateCarLocDetails(dlc);
		
		model.addAttribute("rentId", rentId);
		model.addAttribute("dlcId", dlcId);
		String fullName = renter.getFirstName() + " "+ renter.getLastName();
		model.addAttribute("renterName", fullName);
		return "reserve-success";
	}
	
}
