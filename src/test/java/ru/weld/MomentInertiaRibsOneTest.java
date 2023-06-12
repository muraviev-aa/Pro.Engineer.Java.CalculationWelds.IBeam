package ru.weld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MomentInertiaRibsOneTest {
    @Test
    void when70B4Then6Point5() {
        double lengthRibOne = 10;
        double bevelRibOne = 2.5;
        double expected = 6.5;
        MomentInertiaWeldRibsOne miro = new MomentInertiaWeldRibsOne();
        double out = miro.lengthWeld(lengthRibOne, bevelRibOne);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when70B4Then0Point6() {
        double sideRibOne = 0.6;
        double factor = 1;
        double expected = 0.6;
        MomentInertiaWeldRibsOne miro = new MomentInertiaWeldRibsOne();
        double out = miro.widthWeld(sideRibOne, factor);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when70B4Then41Point75() {
        double heightBeam = 71;
        double lengthRibOne = 10;
        double bevelRibOne = 2.5;
        double expected = 41.75;
        MomentInertiaWeldRibsOne miro = new MomentInertiaWeldRibsOne();
        double out = miro.distanceCenterGravityWeldX(heightBeam, lengthRibOne, bevelRibOne);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when70B4Then0Point8() {
        double thicknessRibOne = 1;
        double sideRibOne = 0.6;
        double factor = 1;
        double expected = 0.8;
        MomentInertiaWeldRibsOne miro = new MomentInertiaWeldRibsOne();
        double out = miro.distanceCenterGravityWeldY(thicknessRibOne, sideRibOne, factor);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when70B4Then27246Point7() {
        double heightBeam = 71;
        double lengthRibOne = 10;
        double factor = 1;
        double bevelRibOne = 2.5;
        double sideRibOne = 0.6;
        double expected = 27246.7;
        MomentInertiaWeldRibsOne miro = new MomentInertiaWeldRibsOne();
        double out = miro.momentInertiaWeldRibsOneX(heightBeam, lengthRibOne, factor, bevelRibOne, sideRibOne);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when70B4Then10Point45() {
        double thicknessRibOne = 1;
        double lengthRibOne = 10;
        double factor = 1;
        double bevelRibOne = 2.5;
        double sideRibOne = 0.6;
        double expected = 10.45;
        MomentInertiaWeldRibsOne miro = new MomentInertiaWeldRibsOne();
        double out = miro.momentInertiaWeldRibsOneY(thicknessRibOne, lengthRibOne, bevelRibOne, sideRibOne, factor);
        Assertions.assertEquals(expected, out, 0.01);
    }
}