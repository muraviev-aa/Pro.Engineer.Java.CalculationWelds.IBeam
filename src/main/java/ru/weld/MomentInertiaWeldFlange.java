package ru.weld;

public class MomentInertiaWeldFlange implements RoundUp {
    public double lengthWeldOverFlange(double flangeWidth) {
        return flangeWidth - 1;
    }

    public double lengthWeldBelowFlange(double flangeWidth, double wallThickness, double radius) {
        return 0.5 * (flangeWidth - wallThickness) - 1 - radius;
    }

    public double distanceCenterGravityWeldOverX(double heightBeam, double sideF, double factor) {
        return 0.5 * (heightBeam + sideF * factor);
    }

    public double distanceCenterGravityWeldBelowX(double heightBeam, double flangeThickness, double sideF, double factor) {
        return 0.5 * (heightBeam - sideF * factor) - flangeThickness;
    }

    public double distanceCenterGravityWeldBelowY(double flangeWidth, double wallThickness, double radius) {
        return 0.5 * (flangeWidth - 1 - lengthWeldBelowFlange(flangeWidth, wallThickness, radius));
    }

    public double momentInertiaWeldOverFlangeX(double heightBeam, double flangeWidth, double sideF, double factor) {
        double d = distanceCenterGravityWeldOverX(heightBeam, sideF, factor);
        double l = lengthWeldOverFlange(flangeWidth);
        double h = sideF * factor;
        double ix = (l * Math.pow(h, 3)) / 12;
        double s = l * h;
        return 2 * (ix + Math.pow(d, 2) * s);
    }

    public double momentInertiaWeldBelowFlangeX(double heightBeam, double flangeWidth, double flangeThickness,
                                                double wallThickness, double radius, double sideF, double factor) {
        double d = distanceCenterGravityWeldBelowX(heightBeam, flangeThickness, sideF, factor);
        double l = lengthWeldBelowFlange(flangeWidth, wallThickness, radius);
        double h = sideF * factor;
        double ix = (l * Math.pow(h, 3)) / 12;
        double s = l * h;
        return 4 * (ix + Math.pow(d, 2) * s);
    }

    public double momentInertiaWeldOverFlangeY(double flangeWidth, double sideF, double factor) {
        double l = lengthWeldOverFlange(flangeWidth);
        double h = sideF * factor;
        double iy = (h * Math.pow(l, 3)) / 12;
        return 2 * iy;
    }

    public double momentInertiaWeldBelowFlangeY(double flangeWidth, double wallThickness,
                                                double radius, double sideF, double factor) {
        double d = distanceCenterGravityWeldBelowY(flangeWidth, wallThickness, radius);
        double l = lengthWeldBelowFlange(flangeWidth, wallThickness, radius);
        double h = sideF * factor;
        double s = l * h;
        double iy = (h * Math.pow(l, 3)) / 12;
        return 4 * (iy + Math.pow(d, 2) * s);
    }

    public double sumAreaWeldFlange(double flangeWidth, double wallThickness, double radius,
                                    double sideF, double factor) {
        double lo = lengthWeldOverFlange(flangeWidth);
        double lb = lengthWeldBelowFlange(flangeWidth, wallThickness, radius);
        double h = sideF * factor;
        return 2 * lo * h + 4 * lb * h;
    }
}
