package ss16_text_file.practice.find_max_write_out_file.model;

import java.util.List;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("D:\\codegym\\module2\\vanphuc\\src\\file\\test.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("D:\\codegym\\module2\\vanphuc\\src\\file\\result.txt", maxValue);
    }
}
