package solartimes;

public class Up {

    public double timeUp;
    public String timeUpString;

    public Up(double alfaDeg, double deltaDeg, double latitudeDeg, double timeStellarNoon, double elevation) {

        double horizon = Math.toRadians(-0.83); // tarkista!!!

        double latitudeRad = Math.toRadians(latitudeDeg);
        double deltaRad = Math.toRadians(deltaDeg);

        /*korkeimmillaan, eli etel�ss�*/
        double timeSouth = TrueDegree.minDegree(alfaDeg - timeStellarNoon) * 24. / 360.;

        //nousu
        double timeRize = TrueDegree.minHour(timeSouth - Math.toDegrees(Math.acos(Math.sin(horizon) / (Math.cos(deltaRad) * Math.cos(latitudeRad)) - Math.tan(deltaRad) * Math.tan(latitudeRad))) * 24. / 360.);

        //lasku
        double timeSet = TrueDegree.minHour(timeSouth + Math.toDegrees(Math.acos(Math.sin(horizon) / (Math.cos(deltaRad) * Math.cos(latitudeRad)) - Math.tan(deltaRad) * Math.tan(latitudeRad))) * 24. / 360.);

        if ((Double.isNaN(timeRize) || Double.isNaN(timeSet)) && elevation > 0) {
            this.timeUp = 24.;
        } else if ((Double.isNaN(timeRize) || Double.isNaN(timeSet)) && elevation < 0) {
            this.timeUp = 0.;
        } else {
            this.timeUp = TrueDegree.minHour(timeSet - timeRize);
        }

        this.timeUpString = TimeFormat.timeHour(timeUp) + ":" + TimeFormat.timeMinute(timeUp);
    }
}
