package solartimes;

public class LocalHorizontal {

    public double elevationDeg;
    public double suuntaDeg;
    public String suuntaString;

    public LocalHorizontal(double alfaDeg, double deltaDeg, double timeStellarLocalDeg, double latitudeDeg) {

        double hourRad = Math.toRadians(timeStellarLocalDeg - alfaDeg);

        double deltaRad = Math.toRadians(deltaDeg);
        double latitudeRad = Math.toRadians(latitudeDeg);

        /*atsimuutti x ja y komponentit*/
        double y = Math.sin(hourRad) * Math.cos(deltaRad);
        double x = Math.cos(hourRad) * Math.cos(deltaRad) * Math.sin(latitudeRad) - Math.sin(deltaRad) * Math.cos(latitudeRad);

        double azimuth = TrueDegree.minDegree(TrueDegree.trueTan(y, x) + 180d);
        this.suuntaDeg = azimuth;

        this.elevationDeg = Math.toDegrees(Math.asin(Math.sin(deltaRad) * Math.sin(latitudeRad) + Math.cos(hourRad) * Math.cos(deltaRad) * Math.cos(latitudeRad)));
        this.suuntaString = TrueDegree.NorthSouthEastWest(azimuth);
    }
}
