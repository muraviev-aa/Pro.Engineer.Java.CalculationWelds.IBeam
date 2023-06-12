package ru.weld;

public class MomentResistanceWeldWall implements RoundUp {
    public double momentResistanceWallX(double momentInertiaWallX, double heightWeldX) {
        double wx = momentInertiaWallX / (0.5 * heightWeldX);
        return roundTwo(wx);
    }

    public double momentResistanceWallY(double momentInertiaWallY, double heightWeldY, double wallThickness) {
        double wy = momentInertiaWallY / (heightWeldY + 0.5 * wallThickness);
        return roundTwo(wy);
    }
}
