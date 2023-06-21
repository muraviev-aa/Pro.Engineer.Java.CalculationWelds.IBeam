package ru.weld;

public class InfluenceBendingMomentMx {
    public double tangentialStressesMx(double bendingMomentMx, double sumWx) {
        return bendingMomentMx / sumWx;
    }
}
