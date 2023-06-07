package ru.weld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeldTest {
    @Test
    void whenC245And08G2C() {
        double heightBeam = 24.8;
        double flangeThickness = 0.8;
        double sideW = 1.0;
        double radius = 1.2;
        double wallThickness = 0.5;
        double rwf = 2200;
        double rwz = 1690;
        double expectedX = 1293.73;
        double expectedY = 25.57;
        Weld weld = new Weld();
        weld.setFactorF(0.9);
        weld.setFactorZ(1);
        weld.selectSectionCalc(rwf, rwz);
        double factor = weld.getFactor();
        MomentInertiaWall miw = new MomentInertiaWall();
        double outX = miw.momentInertiaWallX(heightBeam, flangeThickness, sideW,
                factor, radius);
        double outY = miw.momentInertiaWallY(heightBeam, flangeThickness, sideW, factor,
        radius, wallThickness);
        Assertions.assertEquals(expectedX, outX, 0.01);
        Assertions.assertEquals(expectedY, outY, 0.01);
    }
}