package ru.weld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxDistanceWeldRibsTwoTest {
    @Test
    void when70B4Then36Point1() {
        double heightBeam = 71;
        double sideRibTwo = 0.6;
        double factor = 1;
        double expected = 36.1;
        MaxDistanceWeldRibsTwo maxDistanceWeldRibsTwo = new MaxDistanceWeldRibsTwo();
        double out = maxDistanceWeldRibsTwo.distanceWeldRibsTwoMaxX(heightBeam, sideRibTwo, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when70B4Then20Point35() {
        double flangeWidth = 26.2;
        double lengthRibTwo = 7.75;
        double expected = 20.35;
        MaxDistanceWeldRibsTwo maxDistanceWeldRibsTwo = new MaxDistanceWeldRibsTwo();
        double out = maxDistanceWeldRibsTwo.distanceWeldRibsTwoMaxY(flangeWidth, lengthRibTwo);
        Assertions.assertEquals(expected, out, 0.01);
    }
}