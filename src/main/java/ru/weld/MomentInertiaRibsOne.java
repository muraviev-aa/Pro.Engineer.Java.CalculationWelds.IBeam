package ru.weld;

public class MomentInertiaRibsOne {
    private double lengthRibOne;
    private double bevelRibOne;
    private double thicknessRibOne;
    private double sideRibOne;
    private double factor;
    private double heightBeam;

    public double length(double lengthRibOne, double bevelRibOne) {
        return lengthRibOne - bevelRibOne - 1;
    }

    public double width(double sideRibOne, double factor) {
        return sideRibOne * factor;
    }

    public double distanceCenterGravityX(double heightBeam, double lengthRibOne, double bevelRibOne) {
        return 0.5 * (lengthRibOne - bevelRibOne) + bevelRibOne + 0.5 * heightBeam;
    }

    public double distanceCenterGravityY(double thicknessRibOne, double sideRibOne, double factor) {
        return 0.5 * (thicknessRibOne + sideRibOne * factor);
    }
}
