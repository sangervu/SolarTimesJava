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

        StellarTime timeStellar = new StellarTime(T, longitudeDeg);

        double timeStellarLocalDeg = timeStellar.stellarTimeLocalDeg;
        double timeStellarNoon = timeStellar.stellarTimeNoonDeg;

        System.out.println("StellarTime: " + timeStellarLocalDeg);
        System.out.println("StellarTime: " + timeStellarNoon);

        // Sun position parameters
        SunPosition positionSun = new SunPosition(alfaSunDeg, deltaSunDeg, timeStellarLocalDeg, latitudeDeg);

        double currentSunElevationDeg = positionSun.currentElevationDeg;
        double sunAzimuthDeg = positionSun.currentAzimuthDeg;
        String sunAzimuthString = positionSun.currentAzimuthString;

        double maxSunElevationDeg = positionSun.maxElevationDeg;

        SolarPower powerSolar = new SolarPower(latitudeDeg, T, currentSunElevationDeg, maxSunElevationDeg);

        South south = new South(alfaSunDeg, timeStellarNoon);

        double timeSouth = south.timeSouth;
        System.out.println("Time south: " + timeSouth);

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
        System.out.println("Sun current Power [W/m2]: " + sunPowerNow);
        System.out.println("Sun Power max today [W/m2]: " + sunPowerDayMax);
        System.out.println("Sun Power max during the year [W/m2]: " + sunPowerYearMax);

        System.out.println("UVI now: " + sunUvi);
        System.out.println("UVI max today: " + sunUviMax);
        System.out.println("Sun max elevation today: " + maxSunElevationDeg);
        System.out.println("Sun current elevation: " + currentSunElevationDeg);
        System.out.println("Sun current azimuth: " + sunAzimuthDeg);
        System.out.println("Sun current azimuth: " + sunAzimuthString);

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
         */
    }

}
