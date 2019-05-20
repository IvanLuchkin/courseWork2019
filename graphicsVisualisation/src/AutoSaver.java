import java.io.FileWriter;
import java.io.IOException;

class AutoSaver {
    static double inputX1Saver;
    static double inputX2Saver;
    static double inputY1Saver;
    static double inputY2Saver;
    static String inputFunctionSaver;
    static double inputAccuracySaver;
    static String methodSaver;
    static String resultMin;
    static String resultMax;

    private static final String savePath = "FEXT_autosave.txt";

    static void save() {
        try {
            FileWriter writer = new FileWriter(savePath);
            writer.write("Last 'X1' input: " + inputX1Saver + '\n');
            writer.write("Last 'Y1' input: " + inputY1Saver + '\n');
            writer.write("Last 'X2' input: " + inputX2Saver + '\n');
            writer.write("Last 'Y2' input: " + inputY2Saver + '\n');
            writer.write("Last function input: " + inputFunctionSaver + '\n');
            writer.write("Last accuracy input: " + inputAccuracySaver + '\n');
            writer.write("Last method chosen: " + methodSaver + '\n');
            writer.write("Last minimum point result: " + resultMin + '\n');
            writer.write("Last maximum point result: " + resultMax);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
