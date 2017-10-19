package solartimes;

public class SunPosition {

    public double currentElevationDeg;
    public double currentAzimuthDeg;
    public String currentAzimuthString;
    public double maxElevationDeg;

    public SunPosition(double alfaDeg, double deltaDeg, double timeStellarLocalDeg, double latitudeDeg) {

        this.maxElevationDeg = TrueDegree.trueElevation(90.0 + deltaDeg - latitudeDeg);

        double hourRad = Math.toRadians(timeStellarLocalDeg - alfaDeg);

        double deltaRad = Math.toRadians(deltaDeg);
        double latitudeRad = Math.toRadians(latitudeDeg);

        /*atsimuutti x ja y komponentit*/
        double y = Math.sin(hourRad) * Math.cos(deltaRad);
        double x = Math.cos(hourRad) * Math.cos(deltaRad) * Math.sin(latitudeRad) - Math.sin(deltaRad) * Math.cos(latitudeRad);

        double azimuth = TrueDegree.minDegree(TrueDegree.trueTan(y, x) + 180);
        this.currentAzimuthDeg = azimuth;

        this.currentElevationDeg = Math.toDegrees(Math.asin(Math.sin(deltaRad) * Math.sin(latitudeRad) + Math.cos(hourRad) * Math.cos(deltaRad) * Math.cos(latitudeRad)));
        this.currentAzimuthString = TrueDegree.NorthSouthEastWest(azimuth);
    }
}
