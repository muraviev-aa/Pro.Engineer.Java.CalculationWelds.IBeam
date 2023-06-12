package ru.weld;

public class MomentInertiaWeldRibsOne {
    private double lengthRibOne;
    private double bevelRibOne;
    private double thicknessRibOne;
    private double sideRibOne;
    private double factor;
    private double heightBeam;

    public double lengthWeld(double lengthRibOne, double bevelRibOne) {
        return lengthRibOne - bevelRibOne - 1;
    }

    public double widthWeld(double sideRibOne, double factor) {
        return sideRibOne * factor;
    }

    public double distanceCenterGravityWeldX(double heightBeam, double lengthRibOne, double bevelRibOne) {
        return 0.5 * (lengthRibOne - bevelRibOne) + bevelRibOne + 0.5 * heightBeam;
    }

    public double distanceCenterGravityWeldY(double thicknessRibOne, double sideRibOne, double factor) {
        return 0.5 * (thicknessRibOne + sideRibOne * factor);
    }

    public double momentInertiaWeldRibsOneX(double heightBeam, double lengthRibOne, double factor,
                                            double bevelRibOne, double sideRibOne) {
        double w = widthWeld(sideRibOne, factor);
        double l = lengthWeld(lengthRibOne, bevelRibOne);
        double ix = (w * Math.pow(l, 3)) / 12;
        double d = distanceCenterGravityWeldX(heightBeam, lengthRibOne, bevelRibOne);
        double s = l * w;
        return 4 * (ix + Math.pow(d, 2) * s);
    }

    public double momentInertiaWeldRibsOneY(double thicknessRibOne, double lengthRibOne, double bevelRibOne,
                                            double sideRibOne, double factor) {
        double l = lengthWeld(lengthRibOne, bevelRibOne);
        double w = widthWeld(sideRibOne, factor);
        double iy = (l * Math.pow(w, 3)) / 12;
        double d = distanceCenterGravityWeldY(thicknessRibOne, sideRibOne, factor);
        double s = l * w;
        return 4 * (iy + Math.pow(d, 2) * s);
    }
}
