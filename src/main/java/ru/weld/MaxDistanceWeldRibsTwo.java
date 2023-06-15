package ru.weld;

public class MaxDistanceWeldRibsTwo {
    public double distanceWeldRibsTwoMaxX(double heightBeam, double sideRibTwo,
                                          double factor) {
        return 0.5 * heightBeam + sideRibTwo * factor;
    }

    public double distanceWeldRibsTwoMaxY(double flangeWidth, double lengthRibTwo) {
        return 0.5 * flangeWidth + lengthRibTwo - 0.5;
    }
}
