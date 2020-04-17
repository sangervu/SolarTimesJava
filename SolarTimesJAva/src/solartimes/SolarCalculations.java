package solartimes;

public class SolarCalculations {

    public double thermalActivity;
    public double thermalActivityStrong;
    public double thermalActivityEnd;
    public String thermalActivityEndString;
    public double UvIndex;
    public double m; 
    public double UvIndexMax;
    public double UvIndexOverThree;
    public double UvIndexEnd;
    public String UvIndexEndString;

    public SolarCalculations(double deltaSunDeg, double latitudeDeg, double currentSunElevationDeg, double maxSunAltitudeDiurnalDeg, double timeSouth) {

        double weakThermalLimitRad = Math.toRadians(17.5); //degrees in Sun elevation, empirical
        double strongThermalLimitRad = Math.toRadians(35.0); //degrees in Sun elevation, empirical
        //double uvOverTwoLimitRad = Math.toRadians(90.0 - 55.0); //degrees in Sun elevation, UV
        double uvOverThreeLimitRad = Math.toRadians(90.0 - 48.0); //degrees in Sun elevation, UV

        double latitudeRad = Math.toRadians(latitudeDeg);
        double currentSunElevationRad = Math.toRadians(currentSunElevationDeg);
        
        double deltaSunRad = Math.toRadians(deltaSunDeg);

        this.thermalActivity = 2 * Math.acos(-Math.tan(deltaSunRad) * Math.tan(latitudeRad) + Math.sin(weakThermalLimitRad) / (Math.cos(deltaSunRad) * Math.cos(latitudeRad))) / (2 * Math.PI) * 24;
        if (Double.isNaN(thermalActivity)) {
            this.thermalActivity = 0.;
        }

        this.thermalActivityStrong = 2 * Math.acos(-Math.tan(deltaSunRad) * Math.tan(latitudeRad) + Math.sin(strongThermalLimitRad) / (Math.cos(deltaSunRad) * Math.cos(latitudeRad))) / (2 * Math.PI) * 24;
        if (Double.isNaN(thermalActivityStrong)) {
            thermalActivityStrong = 0.;
        }

        if (Double.isNaN(thermalActivity) || thermalActivity == 0) {
            this.thermalActivityEnd = 0.;
        } else {
            this.thermalActivityEnd = timeSouth + thermalActivity / 2;
        }

        //TimeFormat timeThermal = new TimeFormat(thermalActivityEnd);
        //this.thermalActivityEndString = (TimeFormat.hourTimeString) + ":" + (TimeFormat.minuteTimeString);

        double a = 2.696056, b = 5.474571, c = -0.09888, d = 0.040392;
        double m = 1. / Math.cos(Math.asin(6371. / 6393. * Math.sin((Math.PI / 2 - currentSunElevationRad))));
        this.m = m;

        double uvIndex = MathNew.roundDesimal_1(MathNew.pow(Math.cos(Math.PI / 2 - currentSunElevationRad), a) * MathNew.exp(b + c * m + d * m * m) / 25.);

        if (Double.isNaN(uvIndex)) {
            this.UvIndex = 0.;
        }
        else {
        
        this.UvIndex = uvIndex;
        }

        double maxSunAltitudeDiurnalRad = Math.toRadians(maxSunAltitudeDiurnalDeg);
        
        double mMax = 1. / Math.cos(Math.asin(6371. / 6393. * Math.sin((Math.PI / 2 - maxSunAltitudeDiurnalRad))));

        this.UvIndexMax = MathNew.roundDesimal_1(MathNew.pow(Math.cos(Math.PI / 2 - maxSunAltitudeDiurnalRad), a) * MathNew.exp(b + c * mMax + d * mMax * mMax) / 25.);

        double uvIndexOverThree = 2 * Math.acos(-Math.tan(deltaSunRad) * Math.tan(latitudeRad) + Math.sin(uvOverThreeLimitRad) / (Math.cos(deltaSunRad) * Math.cos(latitudeRad))) / (2 * Math.PI) * 24;

        if (Double.isNaN(uvIndexOverThree)) {
            this.UvIndexOverThree = 0.;
        }

        if (Double.isNaN(uvIndex) || uvIndexOverThree == 0) {
            this.UvIndexEnd = 0.;
        } else {
            this.UvIndexEnd = timeSouth + uvIndexOverThree / 2;
        }

        //TimeFormat timeUvi = new TimeFormat(uvIndexEnd);
        //this.UvIndexEndString = (TimeFormat.hourTimeString) + ":" + (TimeFormat.minuteTimeString);

    }

}
