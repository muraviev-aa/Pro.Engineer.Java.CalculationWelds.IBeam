package ru.weld;

public class ForceN {
    public double tangentialStressesN(double forceN, double sumArea) {
        return forceN / sumArea;
    }
}
