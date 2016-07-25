package com.pikaa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Date_Loc_Car")
@Component
public class DateLocCar {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="id")
	private int dateId;
	@Column(name="pick_day")
	private int pickDateDay;
	@Column(name="pick_month")
	private int pickDateMonth;
	@Column(name="pick_year")
	private int pickDateYear;
	@Column(name="return_day")
	private int returnDateDay;
	@Column(name="return_month")
	private int returnDateMonth;
	@Column(name="return_year")
	private int returnDateYear;
	@Column(name="loc_id")
	private int locId;
	@Column(name="car_id")
	private int carId;
	public int getDateId() {
		return dateId;
	}
	public void setDateId(int dateId) {
		this.dateId = dateId;
	}
	public int getPickDateDay() {
		return pickDateDay;
	}
	public void setPickDateDay(int pickDateDay) {
		this.pickDateDay = pickDateDay;
	}
	public int getPickDateMonth() {
		return pickDateMonth;
	}
	public void setPickDateMonth(int pickDateMonth) {
		this.pickDateMonth = pickDateMonth;
	}
	public int getPickDateYear() {
		return pickDateYear;
	}
	public void setPickDateYear(int pickDateYear) {
		this.pickDateYear = pickDateYear;
	}
	public int getReturnDateDay() {
		return returnDateDay;
	}
	public void setReturnDateDay(int returnDateDay) {
		this.returnDateDay = returnDateDay;
	}
	public int getReturnDateMonth() {
		return returnDateMonth;
	}
	public void setReturnDateMonth(int returnDateMonth) {
		this.returnDateMonth = returnDateMonth;
	}
	public int getReturnDateYear() {
		return returnDateYear;
	}
	public void setReturnDateYear(int returnDateYear) {
		this.returnDateYear = returnDateYear;
	}
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	@Override
	public String toString() {
		return "DateLocCar [dateId=" + dateId + ", pickDateDay=" + pickDateDay
				+ ", pickDateMonth=" + pickDateMonth + ", pickDateYear="
				+ pickDateYear + ", returnDateDay=" + returnDateDay
				+ ", returnDateMonth=" + returnDateMonth + ", returnDateYear="
				+ returnDateYear + ", locId=" + locId + ", carId=" + carId
				+ "]";
	}

}
