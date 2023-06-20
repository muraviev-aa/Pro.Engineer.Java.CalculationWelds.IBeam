package ru.weld;

public class ShearForceQx {
    public double tangentialStressesQx(double shearForceQx, double sumArea) {
        return shearForceQx / sumArea;
    }
}
