package model;

import java.util.ArrayList;
import java.time.*;

public class Taxes {

	private ArrayList<Vehicle> listOfAutos;
	private Vehicle vihicle;

	// The constructor of the class.
	public Taxes() {
		listOfAutos = new ArrayList<Vehicle>();
	}

	/**
	 * This function adds a new car to the list of cars
	 * 
	 * @param register         The car's registration number
	 * @param brand            String
	 * @param carBody          Sedan, Hatchback, SUV, Pickup, Coupe, Convertible,
	 *                         Minivan, Wagon, Van, Truck, Hybrid, Electric
	 * @param model            year of the car
	 * @param color            String
	 * @param price            The price of the car
	 * @param cilinderCapacity the size of the engine
	 * @param ubication        The place where the car is located.
	 */
	public void addCar(int register, String brand, String carBody, int model, String color, long price,
			int cilinderCapacity, String ubication) {
		long valueTax = calculateTax(price);
		int yearsOld = calculateAge(model);
		long depretiationVehicle = vehicleDepreciation(yearsOld, price);
		long valueSell = calculateSellValue(price, depretiationVehicle);
		long valueInsurance = insuranceValue(cilinderCapacity, yearsOld);

		vihicle = new Vehicle(register, brand, carBody, model, color, price, cilinderCapacity, ubication, valueTax,
				yearsOld, depretiationVehicle, valueSell, valueInsurance);
		listOfAutos.add(vihicle);

	}

	/**
	 * This function adds a vehicle to the list of autos
	 * 
	 * @param vehicle The vehicle object that is being added to the list.
	 */
	public void addCarUser(Vehicle vehicle) {
		listOfAutos.add(vehicle);
	}

