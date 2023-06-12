package ru.weld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MomentInertiaWeldWallTest {

    @Test
    void when25B1Then19Point8() {
        double heightBeam = 24.8;
        double flangeThickness = 0.8;
        double radius = 1.2;
        double expected = 19.8;
        MomentInertiaWeldWall miw = new MomentInertiaWeldWall();
        double out = miw.lengthWeld(heightBeam, flangeThickness, radius);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1Then0Point9() {
        double sideW = 1;
        double factor = 0.9;
        double expected = 0.9;
        MomentInertiaWeldWall miw = new MomentInertiaWeldWall();
        double out = miw.widthWeld(sideW, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1Then0Point7() {
        double wallThickness = 0.5;
        double sideW = 1;
        double factor = 0.9;
        double expected = 0.7;
        MomentInertiaWeldWall miw = new MomentInertiaWeldWall();
        double out = miw.distanceCenterWeldGravityY(wallThickness, sideW, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1Then19And8() {
        double heightBeam = 24.8;
        double flangeThickness = 0.8;
        double radius = 1.2;
        double expected = 19.8;
        MomentInertiaWeldWall miw = new MomentInertiaWeldWall();
        double out = miw.heightWeldX(heightBeam, flangeThickness, radius);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when25B1WidthXThen0And9() {
        double sideW = 1;
        double factor = 0.9;
        double expected = 0.9;
        MomentInertiaWeldWall miw = new MomentInertiaWeldWall();
        double out = miw.widthWeldX(sideW, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1HeightYThen0Point9() {
        double sideW = 1;
        double factor = 0.9;
        double expected = 0.9;
        MomentInertiaWeldWall miw = new MomentInertiaWeldWall();
        double out = miw.heightWeldY(sideW, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1WidthYThen19Point8() {
        double heightBeam = 24.8;
        double flangeThickness = 0.8;
        double radius = 1.2;
        double expected = 19.8;
        MomentInertiaWeldWall miw = new MomentInertiaWeldWall();
        double out = miw.widthWeldY(heightBeam, flangeThickness, radius);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1Then1164Point36() {
        double heightBeam = 24.8;
        double flangeThickness = 0.8;
        double sideW = 1;
        double factor = 0.9;
        double radius = 1.2;
        double expected = 1164.36;
        MomentInertiaWeldWall miw = new MomentInertiaWeldWall();
        double out = miw.momentInertiaWeldWallX(heightBeam, flangeThickness, sideW, factor, radius);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when25B1Then1293Point73() {
        double heightBeam = 24.8;
        double flangeThickness = 0.8;
        double sideW = 1;
        double factor = 1.0;
        double radius = 1.2;
        double expected = 1293.73;
        MomentInertiaWeldWall miw = new MomentInertiaWeldWall();
        double out = miw.momentInertiaWeldWallX(heightBeam, flangeThickness, sideW, factor, radius);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when25B1Then19Point87() {
        double heightBeam = 24.8;
        double flangeThickness = 0.8;
        double sideW = 1;
        double factor = 0.9;
        double radius = 1.2;
        double wallThickness = 0.5;
        double expected = 19.87;
        MomentInertiaWeldWall miw = new MomentInertiaWeldWall();
        double out = miw.momentInertiaWeldWallY(heightBeam, flangeThickness, sideW, factor,
        radius, wallThickness);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when25B1Then25Point57() {
        double heightBeam = 24.8;
        double flangeThickness = 0.8;
        double sideW = 1;
        double factor = 1.0;
        double radius = 1.2;
        double wallThickness = 0.5;
        double expected = 25.57;
        MomentInertiaWeldWall miw = new MomentInertiaWeldWall();
        double out = miw.momentInertiaWeldWallY(heightBeam, flangeThickness, sideW, factor,
                radius, wallThickness);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when70B4Then50Point56() {
        double heightBeam = 71;
        double flangeThickness = 2.5;
        double radius = 2.4;
        double sideW = 0.6;
        double factor = 0.7;
        double expected = 50.56;
        MomentInertiaWeldWall miw = new MomentInertiaWeldWall();
        double out = miw.sumAreaWeldWall(heightBeam, flangeThickness, radius, sideW, factor);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when70B4Then() {

    }
}