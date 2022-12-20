package presenter;

import model.*;
import view.*;
import java.text.*;
import java.util.*;

public class Presenter {

	View view;
	Vehicle vehicle;
	Taxes tax;
	NumberFormat nf = NumberFormat.getInstance(Locale.US);
	String parameter[] = { "Color", "Carrocería", "Ciudad", "Marca" };
	String colors[] = { "blanco", "negro", "rojo", "azul", "amarillo", "naranja", "gris", "verde", "Otro" };
	String brands[] = { "Toyota", "Mazda", "Cadillac", "Chevrolet", "Volkswagen", "Renault", "Ferrari", "Land Rover",
			"Otro" };
	String citiesData[] = { "Tunja", "Sogamoso", "Paipa", "Duitama", "Bogota", "Chiquinquirá", "San Gil",
			"Villavicencio", "Otro" };
	String carBodyData[] = { "Cupé", "Liftback", "Familiar", "Sedán", "Descapotable", "Otro" };

	// Creating a new instance of the View class and the Taxes class.
	public Presenter() {
		view = new View();
		tax = new Taxes();

		createData();
	}

	/**
	 * It shows a menu with a list of options to the user
	 * 
	 * @return The option that the user has chosen.
	 */
	public String showMenu() {
		String data[] = { "Ingresar vehículo", "Modificar vechiulo", "Eliminar vehiculo", "Ver Listado de información",
				"Total impuestos de los vehiculos por color",
				"Cantidad de vehiculos de acuerdo a modelo ___ o superiores", "Buscar vehículo mayor costo de impuesto",
				"Buscar vehículo menor costo de impuesto", "Promedio del valor del impuesto",
				"Promedio del valor del SOAT", "Depreacicón vehicular más alta", "Depreciación vehicular máss baja",
				"Menor número de años de antigüedad", "Mayor número de años de antigüedad",
				"Valor total de impuesto en vehiculos modelos mayores a____", "Cantidad de vehiculos según parametro", // COLOR,
																														// MARCA,
																														// //
																														// CARRCERIA
				"Promedio de venta de los vehiculos según parametro", // COLOR, MARCA, CARROCERÍA
				"valor total de los Soat para un cilindraje mayor a___", "Salir"

		};
		String option = view.showListDialogParameters(data,
				"------BIENVENIDO AL SISTEMA SOAT----- \n ESCOJA LA OPCIÓN DE SU PREFERENCIA");
		return option;

	}

	/**
	 * It creates a new car object and adds it to the list of cars
	 */
	public void createData() {
		tax.addCar(123123, "Toyota", "Hatchback", 2022, "blanco", 45000000, 3144, "Tunja");
		tax.addCar(524123, "Mazda", "Liftback", 2001, "azul", 186674270, 1711, "Sogamoso");
		tax.addCar(231233, "Cadillac", "Sedán", 2015, "rojo", 69164886, 2204, "Duitama");
		tax.addCar(423123, "Chevrolet", "Sedán", 1998, "verde", 215606757, 2097, "Tunja");
		tax.addCar(323123, "Toyota", "Hatchback", 1995, "gris", 182634771, 1101, "Bogotá");
		tax.addCar(223123, "Chevrolet", "Cupé", 2022, "blanco", 163700568, 1198, "Tunja");
		view.showGraficMessage("DATOS CARGADOS");
	}

