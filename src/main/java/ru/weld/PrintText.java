package ru.weld;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class PrintText {
    public String textDate() {
        Date dNow = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("Отчет создан: dd.MM.yyyy, hh:mm a zzz");
        String date = formatter.format(dNow);
        return date + "\n"
                + "\n";
    }

    public String textName(String name) {
        return "Наименование: " + name + "\n"
                + "\n";
    }

    public String textSizeBeam(String profileName, String heightBeamRes, String flangeWidthRes,
                               String flangeThicknessRes, String wallThicknessRes, String radiusRes) {
        String text = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + "                      Размеры двутаврового сечения, см\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + " Сечение колонны: " + profileName + "\n"
                + "-------------------------------------------------------------------------------\n"
                + " Высота балки: " + heightBeamRes + "; " + "Ширина полки: " + flangeWidthRes + "; "
                + " Толщина полки: " + flangeThicknessRes + "\n"
                + "-------------------------------------------------------------------------------\n"
                + " Толщина стенки: " + wallThicknessRes + "; "
                + "Радиус: " + radiusRes + "\n"
                + "-------------------------------------------------------------------------------\n";
        return text;
    }

    public String textWeldK(String flangeKfRes, String wallKfRes) {
        String text = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + "                 Катеты швов приварки двутавра, см\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + " Катет шва полки: " + flangeKfRes + "; "
                + " Катет шва стенки: " + wallKfRes + "\n"
                + "-------------------------------------------------------------------\n";
        return text;
    }

    public String textSolutionResistance(String metalWeld, String borderWeld, String steelCategory) {
        return "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + "                          Расчетные сопротивления" + "\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + " По металлу шва: " + metalWeld + " кг/см^2" + "; "
                + " По границе сплавления: " + borderWeld + " кг/см^2" + "\n"
                + "-------------------------------------------------------------------------------\n"
                + " Категория стали: " + steelCategory + "\n"
                + "-------------------------------------------------------------------------------\n";
    }

    public String textCharacterSections(String ix, String iy, String wx, String wy, String s, String l) {
        return "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + "                       Характеристики угловых швов\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + " Ix = " + ix + " см^4; " + "Iy = " + iy + " см^4; "
                + " Wx = " + wx + " см^3; " + "Wy = " + wy + " см^3" + "\n"
                + "-------------------------------------------------------------------------------\n"
                + " S = " + s + " см^2; " + "L = " + l + " см" + "\n"
                + "-------------------------------------------------------------------------------\n";
    }

    public String textForceAndMoment(String textForceN, String textForceQx, String textForceQy,
                                     String textMomMx, String textMomMy) {
        return "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + "                                 Нагрузки\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + " N = " + textForceN + " кг" + "; " + "Qx = " + textForceQx + " кг" + "; "
                + "Qy = " + textForceQy + " кг" + "; " + " Mx = " + textMomMx + " кг*см" + "\n"
                + " My = " + textMomMy + " кг*см" + "\n"
                + "-------------------------------------------------------------------------------\n";
    }

    public String textSumTang(String rw, String sumTangX, String sumTangY, String sumTangZ) {
        String sumResTangX = null;
        String sumResTangY = null;
        String sumResTangZ = null;
        if (Double.parseDouble(sumTangX) < Double.parseDouble(rw)) {
            sumResTangX = sumTangX + " кг/см^2" + " < Rw = " + rw + " кг/см^2;"
                    + " Условие прочности выполнено";
        } else {
            sumResTangX = sumTangX + " кг/см^2" + " > Rw = " + rw + " кг/см^2;"
                    + " Условие прочности не выполнено!!!";
        }

        if (Double.parseDouble(sumTangY) < Double.parseDouble(rw)) {
            sumResTangY = sumTangY + " кг/см^2" + " < Rw = " + rw + " кг/см^2;"
                    + " Условие прочности выполнено";
        } else {
            sumResTangY = sumTangY + " кг/см^2" + " > Rw = " + rw + " кг/см^2;"
                    + " Условие прочности не выполнено!!!";
        }

        if (Double.parseDouble(sumTangZ) < Double.parseDouble(rw)) {
            sumResTangZ = sumTangZ + " кг/см^2" + " < Rw = " + rw + " кг/см^2;"
                    + " Условие прочности выполнено";
        } else {
            sumResTangZ = sumTangZ + " кг/см^2" + " > Rw = " + rw + " кг/см^2;"
                    + " Условие прочности не выполнено!!!";
        }
        return "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + "                    Суммарные касательные напряжения\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + " τx = " + sumResTangX + "\n"
                + " τy = " + sumResTangY + "\n"
                + " τz = " + sumResTangZ + "\n"
                + "-------------------------------------------------------------------------------\n";
    }

    public String textTangStrEquivalent(String tangStrEquivalent, String rw) {
        String tangStrEquivalentResult;
        if (Double.parseDouble(tangStrEquivalent) < Double.parseDouble(rw)) {
            tangStrEquivalentResult = tangStrEquivalent + " кг/см^2" + " < Rw = " + rw + " кг/см^2;"
                    + " Условие прочности выполнено";
        } else {
            tangStrEquivalentResult = tangStrEquivalent + " кг/см^2" + " > Rw = " + rw + " кг/см^2;"
                    + " Условие прочности не выполнено!!!";
        }

        return "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + "                    Приведенные касательные напряжения\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + " τпр = " + tangStrEquivalentResult + "\n"
                + "-------------------------------------------------------------------------------\n";
    }
}
