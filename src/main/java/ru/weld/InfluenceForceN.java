package ru.weld;

public class InfluenceForceN {
    public double tangentialStressesN(double forceN, double sumArea) {
        return forceN / sumArea;
    }
}
