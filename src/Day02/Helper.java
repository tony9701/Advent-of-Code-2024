package Day02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Helper {

    public static boolean isSafe(List<Integer> numbers) {

        if (isDecreasing(numbers)) {
            return true;
        }

        return isIncreasing(numbers);

    }

    public static boolean isIncreasing(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            int diff = numbers.get(i) - numbers.get(i + 1);

            if (diff < 1 || diff > 3) {
                return false;
            }
        }

        return true;
    }


    public static boolean isDecreasing(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            int diff = numbers.get(i + 1) - numbers.get(i);

            if (diff < 1 || diff > 3) {
                return false;
            }
        }

        return true;
    }

    public static void listCreator(List<List<Integer>> numbersList) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Paste your input and hit 'Enter' 2 times!");

        while (sc.hasNextLine()) {
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                break;
            }

            List<Integer> numbers = Arrays.stream(input.split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            numbersList.add(numbers);
        }
    }
}
