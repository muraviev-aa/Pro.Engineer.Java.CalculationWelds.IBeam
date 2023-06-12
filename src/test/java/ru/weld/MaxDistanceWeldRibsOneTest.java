package ru.weld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxDistanceWeldRibsOneTest {
    @Test
    void when70B4Then45() {
        double heightBeam = 71;
        double lengthRibOne = 10;
        double expected = 45;
        MaxDistanceWeldRibsOne maxDistanceWeldRibsOne = new MaxDistanceWeldRibsOne();
        double out = maxDistanceWeldRibsOne.distanceWeldRibsOneMaxX(heightBeam, lengthRibOne);
        Assertions.assertEquals(expected, out, 0.1);
    }
}