package ru.weld;

public class InfluenceBendingMomentMy {
    public double tangentialStressesMy(double bendingMomentMy, double sumWy) {
        return bendingMomentMy / sumWy;
    }
}
