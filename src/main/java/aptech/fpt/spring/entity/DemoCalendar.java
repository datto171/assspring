package aptech.fpt.spring.entity;

import java.util.Calendar;
import java.util.TimeZone;

public class DemoCalendar {
    public static String generateTime(long timeMLS) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+7"));
        cal.setTimeInMillis(timeMLS);
        return String.format("%02d-%02d-%4d %02d:%02d",
                cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.HOUR),
                cal.get(Calendar.MINUTE));
    }
}
