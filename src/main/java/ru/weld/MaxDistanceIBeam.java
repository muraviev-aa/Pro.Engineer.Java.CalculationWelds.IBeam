package ru.weld;

public class MaxDistanceIBeam {
    public double distanceMaxX(double heightBeam, double sideF, double factor) {
        return 0.5 * heightBeam + sideF * factor;
    }

    public double distanceMaxY(double flangeWidth) {
        return 0.5 * (flangeWidth - 1);
    }
}
