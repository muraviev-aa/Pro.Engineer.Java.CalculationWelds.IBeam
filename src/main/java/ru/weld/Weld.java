package ru.weld;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Weld extends JFrame implements RoundUp {
    private double factorF;
    private double factorZ;
    private double factor;
    private JTabbedPane tabbedPane1;
    private JPanel panel;
    private JComboBox comboBox1;
    private JLabel label1;
    private JTextField textFieldHeightBeam;
    private JTextField textFieldFlangeWidth;
    private JTextField textFieldFlangeThickness;
    private JTextField textFieldWallThickness;
    private JTextField textFieldRadius;
    private JTextField textFieldFlangeKf;
    private JTextField textFieldWallKf;
    private JCheckBox checkBox0And7;
    private JCheckBox checkBox0And8;
    private JCheckBox checkBox0And9;
    private JCheckBox checkBox1And1;
    private JCheckBox checkBox1And15;
    private JCheckBox checkBox1And05;
    private JCheckBox checkBox1;
    private JTextField textFieldIx;
    private JTextField textFieldIy;
    private JTextField textFieldWx;
    private JTextField textFieldWy;
    private JButton buttonIW;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel labelRwf;
    private JLabel labelRwz;
    private JLabel labelClassSteel;
    private JCheckBox checkBox25B1;
    private JButton buttonResetSection;
    private JButton buttonResetWeld;
    private JLabel labelF;
    private JLabel labelZ;
    private JCheckBox checkBox70B4;
    private JTextField textFieldRibLength1;
    private JTextField textFieldRibBevel1;
    private JTextField textFieldRibLength2;
    private JTextField textFieldRibBevel2;
    private JTextField textFieldRibLength3;
    private JTextField textFieldRibBevel3;
    private JTextField textFieldArea;
    private JTextField textFieldLength;
    double heightBeam;
    double flangeWidth;
    double flangeThickness;
    double wallThickness;
    double sideW;
    double sideF;
    double radius;
    double rwf;
    double rwz;

    private final Object[] columnsRwf = new String[]{
            "Тип электрода / марка проволоки", "Rwf [кг/см^2]"
    };

    private final Object dataRwf = new String[][]{
            {"Э42(A) / Св-08(А)", "1850"},
            {"Э46(A) / Св-08ГА", "2050"},
            {"Э50(A) / Св-08Г2С, Св-10ГА, Св-10Г2", "2200"},
            {"Э60 / Св-08Г2С*, Св-08ГСНТ, Св-08ГСМТ", "2450"},
            {"Э70 / Св-10ХГ2СМА, Св-08ХН2ГМЮ", "2850"},
            {"Э85 / - ", "3450"}
    };

    private final Object columnsRwz = new String[]{
            "Класс стали", "Мин. толщина свариваемых элементов", "Rwz [кг/см^2]"
    };

    private final Object dataRwz = new String[][]{
            {"C235", "от 2,0 до 4,0 включ.", "1650"},
            {"C245", "от 2,0 до 20 включ.", "1690"},
            {"C255", "от 2,0 до 3,9 включ.", "1740"},
            {"C255", "от 4,0 до 10 включ.", "1740"},
            {"C255", "св. 10 до 20 включ.", "1690"},
            {"C255", "св. 20 до 40 включ.", "1690"},
            {"C345K", "от 4,0 до 10 включ.", "2150"},
            {"C355", "от 2,0 до 16 включ.", "2240"},
            {"C355", "св. 16 до 40 включ.", "2240"},
            {"C355", "св. 40 до 60 включ.", "2240"},
            {"C355", "св. 60 до 80 включ.", "2240"},
            {"C355", "св. 80 до 100 включ.", "2150"},
            {"C355", "св. 100 до 160 включ.", "2150"},
            {"C355", "св. 160 до 200 включ.", "2150"},
            {"C355", "св. 200 до 260 включ.", "2060"},
            {"C355", "св. 260 до 300 включ.", "2060"},
            {"C355", "св. 300 до 360 включ.", "2010"},
            {"C355-1 / C355-K", "от 2,0 до 16 включ.", "2240"},
            {"C355-1 / C355-K", "св. 16 до 40 включ.", "2240"},
            {"C355-1 / C355-K", "св. 40 до 50 включ.", "2240"},
            {"C355П", "от 2,0 до 16 включ.", "2240"},
            {"C355П", "св. 16 до 40 включ.", "2240"}
    };

    public double getFactor() {
        return factor;
    }

    public void setFactorF(double factorF) {
        this.factorF = factorF;
    }

    public void setFactorZ(double factorZ) {
        this.factorZ = factorZ;
    }

    public double getFactorF() {
        return factorF;
    }

    public double getFactorZ() {
        return factorZ;
    }

    public Weld() {
        super("Расчет сварного шва приварки двутавра");
        setContentPane(this.panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dimension = new Dimension(205, 30);
        buttonIW.setPreferredSize(dimension);
        button2.setPreferredSize(dimension);
        button3.setPreferredSize(dimension);
        button4.setPreferredSize(dimension);
        buttonResetSection.setPreferredSize(dimension);
        buttonResetWeld.setPreferredSize(dimension);
        final ButtonGroup checkBoxGroupBf = new ButtonGroup();
        checkBoxGroupBf.add(checkBox1And1);
        checkBoxGroupBf.add(checkBox0And9);
        checkBoxGroupBf.add(checkBox0And8);
        checkBoxGroupBf.add(checkBox0And7);
        final ButtonGroup checkBoxGroupBz = new ButtonGroup();
        checkBoxGroupBz.add(checkBox1And15);
        checkBoxGroupBz.add(checkBox1And05);
        checkBoxGroupBz.add(checkBox1);
        final ButtonGroup checkBoxGroupIBeam = new ButtonGroup();
        checkBoxGroupIBeam.add(checkBox25B1);
        checkBoxGroupIBeam.add(checkBox70B4);
        setSize(950, 750);
        label1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().
                getImage(getClass().getResource("/withoutRibs.png"))));
        tabbedPane1.setEnabledAt(1, false);
        tabbedPane1.setEnabledAt(2, false);
        tabbedPane1.setEnabledAt(3, false);
        setLocationRelativeTo(null);
        setVisible(true);
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = (String) comboBox1.getSelectedItem();
                label1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().
                        getImage(getClass().getResource("/" + str + ".png"))));
            }
        });
        button3.addActionListener(e -> createTableRwf());
        button4.addActionListener(e -> createTableRwz());
        checkBox25B1.addActionListener(e -> {
            textFieldHeightBeam.setText("24.8");
            textFieldFlangeWidth.setText("12.4");
            textFieldFlangeThickness.setText("0.8");
            textFieldWallThickness.setText("0.5");
            textFieldRadius.setText("1.2");
        });
        buttonResetSection.addActionListener(e -> {
            textFieldHeightBeam.setText("");
            textFieldFlangeWidth.setText("");
            textFieldFlangeThickness.setText("");
            textFieldWallThickness.setText("");
            textFieldRadius.setText("");
            checkBoxGroupIBeam.clearSelection();
        });
        buttonResetWeld.addActionListener(e -> {
            textFieldFlangeKf.setText("");
            textFieldWallKf.setText("");
            labelRwf.setText("Rwf");
            labelRwz.setText("Rwz");
            labelClassSteel.setText("C...");
            checkBoxGroupBf.clearSelection();
            checkBoxGroupBz.clearSelection();
            factorF = 0;
            labelF.setText("");
            labelZ.setText("");
        });
        button2.addActionListener(e -> {
            textFieldIx.setText("");
            textFieldIy.setText("");
            textFieldWx.setText("");
            textFieldWy.setText("");
            textFieldArea.setText("");
            textFieldLength.setText("");
        });
        buttonIW.addActionListener(e -> {
            if (comboBox1.getSelectedItem() == "withoutRibs") {
                readingDataFromCheckboxesAndLabels();
                baseBeamWithoutRibs();
            } else if (comboBox1.getSelectedItem() == "allRibs") {
                System.out.println("allRibs");
            } else if (comboBox1.getSelectedItem() == "ribsNumberOne") {
                tabbedPane1.setEnabledAt(1, true);
                System.out.println("ribsNumberOne");
            } else if (comboBox1.getSelectedItem() == "ribsNumberTwo") {
                System.out.println("ribsNumberTwo");
            } else if (comboBox1.getSelectedItem() == "ribsNumberThree") {
                System.out.println("ribsNumberThree");
            } else if (comboBox1.getSelectedItem() == "ribsNumbersOneTwo") {
                System.out.println("ribsNumbersOneTwo");
            } else if (comboBox1.getSelectedItem() == "ribsNumbersOneThree") {
                System.out.println("ribsNumbersOneThree");
            } else if (comboBox1.getSelectedItem() == "ribsNumbersTwoThree") {
                System.out.println("ribsNumbersTwoThree");
            }
        });
        checkBox1And15.addActionListener(e -> factorZ = 1.15);
        checkBox1And05.addActionListener(e -> factorZ = 1.05);
        checkBox1.addActionListener(e -> factorZ = 1);
        checkBox1And1.addActionListener(e -> factorF = 1.1);
        checkBox0And9.addActionListener(e -> factorF = 0.9);
        checkBox0And8.addActionListener(e -> factorF = 0.8);
        checkBox0And7.addActionListener(e -> factorF = 0.7);
        checkBox70B4.addActionListener(e -> {
            textFieldHeightBeam.setText("71");
            textFieldFlangeWidth.setText("26.2");
            textFieldFlangeThickness.setText("2.5");
            textFieldWallThickness.setText("1.7");
            textFieldRadius.setText("2.4");
        });
        comboBox1.addActionListener(e -> {
            if (comboBox1.getSelectedItem() == "allRibs") {
                tabbedPane1.setEnabledAt(1, true);
                tabbedPane1.setEnabledAt(2, true);
                tabbedPane1.setEnabledAt(3, true);
            } else if (comboBox1.getSelectedItem() == "ribsNumberOne") {
                tabbedPane1.setEnabledAt(1, true);
                tabbedPane1.setEnabledAt(2, false);
                tabbedPane1.setEnabledAt(3, false);
            } else if (comboBox1.getSelectedItem() == "ribsNumberTwo") {
                tabbedPane1.setEnabledAt(1, false);
                tabbedPane1.setEnabledAt(2, true);
                tabbedPane1.setEnabledAt(3, false);
            } else if (comboBox1.getSelectedItem() == "ribsNumberThree") {
                tabbedPane1.setEnabledAt(1, false);
                tabbedPane1.setEnabledAt(2, false);
                tabbedPane1.setEnabledAt(3, true);
            } else if (comboBox1.getSelectedItem() == "ribsNumbersOneTwo") {
                tabbedPane1.setEnabledAt(1, true);
                tabbedPane1.setEnabledAt(2, true);
                tabbedPane1.setEnabledAt(3, false);
            } else if (comboBox1.getSelectedItem() == "ribsNumbersOneThree") {
                tabbedPane1.setEnabledAt(1, true);
                tabbedPane1.setEnabledAt(2, false);
                tabbedPane1.setEnabledAt(3, true);
            } else if (comboBox1.getSelectedItem() == "ribsNumbersTwoThree") {
                tabbedPane1.setEnabledAt(1, false);
                tabbedPane1.setEnabledAt(2, true);
                tabbedPane1.setEnabledAt(3, true);
            } else if (comboBox1.getSelectedItem() == "withoutRibs") {
                tabbedPane1.setEnabledAt(1, false);
                tabbedPane1.setEnabledAt(2, false);
                tabbedPane1.setEnabledAt(3, false);
            }
        });
    }

    public void createTableRwf() {
        JTable table = new JTable((Object[][]) dataRwf, columnsRwf);
        JFrame frame = new JFrame("Расчетные сопротивления по металлу сварного шва");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 200);
        frame.add(new JScrollPane(table));
        frame.setVisible(true);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int i = table.getSelectedRow();
                TableModel model = table.getModel();
                labelRwf.setText(model.getValueAt(i, 1).toString());
            }
        });
    }

    public void createTableRwz() {
        JTable table = new JTable((Object[][]) dataRwz, (Object[]) columnsRwz);
        JFrame frame = new JFrame("Расчетные сопротивления по границе сплавления");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 300);
        frame.add(new JScrollPane(table));
        frame.setVisible(true);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int i = table.getSelectedRow();
                TableModel model = table.getModel();
                labelRwz.setText(model.getValueAt(i, 2).toString());
                labelClassSteel.setText(model.getValueAt(i, 0).toString());
            }
        });
    }

    public void selectSectionCalc(double rwf, double rwz) {
        double f = factorF * rwf;
        double z = factorZ * rwz;
        double res = f / z;
        if (res <= 1) {
            factor = factorF;
            labelF.setText("По металлу шва");
        } else {
            factor = factorZ;
            labelZ.setText("По границе сплавления");
        }
    }

    public void readingDataFromCheckboxesAndLabels() {
        heightBeam = Double.parseDouble(textFieldHeightBeam.getText());
        flangeWidth = Double.parseDouble(textFieldFlangeWidth.getText());
        flangeThickness = Double.parseDouble(textFieldFlangeThickness.getText());
        wallThickness = Double.parseDouble(textFieldWallThickness.getText());
        sideW = Double.parseDouble(textFieldWallKf.getText());
        sideF = Double.parseDouble(textFieldFlangeKf.getText());
        radius = Double.parseDouble(textFieldRadius.getText());
        rwf = Double.parseDouble(labelRwf.getText());
        rwz = Double.parseDouble(labelRwz.getText());
    }

    public void baseBeamWithoutRibs() {
        MomentInertiaWall momentInertiaWall = new MomentInertiaWall();
        MomentInertiaFlange momentInertiaFlange = new MomentInertiaFlange();
        MaxDistanceIBeam maxDistanceIBeam = new MaxDistanceIBeam();
        selectSectionCalc(rwf, rwz);
        /**
         * Выводим factor
         */
        System.out.println(factor);
        double wallIx = momentInertiaWall.momentInertiaWallX(heightBeam,
                flangeThickness, sideW, factor, radius);
        double flangeOverIx = momentInertiaFlange.momentInertiaOverFlangeX(heightBeam,
                flangeWidth, sideF, factor);
        double flangeBelowIx = momentInertiaFlange.momentInertiaBelowFlangeX(heightBeam, flangeWidth,
                flangeThickness, wallThickness, radius, sideF, factor);
        double sumIx = roundTwo(wallIx + flangeOverIx + flangeBelowIx);
        textFieldIx.setText(Double.toString(sumIx));
        double wallIy = momentInertiaWall.momentInertiaWallY(heightBeam,
                flangeThickness, sideW, factor, radius, wallThickness);
        double flangeOverIy = momentInertiaFlange.momentInertiaOverFlangeY(flangeWidth, sideF, factor);
        double flangeBelowIy = momentInertiaFlange.momentInertiaBelowFlangeY(flangeWidth, wallThickness,
                radius, sideF, factor);
        double sumIy = roundTwo(wallIy + flangeOverIy + flangeBelowIy);
        textFieldIy.setText(Double.toString(sumIy));
        double wx = roundTwo(sumIx / maxDistanceIBeam.distanceMaxX(heightBeam, sideF, factor));
        textFieldWx.setText(Double.toString(wx));
        double wy = roundTwo(sumIy / maxDistanceIBeam.distanceMaxY(flangeWidth));
        textFieldWy.setText(Double.toString(wy));
        double lw = momentInertiaWall.sumAreaWall(heightBeam, flangeThickness, radius, sideW, factor);
        double lf = momentInertiaFlange.sumAreaFlange(flangeWidth, wallThickness, radius, sideF, factor);
        double sumArea = roundTwo(lw + lf);
        textFieldArea.setText(Double.toString(sumArea));
        double l = momentInertiaWall.length(heightBeam, flangeThickness, radius);
        double lo = momentInertiaFlange.lengthOverFlange(flangeWidth);
        double lb = momentInertiaFlange.lengthBelowFlange(flangeWidth, wallThickness, radius);
        double sumLength = roundTwo(2 * (l + lo) + 4 * lb);
        textFieldLength.setText(String.valueOf(sumLength));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Weld::new);
    }
}
