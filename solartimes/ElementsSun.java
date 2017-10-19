package solartimes;

public class ElementsSun {

    public double alfaSunDeg;
    public double deltaSunDeg;
    //public double epsilonRad;

    // Objecti rektaskensio, right ascension ja deklinaatio
    public ElementsSun(double T) {

        EpsilonEarth epsilon = new EpsilonEarth(T);
        double epsilonRad = epsilon.epsilonEarthRad;
        //this.epsilonRad = epsilon.epsilonEarthRad;

        double Lo = Math.toRadians(TrueDegree.minDegree((280.46646 + 36000.76983 * T + 0.0003032 * T * T)));
        //double L=TrueDegree.minDegree(100.46435+0.9856091*(julian-2451545));
        //double omega=TrueDegree.minDegree(102.94719+1198.28/3600d*T);
        double M = Math.toRadians(TrueDegree.minDegree((357.52911 + 35999.05029 * T - 0.0001537 * T * T)));
        double C = Math.toRadians((1.914602 - 0.004817 * T - 0.000014 * T * T) * Math.sin(M) + (0.019993 - 0.000101 * T) * Math.sin(2 * M) + 0.000289 * Math.sin(3 * M));

        double x = Math.cos(Lo + C);
        double y = Math.cos(epsilonRad) * Math.sin(Lo + C);

        this.alfaSunDeg = TrueDegree.trueTan(y, x);
        this.deltaSunDeg = Math.toDegrees(Math.asin(Math.sin(epsilonRad) * Math.sin(Lo + C)));

    }
}
