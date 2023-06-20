package ru.weld;

public class BendingMomentMx {
    public double tangentialStressesMx(double bendingMomentMx, double momentResistanceX) {
        return bendingMomentMx / momentResistanceX;
    }
}
