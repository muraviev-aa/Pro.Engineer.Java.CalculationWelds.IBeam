package ru.weld;

public class ShearForceQy {
    public double tangentialStressesQy(double shearForceQy, double sumArea) {
        return shearForceQy / sumArea;
    }
}
