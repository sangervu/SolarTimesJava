package solartimes;

public class South {

    public String timeSouthString;
    public double timeSouth;

    public South(double alfaDeg, double timeStellarNoonDeg) {

        /*korkeimmillaan, eli etelässä*/
        
        double timeSouth = TrueDegree.minDegree(alfaDeg - timeStellarNoonDeg) * 24. / 360.;

        this.timeSouth = timeSouth;
        
        this.timeSouthString = (TimeFormat.timeHour(timeSouth) + ":" + TimeFormat.timeMinute(timeSouth));
    }
}
