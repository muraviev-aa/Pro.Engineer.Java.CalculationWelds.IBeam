package ru.weld;

public class MaxDistanceWeldRibsThree {
    public double distanceWeldRibsThreeMaxX(double thicknessRibThree, double sideRibThree, double factor) {
        return 0.5 * thicknessRibThree + sideRibThree * factor;
    }

    public double distanceWeldRibsThreeMaxY(double wallThickness, double lengthRibThree) {
        return 0.5 * wallThickness + lengthRibThree - 0.5;
    }
}