	/**
	 * This function is used to register a vehicle in the system, it has a
	 * verification that checks if the vehicle is already registered, if it is, it
	 * will show an error message, if it is not, it will register the vehicle
	 */
	public void enterVehicle() throws NullPointerException, NumberFormatException {
		try {
			int register = view.readGraficInt("Ingrese el registro del vehículo");
			boolean verification = tax.verify(register);

			if (verification == true) {
				view.showErrorMessage("Ya existe un auto con este registro");
				run();

			} else {

				String brand = view.showListDialogParameters(brands, "Ingrese la marca del vehículo");
				String carBody = view.showListDialogParameters(carBodyData,
						"Ingrese el tipo de carrocería del vehículo");
				int model = view.readGraficInt("Ingrese el modelo del vehículo");
				String color = view.showListDialogParameters(colors, "ESCOJA EL COLOR DE SU VEHICULO");

				long price = view.readGraficLong("Ingrese el valor del vehículo");
				int cylinder = view.readGraficInt("Ingrese el cilindraje del vehículo");
				String city = view.showListDialogParameters(citiesData, "Ingrese la ciudad de registro del vehículo");
				long valueTax = tax.calculateTax(price);
				int yearsOld = tax.calculateAge(model);
				long depreciation = tax.vehicleDepreciation(yearsOld, price);
				long totalValueSell = tax.calculateSellValue(price, depreciation);
				long insuranceValue = tax.insuranceValue(cylinder, yearsOld);

				Vehicle vehicle = new Vehicle(register, brand, carBody, model, color, price, cylinder, city, valueTax,
						yearsOld, depreciation, totalValueSell, insuranceValue);
				tax.addCarUser(vehicle);
				view.showGraficMessage("AUTO REGISTRADO");
			}

		} catch (NullPointerException e) {
			view.showErrorMessage("DEBE RELLENAR EL ESPACIO EN BLANCO");
		} catch (NumberFormatException ex) {
			view.showErrorMessage("POR FAVOR, DIGITE EL NÚMERO CORRESPONDIENTE");
		}

	}

	/**
	 * The function modifyVehicle() is used to modify the data of a vehicle that has
	 * already been registered in the system
	 */
	public void modifyVehicle() throws NullPointerException, NumberFormatException {
		try {
			int register = view.readGraficInt("Ingrese el registro del vehículo que desea modificar");
			boolean verification = tax.verify(register);
			if (verification == true) {
				int confirmation = view
						.readGraficInt("EL AUTO QUE DESEA MODIFICAR ES:" + tax.dataAuto(register) + "[1]SI \n [2]NO");
				if (confirmation == 1) {
					String brand = view.showListDialogParameters(brands, "Ingrese la marca del vehículo");
					String carBody = view.showListDialogParameters(carBodyData,
							"Ingrese el tipo de carrocería del vehículo");
					int model = view.readGraficInt("Ingrese el modelo del vehículo");
					String color = view.showListDialogParameters(colors, "ESCOJA EL COLOR DE SU VEHICULO");

					long price = view.readGraficLong("Ingrese el valor del vehículo");
					int cylinder = view.readGraficInt("Ingrese el cilindraje del vehículo");
					String city = view.showListDialogParameters(citiesData,
							"Ingrese la ciudad de registro del vehículo");
					long valueTax = tax.calculateTax(price);
					int yearsOld = tax.calculateAge(model);
					long depreciation = tax.vehicleDepreciation(yearsOld, price);
					long totalValueSell = tax.calculateSellValue(price, depreciation);
					long insuranceValue = tax.insuranceValue(cylinder, yearsOld);

					tax.modifyAuto(register, brand, carBody, model, color, price, cylinder, city, valueTax, yearsOld,
							register, totalValueSell, insuranceValue);

					view.showGraficMessage("AUTO MODIFICADO");
				} else {
					run();
				}
			} else {
				view.showGraficMessage("NO EXISTE UN AUTO CON ESTE REGISTRO");
			}
		} catch (NullPointerException e) {
			view.showErrorMessage("DEBE RELLENAR EL ESPACIO EN BLANCO");
		} catch (NumberFormatException ex) {
			view.showErrorMessage("POR FAVOR, DIGITE EL NÚMERO CORRESPONDIENTE");
		}

	}

	/**
	 * It deletes a vehicle from the database.
	 */
	public void deleteVehicle() {
		int register = view.readGraficInt("Ingrese el registro del vehículo que desea borrar");
		boolean verification = tax.verify(register);
		if (verification == true) {
			int confirmation = view
					.readGraficInt("EL AUTO QUE DESEA BORRAR ES:" + tax.dataAuto(register) + "[1]SI \n [2]NO");
			if (confirmation == 1) {
				boolean reafirmation = tax.deleteAuto(register);
				if (reafirmation == true) {
					view.showGraficMessage("SE HA ELIMININADO CORRECTAMENTE");
				}
			}
		} else {
			view.showErrorMessage("NO EXISTE UN AUTO CON ESE REGISTRO");
		}
	}

	/**
	 * It shows the information of all the cars registered in the system
	 */
	public void totalInformation() {
		view.showGraficMessage("=====AUTOS REGISTRADOS=====\n"
				+ "|| REGISTRO || MARCA || CARROCERIA || MODELO || COLOR || PRECIO || CILINDRAJE || UBICACIÓN || VALOR IMPUESTO || ANTIGUEDAD || DEPRECIACIÓN || VALOR VENTA || VALOR SOAT ||\n"
				+ tax.showAutos());

	}

