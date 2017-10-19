package solartimes;

public class TrueDegree {

 /* (0-360 deg) Metodi*/
  public static double minDegree(double degree) {
            while (degree >= 360.)
              degree = degree - 360.;
              while (degree < 0.)
                degree = degree + 360.;
              return degree;
          }

 /* (0-24 h) Metodi*/
  public static double minHour(double hour) {
                      while (hour >=24)
                        hour = hour - 24;
                        while (hour < 0)
                          hour = hour + 24;
                        return hour;
                      }

/* (-90 to 90) degrees Metodi*/
public static double trueElevation(double degree) {
           while (degree > 90)
           degree = 180-degree;
            while (degree < -90)
             degree = 180+degree;
             return degree;
         }

/* True tangent Metodi*/
 public static double trueTan(double y, double x){
             double alfa=y/x;
               alfa=Math.toDegrees(Math.atan(alfa));
               if (y >= 0 & x > 0)
                 alfa=y/x;
               else if (y >= 0 & x < 0)
                 alfa=alfa+ 180;
               else if (y < 0 & x > 0)
                 alfa=alfa + 360;
               else if (y < 0 & x < 0)
                 alfa=alfa + 180;
               return alfa;
          }

  // Metodi deg => ESNW
  public static String NorthSouthEastWest(double atsimuutti){

               String suunta = " ";
               if ( (atsimuutti >= (180. - 11.25)) && (atsimuutti < (180. + 11.25))) {
                 suunta = suunta + "S";
               }
               else if ( (atsimuutti >= (157.5 - 11.25)) && (atsimuutti < (157.5 + 11.25))) {
                 suunta = suunta + "SSE";
               }
               else if ( (atsimuutti >= (135 - 11.25)) && (atsimuutti < (135 + 11.25))) {
                 suunta = suunta + "SE";
               }
               else if ( (atsimuutti >= (112.5 - 11.25)) && (atsimuutti < (112.5 + 11.25))) {
                 suunta = suunta + "ESE";
               }
               else if ( (atsimuutti >= (90 - 11.25)) && (atsimuutti < (90 + 11.25))) {
                 suunta = suunta + "E";
               }
               else if ( (atsimuutti >= (67.5 - 11.25)) && (atsimuutti < (67.5 + 11.25))) {
                 suunta = suunta + "ENE";
               }
               else if ( (atsimuutti >= (45 - 11.25)) && (atsimuutti < (45 + 11.25))) {
                 suunta = suunta + "NE";
               }
               else if ( (atsimuutti >= (22.5 - 11.25)) && (atsimuutti < (22.5 + 11.25))) {
                 suunta = suunta + "NNE";
               }
               else if ( (atsimuutti >= (360 - 11.25)) || (atsimuutti < 11.25)) {
                 suunta = suunta + "N";
               }
               else if ( (atsimuutti >= (337.5 - 11.25)) && (atsimuutti < (337.5 + 11.25))) {
                 suunta = suunta + "NNW";
               }
               else if ( (atsimuutti >= (315 - 11.25)) && (atsimuutti < (315 + 11.25))) {
                 suunta = suunta + "NW";
               }
               else if ( (atsimuutti >= (292.5 - 11.25)) && (atsimuutti < (292.5 + 11.25))) {
                 suunta = suunta + "WNW";
               }
               else if ( (atsimuutti >= (270 - 11.25)) && (atsimuutti < (270 + 11.25))) {
                 suunta = suunta + "W";
               }
               else if ( (atsimuutti >= (247.5 - 11.25)) && (atsimuutti < (247.5 + 11.25))) {
                 suunta = suunta + "WSW";
               }
               else if ( (atsimuutti >= (225 - 11.25)) && (atsimuutti < (225 + 11.25))) {
                 suunta = suunta + "SW";
               }
               else if ( (atsimuutti >= (202.5 - 11.25)) && (atsimuutti < (202.5 + 11.25))) {
                 suunta = suunta + "SSW";
               }
               return suunta;
             }
         }
