package de.sevendroids.java.powermock.sample;

import java.util.Calendar;
import java.util.Date;

/**
 * @author 7droids.de (FA)
 */
public class PowerMockSampleClassConstructor {

	private static final Date FIXEDDATE;
	static {
		Calendar cal = Calendar.getInstance();
		cal.set(2011, Calendar.OCTOBER, 27, 0, 0, 0);
		cal.set(Calendar.MILLISECOND, 0);
		FIXEDDATE = cal.getTime();
	}

	public static boolean isTodayAfterFixedDate() {
		Date today = new Date();
		return today.after(FIXEDDATE);
	}
}
