package ru.weld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeldTest {
    @Test
    void whenRwf2200SlashRwz1690ThenIx1293Point73AndIy25Point57() {
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

    @Test
    void whenRwf1850SlashRwz2240Then0Point9() {
        double rwf = 2200;
        double rwz = 1690;
        Weld weld = new Weld();
        weld.setFactorF(1.1);
        weld.setFactorZ(1);
        weld.selectSectionCalc(rwf, rwz);
        double expected = weld.getFactor();
        double out = 0.9;
        Assertions.assertEquals(expected, out, 0.1);
    }
}