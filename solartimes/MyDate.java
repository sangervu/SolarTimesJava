package solartimes;

import java.util.Calendar;
import java.util.TimeZone;

public class MyDate {

    public double timeZone;
    public double dst;
    
    
    public int year;
    public int month;
    public int day;
    public int hour;
    public int minute;

    public MyDate() {

        TimeZone tz = TimeZone.getDefault();
        int timeZoneInt = tz.getRawOffset(); // in milliseconds
        int dstInt = tz.getDSTSavings(); // in milliseconds
        
        this.dst = (double)dstInt / 1000. / 60. / 60.; 
        this.timeZone = (double) timeZoneInt / 1000. / 60. / 60.; // in hours

        /*Calendar and time*/
        Calendar cal = Calendar.getInstance();

        this.year = cal.get(Calendar.YEAR);
        this.month = cal.get(Calendar.MONTH) + 1;
        this.day = cal.get(Calendar.DATE);
        this.hour = cal.get(Calendar.HOUR_OF_DAY);
        this.minute = cal.get(Calendar.MINUTE);

    }

}
