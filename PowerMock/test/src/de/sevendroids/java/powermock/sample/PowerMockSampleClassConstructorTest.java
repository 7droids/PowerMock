package de.sevendroids.java.powermock.sample;

import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author 7droids.de (FA)
 */
// 1 Define special runner for PowerMock
@RunWith(PowerMockRunner.class)
// 2 Define class to test
@PrepareForTest(PowerMockSampleClassConstructor.class)
public class PowerMockSampleClassConstructorTest {

	/**
	 * Test method for
	 * {@link PowerMockSampleClassConstructor#isTodayAfterFixedDate()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void verifyThatIsTodayAfterFixedDateForEndOfOctober2011()
			throws Exception {
		// Create a date for 30th of October
		Calendar cal = Calendar.getInstance();
		cal.set(2011, Calendar.OCTOBER, 30);
		Date lastDayInOctober = cal.getTime();
		// 3 Define return value for constructor
		whenNew(Date.class).withNoArguments().thenReturn(lastDayInOctober);
		assertTrue(PowerMockSampleClassConstructor.isTodayAfterFixedDate());
		// 4 Constructor called only once
		verifyNew(Date.class).withNoArguments();
	}
}
