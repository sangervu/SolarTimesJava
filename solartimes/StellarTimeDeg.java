package solartimes;

import java.util.Calendar;
import java.util.TimeZone;

public class StellarTimeDeg {

    public double stellarTimeNoon;
    public double stellarTimeLocal;

    public StellarTimeDeg(double T, double longitude) {

        //double T=CalendarLocal.T;
        TimeZone tz = TimeZone.getDefault();
        int timeZoneInt = tz.getRawOffset(); // in milliseconds
        double timeZone = timeZoneInt / 1000. / 60. / 60.; // in hours

        //current time
        Calendar cal = Calendar.getInstance();

        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);

        double hourD = Double.valueOf(hour);
        double minuteD = Double.valueOf(minute);

        double stellarTimeDeg = TrueDegree.minDegree((24110.54841 + 8640184.812866 * T + 0.093104 * (T * T) - 0.0000062 * (T * T * T)) / 3600. * 15.);

        this.stellarTimeNoon = TrueDegree.minDegree(stellarTimeDeg + 1.002737908 * (-timeZone) * 15. + longitude);
        this.stellarTimeLocal = TrueDegree.minDegree(stellarTimeNoon + (1.002737908 * (hourD + minuteD / 60.) * 15.));
    }
}