	// FILTROS

	// punto 1
	/**
	 * It takes a color from the user, and then it calculates the total taxes for
	 * that color
	 */
	public void totalTaxesByColor() {
		long total = 0;

		String data = null;
		int option = view.showOptionDialogMenu(colors);
		switch (option) {
		case 0:
			data = colors[0];
			total = tax.totalTaxByColor(data);
			view.showGraficMessage("El total de impuestos para el color: " + colors[0] + " es de: " + nf.format(total));
			break;

		case 1:
			data = colors[1];
			total = tax.totalTaxByColor(data);
			view.showGraficMessage("El total de impuestos para el color: " + colors[1] + " es de: " + nf.format(total));
			break;
		case 2:
			data = colors[2];
			total = tax.totalTaxByColor(data);
			view.showGraficMessage("El total de impuestos para el color: " + colors[2] + " es de: " + nf.format(total));
			break;

		case 3:
			data = colors[3];
			total = tax.totalTaxByColor(data);
			view.showGraficMessage("El total de impuestos para el color: " + colors[3] + " es de: " + nf.format(total));
			break;

		case 4:
			data = colors[4];
			total = tax.totalTaxByColor(data);
			view.showGraficMessage("El total de impuestos para el color: " + colors[4] + " es de: " + nf.format(total));
			break;

		case 5:
			data = colors[5];
			total = tax.totalTaxByColor(data);
			view.showGraficMessage("El total de impuestos para el color: " + colors[5] + " es de: " + nf.format(total));
			break;

		case 6:
			data = colors[6];
			total = tax.totalTaxByColor(data);
			view.showGraficMessage("El total de impuestos para el color: " + colors[6] + " es de: " + nf.format(total));
			break;

		case 7:
			data = colors[7];
			total = tax.totalTaxByColor(data);
			view.showGraficMessage("El total de impuestos para el color: " + colors[7] + " es de: " + nf.format(total));
			break;

		default:
			break;
		}

	}

	// PUNTO 2
	/**
	 * It reads an integer from the user, and then displays the total number of
	 * vehicles with a model number equal to or greater than the number entered by
	 * the user
	 */
	public void quantityByModels() throws NumberFormatException {

		try {
			int model = view.readGraficInt("DIGITE EL MODELO DESDE EL CUAL DESDE CALCULAR LA CANTIDAD");
			int total = tax.totalByModelsSuperior(model);
			view.showGraficMessage(
					"LA CANTIDAD DE VEHICULOS MODELO " + model + " O SUPERIORES SON: " + nf.format(total));
		} catch (NumberFormatException e) {
			view.showErrorMessage("DEBE DIGITAR NÚMEROS ÚNICAMENTE");
		}

	}

	/**
	 * It shows the highest tax value.
	 */
	public void higherTax() {
		view.showGraficMessage("EL IMPUESTO VEHICULAR DE MAYOR VALOR ES DE: " + nf.format(tax.higherTax())
				+ "\nLA INFORMACIÓN DEL VEHICULO ES: \n" + tax.findAutoByTax(tax.higherTax()));
	}

	/**
	 * The function lowerTax() is used to show the user the vehicle with the lowest
	 * tax
	 */
	public void lowerTax() {
		view.showGraficMessage("EL IMPUESTO VEHICULAR DE MENOR VALOR ES DE: " + nf.format(tax.lowerTax())
				+ "\nLA INFORMACIÓN DEL VEHICULO ES: \n" + tax.findAutoByTax(tax.lowerTax()));

	}

	// punto 4
	/**
	 * It shows the average of the SOAT value.
	 */
	public void averageTax() {
		view.showGraficMessage("EL PROMEDIO DEL VALOR DEL IMPUESTO ES DE: " + nf.format(tax.averageTax()));
	}

	// PUNTO 3
	/**
	 * > This function calculates the average of the SOAT value
	 */
	public void averageSOAT() {
		view.showGraficMessage("EL PROMEDIO DEL VALOR DEL SOAT ES DE: " + nf.format(tax.averageSOAT()));
	}

