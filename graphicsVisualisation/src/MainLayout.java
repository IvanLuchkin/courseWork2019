import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainLayout extends JFrame {

    String function = "";
    double x1;
    double x2;
    double y1;
    double y2;
    TextField functionInput;
    TextField accuracyInput;
    TextField inputX1;
    TextField inputX2;
    TextField inputY1;
    TextField inoutY2;
    JFrame FRAME;
    JPanel PANEL;
    JLabel errorLabel;
    JButton startButton;
    JRadioButton chooseGoldenSection;
    JRadioButton chooseSearch;
    JRadioButton chooseDihotomy;

    MainLayout() {
        FRAME = new JFrame();
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PANEL = new JPanel();
        FRAME.add(PANEL);
        PANEL.setBackground(Color.white);
        PANEL.setLayout(null);
        startButton = new JButton("Начать поиск");
        chooseGoldenSection = new JRadioButton("Метод золотого сечения");
        chooseSearch = new JRadioButton("Метод равномерного поиска");
        chooseDihotomy = new JRadioButton("Метод дихотомии");
        FRAME.setSize(300, 800);
        FRAME.setTitle("Поиск экстремумов");
        functionInput = new TextField();
        accuracyInput = new TextField();
        inputX1 = new TextField("", 40);
        inputX2 = new TextField("", 40);
        inputY1 = new TextField("", 40);
        inoutY2 = new TextField("", 40);

        functionInput.setLocation(60, 60);
        functionInput.setSize(200, 20);

        accuracyInput.setLocation(60, 125);
        accuracyInput.setSize(200, 20);

        inputX1.setLocation(60, 190);
        inputX2.setLocation(180, 190);

        inputX1.setSize(50, 20);
        inputX2.setSize(50, 20);

        PANEL.add(inputX1);
        PANEL.add(inputX2);

        inputY1.setLocation(60, 235);
        inoutY2.setLocation(180, 235);

        inputY1.setSize(50, 20);
        inoutY2.setSize(50, 20);

        PANEL.add(inputY1);
        PANEL.add(inoutY2);
        PANEL.add(functionInput);
        PANEL.add(accuracyInput);


        JLabel finputTechLabel1 = new JLabel("Введите функцию:");
        JLabel finputTechLabel2 = new JLabel("F(x) = ");
        JLabel accuracyTechLabel1 = new JLabel("Введите точность вычислений:");
        JLabel accuracyTechLabel2 = new JLabel("e = ");
        JLabel chunkTechLabel = new JLabel("Укажите концы промежутка:");
        JLabel methodTechLabel = new JLabel("Выберите метод поиска:");
        JLabel labelX1 = new JLabel("X от:");
        JLabel labelX2 = new JLabel("до:");
        JLabel labelY1 = new JLabel("Y от:");
        JLabel labelY2 = new JLabel("до:");
        JLabel resultLabel = new JLabel("");

        resultLabel.setLocation(400, 380);
        resultLabel.setSize(100, 30);
        PANEL.add(resultLabel);

        finputTechLabel1.setLocation(10, 20);
        finputTechLabel1.setSize(140, 20);
        PANEL.add(finputTechLabel1);

        finputTechLabel2.setLocation(10, 60);
        finputTechLabel2.setSize(60, 20);
        PANEL.add(finputTechLabel2);

        accuracyTechLabel1.setLocation(10, 95);
        accuracyTechLabel1.setSize(230, 20);
        PANEL.add(accuracyTechLabel1);

        accuracyTechLabel2.setLocation(15, 125);
        accuracyTechLabel2.setSize(50, 20);
        PANEL.add(accuracyTechLabel2);

        chunkTechLabel.setLocation(10, 155);
        chunkTechLabel.setSize(260, 20);
        PANEL.add(chunkTechLabel);

        methodTechLabel.setLocation(10, 270);
        methodTechLabel.setSize(270, 20);
        PANEL.add(methodTechLabel);

        labelX1.setLocation(14, 190);
        labelX1.setSize(40, 20);
        PANEL.add(labelX1);

        labelX2.setLocation(150, 190);
        labelX2.setSize(40, 20);
        PANEL.add(labelX2);

        labelY1.setLocation(14, 235);
        labelY1.setSize(40, 20);
        PANEL.add(labelY1);

        labelY2.setLocation(150, 235);
        labelY2.setSize(40, 20);
        PANEL.add(labelY2);

        startButton.setLocation(5, 400);
        startButton.setSize(290, 50);
        PANEL.add(startButton);

        chooseGoldenSection.setLocation(5, 305);
        chooseGoldenSection.setSize(200, 25);
        chooseGoldenSection.setBackground(Color.white);
        PANEL.add(chooseGoldenSection);

        chooseSearch.setLocation(5, 335);
        chooseSearch.setSize(230, 25);
        chooseSearch.setBackground(Color.white);
        PANEL.add(chooseSearch);

        chooseDihotomy.setLocation(5, 365);
        chooseDihotomy.setSize(200, 25);
        chooseDihotomy.setBackground(Color.white);
        PANEL.add(chooseDihotomy);

        errorLabel = new JLabel("");
        errorLabel.setLocation(10, 210);
        errorLabel.setSize(170, 20);
        PANEL.add(errorLabel);

        FRAME.setVisible(true);
        FRAME.setResizable(false);


        startButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                function = functionInput.getText();
                if (!function.equals("")) {
                    set("");
                    x1 = Double.parseDouble(inputX1.getText());
                    x2 = Double.parseDouble(inputX2.getText());
                    try {
                        if (x1 < x2) {
                            set("");
                            y1 = Double.parseDouble(inputY1.getText());
                            y2 = Double.parseDouble(inoutY2.getText());
                            try {
                                if (y1 < y2) {
                                    set("");
                                    set("УРА!");
                                    try {
                                        if (chooseGoldenSection.isEnabled()) {
                                            resultLabel.setText(Double.toString(new GoldenSection(new CoordinatesCalculator(function)).findMax(x1, x2, 0.000001)));
                                        }
                                        GraphicsPainter p = new GraphicsPainter(x1, x2, y1, y2, function);
                                    } catch (Exception w3) {
                                        set("класс GraphicsPainter - говно!");
                                        System.out.println(w3);
                                    }
                                } else {
                                    set("некорректный интервал Y");
                                }
                            } catch (Exception w1) {
                                set("некорректные координаты");
                            }
                        } else {
                            set("некорректный интервал X");
                        }

                    } catch (Exception w2) {
                        set("некорректные координаты");
                    }
                } else {
                    set("Введите функцию");
                }

            }
        });
    }

    public void set(String s) {
        errorLabel.setText(s);
    }

    public static void main(String args[]) {
        new MainLayout();
    }
}