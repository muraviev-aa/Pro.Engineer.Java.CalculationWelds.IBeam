package ru.weld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MomentInertiaWeldRibsThreeTest {
    @Test
    void when70B4Then16Point5() {
        double lengthRibThree = 20;
        double bevelRibThree = 2.5;
        double expected = 16.5;
        MomentInertiaWeldRibsThree momentInertiaWeldRibsThree = new MomentInertiaWeldRibsThree();
        double out = momentInertiaWeldRibsThree.lengthWeld(lengthRibThree, bevelRibThree);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when70B4Then0Point6() {
        double sideRibThree = 0.6;
        double factor = 1;
        double expected = 0.6;
        MomentInertiaWeldRibsThree momentInertiaWeldRibsThree = new MomentInertiaWeldRibsThree();
        double out = momentInertiaWeldRibsThree.widthWeld(sideRibThree, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when70B4Then12Point1() {
        double wallThickness = 1.7;
        double lengthRibThree = 20;
        double bevelRibThree = 2.5;
        double expected = 12.1;
        MomentInertiaWeldRibsThree momentInertiaWeldRibsThree = new MomentInertiaWeldRibsThree();
        double out = momentInertiaWeldRibsThree.distanceCenterGravityWeldX(wallThickness,
                lengthRibThree, bevelRibThree);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when70B4Then0Point8() {
        double thicknessRibThree = 1;
        double sideRibThree = 0.6;
        double factor = 1;
        double expected = 0.8;
        MomentInertiaWeldRibsThree momentInertiaWeldRibsThree = new MomentInertiaWeldRibsThree();
        double out = momentInertiaWeldRibsThree.distanceCenterGravityWeldY(thicknessRibThree, sideRibThree, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when70B4Then26Point53() {
        double thicknessRibThree = 1;
        double lengthRibThree = 20;
        double bevelRibThree = 2.5;
        double sideRibThree = 0.6;
        double factor = 1;
        double expected = 26.53;
        MomentInertiaWeldRibsThree momentInertiaWeldRibsThree = new MomentInertiaWeldRibsThree();
        double out = momentInertiaWeldRibsThree.momentInertiaWeldRibsThreeX(thicknessRibThree, lengthRibThree,
                bevelRibThree, sideRibThree, factor);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when70B4Then6696Point26() {
        double wallThickness = 1.7;
        double lengthRibThree = 20;
        double bevelRibThree = 2.5;
        double sideRibThree = 0.6;
        double factor = 1;
        double expected = 6696.26;
        MomentInertiaWeldRibsThree momentInertiaWeldRibsThree = new MomentInertiaWeldRibsThree();
        double out = momentInertiaWeldRibsThree.momentInertiaWeldRibsThreeY(wallThickness, lengthRibThree, bevelRibThree,
        sideRibThree, factor);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when70B4Then39Point6() {
        double lengthRibThree = 20;
        double bevelRibThree = 2.5;
        double sideRibThree = 0.6;
        double factor = 1;
        double expected = 39.6;
        MomentInertiaWeldRibsThree momentInertiaWeldRibsThree = new MomentInertiaWeldRibsThree();
        double out = momentInertiaWeldRibsThree.sumAreaWeldRibsThree(lengthRibThree, bevelRibThree,
                sideRibThree, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }
}