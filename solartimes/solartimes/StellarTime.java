package solartimes;

public class StellarTime {

    public double stellarTimeNoonDeg;
    public double stellarTimeLocalDeg;

    public StellarTime(double T, double longitudeDeg) {

        MyDate date = new MyDate();
        double timeZone = date.timeZone; // in hours

        int hour = date.hour;
        int minute = date.minute;

        double hourDouble = Double.valueOf(hour);
        double minuteDouble = Double.valueOf(minute);

        double stellarTimeDeg = TrueDegree.minDegree((24110.54841 + 8640184.812866 * T + 0.093104 * (T * T) - 0.0000062 * (T * T * T)) / 3600. * 15.);

        double stellarTimeNoonDeg = TrueDegree.minDegree(stellarTimeDeg + 1.002737908 * (-timeZone) * 15. + longitudeDeg);
        this.stellarTimeNoonDeg = stellarTimeNoonDeg;

        this.stellarTimeLocalDeg = TrueDegree.minDegree(stellarTimeNoonDeg + (1.002737908 * (hourDouble + minuteDouble / 60.) * 15.));
    }
}
