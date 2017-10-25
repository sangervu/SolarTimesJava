package solartimes;

import java.util.Scanner;

public class MainActivity {

    public static double latitudeDeg = Location.latitude;
    public static double longitudeDeg = Location.longitude;

    public static void main(String[] args) {

        MyDate myDate = new MyDate();
        int year = myDate.year;
        int month = myDate.month;
        int day = myDate.day;
        Julian julian = new Julian(year, month, day);
        double T = julian.noonT; // T at noon

        System.out.println("1: SunNow  2:SunToday  3:SunYesterday ");
        Scanner input = new Scanner(System.in);
        int valinta = input.nextInt();
        switch (valinta) {

            case 1:
                sunNow(T);
                break;
            case 2:
                sunToday(T);
                break;
            case 3:
                Julian julianYesterday = new Julian(year, month, day - 1);

                T = julianYesterday.noonT; // T at noon
                sunYesterday(T);
                break;

        }
    }

    public static void sunNow(double T) {

        // calculate sun elements
        ElementsSun elementsSun = new ElementsSun(T);
        double deltaSunDeg = elementsSun.deltaSunDeg;
        double alfaSunDeg = elementsSun.alfaSunDeg;

        StellarTime timeStellar = new StellarTime(T, longitudeDeg);

        double timeStellarLocalDeg = timeStellar.stellarTimeLocalDeg;
        double timeStellarNoon = timeStellar.stellarTimeNoonDeg;

        // Sun position parameters
        SunPosition positionSun = new SunPosition(alfaSunDeg, deltaSunDeg, timeStellarLocalDeg, latitudeDeg);

        double currentSunElevationDeg = positionSun.currentElevationDeg;
        double sunAzimuthDeg = positionSun.currentAzimuthDeg;
        String sunAzimuthString = positionSun.currentAzimuthString;

        double maxSunElevationDeg = positionSun.maxElevationDeg;

        SolarPower powerSolar = new SolarPower(latitudeDeg, T, currentSunElevationDeg, maxSunElevationDeg);

        South south = new South(alfaSunDeg, timeStellarNoon);
        double timeSouth = south.timeSouth;

        SolarCalculations calcSolar = new SolarCalculations(deltaSunDeg, latitudeDeg, currentSunElevationDeg, maxSunElevationDeg, timeSouth);

        double sunPowerNow = powerSolar.currentSunPower;

        double sunUvi = calcSolar.UvIndex;

        System.out.println("Sun current elevation: " + currentSunElevationDeg);
        System.out.println("Sun current azimuth: " + sunAzimuthDeg);
        System.out.println("Sun current azimuth: " + sunAzimuthString);
        System.out.println("Sun current Power [W/m2]: " + sunPowerNow);
        System.out.println("UVI now: " + sunUvi);

    }

    public static void sunToday(double T) {

        // calculate sun elements
        ElementsSun elementsSun = new ElementsSun(T);
        double deltaSunDeg = elementsSun.deltaSunDeg;
        double alfaSunDeg = elementsSun.alfaSunDeg;

        StellarTime timeStellar = new StellarTime(T, longitudeDeg);

        double timeStellarLocalDeg = timeStellar.stellarTimeLocalDeg;
        double timeStellarNoon = timeStellar.stellarTimeNoonDeg;

        // Sun position parameters
        SunPosition positionSun = new SunPosition(alfaSunDeg, deltaSunDeg, timeStellarLocalDeg, latitudeDeg);

        double currentSunElevationDeg = positionSun.currentElevationDeg;
        //double sunAzimuthDeg = positionSun.currentAzimuthDeg;
        //String sunAzimuthString = positionSun.currentAzimuthString;

        double maxSunElevationDeg = positionSun.maxElevationDeg;

        //SolarPower powerSolar = new SolarPower(latitudeDeg, T, currentSunElevationDeg, maxSunElevationDeg);
        South south = new South(alfaSunDeg, timeStellarNoon);
        Rize rize = new Rize(alfaSunDeg, deltaSunDeg, latitudeDeg, timeStellarNoon);
        Set set = new Set(alfaSunDeg, deltaSunDeg, latitudeDeg, timeStellarNoon);
        Up up = new Up(alfaSunDeg, deltaSunDeg, latitudeDeg, timeStellarNoon, currentSunElevationDeg);

        double timeSouth = south.timeSouth;
        //System.out.println("Time rize: " + rize.timeRize);
        System.out.println("Time rize: " + rize.timeRizeString);

        //System.out.println("Time south: " + south.timeSouth);
        System.out.println("Time south: " + south.timeSouthString);

        //System.out.println("Time set: " + set.timeSetHorizon);
        System.out.println("Time set: " + set.timeSetHorizonString);

        //System.out.println("Time up: " + up.timeUp);
        System.out.println("Time up: " + up.timeUpString);

        SolarCalculations calcSolar = new SolarCalculations(deltaSunDeg, latitudeDeg, currentSunElevationDeg, maxSunElevationDeg, timeSouth);

        double sunUviMax = calcSolar.UvIndexMax;

        System.out.println("UVI max today: " + sunUviMax);
        System.out.println("Sun max elevation today: " + maxSunElevationDeg);

    }

    public static void sunYesterday(double T) {
        // calculate sun elements
        ElementsSun elementsSun = new ElementsSun(T);
        double deltaSunDeg = elementsSun.deltaSunDeg;
        double alfaSunDeg = elementsSun.alfaSunDeg;

        StellarTime timeStellar = new StellarTime(T, longitudeDeg);

        double timeStellarLocalDeg = timeStellar.stellarTimeLocalDeg;
        double timeStellarNoon = timeStellar.stellarTimeNoonDeg;

        // Sun position parameters
        SunPosition positionSun = new SunPosition(alfaSunDeg, deltaSunDeg, timeStellarLocalDeg, latitudeDeg);

        double currentSunElevationDeg = positionSun.currentElevationDeg;
        //double sunAzimuthDeg = positionSun.currentAzimuthDeg;
        //String sunAzimuthString = positionSun.currentAzimuthString;

        double maxSunElevationDeg = positionSun.maxElevationDeg;

        //SolarPower powerSolar = new SolarPower(latitudeDeg, T, currentSunElevationDeg, maxSunElevationDeg);
        South south = new South(alfaSunDeg, timeStellarNoon);
        Rize rize = new Rize(alfaSunDeg, deltaSunDeg, latitudeDeg, timeStellarNoon);
        Set set = new Set(alfaSunDeg, deltaSunDeg, latitudeDeg, timeStellarNoon);
        Up up = new Up(alfaSunDeg, deltaSunDeg, latitudeDeg, timeStellarNoon, currentSunElevationDeg);

        double timeSouth = south.timeSouth;
        //System.out.println("Time rize: " + rize.timeRize);
        System.out.println("Time rize: " + rize.timeRizeString);

        //System.out.println("Time south: " + south.timeSouth);
        System.out.println("Time south: " + south.timeSouthString);

        //System.out.println("Time set: " + set.timeSetHorizon);
        System.out.println("Time set: " + set.timeSetHorizonString);

        //System.out.println("Time up: " + up.timeUp);
        System.out.println("Time up: " + up.timeUpString);

        SolarCalculations calcSolar = new SolarCalculations(deltaSunDeg, latitudeDeg, currentSunElevationDeg, maxSunElevationDeg, timeSouth);

        double sunUviMax = calcSolar.UvIndexMax;

        System.out.println("UVI max today: " + sunUviMax);
        System.out.println("Sun max elevation today: " + maxSunElevationDeg);

    }

}
