package solartimes;

public class South {

    public String timeSouthString;
    public double timeSouth;

    public South(double alfaDeg, double timeStellarNoonDeg) {

        /*korkeimmillaan, eli etelässä*/
        this.timeSouth = TrueDegree.minDegree(alfaDeg - timeStellarNoonDeg) * 24. / 360.;

        //TimeFormat timeSun = new TimeFormat(timeSouth);
        this.timeSouthString = (TimeFormat.hourTimeString) + ":" + (TimeFormat.minuteTimeString);
    }
}
