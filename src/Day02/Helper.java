package Day02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Helper {
    public static boolean isSafe(int[] numbers) {


        if (isDecreasing(numbers)) {
            return true;
        }

        return isIncreasing(numbers);

    }

    public static boolean isIncreasing(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int currentNum = numbers[i];
            int nextNum = numbers[i + 1];

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

    public static boolean isDecreasing(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int currentNum = numbers[i];
            int nextNum = numbers[i + 1];

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

    public static void listCreator(List<int[]> numbersList) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Paste your input and hit 'Enter' 2 times!");

        while (sc.hasNextLine()) {
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                break;
            }

            int[] numbers = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            numbersList.add(numbers);
        }
    }
}
