package solartimes;

public class South {

    public static String timeSouthString;
    public static double timeSouth;

    public South(double alfa) {

        double timeStellarNoon = StellarTimeDeg.stellarTimeNoon;
        /*korkeimmillaan, eli etelässä*/
        timeSouth = TrueDegree.minDegree(alfa - timeStellarNoon) * 24. / 360.;
        //TimeFormat timeSun = new TimeFormat(timeSouth);

        timeSouthString = (TimeFormat.hourTimeString) + ":" + (TimeFormat.minuteTimeString);
    }
}
