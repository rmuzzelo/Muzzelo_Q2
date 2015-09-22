package Main;

import static org.junit.Assert.*;

import org.junit.Test;

public class TuitionTest {

	@Test
	public void testCalculateLoan() {
		assertTrue("Assertion didn't work",Tuition.CalculateLoan(12520,.04,.1)==58393.28);
	}

	@Test
	public void testRepayment() {
		assertTrue("Assertion didn't work",Tuition.Repayment(.1,10,58393.28)==771.671498094305);
	}

}
