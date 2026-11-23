package com.smartstore.billing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BillingApplicationTest {

	@Test
	void testCalculateDiscountBelowOneThousand() {
		double totalAmount = 800;
		double expectedDiscount = 0;

		double actualDiscount = BillingApplication.calculateDiscount(totalAmount);

		assertEquals(expectedDiscount, actualDiscount, 0.001);
	}

	@Test
	void testCalculateDiscountAtOneThousand() {
		double totalAmount = 1000;
		double expectedDiscount = 50;

		double actualDiscount = BillingApplication.calculateDiscount(totalAmount);

		assertEquals(expectedDiscount, actualDiscount, 0.001);
	}

	@Test
	void testCalculateDiscountAtFourThousandNineHundredNinetyNine() {
		double totalAmount = 4999;
		double expectedDiscount = 249.95;

		double actualDiscount = BillingApplication.calculateDiscount(totalAmount);

		assertEquals(expectedDiscount, actualDiscount, 0.001);
	}

	@Test
	void testCalculateDiscountAtFiveThousand() {
		double totalAmount = 5000;
		double expectedDiscount = 500;

		double actualDiscount = BillingApplication.calculateDiscount(totalAmount);

		assertEquals(expectedDiscount, actualDiscount, 0.001);
	}

	@Test
	void testCalculateDiscountAboveFiveThousand() {
		double totalAmount = 7000;
		double expectedDiscount = 700;

		double actualDiscount = BillingApplication.calculateDiscount(totalAmount);

		assertEquals(expectedDiscount, actualDiscount, 0.001);
	}
}