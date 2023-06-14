package ru.weld;

public class MomentInertiaWeldRibsThree {
//    private double lengthRibThree;
//    private double bevelRibThree;
//    private double thicknessRibThree;
//    private double sideRibThree;
//    private double factor;
//    private double heightBeam;
//    private double wallThickness;

    public double lengthWeld(double lengthRibThree, double bevelRibThree) {
        return lengthRibThree - bevelRibThree - 1;
    }

    public double widthWeld(double sideRibThree, double factor) {
        return sideRibThree * factor;
    }

    public double distanceCenterGravityWeldX(double wallThickness, double lengthRibThree, double bevelRibThree) {
        double lw = lengthWeld(lengthRibThree, bevelRibThree);
        return 0.5 * (wallThickness + lw) + bevelRibThree + 0.5;
    }

    public double distanceCenterGravityWeldY(double thicknessRibThree, double sideRibThree, double factor) {
        return 0.5 * (thicknessRibThree + sideRibThree * factor);
    }

    public double momentInertiaWeldRibsThreeX(double thicknessRibThree, double lengthRibThree,
                                              double bevelRibThree, double sideRibThree, double factor) {
        double lw = lengthWeld(lengthRibThree, bevelRibThree);
        double w = widthWeld(sideRibThree, factor);
        double ix = (lw * Math.pow(w, 3)) / 12;
        double d = distanceCenterGravityWeldY(thicknessRibThree, sideRibThree, factor);
        double s = lw * sideRibThree * factor;
        return 4 * (ix + Math.pow(d, 2) * s);
    }

    public double momentInertiaWeldRibsThreeY(double wallThickness, double lengthRibThree, double bevelRibThree,
                                              double sideRibThree, double factor) {
        double lw = lengthWeld(lengthRibThree, bevelRibThree);
        double w = widthWeld(sideRibThree, factor);
        double iy = (w * Math.pow(lw, 3)) / 12;
        double d = distanceCenterGravityWeldX(wallThickness, lengthRibThree, bevelRibThree);
        double s = lw * sideRibThree * factor;
        return 4 * (iy + Math.pow(d, 2) * s);
    }

    public double sumAreaWeldRibsThree(double lengthRibThree, double bevelRibThree,
                                       double sideRibThree, double factor) {
        return 4 * lengthWeld(lengthRibThree, bevelRibThree) * widthWeld(sideRibThree, factor);
    }
}
