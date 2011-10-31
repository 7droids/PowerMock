/**
 * 
 */
package de.sevendroids.java.powermock.sample;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author 7droids.de (FA) <br>
 *         Sample class with use cases for the mocking lib Power Mock
 */
public class PowerMockSampleClassWithStaticMethod {

	/**
	 * With this simple Method you can check whether today is a day light
	 * switching date.
	 * 
	 * @return TRUE if on this day the time is changing from day light saving
	 *         time to normal time or vis versa.
	 */
	public boolean isCurrentDateDayLightSwitchingDate() {
		Calendar today = Calendar.getInstance();
		return isCurrentDateDayLightSwitchingDate(today);
	}

	/**
	 * With this simple Method you can check whether today is a day light
	 * switching date.
	 * 
	 * @param date
	 *            Date to test
	 * 
	 * @return TRUE if on this day the time is changing from day light saving
	 *         time to normal time or vis versa.
	 */
	protected boolean isCurrentDateDayLightSwitchingDate(Calendar date) {
		Calendar todayInTheMorning = date;
		todayInTheMorning.set(Calendar.HOUR_OF_DAY, 0);
		todayInTheMorning.set(Calendar.MINUTE, 0);
		todayInTheMorning.set(Calendar.SECOND, 0);
		Calendar todayInTheEvening = (Calendar) todayInTheMorning.clone();
		todayInTheEvening.set(Calendar.HOUR_OF_DAY, 23);
		todayInTheEvening.set(Calendar.MINUTE, 59);
		todayInTheEvening.set(Calendar.SECOND, 59);
		TimeZone tz = TimeZone.getDefault();
		return tz.inDaylightTime(todayInTheMorning.getTime()) != tz
				.inDaylightTime(todayInTheEvening.getTime());
	}
}
