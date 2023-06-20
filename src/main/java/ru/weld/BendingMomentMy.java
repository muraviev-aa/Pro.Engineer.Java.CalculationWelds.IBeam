package ru.weld;

public class BendingMomentMy {
    public double tangentialStressesMy(double bendingMomentMy, double momentResistanceY) {
        return bendingMomentMy / momentResistanceY;
    }
}
