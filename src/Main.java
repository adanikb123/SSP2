import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            MyFileReader myFileReader = new MyFileReader();
            myFileReader.writeToInputFileRandomValue("возрастание");
            myFileReader.readFromInputFile();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
