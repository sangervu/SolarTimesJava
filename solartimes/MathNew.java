package solartimes;

public class MathNew {

    /*public static double arcTan(double x) {
        double a = 1. / Math.sqrt(1 + x * x);
        double b = 1.0;
        a = 0.5 * (a + b);
        b = Math.sqrt(a * b);
        while (b - a > 1e-13) {
            a = 0.5 * (a + b);
            b = Math.sqrt(a * b);
        }
        x = x / (Math.sqrt(1 + x * x) * b);
        return x;
    }*/

    /*public static double arcSin(double x) {
        if (x == 1) {
            x = Math.PI / 2;
        } else if (x == -1) {
            x = -Math.PI / 2;
        } else {
            x = x / (Math.sqrt(1 - x * x));
            x = arcTan(x);
        }
        return x;
    } */

   /* public static double arcCos(double x) {
        if (x == -1) {
            x = Math.PI;
            return x;
        }
        x = Math.sqrt(1 - x * x) / x;
        x = arcTan(x);
        if (x < 0) {
            x = x + Math.PI;
        }
        return x;
    }*/

    static public double pow(double x, double y) {
        if (x == 0.) {
            return 0.;
        }
        if (x == 1.) {
            return 1.;
        }
        if (y == 0.) {
            return 1.;
        }
        if (y == 1.) {
            return x;
        }
        //
        long l = (long) Math.floor(y);
        boolean integerValue = (y == (double) l);
        //
        if (integerValue) {
            boolean neg = false;
            if (y < 0.) {
                neg = true;
            }
            //
            double result = x;
            for (long i = 1; i < (neg ? -l : l); i++) {
                result = result * x;
            }
            //
            if (neg) {
                return 1. / result;
            } else {
                return result;
            }
        } else {
            if (x > 0.) {
                return exp(y * log(x));
            } else {
                return Double.NaN;
            }
        }
    }

    static public double exp(double x) {
        if (x == 0.) {
            return 1.;
        }
        //
        double f = 1;
        long d = 1;
        double k;
        boolean isless = (x < 0.);
        if (isless) {
            x = -x;
        }
        k = x / d;
        //
        for (long i = 2; i < 50; i++) {
            f = f + k;
            k = k * x / i;
        }
        //
        if (isless) {
            return 1 / f;
        } else {
            return f;
        }
    }

    static public double log(double x) {
        if (!(x > 0.)) {
            return Double.NaN;
        }
        //
        boolean neg = false;
        double log2 = _log(0.5);
        if (x < 0) {
            neg = true;
            x = -x;
        }
        int index = 0;
        while (x > 1.) {
            x = x / 2.;
            index++;
        }
        double res = _log(x);
        for (int i = 0; i < index; i++) {
            res = res - log2;
        }
        if (neg) {
            return 1 / res;
        } else {
            return res;
        }
    }

    static private double _log(double x) {
        if (!(x > 0.)) {
            return Double.NaN;
        }
        //
        double f = 0.0;
        //
        double y1 = x - 1.;
        double y2 = x + 1.;
        double y = y1 / y2;
        //
        double k = y;
        y2 = k * y;
        //
        for (long i = 1; i < 50; i += 2) {
            f += k / i;
            k *= y2;
        }
        return f * 2.;
    }

    public static double roundInteger(double x) {
        double original = x;

        if (x > 0) {

            while (x >= 1) {
                x = x - 1;
            }
            if (x < 0.5) {
                x = original - x;
            } else {
                x = original - x + 1;
            }
        } else {
            while (x <= -1) {
                x = x + 1;
            }
            if (x < -0.5) {
                x = original - x - 1;
            } else {
                x = original - x;
            }
        }
        return x;
    }

    public static double integer(double x) {
        double original = x;

        if (x > 0) {
            while (x >= 1) {
                x = x - 1;
            }
        } else {
            while (x <= -1) {
                x = x + 1;
            }
        }
        return original - x;
    }

    public static double roundDesimal_1(double x) {
        x = x * 10;
        x = integer(x);
        x = x / 10;
        return x;
    }
}
