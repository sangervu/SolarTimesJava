package solartimes;

public class Julian {

    public double noonT;
    public double currentT;
    public double julian;

    public Julian(int year, int month, int day) {

        julian = 367 * year - (7 * (year + (month + 9) / 12)) / 4 - (3 * ((year + (month - 9) / 7) / 100 + 1)) / 4 + 275 * month / 9 + day + 1721029;

        noonT = (julian - 2451545.) * 0.000027378507871321;

    }

    public Julian(int year, int month, int day, int hour, int minute) {

        julian = 367 * year - (7 * (year + (month + 9) / 12)) / 4 - (3 * ((year + (month - 9) / 7) / 100 + 1)) / 4 + 275 * month / 9 + day + 1721029;

        currentT = (julian - 0.5 + hour / 24. + minute / 1440. - 2451545.) * 0.000027378507871321;
    }

}