	// punto5
	/**
	 * It shows the highest depreciation of the vehicles.
	 */
	public void higherDepretiation() {
		view.showGraficMessage("LA DEPRECIACIÓN VEHICULAR DE MAYOR VALOR ES DE: " + nf.format(tax.higherDepretiation())
				+ "\nLA INFORMACIÓN DEL VEHICULO ES: \n" + tax.findAutoByDepretiation(tax.higherDepretiation()));
	}

	/**
	 * This function is used to show the lower depreciation of the vehicle
	 */
	public void lowerDepretiation() {
		view.showGraficMessage("LA DEPRECIACIÓN VEHICULAR DE MENOR VALOR ES DE: " + nf.format(tax.lowerDepretiation())
				+ "\nLA INFORMACIÓN DEL VEHICULO ES: \n" + tax.findAutoByDepretiation(tax.lowerDepretiation()));

	}

	// PUNTO6
	/**
	 * > This function shows the lower age of the old people in the database
	 */
	public void lowerAgeOld() {
		view.showGraficMessage("EL MENOR NÚMERO DE AÑOS ES DE: " + tax.lowerAgeOld()
				+ "\nLA INFORMACIÓN DEL VEHICULO ES: \n" + tax.findAutoByYearsOld(tax.lowerAgeOld()));
	}

	/**
	 * It shows the oldest person in the list.
	 */
	public void higherAgeOld() {
		view.showGraficMessage("EL MAYOR NÚMERO DE AÑOS ES DE: " + tax.higherAgeOld()
				+ "\nLA INFORMACIÓN DEL VEHICULO ES: \n" + tax.findAutoByYearsOld(tax.higherAgeOld()));
	}

	/**
	 * It reads an integer from the user, and then displays the total taxes for all
	 * cars with a model number greater than or equal to the number entered by the
	 * user
	 */
	public void totalTaxByModel() throws NumberFormatException {
		try {
			int model = view
					.readGraficInt("POR FAVOR, DIGITE EL MODELO DESDE EL CUAL DESEA CALCULAR EL TOTAL DE IMPUESTOS");
			view.showGraficMessage("EL TOTAL DE LOS IMPUESTOS PARA EL MODELO: " + model + " Y SUPERIORES, ES DE: "
					+ nf.format(tax.totalTaxesByModel(model)));
		} catch (NumberFormatException e) {
			view.showGraficMessage("DIGITE NÚMEROS ÚNICAMENTE");
		}

	}

	/**
	 * It shows a dialog menu with the options of the array parameter, then it shows
	 * a list dialog with the options of the array colors, carBodyData, citiesData
	 * or brands, depending on the option chosen in the dialog menu, then it shows a
	 * message dialog with the quantity of the chosen option
	 */
	public void quantityByParameters() {

		int option = view.showOptionDialogMenu(parameter);
		String election;
		switch (option) {
		case 0:
			election = view.showListDialogParameters(colors, "ELIGE EL COLOR PARA CALCULAR LA CANTIDAD");
			view.showGraficMessage("HAY " + tax.quantityColor(election) + "DE COLOR: " + election);
			break;
		case 1:
			election = view.showListDialogParameters(carBodyData, "ELIGE LA CARROCERÍA PARA CALCULAR LA CANTIDAD");
			view.showGraficMessage("HAY " + tax.quantityCarBody(election) + "DE CARROCERIA: " + election);
			break;
		case 2:
			election = view.showListDialogParameters(citiesData, "ELIGE LA CIUDAD PARA CALCULAR LA CANTIDAD");
			view.showGraficMessage("HAY " + tax.quantityCity(election) + "DE LA CIUDAD DE: " + election);
			break;
		case 3:
			election = view.showListDialogParameters(brands, "ELIGE LA MARCA PARA CALCULAR LA CANTIDAD");
			view.showGraficMessage("HAY " + tax.quantityBrand(election) + "DE LA MARCA DE: " + election);
			break;

		default:
			break;
		}

	}

