package solartimes;

public class MainActivity {

    public static void main(String[] args) {

        double latitude = Location.latitude;
        double longitude = Location.longitude;

        MyDate myDate = new MyDate();
        int year = myDate.year;
        int month = myDate.month;
        int day = myDate.day;
        int hour = myDate.hour;
        int minute = myDate.minute;

        Julian julian = new Julian(year, month, day);

        double T = julian.noonT; // T at noon

        //double julianNew = julian.julian;
        // calculate sun elements
        ElementsSun elementsSun = new ElementsSun(T);
        double deltaSunDeg = elementsSun.deltaSunDeg;
        double alfaSunDeg = elementsSun.alfaSunDeg;

        SolarActivity solarActivity = new SolarActivity(latitude, T, deltaSunDeg, alfaSunDeg);

        double sunAltMax = solarActivity.elvatioMaxDeg;
        double sunUvi = solarActivity.uvIndex;
        double sunUviMax = solarActivity.uvIndexMax;

        double sunNow = solarActivity.currentSunPower;
        double sunDayMax = solarActivity.maxSunPowerDiurnal;
        double sunYearMax = solarActivity.maxSunPowerAnnual;
        double sunTherm = solarActivity.thermalActivity;
        double sunThermStrong = solarActivity.thermalActivityStrong;
        String sunThermEndString = solarActivity.thermalActivityEndString;
        String sunUviEndString = solarActivity.uvIndexEndString;

        //System.out.println("Solar activity " + solarActivity.maxSunPowerDiurnal);
        System.out.println("AunAltitude " + solarActivity.maxSunPowerDiurnal);
        System.out.println("AunAltitude " + solarActivity.uvIndexMax);
        System.out.println("AunAltitude " + solarActivity.currentSunPower);

        //System.out.println("UVI " + sunUviMax);
        //System.out.println("aurinko " + sunAltMax);
        //System.out.println("UVI " + sunUviMax);
        //sunTimes();
    }

    public static void sunTimes() {

        String sunRizeString = Rize.timeRizeString;
        String sunSouthString = South.timeSouthString;
        String sunSetString = Set.timeSetHorizonString;

        String sunAboveString = Up.timeUpString;
        //TimeFormat delta = new TimeFormat(sunAboveDelta);
        String sunAboveDeltaString = "00" + ":" + TimeFormat.minuteTimeString;

        String sunCivilString = Set.timeSetCivilString;
        String sunNauticalString = Set.timeSetNauticalString;
        String sunAstroString = Set.timeSetAstronomicalString;

        //String sunAzimuth = LocalHorizontal.suunta;
        //double sunAltitude = LocalHorizontal.elevation;

    }

}
