package ru.weld;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Weld extends JFrame {
    private double factorF;
    private double factorZ;
    private double factor;
    private JTabbedPane tabbedPane1;
    private JPanel panel;
    private JComboBox comboBox1;
    private JLabel label1;
    private JTextField textFieldHeightBeam;
    private JTextField textFieldFlangeWidth;
    private JTextField textFieldtFlangeThickness;
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
        setContentPane(panel);
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
        final ButtonGroup checkBoxGroup25B1 = new ButtonGroup();
        checkBoxGroup25B1.add(checkBox25B1);
        setSize(950, 700);
        label1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().
                getImage(getClass().getResource("/withoutRibs.png"))));
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
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTableRwf();
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTableRwz();
            }
        });
        checkBox25B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldHeightBeam.setText("24.8");
                textFieldFlangeWidth.setText("12.4");
                textFieldtFlangeThickness.setText("0.8");
                textFieldWallThickness.setText("0.5");
                textFieldRadius.setText("1.2");
            }
        });
        buttonResetSection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldHeightBeam.setText("");
                textFieldFlangeWidth.setText("");
                textFieldtFlangeThickness.setText("");
                textFieldWallThickness.setText("");
                textFieldRadius.setText("");
                checkBoxGroup25B1.clearSelection();
            }
        });
        buttonResetWeld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldIx.setText("");
                textFieldIy.setText("");
                textFieldWx.setText("");
                textFieldWy.setText("");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldIx.setText("");
                textFieldIy.setText("");
                textFieldWx.setText("");
                textFieldWy.setText("");
            }
        });
        buttonIW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MomentInertiaWall momentInertiaWall = new MomentInertiaWall();
                double heightBeam = Double.parseDouble(textFieldHeightBeam.getText());
                double flangeThickness = Double.parseDouble(textFieldtFlangeThickness.getText());
                double wallThickness = Double.parseDouble(textFieldWallThickness.getText());
                double sideW = Double.parseDouble(textFieldWallKf.getText());
                double rwf = Double.parseDouble(labelRwf.getText());
                double rwz = Double.parseDouble(labelRwz.getText());
                double radius = Double.parseDouble(textFieldRadius.getText());
                double heightWeldX = momentInertiaWall.heightWeldX(heightBeam, flangeThickness, radius);
                selectSectionCalc(rwf, rwz);
                double heightWeldY = momentInertiaWall.heightWeldY(sideW, factor);
                /**
                 * Выводим factor
                 */
                System.out.println(factor);
                double ix = momentInertiaWall.momentInertiaWallX(heightBeam,
                        flangeThickness, sideW, factor, radius);
                double iy = momentInertiaWall.momentInertiaWallY(heightBeam,
                        flangeThickness, sideW, factor, radius, wallThickness);
                textFieldIx.setText(Double.toString(ix));
                textFieldIy.setText(Double.toString(iy));
                MomentResistanceWall momentResistanceWall = new MomentResistanceWall();
                double wx = momentResistanceWall.momentResistanceWallX(ix, heightWeldX);
                double wy = momentResistanceWall.momentResistanceWallY(iy, heightWeldY, wallThickness);
                textFieldWx.setText(Double.toString(wx));
                textFieldWy.setText(Double.toString(wy));
            }
        });
        checkBox1And15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factorZ = 1.15;
            }
        });
        checkBox1And05.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factorZ = 1.05;
            }
        });
        checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factorZ = 1;
            }
        });
        checkBox1And1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factorF = 1.1;
            }
        });
        checkBox0And9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factorF = 0.9;
            }
        });
        checkBox0And8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factorF = 0.8;
            }
        });
        checkBox0And7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factorF = 0.7;
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Weld::new);
    }
}
