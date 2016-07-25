package com.pikaa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pikaa.model.DateLocCar;
import com.pikaa.model.Locations;
import com.pikaa.model.RenterDetails;
import com.pikaa.repository.PikaaRepository;

@Service
@Transactional
public class pikaaService {
	@Autowired
	PikaaRepository pr;
	
	double basePrice;
	double tax;
	public List<Locations> topNearestLocsList(int zipCode)
	{
		List<Locations> topList = pr.topNearestLocsList(zipCode);
		List<Locations> top5List = new ArrayList<Locations>();
		for(int i=0; i<5; i++)
		{
			top5List.add(topList.get(i));
		}
		return top5List;
	}

	public int getAvailabilityCars(int locId, int carId, int pickDateDay, int pickDateMonth,
			int pickDateYear, int returnDateDay, int returnDateMonth, int returnDateYear)
	{
		int avail_cars = pr.getAvailabilityCars(locId, carId, pickDateDay, pickDateMonth, pickDateYear, returnDateDay, returnDateMonth, returnDateYear);
		return avail_cars;
	}
	public double getBasePrice(int id)
	{
		basePrice = pr.getPrice(id);
		return basePrice;
	}
	public double getTax()
	{
		tax = basePrice * 0.08;
		return tax;
	}
	public double getTotalPrice()
	{
		double totalPrice = tax + basePrice;
		return totalPrice;
	}
	
	public int saveRenterDetails(RenterDetails rd)
	{
		int rentId = pr.saveRenterDetails(rd);
		return rentId;
	}
	public int saveDateCarLocDetails(DateLocCar dlc)
	{
		int dlcId = pr.saveDateCarLocDetails(dlc);
		return dlcId;
	}
}
