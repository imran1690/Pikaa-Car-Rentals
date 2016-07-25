package com.pikaa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="cars")  
@Entity
public class Cars {
	
	@Id
	@Column(name="id")
	private int carId;
	@Column(name="car_type")
	private String carType;
	@Column(name="availability")
	private int carAvailability;
	@Column(name="price_in_dollar")
	private double carPrice;
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public int getCarAvailability() {
		return carAvailability;
	}
	public void setCarAvailability(int carAvailability) {
		this.carAvailability = carAvailability;
	}
	public double getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}
	@Override
	public String toString() {
		return "Cars [carId=" + carId + ", carType=" + carType
				+ ", carAvailability=" + carAvailability + ", carPrice="
				+ carPrice + "]";
	}
	
	

}
