package ru.weld;

public interface RoundUp {
    default double roundWhole(double d) {
        double scale = Math.pow(10, 0);
        return Math.ceil(d * scale) / scale;
    }

    default double roundOne(double d) {
        double scale = Math.pow(10, 1);
        return Math.ceil(d * scale) / scale;
    }

    default double roundTwo(double d) {
        double scale = Math.pow(10, 2);
        return Math.ceil(d * scale) / scale;
    }

    default double roundEight(double d) {
        double scale = Math.pow(10, 8);
        return Math.ceil(d * scale) / scale;
    }
}
