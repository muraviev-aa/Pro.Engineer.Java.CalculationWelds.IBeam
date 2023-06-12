package ru.weld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MomentResistanceWallTest {
    @Test
    void when25B1WxWallThen130Point68() {
        double momentInertiaWallX = 1293.73;
        double heightWeldX = 19.8;
        MomentResistanceWeldWall momentResistanceWall = new MomentResistanceWeldWall();
        double expected = momentResistanceWall.momentResistanceWallX(momentInertiaWallX, heightWeldX);
        double out = 130.68;
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when25B1WyWallThen20Point46() {
        double momentInertiaWallY = 25.57;
        double heightWeldY = 1.0;
        double wallThickness = 0.5;
        MomentResistanceWeldWall momentResistanceWall = new MomentResistanceWeldWall();
        double expected = momentResistanceWall.momentResistanceWallY(momentInertiaWallY, heightWeldY, wallThickness);
        double out = 20.46;
        Assertions.assertEquals(expected, out, 0.01);
    }
}