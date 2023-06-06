package ru.weld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MomentInertiaWallTest {

    @Test
    void when25B1Then19Point8() {
        double heightBeam = 24.8;
        double flangeThickness = 0.8;
        double radius = 1.2;
        double expected = 19.8;
        MomentInertiaWall miw = new MomentInertiaWall();
        double out = miw.length(heightBeam, flangeThickness, radius);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1Then0Point9() {
        double side = 1;
        double factor = 0.9;
        double expected = 0.9;
        MomentInertiaWall miw = new MomentInertiaWall();
        double out = miw.width(side, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1Then0Point7() {
        double wallThickness = 0.5;
        double side = 1;
        double factor = 0.9;
        double expected = 0.7;
        MomentInertiaWall miw = new MomentInertiaWall();
        double out = miw.distanceCenterGravityY(wallThickness, side, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1Then19And8() {
        double heightBeam = 24.8;
        double flangeThickness = 0.8;
        double radius = 1.2;
        double expected = 19.8;
        MomentInertiaWall miw = new MomentInertiaWall();
        double out = miw.heightWeldX(heightBeam, flangeThickness, radius);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when25B1WidthXThen0And9() {
        double side = 1;
        double factor = 0.9;
        double expected = 0.9;
        MomentInertiaWall miw = new MomentInertiaWall();
        double out = miw.widthWeldX(side, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1HeightYThen0Point9() {
        double side = 1;
        double factor = 0.9;
        double expected = 0.9;
        MomentInertiaWall miw = new MomentInertiaWall();
        double out = miw.heightWeldY(side, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1WidthYThen19Point8() {
        double heightBeam = 24.8;
        double flangeThickness = 0.8;
        double radius = 1.2;
        double expected = 19.8;
        MomentInertiaWall miw = new MomentInertiaWall();
        double out = miw.widthWeldY(heightBeam, flangeThickness, radius);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1Then1164Point36() {
        double heightBeam = 24.8;
        double flangeThickness = 0.8;
        double side = 1;
        double factor = 0.9;
        double radius = 1.2;
        double expected = 1164.36;
        MomentInertiaWall miw = new MomentInertiaWall();
        double out = miw.momentInertiaWallX(heightBeam, flangeThickness, side, factor, radius);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when25B1() {
        double heightBeam = 24.8;
        double flangeThickness = 0.8;
        double side = 1;
        double factor = 0.9;
        double radius = 1.2;
        double wallThickness = 0.5;
        double expected = 19.87;
        MomentInertiaWall miw = new MomentInertiaWall();
        double out = miw.momentInertiaWallY(heightBeam, flangeThickness, side, factor,
        radius, wallThickness);
        Assertions.assertEquals(expected, out, 0.01);
    }
}