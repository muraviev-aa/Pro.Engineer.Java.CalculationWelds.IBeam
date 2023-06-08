package ru.weld;

public class MomentResistanceWall implements RoundUp {
    public double momentResistanceWallX(double momentInertiaWallX, double heightWeldX) {
        double wx = momentInertiaWallX / (0.5 * heightWeldX);
        return roundTwo(wx);
    }

    public double momentResistanceWallY(double momentInertiaWallY, double heightWeldY, double wallThickness) {
        double wy = momentInertiaWallY / (heightWeldY + 0.5 * wallThickness);
        return roundTwo(wy);
    }

    public static void main(String[] args) {
        MomentResistanceWall momentResistanceWall = new MomentResistanceWall();
        System.out.println(momentResistanceWall.momentResistanceWallX(1164.36, 19.8));
        System.out.println(momentResistanceWall.momentResistanceWallY(19.87, 0.9, 0.5));
    }
}
