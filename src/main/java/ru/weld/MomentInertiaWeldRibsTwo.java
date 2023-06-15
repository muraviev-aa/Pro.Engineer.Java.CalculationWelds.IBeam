package ru.weld;

public class MomentInertiaWeldRibsTwo {
//    private double lengthRibTwo;
//    private double bevelRibTwo;
//    private double thicknessRibTwo;
//    private double sideRibTwo;
//    private double factor;
//    private double heightBeam;

    public double lengthWeld(double lengthRibTwo) {
        return lengthRibTwo - 1;
    }

    public double widthWeld(double sideRibTwo, double factor) {
        return sideRibTwo * factor;
    }

    public double distanceCenterGravityWeldOverBelowX(double flangeWidth, double lengthRibTwo) {
        return 0.5 * (flangeWidth + lengthRibTwo);
    }

    public double distanceCenterGravityWeldOverY(double heightBeam, double sideRibTwo, double factor) {
        return 0.5 * (heightBeam + sideRibTwo * factor);
    }

    public double distanceCenterGravityWeldBelowY(double heightBeam, double thicknessRibTwo,
                                                  double sideRibTwo, double factor) {
        return 0.5 * heightBeam - thicknessRibTwo - 0.5 * sideRibTwo * factor;
    }

    public double momentInertiaWeldRibsTwoX(double heightBeam, double lengthRibTwo, double thicknessRibTwo,
                                            double sideRibTwo, double factor) {
        double l = lengthWeld(lengthRibTwo);
        double w = widthWeld(sideRibTwo, factor);
        double dOver = distanceCenterGravityWeldOverY(heightBeam, sideRibTwo, factor);
        double dBelow = distanceCenterGravityWeldBelowY(heightBeam, thicknessRibTwo, sideRibTwo, factor);
        double s = l * sideRibTwo * factor;
        double iOverX = ((l * Math.pow(w, 3)) / 12) + Math.pow(dOver, 2) * s;
        double iBelowX = ((l * Math.pow(w, 3)) / 12) + Math.pow(dBelow, 2) * s;
        return 4 * (iOverX + iBelowX);
    }

    public double momentInertiaWeldRibsTwoY(double flangeWidth, double lengthRibTwo, double sideRibTwo,
                                            double factor) {
        double l = lengthWeld(lengthRibTwo);
        double w = widthWeld(sideRibTwo, factor);
        double d = distanceCenterGravityWeldOverBelowX(flangeWidth, lengthRibTwo);
        double s = l * sideRibTwo * factor;
        double iy = ((w * Math.pow(l, 3)) / 12) + Math.pow(d, 2) * s;
        return 8 * iy;
    }

    public double sumAreaWeldRibsOne(double lengthRibTwo, double sideRibTwo, double factor) {
        return 8 * lengthWeld(lengthRibTwo) * widthWeld(sideRibTwo, factor);
    }
}
