package ru.weld;

public class MomentInertiaWall implements RoundUp {
//    private double heightBeam;
//    private double wallThickness;
//    private double flangeThickness;
//    private double radius;
//    private double side;
//    private boolean flag;
//    private double factor;

    public double length(double heightBeam, double flangeThickness, double radius) {
        return heightBeam - 2 * flangeThickness - 2 * radius - 1;
    }

    public double width(double sideW, double factor) {
        return sideW * factor;
    }

    public double distanceCenterGravityY(double wallThickness, double sideW, double factor) {
        return 0.5 * (wallThickness + (sideW * factor));
    }

    public double heightWeldX(double heightBeam, double flangeThickness, double radius) {
        return length(heightBeam, flangeThickness, radius);
    }

    public double widthWeldX(double sideW, double factor) {
        return width(sideW, factor);
    }

    public double heightWeldY(double sideW, double factor) {
        return width(sideW, factor);
    }

    public double widthWeldY(double heightBeam, double flangeThickness, double radius) {
        return length(heightBeam, flangeThickness, radius);
    }

    public double momentInertiaWallX(double heightBeam, double flangeThickness, double sideW,
                                     double factor, double radius) {
        double x = widthWeldX(sideW, factor);
        double y = heightWeldX(heightBeam, flangeThickness, radius);
        double ix = (x * Math.pow(y, 3)) / 12;
        return 2 * roundTwo(ix);
    }

    public double momentInertiaWallY(double heightBeam, double flangeThickness, double sideW, double factor,
                                     double radius, double wallThickness) {
        double x = widthWeldY(heightBeam, flangeThickness, radius);
        double y = heightWeldY(sideW, factor);
        double d = distanceCenterGravityY(wallThickness, sideW, factor);
        double a = heightWeldY(sideW, factor) * widthWeldY(heightBeam, flangeThickness, radius);
        double iy = ((x * Math.pow(y, 3)) / 12) + (Math.pow(d, 2) * a);
        return 2 * roundTwo(iy);
    }
}
