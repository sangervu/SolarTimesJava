package solartimes;

public class EpsilonEarth {

    public double epsilonEarthRad;
    public double epsilonEarthDeg;

    public EpsilonEarth(double T) {
        // epsilon Earth in radians

        double epsilonDeg = (23 + 26. / 60. + 21.448 / 3600 - 46.815 / 3600 * T - 0.00059 / 3600 * T * T + 0.001813 * T * T * T);
        double epsilonRad = Math.toRadians(epsilonDeg);

        this.epsilonEarthRad = epsilonRad;
        this.epsilonEarthDeg = epsilonDeg;
    }
}
