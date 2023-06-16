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
    private JTextField textFieldRibLength3;
    private JTextField textFieldRibBevel3;
    private JTextField textFieldArea;
    private JTextField textFieldLength;
    private JTextField textFieldRibSide1;
    private JTextField textFieldRibThickness1;
    private JTextField textFieldRibSide2;
    private JTextField textFieldRibThickness2;
    private JTextField textFieldRibSide3;
    private JTextField textFieldRibThickness3;
    private JButton buttonResetSizeRibs;
    double heightBeam;
    double flangeWidth;
    double flangeThickness;
    double wallThickness;
    double sideW;
    double sideF;
    double radius;
    double rwf;
    double rwz;
    double lengthRibOne;
    double bevelRibOne;
    double sideRibOne;
    double thicknessRibOne;
    double thicknessRibThree;
    double lengthRibThree;
    double bevelRibThree;
    double sideRibThree;
    double lengthRibTwo;
    double thicknessRibTwo;
    double sideRibTwo;

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
        this.setIconImage(Toolkit.getDefaultToolkit().
                getImage(getClass().getResource("/ant.gif")));
        Dimension dimension = new Dimension(205, 30);
        buttonIW.setPreferredSize(dimension);
        button2.setPreferredSize(dimension);
        button3.setPreferredSize(dimension);
        button4.setPreferredSize(dimension);
        buttonResetSection.setPreferredSize(dimension);
        buttonResetWeld.setPreferredSize(dimension);
        buttonResetSizeRibs.setPreferredSize(dimension);
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
        setSize(1000, 750);
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
            labelClassSteel.setText("C....");
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
                readingDataFromCheckboxesAndLabelsBeam();
                calculateResult();
            } else if (comboBox1.getSelectedItem() == "allRibs") {
                readingDataFromCheckboxesAndLabelsRibsOneTwoThree();
                calculateResult();
            } else if (comboBox1.getSelectedItem() == "ribsNumberOne") {
                readingDataFromCheckboxesAndLabelsRibsOne();
                calculateResult();
            } else if (comboBox1.getSelectedItem() == "ribsNumberTwo") {
                readingDataFromCheckboxesAndLabelsRibsTwo();
                calculateResult();
            } else if (comboBox1.getSelectedItem() == "ribsNumberThree") {
                readingDataFromCheckboxesAndLabelsRibsThree();
                calculateResult();
            } else if (comboBox1.getSelectedItem() == "ribsNumbersOneTwo") {
                readingDataFromCheckboxesAndLabelsRibsOneTwo();
                calculateResult();
            } else if (comboBox1.getSelectedItem() == "ribsNumbersOneThree") {
                readingDataFromCheckboxesAndLabelsRibsOneThree();
                calculateResult();
            } else if (comboBox1.getSelectedItem() == "ribsNumbersTwoThree") {
                System.out.println("ribsNumbersTwoThree");
            }
        });
        checkBox1And15.addActionListener(e -> factorZ = 1.15);
        checkBox1And15.addActionListener(e -> labelZ.setText(""));
        checkBox1And05.addActionListener(e -> factorZ = 1.05);
        checkBox1And05.addActionListener(e -> labelZ.setText(""));
        checkBox1.addActionListener(e -> factorZ = 1);
        checkBox1.addActionListener(e -> labelZ.setText(""));
        checkBox1And1.addActionListener(e -> factorF = 1.1);
        checkBox1And1.addActionListener(e -> labelF.setText(""));
        checkBox0And9.addActionListener(e -> factorF = 0.9);
        checkBox0And9.addActionListener(e -> labelF.setText(""));
        checkBox0And8.addActionListener(e -> factorF = 0.8);
        checkBox0And8.addActionListener(e -> labelF.setText(""));
        checkBox0And7.addActionListener(e -> factorF = 0.7);
        checkBox0And7.addActionListener(e -> labelF.setText(""));
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
        buttonIW.addActionListener(e -> controlFilling());
        textFieldHeightBeam.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textFieldHeightBeam.setBackground(Color.WHITE);
            }
        });
        textFieldFlangeWidth.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textFieldFlangeWidth.setBackground(Color.WHITE);
            }
        });
        textFieldFlangeThickness.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textFieldFlangeThickness.setBackground(Color.WHITE);
            }
        });
        textFieldWallThickness.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textFieldWallThickness.setBackground(Color.WHITE);
            }
        });
        textFieldRadius.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textFieldRadius.setBackground(Color.WHITE);
            }
        });
        textFieldFlangeKf.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textFieldFlangeKf.setBackground(Color.WHITE);
            }
        });
        textFieldWallKf.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textFieldWallKf.setBackground(Color.WHITE);
            }
        });
        textFieldRibLength1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textFieldRibLength1.setBackground(Color.WHITE);
            }
        });
        textFieldRibSide1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textFieldRibSide1.setBackground(Color.WHITE);
            }
        });
        textFieldRibThickness1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textFieldRibThickness1.setBackground(Color.WHITE);
            }
        });
        textFieldRibBevel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textFieldRibBevel1.setBackground(Color.WHITE);
            }
        });
        buttonResetSizeRibs.addActionListener(e -> {
            textFieldRibSide1.setText("");
            textFieldRibSide2.setText("");
            textFieldRibSide3.setText("");
            textFieldRibThickness1.setText("");
            textFieldRibThickness2.setText("");
            textFieldRibThickness3.setText("");
            textFieldRibLength1.setText("");
            textFieldRibLength2.setText("");
            textFieldRibLength3.setText("");
            textFieldRibBevel1.setText("");
            textFieldRibBevel3.setText("");
        });
    }

    public void controlFilling() {
        if (comboBox1.getSelectedItem() == "withoutRibs") {
            withoutRibs();
        } else if (comboBox1.getSelectedItem() == "allRibs") {
            ribsNumberOne();
            ribsNumberTwo();
            ribsNumberThree();
        } else if (comboBox1.getSelectedItem() == "ribsNumberOne") {
            ribsNumberOne();
        } else if (comboBox1.getSelectedItem() == "ribsNumberTwo") {
            ribsNumberTwo();
        } else if (comboBox1.getSelectedItem() == "ribsNumberThree") {
            ribsNumberThree();
        } else if (comboBox1.getSelectedItem() == "ribsNumbersOneTwo") {
            ribsNumberOne();
            ribsNumberTwo();
        } else if (comboBox1.getSelectedItem() == "ribsNumbersOneThree") {
            ribsNumberOne();
            ribsNumberThree();
        } else if (comboBox1.getSelectedItem() == "ribsNumbersTwoThree") {
            ribsNumberTwo();
            ribsNumberThree();
        }
    }

    public void basicCheck() {
        if (textFieldHeightBeam.getText().isEmpty()
                || textFieldFlangeWidth.getText().isEmpty()
                || textFieldFlangeThickness.getText().isEmpty()
                || textFieldWallThickness.getText().isEmpty()
                || textFieldRadius.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Заполните пустые текстовые поля в панели <<Двутавр>>");
        }
        if (textFieldFlangeKf.getText().isEmpty()
                || textFieldWallKf.getText().isEmpty()
                || labelRwf.getText().equals("Rwf")
                || labelRwz.getText().equals("Rwz")
                || labelClassSteel.getText().equals("C...")) {
            JOptionPane.showMessageDialog(null,
                    "Заполните пустые текстовые поля в панели <<Сварной шов>>");
        }

        if (!checkBox1And1.isSelected() && !checkBox0And9.isSelected()
                && !checkBox0And8.isSelected() && !checkBox0And7.isSelected()) {
            labelF.setText("Заполни здесь!!!");
            JOptionPane.showMessageDialog(null,
                    "Заполните пустые текстовые поля в панели <<βf>>");
        }

        if (!checkBox1And15.isSelected() && !checkBox1And05.isSelected() && !checkBox1.isSelected()) {
            labelZ.setText("Заполни здесь!!!");
            JOptionPane.showMessageDialog(null,
                    "Заполните пустые текстовые поля в панели <<βz>>");
        }
    }

    public void withoutRibs() {
        basicCheck();
    }

    public void ribsNumberOne() {
        basicCheck();
        if (textFieldRibLength1.getText().isEmpty()
                || textFieldRibSide1.getText().isEmpty()
                || textFieldRibThickness1.getText().isEmpty()
                || textFieldRibBevel1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Заполните пустые текстовые поля в панели <<Размеры ребра 1>>");
        }
    }

    public void ribsNumberTwo() {
        basicCheck();
        if (textFieldRibLength2.getText().isEmpty()
                || textFieldRibSide2.getText().isEmpty()
                || textFieldRibThickness2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Заполните пустые текстовые поля в панели <<Размеры ребра 2>>");
        }
    }

    public void ribsNumberThree() {
        basicCheck();
        if (textFieldRibLength3.getText().isEmpty()
                || textFieldRibSide3.getText().isEmpty()
                || textFieldRibThickness3.getText().isEmpty()
                || textFieldRibBevel3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Заполните пустые текстовые поля в панели <<Размеры ребра 3>>");
        }
    }

    public void createTableRwf() {
        JTable table = new JTable((Object[][]) dataRwf, columnsRwf);
        JFrame frame = new JFrame("Расчетные сопротивления по металлу сварного шва");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().
                getImage(getClass().getResource("/ant.gif")));
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
        frame.setIconImage(Toolkit.getDefaultToolkit().
                getImage(getClass().getResource("/ant.gif")));
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
            if (!checkBox1And1.isSelected() || !checkBox0And9.isSelected()
                    || !checkBox0And8.isSelected() || !checkBox0And7.isSelected()) {
                labelF.setText("");
            } else {
                labelF.setText("По металлу шва");
            }
        } else {
            factor = factorZ;
            if (!checkBox1And15.isSelected() || !checkBox1And05.isSelected()
                    || !checkBox1.isSelected()) {
                labelF.setText("");
            }
            labelZ.setText("По границе сплавления");
        }
    }

    public void readingDataBase() {
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

    public void readingDataFromCheckboxesAndLabelsBeam() {
        readingDataBase();
    }

    public void readingDataFromCheckboxesAndLabelsRibsOne() {
        readingDataBase();
        lengthRibOne = Double.parseDouble(textFieldRibLength1.getText());
        bevelRibOne = Double.parseDouble(textFieldRibBevel1.getText());
        sideRibOne = Double.parseDouble(textFieldRibSide1.getText());
        thicknessRibOne = Double.parseDouble(textFieldRibThickness1.getText());
    }

    public void readingDataFromCheckboxesAndLabelsRibsTwo() {
        readingDataBase();
        lengthRibTwo = Double.parseDouble(textFieldRibLength2.getText());
        sideRibTwo = Double.parseDouble(textFieldRibSide2.getText());
        thicknessRibTwo = Double.parseDouble(textFieldRibThickness2.getText());
    }

    public void readingDataFromCheckboxesAndLabelsRibsThree() {
        readingDataBase();
        thicknessRibThree = Double.parseDouble(textFieldRibThickness3.getText());
        lengthRibThree = Double.parseDouble(textFieldRibLength3.getText());
        bevelRibThree = Double.parseDouble(textFieldRibBevel3.getText());
        sideRibThree = Double.parseDouble(textFieldRibSide3.getText());
    }

    public void readingDataFromCheckboxesAndLabelsRibsOneTwo() {
        readingDataBase();
        /**
         * RibsOne
         */
        lengthRibOne = Double.parseDouble(textFieldRibLength1.getText());
        bevelRibOne = Double.parseDouble(textFieldRibBevel1.getText());
        sideRibOne = Double.parseDouble(textFieldRibSide1.getText());
        thicknessRibOne = Double.parseDouble(textFieldRibThickness1.getText());
        /**
         * RibsTwo
         */
        lengthRibTwo = Double.parseDouble(textFieldRibLength2.getText());
        sideRibTwo = Double.parseDouble(textFieldRibSide2.getText());
        thicknessRibTwo = Double.parseDouble(textFieldRibThickness2.getText());
    }

    public void readingDataFromCheckboxesAndLabelsRibsOneThree() {
        readingDataBase();
        /**
         * RibsOne
         */
        lengthRibOne = Double.parseDouble(textFieldRibLength1.getText());
        bevelRibOne = Double.parseDouble(textFieldRibBevel1.getText());
        sideRibOne = Double.parseDouble(textFieldRibSide1.getText());
        thicknessRibOne = Double.parseDouble(textFieldRibThickness1.getText());
        /**
         * RibsThree
         */
        thicknessRibThree = Double.parseDouble(textFieldRibThickness3.getText());
        lengthRibThree = Double.parseDouble(textFieldRibLength3.getText());
        bevelRibThree = Double.parseDouble(textFieldRibBevel3.getText());
        sideRibThree = Double.parseDouble(textFieldRibSide3.getText());
    }

    public void readingDataFromCheckboxesAndLabelsRibsOneTwoThree() {
        readingDataBase();
        /**
         * RibsOne
         */
        lengthRibOne = Double.parseDouble(textFieldRibLength1.getText());
        bevelRibOne = Double.parseDouble(textFieldRibBevel1.getText());
        sideRibOne = Double.parseDouble(textFieldRibSide1.getText());
        thicknessRibOne = Double.parseDouble(textFieldRibThickness1.getText());
        /**
         * RibsTwo
         */
        lengthRibTwo = Double.parseDouble(textFieldRibLength2.getText());
        sideRibTwo = Double.parseDouble(textFieldRibSide2.getText());
        thicknessRibTwo = Double.parseDouble(textFieldRibThickness2.getText());
        /**
         * RibsThree
         */
        thicknessRibThree = Double.parseDouble(textFieldRibThickness3.getText());
        lengthRibThree = Double.parseDouble(textFieldRibLength3.getText());
        bevelRibThree = Double.parseDouble(textFieldRibBevel3.getText());
        sideRibThree = Double.parseDouble(textFieldRibSide3.getText());
    }

    public void recordingResultBeam(double sumBeamIx, double sumBeamIy, double sumBeamWx, double sumBeamWy,
                                    double sumBeamArea, double sumBeamLength) {
        textFieldIx.setText(Double.toString(sumBeamIx));
        textFieldIy.setText(Double.toString(sumBeamIy));
        textFieldWx.setText(Double.toString(sumBeamWx));
        textFieldWy.setText(Double.toString(sumBeamWy));
        textFieldArea.setText(Double.toString(sumBeamArea));
        textFieldLength.setText(String.valueOf(sumBeamLength));
    }

    public void recordingResultBeamRibsOne(double sumBeamRibsOneIx, double sumBeamRibsOneIy,
                                           double sumBeamRibsOneWx, double sumBeamRibsOneWy,
                                           double sumBeamRibsOneArea, double sumBeamRibsOneLength) {
        textFieldIx.setText(Double.toString(sumBeamRibsOneIx));
        textFieldIy.setText(Double.toString(sumBeamRibsOneIy));
        textFieldWx.setText(Double.toString(sumBeamRibsOneWx));
        textFieldWy.setText(Double.toString(sumBeamRibsOneWy));
        textFieldArea.setText(Double.toString(sumBeamRibsOneArea));
        textFieldLength.setText(String.valueOf(sumBeamRibsOneLength));
    }

    public void recordingResultBeamRibsTwo(double sumBeamRibsTwoIx, double sumBeamRibsTwoIy,
                                           double sumBeamRibsTwoWx, double sumBeamRibsTwoWy,
                                           double sumBeamRibsTwoArea, double sumBeamRibsTwoLength) {
        textFieldIx.setText(Double.toString(sumBeamRibsTwoIx));
        textFieldIy.setText(Double.toString(sumBeamRibsTwoIy));
        textFieldWx.setText(Double.toString(sumBeamRibsTwoWx));
        textFieldWy.setText(Double.toString(sumBeamRibsTwoWy));
        textFieldArea.setText(Double.toString(sumBeamRibsTwoArea));
        textFieldLength.setText(String.valueOf(sumBeamRibsTwoLength));
    }

    public void recordingResultBeamRibsThree(double sumBeamRibsThreeIx, double sumBeamRibsThreeIy,
                                             double sumBeamRibsThreeWx, double sumBeamRibsThreeWy,
                                             double sumBeamRibsThreeArea, double sumBeamRibsThreeLength) {
        textFieldIx.setText(Double.toString(sumBeamRibsThreeIx));
        textFieldIy.setText(Double.toString(sumBeamRibsThreeIy));
        textFieldWx.setText(Double.toString(sumBeamRibsThreeWx));
        textFieldWy.setText(Double.toString(sumBeamRibsThreeWy));
        textFieldArea.setText(Double.toString(sumBeamRibsThreeArea));
        textFieldLength.setText(Double.toString(sumBeamRibsThreeLength));
    }

    public void recordingResultBeamRibsOneTwo(double sumBeamRibsOneTwoIx, double sumBeamRibsOneTwoIy,
                                              double sumBeamRibsOneTwoWx, double sumBeamRibsOneTwoWy,
                                              double sumBeamRibsOneTwoArea, double sumBeamRibsOneTwoLength) {
        textFieldIx.setText(Double.toString(sumBeamRibsOneTwoIx));
        textFieldIy.setText(Double.toString(sumBeamRibsOneTwoIy));
        textFieldWx.setText(Double.toString(sumBeamRibsOneTwoWx));
        textFieldWy.setText(Double.toString(sumBeamRibsOneTwoWy));
        textFieldArea.setText(Double.toString(sumBeamRibsOneTwoArea));
        textFieldLength.setText(Double.toString(sumBeamRibsOneTwoLength));
    }

    public void recordingResultBeamRibsOneThree(double sumBeamRibsOneThreeIx, double sumBeamRibsOneThreeIy,
                                                double sumBeamRibsOneThreeWx, double sumBeamRibsOneThreeWy,
                                                double sumBeamRibsOneThreeArea, double sumBeamRibsOneThreeLength) {
        textFieldIx.setText(Double.toString(sumBeamRibsOneThreeIx));
        textFieldIy.setText(Double.toString(sumBeamRibsOneThreeIy));
        textFieldWx.setText(Double.toString(sumBeamRibsOneThreeWx));
        textFieldWy.setText(Double.toString(sumBeamRibsOneThreeWy));
        textFieldArea.setText(Double.toString(sumBeamRibsOneThreeArea));
        textFieldLength.setText(Double.toString(sumBeamRibsOneThreeLength));
    }

    public void recordingResultBeamRibsOneTwoThree(double sumBeamRibsOneTwoThreeIx, double sumBeamRibsOneTwoThreeIy,
                                                   double sumBeamRibsOneTwoThreeWx, double sumBeamRibsOneTwoThreeWy,
                                                   double sumBeamRibsOneTwoThreeArea, double sumBeamRibsOneTwoThreeLength) {
        textFieldIx.setText(Double.toString(sumBeamRibsOneTwoThreeIx));
        textFieldIy.setText(Double.toString(sumBeamRibsOneTwoThreeIy));
        textFieldWx.setText(Double.toString(sumBeamRibsOneTwoThreeWx));
        textFieldWy.setText(Double.toString(sumBeamRibsOneTwoThreeWy));
        textFieldArea.setText(Double.toString(sumBeamRibsOneTwoThreeArea));
        textFieldLength.setText(Double.toString(sumBeamRibsOneTwoThreeLength));
    }

    /**
     * Наибольшее расстояние для вычисления Wx для балки со вторым ребром
     */
    public double maxDistanceWxBeamRibsTwo(double sumBeamRibsTwoIx) {
        double sumBeamRibsTwoWx;
        MaxDistanceWeldIBeam maxDistanceWeldIBeam = new MaxDistanceWeldIBeam();
        MaxDistanceWeldRibsTwo maxDistanceWeldRibsTwo = new MaxDistanceWeldRibsTwo();
        double maxBeamWeldX = maxDistanceWeldIBeam.distanceBeamMaxX(heightBeam, sideF, factor);
        double maxRibsTwoX = maxDistanceWeldRibsTwo.distanceWeldRibsTwoMaxX(heightBeam, sideRibTwo, factor);
        if (maxBeamWeldX >= maxRibsTwoX) {
            sumBeamRibsTwoWx = roundTwo(sumBeamRibsTwoIx / maxBeamWeldX);
        } else {
            sumBeamRibsTwoWx = roundTwo(sumBeamRibsTwoIx / maxRibsTwoX);
        }
        return sumBeamRibsTwoWx;
    }

    public double maxDistanceWyBeamRibsThree(double sumBeamRibsThreeIy) {
        double sumBeamRibsThreeWy;
        MaxDistanceWeldIBeam maxDistanceWeldIBeam = new MaxDistanceWeldIBeam();
        MaxDistanceWeldRibsThree maxDistanceWeldRibsThree = new MaxDistanceWeldRibsThree();
        double maxBeamWeldY = maxDistanceWeldIBeam.distanceBeamMaxY(flangeWidth);
        double maxRibsThreeY = maxDistanceWeldRibsThree.distanceWeldRibsThreeMaxY(wallThickness, lengthRibThree);
        if (maxBeamWeldY >= maxRibsThreeY) {
            sumBeamRibsThreeWy = roundTwo(sumBeamRibsThreeIy / maxBeamWeldY);
        } else {
            sumBeamRibsThreeWy = roundTwo(sumBeamRibsThreeIy / maxRibsThreeY);
        }
        return sumBeamRibsThreeWy;
    }

    public double maxDistanceWyRibsTwoThree(double sumBeamRibsOneTwoThreeIy) {
        double sumBeamRibsOneTwoThreeWy;
        MaxDistanceWeldRibsTwo maxDistanceWeldRibsTwo = new MaxDistanceWeldRibsTwo();
        MaxDistanceWeldRibsThree maxDistanceWeldRibsThree = new MaxDistanceWeldRibsThree();
        double maxRibsTwoY = maxDistanceWeldRibsTwo.distanceWeldRibsTwoMaxY(flangeWidth, lengthRibTwo);
        double maxRibsThreeY = maxDistanceWeldRibsThree.distanceWeldRibsThreeMaxY(wallThickness, lengthRibThree);
        if (maxRibsTwoY >= maxRibsThreeY) {
            sumBeamRibsOneTwoThreeWy = roundTwo(sumBeamRibsOneTwoThreeIy / maxRibsTwoY);
        } else {
            sumBeamRibsOneTwoThreeWy = roundTwo(sumBeamRibsOneTwoThreeIy / maxRibsThreeY);
        }
        return sumBeamRibsOneTwoThreeWy;
    }

    public void calculateResult() {
        MomentInertiaWeldWall momentInertiaWeldWall = new MomentInertiaWeldWall();
        MomentInertiaWeldFlange momentInertiaWeldFlange = new MomentInertiaWeldFlange();
        MomentInertiaWeldRibsOne momentInertiaWeldRibsOne = new MomentInertiaWeldRibsOne();
        MomentInertiaWeldRibsTwo momentInertiaWeldRibsTwo = new MomentInertiaWeldRibsTwo();
        MomentInertiaWeldRibsThree momentInertiaWeldRibsThree = new MomentInertiaWeldRibsThree();
        MaxDistanceWeldIBeam maxDistanceWeldIBeam = new MaxDistanceWeldIBeam();
        MaxDistanceWeldRibsOne maxDistanceWeldRibsOne = new MaxDistanceWeldRibsOne();
        MaxDistanceWeldRibsTwo maxDistanceWeldRibsTwo = new MaxDistanceWeldRibsTwo();
        MaxDistanceWeldRibsThree maxDistanceWeldRibsThree = new MaxDistanceWeldRibsThree();
        selectSectionCalc(rwf, rwz);
        /**
         * Выводим factor
         */
        System.out.println(factor);
        double wallIx = momentInertiaWeldWall.momentInertiaWeldWallX(heightBeam,
                flangeThickness, sideW, factor, radius);
        double flangeOverIx = momentInertiaWeldFlange.momentInertiaWeldOverFlangeX(heightBeam,
                flangeWidth, sideF, factor);
        double flangeBelowIx = momentInertiaWeldFlange.momentInertiaWeldBelowFlangeX(heightBeam, flangeWidth,
                flangeThickness, wallThickness, radius, sideF, factor);
        double ribsOneIx = momentInertiaWeldRibsOne.momentInertiaWeldRibsOneX(heightBeam, lengthRibOne,
                factor, bevelRibOne, sideRibOne);
        double ribsTwoIx = momentInertiaWeldRibsTwo.momentInertiaWeldRibsTwoX(heightBeam, lengthRibTwo,
                thicknessRibTwo, sideRibTwo, factor);
        double ribsThreeIx = momentInertiaWeldRibsThree.momentInertiaWeldRibsThreeX(thicknessRibThree,
                lengthRibThree, bevelRibThree, sideRibThree, factor);
        double sumBeamIx = roundTwo(wallIx + flangeOverIx + flangeBelowIx);
        double sumBeamRibsOneIx = roundTwo(wallIx + flangeOverIx + flangeBelowIx + ribsOneIx);
        double sumBeamRibsTwoIx = roundTwo(wallIx + flangeOverIx + flangeBelowIx + ribsTwoIx);
        double sumBeamRibsThreeIx = roundTwo(wallIx + flangeOverIx + flangeBelowIx + ribsThreeIx);
        double sumBeamRibsOneTwoIx = roundTwo(wallIx + flangeOverIx + flangeBelowIx + ribsOneIx + ribsTwoIx);
        double sumBeamRibsOneThreeIx = roundTwo(wallIx + flangeOverIx + flangeBelowIx + ribsOneIx + ribsThreeIx);
        double sumBeamRibsOneTwoThreeIx = roundTwo(wallIx + flangeOverIx + flangeBelowIx + ribsOneIx
                + ribsTwoIx + ribsThreeIx);

        double wallIy = momentInertiaWeldWall.momentInertiaWeldWallY(heightBeam,
                flangeThickness, sideW, factor, radius, wallThickness);
        double flangeOverIy = momentInertiaWeldFlange.momentInertiaWeldOverFlangeY(flangeWidth, sideF, factor);
        double flangeBelowIy = momentInertiaWeldFlange.momentInertiaWeldBelowFlangeY(flangeWidth, wallThickness,
                radius, sideF, factor);
        double ribsOneIy = momentInertiaWeldRibsOne.momentInertiaWeldRibsOneY(thicknessRibOne, lengthRibOne,
                bevelRibOne, sideRibOne, factor);
        double ribsTwoIy = momentInertiaWeldRibsTwo.momentInertiaWeldRibsTwoY(flangeWidth, lengthRibTwo, sideRibTwo,
                factor);
        double ribsThreeIy = momentInertiaWeldRibsThree.momentInertiaWeldRibsThreeY(wallThickness, lengthRibThree,
                bevelRibThree, sideRibThree, factor);
        double sumBeamIy = roundTwo(wallIy + flangeOverIy + flangeBelowIy);
        double sumBeamRibsOneIy = roundTwo(wallIy + flangeOverIy + flangeBelowIy + ribsOneIy);
        double sumBeamRibsTwoIy = roundTwo(wallIy + flangeOverIy + flangeBelowIy + ribsTwoIy);
        double sumBeamRibsThreeIy = roundTwo(wallIy + flangeOverIy + flangeBelowIy + ribsThreeIy);
        double sumBeamRibsOneTwoIy = roundTwo(wallIy + flangeOverIy + flangeBelowIy + ribsOneIy + ribsTwoIy);
        double sumBeamRibsOneThreeIy = roundTwo(wallIy + flangeOverIy + flangeBelowIy + ribsOneIy + ribsThreeIy);
        double sumBeamRibsOneTwoThreeIy = roundTwo(wallIy + flangeOverIy + flangeBelowIy + ribsOneIy
                + ribsTwoIy + ribsThreeIy);

        double sumBeamWx = roundTwo(sumBeamIx / maxDistanceWeldIBeam.distanceBeamMaxX(heightBeam, sideF, factor));
        double sumBeamRibsOneWx = roundTwo(sumBeamRibsOneIx
                / maxDistanceWeldRibsOne.distanceWeldRibsOneMaxX(heightBeam, lengthRibOne));
        /**
         * С учетом Xmax для двутавра и ребра 2
         */
        double sumBeamRibsTwoWx = maxDistanceWxBeamRibsTwo(sumBeamRibsTwoIx);
        double sumBeamRibsThreeWx = roundTwo(sumBeamRibsThreeIx
                / maxDistanceWeldIBeam.distanceBeamMaxX(heightBeam, sideF, factor));
        double sumBeamRibsOneTwoWx = roundTwo(sumBeamRibsOneTwoIx
                / maxDistanceWeldRibsOne.distanceWeldRibsOneMaxX(heightBeam, lengthRibOne));
        double sumBeamRibsOneThreeWx = roundTwo(sumBeamRibsOneThreeIx
                / maxDistanceWeldRibsOne.distanceWeldRibsOneMaxX(heightBeam, lengthRibOne));
        double sumBeamRibsOneTwoThreeWx = roundTwo(sumBeamRibsOneTwoThreeIx
                / maxDistanceWeldRibsOne.distanceWeldRibsOneMaxX(heightBeam, lengthRibOne));

        double sumBeamWy = roundTwo(sumBeamIy / maxDistanceWeldIBeam.distanceBeamMaxY(flangeWidth));
        double sumBeamRibsOneWy = roundTwo(sumBeamRibsOneIy
                / maxDistanceWeldIBeam.distanceBeamMaxY(flangeWidth));
        double sumBeamRibsTwoWy = roundTwo(sumBeamRibsTwoIy
                / maxDistanceWeldRibsTwo.distanceWeldRibsTwoMaxY(flangeWidth, lengthRibTwo));
        /**
         * С учетом Ymax двутавра и ребра 3
         */
        double sumBeamRibsThreeWy = maxDistanceWyBeamRibsThree(sumBeamRibsThreeIy);
        double sumBeamRibsOneTwoWy = roundTwo(sumBeamRibsOneTwoIy
                / maxDistanceWeldRibsTwo.distanceWeldRibsTwoMaxY(flangeWidth, lengthRibTwo));
        double sumBeamRibsOneThreeWy = roundTwo(sumBeamRibsOneThreeIy
                / maxDistanceWeldRibsThree.distanceWeldRibsThreeMaxY(wallThickness, lengthRibThree));
        /**
         * С учетом Ymax для ребра 2 и 3
         */
        double sumBeamRibsOneTwoThreeWy = maxDistanceWyRibsTwoThree(sumBeamRibsOneTwoThreeIy);

        double sw = momentInertiaWeldWall.sumAreaWeldWall(heightBeam, flangeThickness, radius, sideW, factor);
        double sf = momentInertiaWeldFlange.sumAreaWeldFlange(flangeWidth, wallThickness, radius, sideF, factor);
        double sr1 = momentInertiaWeldRibsOne.sumAreaWeldRibsOne(lengthRibOne, bevelRibOne, sideRibOne, factor);
        double sr2 = momentInertiaWeldRibsTwo.sumAreaWeldRibsTwo(lengthRibTwo, sideRibTwo, factor);
        double sr3 = momentInertiaWeldRibsThree.sumAreaWeldRibsThree(lengthRibThree, bevelRibThree,
                sideRibThree, factor);
        double sumBeamArea = roundTwo(sw + sf);
        double sumBeamRibsOneArea = roundTwo(sw + sf + sr1);
        double sumBeamRibsTwoArea = roundTwo(sw + sf + sr2);
        double sumBeamRibsThreeArea = roundTwo(sw + sf + sr3);
        double sumBeamRibsOneTwoArea = roundTwo(sw + sf + sr1 + sr2);
        double sumBeamRibsOneThreeArea = roundTwo(sw + sf + sr1 + sr3);
        double sumBeamRibsOneTwoThreeArea = roundTwo(sw + sf + sr1 + sr2 + sr3);

        double l = momentInertiaWeldWall.lengthWeld(heightBeam, flangeThickness, radius);
        double lo = momentInertiaWeldFlange.lengthWeldOverFlange(flangeWidth);
        double lb = momentInertiaWeldFlange.lengthWeldBelowFlange(flangeWidth, wallThickness, radius);
        double lr1 = momentInertiaWeldRibsOne.lengthWeld(lengthRibOne, bevelRibOne);
        double lr2 = momentInertiaWeldRibsTwo.lengthWeld(lengthRibTwo);
        double lr3 = momentInertiaWeldRibsThree.lengthWeld(lengthRibThree, bevelRibThree);
        double sumBeamLength = roundTwo(2 * (l + lo) + 4 * lb);
        double sumBeamRibsOneLength = roundTwo((2 * (l + lo) + 4 * lb) + 4 * lr1);
        double sumBeamRibsTwoLength = roundTwo((2 * (l + lo) + 4 * lb) + 8 * lr2);
        double sumBeamRibsThreeLength = roundTwo((2 * (l + lo) + 4 * lb) + 4 * lr3);
        double sumBeamRibsOneTwoLength = roundTwo((2 * (l + lo) + 4 * lb) + 4 * lr1 + 8 * lr2);
        double sumBeamRibsOneThreeLength = roundTwo((2 * (l + lo) + 4 * lb) + 4 * (lr1 + lr3));
        double sumBeamRibsOneTwoThreeLength = roundTwo((2 * (l + lo) + 4 * lb) +  8 * lr2 + 4 * (lr1 + lr3));

        if (comboBox1.getSelectedItem() == "withoutRibs") {
            recordingResultBeam(sumBeamIx, sumBeamIy, sumBeamWx, sumBeamWy, sumBeamArea, sumBeamLength);
        } else if (comboBox1.getSelectedItem() == "allRibs") {
            recordingResultBeamRibsOneTwoThree(sumBeamRibsOneTwoThreeIx, sumBeamRibsOneTwoThreeIy,
                    sumBeamRibsOneTwoThreeWx, sumBeamRibsOneTwoThreeWy, sumBeamRibsOneTwoThreeArea,
                    sumBeamRibsOneTwoThreeLength);
        } else if (comboBox1.getSelectedItem() == "ribsNumberOne") {
            recordingResultBeamRibsOne(sumBeamRibsOneIx, sumBeamRibsOneIy, sumBeamRibsOneWx,
                    sumBeamRibsOneWy, sumBeamRibsOneArea, sumBeamRibsOneLength);
        } else if (comboBox1.getSelectedItem() == "ribsNumberTwo") {
            recordingResultBeamRibsTwo(sumBeamRibsTwoIx, sumBeamRibsTwoIy, sumBeamRibsTwoWx,
                    sumBeamRibsTwoWy, sumBeamRibsTwoArea, sumBeamRibsTwoLength);
        } else if (comboBox1.getSelectedItem() == "ribsNumberThree") {
            recordingResultBeamRibsThree(sumBeamRibsThreeIx, sumBeamRibsThreeIy, sumBeamRibsThreeWx,
                    sumBeamRibsThreeWy, sumBeamRibsThreeArea, sumBeamRibsThreeLength);
        } else if (comboBox1.getSelectedItem() == "ribsNumbersOneTwo") {
            recordingResultBeamRibsOneTwo(sumBeamRibsOneTwoIx, sumBeamRibsOneTwoIy, sumBeamRibsOneTwoWx,
                    sumBeamRibsOneTwoWy, sumBeamRibsOneTwoArea, sumBeamRibsOneTwoLength);
        } else if (comboBox1.getSelectedItem() == "ribsNumbersOneThree") {
            recordingResultBeamRibsOneThree(sumBeamRibsOneThreeIx, sumBeamRibsOneThreeIy,
                    sumBeamRibsOneThreeWx, sumBeamRibsOneThreeWy, sumBeamRibsOneThreeArea,
                    sumBeamRibsOneThreeLength);
        } else if (comboBox1.getSelectedItem() == "ribsNumbersTwoThree") {
            System.out.println("ribsNumbersTwoThree");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Weld::new);
    }
}
