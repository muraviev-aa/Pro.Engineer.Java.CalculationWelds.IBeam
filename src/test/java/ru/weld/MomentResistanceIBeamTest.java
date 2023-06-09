package ru.weld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MomentResistanceIBeamTest {
    @Test
    void when25B1Then13Point4() {
        double heightBeam = 24.8;
        double sideF = 1;
        double factor = 1;
        double expected = 13.4;
        MomentResistanceIBeam momentResistanceIBeam = new MomentResistanceIBeam();
        double out = momentResistanceIBeam.distanceMaxX(heightBeam, sideF, factor);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when25B1Then5Point7() {
        double flangeWidth = 12.4;
        double expected = 5.7;
        MomentResistanceIBeam momentResistanceIBeam = new MomentResistanceIBeam();
        double out = momentResistanceIBeam.distanceMaxY(flangeWidth);
        Assertions.assertEquals(expected, out, 0.1);
    }
}