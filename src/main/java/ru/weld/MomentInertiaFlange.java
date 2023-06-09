package ru.weld;

public class MomentInertiaFlange implements RoundUp {
    public double lengthOverFlange(double flangeWidth) {
        return flangeWidth - 1;
    }

    public double lengthBelowFlange(double flangeWidth, double wallThickness, double radius) {
        return 0.5 * (flangeWidth - wallThickness) - 1 - radius;
    }

    public double distanceCenterGravityOverX(double heightBeam, double sideF, double factor) {
        return 0.5 * (heightBeam + sideF * factor);
    }

    public double distanceCenterGravityBelowX(double heightBeam, double flangeThickness, double sideF, double factor) {
        return 0.5 * (heightBeam - sideF * factor) - flangeThickness;
    }

    public double distanceCenterGravityBelowY(double flangeWidth, double wallThickness, double radius) {
        return 0.5 * (flangeWidth - 1 - lengthBelowFlange(flangeWidth, wallThickness, radius));
    }

    public double momentInertiaOverFlangeX(double heightBeam, double flangeWidth, double sideF, double factor) {
        double d = distanceCenterGravityOverX(heightBeam, sideF, factor);
        double l = lengthOverFlange(flangeWidth);
        double h = sideF * factor;
        double ix = (l * Math.pow(h, 3)) / 12;
        double s = l * h;
        return 2 * (ix + Math.pow(d, 2) * s);
    }

    public double momentInertiaBelowFlangeX(double heightBeam, double flangeWidth, double flangeThickness,
                                            double wallThickness, double radius, double sideF, double factor) {
        double d = distanceCenterGravityBelowX(heightBeam, flangeThickness, sideF, factor);
        double l = lengthBelowFlange(flangeWidth, wallThickness, radius);
        double h = sideF * factor;
        double ix = (l * Math.pow(h, 3)) / 12;
        double s = l * h;
        return 4 * (ix + Math.pow(d, 2) * s);
    }

    public double momentInertiaOverFlangeY(double flangeWidth, double sideF, double factor) {
        double l = lengthOverFlange(flangeWidth);
        double h = sideF * factor;
        double iy = (h * Math.pow(l, 3)) / 12;
        return 2 * iy;
    }

    public double momentInertiaBelowFlangeY(double flangeWidth, double wallThickness,
                                            double radius, double sideF, double factor) {
        double d = distanceCenterGravityBelowY(flangeWidth, wallThickness, radius);
        double l = lengthBelowFlange(flangeWidth, wallThickness, radius);
        double h = sideF * factor;
        double s = l * h;
        double iy = (h * Math.pow(l, 3)) / 12;
        return 4 * (iy + Math.pow(d, 2) * s);
    }
}
