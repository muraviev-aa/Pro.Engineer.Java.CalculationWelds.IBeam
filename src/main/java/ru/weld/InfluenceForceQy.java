package ru.weld;

public class InfluenceForceQy {
    public double tangentialStressesQy(double forceQy, double sumArea) {
        return forceQy / sumArea;
    }
}
