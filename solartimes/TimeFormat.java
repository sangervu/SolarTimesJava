package solartimes;

public class TimeFormat {
  
  public static String hourTimeString, minuteTimeString;

  public TimeFormat(double timeValue) {

    // hour value
    Double intHour = new Double(timeValue);
    int hourTime = intHour.intValue();
    hourTimeString = String.valueOf(hourTime);

    Integer intHourDouble=new Integer(hourTime);
    double hourTimeDouble=intHourDouble.doubleValue();

    // minute value
    Double intMinute = new Double(((timeValue-hourTimeDouble)*60.));
    int minuteTime = intMinute.intValue();
    
    if (minuteTime<10)
    	
    	minuteTimeString = "0" + String.valueOf(minuteTime);
    
    else
    	
    	minuteTimeString = String.valueOf(minuteTime);	

  }
}
