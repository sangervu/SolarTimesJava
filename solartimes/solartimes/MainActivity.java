package solartimes;

public class MainActivity {

    public static void main(String[] args) {

        double latitudeDeg = Location.latitude;
        double longitudeDeg = Location.longitude;

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

        ElevationMax maxElevation = new ElevationMax(deltaSunDeg, latitudeDeg);
        StellarTime timeStellar = new StellarTime(T, longitudeDeg);

        double timeStellarLocalDeg = timeStellar.stellarTimeLocalDeg;
        double timeStellarNoon = timeStellar.stellarTimeNoonDeg;
        LocalHorizontal horizontalLocal = new LocalHorizontal(alfaSunDeg, deltaSunDeg, timeStellarLocalDeg, latitudeDeg);

        double currentSunElevationDeg = horizontalLocal.currentElevationDeg;

        double maxSunElevationDeg = maxElevation.maxElevationDeg;

        SolarPower powerSolar = new SolarPower(latitudeDeg, T, currentSunElevationDeg, maxSunElevationDeg);

        South south = new South(alfaSunDeg, timeStellarNoon);

        double timeSouth = south.timeSouth;

        SolarCalculations calcSolar = new SolarCalculations(deltaSunDeg, latitudeDeg, currentSunElevationDeg, maxSunElevationDeg, timeSouth);

        double sunPowerNow = powerSolar.currentSunPower;
        double sunPowerDayMax = powerSolar.maxSunPowerDiurnal;
        double sunPowerYearMax = powerSolar.maxSunPowerAnnual;

        double sunUvi = calcSolar.UvIndex;
        double sunUviMax = calcSolar.UvIndexMax;
        //double sunTherm = solarActivity.thermalActivity;
        //double sunThermStrong = solarActivity.thermalActivityStrong;
        //String sunThermEndString = solarActivity.thermalActivityEndString;
        //String sunUviEndString = solarActivity.uvIndexEndString;*/

        //System.out.println("Solar activity " + solarActivity.maxSunPowerDiurnal);
        System.out.println("Sun " + sunPowerNow);
        System.out.println("Sun " + sunPowerDayMax);
        System.out.println("Sun " + sunPowerYearMax);

        System.out.println("UVI " + sunUvi);
        System.out.println("UVI Max " + sunUviMax);
        System.out.println("aurinko " + maxSunElevationDeg);

        //sunTimes();
    }

    public static void sunTimes() {

        /*String sunRizeString = Rize.timeRizeString;
        String sunSouthString = South.timeSouthString;
        String sunSetString = Set.timeSetHorizonString;

        String sunAboveString = Up.timeUpString;
        //TimeFormat delta = new TimeFormat(sunAboveDelta);
        String sunAboveDeltaString = "00" + ":" + TimeFormat.minuteTimeString;

        String sunCivilString = Set.timeSetCivilString;
        String sunNauticalString = Set.timeSetNauticalString;
        String sunAstroString = Set.timeSetAstronomicalString;

        String sunAzimuth = LocalHorizontal.suunta;
        double sunAltitude = LocalHorizontal.elevation;
         */
    }

}
