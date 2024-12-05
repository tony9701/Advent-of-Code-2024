package Day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FirstProblem {
    public static void main(String[] args) throws IOException {
        String regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)+";

        Pattern pattern = Pattern.compile(regex);

        BufferedReader reader = new BufferedReader(new FileReader("src/Day03/input.txt"));

        StringBuilder input = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            input.append(line);
            input.append(System.lineSeparator());
        }

        Matcher matcher = pattern.matcher(input);


        Map<Integer, Integer> matches = new HashMap<>();
        List<Integer> listTest = new ArrayList<>();

        while (matcher.find()) {
            matches.put(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
            listTest.add(Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2)));
        }

        long listCount = listTest.stream().mapToLong(l -> l).sum();
        long listCount2 = 0;

        for (Integer i : listTest) {
            listCount2 += i;
        }

        long count = matches.entrySet().stream().mapToLong(e -> (long) e.getKey() * e.getValue()).sum();

        System.out.println("\n" + count);
        System.out.println("\n" + listCount);
        System.out.println("\n" + listCount2);

    }
}
