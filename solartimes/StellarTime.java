package solartimes;

public class StellarTime {

    public double stellarTimeNoonDeg;
    public double stellarTimeLocalDeg;

    public StellarTime(double T, double longitudeDeg) {

        MyDate date = new MyDate();
        double timeZone = date.timeZone; // in hours
        double dst = date.dst; // in hours

        //System.out.println("TZ: " + timeZone);
        //System.out.println("DST: " + dst);

        double hour = (double) date.hour;
        double minute = (double) date.minute;

        double stellarTimeDeg = TrueDegree.minDegree((24110.54841 + 8640184.812866 * T + 0.093104 * (T * T) - 0.0000062 * (T * T * T)) / 3600. * 15.);

        double stellarTimeNoonDeg = TrueDegree.minDegree(stellarTimeDeg + 1.002737908 * (-timeZone - dst) * 15. + longitudeDeg);

        this.stellarTimeNoonDeg = stellarTimeNoonDeg;

        this.stellarTimeLocalDeg = TrueDegree.minDegree(stellarTimeNoonDeg + (1.002737908 * (hour + minute / 60.) * 15.));

    }
}
