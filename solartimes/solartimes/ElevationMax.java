package solartimes;

public class ElevationMax {

    public double maxElevationDeg;

    public ElevationMax(double deltaDeg, double latitudeDeg) {

        this.maxElevationDeg = TrueDegree.trueElevation(90.0 + deltaDeg - latitudeDeg);
    }
}
