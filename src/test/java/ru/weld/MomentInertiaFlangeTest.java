package ru.weld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MomentInertiaFlangeTest {

    @Test
    void when25B1Then3Point75() {
        double flangeWidth = 12.4;
        double wallThickness = 0.5;
        double radius = 1.2;
        double expected = 3.75;
        MomentInertiaFlange momentInertiaFlange = new MomentInertiaFlange();
        double out = momentInertiaFlange.lengthBelowFlange(flangeWidth, wallThickness, radius);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when25B1Then11Point4() {
        double flangeWidth = 12.4;
        double expected = 11.4;
        MomentInertiaFlange momentInertiaFlange = new MomentInertiaFlange();
        double out = momentInertiaFlange.lengthOverFlange(flangeWidth);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1Then12Point9() {
        double heightBeam = 24.8;
        double side = 1;
        double factor = 1;
        double expected = 12.9;
        MomentInertiaFlange momentInertiaFlange = new MomentInertiaFlange();
        double out = momentInertiaFlange.distanceCenterGravityOverX(heightBeam, side, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1Then11Point1() {
        double heightBeam = 24.8;
        double flangeThickness = 0.8;
        double side = 1;
        double factor = 1;
        double expected = 11.1;
        MomentInertiaFlange momentInertiaFlange = new MomentInertiaFlange();
        double out = momentInertiaFlange.distanceCenterGravityBelowX(heightBeam, flangeThickness, side, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1Then3796Point05() {
        double heightBeam = 24.8;
        double flangeWidth = 12.4;
        double side = 1;
        double factor = 1;
        double expected = 3796.05;
        MomentInertiaFlange momentInertiaFlange = new MomentInertiaFlange();
        double out = momentInertiaFlange.momentInertiaOverFlangeX(heightBeam, flangeWidth, side, factor);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when25B1Then1849Point4() {
        double heightBeam = 24.8;
        double flangeWidth = 12.4;
        double flangeThickness = 0.8;
        double wallThickness = 0.5;
        double radius = 1.2;
        double side = 1;
        double factor = 1;
        double expected = 1849.4;
        MomentInertiaFlange momentInertiaFlange = new MomentInertiaFlange();
        double out = momentInertiaFlange.momentInertiaBelowFlangeX(heightBeam, flangeWidth, flangeThickness,
        wallThickness, radius, side, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1Then246Point93() {
        double flangeWidth = 12.4;
        double side = 1;
        double factor = 1;
        double expected = 246.93;
        MomentInertiaFlange momentInertiaFlange = new MomentInertiaFlange();
        double out = momentInertiaFlange.momentInertiaOverFlangeY(flangeWidth, side, factor);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when25B1Then3Point83() {
        double flangeWidth = 12.4;
        double wallThickness = 0.5;
        double radius = 1.2;
        double expected = 3.83;
        MomentInertiaFlange momentInertiaFlange = new MomentInertiaFlange();
        double out = momentInertiaFlange.distanceCenterGravityBelowY(flangeWidth, wallThickness, radius);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when25B1Then237Point04() {
        double flangeWidth = 12.4;
        double wallThickness = 0.5;
        double radius = 1.2;
        double side = 1;
        double factor = 1;
        double expected = 237.04;
        MomentInertiaFlange momentInertiaFlange = new MomentInertiaFlange();
        double out = momentInertiaFlange.momentInertiaBelowFlangeY(flangeWidth, wallThickness, radius, side, factor);
        Assertions.assertEquals(expected, out, 0.01);
    }
}