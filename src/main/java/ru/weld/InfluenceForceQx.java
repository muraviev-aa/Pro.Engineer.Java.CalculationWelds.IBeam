package ru.weld;

public class InfluenceForceQx {
    public double tangentialStressesQx(double forceQx, double sumArea) {
        return forceQx / sumArea;
    }
}
