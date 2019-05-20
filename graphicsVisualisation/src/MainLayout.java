import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainLayout extends JFrame {

    private String function = "";
    private double accuracy;
    private double x1;
    private double x2;
    private double y1;
    private double y2;
    private TextField functionInput;
    private TextField accuracyInput;
    private TextField inputX1;
    private TextField inputX2;
    private TextField inputY1;
    private TextField inputY2;
    private JFrame FRAME;
    private JPanel PANEL;
    private JLabel errorLabel;
    private JLabel resultMinLabel;
    private JLabel resultMaxLabel;
    private JLabel resultMinTechLabel;
    private JLabel resultMaxTechLabel;
    private JLabel resultTechLabel;
    private JButton startButton;
    private JButton loadSavesButton;
    private JButton refreshButton;
    private JRadioButton chooseGoldenSection;
    private JRadioButton chooseEvenSearch;
    private JRadioButton chooseDihotomy;

    private MainLayout() {
        ButtonGroup group = new ButtonGroup();
        FRAME = new JFrame();
        FRAME.setDefaultCloseOperation(EXIT_ON_CLOSE);
        PANEL = new JPanel();
        FRAME.add(PANEL);
        PANEL.setBackground(Color.white);
        PANEL.setLayout(null);
        startButton = new JButton("Начать поиск");
        loadSavesButton = new JButton("Загрузить последний ввод");
        refreshButton = new JButton("Очистить поля");
        chooseGoldenSection = new JRadioButton("Метод золотого сечения");
        chooseEvenSearch = new JRadioButton("Метод равномерного поиска");
        chooseDihotomy = new JRadioButton("Метод дихотомии");
        FRAME.setSize(300, 690);
        FRAME.setTitle("Поиск экстремумов");
        functionInput = new TextField();
        accuracyInput = new TextField();
        inputX1 = new TextField("", 40);
        inputX2 = new TextField("", 40);
        inputY1 = new TextField("", 40);
        inputY2 = new TextField("", 40);

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
        inputY2.setLocation(180, 235);

        inputY1.setSize(50, 20);
        inputY2.setSize(50, 20);

        PANEL.add(inputY1);
        PANEL.add(inputY2);
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

        resultTechLabel = new JLabel("Ваш результат:");
        resultMinLabel = new JLabel();
        resultMaxLabel = new JLabel();
        resultMinTechLabel = new JLabel("Точка минимума:");
        resultMaxTechLabel = new JLabel("Точка максимума:");


        resultMinTechLabel.setLocation(10, 570);
        resultMinTechLabel.setSize(150, 30);
        resultMinTechLabel.setVisible(true);
        PANEL.add(resultMinTechLabel);

        resultMaxTechLabel.setLocation(10, 605);
        resultMaxTechLabel.setSize(150, 30);
        resultMaxTechLabel.setVisible(true);
        PANEL.add(resultMaxTechLabel);

        resultTechLabel.setLocation(10, 535);
        resultTechLabel.setSize(140, 20);
        resultTechLabel.setVisible(true);
        PANEL.add(resultTechLabel);

        resultMinLabel.setLocation(200, 570);
        resultMinLabel.setSize(100, 30);
        resultMinLabel.setVisible(true);
        PANEL.add(resultMinLabel);

        resultMaxLabel.setLocation(200, 605);
        resultMaxLabel.setSize(100, 30);
        resultMaxLabel.setVisible(true);
        PANEL.add(resultMaxLabel);

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

        loadSavesButton.setLocation(5, 455);
        loadSavesButton.setSize(290,  30);
        PANEL.add(loadSavesButton);

        refreshButton.setLocation(5, 490);
        refreshButton.setSize(290, 30);
        PANEL.add(refreshButton);

        chooseGoldenSection.setLocation(5, 305);
        chooseGoldenSection.setSize(200, 25);
        chooseGoldenSection.setBackground(Color.white);
        PANEL.add(chooseGoldenSection);

        chooseEvenSearch.setLocation(5, 335);
        chooseEvenSearch.setSize(230, 25);
        chooseEvenSearch.setBackground(Color.white);
        PANEL.add(chooseEvenSearch);

        chooseDihotomy.setLocation(5, 365);
        chooseDihotomy.setSize(200, 25);
        chooseDihotomy.setBackground(Color.white);
        PANEL.add(chooseDihotomy);

        errorLabel = new JLabel("");
        errorLabel.setLocation(10, 210);
        errorLabel.setSize(170, 20);
        //PANEL.add(errorLabel);

        FRAME.setVisible(true);
        FRAME.setResizable(false);

        group.add(chooseDihotomy);
        group.add(chooseGoldenSection);
        group.add(chooseEvenSearch);

        refreshButton.addActionListener(e -> {
            functionInput.setText("");
            accuracyInput.setText("");
            inputX1.setText("");
            inputX2.setText("");
            inputY1.setText("");
            inputY2.setText("");
            group.clearSelection();
        });

        loadSavesButton.addActionListener(e -> {
            try {
                String filePathRaw = FindAutoSaveFile.find("FEXT_autosave.txt", new File("").getAbsolutePath()).toString();
                String filePath = filePathRaw.substring(1, filePathRaw.length() - 1);
                File autosave = new File(filePath);
                final Scanner reader = new Scanner(new FileReader(autosave));
                inputX1.setText(reader.nextLine().split(": ")[1]);
                inputY1.setText(reader.nextLine().split(": ")[1]);
                inputX2.setText(reader.nextLine().split(": ")[1]);
                inputY2.setText(reader.nextLine().split(": ")[1]);
                functionInput.setText(reader.nextLine().split(": ")[1]);
                accuracyInput.setText(reader.nextLine().split(": ")[1]);
                String temp = reader.nextLine();
                if (temp.contains("even")) {
                    chooseEvenSearch.setSelected(true);
                } else if(temp.contains("golden")) {
                    chooseGoldenSection.setSelected(true);
                } else chooseDihotomy.setSelected(true);
            } catch (IOException err) {
                err.printStackTrace();
            }
        });

        startButton.addActionListener(e -> {
            function = functionInput.getText();
            accuracy = Double.parseDouble(accuracyInput.getText());
            if (!function.equals("")) {
                set("");
                x1 = Double.parseDouble(inputX1.getText());
                x2 = Double.parseDouble(inputX2.getText());
                try {
                    if (x1 < x2) {
                        set("");
                        y1 = Double.parseDouble(inputY1.getText());
                        y2 = Double.parseDouble(inputY2.getText());
                        try {
                            if (y1 < y2) {
                                set("");
                                set("УРА!");
                                FunctionInterpreter f = new FunctionInterpreter(function);
                                try {
                                    AutoSaver.inputFunctionSaver = function;
                                    AutoSaver.inputAccuracySaver = accuracy;
                                    AutoSaver.inputX1Saver = x1;
                                    AutoSaver.inputX2Saver = x2;
                                    AutoSaver.inputY1Saver = y1;
                                    AutoSaver.inputY2Saver = y2;
                                    double resultMinX = 0;
                                    double resultMinY = 0;
                                    double resultMaxX = 0;
                                    double resultMaxY = 0;

                                    String resultMinPoint;
                                    String resultMaxPoint;
                                    if (chooseGoldenSection.isSelected()) {
                                        AutoSaver.methodSaver = "golden section search";
                                        resultMinX = (double) Math.round(new GoldenSectionSearch(f).findMin(x1, x2, accuracy) * 100) / 100;
                                        resultMinY = (double) Math.round(f.alg(resultMinX) * 100) / 100;
                                        resultMinPoint = "(" + resultMinX + ", " + resultMinY + ")";
                                        resultMinLabel.setText(resultMinPoint);
                                        AutoSaver.resultMin = resultMinPoint;
                                        resultMaxX = (double) Math.round(new GoldenSectionSearch(f).findMax(x1, x2, accuracy) * 100) / 100;
                                        resultMaxY = (double) Math.round(f.alg(resultMaxX) * 100) / 100;
                                        resultMaxPoint = "(" + resultMaxX + ", " + resultMaxY + ")";
                                        resultMaxLabel.setText(resultMaxPoint);
                                        AutoSaver.resultMax = resultMaxPoint;

                                    }
                                    if (chooseDihotomy.isSelected()) {
                                        AutoSaver.methodSaver = "dihotomy search";
                                        resultMinX = (double) Math.round(new DihotomySearch(f).findMin(x1, x2, accuracy) * 100) / 100;
                                        resultMinY = (double) Math.round(f.alg(resultMinX) * 100) / 100;
                                        resultMinPoint = "(" + resultMinX + ", " + resultMinY + ")";
                                        resultMinLabel.setText(resultMinPoint);
                                        AutoSaver.resultMin = resultMinPoint;
                                        resultMaxX = (double) Math.round(new DihotomySearch(f).findMax(x1, x2, accuracy) * 100) / 100;
                                        resultMaxY = (double) Math.round(f.alg(resultMaxX) * 100) / 100;
                                        resultMaxPoint = "(" + resultMaxX + ", " + resultMaxY + ")";
                                        resultMaxLabel.setText(resultMaxPoint);
                                        AutoSaver.resultMax = resultMaxPoint;
                                    }
                                    if (chooseEvenSearch.isSelected()) {
                                        AutoSaver.methodSaver = "even search";
                                        resultMinX = (double) Math.round(new EvenSearch(f).findMin(x1, x2, accuracy) * 100) / 100;
                                        resultMinY = (double) Math.round(f.alg(resultMinX) * 100) / 100;
                                        resultMinPoint = "(" + resultMinX + ", " + resultMinY + ")";
                                        resultMinLabel.setText(resultMinPoint);
                                        AutoSaver.resultMin = resultMinPoint;
                                        resultMaxX = (double) Math.round(new EvenSearch(f).findMax(x1, x2, accuracy) * 100) / 100;
                                        resultMaxY = (double) Math.round(f.alg(resultMaxX) * 100) / 100;
                                        resultMaxPoint = "(" + resultMaxX + ", " + resultMaxY + ")";
                                        resultMaxLabel.setText(resultMaxPoint);
                                        AutoSaver.resultMax = resultMaxPoint;
                                    }
                                    AutoSaver.save();
                                    GraphicsPainter p = new GraphicsPainter(x1, x2, y1, y2, function, resultMinX, resultMinY, resultMaxX, resultMaxY);

                                } catch (Exception w3) {
                                    set("UNABLE TO PAINT GRAPHIC");
                                }
                            } else {
                                set("INCORRECT INTERVAL: Y");
                            }
                        } catch (Exception w1) {
                            set("INCORRECT COORDINATES");
                        }
                    } else {
                        set("INCORRECT INTERVAL: X");
                    }

                } catch (Exception w2) {
                    set("INCORRECT COORDINATES");
                }
            } else {
                set("Введите функцию");
            }

        });
    }

    private void set(String s) {
        errorLabel.setText(s);
    }

    public static void main(String[] args) throws IOException {
        new MainLayout();
    }
}