	/**
	 * This function verifies if the car is already in the list of cars.
	 * 
	 * @param register The register number of the car.
	 * @return The method is returning a boolean value.
	 */
	public boolean verify(int register) {
		boolean verify = false;
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (listOfAutos.get(i).getRegister() == register) {
				verify = true;
			}
		}
		return verify;
	}

	/**
	 * This function takes the listOfAutos arraylist and adds each element to the
	 * autos string, then returns the autos string
	 * 
	 * @return The list of autos
	 */
	public String showAutos() {
		String autos = "";
		for (int i = 0; i < listOfAutos.size(); i++) {
			autos += "\n -" + listOfAutos.get(i) + "\n ";
		}
		return autos;
	}

	/**
	 * > Find the position of a vehicle in the list of vehicles by its registration
	 * number
	 * 
	 * @param register the register number of the vehicle
	 * @return The position of the vehicle in the list.
	 */
	public int findPosition(int register) {
		int pos = -1;
		int i = 0;
		for (Vehicle auto : listOfAutos) {
			if (auto.getRegister() == register) {
				pos = i;
			}
			i++;
		}
		return pos;
	}

	/**
	 * It calculates the tax on a given price
	 * 
	 * @param price The price of the item
	 * @return The total amount of tax that is being calculated.
	 */
	public long calculateTax(long price) {
		long total = 0;
		if (price < 50954000) {

			total = (long) (price * (1.5 / 100));
		} else if (price > 50954000 && price < 11464400) {
			total = (long) (price * (2.5 / 100));

		} else if (price > 11464400) {
			total = (long) (price * (3.5 / 100));

		}

		return total;
	}

	/**
	 * It takes a year as an argument and returns the number of years between that
	 * year and the current year
	 * 
	 * @param model The year the car was made
	 * @return The number of years between the model year and the current year.
	 */
	public int calculateAge(int model) {
		int yearsOld = 0;
		LocalDate modelCar = LocalDate.of(model, 1, 1);
		LocalDate actualDate = LocalDate.now();

		Period period = Period.between(modelCar, actualDate);
		yearsOld = period.getYears();
		return yearsOld;

	}

	/**
	 * > This function takes in a vehicle's age and price and returns the
	 * depreciation value
	 * 
	 * @param yearsOld The age of the vehicle in years.
	 * @param price    The price of the vehicle
	 * @return The total depreciation of the vehicle.
	 */
	public long vehicleDepreciation(int yearsOld, long price) {
		long total = 0;
		if (yearsOld <= 5) {
			total = (long) (price * 0.11);
		} else if (yearsOld > 5 && yearsOld < 12) {
			total = (long) (price * 0.25);
		} else if (yearsOld >= 12) {
			total = (long) (price * 0.45);
		}
		return total;
	}

	/**
	 * This function takes in a price and a depreciation and returns the total value
	 * of the item
	 * 
	 * @param price        The price of the car
	 * @param depreciation The amount of depreciation that the car has gone through.
	 * @return The total value of the car after depreciation.
	 */
	public long calculateSellValue(long price, long depreciation) {
		long total = price - depreciation;
		return total;

	}

	/**
	 * > This function calculates the insurance value of a car based on the cylinder
	 * and years old
	 * 
	 * @param cylinder The size of the engine in cubic centimeters.
	 * @param yearsOld The age of the car in years.
	 * @return The total insurance value.
	 */
	public long insuranceValue(int cylinder, int yearsOld) {
		long totalInsurance = 0;
		if (cylinder <= 1500 && yearsOld < 10) {
			totalInsurance = 650000;
		}

		if (cylinder <= 1500 && yearsOld >= 10) {
			totalInsurance = 750000;
		}

		if (cylinder >= 1500 && cylinder <= 2500 && yearsOld <= 10) {
			totalInsurance = 850000;
		}

		if (cylinder > 1500 && cylinder < 2500 && yearsOld > 10) {
			totalInsurance = 950000;
		}

		if (cylinder > 2500 && yearsOld < 10) {
			totalInsurance = 1050000;
		}

		if (cylinder > 1500 && yearsOld > 10) {
			totalInsurance = 1250000;
		}

		return totalInsurance;

	}

	/**
	 * > This function returns a string representation of the car object at the
	 * position of the register number in the list of cars
	 * 
	 * @param register The register number of the car.
	 * @return The data of the car with the given register number.
	 */
	public String dataAuto(int register) {
		return "" + listOfAutos.get(findPosition(register));
	}

	/**
	 * This function modifies the attributes of an object of the class Auto, which
	 * is in the ArrayList listOfAutos
	 * 
	 * @param register            The register number of the car.
	 * @param brand               String
	 * @param carBody             Sedan, Coupe, Hatchback, SUV, Pickup, Minivan,
	 *                            Convertible, Wagon, Van, Hybrid, Electric
	 * @param model               int
	 * @param color               String
	 * @param price               The price of the car
	 * @param cilinderCapacity    is the capacity of the engine in cubic centimeters
	 * @param ubication           The place where the car is located.
	 * @param valueTax            is the value of the tax that the car has to pay
	 *                            every year.
	 * @param yearsOld            The number of years the car has been in use.
	 * @param depretiationVehicle The value of the vehicle's depreciation.
	 * @param valueSell           is the value of the car after the depreciation
	 * @param valueInsurance      The value of the insurance
	 */
	public void modifyAuto(int register, String brand, String carBody, int model, String color, long price,
			int cilinderCapacity, String ubication, long valueTax, int yearsOld, long depretiationVehicle,
			long valueSell, long valueInsurance) {
		listOfAutos.get(findPosition(register)).setBrand(brand);
		listOfAutos.get(findPosition(register)).setCarBody(carBody);
		listOfAutos.get(findPosition(register)).setModel(model);
		listOfAutos.get(findPosition(register)).setColor(color);
		listOfAutos.get(findPosition(register)).setPrice(price);
		listOfAutos.get(findPosition(register)).setCilinderCapacity(cilinderCapacity);
		listOfAutos.get(findPosition(register)).setUbication(ubication);
		listOfAutos.get(findPosition(register)).setValueTax(valueTax);
		listOfAutos.get(findPosition(register)).setYearsOld(yearsOld);
		listOfAutos.get(findPosition(register)).setDepretiationVehicle(depretiationVehicle);
		listOfAutos.get(findPosition(register)).setValueSell(valueSell);
		listOfAutos.get(findPosition(register)).setValueInsurance(valueInsurance);

	}

	/**
	 * > This function deletes an auto from the list of autos
	 * 
	 * @param register the register number of the car
	 * @return The method is returning a boolean value.
	 */
	public boolean deleteAuto(int register) {
		boolean delete = false;
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (listOfAutos.get(i).getRegister() == register) {

				listOfAutos.remove(findPosition(register));
				delete = true;
			}
		}
		return delete;
	}

	// PARTE 2 FILTROS

	/**
	 * > This function takes a string as a parameter and returns the total taxes of
	 * all the cars that have the same color as the string
	 * 
	 * @param data The data that will be used to filter the list of autos.
	 * @return The total taxes by color.
	 */
	public long totalTaxByColor(String data) {
		long totalTaxesByColor = 0;
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (listOfAutos.get(i).getColor().equals(data)) {
				totalTaxesByColor += listOfAutos.get(i).getValueTax();
			}
		}
		return totalTaxesByColor;
	}

	/**
	 * > This function returns the number of cars in the list that are equal to or
	 * greater than the model number passed in
	 * 
	 * @param model The model of the car
	 * @return The number of cars that are equal to or greater than the model
	 *         number.
	 */
	public int totalByModelsSuperior(int model) {
		int quantity = 0;
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (listOfAutos.get(i).getModel() >= model) {
				quantity++;

			}
		}
		return quantity;
	}

	/**
	 * > This function returns the highest tax value of all the cars in the list
	 * 
	 * @return The higher tax of the list of autos.
	 */
	public long higherTax() {
		long maxPriceTax = listOfAutos.get(0).getValueTax();
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (maxPriceTax < listOfAutos.get(i).getValueTax()) {
				maxPriceTax = listOfAutos.get(i).getValueTax();
			}
		}
		return maxPriceTax;
	}

	/**
	 * > This function returns the lowest tax value of all the cars in the list
	 * 
	 * @return The lowest tax value of the list of autos.
	 */
	public long lowerTax() {
		long minPriceTax = listOfAutos.get(0).getValueTax();
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (minPriceTax > listOfAutos.get(i).getValueTax()) {
				minPriceTax = listOfAutos.get(i).getValueTax();
			}
		}
		return minPriceTax;
	}

	/**
	 * It calculates the average value of the insurance of all the cars in the list
	 * 
	 * @return The average of the SOAT of all the cars in the list.
	 */
	public long averageSOAT() {
		long total = 0;
		long average = 0;
		for (int i = 0; i < listOfAutos.size(); i++) {
			total += listOfAutos.get(i).getValueInsurance();
		}
		average = total / listOfAutos.size();
		return average;
	}

	/**
	 * > This function returns the highest depreciation value of all the cars in the
	 * list
	 * 
	 * @return The method returns the highest depreciation value.
	 */
	public long higherDepretiation() {
		long maxDepretiation = listOfAutos.get(0).getDepretiationVehicle();
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (maxDepretiation < listOfAutos.get(i).getDepretiationVehicle()) {
				maxDepretiation = listOfAutos.get(i).getDepretiationVehicle();
			}
		}
		return maxDepretiation;
	}

	/**
	 * > This function returns the lowest depretiation value of all the cars in the
	 * list
	 * 
	 * @return The method returns the lowest value of the tax of the cars in the
	 *         list.
	 */
	public long lowerDepretiation() {
		long minDepretiation = listOfAutos.get(0).getDepretiationVehicle();
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (minDepretiation > listOfAutos.get(i).getDepretiationVehicle()) {
				minDepretiation = listOfAutos.get(i).getDepretiationVehicle();
			}
		}
		return minDepretiation;
	}

	/**
	 * This function calculates the average tax of all the cars in the list
	 * 
	 * @return The average tax of all the cars in the list.
	 */
	public long averageTax() {
		long total = 0;
		long average = 0;
		for (int i = 0; i < listOfAutos.size(); i++) {
			total += listOfAutos.get(i).getValueTax();
		}
		average = total / listOfAutos.size();
		return average;
	}

	/**
	 * > Find the oldest car in the list of cars
	 * 
	 * @return The age of the oldest car in the list.
	 */
	public int higherAgeOld() {
		int maxAge = listOfAutos.get(0).getYearsOld();
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (maxAge < listOfAutos.get(i).getYearsOld()) {
				maxAge = listOfAutos.get(i).getYearsOld();
			}
		}
		return maxAge;
	}

	/**
	 * > Find the minimum age of all the cars in the list
	 * 
	 * @return The age of the oldest car in the list.
	 */
	public int lowerAgeOld() {
		int minAge = listOfAutos.get(0).getYearsOld();
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (minAge > listOfAutos.get(i).getYearsOld()) {
				minAge = listOfAutos.get(i).getYearsOld();
			}
		}
		return minAge;
	}

	/**
	 * > This function returns the total taxes of all the cars in the list that are
	 * of a certain model or newer
	 * 
	 * @param model The model of the car
	 * @return The total value of the taxes of all the cars that are equal to or
	 *         greater than the model year.
	 */
	public long totalTaxesByModel(int model) {
		long total = 0;
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (listOfAutos.get(i).getModel() >= model) {
				total += listOfAutos.get(i).getValueTax();
			}
		}
		return total;
	}

	/**
	 * > This function returns the number of cars in the list that have the color
	 * specified by the parameter
	 * 
	 * @param color the color of the car
	 * @return The quantity of autos that have the same color.
	 */
	public int quantityColor(String color) {
		int quantity = 0;
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (listOfAutos.get(i).getColor().equals(color)) {
				quantity++;

			}
		}
		return quantity;
	}

	/**
	 * > This function returns the number of cars with a given car body type
	 * 
	 * @param carBody the type of car body
	 * @return The quantity of cars with the same car body.
	 */
	public int quantityCarBody(String carBody) {
		int quantity = 0;
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (listOfAutos.get(i).getCarBody().equals(carBody)) {
				quantity++;

			}
		}
		return quantity;
	}

	/**
	 * > This function returns the number of cars in the list that have the same
	 * brand as the brand passed in as a parameter
	 * 
	 * @param brand the brand of the car
	 * @return The quantity of autos with the same brand.
	 */
	public int quantityBrand(String brand) {
		int quantity = 0;
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (listOfAutos.get(i).getBrand().equals(brand)) {
				quantity++;

			}
		}
		return quantity;
	}

	/**
	 * This function takes a city name as a parameter and returns the number of cars
	 * in that city
	 * 
	 * @param city The city to search for.
	 * @return The quantity of autos in the city.
	 */
	public int quantityCity(String city) {
		int quantity = 0;
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (listOfAutos.get(i).getUbication().equals(city)) {
				quantity++;

			}
		}
		return quantity;
	}

	/**
	 * This function takes a color as a parameter and returns the average value of
	 * all the cars of that color
	 * 
	 * @param color the color of the car
	 * @return The average value of the cars sold by color.
	 */
	public long averageSellByColor(String color) {
		long total = 0;
		long average = 0;
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (listOfAutos.get(i).getColor().equals(color)) {
				total += listOfAutos.get(i).getValueSell();
			}
		}
		average = total / quantityColor(color);
		return average;
	}

	/**
	 * This function calculates the average value of the cars sold by the car body
	 * type
	 * 
	 * @param carBody The type of car body.
	 * @return The average value of the cars sold by car body.
	 */
	public long averageSellByCarBody(String carBody) {
		long total = 0;
		long average = 0;
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (listOfAutos.get(i).getCarBody().equals(carBody)) {
				total += listOfAutos.get(i).getValueSell();
			}
		}
		average = total / quantityCarBody(carBody);
		return average;
	}

	/**
	 * This function calculates the average value of the cars sold by a given brand
	 * 
	 * @param brand The brand of the car
	 * @return The average value of the cars sold by brand.
	 */
	public long averageSellByBrand(String brand) {
		long total = 0;
		long average = 0;
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (listOfAutos.get(i).getBrand().equals(brand)) {
				total += listOfAutos.get(i).getValueSell();
			}
		}
		average = total / quantityBrand(brand);
		return average;
	}

	/**
	 * This function calculates the average value of the cars sold in a city
	 * 
	 * @param city String
	 * @return The average of the value of the cars sold in a city.
	 */
	public long averageSellByUbication(String city) {
		long total = 0;
		long average = 0;
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (listOfAutos.get(i).getUbication().equals(city)) {
				total += listOfAutos.get(i).getValueSell();
			}
		}
		average = total / quantityCity(city);
		return average;
	}

	/**
	 * > This function calculates the total value of the insurance of all the cars
	 * that have a cilinder capacity greater than the one given as a parameter
	 * 
	 * @param cilinder The cilinder capacity of the car.
	 * @return The total value of the insurance of all the cars that have a cilinder
	 *         capacity greater than the one given as a parameter.
	 */
	public long totalInsuranceByCilinder(int cilinder) {
		long totalSOAT = 0;
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (listOfAutos.get(i).getCilinderCapacity() > cilinder) {
				totalSOAT += listOfAutos.get(i).getValueInsurance();
			}
		}
		return totalSOAT;
	}

	/**
	 * This function takes in a float value and returns a string
	 * 
	 * @param price the price of the vehicle
	 * @return A string of all the autos that have the same depretiation as the
	 *         price.
	 */
	public String findAutoByDepretiation(float price) {
		String auto = "";
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (listOfAutos.get(i).getDepretiationVehicle() == price) {
				auto += listOfAutos.get(i).toString() + "\n";
			}
		}
		return auto;
	}

	/**
	 * This function takes a float as a parameter and returns a string
	 * 
	 * @param price the price of the car
	 * @return A string of all the cars that have the same tax value as the price.
	 */
	public String findAutoByTax(float price) {
		String auto = "";
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (listOfAutos.get(i).getValueTax() == price) {
				auto += listOfAutos.get(i).toString() + "\n";
			}
		}
		return auto;
	}

	/**
	 * > This function takes in an integer and returns a string
	 * 
	 * @param years the years old of the auto
	 * @return A string of all the autos that are the same age as the years
	 *         parameter.
	 */
	public String findAutoByYearsOld(int years) {
		String auto = "";
		for (int i = 0; i < listOfAutos.size(); i++) {
			if (listOfAutos.get(i).getYearsOld() == years) {
				auto += listOfAutos.get(i).toString() + "\n";
			}
		}
		return auto;
	}

}
