package solartimes;

public class Rize {

    public static double timeRize;
    public static String timeRizeString;

    //private static int HOUR_OF_DAY;
    //private static int MINUTE;
    public Rize(double alfa, double delta, double latitude) {

        double horizon = Math.toRadians(-0.83); // tarkista!!!
        //double visible = Math.toRadians(-5.); // tarkista!!!
        //double nocturnal = Math.toRadians(-10.); // tarkista!!!
        //double dark = Math.toRadians(-20.);  // tarkista!!!

         double latitudeRad = Math.toRadians(latitude);
        double deltaRad = Math.toRadians(delta);

        double timeStellarNoon = StellarTimeDeg.stellarTimeNoon;
        /*korkeimmillaan, eli etelässä*/
        double timeSouth = TrueDegree.minDegree(alfa - timeStellarNoon) * 24. / 360.;

        //nousu
        timeRize = TrueDegree.minHour(timeSouth - Math.toDegrees(Math.acos(Math.sin(horizon) / (Math.cos(deltaRad) * Math.cos(latitudeRad)) - Math.tan(deltaRad) * Math.tan(latitudeRad))) * 24. / 360.);

        //TimeFormat rize = new TimeFormat(timeRize);
        // time manipulation in Date format
        timeRizeString = (TimeFormat.hourTimeString) + ":" + (TimeFormat.minuteTimeString);
    }
}
