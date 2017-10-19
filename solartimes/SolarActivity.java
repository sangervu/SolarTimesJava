package solartimes;

public class SolarActivity {

    public double maxSunPowerAnnual;
    public double maxSunPowerDiurnal;
    public double currentSunPower;

    public SolarActivity(double latitudeDeg, double T, double deltaSunDeg, double alfaSunDeg, double currentSunAltitudeRad, double maxElevationDeg) {

        double sunPower;
        //double latitudeRad = Math.toRadians(latitudeDeg);
        //double deltaSunRad = Math.toRadians(latitudeDeg);

        // calculate max elevation of the sun in degrees
        double elevationMax;
        if (latitudeDeg < 23.5 & latitudeDeg > -23.5) {
            elevationMax = 90.;
        } else if (latitudeDeg > 23.5) {
            elevationMax = 90 - latitudeDeg + 23.5;
        } else {
            elevationMax = 90 + latitudeDeg + 23.5;
        }

        double maxSunAltitudeAnnualRad = Math.toRadians(elevationMax); //max Sun elevation in Rad

        double maxSunAltitudeDiurnalRad = Math.toRadians(maxElevationDeg);

        double maxSunPowerAnnual = 1350.0 * Math.sin(maxSunAltitudeAnnualRad) * MathNew.pow(0.78, (1 / Math.sin(maxSunAltitudeAnnualRad)));

        // Maximun diurnal solar power
        sunPower = 1350.0 * Math.sin(maxSunAltitudeDiurnalRad) * MathNew.pow(0.78, (1 / Math.sin(maxSunAltitudeDiurnalRad)));
        if (sunPower < 0) {
            this.maxSunPowerDiurnal = 0;
        } else {
            this.maxSunPowerDiurnal = sunPower;
        }

        // Current solar power
        sunPower = 1350.0 * Math.sin(currentSunAltitudeRad) * MathNew.pow(0.78, (1 / Math.sin(currentSunAltitudeRad)));
        if (sunPower < 0) {
            this.currentSunPower = 0;
        } else {
            this.currentSunPower = sunPower;
        }

    }
}
