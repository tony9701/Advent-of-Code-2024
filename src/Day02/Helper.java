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
            int currentNum = numbers.get(i);
            int nextNum = numbers.get(i + 1);

            //check if the difference between numbers are more than 3 or if the nums are equal
            if (diffCheckerNotValid(currentNum, nextNum)) {
                return false;
            }

            //check if the number is increasing (the next num is bigger)
            if (currentNum > nextNum) {
                return false;
            }

        }

        return true;
    }

    // 8 6 4 4 1
    public static boolean isDecreasing(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            int currentNum = numbers.get(i);
            int nextNum = numbers.get(i + 1);

            //check if the difference between numbers are more than 3 or if the nums are equal
            if (diffCheckerNotValid(currentNum, nextNum)) {
                return false;
            }

            //check if the number is decreasing (the next num is lower)
            if (currentNum < nextNum) {
                return false;
            }

        }

        return true;
    }

    public static boolean diffCheckerNotValid(int currentNum, int nextNum) {
        return Math.abs(currentNum - nextNum) > 3 || nextNum == currentNum;
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
