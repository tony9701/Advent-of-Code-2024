package Day02;

import java.util.*;

public class FirstProblem {
    public static void main(String[] args) {

        List<int[]> numbersList = new ArrayList<>();

        //fill the list from console
        listCreator(numbersList);

        int safe = 0;

        for (int[] numbers : numbersList) {
            //check if the numbers are safe
            if (isSafe(numbers)) {
                safe++;
            }
        }

        System.out.println(safe);
    }

    private static boolean isSafe(int[] numbers) {


        if (isDecreasing(numbers)) {
            return true;
        }

        return isIncreasing(numbers);

    }

    private static boolean isIncreasing(int[] numbers) {
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

    private static boolean isDecreasing(int[] numbers) {
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

    private static boolean diffCheckerNotValid(int currentNum, int nextNum) {
        return Math.abs(currentNum - nextNum) > 3 || nextNum == currentNum;
    }

    private static void listCreator(List<int[]> numbersList) {
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
