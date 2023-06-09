package ru.weld;

public class MomentInertiaFlange implements RoundUp {
    public double lengthAboveFlange(double flangeWidth) {
        return flangeWidth - 1;
    }

    public double lengthBelowFlange(double flangeWidth, double wallThickness, double radius) {
        return 0.5 * (flangeWidth - wallThickness) - 1 - radius;
    }

    public double distanceCenterGravityAboveX(double heightBeam, double side, double factor) {
        return 0.5 * (heightBeam + side * factor);
    }

    public double distanceCenterGravityBelowX(double heightBeam, double flangeThickness, double side, double factor) {
        return 0.5 * (heightBeam - side * factor) - flangeThickness;
    }

    public double distanceCenterGravityBelowY(double flangeWidth, double wallThickness, double radius) {
        return 0.5 * (flangeWidth - 1 - lengthBelowFlange(flangeWidth, wallThickness, radius));
    }

    public double momentInertiaAboveFlangeX(double heightBeam, double flangeWidth, double side, double factor) {
        double d = distanceCenterGravityAboveX(heightBeam, side, factor);
        double l = lengthAboveFlange(flangeWidth);
        double h = side * factor;
        double ix = (l * Math.pow(h, 3)) / 12;
        double s = l * h;
        return 2 * (ix + Math.pow(d, 2) * s);
    }

    public double momentInertiaBelowFlangeX(double heightBeam, double flangeWidth, double flangeThickness,
                                            double wallThickness, double radius, double side, double factor) {
        double d = distanceCenterGravityBelowX(heightBeam, flangeThickness, side, factor);
        double l = lengthBelowFlange(flangeWidth, wallThickness, radius);
        double h = side * factor;
        double ix = (l * Math.pow(h, 3)) / 12;
        double s = l * h;
        return 4 * (ix + Math.pow(d, 2) * s);
    }

    public double momentInertiaAboveFlangeY(double flangeWidth, double side, double factor) {
        double l = lengthAboveFlange(flangeWidth);
        double h = side * factor;
        double iy = (h * Math.pow(l, 3)) / 12;
        return 2 * iy;
    }

    public double momentInertiaBelowFlangeY(double flangeWidth, double wallThickness,
                                            double radius, double side, double factor) {
        double d = distanceCenterGravityBelowY(flangeWidth, wallThickness, radius);
        double l = lengthBelowFlange(flangeWidth, wallThickness, radius);
        double h = side * factor;
        double s = l * h;
        double iy = (h * Math.pow(l, 3)) / 12;
        return 4 * (iy + Math.pow(d, 2) * s);
    }
}