	/**
	 * It shows a dialog with a list of parameters, then it shows another dialog
	 * with a list of options for the selected parameter, then it shows a message
	 * with the average of the selected parameter
	 */
	public void averageSellByParameters() {
		int option = view.showOptionDialogMenu(parameter);
		String election;
		switch (option) {
		case 0:
			election = view.showListDialogParameters(colors, "ELIGE EL COLOR PARA CALCULAR EL PROMEDIO DE VENTA");
			view.showGraficMessage("EL PROMEDIO DE VENTA ES DE : " + nf.format(tax.averageSellByColor(election))
					+ " PARA EL COLOR: " + election);
			break;
		case 1:
			election = view.showListDialogParameters(carBodyData, "ELIGE LA  PARA CALCULAR EL PROMEDIO DE VENTA");
			view.showGraficMessage("EL PROMEDIO DE VENTA ES DE : " + nf.format(tax.averageSellByCarBody(election))
					+ " PARA LA MARCA: " + election);
			break;
		case 2:
			election = view.showListDialogParameters(citiesData, "ELIGE LA CIUDAD PARA CALCULAR EL PROMEDIO DE VENTA");
			view.showGraficMessage("EL PROMEDIO DE VENTA ES DE : " + nf.format(tax.averageSellByUbication(election))
					+ " PARA LA CIUDAD: " + election);
			break;
		case 3:
			election = view.showListDialogParameters(brands, "ELIGE LA MARCA PARA CALCULAR EL PROMEDIO DE VENTA");
			view.showGraficMessage("EL PROMEDIO DE VENTA ES DE : " + nf.format(tax.averageSellByBrand(election))
					+ " PARA LA MARCA: " + election);
			break;
		default:
			break;
		}

	}

	/**
	 * This function allows the user to enter a cylinder base and the system will
	 * show the total value of the SOAT of the vehicles with a greater cylinder than
	 * the one entered
	 */
	public void totalSOATByCylinder() throws NumberFormatException {
		try {
			int cilinder = view.readGraficInt("DIGITE EL CILINDRAJE BASE");
			view.showGraficMessage("EL VALOR TOTAL DE LOS SOAT DE LOS VECIHULOS DE CILINDRAJE MAYOR A: " + cilinder
					+ " ES DE: " + nf.format(tax.totalInsuranceByCilinder(cilinder)));
		} catch (NumberFormatException e) {
			view.showErrorMessage("DEBE DIGITAR NÚMEROS ÚNICAMENTE");
		}
	}

	/**
	 * It shows the menu and depending on the option selected, it calls the
	 * corresponding function
	 */
	public void run() throws NullPointerException {
		String option = null;
		do {
			try {
				option = showMenu();

				switch (option) {
				case "Ingresar vehículo":
					enterVehicle();
					break;
				case "Modificar vechiulo":
					modifyVehicle();
					break;
				case "Eliminar vehiculo":
					deleteVehicle();
					break;
				case "Ver Listado de información":
					totalInformation();
					break;
				case "Total impuestos de los vehiculos por color":
					totalTaxesByColor();
					break;
				case "Cantidad de vehiculos de acuerdo a modelo ___ o superiores":
					quantityByModels();
					break;
				case "Buscar vehículo mayor costo de impuesto":
					higherTax();
					break;
				case "Buscar vehículo menor costo de impuesto":
					lowerTax();
					break;
				case "Promedio del valor del impuesto":
					averageTax();
					break;
				case "Promedio del valor del SOAT":
					averageSOAT();
					break;
				case "Depreacicón vehicular más alta":
					higherDepretiation();
					break;
				case "Depreciación vehicular máss baja":
					lowerDepretiation();
					break;
				case "Menor número de años de antigüedad":
					lowerAgeOld();
					break;
				case "Mayor número de años de antigüedad":
					higherAgeOld();
					break;

				case "Valor total de impuesto en vehiculos modelos mayores a____":
					totalTaxByModel();
					break;
				case "Cantidad de vehiculos según parametro":
					quantityByParameters();
					break;
				case "Promedio de venta de los vehiculos según parametro":
					averageSellByParameters();
					break;
				case "valor total de los Soat para un cilindraje mayor a___":
					totalSOATByCylinder();
					break;
				case "Salir":
					view.showGraficMessage("ADIÓS");
					option = "null";
					break;

				default:
					view.showGraficMessage("ADIÓS");
					break;
				}
			} catch (NullPointerException e) {
				view.showErrorMessage("DEBE SELECCIONAR UNA OPCIÓN");
			}
		} while (option != "null");
	}

	/**
	 * The main function creates a new Presenter object and calls the run function
	 * on it
	 */
	public static void main(String[] args) {
		Presenter test = new Presenter();
		test.run();
	}

}
