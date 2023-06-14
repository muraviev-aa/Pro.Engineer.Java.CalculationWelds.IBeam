package ru.weld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxDistanceWeldRibsThreeTest {
    @Test
    void when70B4Then1Point1() {
        double thicknessRibThree = 1;
        double sideRibThree = 0.6;
        double factor = 1;
        double expected = 1.1;
        MaxDistanceWeldRibsThree maxDistanceWeldRibsThree = new MaxDistanceWeldRibsThree();
        double out = maxDistanceWeldRibsThree.distanceWeldRibsThreeMaxX(thicknessRibThree, sideRibThree, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when70B4Then20Point35() {
        double wallThickness = 1.7;
        double lengthRibThree = 20;
        double expected = 20.35;
        MaxDistanceWeldRibsThree maxDistanceWeldRibsThree = new MaxDistanceWeldRibsThree();
        double out = maxDistanceWeldRibsThree.distanceWeldRibsThreeMaxY(wallThickness, lengthRibThree);
        Assertions.assertEquals(expected, out, 0.01);
    }
}