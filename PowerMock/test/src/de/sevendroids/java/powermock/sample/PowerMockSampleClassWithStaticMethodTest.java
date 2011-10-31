/**
 * 
 */
package de.sevendroids.java.powermock.sample;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author 7droids.de (FA)
 * 
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(PowerMockSampleClassWithStaticMethod.class)
public class PowerMockSampleClassWithStaticMethodTest {

	/**
	 * Test method for
	 * {@link PowerMockSampleClassWithStaticMethod#isCurrentDateDayLightSwitchingDate()}
	 */
	@Test
	public void verifyThatIsCurrentDateDayLightSwitchingDateFromWinterToSummer() {
		Calendar endOfMarch = Calendar.getInstance();
		endOfMarch.set(2011, Calendar.MARCH, 27);
		PowerMockito.mockStatic(Calendar.class);
		Mockito.when(Calendar.getInstance()).thenReturn(endOfMarch);
		PowerMockSampleClassWithStaticMethod testClass = new PowerMockSampleClassWithStaticMethod();
		assertTrue(testClass.isCurrentDateDayLightSwitchingDate());
		PowerMockito.verifyStatic();
	}
}
