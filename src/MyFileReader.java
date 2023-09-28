import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MyFileReader {
    private static final String INPUT_PATH = "input.txt";

    private static final String OUTPUT_PATH = "output.txt";

    private static final int MAX_SIZE = 100_000;

    private static final int MAX_VALUE = 1000;

    private BufferedReader bufferedReader;

    private BufferedWriter bufferedWriter;

    private List<Integer> values;

    public MyFileReader() throws IOException {
        values = new ArrayList<>();
        this.bufferedReader = new BufferedReader(new FileReader(INPUT_PATH));
        this.bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_PATH));
    }

    public void writeToInputFileRandomValue(String sortType) throws IOException {
        FileWriter fileWriter = new FileWriter(INPUT_PATH);
        Random random = new Random();
        int inputSize = random.nextInt(MAX_SIZE);

        fileWriter.write(sortType);
        fileWriter.append("\n");

        fileWriter.write(inputSize + "");
        fileWriter.append("\n");

        for (int i = 0; i < inputSize; i++) {
            fileWriter.write(random.nextInt(MAX_VALUE) + "");
            fileWriter.append("\n");
        }
        fileWriter.flush();
    }

    public void readFromInputFile() throws IOException {
        String sortType = bufferedReader.readLine();
        int inputSize = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < inputSize; i++) {
            values.add(Integer.parseInt(bufferedReader.readLine()));
        }
        if (sortType.equalsIgnoreCase("убывание")) {
            decreaseSort();
        } else if (sortType.equalsIgnoreCase("возрастание")) {
            increaseSort();
        } else {
            System.out.println("Неизвестный тип сортировки");
        }
    }

    public void increaseSort() throws IOException {
        Collections.sort(values);
        System.out.println(values);
        writeToFileValues();
    }

    public void decreaseSort() throws IOException {
        Collections.sort(values);
        Collections.reverse(values);
        System.out.println(values);
        writeToFileValues();
    }

    public void writeToFileValues() throws IOException {
        for(int i = 0; i < values.size();i++){
            bufferedWriter.write(values.get(i)+"\n");
            bufferedWriter.flush();
        }
    }
}
