package solartimes;

public class Rize {

    public double timeRize;
    public String timeRizeString;

    public Rize(double alfa, double delta, double latitude, double timeStellarNoon) {

        double horizon = Math.toRadians(-0.83); // tarkista!!!
        //double visible = Math.toRadians(-5.); // tarkista!!!
        //double nocturnal = Math.toRadians(-10.); // tarkista!!!
        //double dark = Math.toRadians(-20.);  // tarkista!!!

        double latitudeRad = Math.toRadians(latitude);
        double deltaRad = Math.toRadians(delta);

        /*korkeimmillaan, eli etelässä*/
        double timeSouth = TrueDegree.minDegree(alfa - timeStellarNoon) * 24. / 360.;

        //nousu
        double timeRize = TrueDegree.minHour(timeSouth - Math.toDegrees(Math.acos(Math.sin(horizon) / (Math.cos(deltaRad) * Math.cos(latitudeRad)) - Math.tan(deltaRad) * Math.tan(latitudeRad))) * 24. / 360.);
        this.timeRize = timeRize;

        this.timeRizeString = (TimeFormat.timeHour(timeRize) + ":" + TimeFormat.timeMinute(timeRize));
    }
}
