package solartimes;

public class TimeFormat {

    public static double hourTimeDouble;
    public static String minuteTimeString;

    public static String timeHour(double timeValue) {

        // hour value
        Double intHour = new Double(timeValue);
        int hourTime = intHour.intValue();
        String hourTimeString = String.valueOf(hourTime);

        Integer intHourDouble = new Integer(hourTime);
        hourTimeDouble = intHourDouble.doubleValue();

        return hourTimeString;
    }

    public static String timeMinute(double timeValue) {
        // minute value
        Double intMinute = new Double(((timeValue - hourTimeDouble) * 60.));
        int minuteTime = intMinute.intValue();

        if (minuteTime < 10) {
            minuteTimeString = "0" + String.valueOf(minuteTime);
        } else {
            minuteTimeString = String.valueOf(minuteTime);
        }
        return minuteTimeString;
    }

}

