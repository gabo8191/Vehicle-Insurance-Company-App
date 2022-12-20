package model;

import java.text.*;
import java.util.*;

public class Vehicle {

	private int register;
	private String brand;
	private String carBody;
	private int model;
	private String color;
	private long price;
	private int cilinderCapacity;
	private String ubication;

	private long valueTax;
	private int yearsOld;
	private long depretiationVehicle;
	private long valueSell;
	private long valueInsurance;
	NumberFormat nf = NumberFormat.getInstance(Locale.US);

	// A constructor.
	public Vehicle() {
	}

	// A constructor.
	public Vehicle(int register, String brand, String carBody, int model, String color, long price,
			int cilinderCapacity, String ubication, long valueTax, int yearsOld, long depretiationVehicle,
			long valueSell, long valueInsurance) {
		this.register = register;
		this.brand = brand;
		this.carBody = carBody;
		this.model = model;
		this.color = color;
		this.price = price;
		this.cilinderCapacity = cilinderCapacity;
		this.ubication = ubication;
		this.valueTax = valueTax;
		this.yearsOld = yearsOld;
		this.depretiationVehicle = depretiationVehicle;
		this.valueSell = valueSell;
		this.valueInsurance = valueInsurance;

	}

	/**
	 * This function returns the value of the register variable
	 * 
	 * @return The value of the register variable.
	 */
	public int getRegister() {
		return register;
	}

	/**
	 * This function sets the register to the value of the parameter.
	 * 
	 * @param register The register number to read from.
	 */
	public void setRegister(int register) {
		this.register = register;
	}

	/**
	 * This function returns the brand of the car
	 * 
	 * @return The brand of the car.
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * This function sets the brand of the car
	 * 
	 * @param brand The brand of the car.
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * > This function returns the car body type
	 * 
	 * @return The carBody variable is being returned.
	 */
	public String getCarBody() {
		return carBody;
	}

	/**
	 * This function sets the carBody variable to the value of the carBody parameter
	 * 
	 * @param carBody The body of the car.
	 */
	public void setCarBody(String carBody) {
		this.carBody = carBody;
	}

	/**
	 * This function returns the model of the car
	 * 
	 * @return The model number of the car.
	 */
	public int getModel() {
		return model;
	}

	/**
	 * This function sets the model of the car to the model that is passed in
	 * 
	 * @param model The model of the car.
	 */
	public void setModel(int model) {
		this.model = model;
	}

	/**
	 * This function returns the color of the car
	 * 
	 * @return The color of the car.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * This function sets the color of the car
	 * 
	 * @param color The color of the marker.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * > This function returns the price of the item
	 * 
	 * @return The price of the item.
	 */
	public long getPrice() {
		return price;
	}

	/**
	 * > Sets the price of the item
	 * 
	 * @param price The price of the item.
	 */
	public void setPrice(long price) {
		this.price = price;
	}

	/**
	 * > This function returns the cilinderCapacity of the car
	 * 
	 * @return The cilinderCapacity
	 */
	public int getCilinderCapacity() {
		return cilinderCapacity;
	}

	/**
	 * > This function sets the cilinder capacity of the car
	 * 
	 * @param cilinderCapacity The capacity of the engine in cubic centimeters.
	 */
	public void setCilinderCapacity(int cilinderCapacity) {
		this.cilinderCapacity = cilinderCapacity;
	}

	/**
	 * This function returns the ubication of the object
	 * 
	 * @return The ubication of the object.
	 */
	public String getUbication() {
		return ubication;
	}

	/**
	 * This function sets the ubication of the object
	 * 
	 * @param ubication The ubication of the user.
	 */
	public void setUbication(String ubication) {
		this.ubication = ubication;
	}

	/**
	 * > This function returns the value of the tax
	 * 
	 * @return The value of the variable valueTax.
	 */
	public long getValueTax() {
		return valueTax;
	}

	/**
	 * > This function sets the value of the tax
	 * 
	 * @param valueTax The value of the tax
	 */
	public void setValueTax(long valueTax) {
		this.valueTax = valueTax;
	}

	/**
	 * > This function returns the value of the variable yearsOld
	 * 
	 * @return The yearsOld variable is being returned.
	 */
	public int getYearsOld() {
		return yearsOld;
	}

	/**
	 * This function sets the yearsOld variable to the value of the yearsOld
	 * parameter
	 * 
	 * @param yearsOld The age of the person.
	 */
	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}

	/**
	 * This function returns the depretiationVehicle
	 * 
	 * @return The depretiationVehicle is being returned.
	 */
	public long getDepretiationVehicle() {
		return depretiationVehicle;
	}

	/**
	 * This function sets the depretiationVehicle variable to the value of the
	 * depretiationVehicle
	 * parameter
	 * 
	 * @param depretiationVehicle The amount of money that the vehicle has
	 *                            depreciated by.
	 */
	public void setDepretiationVehicle(long depretiationVehicle) {
		this.depretiationVehicle = depretiationVehicle;
	}

	/**
	 * This function returns the value of the variable valueSell
	 * 
	 * @return The value of the variable valueSell.
	 */
	public long getValueSell() {
		return valueSell;
	}

	/**
	 * This function sets the value of the variable valueSell to the value of the
	 * parameter valueSell
	 * 
	 * @param valueSell The value of the item in the shop
	 */
	public void setValueSell(long valueSell) {
		this.valueSell = valueSell;
	}

	/**
	 * > This function returns the value of the insurance
	 * 
	 * @return The value of the variable valueInsurance.
	 */
	public long getValueInsurance() {
		return valueInsurance;
	}

	/**
	 * > This function sets the value of the insurance
	 * 
	 * @param valueInsurance The value of the insurance
	 */
	public void setValueInsurance(long valueInsurance) {
		this.valueInsurance = valueInsurance;
	}

	/**
	 * The function toString() is used to return the string representation of the
	 * value of an object
	 * 
	 * @return The method toString() is being returned.
	 */
	@Override
	public String toString() {
		return "   " + register + "           " + brand + "         " + carBody + "           " + model + "       "
				+ color + "             "
				+ nf.format(price) + "             " + cilinderCapacity + "             " + ubication
				+ "                         " + nf.format(valueTax) + "             "
				+ yearsOld + "             " + nf.format(depretiationVehicle) + "             " + nf.format(valueSell)
				+ "             "
				+ nf.format(valueInsurance);
	}

}
