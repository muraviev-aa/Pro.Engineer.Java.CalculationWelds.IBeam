package ru.weld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MomentInertiaWeldFlangeTest {

    @Test
    void when25B1Then3Point75() {
        double flangeWidth = 12.4;
        double wallThickness = 0.5;
        double radius = 1.2;
        double expected = 3.75;
        MomentInertiaWeldFlange momentInertiaFlange = new MomentInertiaWeldFlange();
        double out = momentInertiaFlange.lengthWeldBelowFlange(flangeWidth, wallThickness, radius);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when25B1Then11Point4() {
        double flangeWidth = 12.4;
        double expected = 11.4;
        MomentInertiaWeldFlange momentInertiaFlange = new MomentInertiaWeldFlange();
        double out = momentInertiaFlange.lengthWeldOverFlange(flangeWidth);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1Then12Point9() {
        double heightBeam = 24.8;
        double side = 1;
        double factor = 1;
        double expected = 12.9;
        MomentInertiaWeldFlange momentInertiaFlange = new MomentInertiaWeldFlange();
        double out = momentInertiaFlange.distanceCenterGravityWeldOverX(heightBeam, side, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1Then11Point1() {
        double heightBeam = 24.8;
        double flangeThickness = 0.8;
        double side = 1;
        double factor = 1;
        double expected = 11.1;
        MomentInertiaWeldFlange momentInertiaFlange = new MomentInertiaWeldFlange();
        double out = momentInertiaFlange.distanceCenterGravityWeldBelowX(heightBeam, flangeThickness, side, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1Then3796Point05() {
        double heightBeam = 24.8;
        double flangeWidth = 12.4;
        double side = 1;
        double factor = 1;
        double expected = 3796.05;
        MomentInertiaWeldFlange momentInertiaFlange = new MomentInertiaWeldFlange();
        double out = momentInertiaFlange.momentInertiaWeldOverFlangeX(heightBeam, flangeWidth, side, factor);
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
        MomentInertiaWeldFlange momentInertiaFlange = new MomentInertiaWeldFlange();
        double out = momentInertiaFlange.momentInertiaWeldBelowFlangeX(heightBeam, flangeWidth, flangeThickness,
        wallThickness, radius, side, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1Then246Point93() {
        double flangeWidth = 12.4;
        double side = 1;
        double factor = 1;
        double expected = 246.93;
        MomentInertiaWeldFlange momentInertiaFlange = new MomentInertiaWeldFlange();
        double out = momentInertiaFlange.momentInertiaWeldOverFlangeY(flangeWidth, side, factor);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when25B1Then3Point83() {
        double flangeWidth = 12.4;
        double wallThickness = 0.5;
        double radius = 1.2;
        double expected = 3.83;
        MomentInertiaWeldFlange momentInertiaFlange = new MomentInertiaWeldFlange();
        double out = momentInertiaFlange.distanceCenterGravityWeldBelowY(flangeWidth, wallThickness, radius);
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
        MomentInertiaWeldFlange momentInertiaFlange = new MomentInertiaWeldFlange();
        double out = momentInertiaFlange.momentInertiaWeldBelowFlangeY(flangeWidth, wallThickness, radius, side, factor);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when70B4Then36Point03() {
        double flangeWidth = 26.2;
        double wallThickness = 1.7;
        double radius = 2.4;
        double sideF = 0.6;
        double factor = 0.7;
        double expected = 36.03;
        MomentInertiaWeldFlange momentInertiaFlange = new MomentInertiaWeldFlange();
        double out = momentInertiaFlange.sumAreaWeldFlange(flangeWidth, wallThickness, radius, sideF, factor);
        Assertions.assertEquals(expected, out, 0.01);
    }
}