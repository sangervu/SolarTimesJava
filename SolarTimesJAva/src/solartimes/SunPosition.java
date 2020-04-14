package solartimes;

public class SunPosition {

    public double currentElevationDeg;
    public double currentAzimuthDeg;
    public String currentAzimuthString;
    public double maxElevationDeg;
    public double Ax;
    public double Ay;

    public SunPosition(double alfaDeg, double deltaDeg, double timeStellarLocalDeg, double latitudeDeg) {

        this.maxElevationDeg = MathNew.roundDesimal_1(TrueDegree.trueElevation(90.0 + deltaDeg - latitudeDeg));
        double hourRad = Math.toRadians(timeStellarLocalDeg - alfaDeg);

        double deltaRad = Math.toRadians(deltaDeg);
        double latitudeRad = Math.toRadians(latitudeDeg);

        /*atsimuutti x ja y komponentit*/
        double Ay = Math.sin(hourRad) * Math.cos(deltaRad);
        double Ax = Math.cos(hourRad) * Math.cos(deltaRad) * Math.sin(latitudeRad) - Math.sin(deltaRad) * Math.cos(latitudeRad);

        double azimuth = MathNew.roundDesimal_1(TrueDegree.minDegree(TrueDegree.trueTan(Ay, Ax) + 180.));
        this.currentAzimuthDeg = azimuth;

        this.currentElevationDeg = MathNew.roundDesimal_1(Math.toDegrees(Math.asin(Math.sin(deltaRad) * Math.sin(latitudeRad) + Math.cos(hourRad) * Math.cos(deltaRad) * Math.cos(latitudeRad))));
        this.currentAzimuthString = TrueDegree.NorthSouthEastWest(azimuth);
        
        this.Ax = Ax;
        this.Ay = Ay;
    }
}
