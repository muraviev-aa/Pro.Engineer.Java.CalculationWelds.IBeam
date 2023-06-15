package ru.weld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MomentInertiaWeldRibsTwoTest {
    @Test
    void when70B4Then6Point75() {
        double lengthRibTwo = 7.75;
        double expected = 6.75;
        MomentInertiaWeldRibsTwo momentInertiaWeldRibsTwo = new MomentInertiaWeldRibsTwo();
        double out = momentInertiaWeldRibsTwo.lengthWeld(lengthRibTwo);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when70B4Then0Point6() {
        double sideRibTwo = 0.6;
        double factor = 1;
        double expected = 0.6;
        MomentInertiaWeldRibsTwo momentInertiaWeldRibsTwo = new MomentInertiaWeldRibsTwo();
        double out = momentInertiaWeldRibsTwo.widthWeld(sideRibTwo, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when70B4Then16Point98() {
        double flangeWidth = 26.2;
        double lengthRibTwo = 7.75;
        double expected = 16.98;
        MomentInertiaWeldRibsTwo momentInertiaWeldRibsTwo = new MomentInertiaWeldRibsTwo();
        double out = momentInertiaWeldRibsTwo.distanceCenterGravityWeldOverBelowX(flangeWidth, lengthRibTwo);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when70B4Then35Point8() {
        double heightBeam = 71;
        double sideRibTwo = 0.6;
        double factor = 1;
        double expected = 35.8;
        MomentInertiaWeldRibsTwo momentInertiaWeldRibsTwo = new MomentInertiaWeldRibsTwo();
        double out = momentInertiaWeldRibsTwo.distanceCenterGravityWeldOverY(heightBeam, sideRibTwo, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when70B4Then34Point2() {
        double heightBeam = 71;
        double thicknessRibTwo = 1;
        double sideRibTwo = 0.6;
        double factor = 1;
        double expected = 34.2;
        MomentInertiaWeldRibsTwo momentInertiaWeldRibsTwo = new MomentInertiaWeldRibsTwo();
        double out = momentInertiaWeldRibsTwo.distanceCenterGravityWeldBelowY(heightBeam, thicknessRibTwo,
                sideRibTwo, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when70B4Then39711Point71() {
        double heightBeam = 71;
        double lengthRibTwo = 7.75;
        double thicknessRibTwo = 1;
        double sideRibTwo = 0.6;
        double factor = 1;
        double expected = 39711.71;
        MomentInertiaWeldRibsTwo momentInertiaWeldRibsTwo = new MomentInertiaWeldRibsTwo();
        double out = momentInertiaWeldRibsTwo.momentInertiaWeldRibsTwoX(heightBeam, lengthRibTwo,
                thicknessRibTwo, sideRibTwo, factor);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when70B4Then9459Point1() {
        double flangeWidth = 26.2;
        double lengthRibTwo = 7.75;
        double sideRibTwo = 0.6;
        double factor = 1;
        double expected = 9459.1;
        MomentInertiaWeldRibsTwo momentInertiaWeldRibsTwo = new MomentInertiaWeldRibsTwo();
        double out = momentInertiaWeldRibsTwo.momentInertiaWeldRibsTwoY(flangeWidth, lengthRibTwo,
                sideRibTwo, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when70B4Then32Point4() {
        double lengthRibTwo = 7.75;
        double sideRibTwo = 0.6;
        double factor = 1;
        double expected = 32.4;
        MomentInertiaWeldRibsTwo momentInertiaWeldRibsTwo = new MomentInertiaWeldRibsTwo();
        double out = momentInertiaWeldRibsTwo.sumAreaWeldRibsTwo(lengthRibTwo, sideRibTwo, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }
}