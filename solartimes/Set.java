package solartimes;

public class Set {

    public static String timeSetHorizonString, timeSetCivilString, timeSetNauticalString, timeSetAstronomicalString;
    public static double timeSet, timeSetCivil, timeSetNautical, timeSetAstronomical;

    public Set(double alfa, double delta, double latitude) {

        double horizon = Math.toRadians(-0.83); // in degrees
        double visible = Math.toRadians(-6.); // Civil sunset in degrees
        double nocturnal = Math.toRadians(-12.); // Nautical sunset in degrees
        double night = Math.toRadians(-18.);  // Astronomical sunset in degrees

        double latitudeRad = Math.toRadians(latitude);
        double deltaRad = Math.toRadians(delta);

        double timeStellarNoon = StellarTimeDeg.stellarTimeNoon;
        /*korkeimmillaan, eli etel�ss�*/
        double timeSouth = TrueDegree.minDegree(alfa - timeStellarNoon) * 24. / 360.;

        //Set time for horizon
        timeSet = TrueDegree.minHour(timeSouth + Math.toDegrees(Math.acos(Math.sin(horizon) / (Math.cos(deltaRad) * Math.cos(latitudeRad)) - Math.tan(deltaRad) * Math.tan(latitudeRad))) * 24. / 360.);

        TimeFormat timeSun = new TimeFormat(timeSet);
        // time manipulation in Date format
        timeSetHorizonString = (TimeFormat.hourTimeString) + ":" + (TimeFormat.minuteTimeString);

        //Set time for visible lumination
        timeSetCivil = TrueDegree.minHour(timeSouth + Math.toDegrees(Math.acos(Math.sin(visible) / (Math.cos(deltaRad) * Math.cos(latitudeRad)) - Math.tan(deltaRad) * Math.tan(latitudeRad))) * 24. / 360.);

        TimeFormat timeCivil = new TimeFormat(timeSetCivil);
        timeSetCivilString = (TimeFormat.hourTimeString) + ":" + (TimeFormat.minuteTimeString);

        //Set time for nocturnal lumination
        timeSetNautical = TrueDegree.minHour(timeSouth + Math.toDegrees(Math.acos(Math.sin(nocturnal) / (Math.cos(deltaRad) * Math.cos(latitudeRad)) - Math.tan(deltaRad) * Math.tan(latitudeRad))) * 24. / 360.);

        TimeFormat timeNautical = new TimeFormat(timeSetNautical);
        timeSetNauticalString = (TimeFormat.hourTimeString) + ":" + (TimeFormat.minuteTimeString);

        //Set time for total darkness
        timeSetAstronomical = TrueDegree.minHour(timeSouth + Math.toDegrees(Math.acos(Math.sin(night) / (Math.cos(deltaRad) * Math.cos(latitudeRad)) - Math.tan(deltaRad) * Math.tan(latitudeRad))) * 24. / 360.);

        TimeFormat timeAstronomical = new TimeFormat(timeSetAstronomical);

        timeSetAstronomicalString = (TimeFormat.hourTimeString) + ":" + (TimeFormat.minuteTimeString);

    }
}
