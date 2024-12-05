package Day03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondProblem {
    public static void main(String[] args) throws IOException {
        String regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)|(do\\(\\))|(don't\\(\\))";

        Pattern pattern = Pattern.compile(regex);

        BufferedReader reader = new BufferedReader(new FileReader("src/Day03/inputData.txt"));

        StringBuilder input = new StringBuilder();

        String line;

        while ((line = reader.readLine()) != null) {
            input.append(line);
            input.append(System.lineSeparator());
        }

        Matcher matcher = pattern.matcher(input);

        List<Integer> numbers = new ArrayList<>();
        boolean commandDo = true;

        while (matcher.find()) {
            String group = matcher.group();

            if (matcher.group().contains("don't")) {
                commandDo = false;
            } else if (matcher.group().contains("do")) {
                commandDo = true;
            } else {
                if (commandDo) {
                    numbers.add(Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2)));
                }
            }
        }

        long result = numbers.stream().mapToLong(number -> number).sum();

        System.out.println(result);
    }
}
