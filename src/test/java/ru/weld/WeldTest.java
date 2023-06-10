package ru.weld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeldTest implements RoundUp {
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

    @Test
    void when25B1Side1Factor1ThenIx6939Point18Iy509Point54Wx517Point85Wy89Point4() {
        double heightBeam = 24.8;
        double flangeWidth = 12.4;
        double flangeThickness = 0.8;
        double wallThickness = 0.5;
        double radius = 1.2;
        double sideF = 1;
        double sideW = 1;
        double expectedIx = 6939.18;
        double expectedIy = 509.54;
        double expectedWx = 517.85;
        double expectedWy = 89.4;
        double factor = 1;
        MomentInertiaWall momentInertiaWall = new MomentInertiaWall();
        MomentInertiaFlange momentInertiaFlange = new MomentInertiaFlange();
        MomentResistanceIBeam momentResistanceIBeam = new MomentResistanceIBeam();
        double wallIx = momentInertiaWall.momentInertiaWallX(heightBeam,
                flangeThickness, sideW, factor, radius);
        double flangeOverIx = momentInertiaFlange.momentInertiaOverFlangeX(heightBeam,
                flangeWidth, sideF, factor);
        double flangeBelowIx = momentInertiaFlange.momentInertiaBelowFlangeX(heightBeam, flangeWidth,
                flangeThickness, wallThickness, radius, sideF, factor);
        double outSumIx = roundTwo(wallIx + flangeOverIx + flangeBelowIx);
        Assertions.assertEquals(expectedIx, outSumIx, 0.01);
        double wallIy = momentInertiaWall.momentInertiaWallY(heightBeam,
                flangeThickness, sideW, factor, radius, wallThickness);
        double flangeOverIy = momentInertiaFlange.momentInertiaOverFlangeY(flangeWidth, sideF, factor);
        double flangeBelowIy = momentInertiaFlange.momentInertiaBelowFlangeY(flangeWidth, wallThickness,
                radius, sideF, factor);
        double outSumIy = roundTwo(wallIy + flangeOverIy + flangeBelowIy);
        Assertions.assertEquals(expectedIy, outSumIy, 0.01);
        double outWx = roundTwo(outSumIx / momentResistanceIBeam.distanceMaxX(heightBeam, sideF, factor));
        Assertions.assertEquals(expectedWx, outWx, 0.01);
        double outWy = roundTwo(outSumIy / momentResistanceIBeam.distanceMaxY(flangeWidth));
        Assertions.assertEquals(expectedWy, outWy, 0.01);
    }

    @Test
    void when25B1SideF0Point6SideW0Point4ThenIx3873Point84Iy293Point8Wx297Point98Wy51Point54() {
        double heightBeam = 24.8;
        double flangeWidth = 12.4;
        double flangeThickness = 0.8;
        double wallThickness = 0.5;
        double radius = 1.2;
        double sideF = 0.6;
        double sideW = 0.4;
        double expectedIx = 3873.84;
        double expectedIy = 293.8;
        double expectedWx = 297.98;
        double expectedWy = 51.54;
        double factor = 1;
        MomentInertiaWall momentInertiaWall = new MomentInertiaWall();
        MomentInertiaFlange momentInertiaFlange = new MomentInertiaFlange();
        MomentResistanceIBeam momentResistanceIBeam = new MomentResistanceIBeam();
        double wallIx = momentInertiaWall.momentInertiaWallX(heightBeam,
                flangeThickness, sideW, factor, radius);
        double flangeOverIx = momentInertiaFlange.momentInertiaOverFlangeX(heightBeam,
                flangeWidth, sideF, factor);
        double flangeBelowIx = momentInertiaFlange.momentInertiaBelowFlangeX(heightBeam, flangeWidth,
                flangeThickness, wallThickness, radius, sideF, factor);
        double outSumIx = roundTwo(wallIx + flangeOverIx + flangeBelowIx);
        Assertions.assertEquals(expectedIx, outSumIx, 0.01);
        double wallIy = momentInertiaWall.momentInertiaWallY(heightBeam,
                flangeThickness, sideW, factor, radius, wallThickness);
        double flangeOverIy = momentInertiaFlange.momentInertiaOverFlangeY(flangeWidth, sideF, factor);
        double flangeBelowIy = momentInertiaFlange.momentInertiaBelowFlangeY(flangeWidth, wallThickness,
                radius, sideF, factor);
        double outSumIy = roundTwo(wallIy + flangeOverIy + flangeBelowIy);
        Assertions.assertEquals(expectedIy, outSumIy, 0.01);
        double outWx = roundTwo(outSumIx / momentResistanceIBeam.distanceMaxX(heightBeam, sideF, factor));
        Assertions.assertEquals(expectedWx, outWx, 0.01);
        double outWy = roundTwo(outSumIy / momentResistanceIBeam.distanceMaxY(flangeWidth));
        Assertions.assertEquals(expectedWy, outWy, 0.01);
    }

    @Test
    void when70B4SideF1Point6SideW1Point2ThenIx208647Point87Iy8743Point55Wx5623Point94Wy693Point94() {
        double heightBeam = 71;
        double flangeWidth = 26.2;
        double flangeThickness = 2.5;
        double wallThickness = 1.7;
        double radius = 2.4;
        double sideF = 1.6;
        double sideW = 1.2;
        double expectedIx = 208647.87;
        double expectedIy = 8743.55;
        double expectedWx = 5623.94;
        double expectedWy = 693.94;
        double factor = 1;
        MomentInertiaWall momentInertiaWall = new MomentInertiaWall();
        MomentInertiaFlange momentInertiaFlange = new MomentInertiaFlange();
        MomentResistanceIBeam momentResistanceIBeam = new MomentResistanceIBeam();
        double wallIx = momentInertiaWall.momentInertiaWallX(heightBeam,
                flangeThickness, sideW, factor, radius);
        double flangeOverIx = momentInertiaFlange.momentInertiaOverFlangeX(heightBeam,
                flangeWidth, sideF, factor);
        double flangeBelowIx = momentInertiaFlange.momentInertiaBelowFlangeX(heightBeam, flangeWidth,
                flangeThickness, wallThickness, radius, sideF, factor);
        double outSumIx = roundTwo(wallIx + flangeOverIx + flangeBelowIx);
        Assertions.assertEquals(expectedIx, outSumIx, 0.01);
        double wallIy = momentInertiaWall.momentInertiaWallY(heightBeam,
                flangeThickness, sideW, factor, radius, wallThickness);
        double flangeOverIy = momentInertiaFlange.momentInertiaOverFlangeY(flangeWidth, sideF, factor);
        double flangeBelowIy = momentInertiaFlange.momentInertiaBelowFlangeY(flangeWidth, wallThickness,
                radius, sideF, factor);
        double outSumIy = roundTwo(wallIy + flangeOverIy + flangeBelowIy);
        Assertions.assertEquals(expectedIy, outSumIy, 0.01);
        double outWx = roundTwo(outSumIx / momentResistanceIBeam.distanceMaxX(heightBeam, sideF, factor));
        Assertions.assertEquals(expectedWx, outWx, 0.01);
        double outWy = roundTwo(outSumIy / momentResistanceIBeam.distanceMaxY(flangeWidth));
        Assertions.assertEquals(expectedWy, outWy, 0.01);
    }
}