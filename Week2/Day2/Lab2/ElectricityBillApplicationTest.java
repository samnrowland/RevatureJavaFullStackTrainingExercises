package week2.day2.assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ElectricityBillApplicationTest {

	@Test
	void testEnergyChargeAt100Units() {
		// 100 units are all charged at ₹3 per unit.
		assertEquals(300.00, ElectricityBillApplication.calculateEnergyCharge(100), 0.001);
	}

	@Test
	void testEnergyChargeAt101Units() {
		// 100 units cost ₹300, and the 101st unit costs ₹5.
		assertEquals(305.00, ElectricityBillApplication.calculateEnergyCharge(101), 0.001);
	}

	@Test
	void testEnergyChargeAt300Units() {
		// The first 100 units cost ₹300 and the next 200 units cost ₹1000.
		assertEquals(1300.00, ElectricityBillApplication.calculateEnergyCharge(300), 0.001);
	}

	@Test
	void testEnergyChargeAt301Units() {
		// 300 units cost ₹1300, and the 301st unit costs ₹7.50.
		assertEquals(1307.50, ElectricityBillApplication.calculateEnergyCharge(301), 0.001);
	}

	@Test
	void testSurchargeBelowThreshold() {
		// ₹1997.50 is not above ₹2000, so no surcharge is applied.
		assertEquals(0.00, ElectricityBillApplication.calculateSurcharge(1997.50), 0.001);
	}

	@Test
	void testSurchargeAtThreshold() {
		// A charge of exactly ₹2000 does not qualify for the surcharge.
		assertEquals(0.00, ElectricityBillApplication.calculateSurcharge(2000.00), 0.001);
	}

	@Test
	void testSurchargeAboveThreshold() {
		// 5% of ₹2005 is ₹100.25.
		assertEquals(100.25, ElectricityBillApplication.calculateSurcharge(2005.00), 0.001);
	}

	@Test
	void testCalculateTotal() {
		// ₹2050 + ₹50 fixed charge + 5% surcharge (₹102.50) = ₹2202.50.
		assertEquals(2202.50, ElectricityBillApplication.calculateTotal(2050.00), 0.001);
	}
	
	@Test 
	void testCalulateEnergyChargeThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> ElectricityBillApplication.calculateEnergyCharge(-1));
	}

}