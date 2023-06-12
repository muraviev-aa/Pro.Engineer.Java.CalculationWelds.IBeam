package ru.weld;

public class MaxDistanceWeldIBeam {
    public double distanceBeamMaxX(double heightBeam, double sideF, double factor) {
        return 0.5 * heightBeam + sideF * factor;
    }

    public double distanceBeamMaxY(double flangeWidth) {
        return 0.5 * (flangeWidth - 1);
    }
}
