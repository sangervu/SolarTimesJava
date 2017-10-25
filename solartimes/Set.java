package solartimes;

public class Set {

    public String timeSetHorizonString;
    public String timeSetCivilString;
    public String timeSetNauticalString;
    public String timeSetAstronomicalString;

    public double timeSetHorizon;
    public double timeSetCivil;
    public double timeSetNautical;
    public double timeSetAstronomical;

    public Set(double alfa, double delta, double latitude, double timeStellarNoon) {

        double horizon = Math.toRadians(-0.83); // in degrees
        double visible = Math.toRadians(-6.); // Civil sunset in degrees
        double nocturnal = Math.toRadians(-12.); // Nautical sunset in degrees
        double night = Math.toRadians(-18.);  // Astronomical sunset in degrees

        double latitudeRad = Math.toRadians(latitude);
        double deltaRad = Math.toRadians(delta);

        //korkeimmillaan, eli etelässä
        double timeSouth = TrueDegree.minDegree(alfa - timeStellarNoon) * 24. / 360.;

        //Set time for horizon
        double timeSet = TrueDegree.minHour(timeSouth + Math.toDegrees(Math.acos(Math.sin(horizon) / (Math.cos(deltaRad) * Math.cos(latitudeRad)) - Math.tan(deltaRad) * Math.tan(latitudeRad))) * 24. / 360.);
        this.timeSetHorizon = timeSet;

        // time manipulation in Date format
        this.timeSetHorizonString = TimeFormat.timeHour(timeSet) + ":" + TimeFormat.timeMinute(timeSet);

        //Set time for visible lumination
        double timeSetCivil = TrueDegree.minHour(timeSouth + Math.toDegrees(Math.acos(Math.sin(visible) / (Math.cos(deltaRad) * Math.cos(latitudeRad)) - Math.tan(deltaRad) * Math.tan(latitudeRad))) * 24. / 360.);
        this.timeSetCivil = timeSetCivil;
        //TimeFormat timeCivil = new TimeFormat(timeSetCivil);
        //this.timeSetCivilString = (TimeFormat.hourTimeString) + ":" + (TimeFormat.minuteTimeString);

        //Set time for nocturnal lumination
        double timeSetNautical = TrueDegree.minHour(timeSouth + Math.toDegrees(Math.acos(Math.sin(nocturnal) / (Math.cos(deltaRad) * Math.cos(latitudeRad)) - Math.tan(deltaRad) * Math.tan(latitudeRad))) * 24. / 360.);
        this.timeSetNautical = timeSetNautical;
        //TimeFormat timeNautical = new TimeFormat(timeSetNautical);
        //this.timeSetNauticalString = (TimeFormat.hourTimeString) + ":" + (TimeFormat.minuteTimeString);

        //Set time for total darkness
        double timeSetAstronomical = TrueDegree.minHour(timeSouth + Math.toDegrees(Math.acos(Math.sin(night) / (Math.cos(deltaRad) * Math.cos(latitudeRad)) - Math.tan(deltaRad) * Math.tan(latitudeRad))) * 24. / 360.);
        this.timeSetAstronomical = timeSetAstronomical;
        //TimeFormat timeAstronomical = new TimeFormat(timeSetAstronomical);
        //this.timeSetAstronomicalString = (TimeFormat.hourTimeString) + ":" + (TimeFormat.minuteTimeString);

    }
}
