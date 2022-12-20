package test;

import model.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTax {
	Taxes tax = new Taxes();

	/**
	 * > This function tests the calculateTax function in the Tax class
	 */
	@Test

	public void testCalculatorTax() {
		long result = tax.calculateTax(45000000);
		long expected = 675000; // 1,5%
		assertEquals(expected, result);
	}

	/**
	 * This function tests the vehicleDepreciation function in the Tax class
	 */
	@Test
	public void testDepretiation() {
		long result = tax.vehicleDepreciation(3, 45000000);
		long expected = 4950000;
		assertEquals(expected, result);
	}

	/**
	 * This function tests the insuranceValue function in the Tax class
	 */
	@Test

	public void testInsurenceValue() {
		long result = tax.insuranceValue(1500, 11);
		long expected = 750000;
		assertEquals(expected, result);
	}
}
