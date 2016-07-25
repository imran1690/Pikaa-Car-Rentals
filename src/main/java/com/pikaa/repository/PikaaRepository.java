package com.pikaa.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.pikaa.model.Cars;
import com.pikaa.model.DateLocCar;
import com.pikaa.model.Locations;
import com.pikaa.model.RenterDetails;

@Repository
public class PikaaRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	public List<Locations> topNearestLocsList(int zipCode)
	{
		Criteria locCriteria = getSession().createCriteria(Locations.class);
		List<Locations> locList = locCriteria.list();
		Map<Integer, Locations> sortMap = new TreeMap<Integer, Locations>();
		int zipDiff;
		for(Locations loc: locList)
		{
			zipDiff = zipCode - loc.getLocZipcode();
			if(zipDiff < 0)
			{
				zipDiff *= -1;
			}
			sortMap.put(zipDiff, loc);
		}
		List<Locations> locTopList = new ArrayList<Locations>();
		
		for (Map.Entry<Integer, Locations> entry : sortMap.entrySet()) {
		
			locTopList.add(entry.getValue());
		}
		return locTopList;
	}

	public int getAvailabilityCars(int locId, int carId, int pickDateDay, int pickDateMonth,
			int pickDateYear, int returnDateDay, int returnDateMonth, int returnDateYear)
	{
		int no_of_cars_reserved, available_cars, total_cars = 10;
		Criteria dateCriteria = getSession().createCriteria(DateLocCar.class);
		
		Criterion locIdCriterion = Restrictions.eq("locId", locId);
		Criterion carIdCriterion = Restrictions.eq("carId", carId);
		Criterion pickDateDayCriterion = Restrictions.eq("pickDateDay", pickDateDay);
		Criterion pickDateMonthCriterion = Restrictions.eq("pickDateMonth", pickDateMonth);
		Criterion pickDateYearCriterion = Restrictions.eq("pickDateYear", pickDateYear);
		Criterion returnDateDayCriterion = Restrictions.eq("returnDateDay", returnDateDay);
		Criterion returnDateMonthCriterion = Restrictions.eq("returnDateMonth", returnDateMonth);
		Criterion returnDateYearCriterion = Restrictions.eq("returnDateYear", returnDateYear);
		
		dateCriteria.add(locIdCriterion);
		dateCriteria.add(carIdCriterion);
		dateCriteria.add(pickDateDayCriterion);
		dateCriteria.add(pickDateMonthCriterion);
		dateCriteria.add(pickDateYearCriterion);
		dateCriteria.add(returnDateDayCriterion);
		dateCriteria.add(returnDateMonthCriterion);
		dateCriteria.add(returnDateYearCriterion);
		
		List<DateLocCar> dateList = dateCriteria.list();
		no_of_cars_reserved = dateList.size();
		available_cars = total_cars - no_of_cars_reserved;
		return available_cars;
	}
	
	public int saveRenterDetails(RenterDetails rd)
	{
		int renterId = (Integer)getSession().save(rd);
		return renterId;
	}
	
	public double getPrice(int id)
	{
		Criteria carCriteria = getSession().createCriteria(Cars.class);
		Criterion idCriterion = Restrictions.eq("carId", id);
		
		carCriteria.add(idCriterion);
		
		Cars carobj = (Cars)carCriteria.uniqueResult();
		return carobj.getCarPrice();	
	}
	
	public int saveDateCarLocDetails(DateLocCar dlc)
	{
		int dlcId = (Integer)getSession().save(dlc);
		return dlcId;
	}

}
