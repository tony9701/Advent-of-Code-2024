package Day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Helper {

    public static boolean isSafe(List<Integer> numbers) {

        if (isDecreasingV2(numbers)) {
            return true;
        }

        return isIncreasingV2(numbers);

    }

    public static boolean isSafe(List<Integer> numbers, boolean isProblemTwo) {

        if (isDecreasing(numbers, true)) {
            return true;
        }

        return isIncreasing(numbers, true);

    }

    public static boolean isIncreasingV2(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            int diff = numbers.get(i) - numbers.get(i + 1);

            if (diff < 1 || diff > 3) {
                return false;
            }
        }

        return true;
    }


    public static boolean isDecreasingV2(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            int diff = numbers.get(i + 1) - numbers.get(i);

            if (diff < 1 || diff > 3) {
                return false;
            }
        }

        return true;
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

    public static boolean isIncreasing(List<Integer> numbers, boolean isRemovingLevel) {
        int removedLevelsFlag = 0;
        List<Integer> numberCopy = new ArrayList<>(numbers);

        for (int i = 0; i < numberCopy.size() - 1; i++) {
            int currentNum = numberCopy.get(i);
            int nextNum = numberCopy.get(i + 1);

            //check if the difference between numbers are more than 3 or if the nums are equal
            if (diffCheckerNotValid(currentNum, nextNum)) {

                if (removedLevelsFlag == 0) {
                    numberCopy.remove(i + 1);
                    removedLevelsFlag++;
                    i--;
                    continue;
                }

                return false;
            }


            //check if the number is increasing (the next num is bigger)
            if (currentNum > nextNum) {

                //check if level is already removed. If not remove it and restart the loop.
                if (removedLevelsFlag == 0) {
                    numberCopy.remove(i + 1);
                    removedLevelsFlag++;
                    i--;
                    continue;
                }

                return false;
            }


        }

        return true;
    }



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

    public static boolean isDecreasing(List<Integer> numbers, boolean isRemovingLevel) {
        int removedLevelsFlag = 0;
        List<Integer> numberCopy = new ArrayList<>(numbers);

        for (int i = 0; i < numberCopy.size() - 1; i++) {
            int currentNum = numberCopy.get(i);
            int nextNum = numberCopy.get(i + 1);

            //check if the difference between numbers are more than 3 or if the nums are equal
            if (diffCheckerNotValid(currentNum, nextNum)) {
                if (removedLevelsFlag == 0) {
                    numberCopy.remove(i + 1);
                    removedLevelsFlag++;
                    i--;
                    continue;
                }

                return false;
            }

            //check if the number is decreasing (the next num is lower)
            if (currentNum < nextNum) {
                if (removedLevelsFlag == 0) {
                    numberCopy.remove(i + 1);
                    removedLevelsFlag++;
                    i--;
                    continue;
                }

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
